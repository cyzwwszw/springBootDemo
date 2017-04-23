package com.dream9.biz;

import com.dream9.dao.model.UserInfo;

import java.util.List;

/**
 * Created by dream9 on 2017/2/18.
 */
public interface IUserInfoService {

    List<UserInfo> findAll();

    int addUser(UserInfo userInfo);

    List<UserInfo> findByPage(UserInfo userInfo);
}
