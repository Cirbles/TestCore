package com.test.core.request;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class ReadJson {
    //读取json文件
    public static JSONObject readJsonFile() {
        String jsonStr = "";
        try {
            File jsonFile = new File("src/main/resources/common/userInfo.json");
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return JSONObject.parseObject(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(ReadJson.readJsonFile().toJSONString());
    }
}
