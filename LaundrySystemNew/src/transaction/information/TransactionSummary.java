package transaction.information;

public abstract class TransactionSummary extends RecentTransaction{	
	int totalNumberOfClothes = 0;
	
	double amount = 0;
	double kilo = 0;

	int cntTshirt = 0;
	int cntShort = 0;
	int cntPants = 0;
	int cntUnderwear = 0;
	int cntOthers = 0;
	
	String typeOfWash = "";
	String modeOfPayment = "";
	String typeOfService = "";
	
	String userEmailAdd = "";

	public int getCntTshirt() {
		return cntTshirt;
	}

	public void setCntTshirt(int cntTshirt) {
		this.cntTshirt = cntTshirt;
	}

	public int getCntShort() {
		return cntShort;
	}

	public void setCntShort(int cntShort) {
		this.cntShort = cntShort;
	}

	public int getCntPants() {
		return cntPants;
	}

	public void setCntPants(int cntPants) {
		this.cntPants = cntPants;
	}

	public int getCntUnderwear() {
		return cntUnderwear;
	}

	public void setCntUnderwear(int cntUnderwear) {
		this.cntUnderwear = cntUnderwear;
	}

	public int getCntOthers() {
		return cntOthers;
	}

	public void setCntOthers(int cntOthers) {
		this.cntOthers = cntOthers;
	}

	public void setUserEmailAdd(String emailAdd){
		this.userEmailAdd = emailAdd;
	}
	
	public String getUserEmailAdd(){
		return this.userEmailAdd;
	}
	
	public void setTypeOfWash(String typeOfWash){
		this.typeOfWash = typeOfWash;
	}
	
	public String getTypeOfWash(){
		return this.typeOfWash;
	}
	
	public void setModeOfPayment(String modeOfPayment){
		this.modeOfPayment = modeOfPayment;
	}
	
	public String getModeOfPayment(){
		return this.modeOfPayment;
	}
	
	public void setTypeOfService(String typeOfService){
		this.typeOfService = typeOfService;
	}
	
	public String getTypeOfService(){
		return this.typeOfService;
	}
	
	public void setTotalNumberOfClothes(int total){
		this.totalNumberOfClothes = total;
	}
	
	public int getTotalNumberOfClothes(){
		return this.totalNumberOfClothes;
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	public double getAmount(){
		return this.amount;
	}
	
	public void setKiloCount(double kilo){
		this.kilo = kilo;
	}
	
	public double getKiloCount(){
		return this.kilo;
	}
}
