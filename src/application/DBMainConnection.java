package application;
       // ovu sam menjao  
// ovde sam ovo doktorirao                               
//                                                            KONEKCIJA SA BAZOM    
//                                                  ============LICNI PODATCI==============


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DBMainConnection {
	
	
	private static final String Rs2 = null;
	Connection con= null;
	PreparedStatement Ps1= null;
	PreparedStatement Ps2= null;
	ResultSet Rs1 = null;
	
	
    public void DBInsert(String proc3) {
		try{
		  	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	
		  	con= DriverManager.getConnection("jdbc:mysql://alfacreva.com:3306/alfa_Policija","alfa_Policija","asdfgh123");
		  	
		  	//Ps1 = con.prepareStatement("UPDATE LicniPodatci SET SALARY = ? WHERE ID = ?");
		  	Ps1 = con.prepareStatement("INSERT INTO LicniPodatci (Ime,Prezime,Godiste,ImeRoditelja) VALUES (?,'m','10','M')");
		  	Ps2 = con.prepareStatement("SELECT SUM(Godiste) AS GOD FROM LicniPodatci");
		  	
            Ps1.setString(1, proc3);
            //Ps1.setInt(2, 1);
           
           Ps1.executeUpdate();
           Rs1= Ps2.executeQuery();
           
          while (Rs1.next()) {
        		 int Rs2= Rs1.getInt("GOD");
        		 System.out.println(Rs2);
        		}
         
		   }
	       catch (SQLException e )
		         {
		          e.printStackTrace();
	                         
		         }
		     finally {
		    	      if (Ps1!= null) try {Ps1.close();} catch (Exception e){}
		    	      if (con!= null) try {con.close();} catch (Exception e){}
			
		             }
		
		
		
    }
	public void DBSelect() {
		
		
		try{
		  	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	
		  	con= DriverManager.getConnection("jdbc:mysql://alfacreva.com:3306/alfa_Policija","alfa_Policija","asdfgh123");
	  	
		  	Ps1= con.prepareStatement("SELECT Ime,Prezime,Godiste,ImeRoditelja FROM LicniPodatci ");
		  	
            Rs1= Ps1.executeQuery();
            
            //                               Za bilo koje informacije o bazi
            ResultSetMetaData RsMeta= Rs1.getMetaData();
            int BrojKolone= RsMeta.getColumnCount();
            
            for (int i=1; i<= BrojKolone; i++){
            	 System.out.println("Ime "+i+" kolone: "+ RsMeta.getColumnName(i)+ "  "
            	 		          + " Tim Kolone: "+ RsMeta.getColumnTypeName(i));
            	 System.out.println("=================================================");	 
            }
           // ======================================================================================================
            
           //                                  Za Ispis iz ResultSeta
                 while (Rs1.next()) {
        		System.out.println(Rs1.getString("Ime") + ", " + Rs1.getString("Prezime"));
        		}
           //=======================================================================================================  
                 
            
                 
                 
                 
		   }
	       catch (SQLException e ){
		             
		          	System.out.println("SQL Errorèina:   "+ e.getMessage()+ "        Šifra Errora: "+ e.getErrorCode()); 
		          	e.printStackTrace();
	                         
		   }
		
		catch (Exception es ){
	          es.printStackTrace();
	          	System.out.println("Exception je "+ es.getMessage()); 
	          	es.printStackTrace();
                       
	   }
		     finally {
		    	      if (Rs1!= null) try {Rs1.close();} catch (Exception e){}
		    	      if (Ps1!= null) try {Ps1.close();} catch (Exception e){}
		    	      if (con!= null) try {con.close();} catch (Exception e){}
			
		             }}
		public void DBDelete() {
			
			
			try{
			  	try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  	
			  	con= DriverManager.getConnection("jdbc:mysql://alfacreva.com:3306/alfa_Policija","alfa_Policija","asdfgh123");
		  	
			  	Ps1= con.prepareStatement("DELETE * FROM LicniPodatci ");
			  	
	            Ps1.executeUpdate();
	            
	            //                               Za bilo koje informacije o bazi
	            /*ResultSetMetaData RsMeta= Rs1.getMetaData();
	            int BrojKolone= RsMeta.getColumnCount();
	            
	            for (int i=1; i<= BrojKolone; i++){
	            	 System.out.println("Ime "+i+" kolone: "+ RsMeta.getColumnName(i)+ "  "
	            	 		          + " Tim Kolone: "+ RsMeta.getColumnTypeName(i));
	            	 System.out.println("=================================================");	 
	            }
	           // ======================================================================================================
	            
	           //                                  Za Ispis iz ResultSeta
	                 while (Rs1.next()) {
	        		System.out.println(Rs1.getString("Ime") + ", " + Rs1.getString("Prezime"));
	        		}
	           //=======================================================================================================  
	                 */
	            
	                 
	                 
	                 
			   }
		       catch (SQLException e ){
			             
			          	System.out.println("SQL Errorèina:   "+ e.getMessage()+ "        Šifra Errora: "+ e.getErrorCode()); 
			          	e.printStackTrace();
		                         
			   }
			
			/*catch (Exception es ){
		          es.printStackTrace();
		          	System.out.println("Exception je "+ es.getMessage()); 
		          	es.printStackTrace();
	                       
		   }*/
			     finally {
			    	      if (Rs1!= null) try {Rs1.close();} catch (Exception e){}
			    	      if (Ps1!= null) try {Ps1.close();} catch (Exception e){}
			    	      if (con!= null) try {con.close();} catch (Exception e){}
				
			             }
	}

}
