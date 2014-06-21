package pharmacy.system;

import java.util.ArrayList;

public abstract class TableData {
	public ArrayList<String> arrMedicineList = new ArrayList<String>();
	public ArrayList<Double> arrAmount = new ArrayList<Double>();
	public ArrayList<Integer> arrNumber = new ArrayList<Integer>();
	public ArrayList<String> arrCartMedicineList = new ArrayList<String>();
	public ArrayList<Double> arrCartAmount = new ArrayList<Double>();
	public double total = 0;
	
	public void setArrAmount(double amount) {
		arrAmount.add(amount);
	}
	
	public double getArrAmount(int i) {
		return arrAmount.get(i);
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public double getTotal() {
		return this.total;
	}
	
	public void setArrCartAmount(double amount) {
		arrCartAmount.add(amount);
	}
	
	public double getArrCartAmount(int i) {
		return arrCartAmount.get(i);
	}
	
	public void setMedicineList(String medicineList) {
		arrMedicineList.add(medicineList);		
	}
	
	public String getMedicineList(int i) {
		return arrMedicineList.get(i);
	}
	
	public void setCartMedicineList(String medicineList) {
		arrCartMedicineList.add(medicineList);
		setArrCartAmount(arrAmount.get(medicineList.indexOf(medicineList)));
	}
	
	public String getCartMedicineList(int i) {
		return arrCartMedicineList.get(i);
	}
	
	public void setNumber(int number) {
		arrNumber.add(number);		
	}
	
	public int getNumber(int i) {
		return arrNumber.get(i);
	}

	public void clearArr() {
		arrMedicineList.clear();
		arrCartMedicineList.clear();
		arrNumber.clear();
		arrAmount.clear();
	}
	
	public int getArrSize() {
		return arrMedicineList.size();
	}
	
	public int getCartArrSize() {
		return arrCartMedicineList.size();
	}
	
	public void removeCart(int i ) {
		arrCartMedicineList.remove(i);
		arrNumber.remove(i);
	}
}
