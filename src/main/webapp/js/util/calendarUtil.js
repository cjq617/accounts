//JS关于日期的工具方法

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

/**
 * 将一位的数字填充为两位
 * @param i
 * @return String
 */
function addZero(i) {
    if (i < 10)
        return "0" + i;
    else
        return i;
}

/**
 * 根据date.getDay()得到的数字 返回汉字的星期几
 * @param i
 * @return String
 */
function getDay(i) {
    switch (i) {
        case 0:
            return "日";
        case 1:
            return "一";
        case 2:
            return "二";
        case 3:
            return "三";
        case 4:
            return "四";
        case 5:
            return "五";
        case 6:
            return "六";
    }
}

/**
 * 将一个日期对象date转换成字符串2011-08-09
 * @param date
 * @return String
 */
function dateTOString(date) {
    return date.getFullYear() + "-" + addZero(date.getMonth() + 1) + "-" + addZero(date.getDate());
}

/**
 * 将类似2011-09-08的字符串转换成日期
 * @param str
 * @return Date
 */
function stringTODate(str) {
    var arr = str.split("-");
    var date = new Date();
    date.setFullYear(arr[0], arr[1] - 1, arr[2]);
    date.setHours(0, 0, 0, 0);
    return date;
}

/**
 * 将一个日期对象date转换成字符串2011-08-09 12:00
 * @param date
 * @return String
 */
function dateTOString2(date) {
    return date.getFullYear() + "-" + addZero(date.getMonth() + 1) + "-"
        + addZero(date.getDate()) + " " + addZero(date.getHours()) + ":" + addZero(date.getMinutes());
}

/**
 * 将一个日期对象date转换成字符串2011-08-09 12:00:00
 * @param date
 * @return String
 */
function dateTOString3(date) {
    return date.getFullYear() + "-" + addZero(date.getMonth() + 1) + "-"
        + addZero(date.getDate()) + " " + addZero(date.getHours()) + ":" + addZero(date.getMinutes()) + ":" + addZero(date.getSeconds());
}

/**
 * 将类似2011-09-05 13：30 的字符串转换成日期
 * @param str
 * @return Date
 */
function stringTODate2(str) {
    var arr = str.split(" ");
    var arr2 = arr[0].split("-");
    var date = new Date();
    date.setFullYear(arr2[0], arr2[1] - 1, arr2[2]);
    date.setHours(arr[1].slice(0, 2), arr[1].slice(-2));
    return date;
}

/**
 * 将类似2011-09-05 13:30:00 的字符串转换成日期
 * @param str
 * @return Date
 */
function stringTODate3(str) {
    var arr = str.split(" ");
    var arr2 = arr[0].split("-");
    var date = new Date();
    date.setFullYear(arr2[0], arr2[1] - 1, arr2[2]);
    date.setHours(arr[1].slice(0, 2), arr[1].slice(3,5),arr[1].slice(-2));
    return date;
}

/**
 * 根据一个date对象得到离这天前后多少天的日期对象 i为负数为前几天，正数为后几天
 * @param date
 * @param i
 * @return Date
 */
function nextDate(date, i) {
    var nDate = new Date();
    nDate.setFullYear(date.getFullYear(), date.getMonth(), date.getDate() + i);
    return nDate;
}

/**
 * 获取一个日期字符串的n天后的日期字符串
 */
function getNextDateString(dateStr, n) {
    return dateTOString(nextDate(stringTODate(dateStr), n));
}

/**
 * 判断第一个日期是否在第二个日期之前
 * 如果date1 < date2 返回 -1 相等返回0 大于返回 1
 * @param date1
 * @param date2
 * @return Number
 */
function isBefore(date1, date2) {
    var d1 = stringTODate(date1);
    var d2 = stringTODate(date2);
    var t = d1.getTime() - d2.getTime();
    if (t == 0)
        return 0;
    else if (t < 0)
        return -1;
    else return 1;
}

/**
 * 判断第二个日期是否在第一个日期的 i 天以后
 * @param date1
 * @param date2
 * @param i
 * @return Boolean
 */
function isMoreDaysLater(date1, date2, i) {
    var d1 = stringTODate(date1);
    var d2 = stringTODate(date2);
    var t = d2.getTime() - d1.getTime();
    return t >= i * 24 * 60 * 60 * 1000;
}

/**
 * 计算第一个日期和第二个日期相差多少天
 * @param date1
 * @param date2
 * @return Number
 */
function getDifferDays(date1, date2) {
    var d1 = stringTODate(date1);
    var d2 = stringTODate(date2);
    return (d2.getTime() - d1.getTime()) / 1000 / 60 / 60 / 24;
}

function getDifferDaysByDate(date1, date2) {
    var d1 = date1;
    var d2 = date2;
    d1.setHours(0);
    d1.setMinutes(0);
    d1.setSeconds(0);
    d1.setMilliseconds(0);
    d2.setHours(0);
    d2.setMinutes(0);
    d2.setSeconds(0);
    d2.setMilliseconds(0);
    return (d2.getTime() - d1.getTime()) / 1000 / 60 / 60 / 24;
}

/**
 * 计算第一个日期和第二个日期相差多少分钟 日期格式为2011-10-01 12:23
 * @param date1
 * @param date2
 * @return Number
 */
function getDifferMinutes(date1, date2) {
    var d1 = stringTODate2(date1);
    var d2 = stringTODate2(date2);
    return (d2.getTime() - d1.getTime()) / 1000 / 60;
}

/**
 * 计算第一个日期和第二个日期相差多少秒 日期格式为2011-10-01 12:23:00
 * @param date1
 * @param date2
 * @return Number
 */
function getDifferSeconds(date1, date2) {
    if(!date1 instanceof Date) {
        date1 = stringTODate3(date1);
    }
    if(!date2 instanceof Date) {
        date2 = stringTODate3(date2);
    }
    var minSeconds = date2.getTime() - date1.getTime();
    return (minSeconds - minSeconds%1000)/1000;
}

/**
 * 根据日期字符串返回星期几
 * @param dateStr
 * @returns {string}
 */
function getDayByDateStr(dateStr) {
    return getDay(stringTODate(dateStr).getDay());
}

/**
 * 时间加
 * @param date 日期
 * @param i 增量
 * @param t 1时，2分，3秒
 */
function addTime(date, i, t){
    i = parseInt(i, 10);
    if(t == 1){
        date.setHours(date.getHours() + i,date.getMinutes(), date.getSeconds(), 0);
    }else if(t == 2){
        date.setMinutes(date.getMinutes() + i,date.getSeconds(), 0);
    }else if(t == 3){
        date.setSeconds(date.getSeconds() + i, 0);
    }
    return date;
}

/**
 * 获取给定日期的当月第一天
 * @param date
 * @returns {*}
 */
function getMonthFirst(date){
    date.setDate(1);
    return date;
}

/**
 * 获取给定日期当月的最后一天
 * @param date
 * @returns {Date}
 */
function getMonthLast(date){
    var month=date.getMonth();
    var nextMonth=++month;
    var nextMonthFirstDay=new Date(date.getFullYear(),nextMonth,1);
    var oneDay=1000*60*60*24;
    return new Date(nextMonthFirstDay-oneDay);
}

function getYearFirst(date) {
    date.setMonth(0);
    date.setDate(1);
    return date;
}

function getYearLast(date) {
    date.setMonth(11);
    date.setDate(31);
    return date;
}