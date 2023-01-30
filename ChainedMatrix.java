package assign2;
import java.util.Scanner;
public class ChainedMatrix {
	static int P[][];
	static int minmult(int n, int d[], int P[][]) {
		int i, j, k, diagonal;
		int minimum, dvalue;
		int[][] M = new int[n+1][n+1];
		for(i=1; i<n+1; i++) {
			M[i][i]=0;
		}
		for(diagonal=1; diagonal<=n-1; diagonal++) {
			for(i=1; i <= n-diagonal; i++) {
				j = i + diagonal;
				minimum=9999999;
				for(k=i; k<=j-1; k++) {
					dvalue = M[i][k]+M[k+1][j]+d[i-1]*d[k]*d[j];
					if(dvalue<minimum) {
						minimum = dvalue;
						P[i][j]=k;
						}
					M[i][j] = minimum;
				}
			}
		}
		System.out.println("M배열입니다");
		for(i=1; i<=n; i++) {
			for(j=1; j<=n; j++) {
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------");
		return M[1][n];
	}
	
	static void order(int i, int j) {
		if(i==j) {
			System.out.print("A" + i);
		}
		else {
			int k = P[i][j];
			System.out.print("(");
			order(i, k);
			order(k+1, j);
			System.out.print(")");
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("몇개의 행렬을 원하십니까?");
		int n=sc.nextInt();
		System.out.println("각 행렬의 크기를 입력하세요!");
		int d[]=new int[n+1];
		P=new int[n][n+1];
		for(int i=0;i<n+1; i++) {
			int a=sc.nextInt();
			d[i]=a;
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n+1; j++) {
				P[i][j]=0;
			}
		}
		minmult(n,d,P);
		System.out.println("P배열입니다");
		for(int i=1; i<=n-1; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(P[i][j]+" ");
			}
			System.out.println();
		}
		System.out.print("몇부터 몇까지의 행렬을 계산할 겁니까?");
		int a=sc.nextInt();
		System.out.println("다음 행렬을 입력하시오");
		int b=sc.nextInt();
		System.out.print("최적의 순서--> ");
		order(a,b);
		sc.close();
		}
	}


