import java.util.ArrayList;

class Set {

	private ArrayList<Integer> members;

	// Constructors
	public Set(){
		members = new ArrayList<Integer>();
	}

	public Set(ArrayList<Integer> members){
		this.members = members;
	}

	public ArrayList<Integer> getMembers(){
		return members;
	}

	public void addMember(int i){
		members.add(i);
	}
	//
	//
	// 	// toString() method
	public String toString() {
		if(members.size() == 0){
			return "[]";
		}else{
			String result = "";
			for(int i=0;i<members.size(); i++){
				if(i == members.size() -1){
					result = result + members.get(i);
				}else{
					result = result + members.get(i) + ", ";
				}
			}
			return "["+result+"]";
		}
	}
	//
	// 				// Return true if 'this' is a subset of 'set', 
	// 					// otherwise return false.
	public boolean isSubset(Set set) {
		for(int member: members){
			if(!set.getMembers().contains(member)){
				return false;
			}
		}
		return true; // this is a stub
	}
}
//
// 									
