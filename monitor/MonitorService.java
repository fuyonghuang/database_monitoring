package com.jt.database_monitoring.monitor;

import java.util.List;
import java.util.Map;
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

  @Value("${sql.sqlStr}")
  private String sqlStr;
  @Value("${sql.presetTime}")
  private long presetTime;
  @Value("${sms.username}")
  private String username;
  @Value("${sms.password}")
  private String password;
  @Value("${sms.url}")
  private static String url;

  public void runMonitorService(int count){
    long startTime = System.currentTimeMillis();
    List<Map<String, Object>> maps = jdbcTemplate.queryForList(sqlStr);
    System.out.println(maps.iterator());
    long endTime = System.currentTimeMillis();
    long l = startTime - endTime;
    if(l<=presetTime&&count<=2){
      System.out.println("asdfsd");

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
