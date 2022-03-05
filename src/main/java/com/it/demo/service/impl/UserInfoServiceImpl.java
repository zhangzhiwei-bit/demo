package com.it.demo.service.impl;

import com.it.demo.mapper.UserInfoMapper;
import com.it.demo.model.UserInfo;
import com.it.demo.service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService{


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoByid(String openid) {
        return userInfoMapper.getUserInfoByid(openid);
    }

    @Override
    public Integer insertUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertUserInfo(userInfo);
        
    }

    @Override
    public Integer updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }
}
