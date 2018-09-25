package com.jt.database_monitoring.thread;

import com.jt.database_monitoring.monitor.MonitorService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by  2018/9/24.
 */
@Component
public class RunTaskJob {
  @Autowired
  MonitorService monitorService;
  private static long initTime = System.currentTimeMillis();
  private static int count = 0;

  @Scheduled(cron = "")
  public void run(){
    long nowTime = System.currentTimeMillis();
    long betweenDays = (long)((nowTime - initTime) / (1000 * 60 ));
    if(betweenDays>=30){
      count = 0;
    }else {
      count++;
    }
    monitorService.runMonitorService(count);
  }

}
