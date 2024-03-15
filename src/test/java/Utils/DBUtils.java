package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
	private String dbHostName ="jdbc:mysql://stack-overflow.cfse9bqqndon.us-east-1.rds.amazonaws.com:3306/CraterDBS";//should include port
	private String username="craterdbuser";
	private String password="ptschool2023";
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	private ResultSetMetaData rsmd;
	
	
	static String selctAitemQ="Select * From items Where id='12284'";
	
	
	public static void main(String[] args) {
		DBUtils  utils= new DBUtils();
		List <String> itemInfo = utils.selectARecord(selctAitemQ);
		for ( String item:itemInfo ) {
			System.out.println(item);
		}
	}
	
	
	public List<String> selectARecord(String query){
		List<String> list = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(dbHostName, username, password);
			System.out.println("DB connection established.");
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			rsmd = resultset.getMetaData();
			
			resultset.next();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				list.add(resultset.getString(i));
			}
		} catch (SQLException e) {
		System.out.println("DB connection Not established.");
			e.printStackTrace();
		}
		return list;
	}
}