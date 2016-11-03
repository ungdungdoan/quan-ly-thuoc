import java.sql.SQLException;

import ServiceThuoc.Manager;
import ThuocImpl.GetThuocList;
import ThuocImpl.ListServiceGet;

public class tst {
public static void main(String[] args) throws SQLException {
	GetThuocList dd = new GetThuocList();
	Manager bb = new Manager();
	bb.deleteThuoc(1);
}

}
