/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 

import java.sql.*;
     
public class InsertCoffees {

	public static void main(String args[]) {
		  
		String url = "jdbc:mySubprotocol:myDataSource";
		Connection con;
		Statement stmt;
		String query = "select COF_NAME, PRICE from COFFEES";
	
		try {
			Class.forName("myDriver.ClassName");
	
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: "); 
			System.err.println(e.getMessage());
		}

		try {

			con = DriverManager.getConnection(url, 
									 "myLogin", "myPassword");
	
			stmt = con.createStatement();							
	
			stmt.executeUpdate("insert into COFFEES " +
		         "values('Colombian', 00101, 7.99, 0, 0)");
	
			stmt.executeUpdate("insert into COFFEES " +
		         "values('French_Roast', 00049, 8.99, 0, 0)");
			
			stmt.executeUpdate("insert into COFFEES " +
		         "values('Espresso', 00150, 9.99, 0, 0)");
	
			stmt.executeUpdate("insert into COFFEES " +
	             "values('Colombian_Decaf', 00101, 8.99, 0, 0)");
	
			stmt.executeUpdate("insert into COFFEES " +
		         "values('French_Roast_Decaf', 00049, 9.99, 0, 0)");
	
			ResultSet rs = stmt.executeQuery(query);
	
			System.out.println("Coffee Break Coffees and Prices:");
			while (rs.next()) {
				String s = rs.getString("COF_NAME");
				float f = rs.getFloat("PRICE");
				System.out.println(s + "   " + f);
			}
	
			stmt.close();
			con.close();
	
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}

