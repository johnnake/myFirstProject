package com.zxw.util;


import lombok.Data;

import java.util.List;


@Data
public class PageResult<T> {
    private List<T> dataList;
    private int pageNo;
    private int pageSize;
    private long totalCount;

    public PageResult() {
    }

    public PageResult(List<T> dataList, int pageNo, int pageSize, long totalCount) {
        this.dataList = dataList;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    // 构造方法、getters 和 setters 省略，请根据需要添加
}