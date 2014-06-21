package table.data;

import java.util.ArrayList;

public abstract class Plans extends PlanTable{
	ArrayList<String> plans = new ArrayList<String>();
	ArrayList<String> descriptions = new ArrayList<String>();
	
	public ArrayList<String> getPlans() {
		return plans;
	}
	
	public ArrayList<String> getDescription() {
		return descriptions;
	}
	
	public void setPlans(String plan){
		this.plans.add(plan);
	}
	
	public void setDescription(String description){
		this.descriptions.add(description);
	}
	
	public void clearPlans(){
		this.plans.clear();
		this.descriptions.clear();
	}
}
