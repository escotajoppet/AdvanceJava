package HotelReservation;

public abstract class SQLStringClass extends DBConn {

	public String sqlInsertQuery(String table, String column, String values) {
		return "INSERT INTO "+table+" ("+column+") VALUES ("+values+")";
	}
	
	public String sqlUpdateQuery(String table, String values, String condition) {
		return "UPDATE "+table+" SET "+values+" WHERE "+condition+"";
	}
	
	public String sqlSelectQuery(String column, String table, String condition) {
		return "SELECT "+column+" FROM "+table+" "+condition+"";
	}
	
	public String sqlDeleteQuery(String table, String condition) {
		return "DELETE FROM "+table+" WHERE "+condition+"";
	}
}
