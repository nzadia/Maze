
/**
 * Write a description of class MazeDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class MazeDriver
{
    public static void main(String[] args){

        Scanner sc= new Scanner(System.in); 

        String filename;
        boolean hasFile= true;
        do{
            hasFile = true;
            System.out.println("What is the name of the file?"); 
            filename=sc.nextLine(); 
            try{
                Maze m = new Maze(filename);
                m.parseFile();
                m.solveMaze();
            }
            catch(FileNotFoundException e){
                System.out.println("File Not Found");
                hasFile = false;
            }
        }while (hasFile != true); 

    }
}
