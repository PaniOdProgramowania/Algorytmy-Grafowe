package pl.paniodprogramowania.graph;

public class Graph {

  /**
   *           (4)
   *       2 ------,
   *   (9) |       | (4)
   *       |       |
   *       |  (1)  |   (9)
   *       3 ----- 4 ----- 5
   *       |       |       |
   *       |       | (2)   | (2)
   *       |       |       |
   *       '-----  6 ----- 1
   *     (10)         (3)
   *
   */
  public static int[][] returnChallengeGraph(){
    int n = 6;
    int[][] graph = new int[n][n];
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        graph[i][j] = 0;
      }
    }
    graph[0][4] = 2;
    graph[0][5] = 3;
    graph[1][2] = 9;
    graph[1][3] = 0;
    graph[2][1] = 9;
    graph[2][3] = 1;
    graph[2][5] = 10;
    graph[3][1] = 4;
    graph[3][2] = 1;
    graph[3][4] = 9;
    graph[3][5] = 2;
    graph[4][0] = 2;
    graph[4][3] = 9;
    graph[5][0] = 3;
    graph[5][2] = 10;
    graph[5][3] = 2;
    return graph;
  }

  /**
   *             (10)
   *       0 ----------> 4
   *      | \            ^
   * (5)  |  \  (45)     |  (25)
   *      |   \_______,  |
   *      v           \  |
   *      1 --> 2 -->  ->3
   *       (20)   (1)
   */
  public static int[][] returnCities(){
    int n = 5;
    int[][] graph = new int[n][n];
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++) {
        graph[i][j] = 0;
      }
    }
    graph[0][1]=5;
    graph[0][3]=45;
    graph[0][4]=10;
    graph[1][2]=20;
    graph[2][3] =1;
    return graph;
  }

  /**
   *                  0
   *               /     \
   *             /        \
   *           /           \
   *         /              \
   *       1                2
   *     /   \            /  \
   *    3     4         5      6
   *   / \   /  \     / \     / \
   *  7  8  9   10  11  12  13  14
   *
   *
   **/

  public static int[][] returnTree(){
    int n = 15;
    int[][] graph = new int[n][n];
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        graph[i][j] = 0;
      }
    }
    graph[0][1] = 1;
    graph[0][2] = 1;
    graph[1][0] = 1;
    graph[1][3] = 1;
    graph[1][4] = 1;
    graph[2][0] = 1;
    graph[2][5] = 10;
    graph[2][6] = 1;
    graph[3][1] = 1;
    graph[3][7] = 1;
    graph[3][8] = 1;
    graph[4][1] = 1;
    graph[4][9] = 1;
    graph[4][10] = 1;
    graph[7][3] = 1;
    graph[8][3] = 1;
    graph[9][4] = 1;
    graph[10][4] = 1;
    graph[5][2] = 1;
    graph[5][11] = 1;
    graph[5][12] = 1;
    graph[6][2] = 1;
    graph[6][13] = 1;
    graph[6][14] = 1;
    graph[11][5] = 1;
    graph[12][5] = 1;
    graph[13][6] = 1;
    graph[14][6] = 1;
    return graph;
  }

  public static void printGraph(int[][] graph){
    for (int[] row : graph) {
      for (int value : row) {
        System.out.print("["+value+"] ");
      }
      System.out.println();
    }
  }

}
