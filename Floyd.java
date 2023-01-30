import java.util.Scanner;
public class Floyd {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("몇개의 vertex가 존재하나요?:");
		int n=sc.nextInt();
		System.out.println("W배열을 입력하시오");
		System.out.println("--------------------");
		int[][] W=new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				W[i][j]=sc.nextInt();
			}
		}
		System.out.println("--------------------");
		System.out.println("W배열입니다");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(W[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
		int[][] D=new int[n][n];
		int[][] P=new int[n][n];
		Floyd2(n,W,D,P);
		System.out.println("---------------------");
		System.out.println("D배열입니다");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
			System.out.print(D[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
		System.out.println("P배열입니다");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
			System.out.print(P[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.print("start vertex:");
		int a=sc.nextInt();
		System.out.print("end vertex:");
		int b=sc.nextInt();
		
		System.out.print("v"+a+"->");
		path(P,a,b);
		System.out.print("v"+b);
	
		sc.close();
	}
	
static void Floyd2(int n,int W[][],int D[][],int P[][]) {
	int i,j,k;
	for(i=0; i<n; i++){
        for(j=0; j<n; j++){
            P[i][j]=0;
        }
    }
	for(i=0; i<n; i++){
        for(j=0; j<n; j++){
            D[i][j]=W[i][j];
        }
    }
	for(k=0; k<n; k++) {
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				if(D[i][k]+D[k][j]<D[i][j]) {
					P[i][j]=k+1;
					D[i][j]=D[i][k]+D[k][j];
				}
			}
		}
	}
	
}
static void path(int P[][],int q,int r) {
	if(P[q-1][r-1]!=0) {
		path(P,q,P[q-1][r-1]);
		System.out.print("v" + P[q-1][r-1]+ "->");
		path(P,P[q-1][r-1],r);
	}
	
}
}