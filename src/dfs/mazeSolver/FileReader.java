package dfs.mazeSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private int[][] map;
    private String filename;
    private int numOfRows;
    private int numOfColumns;
    private int startPositionRow;       //the start index of the 2 "start point" rowIndex
    private int startPositionColumn;    //the start index of the 2 "start point" colIndex

    public FileReader(String filename, int numOfRows, int numOfColumns) {
        this.filename = filename;
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.map = new int[numOfRows][numOfColumns];
    }

    public void parseFile(){
        try{
            Scanner scanner = new Scanner(new File(this.filename));

            for(int i=0; i<this.numOfRows; i++){
                for(int j=0; j<this.numOfColumns; j++){
                    map[i][j] = scanner.nextInt();  //read the integers from the file

                    if(map[i][j] == 2){     //found the 2 soo save the row and col index
                        startPositionRow = i;
                        startPositionColumn = j;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int[][] getMap() {
        return map;
    }

    public int getStartPositionRow() {
        return startPositionRow;
    }

    public int getStartPositionColumn() {
        return startPositionColumn;
    }
}
