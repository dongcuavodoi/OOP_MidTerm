package reader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class GraphMatrix implements Graph{
 private int v, e;
 private boolean connected[][];
 //Contructure
 public GraphMatrix(int v){
	 //Only allow positive number of vertices
	 if (v > 0){
		 this.e = 0;
		 this.v = v;
		 //Connected array is automatically initialized with “false”
		 connected = new boolean[v][v];
	 }
 }
 public boolean add(int u, int v){
	 if (!isValidNode(u) || !isValidNode(v) || (u == v) || contains(u, v))
		 return false;
	 connected[u][v] = true;
	 connected[v][u] = true;
	 this.e++;
	 return true;
 }
 public boolean remove(int u, int v){
	 if (!isValidNode(u) || !isValidNode(v) || (u == v) || !contains(u, v))
		 return false;
	 connected[u][v] = false;
	 connected[v][u] = false;
	 this.e--;
	 return true;
 }
 public List<Integer> adj(int u){
	 if (!isValidNode(u))
		 return null;
	 List<Integer> adjList = new LinkedList<Integer>();
	 for (int i = 0; i < this.v; i++)
		 if (connected[u][i])
			 adjList.add(i);
	 //The returned adj list can not be modified from outside, important!!!
	 return (List<Integer>)Collections.unmodifiableList(adjList);
 }
 public boolean contains(int u, int v){
	 if (!isValidNode(u) || !isValidNode(v))
		 return false;
	 else return connected[u][v];
 }
 public int v(){
	 return v;
 }
 public int e(){
	 return e;
 }
 public Iterator iterator(){
	 //not implemented yet
	 return null;
 }
 public void printGraph(){
	System.out.println("****GRAPH*****");
	System.out.println("Number of vertices: " + this.v);
	System.out.println("Number of edges: " + this.e);
	System.out.println("Connection - Matrix");
	for (int i = 0; i < this.v; i++){
		for (int j = 0; j < this.v; j++)
			System.out.print(connected[i][j] ? "1 " : "0 ");
		System.out.println();
	}
	System.out.println("***************");
 }
 private boolean isValidNode(int u){
	return (u >= 0) && (u <= this.v-1);
	}
@Override
public void displayGraph() {
	// TODO Auto-generated method stub
	
}
}