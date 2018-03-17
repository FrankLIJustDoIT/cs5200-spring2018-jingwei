package edu.northeastern.cs5200.controllers.Dao;

import java.io.*;
import java.sql.*;

public class BaseDao {
	final static String DRIVER = "com.mysql.jdbc.Driver";
	final static String URL = "jdbc:mysql://cs5200-spring2018-jingwei.c6frr1nutfkh.us-west-2.rds.amazonaws.com";
	final static String USERNAME = "jingwei";
	final static String PASSWORD = "LJW199311";

	public static BaseDao instance;
	public static BaseDao getInstance() {
		if(instance == null){
			instance = new BaseDao();
		}
		
		return instance;
	}
	
	public void reconstruction(String rec){
		Connection conn = null;
		BufferedReader br = null;
		Statement statement = null;
		
		try{
			br = new BufferedReader(new FileReader(rec));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String query = null;
			while((query = br.readLine()) != null) {
				statement = (Statement) conn.createStatement();
				statement.execute(query);
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				statement.close();
				conn.close();
				br.close();
			}catch(SQLException e){
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
