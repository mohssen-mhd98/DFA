import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



import java.util.NoSuchElementException;
public class Mm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		registerFactor_food();
/*	
		 Connection conn = null;
	       Statement statement;
	    	
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    

	     statement = conn.createStatement();

	   /* String b = "تت";
	    String n = "32000";*/
		  /*  Date d = new Date();
		    LocalDateTime now = LocalDateTime.now();
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		    String currentDateTime = format.format(d);
		    System.out.println(d);
		    
	    statement.executeUpdate("insert into factor_food "+"(factor_number,date,total_cost,address,deliveryNational_code)"+"values"+"(22,now(),20000,'kjkjs','0043265203')");
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}*/

	}
	

	 public static void db(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();
	     int sum=0;
	     int sum1=0;
	     int c;
	     int ff=0;
	     String favoriteFood = null;
	     user_id = sc.nextLine();
	    	System.out.println(user_id);
	     ResultSet rset1;
	     
	    ResultSet rset = statement.executeQuery("select factor_number from factor_food_withname where customerNational_code = '"+user_id+"' ");
	    while(rset.next()){
	    	
	    	c= rset.getInt("factor_number");
	    	//System.out.println(c);
	    	//System.out.println(user_id);
	        System.out.println("Factor number : " + c);
		    rset1 = st.executeQuery("select order_FoodFood_name,order_FoodFood_price from contains where factor_FoodFactor_number = '"+c+"' ");
		    while(rset1.next()) {
	        System.out.println(rset1.getString("order_FoodFood_name")+"\t"+rset1.getInt("order_FoodFood_price") );
	        System.out.println();
	        }
	    }
	    
	    rset = statement.executeQuery("select factor_number from factor_food_withname where customerNational_code = '"+user_id+"' ");

	    while(rset.next()){
	    	c= rset.getInt("factor_number");
	        rset1 = st.executeQuery("select count(*)as num,order_FoodFood_name  \r\n" + 
	        		"from `contains`,factor_food_withname,customer \r\n" + 
	        		"where factor_FoodFactor_number=factor_number and customerNational_code=national_code and national_code='0021563600'\r\n" + 
	        		" group by order_FoodFood_name ");
		  
		    while(rset1.next()) {
		    	
		    	if(ff<rset1.getInt("num")) {
		    		favoriteFood = rset1.getString("order_FoodFood_name");
		    		ff = rset1.getInt("num");
		    	}

			   /*System.out.print(rset1.getInt("num"));
			   System.out.println(rset1.getString("order_FoodFood_name"));*/
	        }
	    }
	    System.out.println("Your favorite food is : "+favoriteFood);
	    
	   
	  /*  rset = statement.executeQuery("select factor_ingredients,total_cost from factor_food");
	    while(rset.next()){	0021563600
	        System.out.println(rset.getInt("factor_number")+"\t"+rset.getInt("total_cost") );
	        sum += rset.getInt("total_cost");
	        System.out.println(sum);
	    }*/

	    //statement.executeUpdate("Update address set customer_name='"+b+"' where address_id=9 ");
	    //statement.execute("insert into menu values('"+b+"' ,'"+n+"' )");
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }
	 
 public static void editDelivery() {
		 
     //Scanner sc = new Scanner(System.in);
	 
	 while(true) {
		 try {
			// String h = sc.nextLine();
		 }catch(NoSuchElementException e) {
			 e.getMessage();
		 }
		  Scanner sc = new Scanner(System.in);
		 System.out.println("Editing user !!!");
		 System.out.println("if you wanna stay her Enter c | for Exit Enter e");
		 
			 String c = sc.nextLine();
		      if(c.equals("e"))break;
			 
		  System.out.println("for creating user Enter i | for updating user Enter u | for updating user Enter d");
	      String choice = sc.nextLine();
	      switch(choice) {
	      
	      case "i":
	    	  //insertFactor(0, 0, 0, choice, choice, choice, choice);
	    	  break;
	      case "u":
	    	  updateDelivery();
	    	  break;
	    	  
	      case "d":
	    	  deleteDelivery();
	    	  break; 
	    	  
	      }
	      sc.close();
	 }   

		  
	 }
	 
	 
	 public static void insertFactor(int factor_number, int add_id , int tCost , String cName ,
			 String cNCode , String address, String dNCode){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();

	     String favoriteFood = null;

	     ResultSet rset1;
	     //System.out.println("Customer Name\t address_id :");
		   /* ResultSet rset = statement.executeQuery("select address_id,customer_name from address");
		    rset1 = st.executeQuery("select national_code from delivery");
		    while(rset.next()){
		        System.out.println(rset.getString("customer_name") +"\t"+"\t"+"\t"+rset.getInt("address_id"));
		    }
		    
		     System.out.println("Delivery id  :");
			    rset1 = statement.executeQuery("select national_code from delivery");
			    while(rset1.next()){
			    	System.out.println(rset1.getString("national_code"));
			    }
		    
	   /* System.out.print("----------------------------\n");
	    statement.executeUpdate("insert into factor_food_withname "+
	    "(factor_number,address_id,total_cost,storeStore_name)"+
	    "values"+"('"+factor_number+"','"+totalCost+"','"+storeName+"')");*/
		    
		    System.out.print("----------------------------\n");
		    
		    if(address.equals("0")) {
		    	
		    	if(cName.equals("0")) {
		    		
				    statement.executeUpdate("insert into factor_food_withname "+
						    "(factor_number,total_cost)"+
						    "values"+"('"+factor_number+"','"+tCost+"')");
		    		
		    	}
		    	else {
		    		
		   		 statement.executeUpdate("insert into factor_food_withname "+
		   				 "(factor_number,total_cost,customer_name,customerNational_code)"+
		   				  "values"+"('"+factor_number+"','"+tCost+"','"+cName+"','"+cNCode+"')");
		    	}
		    	
		    }else {
		    	
		    	if(cName.equals("0")) {
		    		
		   		 statement.executeUpdate("insert into factor_food_withname "+
		   			  "(factor_number,total_cost,address,deliveryNational_code)"+
		   			  "values"+"('"+factor_number+"','"+tCost+"','"+address+"','"+dNCode+"')");	
		    	}else {
		    		
		   		 statement.executeUpdate("insert into factor_food_withname "+
		   			    "(factor_number,address_id,total_cost,customer_name,customerNational_code,address,deliveryNational_code)"+
		   			    "values"+"('"+factor_number+"','"+add_id+"''"+tCost+"','"+cName+"','"+cNCode+"','"+address+"','"+dNCode+"')");
		    	}
		    	
		    }
		    
		   /* statement.executeUpdate("insert into factor_food_withname "+
		    "(factor_number,total_cost)"+
		    "values"+"('"+factor_number+"','"+tCost+"')");
		    
		 statement.executeUpdate("insert into factor_food_withname "+
		    "(factor_number,address_id,total_cost,customer_name,customerNational_code,address,deliveryNational_code)"+
		    "values"+"('"+factor_number+"','"+add_id+"''"+tCost+"','"+cName+"','"+cNCode+"','"+address+"','"+dNCode+"')");
		 statement.executeUpdate("insert into factor_food_withname "+
			  "(factor_number,total_cost,address,deliveryNational_code)"+
			  "values"+"('"+factor_number+"','"+tCost+"','"+address+"','"+dNCode+"')");	
		 
		 statement.executeUpdate("insert into factor_food_withname "+
			 "(factor_number,total_cost,customer_name,customerNational_code)"+
			  "values"+"('"+factor_number+"','"+tCost+"','"+cName+"','"+cNCode+"')");
		    
		    
		    
	    System.out.println("Add Order Food :");
	   /* System.out.println("To Exit input e :");
	    String e  = sc.nextLine();
	    if(e.equals("e"))break;*/
	   /* System.out.println("Input Factor Number  :");
	     int fNUm  = sc.nextInt();
		 System.out.println("Input Customer Name  :");
	     String cName  = sc.nextLine();
		 System.out.println("Input Customer Name  :");
	     String cNCode  = sc.nextLine();
		 System.out.println("Input Delivery national Code  :");
	     String dNCode  = sc.nextLine();
	     System.out.println("Input Mobile Phone  :");
	     int add_id  = sc.nextInt();
	     String address  = sc.nextLine();*/
	     
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");
	    
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	
 public static void updateDelivery(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();

	     String favoriteFood = null;

	     ResultSet rset1;
	     
	    ResultSet rset = statement.executeQuery("select * from delivery ");
	    System.out.println("national_code\tname\tmobile_phone");
	    while(rset.next()){
	    	
	        System.out.println(rset.getString("national_code")+"\t"+rset.getString("name")+
	        		"\t"+rset.getString("Lname")+"\t"+rset.getString("mobile_phone"));

	        }
	    System.out.print("----------------------------\n");

	   /* System.out.println("Input User National Code For Update  :");
	     String nc  = sc.nextLine();*/
	     Boolean t = true;
	    
	     while(t) {
	 	   
	    	 
	    	 System.out.println("To Exit Enter e | to continue Enter c :");
	    	 String choice1  = sc.nextLine();
	    	 if(choice1.equals("e")) break;
	 	    System.out.println("which item do you want to Update :");
	 	   System.out.println("name\t| Lname\t| mobile_phone\t| national_code");
	    	 System.out.println("Input column Name to change it :");
		     String choice  = sc.nextLine();
		     String nc;

		     switch(choice) {
		     	
		     case "name":
	     			System.out.println("Input Delivery National Code For Update  :");
	     		      nc  = sc.nextLine();
	     			System.out.println("Input New Name  :");
	     			String n  = sc.nextLine();    			
	     		    statement.executeUpdate("Update delivery set name='"+n+"' where national_code='"+nc+"'");
	     		    break;
	     		    
		     case "Lname":
	     			System.out.println("Input Delivery National Code For Update  :");
	     		     nc  = sc.nextLine();
	     			System.out.println("Input NEW Last Name  :");
	     			String ln  = sc.nextLine();	
	     			statement.executeUpdate("Update delivery set Lname='"+ln+"' where national_code='"+nc+"'");	
				    	 break;
				    	 
		     case "mobile_phone":		    	 
	     			System.out.println("Input Delivery National Code For Update  :");
	     		    	nc  = sc.nextLine();
	     			System.out.println("Input NEW Mobile Phone  :");
	     			String mp  = sc.nextLine();	
	     			statement.executeUpdate("Update delivery set mobile_phone='"+mp+"' where national_code='"+nc+"'");
	     			break;
	     			
		     case "national_code":
    			 System.out.println("Input delivery National Code For Update  :");
    			 	nc  = sc.nextLine();
    			 System.out.println("Input NEW National Code  :");
    		     String nc1  = sc.nextLine();
    		     statement.executeUpdate("Update delivery set national_code='"+nc1+"' where national_code='"+nc+"'");
   		     break;
   		     
   		default :
   			System.out.println("Wrong input!! Pleas try again");
		     
		     }

	    	 
	    	/* System.out.println("To Exit Enter e | to continue Enter c :");
	    	 String choice1  = sc.nextLine();
	    	 if(choice1.equals("e")) break;
	 	    System.out.println("which item do you want to Update :");
	 	   System.out.println("name\t| lname\t| mobile_phone\t| age");
	    	 System.out.println("Input column Name to change it :");
		     String choice  = sc.nextLine();
		     
		     		if(choice.equals("name")) {
		     			
		     			System.out.println("Input User National Code For Update  :");
		     		     String nc  = sc.nextLine();
		     			System.out.println("Input Name  :");
		     			String n  = sc.nextLine();    			
		     		    statement.executeUpdate("Update customer set name='"+n+"' where national_code='"+nc+"'");
		     		}
		     			
		     		if(choice.equals("Lname")) {
		     			
		     			System.out.println("Input User National Code For Update  :");
		     		    String nc  = sc.nextLine();
		     			System.out.println("Input Last Name  :");
		     			String ln  = sc.nextLine();	
		     			statement.executeUpdate("Update customer set Lname='"+ln+"' where national_code='"+nc+"'");	
		     		}
		     		
		     		if(choice.equals("mobile_phone")) {
		     			
		     			System.out.println("Input User National Code For Update  :");
		     		    String nc  = sc.nextLine();
		     			System.out.println("Input Mobile Phone  :");
		     			String mp  = sc.nextLine();	
		     			statement.executeUpdate("Update customer set mobile_phone='"+mp+"' where national_code='"+nc+"'");
		     		}
		     		
		     		if(choice.equals("age")) {
		     			
		     			System.out.println("Input User National Code For Update  :");
		     		    String nc  = sc.nextLine();
		     			System.out.println("Input Age  :");
		     			int age= sc.nextInt();
		     			statement.executeUpdate("Update customer set age='"+age+"' where national_code='"+nc+"'");
		     		}
		     		
		    		if(choice.equals("national_code")) {
		    			
		    			 System.out.println("Input User National Code For Update  :");
		    		     String nc  = sc.nextLine();
		    			 System.out.println("Input National Code  :");
		    		     String nc1  = sc.nextLine();
		    		     statement.executeUpdate("Update customer set national_code='"+nc1+"' where national_code='"+nc+"'");
		    		}*/
	    	 
	    	 
	     }
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");

	    

	    System.out.println("----Update was Successful----");
	    sc.close();
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }

	 public static void deleteDelivery(){
	      Connection conn = null;
	       Statement statement,st;
	       String user_id;
	       Scanner sc = new Scanner(System.in);
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    
	     statement = conn.createStatement();
	     st = conn.createStatement();


	     
	    ResultSet rset = statement.executeQuery("select * from delivery ");
	    System.out.println("national_code\tname\tmobile_phone");
	    while(rset.next()){
	    	
	        System.out.println(rset.getString("national_code")+"\t"+rset.getString("name")+
	        		"\t"+rset.getString("Lname")+"\t"+rset.getString("mobile_phone"));

	        }
	    System.out.print("----------------------------\n");

	    
	   /* System.out.println("Input User National Code For Update  :");
	     String nc  = sc.nextLine();*/
	     Boolean t = true;
	     
	     
	    
	     while(t) {
	 	   
	    	 System.out.println("To Exit Enter e | to continue Enter c :");
	    	 String choice1  = sc.nextLine();
	    	 if(choice1.equals("e")) break;
	 	    System.out.println("which item do you want to Delete :");
	 	   System.out.println("name\t| Lname\t| mobile_phone\t| age\t| national_code");
	    	 System.out.println("Input column Name to Delete row(s) :");
		     String choice  = sc.nextLine();
		     
		     switch(choice) {
		     	
		     case "name":
	     			System.out.println("Input Name to Delete  :");
	     			String n  = sc.nextLine();    			
	     		    statement.executeUpdate("Delete from delivery where name='"+n+"' ");
	     		    break;
	     		    
		     case "Lname":
		     			System.out.println("Input Last Name to Delete :");
		     			String ln  = sc.nextLine();	
		     			statement.executeUpdate("Delete from delivery where Lname='"+ln+"'");
				    	 break;
		     case "mobile_phone":
	     			System.out.println("Input Mobile Phone to Delete :");
	     			String mp  = sc.nextLine();	
	     			statement.executeUpdate("Delete delivery  where mobile_phone='"+mp+"'");
	     			break;
	     			
		     case "national_code":
  			 System.out.println("Input User National Code to Delete  :");
  		     String nc  = sc.nextLine();
  		     statement.executeUpdate("Delete from delivery where national_code='"+nc+"'");
  		     break;
  		default :
  			System.out.println("Wrong input!! Pleas try again");
		     
		     }

	    	 
	     }
	    
	   // statement.executeUpdate("insert address set customer_name='"+b+"' where address_id=9 ");

	    

	    System.out.println("----Deletion was Successful----");
	    //sc.close();
	    
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }
	 

	 public static void insertfoodOrder(int fact_num , String foodName, int price , int num) {
		 
		 Connection conn = null;
	       Statement statement;
	    	//db();
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/db_final_project";
	    String user      = "root";
	    String password  = "emma1998";
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...    

	     statement = conn.createStatement();

	   /* String b = "تت";
	    String n = "32000";*/
	    Date d = new Date();
	    LocalDateTime now = LocalDateTime.now();
	    System.out.println(d);
	     
	    statement.executeUpdate("insert into contains "+"(factor_FoodFactor_number,order_FoodFood_name,order_FoodFood_price,numberOfOrder)" + "values" +"('"+fact_num+"','"+foodName+"','"+price+"','"+num+"')");
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	    System.out.print("\ndkcsjcksjckjsdd");
	} finally {
	    try{
	           if(conn != null){
	            conn.close();
	           System.out.print("\nddd");
	           }

	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
	    }
	}

	    }
	 
	 
	 public static void registerFactor_food()
		{
			Connection conn = null;
		       Statement statement,st;
		       Scanner sc = new Scanner(System.in);
		       String c = "e";
		   	int factor_number;
		   		
			int address_id=0;
			//String cName=null;
			int []price = new int[10]; 
			int []num = new int[10]; 
			String foodName;
			int total=0;
			int number;
			int i =0;
			String h;
			String storeName;
			ArrayList<String> oName = new ArrayList<String>();
			  int fact_num=3 ;
			  
		       String user_id;

		try {
		    // db parameters
		    String url       = "jdbc:mysql://localhost:3306/db_final_project";
		    String user      = "root";
		    String password  = "emma1998";
		    
		    // create a connection to the database
		    conn = DriverManager.getConnection(url, user, password);
		    // more processing here
		    // ...    
		     statement = conn.createStatement();
		     st = conn.createStatement();

		     String favoriteFood = null;

		     ResultSet rset1;
		     System.out.println("Customer Name\t address_id :");
			    ResultSet rset = statement.executeQuery("select address_id,customer_name from address");
			    rset1 = st.executeQuery("select national_code from delivery");
			    while(rset.next()){
			        System.out.println(rset.getString("customer_name") +"\t"+"\t"+"\t"+rset.getInt("address_id"));
			    }
			    
			     System.out.println("Delivery id  :");
				    rset1 = statement.executeQuery("select national_code from delivery");
				    while(rset1.next()){
				    	System.out.println(rset1.getString("national_code"));
				    }

			  
			//while(c.equals("e")) {

			  	//show stores and names
				//showStores();
				
				System.out.println("Order Food :");
				System.out.println("!! Any Item You want to put it null Enter 0 for it !! :");
				//System.out.println("to EXIT press m :");
				//c = sc.nextLine();
			//	if(c.equals("e"))break;
				System.out.println("factor_number :");
				factor_number = sc.nextInt();
				//System.out.print(factor_number);
				 System.out.println("Input Customer Name  :");
				 String h1 = sc.nextLine();
			     String cName  = sc.nextLine();
				 System.out.println("Input Customer National Code  :");
			     String cNCode  = sc.nextLine();
				 System.out.println("Input Delivery national Code  :");
			     String dNCode  = sc.nextLine();
			     System.out.println("Input Address Id  :");
			     int add_id  = sc.nextInt();
			     System.out.println("Input Address   :");
			     h1 = sc.nextLine();
			     String address  = sc.nextLine();
				
				

				 
					System.out.printf("%d--------",factor_number);

					for(int i1=0;i1<num.length;i1++ ) {

					System.out.println("to EXIT press e :");
					c = sc.nextLine();
					if(c.equals("e"))break;
					System.out.println("Food_name :");
					oName.add(sc.nextLine());
					
					System.out.println("Number :");
					num[i1] = sc.nextInt();
					System.out.println("Food Price :");
					price[i1] = sc.nextInt();
					c = sc.nextLine();
					total += price[i1]*num[i1];
					
					
				}
					// h = sc.nextLine();
					System.out.println(total);
					 //register_factor(factor_number,storeName,total);
					insertFactor(factor_number,add_id,total,cName,cNCode,address,dNCode);
					for(int i1=0;i1<oName.size();i1++ )
				  insertfoodOrder( factor_number ,oName.get(i1),price[i1] ,num[i1]);

					
				/* Factor_food f = new Factor_food(11,"scscc",5, null ,4000,"nima" );
					System.out.println(factor_number);
				 register_factor(factor_number,storeName,total);
				/* for(int j=0;j<o.length;j++) {
					 o[j].register_factor();
				 }*/
			
		} catch(SQLException e) {
			   System.out.println(e.getMessage());
			    System.out.print("\ndkcsjcksjckjsdd");
			} finally {
			    try{
			           if(conn != null){
			            conn.close();
			           System.out.print("\nddd");
			           }

			    }catch(SQLException ex){
			           System.out.println(ex.getMessage());
			            System.out.print("\ndkcsjcksjckjsdd555555555555555555");
			    }
			}

				
			
		}
		
	 
}