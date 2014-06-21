package table.data;

import java.util.ArrayList;

import sql.string.commands.SqlStringCommands;

public class GuestView extends SqlStringCommands{
	ArrayList<Integer> groupNumber = new ArrayList<Integer>();
	ArrayList<String> thesisTitle = new ArrayList<String>();
	ArrayList<String> members = new ArrayList<String>();
	ArrayList<String> status = new ArrayList<String>();
	
	public void clearGuestView(){
		this.groupNumber.clear();
		this.thesisTitle.clear();
		this.members.clear();
		this.status.clear();
	}
	
	public void setGuestMembers(String member){
		if(!member.equals("")){
			this.members.add(member);
		}
	}
	
	public ArrayList<String> getGuestMembers(){
		return this.members;
	}

	public ArrayList<Integer> getGuestGroupNumber() {
		return groupNumber;
	}
	
	public void setGuestGroupNumber(int groupNumber) {
		this.groupNumber.add(groupNumber);
	}
	
	public ArrayList<String> getGuestThesisTitle() {
		return thesisTitle;
	}
	
	public void setGuestThesisTitle(String thesisTitle) {
		this.thesisTitle.add(thesisTitle);
	}
	
	public ArrayList<String> getGuestStatus(){
		return this.status;
	}
	
	public void setGuestStatus(String status){
		this.status.add(status);
	}
}
