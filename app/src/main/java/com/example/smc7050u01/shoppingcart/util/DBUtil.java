package com.example.smc7050u01.shoppingcart.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;


public class DBUtil {

    private static String IP     = "10.116.0.75";
    private static String DBName = "现场生产计划数据";
    private static String USER   = "likun";
    private static String PWD    = "q1w2e3r4";

    private static Connection        conn = null;
    private static Statement         stmt = null;
    private static PreparedStatement ps   = null;


    private static Connection getSQLConnection() {
        Connection con = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IP + ":1433/" + DBName + ";useunicode=true;characterEncoding=UTF-8", USER, PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    /**
     * 根据订单编号和订单项号查询
     *
     * @param id
     * @param item_id
     * @return
     */
    public static String querybyid(String id, String item_id) {
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
                    "      ,配品时间\n" +
                    "  FROM [现场生产计划数据].[dbo].[T_sales_yingye]" +
                    "where requestno=? and itemno=?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, item_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s1 = rs.getString("requestno");
                String s2 = rs.getString("itemno");
                String s3 = rs.getString("ApprovedID");
                String s4 = rs.getString("requestqty");
                String s5 = rs.getString("receivedate");
                String s6 = rs.getString("instrissuedate");//接单
                String s7 = rs.getString("instrprinttime");//打印
                String s8 = rs.getString("instrcanceldate");
                String s9 = rs.getString("OperateTime");//入库
                String s10 = rs.getString("生产区分");
                String s11 = rs.getString("model");
                String s12 =rs.getString("配品时间");

                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm");

                if (s9!=null){
                    s9 =sdf.format(Timestamp.valueOf(s9).getTime());
                }
                if (s6!=null){
                    s6=sdf.format(Timestamp.valueOf(s6).getTime());
                }
                if (s7!=null){
                    s7=sdf.format(Timestamp.valueOf(s7).getTime());
                }
                if (s12!=null){
                    s12=sdf.format(Timestamp.valueOf(s12).getTime());
                }
                if (s8!=null){
                    s8=sdf.format(Timestamp.valueOf(s8).getTime());
                }
                if (s5!=null){
                    s5=sdf.format(Timestamp.valueOf(s5).getTime());
                }

                result += " 出荷指示号 :" + s3 + "\n"
                        + " 型号 : " + s11 + "\n"
                        + " 数量 : " + s4 + "\n"
                        + " 生产区分 :" + s10 + "\n"
                        + " 接单日期 :" + s6 + "\n"
                        + " 生产准备日期（打印):" + s7 + "\n"
                        + " 配品时间 :" + s12 + "\n"
                        + " 取消日期 :" + s8 + "\n"
                        + " 实际入物流日 :" + s9 + "\n"
                        + " 理论入物流日 :" + s5 + "\n"
                        + " \n";
            }
            ps.close();
            closeConnect();
        } catch (SQLException e) {
            e.printStackTrace();
            result += "查询数据异常!" + e.getMessage();
        }

