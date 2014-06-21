package art.gallery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.connect.DbConnect;

public class ArtGallery extends ArtWorks{
	DbConnect obj = new DbConnect();
	
	Statement st = null;
	ResultSet rs = null;

	String sql = "";
	String message = "";
	String penName = "";
	
	public Connection getDbConnection(){
		return obj.getConnection();
	}
	
	public void setPenName(String username){
		this.penName = username;
	}
	
	public String getPenName(){
		return this.penName;
	}

	public boolean logIn(String penName, String password){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`pen_name`, `password`",  "authors", "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				if(penName.equals(rs.getString("pen_name"))){
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
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void signUp(String firstName, String lastName, String penName, String password, String retypePassword){
		if(!password.equals(retypePassword)){
			setMessage("error registering: passwords don't match");
			return;
		}
		
		try{
			st = getDbConnection().createStatement();
			sql = insertIntoFields("authors", "`first_name`, `last_name`, `pen_name`, `password`", "'"+firstName+"', '"+lastName+"', '"+penName+"', '"+password+"'");
			st.execute(sql);
			
			setMessage("successfully registered");
		} catch(Exception e){
			setMessage("error registering new user " + e);
			return;
		}
	}
	
	public void addNewArt(String category, String artTitle, String artLocation){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:MM:ss");
		Date date = new Date();
		
		if(category.equals("")){
			setMessage("please indicate the category of your new art");
			return;
		}
		
		try{
			st = getDbConnection().createStatement();
			sql = insertIntoFields("artwork", "`artdate`, `author`, `arttitle`, `category`", "'"+df.format(date)+"', '"+getPenName()+"', '"+artTitle+"', '"+category+"'");
			st.execute(sql);
			
			sql = insertIntoFields("gallery", "`arttitle`, `gallerylocation`, `author`", "'"+artTitle+"', '"+artLocation+"', '"+getPenName()+"'");
			st.execute(sql);
			
			setMessage("successfully added");
		} catch(Exception e){
			setMessage("error adding new art " + e);
			return;
		}
	}
	
	public void viewContributions(){
		try{
			st = getDbConnection().createStatement();
			
			sql = selectFields("*", "artwork", "`author`='"+getPenName()+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setArtEntryNumber(rs.getInt("artid"));
				setArtEntryTitle(rs.getString("arttitle"));
				setArtEntryDate(rs.getString("artdate"));
				setArtCategory(rs.getString("category"));
			}
			
			sql = selectFields("`gallerylocation`", "gallery", "`author`='"+getPenName()+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setArtLocation(rs.getString("gallerylocation"));
			}
			
		} catch(Exception e){
			setMessage("error viewing contributions " + e);
			return;
		}
	}	
	
	public void searchArtwork(String keyword, String searchBy){
		String condition = searchBy.equals("") ? "1" : "`"+searchBy+"` REGEXP '"+keyword+"'";
		
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`artid`, `artdate`, `arttitle`, `author`, `category`", "artwork", condition);
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setArtEntryNumber(rs.getInt("artid"));
				setArtEntryTitle(rs.getString("arttitle"));
				setArtAuthor(rs.getString("author"));
				setArtEntryDate(rs.getString("artdate"));
				setArtCategory(rs.getString("category"));
			}
			
			sql = selectFields("`gallerylocation`", "gallery", condition);
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setArtLocation(rs.getString("gallerylocation"));
			}
		} catch(Exception e){
			setMessage("error searching artwork " + e);
			return;
		}
	}
	
	public void deleteArt(String entryNumber){
		try{
			st = getDbConnection().createStatement();
			
			sql = deleteFromField("artwork", "artid", entryNumber);
			st.execute(sql);
			
			sql = deleteFromField("gallery", "artid", entryNumber);
			st.execute(sql);
			
			sql = deleteFromField("comments", "artid", entryNumber);
			st.execute(sql);
			
		} catch(Exception e){
			setMessage("error deleting " + e);
			return;
		}
	}	
	
	public void viewComments(){
		try{
			st = getDbConnection().createStatement();
			
			sql = selectFields("`commentid`, `comment`", "comments", "`artid`='"+getSelectedEntryId()+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setCommentArtId(rs.getInt("commentid"));
				setCommentComments(rs.getString("comment"));
			}
			
		} catch(Exception e){
			setMessage("error viewing comments " + e);
			return;
		}
	}
	
	public void updateArt(String newArtTitle, String newCategory){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:MM:ss");
		Date date = new Date();
		
		try{
			st = getDbConnection().createStatement();
			
			if(newCategory.equalsIgnoreCase(getSelectedTableName())){
				sql = updateFields(getSelectedTableName(), "`entry_date_time`='"+df.format(date)+"', `art_title`='"+newArtTitle+"'", "`entry_number`='"+getSelectedEntryId()+"'");
				st.execute(sql);
			} else{
				sql = insertIntoFields(newCategory, "`entry_date_time`, `art_title`, `art_author`",  "'"+df.format(date)+"', '"+newArtTitle+"', '"+getPenName()+"'");
				st.execute(sql);
				sql = deleteFromField(getSelectedTableName(), "entry_number", Integer.toString(getSelectedEntryId()));
				st.execute(sql);
			}
			
		} catch(Exception e){
			setMessage("error updating art " + e);
			return;
		}
	}
	
	public void confirmUpdate(String[] updateCategories){
		try{
			st = getDbConnection().createStatement();
			
			for(int i = 0; i<getArtEntryNumber().size(); i++){
				sql = updateField("artwork", "category", updateCategories[i], "`artid`='"+getArtEntryNumber().get(i)+"'");
				System.out.println(sql);
				st.execute(sql);
			}
		} catch(Exception e){
			setMessage("error confirming update " + e);
			return;
		}
	}
	
	public void postComment(String fieldValues, String comment){
		String[] info = fieldValues.split("/");
		
		try{
			st = getDbConnection().createStatement();
			sql = insertIntoFields("comments", "`artid`, `arttitle`, `author`, `comment`", "'"+info[1]+"', '"+info[2]+"', '"+info[3]+"', '"+comment+"'");
			st.execute(sql);
			
		} catch(Exception e){
			setMessage("error posting comment " + e);
			return;
		}
	}
}
