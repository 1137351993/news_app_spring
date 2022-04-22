package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttentionDao {
    void push(@Param("id") String id, @Param("account") String source, @Param("package_id") int package_id);
}
