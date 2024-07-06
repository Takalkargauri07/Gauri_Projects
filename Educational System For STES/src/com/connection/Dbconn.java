
package com.connection;


import java.sql.*;
import java.util.UUID;
import java.util.Random;


public class Dbconn {
	public static String logos="D:\\ProjectCode\\report\\lo.png";
	public Dbconn() throws SQLException {
        //initComponents();
           //Connection con;
		
    }
	public static String generateTransactionId() {
        // Generate a unique transaction ID using UUID
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        String transactionId = generateTransactionId();
        System.out.println("Generated Transaction ID: " + transactionId);
    }
    
            public static Connection conn() throws SQLException, ClassNotFoundException{
                Connection con;
        Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost/240477_cs_g_129_collegemanagement","root","admin");
         
        
       return(con);
    
}
            public static String OTPData() {
        		StringBuilder ss = new StringBuilder();
        		String numbers = "1234567890";
        	      Random random = new Random();
        	      char[] otp = new char[6];

        	      for(int i = 0; i< 6 ; i++) {
        	         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        	         ss.append(otp[i]);
        	      }

        		return ss.toString();

        	}
           
           
}
