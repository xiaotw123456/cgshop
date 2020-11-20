package com.example.cgcommon.constant;

import lombok.Data;

import java.util.List;

/**
 * @version: V1.0
 * @author: Administrator
 * @className: PageResult
 * @packageName: com.example.cgcommon.constant
 * @description: 这是用户类
 * @data: 2020/10/24 14:04
 **/
@Data
public class PageResult<T> {

    private Long total;//总记录数
    private List<T> rows;//记录

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }
}
