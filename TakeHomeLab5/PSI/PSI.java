import java.util.*;

public class PSI {

	private Integer[] nums;

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		int numCount = sc.nextInt();

		sc.nextLine(); // consume line feed

		Integer[] nums = new Integer[numCount];

		for(int i = 0; i< numCount; i++){
			nums[i] = sc.nextInt();
		}

		//System.out.println((new PSI(nums)).solve());
		System.out.println((new PSI(nums)).solve2());
	}


	public PSI(Integer[] nums){
		this.nums = nums;
	}

	// O(n^2)
	public int solve(){
		int PSICount = 0;
		int[] sums = new int[nums.length];
		
		sums[0] = nums[0];

		// O(n)
		for(int i = 1; i<nums.length; i++){
			sums[i] = sums[i-1] + nums[i];
		}

		// O(n^2)
		for(int i = 0; i<sums.length; i++){ // for each sums element
			for(int j = 0; j<i; j++){ // up to index i of nums
				if(sums[i] - sums[j] > 0){
					PSICount++;
				}
			}

			if(sums[i] > 0){
				PSICount++;
			}
		}

		return PSICount;
	}

	// O(nlogn)
	public int solve2(){
		int PSICount = 0;
		mergeSort(nums);
		
		for( int i =0; i< nums.length; i++){
			for(int j = i+1; j< nums.length; j++){
				if(nums[i] + nums[j] > 0){
					PSICount++;
				}
			}
			if(nums[i] > 0){
				PSICount++;
			}
		}
		return PSICount;
	}
/*
	public int solve3(){
		int PSICount = 0;
		int sum = 0;

		for(int i = 0; i< nums.length; i++){
			if(nums[i] + sum > 0){
				PSICount++;
			}else{
				sum = 0;
			}
		}

		return PSICount;
	}
*/

	// Merge Sort Impl
	private void mergeSort(Comparable [ ] a)
	{
		Comparable[] tmp = new Comparable[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}


	private void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}


    private void merge(Comparable[ ] a, Comparable[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo(a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
    
}
