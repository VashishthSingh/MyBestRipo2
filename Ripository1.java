package com.csbestprog.CSBestProg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ripository1 {
	public static void getDataFromClient(String data) {
		Readings rea=JsonUtility.convertToJavaObject(data);
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=(Connection) DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/report?useSSL=false","root","password");     
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement("insert into MyTable(ramUti,diskUti,cpuUti,readTime) values(?,?,?,?)");  
			stmt.setFloat(1,rea.getRamUsed());
			stmt.setFloat(2,rea.getDiskUsed());
			stmt.setDouble(3,rea.getCpuUtilization());
			stmt.setString(4,rea.getReadDateTime());
			stmt.executeUpdate();  
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}
}
