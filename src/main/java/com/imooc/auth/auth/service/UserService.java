package com.imooc.auth.auth.service;

import com.imooc.auth.auth.mapper.UserInfoMapper;
import com.imooc.auth.auth.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo findUserById(String id){
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
