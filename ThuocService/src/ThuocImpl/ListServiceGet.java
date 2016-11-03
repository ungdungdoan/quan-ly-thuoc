package ThuocImpl;

import java.util.ArrayList;

import com.google.gson.Gson;

import jdk.internal.dynalink.beans.StaticClass;


public class ListServiceGet
{


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