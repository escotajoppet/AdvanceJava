package hotel.reservation;

import java.sql.*;

public class HotelReservation extends SqlStringCommands{
	private DatabaseConnection obj = new DatabaseConnection();
	private Connection dbCon = null;
	private ResultSet rs = null;
	private Statement st = null;
	
	private String sql = "";
	
	private String entryId = "";
	private String cityMunicipality = "";
	private String loggedIn = "";
	
	public HotelReservation(){
		dbCon = obj.getConnection();
	}
	
	public void getHotelList(){
		try{
			st = dbCon.createStatement();
			sql = selectFields("*", "hotellist", "`location`='"+getCityMunicipality()+"'");			
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setHotelId(rs.getInt("entry_id"));
				setHotelName(rs.getString("hotel_name"));
				setDescription(rs.getString("description"));
				setRouteFrom(rs.getString("route_from"));
				setLocation(rs.getString("location"));
			}
			
		} catch(Exception e){
			System.out.println("error getting hotel list " + e);
			return;
		}
	}
	
	public void setCityMunicipality(String cityMunicipalityName){
		this.cityMunicipality = cityMunicipalityName;
	}
	
	public String getCityMunicipality(){
		return this.cityMunicipality;
	}
	
	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public void addNewHotel(String hotelName,  String routeFrom, String description, String address, String contact){
		try{
			st = dbCon.createStatement();
			sql = insertIntoFields("hotellist", 
					"`hotel_name`, `location`, `route_from`, `description`", 
					"'"+hotelName+"', '"+getCityMunicipality()+"', '"+routeFrom+"', '"+description+"'");
			System.out.println(sql);
			st.execute(sql);
			
			sql = insertIntoFields("locationinformation", 
					"`hotelname`, `hotellocation`, `hoteladdress`, `hotelcontact`", 
					"'"+hotelName+"', '"+getCityMunicipality()+"', '"+address+"', '"+contact+"'");
			System.out.println(sql);
			st.execute(sql);
			
			System.out.println("adding hotel successful");
		} catch(Exception e){
			System.out.println("error adding new hotel " + e);
			return;
		}
	}
	
	public void removeHotel(String[] checks){		
		try{
			st = dbCon.createStatement();
			
			for(int i = 0; i<checks.length; i++){				
				sql = deleteFromField("hotellist", "entry_id", checks[i]);
				st.execute(sql);
				
				sql = deleteFromField("roominformation", "hotelid", checks[i]);
				st.execute(sql);
				
				sql = deleteFromField("promoinformation", "hotelid", checks[i]);
				st.execute(sql);
				
				sql = deleteFromField("locationinformation", "hotelid", checks[i]);
				st.execute(sql);
			}
			
			System.out.println("deleting hotel successful");
		} catch(Exception e){
			System.out.println("error deleting hotel " + e);
			return;
		}
	}
	
	public boolean login(String username, String password){
		try{
			st = dbCon.createStatement();
			sql = selectFields("`username`, `password`", "admin", "1");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				if(username.equals(rs.getString("username"))){
					if(password.equals(rs.getString("password"))){
						return true;
					}
				}
			}
			
			System.out.println("information is not in the database");
			return false;
		} catch(Exception e){
			System.out.println("error logging in " + e);
			return false;
		}
	}
	
	public void setLoggedIn(String loggedIn){
		this.loggedIn = loggedIn;
	}
	
	public String getLoggedIn(){
		return this.loggedIn;
	}
	
	public void addNewRoomInformation(String roomType, String roomDescription){
		try{
			st = dbCon.createStatement();
			sql = insertIntoFields("roominformation", "`hotelid`, `roomtype`, `roomdescription`",  "'"+getEntryId()+"', '"+roomType+"', '"+roomDescription+"'");
			st.execute(sql);
			
			System.out.println("success adding new room");
		} catch(Exception e){
			System.out.println("error adding new room info " + e);
			return;
		}
	}
	
	public void addNewPromoInformation(String promoName, String promoDescription){
		try{
			st = dbCon.createStatement();
			sql = insertIntoFields("promoinformation", "`hotelid`, `promoname`, `description`",  "'"+getEntryId()+"', '"+promoName+"', '"+promoDescription+"'");
			st.execute(sql);
			
			System.out.println("success adding new promo");
		} catch(Exception e){
			System.out.println("error adding new promo info " + e);
			return;
		}
	}
	
	public void setHotelLocation(){
		try{
			st = dbCon.createStatement();
			sql = selectFields("`hotelname`, `hotellocation`, `hoteladdress`, `hotelcontact`", "locationinformation", "`hotelid`='"+getEntryId()+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setViewHotelName(rs.getString("hotelname"));
				setViewHotelLocation(rs.getString("hotellocation"));
				setViewHotelAddress(rs.getString("hoteladdress"));
				setViewHotelContact(rs.getString("hotelcontact"));
			}
		} catch(Exception e){
			System.out.println("error setting hotel location " + e);
			return;
		}
	}
	
	public void setPromoInformation(){
		try{
			st = dbCon.createStatement();
			sql = selectFields("`promoname`, `description`", "promoinformation", "`hotelid`='"+getEntryId()+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setViewPromoName(rs.getString("promoname"));
				setViewPromoDescription(rs.getString("description"));
			}
		} catch(Exception e){
			System.out.println("error setting promo " + e);
			return;
		}
	}
	
	public void setRoomInformation(){
		try{
			st = dbCon.createStatement();
			sql = selectFields("`roomtype`, `roomdescription`", "roominformation", "`hotelid`='"+getEntryId()+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				setViewRoomType(rs.getString("roomtype"));
				setViewRoomDescription(rs.getString("roomdescription"));
			}
		} catch(Exception e){
			System.out.println("error setting room " + e);
			return;
		}
	}
}
