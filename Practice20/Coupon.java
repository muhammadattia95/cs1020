// Define a coupon with rate
//   rate > 1: cash coupon with face value = rate
//   rate < 1: discount coupon with rate of discount

import java.util.*;

class Coupon {

	/********* Data attributes **********/
	private String name;
	private double rate;

	/********** Constructors **********/
	public Coupon(){        
	}

	public Coupon(String name, double rate) {
		// fill in the code
		this.name = name;
		this.rate = rate;
	}

	/********* Accessors ************/
	public String getName() {
		return name;
	}

	public double getRate() {
		return rate;
	}

	// Computes the amount to pay.
	// If payment calculated is negative, it means that
	// the coupon's value is larger than the price.
	public double payment(double price) {
		// fill in the code
		return rate < 1? price - (price*rate) : price - rate;
	}
}

