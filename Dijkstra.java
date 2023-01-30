package assign2;
import java.util.Scanner;

public class Dijkstra {
	static void dijkstra(int n,int W[][],String F[]) {
		
		int i,vnear=1;
		
		int touch[]=new int[n+1];
		int length[]=new int[n+1];
		for(i=2; i<=n; i++) {
			touch[i]=1;
			length[i]=W[1][i];
		}
		//F=new String[n+1];
		
		for(int time=1; time<=n-1; time++) {
			int min=99999;
			for(i=2; i<=n; i++) {
			if(0<=length[i] && length[i]<=min) {
				min=length[i];
				vnear=i;
			}
			F[time]="{"+touch[vnear]+","+vnear+"}"+W[touch[vnear]][vnear];
		}
		for(i=2; i<=n; i++) {
				if(length[vnear]+W[vnear][i]<length[i]) {
					length[i]=length[vnear] + W[vnear][i];
					touch[i]=vnear;
				}
		}
				length[vnear]=-1;
					
				
				System.out.println(F[time]);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("몇개의 vertex가 있습니까?");
		int n=sc.nextInt();
		System.out.println("몇개의 edge가 있습니까?");
		int l=sc.nextInt();
		String F[]=new String[n];
		int W[][]=new int[n+1][n+1];
		for(int a=1; a<=n; a++) {
			for(int b=1; b<=n; b++) {
				W[a][b]=9999;
				if(a==b) {
					W[a][b]=0;
				}
			}
		}
		
		System.out.println("Edge의 start, end, weight");
		for(int i=1 ; i <=l ; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			W[start][end] = weight;
		}

		
		dijkstra(5,W,F);
		sc.close();
	


	

}
}
