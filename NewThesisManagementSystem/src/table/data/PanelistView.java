package table.data;

import java.util.ArrayList;

public class PanelistView extends GuestView{
	int groupNumber = 0;
	String thesisType = "";
	String thesisTitle = "";
	String briefDescription = "";
	ArrayList<String> members = new ArrayList<String>();
	
	public void clearMembers(){
		this.members.clear();
	}
	
	public void setMembers(String member){
		if(!member.equals("")){
			this.members.add(member);
		}
	}
	
	public ArrayList<String> getMembers(){
		return this.members;
	}
	
	public String getThesisType() {
		return thesisType;
	}

	public void setThesisType(String thesisType) {
		this.thesisType = thesisType;
	}

	public int getGroupNumber() {
		return groupNumber;
	}
	
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	public String getThesisTitle() {
		return thesisTitle;
	}
	
	public void setThesisTitle(String thesisTitle) {
		this.thesisTitle = thesisTitle;
	}
	
	public String getBriefDescription() {
		return briefDescription;
	}
	
	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}
}
