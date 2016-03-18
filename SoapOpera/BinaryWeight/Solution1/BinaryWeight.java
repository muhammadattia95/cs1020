
import java.util.*;

public class BinaryWeight{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		while(true){
			System.out.println(nextSameBinaryWeight(sc.nextInt()));
			sc.nextLine();
		}
	}

	public static int nextSameBinaryWeight(int num){
		return helper(num+1, num);
	} 

	public static int helper(int num, int originalNum){
		if(Integer.bitCount(num) == Integer.bitCount(originalNum)){
			return num;
		}else{
			return helper(num+1, originalNum);
		}
	}
}