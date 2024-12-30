package studentapp.model;

import java.sql.ResultSet;

public interface DAOService {
	void connectToDB();
	Boolean verifyLogin(String email, String password);
	void saveReg(String name, String city, String email, String mobile);
	ResultSet getAllReg();
	void deleteReg(String email);
	void updateReg(String name, String city, String email, String mobile);
}
