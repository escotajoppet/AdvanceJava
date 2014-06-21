package sql.string.commands;

public abstract class SqlStringCommands {
	public String selectFields(String fields, String tableName, String condition){
		return "SELECT "+fields+" FROM `"+tableName+"` "+condition+"";
	}
	
	public String insertIntoFields(String tableName, String fields, String values){
		return "INSERT INTO `"+tableName+"` ("+fields+") VALUES("+values+")";
	}
	
	public String updateField(String tableName, String field, String value, String condition){
		return "UPDATE `"+tableName+"` SET `"+field+"`='"+value+"' WHERE "+condition+"";
	}
	
	public String updateFields(String tableName, String fieldValue, String condition){
		return "UPDATE `"+tableName+"` SET "+fieldValue+" WHERE "+condition+"";
	}
	
	public String deleteFromField(String tableName, String conditionField, String conditionValue){
		return "DELETE FROM `"+tableName+"` WHERE `"+conditionField+"`='"+conditionValue+"'";
	}
}
