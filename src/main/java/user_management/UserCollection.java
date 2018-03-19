package user_management;

import user_management.security.Password;
import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.util.ArrayList;

public class UserCollection extends ArrayList<User>{

    public User findById(int id) {
        for (User user : this) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        for (User user : this) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) {
        try {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getEmail().equals(email) && this.get(i).getPassword().equals(Password.hashPassword(password))) {
                    return this.get(i);
                }
            }
            throw new UserAuthenticationFailedException();
        } catch (UserAuthenticationFailedException e) {
            System.out.println("Incorrect email or password");
        }
        return null;
    }

    public int createUser(String name, String email, String password) {
        boolean ableToCreateAccount = true;
        try {
            for (User user : this) {
                if (user.getEmail().equals(email)) {
                    throw new EmailNotAvailableException();
                }
            }
            if (!passwordGood(password)) {
                throw new PasswordTooSimpleException();
            }
            if (!emailGood(email)) {
                throw new InvalidEmailException();
            }
        } catch (EmailNotAvailableException | PasswordTooSimpleException | InvalidEmailException e) {
            ableToCreateAccount = false;
            System.out.println("No can do my dude");
        }
        if (ableToCreateAccount) {
            this.add(new User(this.size(), name, email, password));
            return this.size();
        } else return 0;
    }

    private boolean passwordGood(String password){
        String regex = "(^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$)";
        return password.matches(regex);
    }

    private boolean emailGood(String email){
        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        return email.matches(regex);
    }

}
