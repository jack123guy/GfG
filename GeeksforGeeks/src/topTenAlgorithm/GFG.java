package topTenAlgorithm;

import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.System.out;

// Practice from the address below
// http://www.practice.geeksforgeeks.org/problem-page.php?pid=1539
class GFG {
	public static void main(String[] args) {
		// code
		int T, n;
		int[] A;
		boolean[] num = new boolean[9];
		Scanner sc = new Scanner(System.in);
		ArrayList<boolean[]> list = new ArrayList<boolean[]>();
		out.print("Enter T:");
		T = sc.nextInt();
		out.println();

		for (int i = 0; i < T; i++) {
			out.print("Enter n:");
			n = sc.nextInt();
			out.println();
			A = new int[n];
			
			out.print("Fill the blank:\n");
			for (int q = 0; q < n; q++) {
				A[q] = sc.nextInt();
			}
			num = Distinc(A);
			list.add(num);
		}
		
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			num = (boolean[]) iter.next();
			for(int j=0;j<9;j++){
				if(num[j] == true){
					out.print(j+" ");
				}
			}
			out.println();
		}
	}
/*
	static void SortArray(int[] A) {
		int temp;
		int[] Ans = A;
		for (int i = 0; i < Ans.length - 1; i++) {
			if (Ans[i] > Ans[i + 1]) {
				temp = Ans[i];
				Ans[i] = Ans[i + 1];
				Ans[i + 1] = temp;
			}
		}
	}
*/
	static boolean[] Distinc(int[] A) {
		boolean[] no = new boolean[10];
		for (int i = 0; i < A.length; i++) {
			int temp;
			temp = (int) Math.floor(A[i] / 100);
			if (temp == 0)
				;
			else {
				no[temp] = true;
				A[i] = A[i] - temp * 100;
			}

			temp = (int) Math.floor(A[i] / 10);
			no[temp] = true;
			A[i] = A[i] - temp * 10;

			temp = A[i];
			no[temp] = true;
		}
		return no;
	}
}