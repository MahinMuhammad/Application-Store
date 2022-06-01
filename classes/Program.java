package classes;

import java.lang.*;
import interfaces.IRecomendation;
public abstract class Program implements IRecomendation
{
    protected String name;
    protected String size;
    protected int totalDownloads;
    protected String catagory;
    protected String ratedFor; //minimum age recomendation
    protected double price;
    protected double recomendation;
    protected double totalRecomendation;
    protected double numberOfRatings;

    public Program()
    {
        System.out.println("e-P");
    }
    public Program(String name, String size, int totalDownloads, String ratedFor, String catagory, double price)
    {
        System.out.println("p-P");
        this.name = name;
        this.size = size;
        this.totalDownloads = totalDownloads;
        this.ratedFor = ratedFor;
        this.catagory = catagory;
        if(price>=0)
        {
            this.price = price; 
        }
        else
        {
            System.out.println("Wrong input for Price!");
        }
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setSize(String size)
    {
        this.size = size;
    }
    public void setTotalDownloads(int totalDownloads)
    {
        this.totalDownloads = totalDownloads;
    }
    public void setRatedFor(String ratedFor)
    {
        this.ratedFor = ratedFor;
    }
    public void setCatagory()
    {
        this.catagory = catagory;
    }
    public void setPrice()
    {
        if(price>=0)
        {
            this.price = price; 
        }
        else
        {
            System.out.println("Wrong input for Price!");
        }
    }
    public void setRecomendation(double recomendation)
    {
        this.recomendation = recomendation;
    }

    public String getName()
    {
        return name;
    }
    public String getSize()
    {
        return size;
    }
    public int getTotalDownloads()
    {
        return totalDownloads;
    }
    public String getRatedFor()
    {
        return ratedFor;
    }
    public String getCatagory()
    {
        return catagory;
    }
    public double getPrice()
    {
        return price;
    }

    public double getRecomendation()
    {
        return recomendation;
    }

    public abstract void showDetails();

    public void calulateRecomendation(double rating)
    {
        numberOfRatings++;
        totalRecomendation = totalRecomendation + rating;
        recomendation = totalRecomendation/numberOfRatings;
    }
}
