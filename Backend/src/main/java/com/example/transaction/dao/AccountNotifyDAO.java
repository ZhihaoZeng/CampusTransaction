package com.example.transaction.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.transaction.pojo.Account;
import com.example.transaction.pojo.AccountNotify;
import com.example.transaction.pojo.Commodity;
import com.example.transaction.pojo.Notify;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 高战立
 * @Date: 2020/4/25 18:40
 * @Content:
 */

@Repository
public interface AccountNotifyDAO extends BaseMapper<AccountNotify> {

    @Results(
            @Result(property = "notify", column = "notify_id", javaType = Notify.class, one = @One(
                    select = "com.example.transaction.dao.NotifyDao.selectById"
            ))
    )
    @Select("select * from notify acc_notify where account_id = #{account_id} and is_read = false order by create_time DESC")
    List<AccountNotify> getUnreadNotifyByAccountId(Integer accountId);

    @Results(
            @Result(property = "notify", column = "notify_id", javaType = Notify.class, one = @One(
                    select = "com.example.transaction.dao.NotifyDao.selectById"
            ))
    )
    @Select("select * from notify acc_notify where account_id = #{account_id} order by create_time DESC")
    List<AccountNotify> getAllNotifyByAccountId(Integer accountId);

    @Results(
            @Result(property = "notify", column = "notify_id", javaType = Notify.class, one = @One(
                    select = "com.example.transaction.dao.NotifyDao.selectById"
            ))
    )
    @Select("select * from notify acc_notify where id = #{id} ")
    AccountNotify getDetailedNotifyById(Integer id);



    @Update("update acc_notify set is_read = true where id = #{id}")
    int setNotifyRead(Integer id);




}