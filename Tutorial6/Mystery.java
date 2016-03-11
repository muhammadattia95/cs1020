class DivideBy4Exception extends Exception {}
class DivideBy100Exception extends DivideBy4Exception {}
class DivideBy400Exception extends DivideBy100Exception {}

/* Part (e): Poor design! DO NOT EVER Use Exceptions this way!! */

public class Mystery {
	
	public int calculate(int input) {
		int value = 0;
		for (int index = 1; index <= input; index++)
			value += buzz(index);
		return value;
	}
	
	public int buzz(int value) {
		try {
			if (value % 400 == 0)
				throw new DivideBy400Exception();
			if (value % 100 == 0)
				throw new DivideBy100Exception();
			if (value % 4 == 0)
				throw new DivideBy4Exception();
			return 0;
		} catch (DivideBy4Exception ex) {
			return 1;
		} catch (DivideBy100Exception ex) {
			return 0;
		} catch (DivideBy400Exception ex) {
			return 1;
		} finally {
			return 3;
		}
	}
	
	public static void main(String[] arr) {
	}
}

