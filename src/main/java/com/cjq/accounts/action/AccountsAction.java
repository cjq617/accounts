package com.cjq.accounts.action;

import com.cjq.accounts.dto.AccountsDto;
import com.cjq.accounts.dto.QueryDto;
import com.cjq.accounts.dto.SumGson;
import com.cjq.accounts.entity.Accounts;
import com.cjq.accounts.service.AccountsService;
import com.cjq.publics.dto.ResultDto;
import com.cjq.publics.dto.ReturnCode;
import com.cjq.publics.entity.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/accounts")
@Controller
public class AccountsAction{
	
	private AccountsService accountsService;

	@Resource
	public void setAccountsService(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	/**
	 * 账单添加页面
	 * @return string
     */
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String add() {
		return "/accounts/billsAdd";
	}

	/**
	 * 添加当天的消费记录
	 * @param dto 账单数据
	 * @return resultDto
     */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public ResultDto add(@RequestBody AccountsDto dto) {
		ResultDto resultDto = accountsService.validateExist(dto.getFlag(),dto.getAddDate());
		if(!ReturnCode.SUCCESS.equals(resultDto.getStatus())) {
			return accountsService.add(dto);
		}
		resultDto.setStatus(ReturnCode.DATA_ERROR);
		return resultDto;
	}

	/**
	 * 计算当天总额
	 * @param dto
	 * @return
     */
	@RequestMapping("/getSum")
	@ResponseBody
	public ResultDto getSum(AccountsDto dto) {
		SumGson sg = accountsService.getSum(dto);
		return new ResultDto(ReturnCode.SUCCESS,sg);
	}

	/**
	 * 账单查询页面
	 * @return string
     */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String query() {
		return "/accounts/billsQuery";
	}

	/**
	 * 查询每天消费信息
	 * @param queryDto 查询dto
	 * @return resultDto
     */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto query(@RequestBody QueryDto queryDto) {
		Pagination<AccountsDto> page = accountsService.queryBills(queryDto);
		return new ResultDto(ReturnCode.SUCCESS,page);
	}

	/**
	 * 账单详情页面
	 * @param id 主键
	 * @param model model
     * @return string
     */
	@RequestMapping(value = "/getBillById", method = RequestMethod.GET)
	public String getBillById(String id, Model model) {
		model.addAttribute("id",id);
		return "/accounts/billsModify";
	}

	/**
	 * 通过id获取当天账单信息
	 * @param id 主键
	 * @return resultDto
     */
	@RequestMapping(value = "/getBillById", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto getBillsById(String id) {
		AccountsDto dto = accountsService.queryDtoById(id);
		if(dto != null) {
			return new ResultDto(ReturnCode.SUCCESS,dto);
		}
		return new ResultDto(ReturnCode.DATA_ERROR);
	}

	/**
	 * 更新账单内容
	 * @param dto 账单dto
	 * @return resultDto
     */
	@RequestMapping("/updateAccounts")
	@ResponseBody
	public ResultDto updateAccounts(@RequestBody AccountsDto dto) {
        ResultDto resultDto = accountsService.validateExist(dto.getFlag(),dto.getAddDate());
        if(!ReturnCode.SUCCESS.equals(resultDto.getStatus()) || ((Accounts)resultDto.getObj()).getId().equals(dto.getId())) {
            return accountsService.updateAccounts(dto);
        }
        resultDto.setStatus(ReturnCode.DATA_ERROR);
        return resultDto;
	}

	/**
	 * 初始化other_accounts数据，从原来accounts表中插入到子表中（数据清洗方法）
	 * @param queryDto 更新条件
	 * @return resultDto
     */
	@RequestMapping("/initOther")
	@ResponseBody
	public ResultDto initOther(QueryDto queryDto) {
		return accountsService.updateInitOther(queryDto);
	}

	@RequestMapping("/settle")
	public String settle() {
		return "accounts/settle";
	}

	@RequestMapping("/settleQuery")
	@ResponseBody
	public ResultDto settleQuery(@RequestBody QueryDto queryDto) {
		return  accountsService.settleQuery(queryDto);
	}

	@RequestMapping("/users")
	public String users() {
		return "accounts/users";
	}

	@RequestMapping("/usersQuery")
	@ResponseBody
	public ResultDto usersQuery() {
		return  accountsService.usersQuery();
	}
}
