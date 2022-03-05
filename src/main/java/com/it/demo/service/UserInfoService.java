package com.it.demo.service;

import com.it.demo.model.UserInfo;

public interface UserInfoService {
    UserInfo getUserInfoByid(String openid);
    Integer insertUserInfo(UserInfo userInfo);
    Integer updateUserInfo(UserInfo userInfo);
}
