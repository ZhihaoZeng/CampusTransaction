package com.example.transaction.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.transaction.pojo.Account;
import com.example.transaction.pojo.Commodity;
import com.example.transaction.pojo.Reservation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 高战立
 * @Date: 2020/4/25 14:55
 * @Content: 预约表业务层
 */

@Repository
public interface ReservationDAO  extends BaseMapper<Reservation> {

    @Results(id = "reservationMap", value = {
//            @Result(property = "user", column = "account_id", javaType = Account.class, one = @One(
//                    select = "com.example.transaction.dao.AccountDAO.selectById"
//            )),
            @Result(property = "commodity", column = "commodity_id", javaType = Commodity.class, one = @One(
                    select = "com.example.transaction.dao.CommodityDAO.selectById"
            ))
    })
    @Select("select * from reservation where account_id=#{id}")
    List<Reservation> getAllReservationByAccountId(Integer id);

    @Select("select * from reservation ${ew.customSqlSegment}")
    @ResultMap(value = {"reservationMap"}) //复用上述外键查找
    List<Reservation> getWithCondition(@Param("ew")QueryWrapper<Reservation> queryWrapper);
}