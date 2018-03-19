package user_management;

import user_management.security.Password;

public class User {

    private int id;
    private String email;
    private String name;
    private Password password;

    public User() {}

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = new Password(password);
    }

    public User(int id, String name, String email, Password password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new Password(password);
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return getName() + " - " + getEmail();
    }

    @Override
    public boolean equals(Object obj) {
        User checkingUser = (User) obj;
        return checkingUser.getName().equals(this.getName()) && checkingUser.getEmail().equals(this.getEmail()) && checkingUser.getId() == this.getId();
    }

}
