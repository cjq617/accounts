package com.cjq.publics.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by jq Chen on 2018/5/3.
 */
public class DateUtil {
    public static final String DATE_WEEK = "yyyy-MM-dd EEEE";//2016-05-10 星期一
    public static final String NORMAL_DATE = "yyyy-MM-dd HH:mm:ss";
    public static final String SIMPLE_DATE = "yyyy-MM-dd";
    public static final String EXACT_DATE = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String LONG_DATE = "yyyyMMddHHmmssSSS";
    public static final String LONG_DATE_SECOND = "yyyyMMddHHmmss";
    public static final String LONG_DATE_HH_MM = "yyyyMMddHHmm";
    public static final String LONG_DATE_HH = "yyyyMMddHH";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYMMDD = "yyMMdd";
    public static final String YYMD = "yyMd";
    public static final String PATH_DATE = "yyyy/MM/dd";
    public static final String DATE_T_TIME = "yyyy-MM-dd'T'HH:mm:ss";
    private static final Logger log = LogManager.getLogger(DateUtil.class);
    
    public static Calendar getCalendar() {
        return Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.CHINA);
    }

    public static Date getNowDate() {
        return getCalendar().getTime();
    }
    /**
     * 格式化日期 格式: yyyy-MM-dd HH:mm:ss
     */
    public static String formatDate(Date date) {
        if (date == null)
            return null;
        return new SimpleDateFormat(NORMAL_DATE).format(date);
    }

    /**
     * 格式化日期 格式: yyyy-MM-dd
     */
    public static String formatDate2(Date date) {
        if (date == null)
            return null;
        return new SimpleDateFormat(SIMPLE_DATE).format(date);
    }

    /**
     * 自定格式化日期
     *
     * @param date
     * @param toFormat
     * @return
     */
    public static String formatDate(Date date, String toFormat) {
        if (null == date || !StringUtils.hasText(toFormat)) {
            return "";
        }
        return new SimpleDateFormat(toFormat).format(date);
    }

    public static String converDateFormat(String date, String fromFormat, String toFormat) {
        if (!StringUtils.hasText(date) || !StringUtils.hasText(fromFormat) || !StringUtils.hasText(toFormat)) {
            return "";
        }
        return formatDate(converDate3(date, fromFormat), toFormat);
    }

    /**
     * 字符串转日期
     *
     * @param dateStr 日期字符串 格式 yyyy-MM-dd HH:mm:ss:SSS
     * @return Date
     */
    public static Date converDate(String dateStr) {
        DateFormat df = new SimpleDateFormat(EXACT_DATE);
        Date date;
        try {
            date = df.parse(dateStr);
            return date;
        } catch (ParseException e) {
            log.error("字符串转日期错误", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 字符串转日期2
     *
     * @param dateStr 日期字符串 格式 yyyy-MM-dd
     * @return Date
     */
    public static Date converDate2(String dateStr) {
        DateFormat df = new SimpleDateFormat(SIMPLE_DATE);
        Date date;
        try {
            date = df.parse(dateStr);
            return date;
        } catch (ParseException e) {
            log.error("字符串转日期错误", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 字符串转日期3
     *
     * @param dateStr   日期字符串
     * @param formatStr 格式
     * @return Date
     */
    public static Date converDate3(String dateStr, String formatStr) {
        DateFormat df = new SimpleDateFormat(formatStr);
        Date date;
        try {
            date = df.parse(dateStr);
            return date;
        } catch (ParseException e) {
            log.error("字符串转日期错误", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 未知格式转为date类型
     *
     * @param dateStr
     * @return
     */
    public static Date converDate4(String dateStr) {
        if (null == dateStr || "".equals(dateStr)) {
            return null;
        }
        String tmp = dateStr.replace("-", "").replace("\\", "").replace(" ", "").replace(":", "").replace("T", "");

        if (tmp.length() == DateUtil.YYMD.length()) {
            return DateUtil.converDate3(tmp, DateUtil.YYMD);
        } else if (tmp.length() == DateUtil.YYMMDD.length()) {
            return DateUtil.converDate3(tmp, DateUtil.YYMMDD);
        } else if (tmp.length() == DateUtil.YYYYMMDD.length()) {
            return DateUtil.converDate3(tmp, DateUtil.YYYYMMDD);
        } else if (tmp.length() == DateUtil.LONG_DATE_HH.length()) {
            return DateUtil.converDate3(tmp, DateUtil.LONG_DATE_HH);
        } else if (tmp.length() == DateUtil.LONG_DATE_HH_MM.length()) {
            return DateUtil.converDate3(tmp, DateUtil.LONG_DATE_HH_MM);
        } else if (tmp.length() == DateUtil.LONG_DATE_SECOND.length()) {
            return DateUtil.converDate3(tmp, DateUtil.LONG_DATE_SECOND);
        } else if (tmp.length() == DateUtil.LONG_DATE.length()) {
            return DateUtil.converDate3(tmp, DateUtil.LONG_DATE);
        }
        return null;
    }

    public static Date calculateDate(Date d, String type, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        if (type.equals("YEAR"))
            calendar.add(Calendar.YEAR, number);
        if (type.equals("MONTH"))
            calendar.add(Calendar.MONTH, number);
        if (type.equals("DAY"))
            calendar.add(Calendar.DAY_OF_MONTH, number);
        if (type.equals("HOUR"))
            calendar.add(Calendar.HOUR_OF_DAY, number);
        if (type.equals("MINUTE"))
            calendar.add(Calendar.MINUTE, number);
        return calendar.getTime();
    }

    public static String formatCmdDate(String cmdDate) {
        if (cmdDate == null) {
            return null;
        }
        // 11Aug09|6Aug09
        int len = cmdDate.length();
        if (len == 5) {
            cmdDate += new SimpleDateFormat("yy").format(getNowDate());
            len = 7;
        }
        if (len != 7)
            return null;
        String month = cmdDate.substring(len - 5, len - 2);
        String year = cmdDate.substring(len - 2, len);
        String day = cmdDate.substring(0, len - 5);
        if (month.equalsIgnoreCase("JAN")) {
            month = "01";
        } else if (month.equalsIgnoreCase("FEB")) {
            month = "02";
        } else if (month.equalsIgnoreCase("MAR")) {
            month = "03";
        } else if (month.equalsIgnoreCase("APR")) {
            month = "04";
        } else if (month.equalsIgnoreCase("MAY")) {
            month = "05";
        } else if (month.equalsIgnoreCase("JUN")) {
            month = "06";
        } else if (month.equalsIgnoreCase("JUL")) {
            month = "07";
        } else if (month.equalsIgnoreCase("AUG")) {
            month = "08";
        } else if (month.equalsIgnoreCase("SEP")) {
            month = "09";
        } else if (month.equalsIgnoreCase("OCT")) {
            month = "10";
        } else if (month.equalsIgnoreCase("NOV")) {
            month = "11";
        } else if (month.equalsIgnoreCase("DEC")) {
            month = "12";
        }
        if (!day.startsWith("0") && day.length() == 1) {
            day = "0" + day;
        }
        return "20" + year + "-" + month + "-" + day;
    }

    /**
     * 计算第二个日期和第一个日期相差多少天
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 相差天数
     */
    public static int getDiffDay(String date1, String date2) {
        long l = converDate2(date2).getTime() - converDate2(date1).getTime();
        return (int) (l / 1000 / 60 / 60 / 24);
    }

    /**
     * 计算当前日期距离给定日期相差多少天
     *
     * @param date 给定日期
     * @return 相差天数
     */
    public static int getDiffDayWithNow(String date) {
        return getDiffDay(formatDate2(getNowDate()), date);
    }

    /**
     * 计算当前日期距离给定日期相差多少分钟
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDiffMin(Date date1, Date date2) {
        long l = date1.getTime() - date2.getTime();
        return (l / 1000 / 60);
    }

    /**
     * 获取当前日期第N天后的日期字符串 格式 yyyy-MM-dd
     *
     * @param days 给定天数，可以为负数
     * @return 日期字符串
     */
    public static String getNextDateWithNow(int days) {
        return formatDate2(calculateDate(getNowDate(), "DAY", days));
    }

    public static String formatMon(String mon) {
        if ("01".equals(mon)) {
            return "JAN";
        } else if ("02".equals(mon)) {
            return "FEB";
        } else if ("03".equals(mon)) {
            return "MAR";
        } else if ("04".equals(mon)) {
            return "APR";
        } else if ("05".equals(mon)) {
            return "MAY";
        } else if ("06".equals(mon)) {
            return "JUN";
        } else if ("07".equals(mon)) {
            return "JUL";
        } else if ("08".equals(mon)) {
            return "AUG";
        } else if ("09".equals(mon)) {
            return "SEP";
        } else if ("10".equals(mon)) {
            return "OCT";
        } else if ("11".equals(mon)) {
            return "NOV";
        } else if ("12".equals(mon)) {
            return "DEC";
        } else {
            return "";
        }
    }

    /**
     * 日期转换（yyyy-MM-dd to ddMMMyy）
     *
     * @param date
     * @return
     */
    public static String formatToCmdDate(String date) {
        if (StringUtils.hasText(date)) {
            int index = date.indexOf("-");
            String year = date.substring(2, index);
            String mon = date.substring(index + 1, index + 3);
            String day = date.substring(date.length() - 2);
            mon = formatMon(mon);
            if (StringUtils.hasText(mon)) {
                date = day + mon + year;
            }
        }
        return date;
    }

    /**
     * 日期比较
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDate(Date date1, Date date2) {
        return date2.compareTo(date1);
    }

    public static String convertWeek(String enWeek) {
        String cnWeek = "";
        if ("SUN".equals(enWeek)) {
            cnWeek = "星期天";
        } else if ("MON".equals(enWeek)) {
            cnWeek = "星期一";
        } else if ("TUE".equals(enWeek)) {
            cnWeek = "星期二";
        } else if ("WED".equals(enWeek)) {
            cnWeek = "星期三";
        } else if ("THU".equals(enWeek)) {
            cnWeek = "星期四";
        } else if ("FRI".equals(enWeek)) {
            cnWeek = "星期五";
        } else if ("SAT".equals(enWeek)) {
            cnWeek = "星期六";
        }
        return cnWeek;
    }

    public static String getCnWeekByDate(Date date) {
        String cnWeek = "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        if (week == 1) {
            cnWeek = "星期日";
        } else if (week == 2) {
            cnWeek = "星期一";
        } else if (week == 3) {
            cnWeek = "星期二";
        } else if (week == 4) {
            cnWeek = "星期三";
        } else if (week == 5) {
            cnWeek = "星期四";
        } else if (week == 6) {
            cnWeek = "星期五";
        } else if (week == 7) {
            cnWeek = "星期六";
        }
        return cnWeek;
    }

    /**
     * 判断今天是否在指定的范围内
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isNowIn(Date date1, Date date2) {
        if (null == date1 || null == date2) {
            return false;
        }
        Calendar now = DateUtil.getCalendar();
        Calendar cal1 = (Calendar) now.clone();
        Calendar cal2 = (Calendar) now.clone();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.compareTo(now) <= 0 && cal2.compareTo(now) >= 0;
    }

/*    *//**
     * 获取给定日期的当月第一天
     *
     * @param date
     * @return
     *//*
    public static String getFirstDayStrOfMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01");
        return sdf.format(date.getTime());
    }

    *//**
     * 获取给定日期的当月最后一天
     *
     * @param date
     * @return
     *//*
    public static String getLastDayStrOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-" + maxDay);
        return sdf.format(date.getTime());
    }*/

    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static LocalDate dateToLocalDate(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        return localDateTime.toLocalDate();
    }

    public static String getFirstDayStrOfMonth(Date date) {
        return getFirstDayStrOfMonth(dateToLocalDate(date));
    }

    public static String getFirstDayStrOfMonth(LocalDate date) {
        return date.with(TemporalAdjusters.firstDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String getLastDayStrOfMonth(Date date) {
        return getLastDayStrOfMonth(dateToLocalDate(date));
    }

    public static String getLastDayStrOfMonth(LocalDate date) {
        return date.with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String appendStartTime(String dateStr) {
        if (!StringUtils.hasText(dateStr)) {
            throw new IllegalArgumentException("参数为空");
        } else {
            return dateStr + " 00:00:00";
        }
    }

    public static String appendEndTime(String dateStr) {
        if (!StringUtils.hasText(dateStr)) {
            throw new IllegalArgumentException("参数为空");
        } else {
            return dateStr + " 23:59:59";
        }
    }

    public static Date stringToDate(String dateStr) {
        return localDateToDate(LocalDate.parse(dateStr));
    }

    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }
}
