package activity;

import java.util.HashMap;

/**
 * Created by qupengcheng on 2018/10/12.
 */

public class Test {
    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("a","111");
        map.put("b","222");
        map.put("c","333");

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("d",map);

        System.out.print(hashMap.toString());
    }
}
