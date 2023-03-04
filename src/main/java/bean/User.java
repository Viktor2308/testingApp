package bean;

import java.util.Objects;

public class User {

    private String name;
    private String login;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String login, String email) {

        if (!Objects.equals(login, email)) {
            setLogin(login);
            setEmail(email);
        } else {
            throw new IllegalArgumentException("User is not correct");
        }
    }

    public User(String name, String login, String email) {
        setName(name);
        if (!Objects.equals(login, email)) {
            setLogin(login);
            setEmail(email);
        } else {
            throw new IllegalArgumentException("User is not correct");
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (!Objects.equals(login, this.email) && !login.isEmpty()) {
            this.login = login;
        } else {
            throw new IllegalArgumentException("No correct login.");
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("No correct email.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(login, user.login) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, login, email);
    }
}
