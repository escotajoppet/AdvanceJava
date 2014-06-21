package HotelReservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class SQLManagerClass extends CheckData {

	public void sqlInsert(String table, String column, String values) {
		try{			
			Connection conn = connectDB();
			String query = sqlInsertQuery(table, column, values);
			Statement st = conn.createStatement();
			st.execute(query);
			conn.commit();						
		} catch(Exception e) {}			
	}
	
	public void sqlUpdate(String table, String values, String condition) {
		try {
			Connection conn = connectDB();
			String query = sqlUpdateQuery(table, values, condition);
			Statement st = conn.createStatement();
			st.execute(query);
			conn.commit();	
		} catch(Exception e) {}
	}
	
	public void sqlDelete(String table, String condition) {
		try{
			Connection conn = connectDB();
			String query = sqlDeleteQuery(table, condition);
			Statement st = conn.createStatement();
			st.execute(query);
			conn.commit();					
		}catch(Exception e) {}
	}
	
	public void viewBalanceInfo() throws Exception {
		Connection conn = connectDB();
		Statement st = conn.createStatement();
		String query = sqlSelectQuery("*", "`balance_info`", "WHERE `code` ='"+getRoomCode()+"'");
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			setRoomCode(rs.getInt("code"));
			setRoomType(rs.getString("room_type"));
			setRooms(rs.getInt("number_of_rooms"));
			setNumberOfDays(rs.getInt("number_of_days"));
			setRoomRate(rs.getDouble("rate"));
			setTotalBalance(rs.getDouble("total_balance"));
			setRemainingBalance(rs.getDouble("remaining_balance"));
			setAmountPaid(rs.getDouble("amount_paid"));		
		}	
	}
	
	public void viewAllGeneralInfo() throws Exception {
		Connection conn = connectDB();
		Statement st = conn.createStatement();
		String query = sqlSelectQuery("*", "`general_info`", "");
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			setArrNumCode(rs.getInt("code"));
			setArrRoomType(rs.getString("room_type"));
			setArrRooms(rs.getInt("rooms"));
			setArrCheckIn(rs.getString("check_in"));
			setArrCheckOut(rs.getString("check_out"));
			setArrDays(rs.getInt("days"));
		}		
	}
	
	public void viewCustomerInfo() throws Exception {
		Connection conn = connectDB();
		Statement st = conn.createStatement();
		String query = sqlSelectQuery("*", "`customer_info`", "WHERE `code` ='"+getRoomCode()+"'");
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			setRoomCode(rs.getInt("code"));
			setfName(rs.getString("first_name"));
			setlName(rs.getString("last_name"));
			setAddress(rs.getString("address"));
			setContact(rs.getInt("contact_number"));
			setEmail(rs.getString("email_address"));
		}	
	}
}
