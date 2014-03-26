
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ohtu.domain.User;
import org.springframework.stereotype.Component;


public class FileUserDao implements UserDao {
    private String fileName;
    private List<User> users;
    public FileUserDao(String fileName) {
        this.fileName = fileName;
        loadUsers();
    }
   
    private void loadUsers() {
        users = new ArrayList<>();
        File f = new File(fileName);
        try (Scanner scanner = new Scanner(f, "UTF-8")) {
            readFile(scanner);
        } catch (FileNotFoundException ex) {
            // do nothing
        }   
    }

    private void readFile(final Scanner scanner) {
        while (scanner.hasNext()) {
            String [] tokens = scanner.nextLine().split(" ");
            users.add(new User(tokens[0], tokens[1]));
        }
    }
   
    @Override
    public List<User> listAll() {
        return users;
    }
    

    @Override
    public User findByName(String name) {
        for (User u : users) {
            if (u.getUsername().equals(name)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        users.add(user);
        writeToFile(user);
    }

    private void writeToFile(User user) {
        File f = new File(fileName);
        
        try (OutputStream stream = new FileOutputStream(f, true)) {
            try (PrintWriter writer = new PrintWriter(stream)) {
                writer.println(user.getUsername() + " " + user.getPassword());
            }
        } catch (FileNotFoundException ex) {
            // do nothing
        } catch (IOException ex) {
            // javaaaaaaaaaa
        }
    }
}
