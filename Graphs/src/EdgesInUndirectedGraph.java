import java.util.LinkedList;
import java.util.Queue;

public class EdgesInUndirectedGraph {
    public static void main( String args[] ) {
        Graph g= new Graph(4);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(1, 3);
        g.addUndirectedEdge(2, 3);

        g.printGraph();
        System.out.println("No. of edges: "+numEdges(g));

        Graph g1 = new Graph(9);
        g1.addUndirectedEdge(0,2);
        g1.addUndirectedEdge(0,5);
        g1.addUndirectedEdge(2,3);
        g1.addUndirectedEdge(2,4);
        g1.addUndirectedEdge(5,3);
        g1.addUndirectedEdge(5,6);
        g1.addUndirectedEdge(3,6);
        g1.addUndirectedEdge(6,7);
        g1.addUndirectedEdge(6,8);
        g1.addUndirectedEdge(6,4);
        g1.addUndirectedEdge(7,8);


        g1.printGraph();
        System.out.println("Number of edges: " + numEdges(g1));
        System.out.println();

        Graph g2 = new Graph(7);
        g2.addUndirectedEdge(1,2);
        g2.addUndirectedEdge(1,3);
        g2.addUndirectedEdge(3,4);
        g2.addUndirectedEdge(3,5);
        g2.addUndirectedEdge(2,5);
        g2.addUndirectedEdge(2,4);
        g2.addUndirectedEdge(4,6);
        g2.addUndirectedEdge(4,5);
        g2.addUndirectedEdge(6,5);


        g2.printGraph();
        System.out.println("Number of edges: " + numEdges(g2));
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
    private static int numEdges(Graph graph){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.vertices];
        int noOfEdges = 0;
        if(graph.vertices < 1){
            return noOfEdges;
        }
        for(int vertex =0; vertex < graph.vertices; vertex++) {
            if(!visited[vertex]) {
                queue.add(vertex);
                visited[vertex] = true;
                while (!queue.isEmpty() && graph.adjacencyList[queue.peek()] != null) {
                    LinkedList<Integer> adjacent = graph.adjacencyList[queue.poll()];
                    if (!adjacent.isEmpty()) {
                        noOfEdges+=adjacent.size();
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
        return noOfEdges/2;
    }
}
