package com.cjq.accounts.dao;

import com.cjq.accounts.entity.OtherAccounts;
import com.cjq.accounts.entity.OtherAccountsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OtherAccountsMapper {
    int countByExample(OtherAccountsExample example);

    int deleteByExample(OtherAccountsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OtherAccounts record);

    int insertSelective(OtherAccounts record);

    List<OtherAccounts> selectByExample(OtherAccountsExample example);

    OtherAccounts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OtherAccounts record, @Param("example") OtherAccountsExample example);

    int updateByExample(@Param("record") OtherAccounts record, @Param("example") OtherAccountsExample example);

    int updateByPrimaryKeySelective(OtherAccounts record);

    int updateByPrimaryKey(OtherAccounts record);
}