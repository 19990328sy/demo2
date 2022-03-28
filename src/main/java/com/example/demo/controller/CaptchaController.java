package com.example.demo.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *功能描述
 * @author shaoyu
 * @date 2022/3/23
    * @param null
 * @return
 * @Description :
 */

@Controller
public class CaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    /*--------------获取验证码-------------*/
    @GetMapping(value = "/captcha", produces = "image/jpeg")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        // 定义response输出类型为image/jpeg
        response.setDateHeader("Expires", 0);
        // 设置http标准
        response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
        // 设置请求头
        response.addHeader("Cache-Control", "post-check=0,pre-check=0");
        response.setHeader("Pragma", "no-cache");
        // 响应返回的是image/jpeg类型
        response.setContentType("image/jpeg");


        /*--------------生成验证码-------------*/
        String text = defaultKaptcha.createText();  // 获取验证码文本内容
        System.out.println("验证码为" + text);
        // 将验证码文本内容放入session
        request.getSession().setAttribute("captcha", text);
        // 根据文本验证码内容创建图形验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            // 输出流输出文件格式为jpg
            ImageIO.write(image, "jpg", outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
