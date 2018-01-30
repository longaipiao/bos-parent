package com.cock.bos.service;

import com.cock.bos.domain.User;

public interface IUserService {
    User login(User mModel);

    void editPassword(String id, String password);
}
