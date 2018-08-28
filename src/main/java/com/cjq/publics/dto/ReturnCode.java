package com.cjq.publics.dto;

import java.io.Serializable;

/**
 * Created by wen.Xu on 2015/9/4 20:30.
 * Desc:
 */
public class ReturnCode implements Serializable {
    private static final long serialVersionUID = 4978479239120726489L;

    public static final String SUCCESS = "0000";
    public static final String NOT_LOGIN = "1000";
    public static final String NO_POPEDOM = "2000";
    public static final String BUSIN_ERROR = "3000";
    public static final String SYS_ERROR = "4000";
    public static final String ILLEGAL_IP = "5000";
    public static final String SIGN_ERROR = "6000";
    public static final String DATA_ERROR = "7000";
    public static final String DATA_EMPTY = "7001";
    public static final String PRICE_CHANGE = "8000";
    public static final String VERIFY_CODE_ERROR = "8001";
    public static final String UUID_REDUPLICATE = "9000";
    public static final String DEFAULT_MESSAGE = "系统繁忙，请稍后再试！";
    public static final String OUT_TICKET_ERROR = "3001";//出票失败
    public static final String MAX_REQUEST = "999";
    public static final String REPEAT_ERROR = "0100";
    public static final String ERROR_MSG = "订单状态已发生改变，请刷新页面后重试！";
    public static final String STATUS_ERROR = "1100";//订单状态错误
}
