package classes;

import java.lang.*;
import interfaces.UserAccountOperation;

public class User implements UserAccountOperation
{
    private String name;
    private String email;
    private String password;
    private double balance;
    private boolean canRate = true;

    public User()
    {
        System.out.println("e-u");
    }
    public User(String name, String email, String password, double balance)
    {
        System.out.println("p-u");
        this.name = name;
        this.balance = balance;
        this.email = email;
        this.password = password;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPassord(String password)
    {
        this.password = password;
    }
    public void setbalance(double balance)
    {
        this.balance = balance;
    }

    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    String getPassword() //pacage-private to protect the password, so it can not be accessed from start class, which is outside of the package
    {
        return password;
    }
    public double getBalance()
    {
        return balance;
    }

    public void showDetails()
    {
        System.out.println("User Name :" + name);
        System.out.println("Email :" + email);
        System.out.println("Current Balance :" + balance);
    }

    public boolean addMoney(double amount)
    {
        if(amount>0)
        {
            balance = balance + amount;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean spendMoney(double amount)
    {
        if(amount>0 && amount<=balance)
        {
            balance = balance - amount;
            return true;
        }
        else
        {
            return false;
        }
    }


    // user's program collection section starts from here

    private Program program[] = new Program[100];
    private ApplicationStore app = new ApplicationStore();

    public boolean uploadProgram(Program a)
    {
        boolean flag = false;

        for(int i=0; i<program.length; i++)
        {
            if(program[i] == null)
            {
                if(spendMoney(a.getPrice()))
                {
                    program[i] = a;
                    flag = true;
                    break;
                }
                else
                {
                    System.out.println("Insufficient Balance!");
                }
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

    public boolean spendMoney(Program a)
    {
        boolean flag = false;
        double price = a.getPrice();
        double currentBalance = getBalance();
        if(price >= currentBalance)
        {
            double newBalance = currentBalance - price;
            setbalance(newBalance);
            flag = true;
        }
        return flag;       
    }

    public boolean ratings(String name, double rating)
    {
        boolean flag = false;
        if(canRate)
        {
            if(app.searchProgramObj(name) != null)
            {
                app.searchProgramObj(name).calulateRecomendation(rating);  
                this.canRate = false;
                flag = true;  
            }  
        }
        
        else
        {
            System.out.println("You can rate only once");
        }
        return flag; 
        
    }




















}
