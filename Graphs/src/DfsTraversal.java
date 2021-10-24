import java.util.LinkedList;
import java.util.Stack;

public class DfsTraversal {

    public static void main(String[] args) {
        Graph g= new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        g.printGraph();
        System.out.println(dfs(g));

        Graph g1 = new Graph(5);
        g1.addEdge(0,1);
        g1.addEdge(0,2);
        g1.addEdge(1,3);
        g1.addEdge(1,4);
        System.out.println("Graph1:");
        g1.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g1));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));

    }

    private static String dfs(Graph graph){
        String result="";
        Stack<Integer> stack = new Stack();
        boolean[] visited = new boolean[graph.vertices];
        if(graph.vertices < 1){
            return result;
        }
        for(int vertex =0; vertex < graph.vertices; vertex++) {
            if(!visited[vertex]) {
                stack.add(vertex);
                visited[vertex] = true;
                while (!stack.isEmpty() && graph.adjacencyList[stack.peek()] != null) {
                    result = result + stack.peek();
                    LinkedList<Integer> adjacent = graph.adjacencyList[stack.pop()];
                    if (!adjacent.isEmpty()) {
                        for (int i = 0; i < adjacent.size(); i++) {
                            if (!visited[adjacent.get(i)]) {
                                stack.add(adjacent.get(i));
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
