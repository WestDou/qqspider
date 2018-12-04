package com.zc.spider.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zc.spider.pojo.Msg;

@Repository
public interface CrawlDao extends JpaRepository<Msg, Long>{

}
