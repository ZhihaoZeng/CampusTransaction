package com.example.transaction.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.transaction.pojo.Commodity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: 高战立
 * @Date: 2020/4/25 9:14
 * @Content: 商品表数据层
 */

@Repository
public interface CommodityDAO extends BaseMapper<Commodity> {

//    @Results(id="commodity_detailedMap-01", value = {
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "commodityLists", column = "id", many = @Many(
//                    select = "com.example.transaction.dao.CommodityDAO.getInfoByCommodityId"
//            ))
//    })
    @Select("select * from commodity where id = #{id}")
    Commodity selectDetailedCommodity(Integer id);
    //利用queryWrapper查找
    List<Commodity> selectWithCondition(@Param("ew") QueryWrapper<Commodity> wrapper);
    //商品名模糊分页查询，新旧程度排序
    IPage<Commodity> sortByNewness(Page<?> page, String name, Timestamp timestamp);
    //商品类型分页查询
    IPage<Commodity> sortByType(Page<?> page, Integer typeId, Timestamp timestamp);
    //商品价格区间分页查询
    IPage<Commodity> betweenPrice(Page<?> page, String name, Integer low, Integer high, Timestamp timestamp);
    //商品名模糊分页查询, 所有者信誉排序
    IPage<Commodity> sortByCredit(Page<?> page, String name, Timestamp timestamp);
}
