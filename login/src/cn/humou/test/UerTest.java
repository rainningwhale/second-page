package cn.humou.test;

import cn.humou.Bean.User;
import cn.humou.Dao.Userdao;
import org.junit.Test;

import static sun.security.jgss.GSSUtil.login;

public class UerTest {


    @Test
    public void Usertest(){

        User loginuser = new User();
        loginuser.setUsername("humou");
        loginuser.setPassword("12345");

        Userdao userdao = new Userdao();
        User user = userdao.login(loginuser);

        
        System.out.println(user);


    }
}
