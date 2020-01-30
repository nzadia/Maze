import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze
{
    private char[][] mazeArray;
    private int rows, cols, startRow, startCol, endRow, endCol;
    private File source;
    private Scanner scan;
    private LocationQueue lq;

    public Maze(String source) throws FileNotFoundException{
        this.source = new File(source);
       
        scan = new Scanner(this.source);
                
        lq = new LocationQueue(); 
    }

    public void parseFile(){
        rows = scan.nextInt();
        cols = scan.nextInt();
        startRow = scan.nextInt();
        startCol = scan.nextInt();
        endRow = scan.nextInt();
        endCol = scan.nextInt();

        mazeArray = new char[rows][cols];

        char[] lineArray;
        String line;

        scan.nextLine();

        for(int i = 0; i < rows; i++){
            line =  scan.nextLine();
            lineArray = line.toCharArray();
            for(int j = 0; j < cols; j++ ){
                mazeArray[i][j] = lineArray[j];
            }
        }

    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public int getStartRow(){
        return startRow;
    }

    public int getEndRow(){
        return endRow;
    }

    public int getEndCol(){
        return endCol;
    }

    public void printMaze(){
        for(int row=0;row<mazeArray.length;row++){
            for(int col=0;col<mazeArray[row].length;col++){
                System.out.print(mazeArray[row][col]);
            }
            System.out.println();
        }
    }

    public void solveMaze(){
        Location current = new Location(startRow, startCol);
        Location end =  new Location(endRow, endCol);
        Location temp;
        int tempRow;
        int tempCol;
        char up;
        char down;
        char left;
        char right;

        lq.insert(current);

        while(!lq.isEmpty()){
            temp = lq.remove();
            tempRow = temp.getRow();
            tempCol = temp.getCol();
            
            mazeArray[tempRow][tempCol] = '.';

            if(temp.getRow() == endRow && temp.getCol() == endCol){
                break;
            }

            if(tempRow+1 < rows){
                down = mazeArray[tempRow+1][tempCol];
                if(down == ' '){
                    lq.insert(new Location(tempRow+1,tempCol));
                }
            }
            if(tempRow-1 >= 0){
                up = mazeArray[tempRow-1][tempCol];
                if(up == ' '){

                    lq.insert(new Location(tempRow-1,tempCol));
                }
            }
            if(tempCol-1 >= 0){
                left = mazeArray[tempRow][tempCol-1];
                if(left == ' '){

                    lq.insert(new Location(tempRow,tempCol-1));
                }
            }
            if(tempCol+1 < cols){
                right = mazeArray[tempRow][tempCol+1];
                if(right == ' '){

                    lq.insert(new Location(tempRow,tempCol+1));
                }
            }

        }
        printMaze();

    }

}
