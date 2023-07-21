package com.atguigu.paymentdemo.controller;

import com.atguigu.paymentdemo.service.WxPayService;
import com.atguigu.paymentdemo.util.HttpUtils;
import com.atguigu.paymentdemo.util.WechatPay2ValidatorForRequest;
import com.atguigu.paymentdemo.vo.R;
import com.google.gson.Gson;
import com.wechat.pay.contrib.apache.httpclient.auth.Verifier;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@CrossOrigin //跨域
@RestController
@RequestMapping("/api/wxh5-pay")
@Api(tags = "网站微信支付APIv3")
@Slf4j
public class WxH5PayController {

    @Resource
    private WxPayService wxPayService;

    /**
     * h5下单
     * @param request
     * @return
     */
    @ApiOperation("微信H5支付")
    @PostMapping("/h5Pay/{productId}")
    public R h5pay(HttpServletRequest request , @PathVariable Long productId) {
        log.info("发起支付请求");

        Map<String, Object> map = null;
        try {
            map = wxPayService.h5pay(productId, request);
        } catch (IOException e) {
            e.printStackTrace();
            new RuntimeException(e.getMessage());
        }
        return R.ok().setData(map);
    }

}
