package dfs.mazeSolver;

public class App {

    // this is for square matrix only which means number of rows = number of columns
    // for no. of rows != no. of columns.... make changes in the program

    public static void main(String[] args) {
        FileReader fileReader = new FileReader("C:\\Users\\amana\\IdeaProjects\\Advanced Algorithms(Graph)\\src\\dfs\\mazeSolver\\map.txt", 5, 5);
        fileReader.parseFile();
        MazeSolver mazeSolver = new MazeSolver(fileReader.getMap(), fileReader.getStartPositionRow(), fileReader.getStartPositionColumn());
        mazeSolver.findWayOut();
    }
}
