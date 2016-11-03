package ThuocImpl;

import java.sql.Connection;
import java.util.ArrayList;

import DBConnect.DBConnection;

public class ThuocManager {
	    public ArrayList<Thuoc> getList() throws Exception
	    {
	        ArrayList<Thuoc> courseList = new ArrayList<Thuoc>();
	        DBConnection db = new DBConnection();
	        Connection con = db.getConnection();
	       GetThuocList list = new GetThuocList();
	        courseList = list.getList();
	        return courseList;
	    }
	}
