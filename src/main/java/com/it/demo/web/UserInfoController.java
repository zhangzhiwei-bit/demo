package com.it.demo.web;

import javax.servlet.http.HttpServletRequest;

import com.it.demo.model.UserInfo;
import com.it.demo.service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserInfoController {
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/wxUserInfo")
    @ResponseBody
    public Object getUserInfo(HttpServletRequest request){
        String code=request.getParameter("code");
        String appid="自己的appid";
        String secret="自己从微信公众平台获取的secret key";
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code=" + code+"&grant_type=authorization_code";
        ResponseEntity <String> responseEntity=restTemplate.getForEntity(url, String.class);
        // System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }

    @RequestMapping("/getUserInfoByid")
    @ResponseBody
    public Object getUserInfoByid(HttpServletRequest request){
        String openid=request.getParameter("openid");
        UserInfo userInfo=userInfoService.getUserInfoByid(openid);
        if(userInfo!=null){
            return userInfo;
        }else{
            return null;
        }
    }
    @RequestMapping("/addUserInfo")
    @ResponseBody
    public Object addUserInfo(UserInfo userInfo){
        UserInfo temuUserInfo=userInfoService.getUserInfoByid(userInfo.getOpenid());
        if(temuUserInfo!=null){
            userInfoService.updateUserInfo(userInfo);
        }else{
            userInfoService.insertUserInfo(userInfo);
        }
        return "success";
    }
}