        return result;
    }

    /**
     * 根据订单编号查询
     *
     * @param id
     * @return
     */
    public static String QueryALL(String id) {
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
                    "      ,配品时间\n" +
                    "  FROM [现场生产计划数据].[dbo].[T_sales_yingye]" +
                    "  where requestno=? ;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String s1 = rs.getString("requestno");
                String s2 = rs.getString("itemno");
                String s3 = rs.getString("ApprovedID");
                String s4 = rs.getString("requestqty");
                String s5 = rs.getString("receivedate");
                String s6 = rs.getString("instrissuedate");//接单
                String s7 = rs.getString("instrprinttime");//打印
                String s8 = rs.getString("instrcanceldate");
                String s9 = rs.getString("OperateTime");//入库
                String s10 = rs.getString("生产区分");
                String s11 = rs.getString("model");
                String s12 =rs.getString("配品时间");

                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm");

                if (s9!=null){
                    s9 =sdf.format(Timestamp.valueOf(s9).getTime());
                }
                if (s6!=null){
                    s6=sdf.format(Timestamp.valueOf(s6).getTime());
                }
                if (s7!=null){
                    s7=sdf.format(Timestamp.valueOf(s7).getTime());
                }
                if (s12!=null){
                    s12=sdf.format(Timestamp.valueOf(s12).getTime());
                }
                if (s8!=null){
                    s8=sdf.format(Timestamp.valueOf(s8).getTime());
                }
                if (s5!=null){
                    s5=sdf.format(Timestamp.valueOf(s5).getTime());
                }
                result += " 订单项号: " + s2 + "\n"
                        + " 出荷指示号: " + s3 + "\n"
                        + " 生产区分 :" + s10 + "\n"
                        + " 型号 : " + s11 + "\n"
                        + " 数量 : " + s4 + "\n"
                        + " 接单日期 : " + s6 + "\n"
                        + " 生产准备日期（打印):" + s7 + "\n"
                        + " 配品时间 : " + s12 + "\n"
                        + " 取消日期 :" + s8 + "\n"
                        + " 实际入物流日 :" + s9 + "\n"
                        + " 理论入物流日 :" + s5 + "\n"
                        + " ________________________"+"\n"
                        + " \n";
            }
            ps.close();
            closeConnect();

        } catch (SQLException e) {
            e.printStackTrace();
            result += "查询数据异常!" + e.getMessage();
        }
        return result;
    }

    public static String Query_ApprovedID(String id) {
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
                    "      ,cast([OperateTime] as smalldatetime) as [OperateTime]\n" +
                    "      ,配品时间\n" +
                    "  FROM [现场生产计划数据].[dbo].[T_sales_yingye]" +
                    "  where ApprovedID=?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String s1 = rs.getString("requestno");
                String s2 = rs.getString("itemno");
                String s3 = rs.getString("ApprovedID");
                String s4 = rs.getString("requestqty");
                String s5 = rs.getString("receivedate");
                String s6 = rs.getString("instrissuedate");//接单
                String s7 = rs.getString("instrprinttime");//打印
                String s8 = rs.getString("instrcanceldate");
                String s9 = rs.getString("OperateTime");//入库
                String s10 = rs.getString("生产区分");
                String s11 = rs.getString("model");
                String s12 =rs.getString("配品时间");

                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm");

                if (s9!=null){
                   s9 =sdf.format(Timestamp.valueOf(s9).getTime());
                }
                if (s6!=null){
                    s6=sdf.format(Timestamp.valueOf(s6).getTime());
                }
                if (s7!=null){
                    s7=sdf.format(Timestamp.valueOf(s7).getTime());
                }
                if (s12!=null){
                    s12=sdf.format(Timestamp.valueOf(s12).getTime());
                }
                if (s8!=null){
                    s8=sdf.format(Timestamp.valueOf(s8).getTime());
                }
                if (s5!=null){
                    s5=sdf.format(Timestamp.valueOf(s5).getTime());
                }



                //String s7=sdf.format(s7s.getTime());
                //String s8=sdf.format(s8s.getTime());
                //String s9=sdf.format(s9s.getTime());

                result += " 订单编号 ：" + s1 + "\n"
                        + " 订单项号 ：" + s2 + "\n"
                        + " 生产区分 :" + s10 + "\n"
                        + " 型号 :" + s11 + "\n"
                        + " 数量 :" + s4 + "\n"
                        + " 接单日期 :" + s6 + "\n"
                        + " 生产准备日期（打印):" + s7 + "\n"
                        + " 配品时间 :" + s12 + "\n"
                        + " 取消日期 :" + s8 + "\n"
                        + " 实际入物流日 :" + s9 + "\n"
                        + " 理论入物流日 :" + s5 + "\n"
                        + " \n";
            }
            ps.close();
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