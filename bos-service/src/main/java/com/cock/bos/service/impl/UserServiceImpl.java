package com.cock.bos.service.impl;

import com.cock.bos.dao.IUserDao;
import com.cock.bos.domain.User;
import com.cock.bos.service.IUserService;
import com.cock.bos.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    /***
     * 用户登录
     */
    @Override
    public User login(User user) {
        //使用MD5加密密码
        String password = MD5Utils.md5(user.getPassword());
        return userDao.findUserByUsernameAndPassword(user.getUsername(), password);
    }

    /**
     * 根据用户id修改密码
     */
    @Override
    public void editPassword(String id, String password) {
        //使用MD5加密密码
        password = MD5Utils.md5(password);
        userDao.executeUpdate("user.editpassword", password, id);
    }
}
