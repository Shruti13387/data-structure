import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    char[][] rooms;
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length==0){
            return 0;
        }
        rooms = grid;
        Queue<int[]> queue = new LinkedList();

        int row = rooms.length;
        int col = rooms[0].length;
        int island=0;
        /**
         Step 1: Filtering  all the gates and add them to queue
         */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == '1') {
                    island++;
                    queue.offer(new int[] {i, j});
                    rooms[i][j]='v';
                    countIsland(queue,row,col);
                }
            }
        }
        return island;
    }

    private void countIsland(Queue<int[]> queue, int row, int col){

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            if (x + 1 < row && rooms[x+1][y] == '1') {
                rooms[x + 1][y] = 'v';
                queue.offer(new int[]{x + 1,y});
            }
            if (x - 1 >= 0 && rooms[x-1][y] == '1') {
                rooms[x - 1][y] = 'v';
                queue.offer(new int[]{x - 1,y});
            }
            if (y + 1 < col && rooms[x][y+1] == '1') {
                rooms[x][y + 1] = 'v';
                queue.offer(new int[]{x,y + 1});
            }
            if (y - 1 >= 0 && rooms[x][y-1]  == '1') {
                rooms[x][y - 1] = 'v';
                queue.offer(new int[]{x,y - 1});
            }
        }
    }
}
