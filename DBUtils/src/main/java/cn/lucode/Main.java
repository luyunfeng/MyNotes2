package cn.lucode;

import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.ds.DSFactory;
import cn.hutool.db.handler.EntityHandler;
import cn.hutool.db.sql.SqlExecutor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yunfeng.lu
 * @create 2018/1/22.
 */
public class Main {

    public static void main(String[] args) {
        DataSource ds = DSFactory.get();
        System.out.println("开始创建");
        Connection conn = null;
        
        String sql="SELECT" +
                "  runtime_info_id," +
                "st_name," +
                "up_down," +
                "line_no," +
                "substring_index( GROUP_CONCAT( depart_time ORDER BY next_day DESC, depart_time DESC ), ',', 1 ) end_time," +
                "substring_index( GROUP_CONCAT( depart_time ORDER BY next_day ASC, depart_time ASC ), ',', 1 ) start_time " +
                "FROM" +
                "t_runtime_info WHERE " +
                "plan_type = (SELECT plan_type FROM t_line_plan WHERE " +
                "line_no = '03/04' AND WEEKDAY( exec_date ) = WEEKDAY( '20180122' )" +
                "AND exec_date <= '20180122' ORDER BY exec_date DESC LIMIT 1)" +
                "AND st_name = '石龙路'" +
                "AND line_no = '03/04'" +
                "group by line_no,up_down;";
        try {
            conn = ds.getConnection();

            Object entityList = SqlExecutor.query(conn, sql, new EntityHandler());
            System.out.println(entityList);


        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DbUtil.close(conn);
        }
    }
}
