package com.example.demo.dao;

import com.example.demo.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersDao {
    Users login(@Param("account") String account, @Param("password") String password);

    Users pull(@Param("account") String account);

    void sign_up(@Param("account") String account, @Param("password") String password, @Param("user_name") String user_name);
}
