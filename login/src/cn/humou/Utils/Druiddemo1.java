package cn.humou.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Druiddemo1 {


//        private static DataSource ds;
        private static DataSource ds;

        static{





        //加载配置文件
            try {
        Properties pro = new Properties();


        InputStream is = Druiddemo1.class.getClassLoader().getResourceAsStream("druid.properties");

            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        public static DataSource getDataSource(){
            return ds;
        }
    }

