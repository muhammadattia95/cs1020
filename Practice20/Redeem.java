// This program reads in an item's cost and some coupons' information,
// and then determines which is the best coupon to use and the amount 
// to pay.

// Add import statement(s) below
import java.util.*;
import java.text.*;

public class Redeem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double amount = sc.nextDouble();
		int couponCount = sc.nextInt();

		Coupon[] coupons = new Coupon[couponCount];

		for(int i = 0; i<couponCount; i++){
			coupons[i] = new Coupon(sc.next(), sc.nextDouble());
			sc.nextLine(); // consume line feed
		}

		Coupon bestCoupon = findBestCoupon(amount, coupons);
		double amountPayable = bestCoupon.payment(amount) < 0? 0: bestCoupon.payment(amount);

		DecimalFormat df = new DecimalFormat("0.00");

		// Output the result
		// Ensure your output is in the right format
		System.out.println("Best choice: " + bestCoupon.getName());
		System.out.println("You need to pay $" + df.format(amountPayable));
	}

	private static Coupon findBestCoupon(double amount, Coupon[] coupons){
		Coupon bestCoupon = null;

		for(Coupon coupon : coupons){
			if(bestCoupon == null){
				bestCoupon = coupon;
			}else{
				double amountPayable = coupon.payment(amount);
				if(amountPayable > 0){
					if(bestCoupon.payment(amount) > 0){
						bestCoupon = coupon.payment(amount) < bestCoupon.payment(amount)? coupon: bestCoupon;
					}else{
						continue;
					}
				}else{
					bestCoupon = Math.abs(coupon.payment(amount)) <  Math.abs(bestCoupon.payment(amount))? coupon: bestCoupon;
				}
			}
		}

		return bestCoupon;
	}
}


