package com.example.transaction.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: 高战立
 * @Date: 2020/4/24 15:37
 * @Content: 商品
 */

@Data
public class Commodity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "original_price")
    private Double originalPrice;
    @TableField(value = "expected_price")
    private Double expectedPrice;
    private String name;
    private String newness;
    private String description;
    @TableField(value = "notice_id")
    private Integer noticeId;
    @TableField(value = "initial_count")
    private Integer initialCount;
    private Integer count;
    private String type;

    @TableField(exist = false)
    private List<Type> types;

    @TableField(exist = false)
    private List<CommodityImage> commodityImages;
    @TableField(exist = false)
    private Notice notice;
    @TableField(exist = false)
    private List<Reservation> reservation;

    @TableField(exist = false)
    private List<String> images;

    
    
    public Commodity() {
    }

    public Commodity(Integer id) {
        this.id = id;
    }
}
