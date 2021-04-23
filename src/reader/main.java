package reader;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fi = new FileInputStream("C:\\Users\\ABC\\eclipse-workspace\\Project\\src\\file.txt");
			Scanner sc = new Scanner(fi);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "File khong ton tai!");
		}
		///////////////////////////
		Graph g = new GraphMatrix(4);
		g.add(0, 1);
		g.add(0, 2);
		g.add(1, 3);
		g.add(2, 3);
		g.printGraph();
		
		//Print the list of adjacent nodes of node 0
		//System.out.println(g.adj(0));
	}

}
