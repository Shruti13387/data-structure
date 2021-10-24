import java.util.LinkedList;

public class Graph {

    int vertices;
    LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for(int i=0; i<vertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        if(source < vertices && destination < vertices){
            this.adjacencyList[source].addLast(destination);
        }
    }

    public void printGraph() {
        System.out.println(">>Adjacency List of Directed Graph<<");
        addEdge(0,5);
        for (int i = 0; i < vertices; i++)
        {
            if(adjacencyList[i]!=null){
                System.out.print("|" + i + "| => ");

                LinkedList<Integer> temp = adjacencyList[i];
                for (int j=0;j < temp.size();j++)
                {
                    System.out.print("[" + temp.get(j) + "] -> ");
                }
                System.out.println("null");
            }
            else{

                System.out.println("|" + i + "| => "+ "null");
            }
        }
    }

}
