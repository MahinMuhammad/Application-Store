package interfaces;

import java.lang.*;
import classes.Program;

public interface UserAccountOperation
{
	boolean ratings(String name, double rating);
	boolean addMoney(double amount);
	boolean spendMoney(Program a);
	boolean removeProgram(Program a);
	boolean uploadProgram(Program a);
	void showAllPrograms();
}