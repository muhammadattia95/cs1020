public class ComplexityAnalysis{

	public static void main(String[] args){}


	/* 
	T(n) = T(n/2) + n + T(n/2)
	      = 2T(n/2) + n
	

	a = 2, b = 2, d = 1

	a = b^d 
		=> 2 = 2^1
		=> O(n log n)
	*/
	public void what_is(int n){
		if(n>1){ 
			System.out.println("first call:"); 
			what_is(n/2); 
			for(int i=0; i<n; i++){  
				System.out.println(n*n + " is n^2");
			}
			System.out.println("second call: ");
			what_is(n/2);
		}

	}


	/*
	T(n) = O(1) + T(n/2) + n^2 + T(n/2) + O(1)
		 = 2T(n/2) + n^2 + 2O(1)

	a=2, b=2, d=2

	a<b^d
		=> 2 < 2^2
		=> O(n^2)
	*/
	public void what_is(int n)  {    // n is large

       if (n > 1) {
            System.out.println("first call: ");
            what_is (n/2);
            for (int i = 0; i < n; i++){					// n
                for (int j = n; j > 0; j--){				// (n)(n-1)
                    System.out.println(n*n + " is n^2");    // (n-1)(n)
                }
            }
            System.out.println("second call: ");			// 1
            what_is(n/2)									
        }

	} 

	/*
	
	T(n) = 2T(n/2) + O(1)
	a=2, b=2, d=0

	a > b^d
		=> 2 > 2^0
		=> O(n^(log2)) (base 2)
		=> O(n)

	*/
	public void what_is(int n)  {    // n is large

	    if (n > 1) {
          	System.out.println("first call: ");
           	what_is (n/2);
           	System.out.println("second call: ");
           	what_is(n/2);
	    }

	}

	
	public void mine(){							// Cost 	Time
												// -------------
		int sum = 0;							// C1		1
		for( int i =1; i<= n; i++){				// C2		n+1
			sum = sum+i;						// C3		n
			for( int j = 1; j<= n; j++){		// C4		n*(n+1)
				sum = sum +j;					// C5		n^2
			}									// 
		}										//	Total Cost = summation(Cost * Time)
												//			   = C1 + C2*(n+1) + C3*(n) + C4*(n^2+n) + C5*(n^2)
												//			   = O(n^2)
	}

	/*
	
	n = 1, 4, 9, 16 ... n^2
	i = 1, 3, 9, 27 ... 3^k

	n^2 = 3^k
	2 log n = k log 3
	k = O(log n)

	*/
	public void ivan(){
		for(int i=1; i< n^2; i*=3){
			//SOP
		}
	}

	/*
	
	n = 1, 2, 3, 4 ... n
	i = 1, 2, 4, 8, 16 ... 2^k
	j = 1, 2, 3, 4 ... k

	i & j no dependency

	O(n log n)


	*/
	public void ivan(){
		for(int i=1; i<n; i*=2){  //log n, base 2
			for(int j = 1; j<n; j++){ // n * log n
				//SOP	
			}
		}
	}


	/*!!!!!!!!!!!!!!
	
	n = 1, 2, 3, 4 ... n
	i = 1, 2, 3, 4, 5, 6, 7, 8 ... n
	j = 0, 1, 1, 2, 2, 2, 3, 3 ... log(n-2), log(n-1), log n, base 3

	
	nlog(n) + nlog(n-1) + nlog(n-2) ....
	nlog n!

	=> O(log n!) = O(n log n)

	*/
	public void ivan(){
		for(int i =1; i< n ; i++){ // n
			for(int j = 1; j<i; j*3){ // log n, base 3
				//SOP
			}
		}
	}

	/*!!!!!!!!!!!!!!
	n = 1, 2, 3, 4 ... n
	i = 1, 2, 4, 8, 16 ... 2^k
	j = 1, 2, 4, 8, 16 ... 2^k

	n = 2^k

	O(n(log n)^2)

	*/
	public void ivan(){
		for(int i = 1; i< n; i*=2){  // log n, base 2
			for(int j = 1; j<i; j++){  // log n, base 2

			}
		}
	}

}