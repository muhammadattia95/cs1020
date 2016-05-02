public class ReverseLinkedList{
	public static void main(String[] args){
		BasicLinkedList<Integer> bll = new BasicLinkedList<Integer>();

		bll.addFirst(5);
		bll.addFirst(4);
		bll.addFirst(3);
		bll.addFirst(2);
		bll.addFirst(1);

		bll.reverseLinkedList();

		System.out.println(bll);
	}

}
