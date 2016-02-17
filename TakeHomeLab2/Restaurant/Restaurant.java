/*
Name: Wong Kang Fei
Matric Number: A0138862W
*/

import java.util.*;

public class Restaurant {

	private static Table[] tables; // Keeping track of existing tables
	private static String[] queries; // Series of queries to be executed
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int TABLE_COUNT = sc.nextInt();
		tables = new Table[TABLE_COUNT];

		sc.nextLine(); // consume line feed
		
		// initialize table instances
		for(int i=0; i<TABLE_COUNT; i++){
			tables[i] = new Table(sc.next(), sc.nextInt());

			sc.nextLine(); // consume line feed
		}

		// sort tables by name ascending lexicographically
		Arrays.sort(tables);

		final int QUERY_COUNT = sc.nextInt();
		queries = new String[QUERY_COUNT];

		sc.nextLine(); // consume line feed
		
		// store series of queries in String form
		// we cannot execute the queries immediately else the output are hard to handle
		for(int i=0; i<QUERY_COUNT; i++){
			queries[i] = sc.nextLine();
		}

		// Batch execute queries
		for(int i=0; i<QUERY_COUNT; i++){
			String[] queryParameters = queries[i].trim().split(" ");

			// extract query operation identifier
			int queryId = Integer.parseInt(queryParameters[0]);

			switch(queryId){
				case 1:
					executeQuery1(queryParameters[1], Integer.parseInt(queryParameters[2]), queryParameters[3]);
					break;
				case 2:
					executeQuery2(queryParameters[1], Integer.parseInt(queryParameters[2]));
					break;
				case 3:
					executeQuery3(queryParameters[1]);
					break;
				case 4:
					executeQuery4(queryParameters[1]);
					break;
				case 5:
					executeQuery5(queryParameters[1]);
					break;
				default:
					break;
			}
		}

	}

	/*
	 *	Precondition: Stored table names are unique
	 *  Input: table name
	 *  Output: return table instance if matching table name is found; otherwise, return null
	 * */
	public static Table findTableByName(String name){
		Table table = null;
		for(int i=0; i<tables.length; i++){
			if(name.equals(tables[i].getName())){
				table = tables[i];
				break;
			}
		}

		return table;
	}

	/*
	 * Precondition: tables are sorted in ascending order lexicographically (See lab requirement pdf)
	 * Input: minimum capacity
	 * Output: return table instance if such empty table is found; otherwise return null
	 *
	 * */
	public static Table findEmptyTable(int minCapacity){
		Table table = null;
		for(int i=0; i<tables.length; i++){
			// table is empty and can handle at least of minCapacity
			if(!tables[i].hasGroup() && tables[i].getCapacity()>=minCapacity){
				table = tables[i];
				break;
			}
		}

		return table;
	}
	
	/*
	 *	Precondition: existing group name are unique
	 *	Input: group name
	 *	Output: return table instance if table contain group with matching group name; otherwise return null
	 *
	 * */
	public static Table findTableByGroupName(String groupName){
		Table table = null;
		for(int i=0; i<tables.length; i++){
			if(tables[i].hasGroup()){
				if(groupName.equals(tables[i].getGroup().getName())){
					table = tables[i];
					break;
				}
			}
		}
		return table;
	}

	/*
	 *	 	1 GROUP_NAME GROUP_SIZE TABLE_NAME
	 *		
	 *		A	group	with	the	name	GROUP_NAME	of	size	GROUP_SIZE	arrives	at	the	restaurant	
	 *		and	they	request	to	be	seated	at	the	table	TABLE_NAME.	If	that	group	can	be	seated	
	 *		at	the	table	TABLE_NAME,	print	TABLE_NAME.	Otherwise,	print	“not possible”.	
	 *
	 * */
	private static void executeQuery1(String groupName, int groupSize, String tableNameRequested){
		Group group = new Group(groupName, groupSize);
		Table tableRequested = findTableByName(tableNameRequested);

		if(tableRequested != null){
			System.out.println(tableRequested.assignGroup(group));
			//System.out.println(tableRequested.getName());
		}else{
			// table not found
			// table name does not exist (not in requirement)
			System.out.println("invalid");
		}

	}
	
	/*
	 *		2 GROUP_NAME GROUP_SIZE
	 *
	 *		A	group	with	the	name	GROUP_NAME	of	size	GROUP_SIZE	arrives	at	the	restaurant.	
	 *		If	that	group	can	be	seated	at	any	suitable	table,	print	TABLE_NAME.	Otherwise,	
	 *		print	“not possible”.	The	table	that	you	allocate	should	be	the	lexicographically	
	 *		smallest	table	that	is	available	and	suitable	for	the	group.	
	 *
	 *		Precondition: table array list must be sorted lexicographically in ascending order.
	 * */
	private static void executeQuery2(String groupName, int groupSize){
		Group group = new Group(groupName, groupSize);
		Table emptyTable = findEmptyTable(groupSize);
		if(emptyTable != null){
			System.out.println(emptyTable.assignGroup(group));
		}else{
			System.out.println("not possible");
		}
	}

	/*
	 *	3 GROUP_NAME 	
	 *	A	group	with	the	name	GROUP_NAME	leaves	the	restaurant.	If	there	are	no	groups	
	 *	with	 the	 name	 GROUP_NAME	 inside	 the	 restaurant,	 the	 system	 does	 not	 do	
	 *	anything.	
	 *
	 * */
	private static void executeQuery3(String groupName){
		Table tableWithGroupName = findTableByGroupName(groupName);
		if(tableWithGroupName != null){
			tableWithGroupName.removeGroup();
		}

	}

	/*
	 *	4 GROUP_NAME	
	 *	Print	the	name	of	the	table	that	the	group	GROUP_NAME	is	currently	assigned	to.	If	
	 *	there	 are	 no	 groups	 with	 the	 name	 GROUP_NAME	 inside	 the	 restaurant,	 print	
	 *	“invalid”.	
	 *
	 */
	private static void executeQuery4(String groupName){
		Table tableWithGroupName = findTableByGroupName(groupName);
		if(tableWithGroupName !=null){
			System.out.println(tableWithGroupName.getName());
		}else{
			System.out.println("invalid");
		}

	}

	/*
	 *	5 TABLE_NAME	
	 *	Print	the	name	of	the	group	that	currently	occupies	the	table	TABLE_NAME.	If	the	
	 *	table	 TABLE_NAME	 is	 currently	 empty	 or	 there	 are	 no	 tables	 with	 the	 name	
	 *	TABLE_NAME,	print	“invalid”.
	 *
	 * */
	private static void executeQuery5(String tableName){
		Table table = findTableByName(tableName);
		if(table != null && table.hasGroup()){
			System.out.println(table.getGroup().getName());
		}else{
			System.out.println("invalid");
		}

	}

}

