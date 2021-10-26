import java.util.LinkedList;
import java.util.Queue;

public class PathExistBetweenTwoVertices {

    public static void main(String[] args) {
        Graph g1 = new Graph(9);
        g1.addEdge(0,2);
        g1.addEdge(0,5);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(5,3);
        g1.addEdge(5,6);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(6,8);
        g1.addEdge(6,4);
        g1.addEdge(7,8);
        g1.printGraph();
        System.out.println("Path exists: " + checkPath(g1, 0, 7));
        System.out.println();
        Graph g2 = new Graph(4);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(2,3);

        g2.printGraph();
        System.out.println("Path exists: " + checkPath(g2, 3, 0));
    }

    private static boolean checkPath(Graph graph, int source, int destination){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.vertices];
        boolean doesPathExist = false;
        if(graph.vertices < 1){
            return doesPathExist;
        }
        if(source==destination){
            return true;
        }
        for(int vertex =0; vertex < graph.vertices; vertex++) {
            if(vertex==source) {
                queue.add(vertex);
                visited[vertex] = true;
                while (!queue.isEmpty() && graph.adjacencyList[queue.peek()] != null && !doesPathExist) {
                    LinkedList<Integer> adjacent = graph.adjacencyList[queue.poll()];
                    if (!adjacent.isEmpty()) {
                        for (int i = 0; i < adjacent.size(); i++) {
                            if(adjacent.get(i)==destination) {
                                doesPathExist = true;
                                break;
                            }
                            if (!visited[adjacent.get(i)]) {
                                queue.add(adjacent.get(i));
                                visited[adjacent.get(i)] = true;
                            }
                        }
                    }
                }
            }
        }
        return doesPathExist;
    }
}
