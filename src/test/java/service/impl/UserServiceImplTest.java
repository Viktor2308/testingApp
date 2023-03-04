package service.impl;

import bean.User;
import dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {


    @Mock
    private UserDao userDaoMock;

    @InjectMocks
    private UserServiceImpl out;

    private User emptyNameUser;
    List<User> actualArrayList;

    @BeforeEach
    public void setUp() {
        User correctUser = new User(
                ConstantUserService.USER_CORRECT_NAME_NIKE,
                ConstantUserService.USER_CORRECT_LOGIN_NIKE,
                ConstantUserService.USER_CORRECT_EMAIL_NIKE);
        emptyNameUser = new User(
                ConstantUserService.USER_EMPTY_NAME,
                ConstantUserService.USER_CORRECT_LOGIN_NIKE,
                ConstantUserService.USER_CORRECT_EMAIL_NIKE);
        actualArrayList = new ArrayList<>();
        actualArrayList.add(correctUser);
    }

    @Test
    void shouldReturnTrueCheckUserExist() {

        when(userDaoMock.findAllUsers())
                .thenReturn(actualArrayList);

        User expectedUser = new User(
                ConstantUserService.USER_CORRECT_NAME_NIKE,
                ConstantUserService.USER_CORRECT_LOGIN_NIKE,
                ConstantUserService.USER_CORRECT_EMAIL_NIKE);

        assertTrue(out.checkUserExist(expectedUser));
    }


    @Test
    public void shouldReturnFalseCheckUserExist() {

        when(userDaoMock.findAllUsers())
                .thenReturn(actualArrayList);

        User expectedUser = new User(
                ConstantUserService.USER_NO_CORRECT_NAME,
                ConstantUserService.USER_CORRECT_LOGIN_NIKE,
                ConstantUserService.USER_CORRECT_EMAIL_NIKE);

        assertFalse(out.checkUserExist(expectedUser));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionCheckUserExist() {
        assertThrows(IllegalArgumentException.class, () -> out.checkUserExist(emptyNameUser));
    }
}