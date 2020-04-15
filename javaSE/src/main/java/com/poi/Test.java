package com.poi;


import java.io.File;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;

public class Test {
    public static void main(String[] args) {
        String proceRet = "SO201907121089info.wms.outbound.hardAllocation.false";
        proceRet = null;
        proceRet = proceRet == null ? null : proceRet.substring(14);
        System.out.println(proceRet);

    }
}
