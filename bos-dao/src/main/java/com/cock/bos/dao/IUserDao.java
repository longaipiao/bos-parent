package com.cock.bos.dao;

import com.cock.bos.dao.base.IBaseDao;
import com.cock.bos.domain.User;

public interface IUserDao extends IBaseDao<User> {

    User findUserByUsernameAndPassword(String username, String password);

}
