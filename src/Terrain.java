import java.util.Random;

public class Terrain {
    private int[][] terrainArray;
    private int rows, cols;

    public Terrain (int x, int y) {
        rows = x;
        cols = y;
        terrainArray = new int[rows][cols];
    }

    public int generateTerrain(int percentageObstacles) {
        if (percentageObstacles < 0 || percentageObstacles > 100) return -1;
        Random rand = new Random();

        // calculate size of terrain
        int numCells = rows * cols;

        // calculate number of obstacles
        int numObstacles = numCells * percentageObstacles / 100;

        // set default terrain values
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                terrainArray[i][j] = 1;
            }
        }

        // generate obstacles
        for (int i = 0; i < numObstacles;) {
            int[] newObstacleCoords = {rand.nextInt(rows), rand.nextInt(cols)};
            if (terrainArray[newObstacleCoords[0]][newObstacleCoords[1]] == 0) continue;
            terrainArray[newObstacleCoords[0]][newObstacleCoords[1]] = 0;
            i++;
        }

        return 0;
    }

    public int revealCell (int row, int col) {
        int result;
        try {
            result = terrainArray[row][col];
        } catch(Exception e) {
            throw new ArrayIndexOutOfBoundsException("Bounds: (" + rows + ", " + cols + ") Index: (" + row + ", " + col + ")" );
        }
        return result;
    }
}