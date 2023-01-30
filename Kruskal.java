package kruskalalgo;
import java.util.Arrays;
import java.util.Scanner;
public class Kruskal {
	static nodetype[] U;

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Vertex의 개수 : ");
			int v = sc.nextInt();

			System.out.println("Edge의 개수 : ");
			int e = sc.nextInt();
			
			Edge E[]=new Edge[e+1];
			Edge F[]=new Edge[v+1];
		
			E[0] = new Edge(0, 0, 0);
			System.out.println("Edge의 start,end,weight을 각각 입력하세요:");
			for(int i = 1 ; i <= e ; i++) {
				E[i] = new Edge();
				E[i].start = sc.nextInt();
				E[i].end = sc.nextInt();
				E[i].weight = sc.nextInt();
			}
			kruskal(v, e, E, F);

			for(int o = 1; o < v ; o++){
				System.out.println("("+ F[o].start + ", " + F[o].end +"), " + F[o].weight);
			}
			
	}
	
	
	
	static void kruskal(int n, int m, Edge[] E, Edge[] F) {
		int i, j;
		int p, q;
		int timeF = 1;
		int timeE = 1;
		Edge edge;

		Arrays.sort(E);

		for(int k = 1 ; k <= n ; k++) {
			F[k] = new Edge(0, 0, 0);
		}

		initial(n);

		while(timeF <= n-1 && timeE < E.length ) {
			edge = E[timeE];
			i = edge.start;
			j = edge.end;
			p = find(i);
			q = find(j);
			if(!equal(p,q)) {
				merge(p,q);
				F[timeF] = edge;
				timeF++;
			}
			timeE++;
		}
	}

	static void makeset(int i) {
		U[i].parent = i;
		U[i].depth = 0;
	}

	static int find(int i) {
		int j;
		j = i;
		while(U[j].parent != j) {
			j = U[j].parent;
		}
		return j;
	}

	static void merge (int p, int q){
		if(U[p].depth == U[q].depth) {
			U[p].depth += 1;
			U[q].parent = p;
		} else if(U[p].depth < U[q].depth) {
			U[p].parent = q;
		} else {
			U[q].parent = p;
		}
	}

	static boolean equal(int p, int q) {
		if(p == q) {
			return true;
		} else {
			return false;
		}
	}

	static void initial(int n) {
		int i;
		U = new nodetype[n+1];
		U[0] = new nodetype();
		for(i = 1 ; i <= n ; i++) {
			U[i] = new nodetype();
			makeset(i);
		}
	}


}

class nodetype{
	int parent;
	int depth;
}

class Edge implements Comparable<Edge>{
	int start;
	int end;
	int weight;

	public Edge() {

	}
	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge ed) {
		if(this.weight < ed.weight)
			return -1;
		else if(this.weight == ed.weight)
			return 0;
		else
			return 1;
	}
}
