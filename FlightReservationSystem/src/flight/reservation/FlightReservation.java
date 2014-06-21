package flight.reservation;

import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import sql.string.commands.SqlStringCommands;
import database.connect.*;

public class FlightReservation extends SqlStringCommands{
	DbConnect obj = new DbConnect();
	
	DecimalFormat df = new DecimalFormat("#.##");
	
	Statement st = null;
	ResultSet rs = null;
	
	String message = "";
	String sql = "";
	String emailAdd = "";
	
	public Connection getDbConnection(){
		return obj.getConnection();
	}
	
	public void registerUser(String fullName, String address, String mobile, String emailAdd, String password, String retypePass){
		if(!password.equals(retypePass)){
			setMessage("passwords dont match");
			return;
		}
		
		try{
			st = getDbConnection().createStatement();
			sql = insertIntoFields("customers", "`full_name`, `address`, `mobile_number`, `email_address`, `password`", "'"+fullName+"', '"+address+"', '"+mobile+"', '"+emailAdd+"', '"+password+"'");
			st.execute(sql);
			
			setMessage("registration successful");
		} catch(Exception e){
			setMessage("error registering " + e);
			return;
		}
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public boolean logIn(String emailAdd, String password){
		System.out.println(emailAdd + " " + password);
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`email_address`, `password`",  "customers", "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				if(emailAdd.equals(rs.getString("email_address"))){
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
	
	public boolean logInAdmin(String username, String password){
		System.out.println(username + " " + password);
		
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("`username`, `password`",  "admin", "1");
			rs = st.executeQuery(sql);
			
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
			setMessage("error admin logging in " + e);
			return false;			
		}
	}
	
	public void setUser(String emailAdd){
		this.emailAdd = emailAdd;
	}
	
	public String getUser(){
		return this.emailAdd;
	}
	
	public void bookFlight(String from, String to, String departureDateTime, String arrivalDateTime, int numberOfPersons){
		departureDateTime = departureDateTime.replace("T", " ");
		arrivalDateTime = arrivalDateTime.replace("T", " ");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		double flightAmount = 0;
		double additionalAmount = 2367.56;
		double personAmount = 0;
		double totalAmount = 0;
		
		switch(to){
			case "China":
				flightAmount = 14170;
				break;
			case "Japan":
				flightAmount = 17836;
				break;
			case "Korea":
				flightAmount = 43641;
				break;
			case "Malaysia":
				flightAmount = 5311;
				break;
			case "Philippines":
				flightAmount = 2286;
				break;
			case "Singapore":
				flightAmount = 4400;
				break;
			case "Thailand":
				flightAmount = 10995;
				break;
			case "UAE":
				flightAmount = 28854;
				break;
			default:
				flightAmount = 0;
				break;				
		}
		
		personAmount = flightAmount * numberOfPersons;
		totalAmount = personAmount + additionalAmount;
		
		try{
			st = getDbConnection().createStatement();
			sql = insertIntoFields("booked_flight", "`time_of_booking`, `email_address`, `from_location`, `to_location`, `departure`, `arrival`, `no_of_persons`, `status`", "'"+dateFormat.format(date)+"', '"+getUser()+"', '"+from+"', '"+to+"', '"+departureDateTime+"', '"+arrivalDateTime+"', "+numberOfPersons+", 'Confirmed'");
			st.execute(sql);
			
			setBookingDate(dateFormat.format(date));
			setFrom(from);
			setTo(to);
			setDepartureDateTime(departureDateTime);
			setArrivalDateTime(arrivalDateTime);
			setNumberOfPersons(numberOfPersons);
			setFlightAmount(flightAmount);
			setPersonAmount(personAmount);
			setTotalAmount(totalAmount);
			
			setMessage("successfully booked flight");
		} catch(Exception e){
			setMessage("error booking flight " + e);
			return;
		}
	}
	
	public void setTransactionInformation(){
		try{
			st = getDbConnection().createStatement();
			sql = selectFields("*", "booked_flight", "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setTransactionDeparture(rs.getString("departure"));
				setTransactionEmailAddress(rs.getString("email_address"));
				setTransactionFromLocation(rs.getString("from_location"));
				setTransactionStatus(rs.getString("status"));
				setTransactionTimeOfBooking(rs.getString("time_of_booking"));
				setTransactionToLocation(rs.getString("to_location"));
			}
			
		} catch(Exception e){
			setMessage("error setting transaction information " + e);
			return;
		}
	}
	
	public void deleteTransaction(String timeDate){
		System.out.println(timeDate);
		
		try{
			st = getDbConnection().createStatement();
			sql = deleteFromField("booked_flight", "time_of_booking", timeDate);
			System.out.println(sql);
			st.execute(sql);
			
		} catch(Exception e){
			setMessage("error deleting " + e);
			return;
		}
	}
	
	public void updateTransaction(String[] status){
		try{
			st = getDbConnection().createStatement();
			
			for(int i =0; i<getTransactionStatus().size(); i++){
				sql = updateField("booked_flight", "status", status[i], "`time_of_booking`='"+getTransactionTimeOfBooking().get(i)+"'");
				st.execute(sql);
			}
			
		} catch(Exception e){
			setMessage("error updating " + e);
			return;
		}
	}
}
