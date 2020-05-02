package ngdemo.mysql;
	
	import java.sql.*;
	import ngdemo.mysql.domain.SQL;

	public class DBConnect {
	    private Connection con;
	    private Statement st;
	    private ResultSet rs;
	    
	    public DBConnect() {
	 try {
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "PaulShock1");
	     st = con.createStatement();
	 } catch (Exception ex) {
	     System.out.println("ERRORCON: " + ex);
	     
	 }
	    }    
	    
	    public void getData() {
	 try {
	     String query = "select * from actor";
	     rs = st.executeQuery(query);
	     System.out.println("Records from Database");
	     while (rs.next()) {
	  String name = rs.getString("first_name");
	  String age = rs.getString("last_name");
	  System.out.println("Name: " + name + " " + age);
	     }
	 } catch(Exception ex) {
	     System.out.println(ex);
	 }
	    }
	
	    //Get the email for the customer.
	    //Change it in the table.
	    //Right now let it always be customer 1
	    public void updateData()
	    {
	    	try {
	    	String query = "SELECT * FROM customer WHERE customer_id = 1";
	    	rs = st.executeQuery(query);
	    	rs.next();
	    	String firstn = rs.getString("first_name");
	    	String lastn = rs.getString("last_name");
	    	String oldemail = rs.getString("email");
	    	String newemail = "@verizon.net";
	    	newemail = firstn + "." + lastn + newemail;
	    	System.out.println("Old email was "+oldemail);
	    	
	    	String sqlUpdateQuery = "UPDATE customer SET email=\""
	    			+  newemail + "\" where customer_id=1";
	    	int rtnval  = st.executeUpdate(sqlUpdateQuery);
	    	rs = st.executeQuery(query);
	    	rs.next();
	    	String changedEmail = rs.getString("email");
	    	System.out.println("New email is "+changedEmail);
	    	//con.commit();
	    	
	    	//Now put old email back.
	    	sqlUpdateQuery = "UPDATE customer SET email=\""
	    			+  oldemail + "\" where customer_id=1";
	    	rtnval  = st.executeUpdate(sqlUpdateQuery);
	    	//con.commit();
	    	//Now retrieve replaced email and show it is same as original.
	    	rs = st.executeQuery(query);
	    	rs.next();
	    	String replacedMail = rs.getString("email");
	    	System.out.println("PUT OLD EMAIL BACK to "+replacedMail);
	    	}
	    	catch (Exception ex)
	    	{
	    		System.out.println(ex);
	    	}
	    }
	    
	    public void createARow()
	    {   
	    	try
	    	{
               String newCustomer = "INSERT INTO customer (address_id,store_id,first_name, last_name, email) VALUES ('604','1','Bob','Smith','b0bsmith@example.com')";                
               int rtnval = st.executeUpdate(newCustomer);
               //con.commit();
               
 //Now display new entry.
               String findNewCustomer = "SELECT * FROM customer WHERE first_name = 'Bob' AND last_name = 'Smith'";
   	    		rs = st.executeQuery(findNewCustomer);
   	    		rs.next();
   	    		String firstname = rs.getString("first_name");
   	    		String lastname = rs.getString("last_name");
   	    		String email = rs.getString("email");
   	    		System.out.println("READ NEW GUY FROM DB "+firstname +" " + lastname+ " " + email);
	    	}
	    	catch (Exception ex)
	    	{
	    		System.out.println(ex);
	    	}
	    	
	    }
	    
	    public void deleteARow()
	    {
	    	try
	    	{
	    		String deletem = "DELETE FROM customer WHERE first_name = 'Bob' AND last_name = 'Smith'";
	    	    int rtnval = st.executeUpdate(deletem);
	    	    //con.commit();
	    	    con.close();
	    	}
	    	catch (Exception ex)
	    	{
	    		System.out.println(ex);
	    	}
	    	
	    }

	    ///////////////////DEMO CODE THAT I KNOW WORKS ENDS HERE.
	    //Basic CRUD for DEMO using Chris' model
	    //Creates a new entry in the sakila customer table.
	    public SQL createARowNotDemo(String firstname,String lastname)
	    {
	    	String firstName = firstname;
	    	String lastName = lastname;
	    	String email = firstName + "." + lastName + "@sakilacustomer.org";
	    	SQL sql = new SQL();
	    	double a = Math.random();
	    	int addressId = (int)(a*600);
	    	int storeId = 1;
	    	boolean rtnval = false;
	    	String newCustomer = "INSERT INTO customer (address_id,store_id,first_name, last_name, email)"
	    			             + " values(?,?,?,?,?)";

	    try
	    {
	     // create the mysql insert preparedstatement
	       PreparedStatement preparedStmt = con.prepareStatement(newCustomer);
	       preparedStmt.setInt (1, addressId);
	       preparedStmt.setInt (2, storeId);
	       preparedStmt.setString(3, firstName);
	       preparedStmt.setString(4, lastName);
	       preparedStmt.setString(5, email);

	       // execute the preparedstatement
	        rtnval = preparedStmt.execute();
	        if (rtnval)
	        {
	        	sql.setFirstName(firstName);
	        	sql.setLastName(lastName);
	        	sql.setAddressId(addressId);
	        	sql.setStoreId(storeId);
	        	sql.setEmail(email);
	        }
	    	      
	        con.close();
	    }
	    catch (Exception e)
	    {
	       System.out.println(e.getStackTrace());
	     }	
	    return sql;
	  }
	    
	    public SQL readARowNotDemo(int primarykey)
	    {	
	    	SQL sql = new SQL();
	    	try
	    	{
	    	   int primaryKey = primarykey;
	    	   String findNewCustomer = "SELECT * FROM customer WHERE customer_id = "+primaryKey;
	    	   rs = st.executeQuery(findNewCustomer);
	    	   rs.next(); 		
	    	   String firstname = rs.getString("first_name");
  	    	   String lastname = rs.getString("last_name");
  	    	   String email = rs.getString("email");
  	    	   int storeid = rs.getInt("store_id");
  	    	   int addressid = rs.getInt("address_id");
  	    	   sql.setFirstName(firstname);
  	    	   sql.setLastName(lastname);
  	    	   sql.setEmail(email);
  	    	   sql.setStoreId(storeid);
  	    	   sql.setAddressId(addressid);
  	    	   con.close();
	    	}
	    	catch (Exception e)
	    	{
	    		System.out.println(e.getStackTrace());	    		
	    	}
	    	return sql;
	    }

	    //Change firstname and lastname of customer whose primary key is specified.
	    //Also change email since it is FIRSTNAME.LASTNAME@sakilacustomer.org
	    public SQL updateARowNotDemo(String firstName,String lastName, int primaryKey)
	    {
	    	SQL sql = new SQL();
	    	String firstname = firstName;
	    	String lastname = lastName;
	    	int primarykey = primaryKey;
	    	String email = firstname + "." + lastname + "@sakilacustomer.org";
	    	String updateString = "UPDATE customer SET first_name = ?," +
	    	                     "last_name = ?,  email = ? WHERE customer_id = ?";
	    	try
	    	{
	    	   PreparedStatement pstmt = con.prepareStatement(updateString);
	    	   pstmt.setString(1,firstname);
	    	   pstmt.setString(2, lastname);
	    	   pstmt.setString(3,email);
	    	   pstmt.setInt(4, primarykey);
	    	   int rtnval = pstmt.executeUpdate();
	    	   sql.setFirstName(firstname);
	    	   sql.setLastName(lastname);
	    	   sql.setEmail(email);
	    	   
	    	   con.close();
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e.getStackTrace());
	    	}
	    	
	    	return sql;
	    }
	    
	    public SQL deleteARowNotDemo(int primaryKey)
	    {
	    	SQL sql = new SQL();
	    	int primarykey = primaryKey;
	    	String deleteString = "DELETE FROM customer WHERE customer_id = "+ primarykey;
	    	try
	    	{
	    	   int rtnval = st.executeUpdate(deleteString);
	    	   con.close();
	    	}
	    	catch (Exception e)
	    	{
	    		System.out.println(e.getStackTrace());
	    	}
	    	
	    	return sql;
	    }
	    
	    
	    
	    			
	    
	}	
