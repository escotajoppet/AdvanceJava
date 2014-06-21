package HotelReservation;

import java.util.ArrayList;

public abstract class ClassGeneralInfo extends ClassBalanceInfo{

	private String roomType ="";
	private String checkIn = "";
	private String checkOut = "";
	private int rooms =0;
	private int numOfDays = 0;
	private int roomCode = 0;
	private ArrayList<Integer> arrNumCode = new ArrayList<Integer>();
	private ArrayList<String> arrRoomType = new ArrayList<String>();
	private ArrayList<Integer> arrRooms = new ArrayList<Integer>();
	private ArrayList<String> arrCheckIn = new ArrayList<String>();
	private ArrayList<String> arrCheckOut = new ArrayList<String>();
	private ArrayList<Integer> arrDays = new ArrayList<Integer>();
	
	
	public int getRoomCode() {
		return this.roomCode;
	}
	
	public void setRoomCode(int roomCode) {
		this.roomCode = roomCode;
	}
	
	public String getRoomType() {
		return this.roomType;
	}
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public int getRooms() {
		return this.rooms;
	}
	
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	
	public int getNumberOfDays() {
		return this.numOfDays;
	}
	
	public void setNumberOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}
	
	public String getCheckIn() {
		return this.checkIn;
	}
	
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	
	public String getCheckOut() {
		return this.checkOut;
	}
	
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	
	////////////////////////////////////////////////
	
	public void setArrNumCode(int roomCode){
		this.arrNumCode.add(roomCode);
	}
	
	public ArrayList<Integer> getArrNumCode(){
		return this.arrNumCode;
	}

	public void setArrRoomType(String roomType){
		this.arrRoomType.add(roomType);
	}
	
	public ArrayList<String> getArrRoomType(){
		return this.arrRoomType;
	}
	
	public void setArrRooms(int rooms) {
		this.arrRooms.add(rooms);
	}
	
	public ArrayList<Integer> getArrRooms(){
		return this.arrRooms;
	}
	
	public void setArrCheckIn(String checkIn) {
		this.arrCheckIn.add(checkIn);
	}
	
	public ArrayList<String> getArrCheckIn(){
		return this.arrCheckIn;
	}
	
	public void setArrCheckOut(String checkOut) {
		this.arrCheckOut.add(checkOut);
	}
	
	public ArrayList<String> getArrCheckOut(){
		return this.arrCheckOut;
	}
	
	public void setArrDays(int days) {
		this.arrDays.add(days);
	}
	
	public ArrayList<Integer> getArrDays(){
		return this.arrDays;
	}
	
	public void clearArr() {
	 	arrCheckIn.clear();
	 	arrCheckOut.clear();
	 	arrDays.clear();
	 	arrNumCode.clear();
	 	arrRooms.clear();
	 	arrRoomType.clear();
	}
}
