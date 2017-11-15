package cn.lucode;

import org.assertj.core.internal.Dates;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yunfeng.lu
 * @create 2017/10/24.
 */
@Component
public class Jobs {
    public final static long ONE_Minute = 100*5000;



    @Scheduled(fixedDelay=ONE_Minute)
    public void fixedDelayJob(){
        System.out.println(new SimpleDateFormat("yyyy-MMdd-HH:mm:ss").format(new Date()) +" >>fixedDelay执行....");
    }

    @Scheduled(fixedRate=ONE_Minute)
    public void fixedRateJob(){
        System.out.println(new SimpleDateFormat("yyyy-MMdd-HH:mm:ss").format(new Date())+" >>fixedRate执行....");
    }

    @Scheduled(cron="* * * * * ?")
    public void cronJob(){

            String s=new SimpleDateFormat("mm:ss").format(new Date());
            System.out.println(new SimpleDateFormat("yyyy-MMdd-HH:mm:ss").format(new Date())+" >>>"+s+"cron执行....");

            System.out.println(new SimpleDateFormat("yyyy-MMdd-HH:mm:ss").format(new Date())+" >>>"+s+"cron执行结束....");

    }
}
