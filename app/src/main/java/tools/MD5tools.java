package tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

/**
 * Created by qupengcheng on 2018/10/12.
 */

public class MD5tools {
    public static String getSigh(String appid, String secret_key) throws Exception {

        //appid，保密字段，时间戳，随机字符串
        String need = "123456" + "&" + "0af61531c6c04ac4ac910d0cd59e6238" + "&" + TimeUTCUtils.getUTCTimeStr() + "&" + getNonceStr();

        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(need.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String result = new BigInteger(1, md.digest()).toString(16);
            return result.toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
}
