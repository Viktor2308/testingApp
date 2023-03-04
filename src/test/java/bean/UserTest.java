package bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {


    @Test
    public void shouldCorrectCreateUser() {
        User actual = new User();
        actual.setLogin(ConstantUserTest.CORRECT_LOGIN);
        actual.setEmail(ConstantUserTest.CORRECT_EMAIL);


        User expected = new User(ConstantUserTest.CORRECT_LOGIN, ConstantUserTest.CORRECT_EMAIL);
        assertEquals(expected, actual);

    }

    @Test
    public void shouldCreateDefaultUser() {
        User expected = new User();
        assertNotNull(expected);
        assertNull(expected.getEmail());
        assertNull(expected.getLogin());
    }

    @Test
    public void shouldReturnErrorIfEmailIsNotCorrect() {
        User expected = new User();
        assertThrows(IllegalArgumentException.class, () -> expected.setEmail(ConstantUserTest.NO_CORRECT_EMAIL));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionIfLoginIsNotCorrect() {
        User expected = new User();
        assertThrows(IllegalArgumentException.class, () -> expected.setLogin(ConstantUserTest.EMPTY_LOGIN));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionIfLoginEqualsEmail() {
        User expected = new User();
        expected.setEmail(ConstantUserTest.CORRECT_EMAIL);
        assertThrows(IllegalArgumentException.class, () -> expected.setLogin(ConstantUserTest.CORRECT_EMAIL));
    }

}