package classes;

import java.lang.*;
import interfaces.ProgramOperation;

public class Developer implements ProgramOperation
{
    private String name;
    private String appStoreId;
    private String contactEmail;
    private Program program[] = new Program[100];
    
    public Developer()
    {
        System.out.println("e-d");
    }

    public Developer(String name, String appStoreId, String contactEmail)
    {
        this.appStoreId = appStoreId;
        this.contactEmail = contactEmail;
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setAppStoreId(String appStoreId)
    {
        this.appStoreId = appStoreId;
    }
    public void setContactEmail(String contactEmail)
    {
        this.contactEmail = contactEmail;
    }

    public String getName()
    {
        return name;
    }
    public String getAppStoreId()
    {
        return appStoreId;
    }
    public String getContactEmail()
    {
        return contactEmail;
    }

    public void showDetails()
    {
        System.out.println("Developer Name :" + name);
        System.out.println("App Store Id :" + appStoreId);
        System.out.println("Contact Email :" + contactEmail);
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
            bubbleShortArr[i] = program[i];
        }
        Program s; // extra object reference to help swap
        boolean sorted = false;
        while(!sorted)
        {
            sorted = true;
            for(int i=0; i<program.length-1; i++)
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
        for(int i=0; i<program.length; i++)
        {
            if(bubbleShortArr[i] != null)
            {
                bubbleShortArr[i].showDetails();
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
