// Q3
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

class Item {
	private String name;
	private int space;
	private int value;
	public Item(String pName, int pSpace, int pValue) {
		name = pName;
		space = pSpace;
		value = pValue;
	}
	@Override public String toString() { return name; }
	public String getName() { return name; }
	public int getSpace() { return space; }
	public int getValue() { return value; }
}
class ItemList {
	private ArrayList<Item> items;
	private int totalSpace;
	private int totalValue;
	public ItemList(ItemList anotherList) {
		if (anotherList == null) {
			items = new ArrayList<Item>();
			return;
		}
		items = new ArrayList<Item>(anotherList.items);
		totalSpace = anotherList.totalSpace;
		totalValue = anotherList.totalValue;
	}
	@Override public String toString() { return items.toString(); }
	public void addItem(Item pItem) {
		items.add(pItem);
		totalSpace += pItem.getSpace();
		totalValue += pItem.getValue();
	}
	public int getTotalSpace() { return totalSpace; }
	public int getTotalValue() { return totalValue; }
	public boolean isEmpty() { return items.isEmpty(); }
}

public class ITLogsMgmtQ3 { 
	
	public static final String MSG_STORE_NOTHING = "[Store Nothing]";
	
	// This is the method that Dylan will call.
	// Preconditions	: items non-null, in lexi ASC. order of names
	// Postconditions	: items not modified, ONLY best option printed
	public void enumerateOptions(List<Item> items, int capacity) {
		ItemList selection = enumerateOptions(items, capacity, 0,
			new ItemList(null)); // Creates empty ItemList - See code!
		if (selection.isEmpty()) System.out.println(MSG_STORE_NOTHING);
		else System.out.println(selection.toString());
	}
	private ItemList enumerateOptions(List<Item> items, int capacity,
		int currIdx, ItemList selection) {

		// base case: currIdx >= items.size
		//
		// check if including current item is exceeding the capacity
		// 	if it does, skip curr and go to the next item


		//find best selection both ways
		//
		//compare selection values

		return null; // Complete the recursive method
	}
	
	public static void main(String[] args) {
		ITLogsMgmtQ3 soln = new ITLogsMgmtQ3();
		List<Item> items = new LinkedList<Item>();
		Scanner scan = new Scanner(System.in);
		int capacity = scan.nextInt();
		while(scan.hasNext()) {
			int space = scan.nextInt();
			int value = scan.nextInt();
			items.add(new Item(scan.nextLine().trim(), space, value));
		}
		scan.close();
		soln.enumerateOptions(items, capacity);
	}
}
