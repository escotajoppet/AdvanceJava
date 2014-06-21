package table.data;

public abstract class SubmittedData extends ViewCustomers{
	String submittedPlanType = "";
	String submittedDescription = "";
	String submittedPaymentType = "";
	
	public String getSubmittedPaymentType() {
		return submittedPaymentType;
	}

	public void setSubmittedPaymentType(String submittedPaymentType) {
		this.submittedPaymentType = submittedPaymentType;
	}

	double submittedPrice = 0;
	
	public String getSubmittedPlanType() {
		return submittedPlanType;
	}
	
	public void setSubmittedPlanType(String submittedPlanType) {
		this.submittedPlanType = submittedPlanType;
	}
	
	public String getSubmittedDescription() {
		return submittedDescription;
	}
	
	public void setSubmittedDescription(String submittedDescription) {
		this.submittedDescription = submittedDescription;
	}
	
	public double getSubmittedPrice() {
		return submittedPrice;
	}
	
	public void setSubmittedPrice(double submittedPrice) {
		this.submittedPrice = submittedPrice;
	}	
}
