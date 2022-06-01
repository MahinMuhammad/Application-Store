package classes;

import java.lang.*;
import java.text.DecimalFormat;

public class App extends Program
{
    private DecimalFormat d = new DecimalFormat("#.##");

    private boolean backgroundRun;
    
    public App()
    {
        System.out.println("e-a");
    }
    
    public App(String name, String size, int totalDownloads, String ratedFor, String catagory, boolean backgroundRun, double price)
    {
        super(name, size, totalDownloads, ratedFor, catagory, price);
        System.out.println("p-a");
        this.backgroundRun = backgroundRun;
    }

    public void setBackgroundRun(Boolean backgroundRun)
    {
        this.backgroundRun = backgroundRun;
    }

    public boolean getBackgroundRun()
    {
        return backgroundRun;
    }

    public void backgroundCheck()
    {
        if(backgroundRun)
        {
            System.out.println("Runs in background");
        }
        else
        {
            System.out.println("Does not run in background");
        }
    }

    public void showDetails()
    {
        System.out.println("Name :" + name);
        System.out.println("Size :" + size);
        if(getPrice()>0)
        {
            System.out.println("Price :Bdt " + getPrice());
        }
        else
        {
            System.out.println("Free");
        }
        System.out.println("Total Downloads :" + totalDownloads);
        System.out.println("Rated for :" + ratedFor);
        System.out.println("Catagory :" + catagory);
        System.out.println("Recomendation :" + d.format(getRecomendation()) + " out of 10");
        System.out.println("Background activity : ");
        backgroundCheck();
    }
}
