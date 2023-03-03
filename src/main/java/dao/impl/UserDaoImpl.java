package dao.impl;


import bean.User;
import dao.UserDao;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    private final List<User> userArrayList = new ArrayList<>();

       public UserDaoImpl() {
        userArrayList.add(new User("Vasya", "Vasya2023", "Vasya@mail.com"));
        userArrayList.add(new User("John", "John", "John2008@mail.com"));
        userArrayList.add(new User("Nike", "NikeNike", "Nike_Nike@mail.com"));
        userArrayList.add(new User("Anna", "AnnaM", "Anna_2013@mail.com"));
    }

    @Override
    public User getUserByName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Name is not correct.");
        }
        for (User user : userArrayList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return userArrayList;
    }
}
