package thuocForm;

import java.lang.reflect.Type;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import thuocimpl.ListServiceGetStub;
import thuocimpl.ListServiceGetStub.StringListGetByJson;
import thuocimpl.ListServiceGetStub.StringListGetByJsonResponse;


public class ThuocManager {
	    public List<Thuoc> getAllThuoc() throws RemoteException{
	    	ListServiceGetStub stub = new ListServiceGetStub();
			StringListGetByJson ss = new StringListGetByJson();
			ss.setI(1);
			StringListGetByJsonResponse cc =stub.stringListGetByJson(ss);
			String ee =cc.get_return();
			Gson gson = new Gson();
			Type type = new TypeToken<ArrayList<Thuoc>>(){}.getType();
			 List<Thuoc> danhsachThuoc = gson.fromJson(ee, type); 
			 return danhsachThuoc;
	    }
	  
	}
