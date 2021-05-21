package com.test.core.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;

public class CommonLogin {
    public static Response login() throws IOException {
        JSONObject jsonObject = ReadJson.readJsonFile();
        JSONObject path = (JSONObject) jsonObject.get("path");
        String requestPath = path.get("domain").toString()+path.get("api").toString();
        JSONObject header = (JSONObject) path.get("header");

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse(header.get("Content-Type").toString());
        RequestBody body = RequestBody.create(mediaType, path.get("body").toString());
        Request request = new Request.Builder()
                .url(requestPath)
                .method("POST", body)
                .addHeader("Content-Type", header.get("Content-Type").toString())
                .addHeader("charset", header.get("charset").toString())
                .build();
        Response response = client.newCall(request).execute();
        return response;

    }

    public static void main(String[] args) throws IOException {
        Response response = CommonLogin.login();
        System.out.println(JSON.toJSON(response.body().string()));
    }

}
