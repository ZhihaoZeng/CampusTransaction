package com.example.transaction.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.transaction.dto.account.SimpleAccount;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
public class Account  implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private Boolean gender;
    private String address;
    private String institute;
    private String mail;
    private String qq;
    private String wechat;
    private String avatar;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;
    private String introduction;

    @TableField(exist = false)
    private Estimate estimate;
    @TableField(exist = false)
    private List<Notice> noticeList;
    @TableField(exist = false)
    private List<Reservation> reservationList;
    @TableField(exist = false)
    private List<Search> searchList;
    @TableField(exist = false)
    private List<AccountNotify> accountNotifyList;
    @TableField(exist = false)
    private List<Subscription> subscriptionList;

    public Account(Integer accountId){
        this.id = accountId;
    }
    public Account(){}
}
