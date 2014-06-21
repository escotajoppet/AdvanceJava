package student.information.system;

public abstract class UpdateAccountForm extends TransactionInformation{
	String updateFirstName = "";
	String updateLastName = "";
	String updateAddress = "";
	String updateContact = "";
	String updateInsuranceType = "";
	
	public String getUpdateFirstName() {
		return updateFirstName;
	}
	public void setUpdateFirstName(String updateFirstName) {
		this.updateFirstName = updateFirstName;
	}
	public String getUpdateLastName() {
		return updateLastName;
	}
	public void setUpdateLastName(String updateLastNam) {
		this.updateLastName = updateLastNam;
	}
	public String getUpdateAddress() {
		return updateAddress;
	}
	public void setUpdateAddress(String updateAddress) {
		this.updateAddress = updateAddress;
	}
	public String getUpdateContact() {
		return updateContact;
	}
	public void setUpdateContact(String updateContact) {
		this.updateContact = updateContact;
	}
	public String getUpdateInsuranceType() {
		return updateInsuranceType;
	}
	public void setUpdateInsuranceType(String updateInsuranceType) {
		this.updateInsuranceType = updateInsuranceType;
	}
}
