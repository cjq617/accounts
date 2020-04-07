package com.cjq.accounts.dao;

import com.cjq.accounts.dto.AccountsDto;
import com.cjq.accounts.dto.OtherAccountsDto;
import com.cjq.accounts.dto.SettleDto;
import com.cjq.accounts.entity.Accounts;
import com.cjq.accounts.entity.AccountsExample;
import com.cjq.accounts.entity.AccountsTotalExample;
import com.cjq.accounts.entity.OtherAccounts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountsMapper {
    int countByExample(AccountsExample example);

    int deleteByExample(AccountsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Accounts record);

    int insertSelective(Accounts record);

    List<Accounts> selectByExample(AccountsExample example);

    Accounts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Accounts record, @Param("example") AccountsExample example);

    int updateByExample(@Param("record") Accounts record, @Param("example") AccountsExample example);

    int updateByPrimaryKeySelective(Accounts record);

    int updateByPrimaryKey(Accounts record);

    int countByTotalExample(AccountsTotalExample example);

    List<AccountsDto> selectDtoByTotalExample(AccountsTotalExample example);

    AccountsDto selectDtoByPrimaryKey(Integer id);

    List<SettleDto> selectSettle();

    List<AccountsDto> selectMonthDetails(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("flag") String flag);

    List<OtherAccountsDto> selectMonthDetailsOther(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("flag") String flag);
}