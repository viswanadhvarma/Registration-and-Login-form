package com.codinghub.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.codinghub.Model.Facebook;
@Repository
public class jdbcCode {

	public Facebook save(Facebook facebook) throws ClassNotFoundException, SQLException 
	{
		String url="jdbc:mysql://localhost:3306/first";
		String username = "root";
		String password = "root";
		String q="INSERT INTO FACEBOOK VALUES(?,?,?,?,?,?,?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,facebook.getFirstname());
		pst.setString(2, facebook.getLastname());
		pst.setString(3, facebook.getEamil());
		pst.setString(4, facebook.getPassword());
		pst.setLong(5, facebook.getMobile());
		pst.setInt(6, facebook.getAge());
		pst.setString(7, facebook.getGender());
		pst.setDate(8, facebook.getDob());
		int rows=pst.executeUpdate();
		return facebook;
	}

	public String getbyemail(String eamil, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/first";
		String username = "root";
		String password1 = "root";
		String q="SELECT * FROM FACEBOOK WHERE EAMIL=? AND PASSWORD=?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password1);
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, eamil);
		pst.setString(2, password);
		ResultSet rs= pst.executeQuery();
		if(rs.next())
			return "1";
		else
			return "0";
	}

	public List getdata() throws ClassNotFoundException, SQLException {
		
		String url="jdbc:mysql://localhost:3306/first";
		String username = "root";
		String password1 = "root";
		String q="SELECT * FROM FACEBOOK";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password1);
		Statement pst=con.createStatement();
		
		ResultSet rs= pst.executeQuery(q);
		List li=new ArrayList();
		
		
		while(rs.next()) {
			Facebook fb = new Facebook();
			fb.setFirstname(rs.getString("firstname"));
			fb.setLastname(rs.getString("lastname"));
			fb.setEamil(rs.getString("eamil"));
			fb.setPassword(rs.getString("password"));
			fb.setMobile(rs.getLong("mobile"));
			fb.setAge(rs.getInt("age"));
			fb.setGender(rs.getString("gender"));
			fb.setDob(rs.getDate("dob"));
			li.add(fb);
		}
		
		return li;
	}

	public String deletedata(String eamil) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/first";
		String username = "root";
		String password1 = "root";
		String q="DELETE FROM FACEBOOK WHERE EAMIL=?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password1);
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, eamil);
		int r=pst.executeUpdate();
		if(r>0)
			return eamil;
		else
			return "";
		
		
		
	}

	public Facebook update(Facebook facebook) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/first";
		String username = "root";
		String password = "root";
		String q="UPDATE FACEBOOK SET FIRSTNAME=?,LASTNAME=?,EAMIL=?,PASSWORD=?,MOBILE=?,AGE=?,GENDER=?,DOB=? WHERE EAMIL=? ";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,facebook.getFirstname());
		pst.setString(2, facebook.getLastname());
		pst.setString(3, facebook.getEamil());
		pst.setString(4, facebook.getPassword());
		pst.setLong(5, facebook.getMobile());
		pst.setInt(6, facebook.getAge());
		pst.setString(7, facebook.getGender());
		pst.setDate(8, facebook.getDob());
		pst.setString(9, facebook.getEamil());
		int rows=pst.executeUpdate();
		return facebook;
		
	}

}
