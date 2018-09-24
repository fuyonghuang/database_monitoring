package com.jt.database_monitoring.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by  2018/9/24.
 */
@Component
public class MonitorService {
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Value("")
  private String sqlStr;
  @Value("")
  private long presetTime;



  public void runMonitorService(int count){
    long startTime = System.currentTimeMillis();
    jdbcTemplate.execute(sqlStr);
    long endTime = System.currentTimeMillis();
    long l = startTime - endTime;
    if(l<=presetTime&&count<=2){


    }

  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i <2000000000 ; i++) {
      if(i==20000){
        System.out.println("fasdf");
      }
    }
    long endTime = System.currentTimeMillis();
    long l = endTime-startTime ;
    System.out.println(l);
  }

}
