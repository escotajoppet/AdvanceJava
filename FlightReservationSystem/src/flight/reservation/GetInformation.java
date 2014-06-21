package flight.reservation;

public abstract class GetInformation extends TransactionInformation{
	String bookingDate = "";
	String from = "";
	String to = "";
	String departureDateTime = "";
	String arrivalDateTime = "";
	
	double totalAmount = 0;
	int numberOfPersons = 0;
	double flightAmount = 0;
	double personAmount = 0;
	
	public double getFlightAmount() {
		return flightAmount;
	}
	public void setFlightAmount(double flightAmount) {
		this.flightAmount = flightAmount;
	}
	public double getPersonAmount() {
		return personAmount;
	}
	public void setPersonAmount(double personAmount) {
		this.personAmount = personAmount;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	public String getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setArrivalDateTime(String arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getNumberOfPersons() {
		return numberOfPersons;
	}
	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}	
}
