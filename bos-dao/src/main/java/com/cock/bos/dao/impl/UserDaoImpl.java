package com.cock.bos.dao.impl;

import com.cock.bos.dao.IUserDao;
import com.cock.bos.dao.base.impl.BaseDaoImpl;
import com.cock.bos.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

    /**
     * 根据用户名和密码查询用户
     */
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username, password);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
