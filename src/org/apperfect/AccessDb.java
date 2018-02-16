package org.apperfect;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspWriter;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;



public class AccessDb {
	private static ResultSet rs;
	private static Connection conn;
	private static Statement st;
	public static void Connect2DB(String driver,String url,String username,String password,String query) throws SQLException, ClassNotFoundException
	{
			Class.forName(driver);
			conn=(Connection) DriverManager.getConnection(url,username,password);
			 st=(Statement) conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			setRs(rs);
	}
	
	public static void showResults(JspWriter out) throws SQLException, IOException
	{
		if(rs!=null)
		{
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
			int totalcols=rsmd.getColumnCount();
			//column name
			out.write("<table border='1'>");
			out.write("<tr>");
			for(int i=1;i<=totalcols;i++){
				out.write("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			out.write("</tr>");
			int j=1;
			 while(rs.next()){  
		            out.write("<tr>");  
		                for(int i=1;i<=totalcols;i++)
		                {  
		                	String typeOfColumn = rsmd.getColumnTypeName(i);
		    				if (typeOfColumn.contains("BLOB") || typeOfColumn.contains("CLOB")) {
		    					System.out.println("Image "+j);
		    					out.write("<td>"+"Image "+j+"</td>"); 
		    				} 
		    				else {
		    					out.write("<td>"+rs.getString(i)+"</td>");  
		    				}
		                
		            }  
		            out.write("</tr>");  
		                  j++;
		        }
		        out.write("</table>");  
		          
		        }  
	}

	public static ResultSet getRs() {
		return rs;
	}

	public static void setRs(ResultSet rs) {
		AccessDb.rs = rs;
	}
	public static void closeAllConnections()
	{
		try{
			if(AccessDb.rs!=null){
				AccessDb.rs.close();
			}
			if(AccessDb.st!=null)
			{
				AccessDb.st.close();
			}
			if(AccessDb.conn!=null)
			{
				AccessDb.conn.close();
			}	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("closing problems");
			e.printStackTrace();
		}
		
	}
}
