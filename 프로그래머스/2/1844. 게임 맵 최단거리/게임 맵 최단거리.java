import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int solution(int[][] maps) {
        int answer = 0;
        bfs(0, 0, maps.length, maps[0].length, maps);
        answer = maps[maps.length-1][maps[0].length-1] == 1 ? -1 : maps[maps.length-1][maps[0].length-1];
        return answer;
    }
    private void bfs(int row, int col, int n, int m, int[][] map) {
    //최단거리는 bfs
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
                if (map[nx][ny] != 0) {
                    if(map[nx][ny] == 1) {
                        map[nx][ny] = map[x][y] + 1;
                        queue.add(new Node(nx, ny));
                    }
                    else if (map[x][y] + 1 < map[nx][ny]) {
                        map[nx][ny] = map[x][y] + 1;
                        queue.add(new Node(nx, ny));
                    }   
                    
                }
            }
        }
    }
    
}
class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
}