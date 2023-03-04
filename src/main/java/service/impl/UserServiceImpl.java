package service.impl;

import bean.User;
import dao.UserDao;
import org.apache.commons.lang3.StringUtils;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean checkUserExist(User user) {
        if (StringUtils.isEmpty(user.getName()) ||
                StringUtils.isEmpty(user.getLogin()) ||
                StringUtils.isEmpty(user.getEmail())) {
            throw new IllegalArgumentException("User not correct.");
        }
        List<User> userList = userDao.findAllUsers();
        return userList.contains(user);
    }
}
