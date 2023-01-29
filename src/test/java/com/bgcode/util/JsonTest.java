package com.bgcode.util;

import com.alibaba.fastjson2.JSONArray;
import junit.framework.TestCase;

/**
 * @time : 2023/1/25 16
 * @author: bgcode
 */
public class JsonTest extends TestCase {

    public void testWrite() throws Exception {
        String a = NETconnect.getURLConnection("https://shayuapi.com/api.php/provide/vod/at/json/?ac=list");
        new Json();
        JSONArray a1 = Json.json(a, "class");
        for (Object o : a1) {
//
            String as = Json.json1(o.toString(), "type_id");
            String sad = Json.json1(o.toString(), "type_name");
            System.out.print(as + sad + "\n");
        }
    }
}