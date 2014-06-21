package art.gallery;

import sql.string.commands.SqlStringCommands;

public abstract class SelectedInfo extends SqlStringCommands{
	String selectedTableName = "";
	String selectedEntryDate = "";
	String selectedArtTitle = "";

	int selectedEntryId = 0;

	public int getSelectedEntryId() {
		return selectedEntryId;
	}
	public void setSelectedEntryId(int selectedEntryId) {
		this.selectedEntryId = selectedEntryId;
	}
	public String getSelectedTableName() {
		return selectedTableName;
	}
	public void setSelectedTableName(String selectedTableName) {
		this.selectedTableName = selectedTableName;
	}
	public String getSelectedEntryDate() {
		return selectedEntryDate;
	}
	public void setSelectedEntryDate(String selectedEntryDate) {
		this.selectedEntryDate = selectedEntryDate;
	}
	public String getSelectedArtTitle() {
		return selectedArtTitle;
	}
	public void setSelectedArtTitle(String selectedArtTitle) {
		this.selectedArtTitle = selectedArtTitle;
	}	
}
