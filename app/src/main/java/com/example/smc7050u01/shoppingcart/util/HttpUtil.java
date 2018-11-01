package com.example.smc7050u01.shoppingcart.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.util
 * 文件名:  HttpUtil
 * 创建者： Steven Kun
 * 创建时间：2018/10/30
 * 描述：TODO okhttp3的工具类
 */
public class HttpUtil {
    public static String sendHttpRequest(String address){
        HttpURLConnection connection=null;
        try {
            URL url =new URL(address);
            connection=(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            InputStream in =connection.getInputStream();
            BufferedReader reader =new BufferedReader(new InputStreamReader(in));
            StringBuilder response=new StringBuilder();
            String line;
            while ((line =reader.readLine()) !=null){
                response.append(line);
            }
            return response.toString();


        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }finally {
            if (connection !=null){
                connection.disconnect();
            }
        }
    }
}
