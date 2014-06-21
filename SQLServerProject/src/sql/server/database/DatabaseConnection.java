package sql.server.database;

import java.sql.*;

public class DatabaseConnection {
	
	private static Connection dbCon = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	
	private static final String DATABASE = "/librarysystemdb";
	private static final String DRIVER = "net.sourceforge.jtds.jdbc.Driver";
	private static final String URL = "jdbc:jtds:sqlserver://127.0.0.1:1433";
	private static final String USER = "";
	private static final String PASSWORD = "";
	
	public static void connectToDb(){
		try{
			Class.forName(DRIVER).newInstance();
			dbCon = DriverManager.getConnection(URL + DATABASE, USER, PASSWORD);
			
			st = dbCon.createStatement();
			rs = st.executeQuery("SELECT [au_id], [au_fname], [au_lname] FROM [dbo].[authors] ORDER BY [au_id]");
			
			System.out.println("Connection Established\n");
			
			while(rs.next()){
				System.out.print(rs.getString("au_id") + " - ");
				System.out.print(rs.getString("au_fname") + " ");
				System.out.println(rs.getString("au_lname"));
			}
			
		} catch(Exception e){
			System.out.println("error connecting " + e);
			return;
		}
	}
	
	public static void main(String[] args){
		connectToDb();
	}
}
