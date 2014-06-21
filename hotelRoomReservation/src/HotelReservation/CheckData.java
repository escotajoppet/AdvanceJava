package HotelReservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public abstract class CheckData extends ClassCustomerInfo {	
	public String checkAvailability(String checkInDate, String roomType, int numRoom) throws Exception {
		String ret = "";
		int roomNum1 = 0;
		checkInDate = checkInDate.replaceAll("-", "");
		int checkInDate1 = Integer.parseInt(checkInDate);
		Connection conn = connectDB();
		Statement st = conn.createStatement();
		//String query = "SELECT `check_in`, `check_out`,`rooms`,`room_type` FROM `general_info`";
		String query = sqlSelectQuery("`check_in`, `check_out`,`rooms`,`room_type`", "`general_info`","");
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			int checkIn1 = Integer.parseInt(rs.getString("check_in").replaceAll("-", ""));
			int checkOut1 = Integer.parseInt(rs.getString("check_out").replaceAll("-", ""));
			if(checkInDate1 >= checkIn1 && checkInDate1 <= checkOut1) {
				if(roomType.equals(rs.getString("room_type"))) {
					roomNum1 = roomNum1 + rs.getInt("rooms");
				}
			}
		}
		if(roomNum1 < 5) {
			if(numRoom > (5-roomNum1)) {
				ret = "error";
			}
		}		
		return ret;	
	}
	
	public String checkCode(int code) throws Exception {
		String ret = "";
		int code1 = 0;
		Connection conn = connectDB();
		Statement st = conn.createStatement();
		//String query = "SELECT `code` FROM `customer_info` WHERE `code` ='"+code+"'";
		String query = sqlSelectQuery("`code`", "`customer_info`", "WHERE `code` ='"+code+"'");
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			code1 = rs.getInt("code");
		}
		if(code1 == 0) {
			ret= "error";
		}
		return ret;		
	}

	public long numberOfDays(String checkIn, String checkOut) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date chkIn = sdf.parse(checkIn);
		Date chkOut = sdf.parse(checkOut);
		long dayMillis = chkOut.getTime() - chkIn.getTime();
		long day = TimeUnit.MILLISECONDS.toDays(dayMillis);
		return day;
	}
	
	public int chkRoomCode() {
		try{
			Connection conn = connectDB();
			ArrayList <Integer> arrCode = new ArrayList<Integer>();
			Statement st = conn.createStatement();
			//String query = "SELECT code FROM `customer_info`";
			String query =sqlSelectQuery("`code`", "`customer_info`", "");
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				arrCode.add(rs.getInt("code"));
			}
			if(arrCode.isEmpty()) {
				setRoomCode(2014000);
			} else {
				setRoomCode(arrCode.get(arrCode.size() -1) +1);
			}	
		} catch(Exception e){}
		return getRoomCode();
	}
}
