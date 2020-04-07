package com.cjq.accounts.service;

import com.cjq.accounts.dto.AccountsDto;
import com.cjq.accounts.dto.QueryDto;
import com.cjq.accounts.dto.SumGson;
import com.cjq.publics.dto.ResultDto;
import com.cjq.publics.entity.Pagination;

public interface AccountsService {
	SumGson getSum(AccountsDto dto);//计算当天消费总额
	
	ResultDto add(AccountsDto dto);//添加某天的消费记录
	
	ResultDto validateExist(String flag, String addDate);//判断该天该人物的记录是否存在

	Pagination<AccountsDto> queryBills(QueryDto dto);//条件查询每天的消费记录

	AccountsDto queryDtoById(String id);

	ResultDto updateAccounts(AccountsDto dto);

	ResultDto updateInitOther(QueryDto dto);

	ResultDto settleQuery(QueryDto dto);

	ResultDto usersQuery();

	ResultDto monthDetail(String month, String flag);
}
