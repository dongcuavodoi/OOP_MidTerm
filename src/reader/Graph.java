package reader;
import java.util.List;

public interface Graph extends Iterable{
	boolean add(int u, int v);
	boolean remove(int u, int v);
	List adj(int u);
	boolean contains(int u, int v);
	int v(); // vertice : dinh
	int e(); // edge : canh
	void displayGraph();
	void printGraph();
} 