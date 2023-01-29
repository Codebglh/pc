package com.bgcode.pac;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import org.junit.Test;

/**
 * @time : 2023/1/25 12
 * @author: bgcode
 */
public class jsoup {
    @Test
    public void sda() {
//        String str = "{\"id\":123}";
//        JSONObject jsonObject = JSON.parseObject(str);
//        int id = jsonObject.getIntValue("id");
        String str1 = "[\"id\", 123]";
        JSONArray jsonArray = JSON.parseArray(str1);
        String name = jsonArray.getString(0);
        int id1 = jsonArray.getIntValue(1);
        System.out.println(id1);
    }
}
