package user_management;

import user_management.security.Password;

public class User {

    private String email;
    private int id;
    private String name;
    private String password;

    public User() {}

    public User(String email, int id, String name, String password) {
        this.email = email;
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return getName() + " - " + getEmail();
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

}
