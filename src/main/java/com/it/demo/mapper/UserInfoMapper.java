package com.it.demo.mapper;

import com.it.demo.model.UserInfo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    UserInfo getUserInfoByid(String openid);
    Integer insertUserInfo(UserInfo userInfo);
    Integer updateUserInfo(UserInfo userInfo);
}
