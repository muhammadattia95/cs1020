// Q2
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class ITLogsMgmtQ2 { 
	
	public static final String MSG_STORE_NOTHING = "[Store Nothing]";
	
	// This is the method that Dylan will call.
	// Preconditions	: items non-null, lexicographically sorted ASC.
	// Postconditions	: items not modified, all storage options printed
	public void enumerateOptions(List<String> items) {
		enumerateOptions(items, 0, new ArrayList<String>());
	} 
	private void enumerateOptions(List<String> items, int currIdx,
		ArrayList<String> selectedItems) {
			// Complete the recursive method

		// base case is related to the index/size of the items
		if(currIdx >= items.size()){
			//display
			for(String item : selectedItems){
				System.out.println(item);
			}
			
			if(selectedItems.isEmpty()){
				System.out.println(MSG_STORE_NOTHING);
			}

			System.out.println();
			return;
		}else{
			
			ArrayList<String> copy = new ArrayList<String>(selectedItems);

			copy.add(items.get(currIdx));

			enumerateOptions(items, currIdx+1, copy);
			enumerateOptions(items, currIdx+1, selectedItems);

		}
	}

	public static void main(String[] args) {
		ITLogsMgmtQ2 soln = new ITLogsMgmtQ2();
		List<String> items = new LinkedList<String>();
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext())
			items.add(scan.nextLine()); // is this equiv to addLast() or addFirst()?
		scan.close();
		soln.enumerateOptions(items);
	}
}
