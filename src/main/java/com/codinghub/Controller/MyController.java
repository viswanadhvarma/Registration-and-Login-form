package com.codinghub.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codinghub.Model.Facebook;
import com.codinghub.Repository.jdbcCode;
@CrossOrigin
@RestController
public class MyController {
	@Autowired
	private jdbcCode jdbc;

	public jdbcCode getJdbc() {
		return jdbc;
	}

	public void setJdbc(jdbcCode jdbc) {
		this.jdbc = jdbc;
	}
	@PostMapping("/data")
	public Facebook insert(@RequestBody Facebook facebook) throws ClassNotFoundException, SQLException 
	{
		return jdbc.save(facebook);

	}
	@GetMapping("/{eamil}/{password}")
	public String getbyemail(@PathVariable String eamil, @PathVariable String password) throws ClassNotFoundException, SQLException {
		return jdbc.getbyemail(eamil,password);
		
	}
	@GetMapping("/all")
	public List getdata() throws ClassNotFoundException, SQLException {
		return jdbc.getdata();
	}
	@DeleteMapping("/{eamil}")
	public String deletedata(@PathVariable String eamil) throws ClassNotFoundException, SQLException {
		return jdbc.deletedata(eamil);
	}
	@PutMapping("/modify/{eamil}")
	public Facebook update(@RequestBody Facebook facebook) throws ClassNotFoundException, SQLException {
		return jdbc.update(facebook);
	}
	
}
