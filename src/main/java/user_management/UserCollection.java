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

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException {
        User userToReturn = null;
        for (User user : this) {
            if (user.getEmail().equals(email)) {
                userToReturn = user;
            }
        }
        if (userToReturn.getPassword().matches(password)) {
            return userToReturn;
        }
        System.out.println("Invalid username or password");
        throw new UserAuthenticationFailedException();
    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException, PasswordTooSimpleException, InvalidEmailException {
        int id = 0;
        boolean ableToCreateAccount = false;
        for (User user : this) {
            if (!user.getEmail().equals(email)) {
                ableToCreateAccount = true;
            }
        }
        if (passwordGood(password)) {
            ableToCreateAccount = true;
        } else if (!passwordGood(password)) {
            ableToCreateAccount = false;
        }
        if (emailGood(email)) {
            ableToCreateAccount = true;
        } else if (!emailGood(email)) {
            ableToCreateAccount = false;
        }
        if (ableToCreateAccount) {
            this.add(new User(this.size(), name, email, password));
            id = this.size();
            return id;
        }
        if (!emailGood(email)) {
            throw new InvalidEmailException();
        }
        if (!passwordGood(password)) {
            throw new PasswordTooSimpleException();
        }
        throw new EmailNotAvailableException();
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
