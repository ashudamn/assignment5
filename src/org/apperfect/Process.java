package org.apperfect;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Process extends TagSupport{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String driver,url,query,username,password;
public void setDriver(String driver){
	this.driver=driver;
}
public void setUrl(String url){
	this.url=url;
}
public void setUser(String user){
	this.username=user;
}
public void setPassword(String password){
	this.password=password;
}
public void setQuery(String query)
{
	this.query=query;
}
public int doStartTag()throws JspException{
	JspWriter out=pageContext.getOut();
	try{
		if(!ErrorFinder.validateRequired(driver, url, username, password, query))
		{
			out.println(ErrorFinder.getError());
		}
		else
		{
			AccessDb.Connect2DB(driver,url,username,password,query);
			AccessDb.showResults(out);
		}
	}
	catch(Exception e){
		//e.printStackTrace();
		ErrorFinder.findError(e);
		try {
			out.println(ErrorFinder.getError());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
	}
	finally{
		AccessDb.closeAllConnections();
	}
	try {
		out.println("<a href=\"Form2.jsp\">Back</a>");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("your error is "+ErrorFinder.getError());
	return SKIP_BODY;
	
}
}
