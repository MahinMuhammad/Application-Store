import java.lang.*;
import classes.*;
import java.util.Scanner;
import java.io.*;
import fileio.*;

public class Start 
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        FileReadWriteDemo frwd = new FileReadWriteDemo();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(isr);

        ApplicationStore aps =new ApplicationStore();

        System.out.println("-------------------------------------------");
		System.out.println("\t\tM-Store");
        System.out.println("\t\t\t(Your daily appstore)");
		System.out.println("-------------------------------------------\n");

        boolean loop1 = true;

        while(loop1)
        {
            System.out.println("-------------------------------------------");
            System.out.println("\t\t Main Menu");
            System.out.println("-------------------------------------------");
			System.out.println("Choose your Action");
			System.out.println("\t1. Users' Section");
			System.out.println("\t2. Developers' Section");
			System.out.println("\t3. Programs' Section");
			System.out.println("\t4. Exit");

            System.out.print("Your Choice :");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    boolean loop2 = true;
                    while(loop2)
                    {
                        System.out.println("-------------------------------------------");
                        System.out.println("\t\tUsers' Section");
                        System.out.println("-------------------------------------------");
                        
                        System.out.println("It's Time To Choose Again:");
                        System.out.println("\t1. Sign Up New User");
                        System.out.println("\t2. Remove Existing User");
                        System.out.println("\t3. Search an User");
                        System.out.println("\t4. Show All User");
                        System.out.println("\t5. User Store Account Transactions");
                        System.out.println("\t6. Add A New Program To User Account");
                        System.out.println("\t7. Remove A Program From User Account");
                        System.out.println("\t8. Show All Programs Aded To User Account");
                        System.out.println("\t9. Go Back Main Menu");
                        
                        System.out.print("Your Choice: ");
                        int option1 = sc.nextInt();

                        switch(option1)
                        {   
                            case 1:

                                System.out.println("-------------------------------------------");
                                System.out.println("You have chose to Sign Up a New User");
                                System.out.println("-------------------------------------------");

                                String userMail = null;
                                String userPass = null;
                                double userBalance = 0;
                                System.out.print("Enter User Name :");
                                String userName = bfr.readLine();

                                boolean mailCheck = false;
                                while(!mailCheck)
                                {
                                    System.out.print("Enter User Email :");
                                    String userMail1 = sc.next();
                                    System.out.print("Confirm User Email :");
                                    String userMail2 = sc.next();
                                    if(userMail1.equals(userMail2))
                                    {
                                        userMail = userMail1;
                                        mailCheck = true;
                                    }
                                    else
                                    {
                                        System.out.println("Confirm The Email Correctly!");
                                    }
                                }

                                    boolean passCheck = false;
                                 while(!passCheck)
                                {
                                    System.out.print("Enter Password (at least 8 Characters long):");
                                    String userPass1 = sc.next();
                                    System.out.print("Confirm User Password :");
                                    String userPass2 = sc.next();
                                    if(userPass1.equals(userPass2) && userPass1.length() >= 8)
                                    {
                                        userPass = userPass1;
                                        passCheck = true;
                                    }
                                    else
                                    {
                                        System.out.println("Confirm The Password Correctly Make Sure It is Atleast 8 Characters long");
                                    }
                                }
                                

                                User us = null;
                                us = new User(userName, userMail, userPass, userBalance);

                                if(aps.signUpUser(us))
                                {
                                    System.out.println("User Sign Up Successful With Email : " + us.getEmail());
                                }
                                else 
                                {
                                    System.out.println("User Sign Up Failed With Email : " + us.getEmail());
                                }

                                break;

                            case 2:
                                System.out.println("-------------------------------------------");
                                System.out.println("You have chose to Remove an Existing User");
                                System.out.println("-------------------------------------------");

                                System.out.print("Enter User Email :");
                                userMail = sc.next();
                                System.out.print("Enter User Password :");
                                userPass = sc.next();
                                us = null;
                                us = aps.searchUser(userMail, userPass);

                                if(us != null)
                                {
                                    if(aps.removeUser(us))
                                    {
                                        System.out.println("User Successfully Removed With Email :" + us.getEmail());
                                    }
                                    else
                                    {
                                        System.out.println("User Romoval Faild With Email :" + us.getEmail());
                                    }
                                }
                                else 
                                {
                                    System.out.println("Wrong Email or Password!");
                                }
                                
                                break;

                            case 3:
                                System.out.println("-------------------------------------------");
                                System.out.println("You have chose to Search an Existing User");
                                System.out.println("-------------------------------------------");

                                System.out.print("Enter User Email :");
                                userMail = sc.next();
                                System.out.print("Enter User Password :");
                                userPass = sc.next();
                                us = null;
                                us = aps.searchUser(userMail, userPass);

                                if(us != null)
                                {
                                    System.out.println("User Found!");
                                    System.out.println();
                                    us.showDetails();
                                    System.out.println();
                                }
                                else
                                {
                                    System.out.println("Wrong Email or Password!");
                                }

                                break;

                            case 4:
                                System.out.println("-------------------------------------------");
							    System.out.println("You have chose to See All Users");
							    System.out.println("-------------------------------------------");

                                aps.showAllUsers();
                                
                                break;

                            case 5:
                                System.out.println("-------------------------------------------");
                                System.out.println("You have chose User Store Account Transactions");
                                System.out.println("-------------------------------------------");
                                
                                System.out.println("Choose from the options:");
					            System.out.println("\t1. Add Money To Your Store Account");
					            System.out.println("\t2. Show Transaction History");
					            System.out.println("\t3. Go Back");

                                System.out.print("Your option: ");
					            int option2 = sc.nextInt();

                                switch(option2)
                                {
                                    case 1:
                                        System.out.println("-------------------------------------------");
                                        System.out.println("You have chose to Add Money To Your Store Account");
                                        System.out.println("-------------------------------------------");

                                        System.out.print("Enter User Email :");
                                        userMail = sc.next();
                                        System.out.print("Enter User Password :");
                                        userPass = sc.next();
                                        us = null;
                                        us = aps.searchUser(userMail, userPass);

                                        if(us != null)
                                        {
                                            System.out.println("Previous Balance :" + us.getBalance());
                                            System.out.print("Enter The Amount :");
                                            double addM = sc.nextDouble();

                                            if(us.addMoney(addM))
                                            {
                                                System.out.println("Amount" + addM + "Successfully Added");
                                                String msg = null;
                                                msg = addM + "Added in" + us.getEmail();
                                                frwd.writeInFile(msg);
                                            }
                                            else
                                            {
                                                System.out.println("Failed To Add Money!");
                                            }
                                            System.out.println("Current Balance :" + us.getBalance());
                                        }
                                        else
                                        {
                                            System.out.println("Wrong Email or Password!");
                                        }

                                        break;

                                    case 2:
                                        System.out.println("-------------------------------------------");
                                        System.out.println("You have chose to See All Transactions");
                                        System.out.println("-------------------------------------------");

                                        frwd.readFromFile();

                                        break;

                                    case 3:
						
                                        System.out.println("-------------------------------------------");
                                        System.out.println("Going Back To User Section................");
                                        System.out.println("-------------------------------------------");
                                        break;
                                        
                                    default:
                                        
                                        System.out.println("-------------------------------------------");
                                        System.out.println("Invalid Option...............");
                                        System.out.println("-------------------------------------------");
                                        break;	
                                }

                                break;

                            case 6:
                                System.out.println("-------------------------------------------");
                                System.out.println("You have chose to add new program to your user account");
                                System.out.println("-------------------------------------------");

                                System.out.print("Enter email id :");
                                String mail = null;
                                mail = sc.next();
                                System.out.print("Enter password :");
                                String pass = null;
                                pass = sc.next();
                                us = null;

                                System.out.print("Full name of the program :");
                                String pName = null;
                                pName = bfr.readLine();

                                Program p = null;

                                if(aps.searchUser(mail, pass) != null)
                                {
                                    us = aps.searchUser(mail, pass);

                                    if(aps.searchProgramObj(pName) != null)
                                    {
                                        p = aps.searchProgramObj(pName);

                                        if(us.uploadProgram(p))
                                        {
                                            System.out.println("Program successfully uploaded in user account with email id " + us.getEmail() + ".....Program Name " + pName);
                                            System.out.println(p.getPrice() + " Taka has been deducted from balance.....User accout " + us.getEmail());
                                            String msg = null;
                                            msg = p.getPrice() + " Taka Spend from" + us.getEmail();
                                            frwd.writeInFile(msg);
                                        }

                                        else
                                        {
                                            System.out.println("Program Uploading failed!!.....Program Name " + pName);
                                        }
                                    }

                                    else
                                    {
                                        System.out.println("No program found with that name");
                                    } 
                                }

                                else
                                {
                                    System.out.println("Wrong User Email or Password");
                                }
                            
                                break;

                            case 7:
                                System.out.println("-------------------------------------------");
                                System.out.println("You have chose to remove a program from your user account");
                                System.out.println("-------------------------------------------");

                                System.out.print("Enter email id :");
                                mail = null;
                                mail = sc.next();
                                System.out.print("Enter password :");
                                pass = null;
                                pass = sc.next();
                                us = null;

                                System.out.print("Full name of the program :");
                                pName = null;
                                pName = bfr.readLine();

                                p = null;

                                if(aps.searchUser(mail, pass) != null)
                                {
                                    us = aps.searchUser(mail, pass);

                                    if(aps.searchProgramObj(pName) != null)
                                    {
                                        p = aps.searchProgramObj(pName);

                                        if(us.removeProgram(p))
                                        {
                                            System.out.println("Program successfully removed from user account with email id " + us.getEmail() + ".....Program Name " + pName);
                                        }

                                        else
                                        {
                                            System.out.println("Program removal failed!!.....Program Name " + pName);
                                        }
                                    }

                                    else
                                    {
                                        System.out.println("No program found with that name");
                                    }
                                }

                                else
                                {
                                    System.out.println("Wrong User Email or Password");
                                }

                                break;

                            case 8:
                                System.out.println("-------------------------------------------");
                                System.out.println("You have chose see all program added to your user account");
                                System.out.println("-------------------------------------------");

                                System.out.print("Enter email id :");
                                mail = null;
                                mail = sc.next();
                                System.out.print("Enter password :");
                                pass = null;
                                pass = sc.next();
                                us = null;

                                if(aps.searchUser(mail, pass) != null)
                                {
                                    us = aps.searchUser(mail,pass);
                                    us.showAllPrograms();
                                }

                                else
                                {
                                    System.out.println("Wrong User Email or Password");
                                }

                                break;

                            case 9:
                                System.out.println("-------------------------------------------");
                                System.out.println("Going Back To Main Menu................");
                                System.out.println("-------------------------------------------");
                                
                                loop2 = false;
                                
                                break;
                                
                            default:
                                
                                System.out.println("-------------------------------------------");
                                System.out.println("Invalid Option...............");
                                System.out.println("-------------------------------------------");
                                break;
                        }
                    }

                    break;

                case 2:
                    boolean loop3 = true;

                    while(loop3)
                    {
                        System.out.println("-------------------------------------------");
                        System.out.println("\t\tDevelopers' Section");
                        System.out.println("-------------------------------------------");
                        
                        System.out.println("It's Time To Choose Again:");
                        System.out.println("\t1. Register New Developer");
                        System.out.println("\t2. Remove Existing Developer");
                        System.out.println("\t3. Search a Developer");
                        System.out.println("\t4. Show All Developers");
                        System.out.println("\t5. Show All Programs of Developer");
                        System.out.println("\t6. Go Back To Main Menu");
                        
                        System.out.print("Your Choice: ");
                        int option3 = sc.nextInt();

                        switch(option3)
                        {
                            case 1:
                                System.out.println("-------------------------------------------");
							    System.out.println("You have chose to Register a New Developer");
							    System.out.println("-------------------------------------------");

                                String devName = null;
                                String devId = null; 
                                String  devMail = null;

                                System.out.print("Enter Developer Name :");
                                devName = bfr.readLine();
                                System.out.print("Enter Developer App Store Id :");
                                devId = sc.next();
                                System.out.print("Enter Developer Contact Email :");
                                devMail = sc.next();

                                Developer dev = new Developer(devName, devId, devMail);

                                if(aps.registerDeveloper(dev))
                                {
                                    System.out.println("Developer Registered with App Store Id :" + dev.getAppStoreId());
                                }
                                else
                                {
                                    System.out.println("Developer registration failed with App Store Id :" + dev.getAppStoreId());
                                }

                                break;

                            case 2:
						
                                System.out.println("-------------------------------------------");
                                System.out.println("You have chose to Remove an Existing Developer");
                                System.out.println("-------------------------------------------");
                                
                                System.out.print("Enter Developer App Store Id :");
                                devId = null;
                                devId = sc.next();
                                dev = null;
                                dev = aps.searchDeveloper(devId);

                                if(dev != null)
                                {
                                    if(aps.removeDeveloper(dev))
                                    {
                                        System.out.println("Developer Removed With App Store Id :" + dev.getAppStoreId());
                                    }
                                    else
                                    {
                                        System.out.println("Developer Removal Failed With App Store Id :" + dev.getAppStoreId());
                                    }
                                }
                                else 
                                {
                                    System.out.println("Develop not found with App Store Id" + devId);
                                }
                                
                                break;

                            case 3:
                                System.out.println("-------------------------------------------");
							    System.out.println("You have chose to Search an Existing Developer");
							    System.out.println("-------------------------------------------");
                                
                                System.out.print("Enter Developer App Store Id :");
                                devId = null;
                                devId = sc.next();
                                dev = null;
                                dev = aps.searchDeveloper(devId);
                                
                                if(dev != null)
                                {
                                    System.out.println("Developer Found!");
                                    System.out.println();
                                    dev.showDetails();
                                    System.out.println();
                                }
                                else 
                                {
                                    System.out.println("Developer Not Found With App Store Id :" + devId);
                                }

                                break;

                            case 4:
                                System.out.println("-------------------------------------------");
							    System.out.println("You have chose to See All Developers");
							    System.out.println("-------------------------------------------");

                                aps.showAllDevelopers();

                                break;
                            
                            case 5:
                                System.out.println("-------------------------------------------");
                                System.out.println("You have chose to See All Programs of a Developer");
                                System.out.println("-------------------------------------------");

                                System.out.print("Enter Developer App Store Id :");
                                devId = null;
                                devId = sc.next();
                                dev = null;
                                dev = aps.searchDeveloper(devId);

                                if(dev != null)
                                {
                                    dev.showAllPrograms();
                                }
                                else 
                                {
                                    System.out.println("Developer not Found with App Store Id :" + devId);
                                }

                                break;
                            
                            case 6:
                                System.out.println("-------------------------------------------");
                                System.out.println("Going Back To Main Menu................");
                                System.out.println("-------------------------------------------");
                            
                                loop3 = false;
                            
                                break;
                            
                            default:
                            
                                System.out.println("-------------------------------------------");
                                System.out.println("Invalid Option...............");
                                System.out.println("-------------------------------------------");

                                break;
                        }
                    }

                    break;

                case 3:
                    boolean loop4 = true;
                    while(loop4)
                    {
                        System.out.println("-------------------------------------------");
                        System.out.println("\t\tPrograms' Section");
                        System.out.println("-------------------------------------------");
                        
                        System.out.println("It's Time To Choose Again:");
                        System.out.println("\t1. Upload New Program");
                        System.out.println("\t2. Remove Existing Program");
                        System.out.println("\t3. Search a Program");
                        System.out.println("\t4. Show All Programs");
                        System.out.println("\t5. Sorted List Of Popular Programs");
                        System.out.println("\t6. Go Back Main Menu");
                        
                        System.out.print("Your Choice: ");
                        int option4 = sc.nextInt();

                        switch(option4)
                        {
                            case 1:
                                System.out.println("-------------------------------------------");
							    System.out.println("You have chose to Upload a New Program");
							    System.out.println("-------------------------------------------");

                                Program p = null;

                                System.out.println("Choose The Type of Program ");
							    System.out.println("\t 1. App");
							    System.out.println("\t 2. Game");
							    System.out.println("\t 3. Go Back");

                                System.out.print("Enter Your Choice :");
                                int typeChoice = sc.nextInt();

                                switch(typeChoice)
                                {
                                    case 1:
                                        System.out.println("-------------------------------------------");
                                        System.out.println("Uploading App..........");
                                        System.out.println("-------------------------------------------");

                                        System.out.print("Enter App Name :");
                                        String appName = bfr.readLine();
                                        System.out.print("Enter App Size :");
                                        String appSize = sc.next();
                                        System.out.print("Enter App Price :");
                                        double appPrice = sc.nextDouble();
                                        System.out.print("Enter Total Downloads :");
                                        int appTotalDownloads = sc.nextInt();
                                        System.out.print("Enter Catagory :");
                                        String appCatagory = sc.next();
                                        System.out.print("Rated For :");
                                        String appRatedFor = sc.next();
                                        System.out.print("Enter Background Run (true/false):");
                                        boolean backgroundRun = sc.nextBoolean();

                                        App app = new App(appName, appSize, appTotalDownloads, appRatedFor, appCatagory, backgroundRun, appPrice);

                                        p = app;

                                        break;

                                    case 2:
                                        System.out.println("-------------------------------------------");
                                        System.out.println("Uploading Game..........");
                                        System.out.println("-------------------------------------------");

                                        System.out.print("Enter Game Name :");
                                        String name = bfr.readLine();
                                        System.out.print("Enter App Size :");
                                        String size = sc.next();
                                        System.out.print("Enter App Price :");
                                        double price = sc.nextDouble();
                                        System.out.print("Enter Total Downloads :");
                                        int totalDownloads = sc.nextInt();
                                        System.out.print("Enter Catagory :");
                                        String catagory = sc.next();
                                        System.out.print("Rated For :");
                                        String ratedFor = sc.next();
                                        System.out.print("Enter Controller Supoort (true/false):");
                                        boolean controllerSupport = sc.nextBoolean();

                                        Game game = new Game(name, size, totalDownloads, ratedFor, catagory, controllerSupport, price);

                                        p = game;

                                        break;
                                    
                                    case 3:
                                        System.out.println("-------------------------------------------");
                                        System.out.println("Going Back To Program's Section................");
                                        System.out.println("-------------------------------------------");

                                        break;
                                    
                                    default :
                                        System.out.println("-------------------------------------------");
                                        System.out.println("\t\tInvalid Choice!");
                                        System.out.println("-------------------------------------------");

                                        break;
                                }

                                if(p != null)
                                {
                                    System.out.print("Enter developer App Store Id :");
                                    String devId = null;
                                    devId = sc.next();
                                    Developer dev = null;
                                    
                                    dev = aps.searchDeveloper(devId);
                                    
                                    if(dev != null)
                                    {
                                        if(dev.uploadProgram(p) && aps.uploadProgram(p))
                                        {
                                            System.out.println("Program Successfully Uploaded.....Name :" + p.getName() + " .....Developer App Store Id :" + dev.getAppStoreId());
                                        }
                                        else 
                                        {
                                            System.out.println("Failed To Upload Program.....Name :" + p.getName());
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Upload Failed.... No developer found!! (Choose an existing Developer)");
                                    }
                                }

                                break;

                            case 2:
                                System.out.println("-------------------------------------------");
							    System.out.println("You have chose to Remove an Existing Program");
							    System.out.println("-------------------------------------------");

                                System.out.print("Enter Program Name :");
                                String progName = null;
                                progName = bfr.readLine();

                                String devId = null;
                                System.out.print("Enter Developer App Store Id :");
                                devId = sc.next();

                                Program pApp = null;
                                Program pDev = null;
                                
                                pApp = aps.searchProgramObj(progName);

                                Developer dev = null;
                                dev = aps.searchDeveloper(devId);
                                
                                if(dev != null)
                                {
                                    pDev = dev.searchProgramObj(progName);
                                    if(pDev != null)
                                    {
                                        if(dev.removeProgram(pDev))
                                        {
                                            System.out.println("Program Successfully Removed From Developer Section......Name :" + pDev.getName());
                                        }
                                        else 
                                        {
                                            System.out.println("Program Removal Failed!......Name :" + progName);
                                        }
                                    }
                                    else 
                                    {
                                        System.out.println("Program Not Found For Developer with App Store Id :" + devId + ".......Program Name :" + progName);
                                    }
                                }
                                else 
                                {
                                    System.out.println("Developer Not Found With App Store Id :" + devId);
                                }
                                
                                if(pApp != null)
                                {
                                    if(aps.removeProgram(pApp))
                                    {
                                        System.out.println("Program Successfully Removed From Application Store......Name :" + pApp.getName());
                                    }
                                    else 
                                    {
                                        System.out.println("Program Removal Failed!......Name :" + progName);
                                    }
                                }

                                else 
                                {
                                    System.out.println("Program Not Found in Appilation Store.......Name :" + progName);
                                }

                                break;

                            case 3:
                                System.out.println("-------------------------------------------");
							    System.out.println("You have chose to Search a Program");
							    System.out.println("-------------------------------------------");

                                System.out.print("Enter Program Name :");
                                progName = null;
                                progName = sc.next();
                                
                                System.out.println("Search List :");
                                
                                if(!aps.searchProgram(progName))
                                {
                                    System.out.println("No Result For :" + progName);
                                }

                                break;

                            case 4:
                                System.out.println("-------------------------------------------");
							    System.out.println("You have chose to See All Programs");
							    System.out.println("-------------------------------------------");

                                aps.showAllPrograms();

                                break;

                            case 5: 
                                System.out.println("-------------------------------------------");
                                System.out.println("You have chose to See Sorted List Of Popular Programs");
                                System.out.println("-------------------------------------------");
                                
                                aps.sortingProgramWithPopularity();

                                break;

                            case 6:
                                System.out.println("-------------------------------------------");
                                System.out.println("Going Back To Main Menu................");
                                System.out.println("-------------------------------------------");
                            
                                loop4 = false;
                            
                                break;
                            
                            default:
                            
                                System.out.println("-------------------------------------------");
                                System.out.println("Invalid Option...............");
                                System.out.println("-------------------------------------------");

                                break;
                        }
                    }                    

                    break;

                case 4:
					System.out.println("-------------------------------------------");
					System.out.println("You have chose to Exit");
					System.out.println("-------------------------------------------");
					
					loop1 = false;
				
					break;
					
				default:
					System.out.println("-------------------------------------------");
					System.out.println("Invalid Choice...............");
					System.out.println("-------------------------------------------");
					break;

            }
        }
    }    
}
