import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddressBookDemo {
	
	 static Scanner scan = new Scanner(System.in);
	 static AddressBook Book1 = new AddressBook();
	// static AddressBook Book2 = new AddressBook();
	 static String firstName;
     static String lastName;
     static String phoneNumber = "";
     static String emailAddress;
	 private static void AddAnEntry() {
		
//    	 String firstName;
//         String last;
//         String pnumber = "";
//         String emailAddress;
		 try {
         System.out.println("Enter First Name: ");
         firstName = scan.nextLine();
         firstName = firstName.substring(0,1).toUpperCase()+firstName.substring(1).toLowerCase();
     //   System.out.println(firstName);
         System.out.println("Enter Last Name: ");
         lastName = scan.nextLine();
         lastName = lastName.substring(0,1).toUpperCase()+lastName.substring(1).toLowerCase();
		 }
		 catch(Exception e)
		 {
			 System.out.println("Invalid input. Cannot be empty ");
			 System.out.println();
			 return;
		 }
         System.out.println("Enter phone number: ");
         System.out.println("For example '111111111' or '111-111-1111' or '(111)-111-1111'");
         phoneNumber = scan.nextLine();
         boolean isValid = isValidPhone(phoneNumber);
         while (!isValid)
         {
         System.out.println("Enter valid phone number: ");
         System.out.println("For example '111111111' or '111-111-1111' or '(111)-111-1111'");
         phoneNumber = scan.nextLine();
         isValid = isValidPhone(phoneNumber);
         }
         phoneNumber = phoneNumber.replaceAll("[^0-9]","");
         System.out.println("Enter email address: ");
         emailAddress = scan.nextLine().toLowerCase();
         System.out.println(emailAddress);
         isValid = isValidEmail(emailAddress);
         while (!isValid)
         {
        	  System.out.println("Enter valid email address: ");
              emailAddress = scan.nextLine();
              isValid = isValidEmail(emailAddress);
         }
         
         if(!Book1.isRecord(emailAddress)) {
         	
         	Book1.addEntry(new Entry(firstName,lastName,phoneNumber,emailAddress));
         	System.out.println();
            System.out.println("Added new entry!");
         }
         else {
        	 System.out.println("Email already exists: ");
        	 System.out.println();
         }
     }
	 
	 private static boolean isValidEmail(String emailAddress) {
		// TODO Auto-generated method stub
		 String EMAIL_PATTERN = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		 
		 if(emailAddress.matches(EMAIL_PATTERN)) {
			 return true;
		 }
		 else {
		   return false;
		 }
	}

	private static boolean isValidPhone(String phoneNumber) {
		 String pattern = ("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}");
		 String pattern2 = ("\\d{10}");
		 String pattern3 = ("\\(\\d{3}\\)-\\d{3}-\\d{4}");
		 String pattern4 = ("\\(\\d{3}\\)\\d{3}-\\d{4}");
		 String pattern5 = ("\\(\\d{3}\\)\\d{3}\\d{4}");
		 String pattern6 = ("\\(\\d{3}\\)\\s\\d{3}\\s\\d{4}");
		 String pattern7 = ("\\(\\d{3}\\)-\\d{3}\\d{4}");
		 String pattern8 = ("\\(\\d{3}\\)-\\d{3}\\s\\d{4}");
		
		 if(phoneNumber.matches(pattern) || phoneNumber.matches(pattern2) || phoneNumber.matches(pattern3)|| phoneNumber.matches(pattern4)
				 || phoneNumber.matches(pattern5)|| phoneNumber.matches(pattern6)|| phoneNumber.matches(pattern7)
				 || phoneNumber.matches(pattern8)){
			 return true;
		 }
		 else
		 {
		// TODO Auto-generated method stub
		 return false;
		 }
	}

	private static void showMenu() 
     {
   	  System.out.println("1) Add an entry");
   	  System.out.println("2) Remove an entry");
   	  System.out.println("3) Search for a specific entry");
   	  System.out.println("4) Print Address Book");
   	  System.out.println("5) Delete Book");
   	  System.out.println("6) Quit");
   	  System.out.println();
   	  System.out.println("Please choose what you'd like to do with the database:");
     }
	 
	 private static void PrintAddressBook() {
		  Book1.printAddressBook();
	//	  Book2.printAddressBook();
		  System.out.println();
		 
	 }
	 
	 private static void DeleteBook() {
			// TODO Auto-generated method stub
		    System.out.println("WARNING DATA WILL BE LOST:");
		    System.out.println("Are you sure you want to continue :");
		    String confirm = scan.nextLine();
		    while(!(confirm.equalsIgnoreCase("Yes") || confirm.equalsIgnoreCase("No") || confirm.equalsIgnoreCase("Y") || confirm.equalsIgnoreCase("N"))){
			  System.out.println("Please enter 'Yes' OR 'No' ");
			  confirm = scan.nextLine();
		    }
		    if(confirm.equalsIgnoreCase("Yes") || confirm.equalsIgnoreCase("Y")) {
		    Book1.deleteAddressBook();
		    }
		    System.out.println();
		}

		private static void RemoveAnEntry() {
			// TODO Auto-generated method stub
			System.out.println("Enter an entry's email to remove: ");
			 emailAddress = scan.nextLine();
	         boolean isValid = isValidEmail(emailAddress);
	         while (!isValid)
	         {
	        	  System.out.println("Enter valid email address: ");
	              emailAddress = scan.nextLine();
	              isValid = isValidEmail(emailAddress);
	         }
	         
	         if(!Book1.isRecord(emailAddress)) {
	          	System.out.println("Email address does not exists");
	          	System.out.println();
	          }
	          else
	          {
	            
	          	Book1.removeEntry(emailAddress);
	          	System.out.println();
	          }
	        
			
		}
	 
		private static void SearchForAnEntry() {
			// TODO Auto-generated method stub
			System.out.println("1) First Name");
			System.out.println("2) Last Name");
			System.out.println("3) Phone Number");
			System.out.println("4) Email Address");
			System.out.println("Choose a search type: ");	
			int choice= ' ';
			boolean isValid;
			String searchValue;
			try {
				choice = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid search option");
				System.out.println();
				return;
			}
			
			switch(choice) {
			case 1:     System.out.println("Enter first name to search: ");
			             try {
			            	 searchValue= scan.nextLine();
			            	 searchValue = searchValue.substring(0,1).toUpperCase()+searchValue.substring(1).toLowerCase();
			          //  	 System.out.println(searchValue);
			            	 Book1.SearchBook(searchValue,choice);
			             }
			             catch(Exception e) {
			            	 System.out.println("Invalid input" + e);
			             }
				break;
				
			case 2:      System.out.println("Enter last name to search: ");
						try {
							searchValue= scan.nextLine();
							searchValue = searchValue.substring(0,1).toUpperCase()+searchValue.substring(1).toLowerCase();
							Book1.SearchBook(searchValue,choice);
						}
						catch(Exception e) {
							System.out.println("Invalid input");
						}
				break;
				
			case 3:      System.out.println("Enter the phone number to search: ");
			            try {
						 System.out.println("For example '111111111' or '111-111-1111' or '(111)-111-1111'");
						 phoneNumber = scan.nextLine();
						 isValid = isValidPhone(phoneNumber);
						 while (!isValid)
						 {
							 System.out.println("Enter a valid phone number to search: ");
							 System.out.println("For example '111111111' or '111-111-1111' or '(111)-111-1111'");
							 phoneNumber = scan.nextLine();
							 isValid = isValidPhone(phoneNumber);
						 }
						     phoneNumber = phoneNumber.replaceAll("[^0-9]","");
						     Book1.SearchBook(phoneNumber, choice);
						 }catch(Exception e) {
							System.out.println("Invalid input");
						 }
				break;
				
			case 4:      System.out.println("Enter an email address to search: ");
						try {
							emailAddress = scan.nextLine();
							isValid = isValidEmail(emailAddress);
							while (!isValid)
	                     {
	                    	 System.out.println("Enter a valid email address to search: ");
	                    	 emailAddress = scan.nextLine();
	                    	 isValid = isValidEmail(emailAddress);
	                     }
							Book1.SearchBook(emailAddress, choice);
							}catch(Exception e) {
								System.out.println("Invalid input");
							}
			
				break;
				
			default:System.out.println("Invalid choice selection");
			        System.out.println();
				break;
				
			}
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 String data = null;
//		 String [] values = new String[4];
//		 System.out.println("Loading Data into Address Book......");
//	     System.out.println();
//		try {
//		      File myObj = new File("src/input.txt");
//		      Scanner fileReader = new Scanner(myObj);
//		      while (fileReader.hasNextLine()) {
//		        data = fileReader.nextLine();
//		        values = data.split(",");
//		        firstName = values[0].trim();
//		        lastName = values[1];
//		        phoneNumber = values[2];
//		        emailAddress = values[3];
//		        System.out.println(firstName);
//		        firstName = Character.toUpperCase(firstName.charAt(0))+firstName.substring(1).toLowerCase();
//		        lastName = lastName.substring(0,1).toUpperCase()+lastName.substring(1).toLowerCase();
//		        phoneNumber = phoneNumber.replaceAll("[^0-9]","");
//		        emailAddress = emailAddress.toLowerCase();
//		        Book1.addEntry(new Entry(firstName,lastName,phoneNumber,emailAddress));
//		      }
//		      fileReader.close();
//		    } catch (FileNotFoundException e) {
//		      System.out.println("An error occurred.");
//		      
//		      e.printStackTrace();
//		    }
        int stop=' ';
       
        System.out.println("Welcome to Address Book Database: ");
        while (stop!= 6)
        {
            showMenu();
            
            try {
            stop = Integer.parseInt(scan.nextLine());
            }
            catch(Exception e) {
             System.out.println("Invalid input");
             System.out.println();
             continue;
            }
            
            switch(stop) {
            case 1:  AddAnEntry();
            	break;
            	
            case 2:  RemoveAnEntry();
            	break;
            
            case 3:  SearchForAnEntry();
        	break;
        
            case 4: PrintAddressBook();
            	break;
            	
            case 5: DeleteBook();
                break;
            
            case 6:  System.out.println("Thank you for using Address Book");
            	break;
            	
            default: System.out.println("Invalid choice selection");
                     System.out.println();
            	break;
            }
          
        }
        
        
	}

	

	

}
