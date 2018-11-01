package com.example.smc7050u01.shoppingcart.entity;

/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.entity
 * 文件名:  T_sales_yingye
 * 创建者： Steven Kun
 * 创建时间：2018/10/24
 * 描述：TODO
 */
public class T_sales_yingye {
    /**
     * ID	连编号
     * requestno	订单号	√
     * itemno	订单项号	√
     * ApprovedID	出荷指示号	√
     * model	型号	√
     * requestqty	数量	√
     * receivedate	理论入物流日	√
     * instrissuedate	接单日期	√	1
     * instrprinttime	生产日期	√	2
     * OperateTime	实际入物流日	√	3
     * zpqf	紫票区分
     * prodid	组装指示号
     * instrcanceldate	取消日期
     * processcode	本工序代码
     * 制部品区分	制部品区分	√
     * RevInstrProcCode	接收工序代码
     * 生产区分	生产区分
     */
    private String requestno;
    private String itemno;
    private int    ApprovedID;
    private String model;
    private String requestqty;
    private String instrissuedate;
    private String instrprinttime;
    private String OperateTime;
    private String 制部品区分;

}
