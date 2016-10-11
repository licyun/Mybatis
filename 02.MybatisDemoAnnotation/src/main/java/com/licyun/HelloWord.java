package com.licyun;

import java.io.Reader;

import com.licyun.dao.IUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.licyun.model.User;

public class HelloWord {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("configure.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        sqlSessionFactory.getConfiguration().addMapper(IUser.class);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUser iuser = session.getMapper(IUser.class);
            User user = (User) iuser.getUserByID(1);
            if(user!=null){
                String userInfo = "名字："+user.getName()+", 所属部门："+user.getDept()+", 主页："+user.getWebsite();
                System.out.println(userInfo);
            }
        } finally {
            session.close();
        }
    }

}