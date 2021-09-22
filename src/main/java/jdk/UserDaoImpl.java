package jdk;

import org.springframework.stereotype.Repository;

public class UserDaoImpl implements UserDao{
    @Override
    public void addUser() {
        System.out.println("添加新用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除新用户");
    }
}
