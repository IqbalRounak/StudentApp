package studentapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {

	Connection con;
	Statement stmnt;
	
	@Override
	public void connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregistrationapp", "root", "sa123");
			stmnt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Boolean verifyLogin(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveReg(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate(("insert into registration values('"+name+"','"+city+"','"+email+"', '"+mobile+"')"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet getAllReg() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteReg(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateReg(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("update registration set name='"+name+"', city='"+city+"', mobile='"+mobile+"' where email='"+email+"'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

	

}
