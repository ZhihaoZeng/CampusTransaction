package com.example.transaction.dto.notice;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName: NoticeCondition
 * @Description: 通告搜索条件
 * @Author: 曾志昊
 * @Date: 2020/5/14 12:03
 */
@Data
public class NoticeCondition {
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm")
    Date endTime;
    Integer pageIndex;
    //0-全部 1-出售的 2-需求
    Integer type;
    Integer accountId;
}
