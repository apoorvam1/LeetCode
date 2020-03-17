
import java.util.LinkedList;
import java.util.List;

public class Graph {
    // number of nodes in the graph
    int n;

    // array of list where each array index i of the array corresponds to node i & contains its neighbors in a list
    List<Integer>[] neighbors;

    public Graph(int n) {
        this.n = n;

        for(int i = 0; i < n; i++) {
            neighbors[i] = new LinkedList<>();
        }
    }


    private void createAdjacencyList(List<List<Integer>> connections) {
        for(List<Integer> conn : connections) {
            int n1 = conn.get(0);
            int n2 = conn.get(1);
            neighbors[n1].add(n2);
            neighbors[n2].add(n1);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        List<List<Integer>> connections = new LinkedList<>();
        List<Integer> l1 = new LinkedList<>();
        l1.add(0);
        l1.add(1);
        connections.add(l1);

        List<Integer> l2 = new LinkedList<>();
        l2.add(0);
        l2.add(4);
        connections.add(l2);

        List<Integer> l3 = new LinkedList<>();
        l3.add(1);
        l3.add(3);
        connections.add(l3);

        List<Integer> l4 = new LinkedList<>();
        l4.add(1);
        l4.add(2);
        connections.add(l4);

        List<Integer> l5 = new LinkedList<>();
        l5.add(1);
        l5.add(4);
        connections.add(l5);

        List<Integer> l6 = new LinkedList<>();
        l6.add(2);
        l6.add(3);
        connections.add(l6);

        List<Integer> l7 = new LinkedList<>();
        l7.add(3);
        l7.add(4);
        connections.add(l7);

        graph.createAdjacencyList(connections);
    }

}
