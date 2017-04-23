package com.dream9.biz.impl;

import com.github.pagehelper.PageHelper;
import com.dream9.biz.IUserInfoService;
import com.dream9.dao.mapper.UserInfoMapper;
import com.dream9.dao.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Created by dream9 on 2017/2/18.
 */

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll() {
        logger.info("查询用户信息 date:{}", new Date());
        return userInfoMapper.selectAll();
    }

    @Override
    public int addUser(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public List<UserInfo> findByPage(UserInfo userInfo) {

        if (userInfo.getPage() != null && userInfo.getRows() != null){
            PageHelper.startPage(userInfo.getPage(), userInfo.getRows());
        }

        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();

        return userInfoMapper.selectByExample(example);
    }


}
