package pharmacy.system;

import java.sql.*;
import java.util.ArrayList;

public class PharmacySystem extends Account {

	ResultSet rs = null;
	Statement st = null;
	String sql = "";
	
	
	
	public ResultSet viewAllInfo(){
		try{
			st = getConnection().createStatement();
			sql = selectFields("*", "medicinelist", "1");
			return st.executeQuery(sql);
			
		} catch(Exception e){
			System.out.println("error view all " + e);
			return null;
		}
	}
	
	public void addNewInfo(String genericName, String brandName, String manufacturer, String amount){
		try{
			st = getConnection().createStatement();
			sql = insertIntoFields("medicinelist", "`generic_name`, `brand_name`, `manufacturer`, `amount`", "'"+genericName+"', '"+brandName+"', '"+manufacturer+"', '"+amount+"'");
			st.execute(sql);
			
			getConnection().commit();
			
			System.out.println("adding success");
		} catch(Exception e){
			System.out.println("error adding " + e);
			return;
		}
	}
	
	public void deleteInfo(String brandName){
		try{
			st = getConnection().createStatement();
			sql = deleteFromField("medicinelist", "brand_name", brandName);
			st.execute(sql);
			
			getConnection().commit();
			
			System.out.println("deleting success");
		} catch(Exception e){
			System.out.println("error deleting " + e);
			return;
		}
	}
	
	public ResultSet searchInfo(String brandName){
		try{
			st = getConnection().createStatement();
			sql = selectFields("*", "medicinelist", "`brand_name`='"+brandName+"'");
			return st.executeQuery(sql);
		} catch(Exception e){
			System.out.println("error searching info " + e);
			return null;
		}
	}
	
	public void addToCart(String medicine, int num) {
		if(arrCartMedicineList.contains(medicine)) {
			arrNumber.set(arrCartMedicineList.indexOf(medicine),arrNumber.get(arrCartMedicineList.indexOf(medicine)) + num);
		} else {
			arrNumber.add(num);
			setCartMedicineList(medicine);
		}
	}
	
	public void medicineList() throws Exception {
		try{
			st = getConnection().createStatement();
			sql = selectFields("`brand_name`, `amount`", "medicinelist", "1");
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				setMedicineList(rs.getString("brand_name"));
				setArrAmount(rs.getDouble("amount"));
			}
		} catch(Exception e){
			
		}		
	}
	
	public void totalAmount(String medicine) {
		double total = getAmount(medicine) * arrNumber.get(arrCartMedicineList.indexOf(medicine));
		setTotal(getTotal() + total);
	}
	
	public double getAmount(String brandName) {
		double amount = 0;
		try{
			st = getConnection().createStatement();
			sql = selectFields("`amount`", "medicinelist", "`brand_name`='"+brandName+"'");
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				amount = rs.getDouble("amount");
			}
		} catch(Exception e){
			
		}
		return amount;
	}
}
