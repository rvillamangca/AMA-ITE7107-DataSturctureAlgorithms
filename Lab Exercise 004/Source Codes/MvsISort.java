/* Merge Sort vs. Insertion Sort Comparison by Ramon Villamangca */

import java.util.Random;

public class MvsISort {
	
	public static final int MAXNUM = 1000000;
	
	public static int randomGen() {
		Random rG = new Random();
		return rG.nextInt(MAXNUM);
	}
	
	public static void insertionSort(int[] A) {
		int k, j, tmp;
		int N = A.length;
		for (k = 1; k < N; k++) {
			tmp = A[k];
			j = k - 1;
			while ((j >= 0) && (A[j] > tmp)) {
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = tmp;
		}
	}
	
	public static void mergeSort(int[] A) {
		mergeAux(A, 0, A.length - 1);
	}
	
	private static void mergeAux(int[] A, int low, int high) {
		if (low == high) return;
		int mid = (low + high) / 2;
		mergeAux(A, low, mid);
		mergeAux(A, mid+1, high);
		int[] tmp = new int[high-low+1];
		int left = low;
		int right = mid+1;
		int pos = 0;
		while ((left <= mid) && (right <= high)) {
			// added code in this loop:
			if (A[left] < A[right]) {
				tmp[pos] = A[left];
				left++;
			} else {
				tmp[pos] = A[right];
				right++;
			}
			pos++;
		}
		while (left <= mid) {
			// added code in this loop:
			tmp[pos] = A[left];
			left++;
			pos++;
		}
		while (right <= high) {
			// added code in this loop:
			tmp[pos] = A[right];
			right++;
			pos++;
		}
		System.arraycopy(tmp, 0, A, low, tmp.length); // added System parent package
	}
	
	public static void main (String[] args) {
		
		int[] origArr = new int[MAXNUM/10];	
		for (int i = 0; i < MAXNUM/10; i++) {
			origArr[i] = randomGen();
		}
		
		int[] testArr = new int[MAXNUM/100000];	
		for (int i = 0; i < MAXNUM/100000; i++) {
			testArr[i] = randomGen()/100;
		}
		
		System.out.println();
		System.out.println("--------------");
		System.out.println();
		
		System.out.print("Test Array before Merge Sort:\t");
		for (int i : testArr) System.out.print(i + " ");
		System.out.println();
		mergeSort(testArr);
		System.out.print("Test Array after Merge Sort:\t");
		for (int i : testArr) System.out.print(i + " ");
		System.out.println();
		
		
		int[] cloneArr = origArr.clone();
		
		System.out.println();
		System.out.println("--------------");
		System.out.println();
		
		// Insertion Sort;
		long insStartTime = System.currentTimeMillis();
		insertionSort(origArr);
		System.out.println("\tElapse Time for Insertion Sort:\t\t" + (System.currentTimeMillis() - insStartTime) + " ms");
		
		// Merge Sort;
		long merStartTime = System.currentTimeMillis();
		mergeSort(cloneArr);
		System.out.println("\tElapse Time for Merge Sort:\t\t" + (System.currentTimeMillis() - merStartTime) + " ms");
		
		System.out.println();
	}
}