package com.example.transaction.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.transaction.pojo.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDAO extends BaseMapper<Notice> {

    @Select("select * from notice where account_id = #{id}")
    List<Notice> getNoticeByOwnerId(Integer id);

    @Select("select * from notice ${ew.customSqlSegment}")
    List<Notice> getNoticeWithCondition(@Param("ew")QueryWrapper<Notice> wrapper);

    @Results(id="noticeMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "commodityLists", column = "id", many = @Many(
                    select = "com.example.transaction.dao.CommodityListDAO.getAllCommodityListByNoticeId"
            ))
    })
    @Select("select * from notice where id=#{id}")
    Notice getNoticeWithAllCommodityById(Integer id);

    @Results(id="accountMap", value = {
            @Result(property = "user", column = "account_id", one = @One(
                    select = "com.example.transaction.dao.AccountDAO.getAccountCreditById"
            ))
    })
    @Select("select * from notice where id = #{id}")
    Notice getCreditByNoticeId(Integer id);
}
