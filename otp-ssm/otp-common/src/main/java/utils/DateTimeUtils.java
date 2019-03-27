package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: jingtiancai
 * @date: 2018/9/18 17:21
 * @desc:
 */
public class DateTimeUtils {
    public static String dateToStamp(String dateStr) throws Exception {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateStr);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
//  public static String stampToDate(String stamp){
//	String res;
//	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	long lt = new Long(stamp);
//	Date date = new Date(lt);
//	res = simpleDateFormat.format(date);
//	return res;
//  }
    public static Date stampToDate(String stamp) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(stamp);
    }

    public static Date stampToDate(Date stamp) throws Exception {
        return stampToDate(stamp.toString());
    }


}
