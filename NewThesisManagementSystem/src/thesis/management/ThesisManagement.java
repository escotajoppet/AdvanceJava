package thesis.management;

import java.sql.*;
import table.data.PanelistView;
import database.connect.*;

public class ThesisManagement extends PanelistView{
	DbConnect dbObj = null;
	Statement st = null;
	ResultSet rs = null;
	String message = "";
	String sqlQuery = "";
	String username = "";
	String logAs = "";
	
	public ThesisManagement(){
		dbObj = new DbConnect();
	}
	
	public Connection getDbConnection(){
		return dbObj.getConnection();
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void addNewThesisTitle(int groupNumber, String thesisType, String thesisTitle, String briefDescription, String member1, String member2, String member3, String member4){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = insertIntoFields("thesis_titles", "`group_number`, `thesis_type`, `thesis_title`, `brief_description`, `member_1`, `member_2`, `member_3`, `member_4`, `status`", "'"+groupNumber+"', '"+thesisType+"', '"+thesisTitle+"', '"+briefDescription+"', '"+member1+"', '"+member2+"', '"+member3+"', '"+member4+"', ''");
			st.execute(sqlQuery);
			
			setMessage("adding title successful");
		} catch(Exception e){
			setMessage("error adding new thesis title " + e);
			return;
		}
	}
	
	public boolean logIn(String username, String password, String table){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = selectFields("`username`, `password`",  table, "WHERE 1");
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				if(username.equals(rs.getString("username"))){
					if(password.equals(rs.getString("password"))){
						return true;
					}
				}
			}
			
			setMessage("error logging in: the information is not on the database");
			return false;
		} catch(Exception e){
			setMessage("error logging in " + e);
			return false;
		}
	}
	
	public void setUserName(String username){
		this.username = username;
	}
	
	public String getUserName(){
		return this.username;
	}
	
	public void setPanelistVew(String groupNumber){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = selectFields("`group_number`, `thesis_type`, `thesis_title`, `brief_description`, `member_1`, `member_2`, `member_3`, `member_4`", "thesis_titles", "WHERE `group_number`='"+groupNumber+"'");
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				setGroupNumber(rs.getInt("group_number"));
				setThesisType(rs.getString("thesis_type"));
				setThesisTitle(rs.getString("thesis_title"));
				setBriefDescription(rs.getString("brief_description"));
				setMembers(rs.getString("member_1"));
				setMembers(rs.getString("member_2"));
				setMembers(rs.getString("member_3"));
				setMembers(rs.getString("member_4"));
			}
			
		} catch(Exception e){
			setMessage("error setting panelist view " + e);
			return;
		}
	}
	
	public void updateStatus(String verdict){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = updateField("thesis_titles", "status", verdict, "`group_number`='"+getGroupNumber()+"'");
			st.execute(sqlQuery);			
			
			setMessage("update success");
		} catch(Exception e){
			setMessage("error updating status " + e);
			return;
		}
	}
	
	public void setGuestView(String viewAs){
		viewAs = viewAs.startsWith("g") ? viewAs.substring(1) : viewAs;
		
		try{
			st = getDbConnection().createStatement();
			sqlQuery = selectFields("`group_number`, `thesis_title`, `member_1`, `member_2`, `member_3`, `member_4`, `status`", "thesis_titles", !viewAs.equals("all") ? "WHERE `status`='"+viewAs+"'" : "");
			System.out.println(sqlQuery);
			rs = st.executeQuery(sqlQuery);
			
			while(rs.next()){
				setGuestGroupNumber(rs.getInt("group_number"));
				setGuestThesisTitle(rs.getString("thesis_title"));
				setGuestMembers(rs.getString("member_1"));
				setGuestMembers(rs.getString("member_2"));
				setGuestMembers(rs.getString("member_3"));
				setGuestMembers(rs.getString("member_4"));
				setGuestStatus(rs.getString("status"));
			}
			
		} catch(Exception e){
			setMessage("error setting guest view " + e);
			return;
		}
	}

	public void confirmUpdate(String thesisType, String thesisTitle, String description, String[] members){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = updateFields("thesis_titles", "`thesis_type`='"+thesisType+"', `thesis_title`='"+thesisTitle+"', `brief_description`='"+description+"'", "`group_number`='"+getGroupNumber()+"'");
			st.execute(sqlQuery);
			
			for(int i = 0; i<members.length; i++){
				sqlQuery = updateField("thesis_titles", "member_"+(i+1), members[i], "`group_number`='"+getGroupNumber()+"'");
				st.execute(sqlQuery);
			}
			
			setMessage("update success");
		} catch(Exception e){
			setMessage("error commiting update " + e);
			return;
		}
	}
	
	public void removeTitle(int groupNumber){
		try{
			st = getDbConnection().createStatement();
			sqlQuery = deleteFromField("thesis_titles", "group_number", Integer.toString(groupNumber));
			st.execute(sqlQuery);
			
			setMessage("successfully removed");
		} catch(Exception e){
			setMessage("error removing title " + e);
			return;
		}
	}
}
