package com.atguigu.paymentdemo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PayType {
    /**
     * 微信
     */
    WXPAY("微信"),


    /**
     * 支付宝
     */
    ALIPAY("支付宝"),


    /**
     * 微信手机网站
     */
    WXMOBILEPAY("微信-手机"),


    /**
     * 支付宝手机网站
     */
    ALIMOBILEPAY("支付宝-手机");
    /**
     * 类型
     */
    private final String type;
}
