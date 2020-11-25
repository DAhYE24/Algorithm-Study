package Codility;

public class Lesson2_Arrays_CyclicRotation {
	// INPUT : 0 < K (Integer) < 100
	// RETURN : K times right shift int[]
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testArr[] = {1, 2, 3, 4};
		int k = 4;
		
		int resultArr[] = CyclicRatationSolution(testArr, k);
		for(int i : resultArr) {
			System.out.print(i + " ");
		}
	}	
	
	public static int[] CyclicRatationSolution(int[] A, int K) {
		// Declare and init params
		int arrSize = A.length;
		int[] rtnArr = new int[arrSize];
		
		// Set the right location at return arr
		for(int i = 0; i < arrSize; i++) {
			int tmpIdx = i+K;
			int tmpArrSize = arrSize;
			
			while(tmpIdx >= tmpArrSize) {
				tmpIdx -= arrSize;
			}
			
			rtnArr[tmpIdx] = A[i];
		}
		
		return rtnArr;
	}
}
