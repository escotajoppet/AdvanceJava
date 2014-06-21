package HotelReservation;

public abstract class ClassBalanceInfo extends SQLStringClass {
	private double roomRate =0;
	private double totalBalance = 0;
	private double remainingBalance = 0;
	private double amountPaid =0;
	private double amountChange =0;
	
	public double getRoomRate() {
		return this.roomRate;
	}
	
	public void setRoomRate(double roomRate) {
		this.roomRate = roomRate;
	}
	
	public double getTotalBalance() {
		return this.totalBalance;
	}
	
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	public double getRemainingBalance() {
		return this.remainingBalance;
	}
	
	public void setRemainingBalance(double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	
	public double getAmountPaid() {
		return this.amountPaid;
	}
	
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public double getAmountChange() {
		return this.amountChange;
	}
	
	public void setAmountChange(double amountChange) {
		this.amountChange = amountChange;
	}
}
