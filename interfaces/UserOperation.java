package interfaces;

import java.lang.*;
import classes.User;
public interface UserOperation 
{
    boolean signUpUser(User u);
    boolean removeUser(User u);
    User searchUser(String email, String password);
    void showAllUsers();
}
