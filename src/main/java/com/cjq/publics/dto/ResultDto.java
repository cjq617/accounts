package com.cjq.publics.dto;

import com.cjq.publics.entity.Pagination;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wen.Xu on 2015/8/16 17:43.
 * Desc:
 */
public class ResultDto implements Serializable {
    private static final long serialVersionUID = 8137964435329216123L;

    private String status;//状态码
    private String message;//错误信息

    private List<?> data;//返回的数据

    private Pagination<?> pg;//返回分页数据

    private Object obj;//返回一个对象

    public ResultDto() {

    }

    public ResultDto(String status) {
        this.status = status;
    }

    public ResultDto(String status, String message) {
        this.status = status;
        if (StringUtils.hasText(message)) {
            this.message = message;
        } else {
            this.message = "未知错误";
        }
    }

    public ResultDto(String status, List<?> data) {
        this.status = status;
        this.data = data;
    }

    public ResultDto(String status, Pagination<?> pg) {
        this.status = status;
        this.pg = pg;
    }

    public ResultDto(String status, Object obj) {
        this.status = status;
        this.obj = obj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Pagination<?> getPg() {
        return pg;
    }

    public void setPg(Pagination<?> pg) {
        this.pg = pg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
