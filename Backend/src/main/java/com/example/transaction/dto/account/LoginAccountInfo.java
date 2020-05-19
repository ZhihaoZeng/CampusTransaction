package com.example.transaction.dto.account;

import lombok.Data;

/**
 * @ClassName: LoginAccountInfo
 * @Description: 用于返回登录验证时的用户数据
 * @Author: 曾志昊
 * @Date: 2020/5/19 23:58
 */
@Data
public class LoginAccountInfo {
    Integer userId;
    String token;
    String userAddress;

}
