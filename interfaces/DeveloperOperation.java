package interfaces;

import java.lang.*;
import classes.Developer;

public interface DeveloperOperation 
{
    boolean registerDeveloper(Developer d);
    boolean removeDeveloper(Developer d);
    Developer searchDeveloper(String appStoreId);
    void showAllDevelopers();
}
