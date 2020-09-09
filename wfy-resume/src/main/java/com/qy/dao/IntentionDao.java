package com.qy.dao;


import com.qy.pojo.resume.Intention;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface IntentionDao {
    List<Intention> findResuemByUserName(Integer uesr_id);
}
