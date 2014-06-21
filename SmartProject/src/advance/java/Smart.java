package advance.java;

import java.sql.*;

public class Smart{
	
	private Connection dbCon = null;
	private Statement st;
	private ResultSet rs;
	private String query = "";
	private String accountNumber = "";
	private String imsi = "";
	
	public Smart(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancedjava", "root", "password");
			System.out.println("Connecting to Database Established!");
		} catch(Exception e){
			System.out.println("Connecting to Database Failed! " + e);
		}
	}
	
	public void setAccountNumber(String accountno){
		this.accountNumber = accountno;
	}
	
	public String getAccountNumber(){
		return this.accountNumber;
	}
	
	public void setIMSI(String accountno){
		try{
			st = dbCon.createStatement();
			query = "SELECT `imsi` FROM subscriber_info WHERE `accountnumber`='"+accountno+"'";
			st.execute(query);
			rs = st.getResultSet();
			
			while(rs.next())
				this.imsi = rs.getString("imsi");
				
		} catch(Exception e){
			System.out.println(e);
		}
	}
	
	public String getIMSI(){
		return this.imsi;
	}
	
	public String[] subscriberInfo(String accountno){
		String[] info = new String[6];
		
		accountno = accountno.trim();
		
		if(accountno.equals("")){
			return null;
		} else if(!isExisting(accountno, "subscriber_info")){
			return null;
		}
			
		try{
			st = dbCon.createStatement();
			query = "SELECT `subscribername`, `msisdn`, `imsi`, `accountnumber`, `birthday`, `mothersmaidenname` FROM subscriber_info WHERE `accountnumber`='"+accountno+"'";
			st.execute(query);
			rs = st.getResultSet();			
			
			while(rs.next()){
				info[0] = rs.getString("subscribername");
				info[1] = rs.getString("msisdn");
				info[2] = rs.getString("imsi");
				info[3] = rs.getString("accountnumber");
				info[4] = rs.getString("birthday");
				info[5] = rs.getString("mothersmaidenname");
			}
			
			return info;
		} catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	public String[] subscriberUsage(String accountno, String imsi){
		accountno = accountno.trim();
		String[] usage = new String[5];
		
		if(accountno.equals("")){
			return null;
		}
		
		try{
			st = dbCon.createStatement();
			query = "SELECT `imsi`, `transactiondata`, `usagetype`, `transactionid`, `cost` FROM subscriber_usage WHERE `imsi`='"+imsi+"'";
			st.execute(query);
			rs = st.getResultSet();
			
			while(rs.next()){
				usage[0] = rs.getString("imsi");
				usage[1] = rs.getString("transactiondata");
				usage[2] = rs.getString("usagetype");
				usage[3] = rs.getString("transactionid");
				usage[4] = rs.getString("cost");
			}
			
			return usage;
		} catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	public String[] subscriberMonthlyUsage(String accountno){
		accountno = accountno.trim();
		String[] monthlyUsage = new String[4];
		
		if(accountno.equals("")){
			return null;
		} else if(!isExisting(accountno, "subscriber_monthly_usage")){
			return null;
		}
			
		try{
			st = dbCon.createStatement();
			query = "SELECT `accountnumber`, `transactiondata`, `numberoftransactions`, `cost` FROM subscriber_monthly_usage WHERE `accountnumber`='"+accountno+"'";
			st.execute(query);
			rs = st.getResultSet();
			
			while(rs.next()){
				monthlyUsage[0] = rs.getString("accountnumber");
				monthlyUsage[1] = rs.getString("transactiondata");
				monthlyUsage[2] = rs.getString("numberoftransactions");
				monthlyUsage[3] = rs.getString("cost");		
			}	
			
			return monthlyUsage;
		} catch(Exception e){
			System.out.println(e);
			return null;
		}
	}	
	
	public boolean isExisting(String accountno, String from){
		try{
			st = dbCon.createStatement();
			query = "SELECT * FROM "+from+"";
			st.execute(query);
			rs = st.getResultSet();
			
			while(rs.next()){
				if(rs.getString("accountnumber").equals(accountno))
					return true;
			}
			
			return false;
		} catch(Exception e){
			return false;
		}
	}
}
