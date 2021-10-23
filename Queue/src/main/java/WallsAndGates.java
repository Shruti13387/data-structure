import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {

        if(rooms == null || rooms.length==0){
            return;
        }

        Queue<int[]> queue = new LinkedList();

        int row = rooms.length;
        int col = rooms[0].length;
        /**
         Step 1: Filtering  all the gates and add them to queue
         */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    int[] temp = {i, j};
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            if (x + 1 < row && rooms[x][y] != -1 && rooms[x][y] < rooms[x + 1][y]) {
                rooms[x + 1][y] = rooms[x][y] + 1;
                queue.offer(new int[]{x + 1,y});
            }
            if (x - 1 >= 0 && rooms[x][y] != -1 && rooms[x][y] < rooms[x - 1][y]) {
                rooms[x - 1][y] = rooms[x][y] + 1;
                queue.offer(new int[]{x - 1,y});
            }
            if (y + 1 < col && rooms[x][y] != -1 && rooms[x][y] < rooms[x][y + 1]) {
                rooms[x][y + 1] = rooms[x][y] + 1;
                queue.offer(new int[]{x,y + 1});
            }
            if (y - 1 >= 0 && rooms[x][y] != -1 && rooms[x][y] < rooms[x][y - 1]) {
                rooms[x][y - 1] = rooms[x][y] + 1;
                queue.offer(new int[]{x,y - 1});
            }
        }

    }
}
