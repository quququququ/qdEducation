package tools;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by qupengcheng on 2018/10/12.
 */

public class MD5tools {
    public static String getSigh(String appid, String secret_key) throws Exception {

        //appid，保密字段，时间戳，随机字符串
        String need = "123456" + "&" + TimeUTCUtils.getUTCTimeStr() + "&" + getNonceStr() + "&" + "0af61531c6c04ac4ac910d0cd59e6238";

        Log.i("------",need+"");
        return MD5(need).toUpperCase();
    }

    public static String getNonceStr() {
        //1. 定义一个字符串（A-Z，a-z，0-9）即62个数字字母；
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        int[] arr = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
        int index = (int) (Math.random() * arr.length);
        int rand = arr[index];
        //2. 由Random生成随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        //3. 长度为几就循环几次
        for (int i = 0; i < rand; ++i) {
            //从62个的数字或字母中选择
            int number = random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

    public static String MD5(String string) {

        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();

    }
}
