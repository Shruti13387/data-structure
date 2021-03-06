import java.util.LinkedList;
import java.util.Queue;

public class BfsTraversal {

    public static void main( String args[] ) {
        Graph g= new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        g.printGraph();
        System.out.println(bfsTraversal(g));

        Graph g1 = new Graph(5);
        g1.addEdge(0,1);
        g1.addEdge(0,2);
        g1.addEdge(1,3);
        g1.addEdge(1,4);
        System.out.println("Graph1:");
        g1.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfsTraversal(g1));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfsTraversal(g2));
    }

    /**
     * Using Loop:
     * 1. Initialise one queue, boolean type array of length equal to vetex and result.
     * 2. if vertices < 1 return result.
     * 3. Traverse all the vertices.
     *      3.1. If vertex is not visited.
     *          3.1.1. Add vertex to queue and mark it visited
     *          3.1.2. Loop till either queue is not empty or adjacencyList is not null
     *              3.1.2.1. concat number in queue to result
     *              3.1.2.2. Loop till adjacent list size
     *                  3.1.2.2. If the node is node is not visited add it to queue and mark it visited.
     */
    private static String bfsTraversal(Graph graph){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.vertices];
        String result = new String();
        if(graph.vertices < 1){
            return result;
        }
        for(int vertex =0; vertex < graph.vertices; vertex++) {
            if(!visited[vertex]) {
                queue.add(vertex);
                visited[vertex] = true;
                while (!queue.isEmpty() && graph.adjacencyList[queue.peek()] != null) {
                    result = result + queue.peek();
                    LinkedList<Integer> adjacent = graph.adjacencyList[queue.poll()];
                    if (!adjacent.isEmpty()) {
                        for (int i = 0; i < adjacent.size(); i++) {
                            if (!visited[adjacent.get(i)]) {
                                queue.add(adjacent.get(i));
                                visited[adjacent.get(i)] = true;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
