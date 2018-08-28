package com.cjq.publics.entity;

import java.io.Serializable;

/**
 * Created by wen.Xu on 2015/8/31 13:14.
 * Desc:
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 7184890606392601037L;

    private int begin;//分页查询开始记录位置

    private int end;//分页查看下结束位置

    private int currentPage;//当前页码

    private int pageSize;//每页显示记录数

    private int totalCount;//查询结果总记录数

    private int totalPage;//总共页数

    private String orderByClause;//MSSQL专用，因为row_numer() over用了排序后，不允许再出现order by 语句

    public Page(int currentPage, int pageSize, int totalCount) {
        currentPage = currentPage == 0 ? 1 :currentPage;
        pageSize = pageSize == 0 ? 20 : pageSize;
        this.begin = (currentPage - 1) * pageSize;//mysql是从n+1开始
        this.end = currentPage * pageSize;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = (totalCount + pageSize - 1) / pageSize;
    }

    public Page(int currentPage, int pageSize, int totalCount, String orderByClause) {
        this(currentPage, pageSize, totalCount);
        this.orderByClause = orderByClause;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
}
