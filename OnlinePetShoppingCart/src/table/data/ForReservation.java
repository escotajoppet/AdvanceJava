package table.data;

public abstract class ForReservation extends ReservationTable{
	int entryId = 0;
	int quantity = 0;
	
	double totalPrice = 0;
	
	String breedName = "";
	String name = "";
	String address = "";
	String contactNumber = "";
	String reservedOrder = "";
	String date = "";
	String itemName = "";
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getReservedEntryId() {
		return entryId;
	}
	
	public void setReservedEntryId(int entryId) {
		this.entryId = entryId;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getBreedName() {
		return breedName;
	}
	
	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getReservedOrder() {
		return reservedOrder;
	}
	
	public void setReservedOrder(String reservedOrder) {
		this.reservedOrder = reservedOrder;
	}
}