class Group {
	private String name;
	private int size;

	//define the appropriate constructor and methods

	public Group(String name, int size){
		this.name = name;
		this.size = size;
	}

	public String getName(){
		return name;
	}

	public int getSize(){
		return size;
	}
}

// Comparable interface to allow Arrays.sort works by sorting table name lexicographically
class Table implements Comparable<Table>{
	private String name;
	private int capacity;
	private Group group;

	//define the appropriate constructor and methods

	public Table(String name, int capacity){
		this.name = name;
		this.capacity = capacity;
	}

	/*
	 *	input: Group instance
	 *	output: return the table name if successfully assigned; otherwise, return "not possible"
	 * */
	public String assignGroup(Group group){
		// is table already assigned to an axisting group?
		// can the table accomodate given group size?
		if(this.group == null && capacity >= group.getSize()){
			this.group = group;

			return name;
		}else{
			return "not possible";
		}
	}

	public void removeGroup(){
		this.group = null;
	}

	public boolean hasGroup(){
		return group != null;
	}

	public String getName(){
		return name;
	}

	public int getCapacity(){
		return capacity;
	}

	public Group getGroup(){
		return group;
	}

	// implement methods required by Comparable interface
	// sort by table name lexicographically
	public int compareTo(Table table){
		return this.name.compareTo(table.getName());
	}
}

