package cn.humou.Dao;

import cn.humou.Bean.User;
import cn.humou.Utils.Druiddemo1;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Userdao {

     //声明连接对象
    private JdbcTemplate template =  new JdbcTemplate(Druiddemo1.getDataSource());


    public User login(User loginuser){

        try {
            String sql = "select * from user where username = ? AND password = ?";
             User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class)
                    , loginuser.getUsername(), loginuser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }



    }
}
