import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {


    @Test
    public void shouldCorrectCreateUser() {
        User actual = new User();
        actual.setLogin(Constant.CORRECT_LOGIN);
        actual.setEmail(Constant.CORRECT_EMAIL);

        User expected = new User(Constant.CORRECT_LOGIN, Constant.CORRECT_EMAIL);
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
        assertThrows(IllegalArgumentException.class, () -> expected.setEmail(Constant.NO_CORRECT_EMAIL));
    }

    @Test
    public void shouldReturnErrorIfLoginIsNotCorrect() {
        User expected = new User();
        assertThrows(IllegalArgumentException.class, () -> expected.setLogin(Constant.EMPTY_LOGIN));
    }

    @Test
    public void shouldReturnErrorIfLoginEqualsEmail() {
        User expected = new User();
        expected.setEmail(Constant.CORRECT_EMAIL);
        assertThrows(IllegalArgumentException.class, () -> expected.setLogin(Constant.CORRECT_EMAIL));
    }

}