package ThuocImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;


public class GetThuocList {  
	private static Connection conn;
	 private static String DRIVER = "com.mysql.jdbc.Driver";
	 private static String URL = "jdbc:mysql://localhost:3306/manager";
	 private static String USER = "root";
	 private static String PASS = "";
	 
	 public static Connection getConnection(){
	  try {
	   Class.forName(DRIVER);
	   conn = DriverManager.getConnection(URL,USER,PASS);
	  } catch (Exception e) {
	   System.out.println(e);
	  }
	  return conn;
	 }
	

public ArrayList<Thuoc> getList() throws SQLException 
{	GetThuocList conn = new GetThuocList();
    ArrayList<Thuoc> donationList = new ArrayList<Thuoc>();
    Connection con = conn.getConnection();
    PreparedStatement stmt = con.prepareStatement("SELECT * FROM thuoc");

        ResultSet rs = stmt.executeQuery();
        //System.out.println(rs);
        try
        {
            while(rs.next())
            {
            	Thuoc ThuocObj = new Thuoc();
                ThuocObj.setMathuoc(rs.getInt("mathuoc"));
                ThuocObj.setTenthuoc(rs.getString("tenthuoc"));
                ThuocObj.setDonvitinh(rs.getString("donvitinh"));
                ThuocObj.setSoluong(rs.getInt("soluong"));
                ThuocObj.setDongia(rs.getInt("dongia"));
                donationList.add(ThuocObj);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return donationList;     
    }
public static String StringListGetByJson(int i)

{
	
	String listResturn = null;
	if(i==1){
    
    ArrayList<Thuoc> thuocList = new ArrayList<Thuoc>();
    try
    {
        thuocList = new ThuocManager().getList();
        Gson gson = new Gson();
        listResturn = gson.toJson(thuocList);
    } catch (Exception e)
    {
        e.printStackTrace();
    }}
    return listResturn;
}
}