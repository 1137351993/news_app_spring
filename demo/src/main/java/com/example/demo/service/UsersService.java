package com.example.demo.service;

import com.example.demo.dao.IUsersDao;
import com.example.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private IUsersDao iUsersDao;
    public Users login(String account, String password) {
        return iUsersDao.login(account, password);
    }

    public Users pull(String account) {
        return iUsersDao.pull(account);
    }

    public void sign_up(String account, String password, String user_name){
        iUsersDao.sign_up(account, password, user_name);}
}
