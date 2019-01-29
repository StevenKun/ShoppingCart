package com.example.smc7050u01.shoppingcart.util;


import java.sql.Connection;
import java.sql.DriverManager;


/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.util
 * 文件名:  JDBCUtils
 * 创建者： Steven Kun
 * 创建时间：2018/11/29
 * 描述：TODO
 */
public class JDBCUtils {

        private static String IP = "10.116.0.75";
        private static String DBName = "现场生产计划数据";
        private static String USER = "likun";
        private static String PWD = "q1w2e3r4";
        private static String DRIVER="net.sourceforge.jtds.jdbc.Driver";
        private static String URL="jdbc:jtds:sqlserver://" + IP + ":1433/" + DBName + ";useunicode=true;characterEncoding=UTF-8";

        /**
         * 获得连接
         */
        public static Connection getConnection() {
            try {
                // 1 注册驱动
                Class.forName(DRIVER);
                // 2 获得连接
                Connection conn = DriverManager.getConnection(URL, USER, PWD);
                return conn;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


}
