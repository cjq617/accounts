package com.cjq.accounts.dao;

import com.cjq.accounts.entity.Settle;
import com.cjq.accounts.entity.SettleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SettleMapper {
    int countByExample(SettleExample example);

    int deleteByExample(SettleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Settle record);

    int insertSelective(Settle record);

    List<Settle> selectByExample(SettleExample example);

    Settle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Settle record, @Param("example") SettleExample example);

    int updateByExample(@Param("record") Settle record, @Param("example") SettleExample example);

    int updateByPrimaryKeySelective(Settle record);

    int updateByPrimaryKey(Settle record);
}