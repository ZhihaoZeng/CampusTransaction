package com.example.transaction.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: 高战立
 * @Date: 2020/4/24 15:25
 * @Content: 用户通知列表
 */

@Data
@TableName(value = "acc_notify")
public class AccountNotify implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "is_read")
    private Boolean isRead;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "GMT+8")
    @TableField(value = "creat_time")
    private Timestamp createTime;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "GMT+8")
    @TableField(value = "read_time")
    private Timestamp readTime;
    @TableField(value = "notify_id")
    private Integer notifyId;
    @TableField(value = "account_id")
    private Integer accountId;


    @TableField(exist = false)
    private Notify notify;
    @TableField(exist = false)
    private Account owner;

    public AccountNotify() {
    }

    public AccountNotify(Integer id) {
        this.id = id;
    }
}
