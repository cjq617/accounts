package com.cjq.publics.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wen.Xu on 2015/8/16 16:53.
 * Desc:
 */
public class Pagination<T> implements Serializable {
    private static final long serialVersionUID = -3949009665457279706L;

    private int pageSize;
    private int totalCount;
    private int totalPage;
    private int currentPage;
    private List<T> data;
    private Object obj;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
