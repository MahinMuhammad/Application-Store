package interfaces;

import java.lang.*;
import classes.Program;
public interface ProgramOperation 
{
    boolean uploadProgram(Program a);
    boolean removeProgram(Program a);
    boolean searchProgram(String name);
    Program searchProgramObj(String name);
    void sortingProgramWithPopularity();
    void showAllPrograms();
}
