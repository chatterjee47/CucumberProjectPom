package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Database {
	
	WebDriver driver;
	
	public void DatabaseConnections() throws SQLException
	{
		//Step 1
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");  
		
		//Step 2
		Statement stmt=con.createStatement();  
		
		//Step 3
		String sqlQuery = "select * from emp";
		
		//Step 4
		ResultSet rs=stmt.executeQuery(sqlQuery);  
		 
		//Step 5
		while(rs.next())
		{
			String username = rs.getString("uname");//uname is the Database column name
			String password = rs.getString("passwrd");//passwrd is the Database column name
			
			driver.findElement(By.xpath("username")).sendKeys(username);//username is the xpath : change the path accordingly
			driver.findElement(By.xpath("password")).sendKeys(password);//password is the xpath : change the path accordingly
			driver.findElement(By.xpath("button")).click();//button is the xpath : change the path accordingly
			
			if(driver.getTitle().equals("logo"))
			{
				System.out.println("Test Case Passed");  
			}else
			{
				System.out.println("Test Case Failed");  
			}	
		}  
	}
}
