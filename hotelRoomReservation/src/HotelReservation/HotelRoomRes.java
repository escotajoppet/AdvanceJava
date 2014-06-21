package HotelReservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class HotelRoomRes extends SQLManagerClass {
	
	public int createResCustomer() {
		setRoomCode(chkRoomCode());
		String column = "`code`, `first_name`, `last_name`, `address`,`contact_number`,`email_address`";
		String values = "'"+getRoomCode()+"', '"+getfName()+"', '"+getlName()+"', '"+getAddress()+"', '"+getContact()+"', '"+getEmail()+"'";
		sqlInsert("customer_info", column, values);
		return getRoomCode();
	}
	

	public void createResGeneral() {
		String column = "`code`, `room_type`, `rooms`, `check_in`,`check_out`,`days`";
		String values = "'"+getRoomCode()+"', '"+getRoomType()+"', '"+getRooms()+"', '"+getCheckIn()+"', '"+getCheckOut()+"', '"+getNumberOfDays()+"'";
		sqlInsert("general_info", column, values);
	}
		
	public void createResBalance() {
		setTotal();
		String column = "`code`, `room_type`, `number_of_rooms`,`rate`,`total_balance`,`number_of_days`,`remaining_balance`,`amount_paid`";
		String values = "'"+getRoomCode()+"', '"+getRoomType()+"', '"+getRooms()+"', '"+getRoomRate()+"', '"+getTotalBalance()+"', '"+getNumberOfDays()+"', '"+getTotalBalance()+"','0'";
		sqlInsert("balance_info", column, values);
	}
			
	public int updateResCustomer() {
		String values = "`first_name` ='"+getfName()+"', `last_name` ='"+getlName()+"', `address`= '"+getAddress()+"',`contact_number` = '"+getContact()+"',`email_address`='"+getEmail()+"'";
		String condition = "`code` = '"+getRoomCode()+"'";
		sqlUpdate("customer_info", values, condition);
		return getRoomCode();
	}
	
	public void updateResGeneral() {
		String values = "`room_type` ='"+getRoomType()+"', `rooms` ='"+getRooms()+"', `check_in`= '"+getCheckIn()+"',`check_out` = '"+getCheckOut()+"',`days`='"+getNumberOfDays()+"'";
		String condition = "`code` = '"+getRoomCode()+"'";
		sqlUpdate("general_info", values, condition);
	}
	
	public void updateResBalance() {
		setTotal();
		String values = "`room_type` ='"+getRoomType()+"', `number_of_rooms` ='"+getRooms()+"', `rate`= '"+getRoomRate()+"',`total_balance` = '"+getTotalBalance()+"',`number_of_days`='"+getNumberOfDays()+"',`remaining_balance` = '"+getTotalBalance()+"',`amount_paid` = '0'";
		String condition = "`code` = '"+getRoomCode()+"'";
		sqlUpdate("balance_info", values, condition);
	}
	
	public void deleteRes() {
		String condition = "`code`='"+getRoomCode()+"'";
		sqlDelete("customer_info", condition);
		sqlDelete("balance_info", condition);
		sqlDelete("general_info", condition);
		
	}
	
	public void setTotal() {
		double rate = 0;
		if(getRoomType().equals("standardRoom")) {
			rate = 5000.00;
		} else if(getRoomType().equals("familyRoom")) {
			rate = 15000.00;
		} else if(getRoomType().equals("suite")) {
			rate = 30000.00;
		}
		setRoomRate(rate);
		setTotalBalance(getRoomRate() * getRooms() * getNumberOfDays());		
	}
	
	public void paymentRes(int code, double amount) throws Exception {		
		Connection conn = connectDB();
		Statement st = conn.createStatement();
		String query = sqlSelectQuery("`remaining_balance`,`amount_paid`", "`balance_info`", "WHERE `code` = '"+code+"'");
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			if(rs.getDouble("remaining_balance") > amount) {
				setRemainingBalance(rs.getDouble("remaining_balance") - amount);
				setAmountChange(0);
				setAmountPaid(rs.getDouble("amount_paid") + amount);			
			} else {
				setAmountPaid(rs.getDouble("amount_paid") + rs.getDouble("remaining_balance"));
				setRemainingBalance(0);
				setAmountChange(amount - rs.getDouble("remaining_balance"));
			}
		}
		
		sqlUpdate("balance_info", "`remaining_balance` ='"+getRemainingBalance()+"', `amount_paid` ='"+getAmountPaid()+"'", "`code` = '"+code+"'");	
	}
	
}
