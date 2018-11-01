package com.example.smc7050u01.shoppingcart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
    private static String IP = "10.116.0.75";
    private static String DBName = "现场生产计划数据";
    private static String USER = "likun";
    private static String PWD = "q1w2e3r4";


    private static Connection conn = null;
    private static Statement stmt = null;



    private static Connection getSQLConnection() {
        Connection con=null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IP + ":1433/" + DBName + ";useunicode=true;characterEncoding=UTF-8", USER, PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static String querybyid(String id,String item_id){
        String result = "";
        try {
            if (conn == null) {
                conn = getSQLConnection();
            }
            String sql = "SELECT  [requestno]\n" +
                    "      ,[ApprovedID]\n" +
                    "      ,[itemno]\n" +
                    "      ,[model]\n" +
                    "      ,[requestqty]\n" +
                    "      ,[receivedate]\n" +
                    "      ,[instrissuedate]\n" +
                    "      ,[instrprinttime]\n" +
                    "      ,[instrcanceldate]\n" +
                    "      ,[制部品区分]\n" +
                    "      ,[生产区分]\n" +
                    "      ,[OperateTime]\n" +
                    "  FROM [现场生产计划数据].[dbo].[T_sales_yingye]"+
                    "where requestno=? and itemno=?;";

            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, item_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s1 = rs.getString("requestno");
                String s2 = rs.getString("itemno");
                String s3 =rs.getString("ApprovedID");
                String s4 =rs.getString("requestqty");
                String s5 =rs.getString("receivedate");
                String s6 =rs.getString("instrissuedate");//接单
                String s7 =rs.getString("instrprinttime");//打印
                String s8 =rs.getString("instrcanceldate");
                String s9 =rs.getString("OperateTime");//入库
                String s10 =rs.getString("生产区分");
                String s11 = rs.getString("model");
                result += "  出荷指示号 :"+s3 + "\n "
                          +" 型号 :"+s11 + "\n "
                          +" 数量 :"+s4 + "\n "
                          +" 理论入物流日 :"+s5 + "\n "
                          +" 接单日期 :"+s6 + "\n "
                          +" 打印日期 :"+s7 + "\n "
                          +" 取消日期 :"+s8 + "\n "
                          +" 实际入物流日 :"+s9 + "\n "
                          +" 生产区分 :"+s10 + "\n "
                          +" \n";
            }
            ps.close();
            closeConnect();
        } catch (SQLException e) {
            e.printStackTrace();
            result += "查询数据异常!" + e.getMessage();
        }

     return  result;
    }

    public static String QueryALL() {
        String result = "";
        try {
            if (conn == null) {
                conn = getSQLConnection();
                stmt = conn.createStatement();
            }
            String sql = "select * from testTable";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String s1 = rs.getString("id");
                String s2 = rs.getString("name");
                String s3 =rs.getString("Depart");
                result += "|"+s1 + " | " + s2+"   |   "  +  s3+"|"+"\n";
            }

            closeConnect();

        } catch (SQLException e) {
            e.printStackTrace();
            result += "查询数据异常!" + e.getMessage();
        }
        return result;
    }

    public static String QueryById(String id) {
        String result = "";
        try {
            if (conn == null) {
                conn = getSQLConnection();
                stmt = conn.createStatement();
            }
            String sql =
                    "SELECT TOP 1000 [id]\n" +
                    "      ,[name]\n" +
                    "      ,[password]\n" +
                    "  FROM [testDemo].[dbo].[userInfo]\n" +
                    "  where id=?;";
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();;
            while (rs.next()) {
                String s1 = rs.getString("id");
                String s2 = rs.getString("name");
                String s3 =rs.getString("password");
                result += s1 + "               " + s2+"               " +  s3+"\n";
            }
            closeConnect();

        } catch (SQLException e) {
            e.printStackTrace();
            result += "查询数据异常!" + e.getMessage();
        }
        return result;
    }

    public static void closeConnect() {


        if (stmt != null) {
            try {
                stmt.close();
                stmt = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}