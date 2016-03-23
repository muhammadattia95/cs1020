public class Movement{
	public static void main(String[] args){
		System.out.println(move(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	public static int move(int up, int down){
		if(up == 0 && down == 0){
			return 1;
		}else if(up == 0){
			return move(0, down-1);
		}else if(down == 0){
			return move(up-1, 0);
		}else{
			return move(up-1, down) + move(up, down-1);
		}
	}
}
