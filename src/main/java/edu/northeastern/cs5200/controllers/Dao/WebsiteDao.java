package edu.northeastern.cs5200.controllers.Dao;

import java.sql.*;
import java.util.*;

import edu.northeastern.cs5200.controllers.Model.*;

public class WebsiteDao{
	public static WebsiteDao instance = null;
	public static WebsiteDao getInstance(){
		if (instance == null){
			instance = new WebsiteDao();
		}
		return instance;
	}
	
	public int createWebsiteForDeveloper(int developerId, Website website){
	    int rs = 0;
	    Connection conn = null;
	    PreparedStatement statement = null;
	    try{
	    	Class.forName(BaseDao.DRIVER);
	        conn = DriverManager.getConnection(BaseDao.URL, BaseDao.USERNAME, BaseDao.PASSWORD);
			String query = "INSERT INTO website (id, name, description, created, updated, visits, developerId)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
			statement = conn.prepareStatement(query);
	        statement.setInt(1, website.getId());
			statement.setString(2, website.getName());
			statement.setString(3, website.getDescription());
			statement.setDate(4, website.getCreated());
			statement.setDate(5, website.getUpdated());
			statement.setInt(6, website.getVisits());
	        statement.setInt(7, developerId);
	        rs = statement.executeUpdate();
	        
	        RoleDao.getInstance().assignWebsiteRole(developerId, website.getId(), Role.owner.ordinal());
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				statement.close();
				conn.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public List<Website> findAllWebsites(){
        List<Website> websites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try{
            Class.forName(BaseDao.DRIVER);
            conn = DriverManager.getConnection(BaseDao.URL, BaseDao.USERNAME, BaseDao.PASSWORD);
			String query = "SELECT * FROM website";
			statement = conn.prepareStatement(query);
			rs = statement.executeQuery();
			
			while(rs.next()){
				Website website = new Website(rs.getInt("id"), rs.getString("name"), rs.getString("description"),rs.getDate("created"),rs.getDate("updated"),rs.getInt("visits"));
				website.setPages(PageDao.getInstance().findPagesForWebsite(website.getId()));
                websites.add(website);
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				statement.close();
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return websites;
	}
	
	public List<Website> findWebsitesForDeveloper(int developerId){
		List<Website> websites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try{
            Class.forName(BaseDao.DRIVER);
            conn = DriverManager.getConnection(BaseDao.URL, BaseDao.USERNAME, BaseDao.PASSWORD);
			String query = "SELECT * FROM website where developerId = ?)";
			statement = conn.prepareStatement(query);
			statement.setInt(1,developerId);
			rs = statement.executeQuery();
			
            while(rs.next()){
            	Website website = new Website(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
        									  rs.getDate("created"),rs.getDate("updated"),rs.getInt("visits"));
				website.setPages(PageDao.getInstance().findPagesForWebsite(website.getId()));
	            websites.add(website);
            }
		
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				statement.close();
				conn.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return websites;
	}
	
	public Website findWebsiteById(int websiteId){
		Website web = null;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try{
            Class.forName(BaseDao.DRIVER);
            conn = DriverManager.getConnection(BaseDao.URL, BaseDao.USERNAME, BaseDao.PASSWORD);
			String query = "SELECT * FROM website where id = ?";
			statement = conn.prepareStatement(query);
			statement.setInt(1,websiteId);
			rs = statement.executeQuery();
			
			while(rs.next()){
				web = new Website(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
								  rs.getDate("created"),rs.getDate("updated"),rs.getInt("visits"));
				web.setPages(PageDao.getInstance().findPagesForWebsite(web.getId()));
			}
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				statement.close();
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return web;
	}
	
	public int updateWebsite(int websiteId, Website website){
        int rs = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            Class.forName(BaseDao.DRIVER);
            conn = DriverManager.getConnection(BaseDao.URL, BaseDao.USERNAME, BaseDao.PASSWORD);
			String query = "UPDATE website SET id = ?, name = ?, description = ?, created = ?, updated = ?, "
						 + "visits = ? where id = ? ";
			statement = conn.prepareStatement(query);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setDate(3, website.getCreated());
			statement.setDate(4, website.getUpdated());
			statement.setInt(5, website.getVisits());
			statement.setInt(6, websiteId);
			rs = statement.executeUpdate();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				statement.close();
				conn.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public int deleteWebsite(int websiteId){
        int rs = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            Class.forName(BaseDao.DRIVER);
            conn = DriverManager.getConnection(BaseDao.URL, BaseDao.USERNAME, BaseDao.PASSWORD);
			String query = "DELETE FROM website where id = ?";
			statement = conn.prepareStatement(query);
			statement.setInt(1, websiteId);
			rs = statement.executeUpdate();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				statement.close();
				conn.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return rs;
	}
}