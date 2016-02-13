public class Fraction {

	/************** Data members **********************/
	private int number;
	private int denom;

	/************** Constructors **********************/
	public Fraction(){
		this.number =1;
		this.denom =1;
	}

	public Fraction(int number, int denom){
		this.number = number;
		this.denom = denom;
	}

	/**************** Accessors ***********************/
	public int getNumber(){
		return number;
	}

	public int getDenom(){
		return denom;
	}


	/**************** Mutators ************************/

	public void setNumber(int number){
		this.number = number;
	}

	public void setDenom(int denom){
		this.denom = denom;
	}

	/***************** Other methods ******************/
	
	private int gcd(int a, int b){
		return b == 0? a: gcd(b, a%b);
	}

	public Fraction simplify(){
		int _gcd = gcd(number, denom);

		return new Fraction(number/_gcd, denom/_gcd);
	}

	public Fraction add(Fraction f){
		int _number = this.number * f.getDenom();
		int _denom = this.denom * f.getDenom();

		int _fnumber = f.getNumber() * this.denom;
		int _fdenom = f.getDenom() * this.denom;

		return new Fraction(_number+_fnumber, _denom).simplify();
	}
	
	@Override
	public String toString(){

		return this.number +"/" + this.denom;
	}

	public boolean equals(Object f){
		if( f instanceof Fraction){
			Fraction _f1 = this.simplify();
			Fraction _f2 = ((Fraction) f).simplify();
		
			return _f1.getNumber() == _f2.getNumber() &&
				_f1.getDenom() == _f2.getDenom();
		}else{

			return false;
		}
	}


}


