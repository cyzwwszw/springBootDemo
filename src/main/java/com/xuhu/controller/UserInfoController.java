package com.xuhu.controller;

import com.xuhu.biz.IUserInfoService;
import com.xuhu.dao.model.UserInfo;
import com.xuhu.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xuhu on 2017/2/18.
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;


    @RequestMapping("/getAll")
    public List<UserInfo> getAll(){
        List<UserInfo> userInfos = userInfoService.findAll();
        return userInfos;
//        return null;
    }

    @GetMapping("addUser/{name}/{age}")
    public String add(@PathVariable("name") String name, @PathVariable("age") Integer age){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(IDUtil.UUID());
        userInfo.setName(name);
        userInfo.setAge(age);

        userInfoService.addUser(userInfo);

        return "SUCCESS";
    }

    @GetMapping("/getByPage/{page}")
    public List<UserInfo> getByPage(@PathVariable("page") Integer page){
        UserInfo userInfo = new UserInfo();
        userInfo.setPage(page);
        return userInfoService.findByPage(userInfo);
    }
}
