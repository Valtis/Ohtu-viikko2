package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    
    // "Some people, when confronted with a problem, think "I know, 
    // I'll use regular expressions." Now they have two problems."
    private boolean invalid(String username, String password) {
        
        if (username.length() < 3) {
            return true;
        }
        
        if (!hasOnlyLowerCaseLetters(username))  {
            return true;
        }
        
        if (password.length() < 8) {
            return true;
        }
        
        if (!hasNumberOrSpecialCharacter(password)) {
            return true;
        }
              
        return false;
    }

    private boolean hasOnlyLowerCaseLetters(String username) {
        return username.matches("[a-z]*");
    }

    private boolean hasNumberOrSpecialCharacter(String password) {
        return password.matches(".*\\d.*") || password.matches(".*\\W.*");
    }
}
