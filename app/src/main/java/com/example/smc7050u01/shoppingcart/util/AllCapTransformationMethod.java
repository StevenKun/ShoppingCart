package com.example.smc7050u01.shoppingcart.util;

import android.text.method.ReplacementTransformationMethod;

/**
 * 项目名： ShoppingCart 包名：com.example.smc7050u01.shoppingcart.util 文件名:  AllCapTransformationMethod 创建者： Steven Kun 创建时间：2018/11/12 描述：TODO
 */
public class AllCapTransformationMethod extends ReplacementTransformationMethod {
    private char[]  lower    = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[]  upper    = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private boolean allUpper = false;

    public AllCapTransformationMethod(boolean needUpper) {
        this.allUpper = needUpper;
    }

    @Override
    protected char[] getOriginal() {
        if (allUpper)
            return lower;
        else
            return upper;
    }

    @Override
    protected char[] getReplacement() {
        if (allUpper)
            return upper;
        else
            return lower;
    }
}