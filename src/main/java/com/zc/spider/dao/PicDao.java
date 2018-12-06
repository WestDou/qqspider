package com.zc.spider.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zc.spider.pojo.Pic;

@Repository
public interface PicDao extends JpaRepository<Pic,Long>{

}
