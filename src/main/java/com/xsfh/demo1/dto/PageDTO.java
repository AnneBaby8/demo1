package com.xsfh.demo1.dto;

import lombok.Data;

@Data
public class PageDTO {

    // "当前页"
    private Integer pageNo = 1;
    //每页数据条数
    private Integer pageSize = 10;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
