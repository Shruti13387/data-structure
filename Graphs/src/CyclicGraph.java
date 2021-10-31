import java.util.LinkedList;
import java.util.Stack;

public class CyclicGraph {

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        g.printGraph();
        System.out.println("Is Cyclic graph: " + isCyclicGraph(g));

        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println("Is Cyclic graph: " + isCyclicGraph(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println("Is Cyclic graph: " + isCyclicGraph(g2));

        Graph g3 = new Graph(4);
        g3.addEdge(0,1);
        g3.addEdge(1,2);
        g3.addEdge(3,0);
        g3.addEdge(3,1);
        g3.printGraph();
        System.out.println("Is Cyclic graph: " + isCyclicGraph(g3));

    }

    public static boolean isCyclicGraph(Graph graph) {
        Stack<Integer> stack = new Stack();
        boolean[] visited = new boolean[graph.vertices];
        boolean[] dfsVisited = new boolean[graph.vertices];
        if (graph.vertices < 1) {
            return false;
        }
        for (int vertex = 0; vertex < graph.vertices; vertex++) {
            if (!visited[vertex]) {
                stack.add(vertex);
                visited[vertex] = true;
                dfsVisited[vertex] = true;
                while (!stack.isEmpty() && graph.adjacencyList[stack.peek()] != null) {
                    int currentVertex = stack.peek();
                    LinkedList<Integer> adjacent = graph.adjacencyList[stack.pop()];
                    if (!adjacent.isEmpty()) {
                        for (int i = 0; i < adjacent.size(); i++) {
                            int node = adjacent.get(i);
                            if (dfsVisited[node] && visited[node])
                                return true;

                            dfsVisited[node] = true;
                            if (!visited[node]) {
                                stack.add(node);
                                visited[node] = true;
                            }
                        }
                    } else if (dfsVisited[currentVertex]) {
                        dfsVisited[currentVertex] = false;
                    }
                }
            }
        }
        return false;
    }
}