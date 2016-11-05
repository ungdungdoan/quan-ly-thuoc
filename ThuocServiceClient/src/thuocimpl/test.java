package thuocimpl;

import java.lang.reflect.Type;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import servicethuoc.ManagerSQLExceptionException;
import servicethuoc.ManagerStub;
import servicethuoc.ManagerStub.AddThuoc;
import servicethuoc.ManagerStub.UpdateThuoc;
import thuocForm.Thuoc;
import thuocimpl.ListServiceGetStub.StringListGetByJson;
import thuocimpl.ListServiceGetStub.StringListGetByJsonResponse;

public class test {

	public static void main(String[] args) throws RemoteException, ManagerSQLExceptionException {
		ListServiceGetStub stub = new ListServiceGetStub();
		StringListGetByJson ss = new StringListGetByJson();
		ss.setI(1);
		StringListGetByJsonResponse cc =stub.stringListGetByJson(ss);
		String ee =cc.get_return();
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Thuoc>>(){}.getType();
		 List<Thuoc> studentsUpdated = gson.fromJson(ee, type); 
		 for (int i = 0; i < studentsUpdated.size(); i++) {
			System.out.println(studentsUpdated.get(i).getTenthuoc());
		}
		 
		 ManagerStub as = new ManagerStub();
		UpdateThuoc sa = new UpdateThuoc();
		sa.setMathuoc(3);
		sa.setTenthuoc("fsdf");
		sa.setDonvitinh("fsdfds");
		sa.setDongia(5);
		sa.setSoluong(70);
		as.updateThuoc(sa);
		
	}

}
