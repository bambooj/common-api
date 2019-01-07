package org.jogen.demo.util;

import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * 日期工具
 * @author Jogen
 */
public class DateUtil {

    /**
     * 根据时间字符串，获取时间戳
     *
     * @param date 时间日期格式：yyyy-MM-dd HH:mm:ss 或 yyyy-MM-ddTHH:mm:ss
     * @return
     */
    public static long getTimestamp(String date){
        long time = 0;
        if (StringUtils.isEmpty(date)){
            return time;
        }
        try {
            time = Timestamp.valueOf(LocalDateTime.parse(date)).getTime();
        } catch (DateTimeParseException e) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            time = Timestamp.valueOf(LocalDateTime.parse(date, formatter)).getTime();
        }

        return time;
    }

    /**
     * convert {@link java.util.Date} to {@link java.time.LocalDateTime}
     * @param date
     * @return
     */
    public LocalDateTime toLocalDateTime(Date date){
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static void main(String[] args) {

        String name = "Hexin";
    }
}
