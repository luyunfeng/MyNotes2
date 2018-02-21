package cn.metro;

import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.ds.DSFactory;
import cn.hutool.db.handler.EntityHandler;
import cn.hutool.db.sql.SqlExecutor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yunfeng.lu
 * @create 2018/1/22.
 */
public class Main {

    public static void main(String[] args) {
        DataSource ds = DSFactory.get();

        Connection conn = null;
        try {
            conn = ds.getConnection();
            String TABLE_NAME="t_runtime_info";
            Entity entityList = SqlExecutor.query(conn, "select * from " + TABLE_NAME + " where runtime_info_id = ?", new EntityHandler(), "100337");
            System.out.println(entityList);



        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DbUtil.close(conn);
        }
    }
}
