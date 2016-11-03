package ServiceThuoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBConnect.DBConnection;

public class Manager {
	public static Connection con;
	public Manager(){
		DBConnection db = new DBConnection();
		this.con = db.getConnection();
	}
	public void addThuoc(int mathuoc,String tenthuoc,String donvitinh,int soluong,int dongia) throws SQLException{
		String sql = "INSERT INTO thuoc (mathuoc,tenthuoc,donvitinh,soluong,dongia) VALUES (?, ?, ?, ?, ?)";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, mathuoc);
		statement.setString(2, tenthuoc);
		statement.setString(3, donvitinh);
		statement.setInt(4, soluong);
		statement.setInt(5, dongia);
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		
	}
		System.out.println("them thnah cong");
		detroy();
	}
public void updateThuoc(int mathuoc,String tenthuoc,String donvitinh,int soluong,int dongia) throws SQLException{
	String sql = "UPDATE thuoc SET tenthuoc=?, donvitinh=?,soluong=?, dongia=? WHERE mathuoc=?";
	PreparedStatement statement = con.prepareStatement(sql);
	statement.setString(1, tenthuoc);
	statement.setString(2, donvitinh);
	statement.setInt(3, soluong);
	statement.setInt(4, dongia);
	statement.setInt(5, mathuoc);
	int rowsInserted = statement.executeUpdate();
	if (rowsInserted > 0) {
	    System.out.println("A new user was inserted successfully!");
	
}
	System.out.println("them thnah cong");
	detroy();
}
public void deleteThuoc(int mathuoc) throws SQLException{
	String sql = "DELETE FROM thuoc WHERE mathuoc=?";
	PreparedStatement statement = con.prepareStatement(sql);
	statement.setInt(1, mathuoc);
	int rowsInserted = statement.executeUpdate();
	if (rowsInserted > 0) {
	    System.out.println("A new user was inserted successfully!");
	
}
	System.out.println("them thnah cong");
	detroy();
}	
	public static void detroy() throws SQLException{
		con.close();
	}

	
	
}
