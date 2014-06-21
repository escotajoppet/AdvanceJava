package table.data;

import java.util.ArrayList;

public abstract class PlanTable extends SubmittedData{
	ArrayList<String> planTypes = new ArrayList<String>();
	ArrayList<String> descriptions = new ArrayList<String>();
	ArrayList<Double> contractPrices = new ArrayList<Double>();
	ArrayList<Double> annuals = new ArrayList<Double>();
	ArrayList<Double> semiAnnuals = new ArrayList<Double>();
	ArrayList<Double> quarterlys = new ArrayList<Double>();
	ArrayList<Double> monthlys = new ArrayList<Double>();
	
	public void clearPlanTable(){
		this.annuals.clear();
		this.contractPrices.clear();
		this.descriptions.clear();
		this.monthlys.clear();
		this.planTypes.clear();
		this.quarterlys.clear();
		this.semiAnnuals.clear();
	}
	
	public void setPlanTypes(String planType){
		this.planTypes.add(planType);
	}
	
	public void setDescriptions(String description){
		this.descriptions.add(description);
	}
	
	public void setContractPrices(double contractPrice){
		this.contractPrices.add(contractPrice);
	}
	
	public void setAnnuals(double annual){
		this.annuals.add(annual);
	}
	
	public void setSemiAnnuals(double semiAnnual){
		this.semiAnnuals.add(semiAnnual);
	}

	public void setQuarterlys(double quarterly){
		this.quarterlys.add(quarterly);
	}

	public void setMonthlys(double monthlys){
		this.monthlys.add(monthlys);
	}
	
	public ArrayList<String> getPlanTypes() {
		return planTypes;
	}
	
	public ArrayList<String> getDescriptions() {
		return descriptions;
	}
	
	public ArrayList<Double> getContractPrices() {
		return contractPrices;
	}
	
	public ArrayList<Double> getAnnuals() {
		return annuals;
	}
	
	public ArrayList<Double> getSemiAnnuals() {
		return semiAnnuals;
	}
	
	public ArrayList<Double> getQuarterlys() {
		return quarterlys;
	}
	
	public ArrayList<Double> getMonthlys() {
		return monthlys;
	}	
}
