package classes;

import java.lang.*;


import interfaces.*;

public class ApplicationStore implements DeveloperOperation, UserOperation, ProgramOperation
{
    private Developer developer[] = new Developer[100];
    private User user[] = new User[1000];
    private Program program[] = new Program[1000];

    public boolean signUpUser(User u)
    {
        boolean flag = false;
        for(int i=0; i<user.length; i++)
        {
            if(user[i]==null)
            {
                user[i] = u;
                flag = true;
                break;
            }
        }
        return flag;
    }
    
    public boolean removeUser(User u)
    {
        boolean flag = false;
        for(int i=0; i<user.length; i++)
        {
            if(user[i] != u)
            {
                user[i] = null;
                flag = true;
                break;
            }
        }
        return flag;
    } 

    public User searchUser(String email, String password)
    {
        User u = null;
        for(int i=0; i<user.length; i++)
        {
            if(user[i] != null)
            {
                if(user[i].getEmail().equals(email) && user[i].getPassword().equals(password))
                {
                    u = user[i];
                    break;
                }
            }
        }
        return u;
    }
    
    public void showAllUsers()
    {
        for(int i=0; i<user.length; i++)
        {
            if(user[i] != null)
            {
                user[i].showDetails();
                System.out.println();
            }
        }
    }

    public boolean registerDeveloper(Developer d)
    {
        boolean flag = false;
        for(int i=0; i<developer.length; i++)
        {
            if(developer[i] == null)
            {
                developer[i] = d;
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean removeDeveloper(Developer d)
    {
        boolean flag =false;
        for(int i=0; i<developer.length; i++)
        {
            if(developer[i] == d)
            {
                developer[i] = null;
                flag = true;
                break;
            }
        }
        return flag;
    }

    public Developer searchDeveloper(String appStoreId)
    {
        Developer d = null;
        for(int i=0; i<developer.length; i++)
        {
            if(developer[i] != null)
            {
                if(developer[i].getAppStoreId().equals(appStoreId))
                {
                    d = developer[i];
                    break;
                }
            }
        }
        return d;
    }

    public void showAllDevelopers()
    {
        for(int i=0; i<developer.length; i++)
        {
            if(developer[i] != null)
            {
                developer[i].showDetails();
                System.out.println();
                developer[i].showAllPrograms();
                System.out.println("____________________");
                
            }
        }
    }

    public boolean uploadProgram(Program a)
    {
        boolean flag = false;
        for(int i=0; i<program.length; i++)
        {
            if(program[i]==null)
            {
                program[i] = a;
                flag = true;
                break;
            }
        }
        return flag;
    } 

    public boolean removeProgram(Program a)
    {
        boolean flag = false;
        for(int i=0; i<program.length; i++)
        {
            if(program[i]==a)
            {
                program[i] = null;
                flag = true;
                break;
            }
        }
        return flag;
    }

    public Program searchProgramObj(String name)
    {
        Program p = null;
        for(int i=0; i<program.length; i++)
        {
            if(program[i] != null)
            {
                if(program[i].getName().equals(name))
            {
                p = program[i];
                break;
            } 
            }
        }
        return p;
    }

    public boolean searchProgram(String name)
    {
        boolean flag = false;
        for(int i=0; i<program.length; i++)
        {
            String ck = null;
            if(program[i] != null)
            {
                ck = program[i].getName().substring(0, name.length());
                ck = ck.toUpperCase();
                name = name.toUpperCase();
                if(ck.equals(name))
                {
                    program[i].showDetails();
                    System.out.println();
                    flag = true;
                } 
            }
        }
        return flag;
    }

    public void sortingProgramWithPopularity()
    {
        Program bubbleShortArr[] = new Program [program.length];
        for(int i=0; i<program.length; i++)
        {
            if(program[i] != null)
            {
                bubbleShortArr[i] = program[i];
            }
        }
        Program s = null; // extra object reference to help swap
        boolean sorted = false;
        while(!sorted)
        {
            sorted = true;
            for(int i=0; i<program.length-1; i++)
            {
                if(bubbleShortArr[i+1] != null)
                {
                    if(bubbleShortArr[i].getRecomendation() < bubbleShortArr[i+1].getRecomendation())
                    {
                        s = bubbleShortArr[i];
                        bubbleShortArr[i] = bubbleShortArr[i+1];
                        bubbleShortArr[i+1] = s;
                        sorted = false;
                    }
                }
            } 
        }
        for(int i=0; i<program.length; i++)
        {
            if(bubbleShortArr[i] != null)
            {
                bubbleShortArr[i].showDetails();
                System.out.println();
            }
        }
    }

    public void showAllPrograms()
    {
        for(int i=0; i<program.length; i++)
        {
            if(program[i]!=null)
            {
                program[i].showDetails();
                System.out.println();
            }
        }
    }

}


