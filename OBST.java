package assign2;

import java.util.Scanner;

public class OBST {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("개수를 입력하세요 : ");
		int n = sc.nextInt();
		float[] p = new float[n+1];
		p[0] = (float)0;
		System.out.println("순서대로 확률을 입력하세요. ");
		for(int i=1; i<n+1; i++) {
			p[i] = sc.nextFloat();
		}
		
		float minavg=0;
		int R[][] = new int[n+2][n+1];
		
		optsearchtree(n, p, minavg, R);
		
		sc.close();
		
	}
	
	static void optsearchtree(int n, float p[], float minavg, int R[][]) {
		int i, j, k, diagonal;
		float[][] A = new float [n+2][n+1];
		
		for(i=1; i<=n; i++) {
			A[i][i-1]=0;
			A[i][i] = p[i];
			R[i][i] = i;
			R[i][i-1] = 0;
		}
		A[n+1][n] = 0;
		R[n+1][n] = 0;
		
		for(diagonal=1; diagonal <= n-1; diagonal++) {
			for(i=1; i <= n-diagonal; i++) {
				j = i + diagonal;
				float psum=(float)0;
				A[i][j] = A[i][i-1] + A[i+1][j];
				R[i][j] = i;
				for(k=i; k <= j; k++) {
					if(A[i][j] > A[i][k-1] + A[k+1][j]) {
						A[i][j] = A[i][k-1] + A[k+1][j];
						R[i][j] = k;
					}
					psum += p[k];
				} 
				A[i][j] += psum;
			}
		}
		
		minavg = A[1][n];
		System.out.println("최적 이분검색트리에서의 평균검색시간 : " + minavg);
		
		System.out.println("A :");
		for(i=1; i<n+2;i++) {
			for(j=0; j<n+1;j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("R :");
		for(i=1; i<n+2;i++) {
			for(j=0; j<n+1;j++) {
				System.out.print(R[i][j] + " ");
			}
			System.out.println();
		}
	}

}
