package com.cjq.accounts.dao;

import com.cjq.accounts.dto.AccountsDto;
import com.cjq.accounts.entity.Accounts;
import com.cjq.accounts.entity.AccountsExample;
import com.cjq.accounts.entity.AccountsTotalExample;
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

}