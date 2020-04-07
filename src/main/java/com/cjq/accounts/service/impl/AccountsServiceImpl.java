package com.cjq.accounts.service.impl;

import com.cjq.accounts.dao.AccountsMapper;
import com.cjq.accounts.dao.MyUserMapper;
import com.cjq.accounts.dao.OtherAccountsMapper;
import com.cjq.accounts.dto.*;
import com.cjq.accounts.entity.*;
import com.cjq.accounts.service.AccountsService;
import com.cjq.publics.dto.ResultDto;
import com.cjq.publics.dto.ReturnCode;
import com.cjq.publics.entity.Page;
import com.cjq.publics.entity.Pagination;
import com.cjq.publics.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class AccountsServiceImpl implements AccountsService {

	@Resource
	private AccountsMapper accountsMapper;

	@Resource
	private OtherAccountsMapper otherAccountsMapper;

	@Resource
	private MyUserMapper myUserMapper;

	/**
	 * @function：计算一天的消费总额
	 * @author：cjq
	 * @date：2014-1-7下午3:32:18
	 */
	@Override
	public SumGson getSum(AccountsDto dto) {
		//一天伙食费
		float foodSum = dto.getBreakfast() + dto.getLunch() + dto.getSupper();
		
		String otherStr = "";//其他消费拼接字符串
		float otherSum = 0.0f;//其他消费总额
		/*if(dto.getOther() != null && dto.getOther().length >0) {
			String[] others = dto.getOther();
			float[] oprices = dto.getOprice();
			for(int i=0;i<others.length;i++) {
				otherStr += others[i] + ":" + oprices[i] + ";";
				otherSum += oprices[i];
			}
		}*/
		System.out.println("其他消费总额：" + otherSum);
		System.out.println("其他：" + otherStr);
		
		//一天总消费
		float sum = dto.getBreakfast() + dto.getLunch() + dto.getSupper() + dto.getEgg() + dto.getFruit() + dto.getDrink() +
				dto.getFood() + dto.getRice() + dto.getCake() + dto.getSupermarket() + dto.getTraffic() + dto.getSoy() + 
				dto.getGass() + dto.getPhone() + dto.getRent() + dto.getFootball() + otherSum;
		System.out.println("总金额：" + sum);
		
		//封装返回的json对象
		SumGson sg = new SumGson();
		sg.setFoodSum(foodSum);
		sg.setTotal(sum);
		sg.setOtherSum(otherSum);

		return sg;
	}

	/**
	 * @function：添加一天的消费记录进数据库
	 * @author：cjq
	 * @date：2014-1-7下午3:32:41
	 */
	@Override
	public ResultDto add(AccountsDto dto) {
		Accounts accounts = new Accounts();
		BeanUtils.copyProperties(dto,accounts);
		accounts.setAddDate(DateUtil.converDate2(dto.getAddDate()));
		int row = accountsMapper.insertSelective(accounts);
		if(row > 0) {
			int id = accounts.getId();
			if(dto.getOtherAccountsList() != null && !dto.getOtherAccountsList().isEmpty()) {
				for(OtherAccounts other : dto.getOtherAccountsList()) {
					other.setAccountsId(id);
					otherAccountsMapper.insertSelective(other);
				}
			}
			return new ResultDto(ReturnCode.SUCCESS, Integer.toString(id));
		}
		return new ResultDto(ReturnCode.BUSIN_ERROR, "添加失败");
	}

	/**
	 * @function：判断是否存在相同的记录
	 * @author：cjq
	 * @date：2014-1-7下午3:33:00
	 */
	@Override
	public ResultDto validateExist(String flag, String addDate) {
		ResultDto resultDto = new ResultDto(ReturnCode.DATA_ERROR);
		AccountsExample example = new AccountsExample();
		AccountsExample.Criteria criteria = example.createCriteria();
		criteria.andFlagEqualTo(flag);
		criteria.andAddDateEqualTo(DateUtil.converDate2(addDate));
		List<Accounts> list = accountsMapper.selectByExample(example);
		if(list != null && !list.isEmpty()) {
			resultDto.setStatus(ReturnCode.SUCCESS);
            resultDto.setObj(list.get(0));
		}
		return resultDto;
	}

	/**
	 * @function：条件查询每天消费记录
	 * @author：cjq
	 * @date：2014-1-7下午3:15:25
	 */
	@Override
	public Pagination<AccountsDto> queryBills(QueryDto dto) {
		AccountsTotalExample totalExample = new AccountsTotalExample();

		AccountsExample example = new AccountsExample();
		AccountsExample.Criteria criteria = example.createCriteria();
		if(StringUtils.hasText(dto.getFlag())) {
			criteria.andFlagEqualTo(dto.getFlag());
		}
		if(StringUtils.hasText(dto.getStartDate())) {
			criteria.andAddDateGreaterThanOrEqualTo(DateUtil.converDate(dto.getStartDate() + " 00:00:00:000"));
		}
		if(StringUtils.hasText(dto.getEndDate())) {
			criteria.andAddDateLessThanOrEqualTo(DateUtil.converDate(dto.getEndDate() + " 23:59:59:998"));
		}

		example.setOrderByClause("add_date desc,flag desc");
		totalExample.setAccountsExample(example);

		OtherAccountsExample otherAccountsExample = new OtherAccountsExample();
		OtherAccountsExample.Criteria oCriteria = otherAccountsExample.createCriteria();
		if(StringUtils.hasText(dto.getKeyWord())) {
			oCriteria.andOtherLike("%" + dto.getKeyWord() + "%");
		}
		totalExample.setOtherAccountsExample(otherAccountsExample);
		int count = accountsMapper.countByTotalExample(totalExample);
		totalExample.setPage(new Page(dto.getCurrentPage(), dto.getPageSize(), count));
		List<AccountsDto> list = accountsMapper.selectDtoByTotalExample(totalExample);
		Pagination<AccountsDto> pg = new Pagination<>();
		pg.setData(list);
		pg.setCurrentPage(totalExample.getPage().getCurrentPage());
		pg.setPageSize(totalExample.getPage().getPageSize());
		pg.setTotalCount(count);
		pg.setTotalPage(totalExample.getPage().getTotalPage());

		return pg;
	}

	@Override
	public AccountsDto queryDtoById(String id) {
		AccountsDto dto = null;
		try{
			dto = accountsMapper.selectDtoByPrimaryKey(Integer.parseInt(id));
		} catch (Exception e) {
			dto = null;
		}
		return dto;
	}

	@Override
	public ResultDto updateAccounts(AccountsDto dto) {
		Accounts accounts = new Accounts();
		BeanUtils.copyProperties(dto, accounts);
		accounts.setAddDate(DateUtil.converDate2(dto.getAddDate()));
		int row = accountsMapper.updateByPrimaryKeySelective(accounts);
		if(row > 0) {
			OtherAccountsExample example = new OtherAccountsExample();
			OtherAccountsExample.Criteria criteria = example.createCriteria();
			criteria.andAccountsIdEqualTo(dto.getId());
			otherAccountsMapper.deleteByExample(example);

			if(dto.getOtherAccountsList() != null && !dto.getOtherAccountsList().isEmpty()) {
				for(OtherAccounts other : dto.getOtherAccountsList()) {
					other.setAccountsId(dto.getId());
					otherAccountsMapper.insertSelective(other);
				}
			}
			return new ResultDto(ReturnCode.SUCCESS);
		}
		return new ResultDto(ReturnCode.DATA_ERROR);
	}

	@Override
	public ResultDto updateInitOther(QueryDto dto) {
		AccountsExample example = new AccountsExample();
		AccountsExample.Criteria criteria = example.createCriteria();
		if(StringUtils.hasText(dto.getFlag())) {
			criteria.andFlagEqualTo(dto.getFlag());
		}
		if(StringUtils.hasText(dto.getStartDate())) {
			criteria.andAddDateGreaterThanOrEqualTo(DateUtil.converDate(dto.getStartDate() + " 00:00:00:000"));
		}
		if(StringUtils.hasText(dto.getEndDate())) {
			criteria.andAddDateLessThanOrEqualTo(DateUtil.converDate(dto.getEndDate() + " 23:59:59:998"));
		}
		criteria.andOtherIsNotNull();
		criteria.andOtherNotEqualTo("");

		List<Accounts> list = accountsMapper.selectByExample(example);
		for(Accounts accounts : list) {
			//String[] otherArr = accounts.getOther().split("\\|");
			//String[] otherPriceArr = accounts.getOprice().split("\\|");
			String[] otherArr = null;
			String[] otherPriceArr = null;
			for(int i=0;i<otherArr.length;i++) {
				OtherAccounts otherAccounts = new OtherAccounts();
				otherAccounts.setAccountsId(accounts.getId());
				otherAccounts.setOther(otherArr[i]);
				otherAccounts.setOtherPrice(new BigDecimal(otherPriceArr[i]));
				otherAccountsMapper.insertSelective(otherAccounts);
			}
		}

		return new ResultDto(ReturnCode.SUCCESS);
	}

	@Override
	public ResultDto settleQuery(QueryDto dto) {
		List<SettleDto> list = accountsMapper.selectSettle();
		return new ResultDto(ReturnCode.SUCCESS, list);
	}

	@Override
	public ResultDto usersQuery() {
		List list = myUserMapper.selectByExample(null);
		return new ResultDto(ReturnCode.SUCCESS, list);
	}

	@Override
	public ResultDto monthDetail(String month, String flag) {
		String date = month + "-01";
		String startDate = DateUtil.appendStartTime(DateUtil.getFirstDayStrOfMonth(DateUtil.stringToDate(date)));
		String endDate = DateUtil.appendEndTime(DateUtil.getLastDayStrOfMonth(DateUtil.stringToDate(date)));
		List<AccountsDto> list = accountsMapper.selectMonthDetails(startDate, endDate, flag);
		AccountsDto dto = list.get(0);
		dto.setAddDate(month);
		dto.setFlag(flag);

		List<OtherAccountsDto> otherAccountsList = accountsMapper.selectMonthDetailsOther(startDate, endDate, flag);
		BigDecimal otherTotal = BigDecimal.ZERO;
		if(otherAccountsList != null && !otherAccountsList.isEmpty()) {
			for(OtherAccountsDto other : otherAccountsList) {
				otherTotal = otherTotal.add(other.getOtherPrice());
			}
			OtherAccountsDto total = new OtherAccountsDto();
			total.setOther("其他总计");
			total.setOtherPrice(otherTotal);
			total.setAddDate(month);
			otherAccountsList.add(total);
		}
		dto.setOthers(otherAccountsList);
		return new ResultDto(ReturnCode.SUCCESS, dto);
	}
}
