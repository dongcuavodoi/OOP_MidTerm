import java.io.FileInputStream;
import java.util.*;

import javax.swing.JOptionPane;
 
//class to store edges of the weighted graph
class Edge {
    int src, dest, weight;
    Edge(int src, int dest){   //, int weight) {
            this.src = src;
            this.dest = dest;
            //this.weight = weight;
        }
}
// Graph class
class Graph {
    // node of adjacency list 
    static class Node {
        int value, weight;
        Node(int value){ //, int weight)  {
            this.value = value;
           // this.weight = weight;
        }
    };
 
// define adjacency list
 
List<List<Node>> adj_list = new ArrayList<>();
 
    //Graph Constructor
    public Graph(List<Edge> edges)
    {
        // adjacency list memory allocation
        for (int i = 0; i < edges.size(); i++)
            adj_list.add(i, new ArrayList<>());
 
        // add edges to the graph
        for (Edge e : edges)
        {
            // allocate new node in adjacency List from src to dest
            adj_list.get(e.src).add(new Node(e.dest)); //, e.weight));
        }
    }
// print adjacency list for the graph
    public static void printGraph(Graph graph)  {
        int src_vertex = 0;
        int list_size = graph.adj_list.size();
 
        System.out.println("The contents of the graph:");
        while (src_vertex < list_size) {
            //traverse through the adjacency list and print the edges
            for (Node edge : graph.adj_list.get(src_vertex)) {
                System.out.print("Vertex:" + src_vertex + " ==> " + edge.value + "\t"); 
                                //" (" + edge.weight + ")\t");
            }
 
            System.out.println();
            src_vertex++;
        }
    }
}
public class main{
    public static void main (String[] args) {
        // define edges of the graph 
    	char c,d;
//        List<Edge> edges = Arrays.asList(new Edge(0, 1, 2),new Edge(0, 2, 4),
//                   new Edge(1, 2, 4),new Edge(2, 0, 5), new Edge(2, 1, 4),
//                   new Edge(3, 2, 3), new Edge(4, 5, 1),new Edge(5, 4, 3));
    	List<Edge> edges = new ArrayList<Edge>();  //copy
//    	edges.add(new Edge(1,2));
//    	edges.add(new Edge(2,3));
//    	edges.add(new Edge(2,4));
//    	edges.add(new Edge(3,4));
    	try {
    		FileInputStream fi = new FileInputStream("C:\\Users\\ABC\\eclipse-workspace\\OOP_MidTerm\\src\\file.txt");
    		Scanner sc = new Scanner(fi);
    		while(sc.hasNextLine()) {
    			String str = sc.nextLine();
    			str = str.replaceAll("\\s+", "");
    			for(int i = 0; i < str.length() - 1; i++) {
    				c = str.charAt(i);
    				d = str.charAt(i+1);
    				edges.add(new Edge(Character.getNumericValue(c),Character.getNumericValue(d)));
    			}
    		}
    		
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "File khong ton tai");
    	}
        // call graph class Constructor to construct a graph
        Graph graph = new Graph(edges);
 
        // print the graph as an adjacency list
        Graph.printGraph(graph);    }
}