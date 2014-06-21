package transaction.information;

import java.util.ArrayList;

import sql.string.commands.SqlStringCommands;

public abstract class RecentTransaction extends SqlStringCommands{
	ArrayList<Integer> recentNumberOfTShirts = new ArrayList<Integer>();
	ArrayList<Integer> recentNumberOfShorts = new ArrayList<Integer>();
	ArrayList<Integer> recentNumberOfPants = new ArrayList<Integer>();
	ArrayList<Integer> recentNumberOfUnderwear = new ArrayList<Integer>();
	ArrayList<Integer> recentNumberOfOthers = new ArrayList<Integer>();
	ArrayList<Integer> recentTotalNumberOfClothes = new ArrayList<Integer>();
	ArrayList<Double> recentAmount = new ArrayList<Double>();
	ArrayList<Double> recentKilo = new ArrayList<Double>();
	ArrayList<String> recentTypeOfWash = new ArrayList<String>();
	ArrayList<String> recentTypeOfService = new ArrayList<String>();
	ArrayList<String> recentModeOfPayment = new ArrayList<String>();
	ArrayList<String> recentDate = new ArrayList<String>();
	ArrayList<String> recentStatus = new ArrayList<String>();
	ArrayList<String> recentEmail= new ArrayList<String>();
	
	public void clearRecentTransaction(){
		this.recentAmount.clear();
		this.recentDate.clear();
		this.recentModeOfPayment.clear();
		this.recentTotalNumberOfClothes.clear();
		this.recentTypeOfService.clear();
		this.recentTypeOfWash.clear();
		this.recentStatus.clear();
		this.recentEmail.clear();
		this.recentNumberOfOthers.clear();
		this.recentNumberOfPants.clear();
		this.recentNumberOfShorts.clear();
		this.recentNumberOfTShirts.clear();
		this.recentNumberOfUnderwear.clear();
	}
	
	public ArrayList<Integer> getRecentNumberOfTShirts() {
		return recentNumberOfTShirts;
	}

	public void setRecentNumberOfTShirts(int recentNumberOfTShirts) {
		this.recentNumberOfTShirts.add(recentNumberOfTShirts);
	}

	public ArrayList<Integer> getRecentNumberOfShorts() {
		return recentNumberOfShorts;
	}

	public void setRecentNumberOfShorts(int recentNumberOfShorts) {
		this.recentNumberOfShorts.add(recentNumberOfShorts);
	}

	public ArrayList<Integer> getRecentNumberOfPants() {
		return recentNumberOfPants;
	}

	public void setRecentNumberOfPants(int recentNumberOfPants) {
		this.recentNumberOfPants.add(recentNumberOfPants);
	}

	public ArrayList<Integer> getRecentNumberOfUnderwear() {
		return recentNumberOfUnderwear;
	}

	public void setRecentNumberOfUnderwear(int recentNumberOfUnderwear) {
		this.recentNumberOfUnderwear.add(recentNumberOfUnderwear);
	}

	public ArrayList<Integer> getRecentNumberOfOthers() {
		return recentNumberOfOthers;
	}

	public void setRecentNumberOfOthers(int recentNumberOfOthers) {
		this.recentNumberOfOthers.add(recentNumberOfOthers);
	}

	public void setRecentDate(String date){
		this.recentDate.add(date);
	}
	
	public ArrayList<String> getRecentDate(){
		return this.recentDate;
	}
	
	public void setRecentEmail(String emailadd){
		this.recentEmail.add(emailadd);
	}
	
	public ArrayList<String> getRecentEmail(){
		return this.recentEmail;
	}
	
	public void setRecentTotalNumberOfClothes(int number){
		this.recentTotalNumberOfClothes.add(number);
	}
	
	public ArrayList<Integer> getRecentTotalNumberOfClothes(){
		return this.recentTotalNumberOfClothes;
	}
	
	public void setRecentAmount(double amount){
		this.recentAmount.add(amount);
	}
	
	public ArrayList<Double> getRecentAmount(){
		return this.recentAmount;
	}
	
	public void setRecentTypeOfWash(String typeOfWash){
		this.recentTypeOfWash.add(typeOfWash);
	}
	
	public ArrayList<String> getRecentTypeOfWash(){
		return this.recentTypeOfWash;
	}
	
	public void setRecentModeOfPayment(String modeOfPayment){
		this.recentModeOfPayment.add(modeOfPayment);
	}
	
	public ArrayList<String> getRecentModeOfPayment(){
		return this.recentModeOfPayment;
	}
	
	public void setRecentTypeOfService(String typeOfService){
		this.recentTypeOfService.add(typeOfService);
	}
	
	public ArrayList<String> getRecentTypeOfService(){
		return this.recentTypeOfService;
	}
	
	public void setRecentKilo(double kilo){
		this.recentKilo.add(kilo);
	}
	
	public ArrayList<Double> getRecentKilo(){
		return this.recentKilo;
	}
	
	public void setRecentStatus(String status){
		this.recentStatus.add(status);
	}
	
	public ArrayList<String> getRecentStatus(){
		return this.recentStatus;
	}
}
