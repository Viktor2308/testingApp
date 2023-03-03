package dao.impl;

import bean.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class UserDaoImplTest {

    private final UserDaoImpl out = new UserDaoImpl();

    @Test
    void shouldReturnUserGetUserByName() {
        User actual = new User("Nike", "NikeNike", "Nike_Nike@mail.com");

        User expected = out.getUserByName(ConstantDaoTest.CORRECT_NAME_NIKE);

        assertEquals(actual, expected);

    }

    @Test
    void shouldReturnNullGetUserByName() {

        User expected = out.getUserByName(ConstantDaoTest.NO_CORRECT_NAME);

        assertNull(expected);

    }

    @Test
    void shouldReturnIllegalArgumentExceptionGetUserByName() {

        assertThrows(IllegalArgumentException.class, () -> out.getUserByName(ConstantDaoTest.EMPTY_NAME));

    }

    @Test
    void shouldReturnListFindAllUsers() {
        List<User> actualArrayList = new ArrayList<>();
        actualArrayList.add(new User("Vasya", "Vasya2023", "Vasya@mail.com"));
        actualArrayList.add(new User("John", "John", "John2008@mail.com"));
        actualArrayList.add(new User("Nike", "NikeNike", "Nike_Nike@mail.com"));
        actualArrayList.add(new User("Anna", "AnnaM", "Anna_2013@mail.com"));

        assertEquals(actualArrayList, out.findAllUsers());

    }


}