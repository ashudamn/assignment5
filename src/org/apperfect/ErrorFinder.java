package org.apperfect;


public class ErrorFinder {
	private static String errorMsg;
	public ErrorFinder()
	{
		
	}
	public static void setError(String errorMsg)
	{
		ErrorFinder.errorMsg=errorMsg;
	}
	public static String getError()
	{
		return ErrorFinder.errorMsg;
	}
	public static boolean validateRequired(String driver,String url,String username,String password,String query)
	{

		if(driver==null||driver.isEmpty())
		{
			setError("driver name is required");
			return false;
		}
		if(url==null||url.isEmpty())
		{
			setError("url is required");
			return false;
		}
		if(username==null||username.isEmpty())
		{
			setError("username is required");
			return false;
		}
		if(password==null||password.isEmpty())
		{
			setError("password is required");
			return false;
		}
		if(query==null||query.isEmpty())
		{
			setError("query cannot be empty");
			return false;
		}
		return true;
	}
public static void findError(Exception e) {
	e.printStackTrace();
	setError(e.getMessage());
	/*if(error.contains("ClassNotFound"))
	{
		setError("Incorrect Driver");
		return;
	
	}
	if(error.contains("No suitable driver found"))
	{
		setError("Something wrong with url, system cannot access it with current driver");
		return;
	}
	if(error.contains("Access denied for user"))
	{
		setError("Something wrong with username or password, Enter correct username, password");
		return;
	}
	if(error.contains("MySQLSyntaxErrorException"))
	{
		setError("Something wrong with your Query check syntax and enter correct query");
		return;
	}
	if(error.contains("No tables used"))
	{
		setError("Mention tables in your query ");
		return;
	}
	else
	{
		setError(e.toString());
	}*/
	

}
}
