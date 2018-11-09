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
    private String RevInstrProcCode;

    public String getRequestno() {
        return requestno;
    }

    public void setRequestno(String requestno) {
        this.requestno = requestno;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public int getApprovedID() {
        return ApprovedID;
    }

    public void setApprovedID(int approvedID) {
        ApprovedID = approvedID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRequestqty() {
        return requestqty;
    }

    public void setRequestqty(String requestqty) {
        this.requestqty = requestqty;
    }

    public String getInstrissuedate() {
        return instrissuedate;
    }

    public void setInstrissuedate(String instrissuedate) {
        this.instrissuedate = instrissuedate;
    }

    public String getInstrprinttime() {
        return instrprinttime;
    }

    public void setInstrprinttime(String instrprinttime) {
        this.instrprinttime = instrprinttime;
    }

    public String getOperateTime() {
        return OperateTime;
    }

    public void setOperateTime(String operateTime) {
        OperateTime = operateTime;
    }

    public String get制部品区分() {
        return 制部品区分;
    }

    public void set制部品区分(String 制部品区分) {
        this.制部品区分 = 制部品区分;
    }

    public String getRevInstrProcCode() {
        return RevInstrProcCode;
    }

    public void setRevInstrProcCode(String revInstrProcCode) {
        RevInstrProcCode = revInstrProcCode;
    }
}
