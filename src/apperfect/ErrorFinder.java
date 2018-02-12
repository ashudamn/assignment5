package apperfect;


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
		if(driver==null)
		{
			System.out.println("driver is null");
		}
		if(driver.isEmpty())
		{
			setError("driver name is required");
			return false;
		}
		if(url.isEmpty())
		{
			setError("url is required");
			return false;
		}
		if(username.isEmpty())
		{
			setError("username is required");
			return false;
		}
		if(password.isEmpty())
		{
			setError("password is required");
			return false;
		}
		if(query.isEmpty())
		{
			setError("query cannot be empty");
			return false;
		}
		return true;
	}
public static void findError(Exception e) {
	String error=e.toString();
	e.printStackTrace();
	if(error.contains("ClassNotFound"))
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
	}
	

}
}
