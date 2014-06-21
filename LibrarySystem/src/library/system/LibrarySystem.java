package library.system;

import database.data.Booklist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

import database.connection.ConnectToDb;

public class LibrarySystem extends Booklist{
	ConnectToDb objConDb = new ConnectToDb();
	
	Statement st = null;
	ResultSet rs = null;
	String query = "";
	String message = "";
	
	public Connection getConnection(){
		return objConDb.getConnection();
	}
	
	public void viewAllBooks(){
		try{
			st = getConnection().createStatement();
			query = selectFields("`control_number`, `book_title`, `author`, `year_published`, `availability`", "books", "1");			
			rs = st.executeQuery(query);
			
			while(rs.next()){
				setControlNumber(rs.getString("control_number"));
				setBook_title(rs.getString("book_title"));
				setAuthor(rs.getString("author"));
				setYear_Published(rs.getInt("year_published"));
				setAvailability(rs.getString("availability"));
			}
			
		} catch(Exception e){
			setMessage("error viewing all books " + e);
			return;
		}
	}
	
	public boolean logIn(String username, String password){
		try{
			st = getConnection().createStatement();
			query = selectFields("`username`, `password`", "admin_user", "1");

			rs = st.executeQuery(query);
			
			while(rs.next()){
				setAdminUsername(rs.getString("username"));
				setAdminPassword(rs.getString("password"));			
			}
			
			for (String userName:getAdminUsername()) {
				if(userName.equals(username)){
					if(getAdminPassword().get(getAdminUsername().indexOf(userName)).equals(password)){
						return true;
					}
				}
			}
			
			setMessage("error logging in, the information is invalid");
			return false;
		} catch(Exception e){
			setMessage("error logging in hello " + e);
			return false;
		}
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void search (String keyword, String category){
		try{
			st = getConnection().createStatement();
			query = selectFields("*", "books", category + " REGEXP '"+keyword+"'");
			rs = st.executeQuery(query);
			
			while(rs.next()){
				setControlNumber(rs.getString("control_number"));
				setBook_title(rs.getString("book_title"));
				setAuthor(rs.getString("author"));
				setYear_Published(rs.getInt("year_published"));
				setAvailability(rs.getString("availability"));				
			}
					
		}catch(Exception e){
			setMessage("error logging in " + e);
			return;
		}
	}
	
	public void addbook (String controlnumber, String booktitle, String author, String yearpublished){
		try{
			int year = Integer.parseInt(yearpublished);
			st = getConnection().createStatement();
			query = insertIntoFields("books", "`control_number`, `book_title`, `author`, `year_published`, `availability`", "'"+controlnumber+"','"+booktitle+"', '"+author+"', "+year+", 'Available'");
			st.execute(query);
			setMessage("Successfully added!");
		}catch(Exception e){
			setMessage("error adding book " + e);
			return;
		}
	}
	
	public void deletebook (String [] deletebook){
		try{
			st = getConnection().createStatement();
			for(int i=0; i<deletebook.length; i++){
				query = deleteFromField("books", "control_number", deletebook[i]);
				st.execute(query);
			}
			
		}catch(Exception e){
			setMessage("error deleting " + e);
			return;
		}
	}
	
	public void setBooksToBorrow(String[] bookstoborrow){
		try{
			st = getConnection().createStatement();
			for(int i =0; i<bookstoborrow.length; i++){
				query = selectFields("`control_number`, `book_title`, `author`, `year_published`", "books", "`control_number`='"+bookstoborrow[i]+"'");
				rs = st.executeQuery(query);

				while(rs.next()){
					setControlNumber(rs.getString("control_number"));
					setBook_title(rs.getString("book_title"));
					setAuthor(rs.getString("author"));
					setYear_Published(rs.getInt("year_published"));
				}
			}
		} catch(Exception e){
			setMessage("error setting books to borrow " + e);
			return;
		}
	}
	
	public void borrowBooks(String studentName, String studentNumber, String transaction, String[] bookstoborrow){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();

		String borrowedBookTitle = "";
		String borrowedAuthor = "";
		int borrowedYearPublished = 0;
		String borrowerNameAndId = "";
		
		try{
			st = getConnection().createStatement();
			query = insertIntoFields("guest_logs", "`student_number`, `name`, `date_time`, `transaction`", "'"+studentNumber+"', '"+studentName+"', '"+dateFormat.format(date)+"', '"+transaction+"'");
			st.execute(query);
			
			for(int i = 0; i<bookstoborrow.length; i++){
				query = updateField("books", "availability", "Borrowed", "`control_number`='"+bookstoborrow[i]+"'");
				st.execute(query);
				
				query = selectFields("*", "books", "`control_number`='"+bookstoborrow[i]+"'");
				rs = st.executeQuery(query);
				
				while(rs.next()){
					borrowedBookTitle = rs.getString("book_title");
					borrowedAuthor = rs.getString("author");
					borrowedYearPublished = rs.getInt("year_published");
				}
				
				borrowerNameAndId = studentNumber + " / " + studentName;
				
				query = insertIntoFields("borrowed_books", "`control_number`, `book_title`, `author`, `year_published`, `borrower`", "'"+bookstoborrow[i]+"', '"+borrowedBookTitle+"', '"+borrowedAuthor+"', "+borrowedYearPublished+", '"+borrowerNameAndId+"'");
				st.execute(query);
			}
			
		} catch(Exception e){
			setMessage("error borrowing books " + e);
			return;
		}
	}
	
	public void setBooksToReturn(){		
		try{
			st = getConnection().createStatement();
			query = selectFields("`control_number`", "borrowed_books", "`borrower` REGEXP '"+getId()+"'");
			rs = st.executeQuery(query);
			
			while(rs.next()){
				setBorrowedControlNumber(rs.getString("control_number")); 
			}
			
			for(int i =0; i<getBorrowedControlNumber().size(); i++){
				query = selectFields("`control_number`, `book_title`, `author`, `year_published`", "borrowed_books", "`control_number`='"+getBorrowedControlNumber().get(i)+"'");
				rs = st.executeQuery(query);

				while(rs.next()){
					setBorrowedBookTitle(rs.getString("book_title"));
					setBorrowedAuthor(rs.getString("author"));
					setBorrowedYearPublished(rs.getInt("year_published"));
				}
			}
			
		} catch(Exception e){
			setMessage("error returning books2 " + e);
			return;
		}
	}
	
	public void returnBooks(String transaction, String[] bookstoreturn){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		try{
			st = getConnection().createStatement();
			query = insertIntoFields("guest_logs", "`student_number`, `name`, `date_time`, `transaction`", "'"+getId()+"', '"+getName()+"', '"+dateFormat.format(date)+"', '"+transaction+"'");
			st.execute(query);
			
			for(int i = 0; i<bookstoreturn.length; i++){
				query = updateField("books", "availability", "Available", "`control_number`='"+bookstoreturn[i]+"'");
				st.execute(query);
				
				query = deleteFromField("borrowed_books", "control_number", bookstoreturn[i]);
				st.execute(query);
			}
			
		} catch(Exception e){
			setMessage("error returning books " + e);
			return;
		}
	}
	
	public void viewGuestLogs(){
		try{
			st = getConnection().createStatement();
			query = selectFields("`student_number`, `name`, `date_time`, `transaction`",  "guest_logs", "1");
			rs = st.executeQuery(query);
			
			while(rs.next()){
				setLogsStudentNumber(rs.getString("student_number"));
				setLogsName(rs.getString("name"));
				setLogsTransaction(rs.getString("transaction"));
				setLogsDateTime(rs.getString("date_time"));
			}
		} catch(Exception e){
			setMessage("error viewing guest logs " + e);
			return;
		}
	}
	
	public void viewBorrowedBooks(){
		try{
			st = getConnection().createStatement();
			query = selectFields("`control_number`, `book_title`, `author`, `year_published`, `borrower`",  "borrowed_books", "1");
			rs = st.executeQuery(query);
			
			while(rs.next()){
				setBorrowedControlNumber(rs.getString("control_number"));
				setBorrowedBookTitle(rs.getString("control_number"));
				setBorrowedAuthor(rs.getString("control_number"));
				setBorrowedYearPublished(rs.getInt("control_number"));
				setBorrowedBorrower(rs.getString("borrower"));
			}
		} catch(Exception e){
			setMessage("error viewing borrowed books" + e);
			return;
		}
	}
}