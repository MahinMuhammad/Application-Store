package classes;

import java.lang.*;
import java.text.DecimalFormat;

public class Game extends Program
{
    private DecimalFormat d = new DecimalFormat("#.##");
    private boolean controllerSupport;

    public Game()
    {
        System.out.println("e-g");
    }
    public Game(String name, String size, int totalDownloads, String ratedFor, String catagory, boolean controllerSupport, double price)
    {
        super(name, size, totalDownloads, ratedFor, catagory, price);
        System.out.println("p-g");
        this.controllerSupport = controllerSupport;
    }

    public void setControllerSupport()
    {
        this.controllerSupport = controllerSupport;
    }
    public boolean getControllerSupport()
    {
        return controllerSupport;
    }
    public void supportCheck()
    {
        if(controllerSupport)
        {
            System.out.println("Supported!");
        }
        else
        {
            System.out.println("Not Supported!");
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
        System.out.print("Controller Support : ");
        supportCheck();
    }
}
