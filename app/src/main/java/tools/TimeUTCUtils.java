package tools;

import android.net.ParseException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by qupengcheng on 2018/10/10.
 */

public class TimeUTCUtils {

    public static String getUTCTimeStr() throws Exception {
        Calendar cal = Calendar.getInstance();
        return String.valueOf(cal.getTimeInMillis() / 1000+86400);// 返回的就是UTC时间
    }
}
