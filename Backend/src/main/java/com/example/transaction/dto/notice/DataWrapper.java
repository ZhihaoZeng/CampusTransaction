package com.example.transaction.dto.notice;

import com.example.transaction.pojo.Notice;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: DataWrapper
 * @Description: Notice外包一层data
 * @Author: 曾志昊
 * @Date: 2020/5/28 15:33
 */
@Data
public class DataWrapper implements Serializable {
    Notice data;
}
