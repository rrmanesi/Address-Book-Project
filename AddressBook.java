import java.util.ArrayList;

public class AddressBook extends Entry {

   ArrayList<Entry> DB = new ArrayList<>();
   private int initiatize = 0;
   
   public AddressBook() {
   }
   
   public void addEntry(Entry record) {
//	  Entry contact = new Entry();
//      contact.setFirstName(fName);
//      contact.setLastName(lName);
//      contact.setPhoneNumber(Phone.replaceAll("[^0-9]",""));
//      contact.setEmailAddress(email);
      DB.add(record);
     // System.out.println();
//      System.out.println("Added new entry!");
   }
   
   public void removeEntry(String email) {
	   if(!(DB.isEmpty())) {
		   for(Entry rec : DB) {
			   if(rec.getEmailAddress().equalsIgnoreCase(email)) {
				 System.out.println("Deleted the following entry!");
				 System.out.println();
				 System.out.println(rec);
				  DB.remove(rec);
				//System.out.println();
			    return;
			   }
		   }
//		   System.out.println("Email Addresss doesnot exist: ");
//		   System.out.println();
//		   return;
		  
	    } else {
		    System.out.println("Address Book is empty: ");
		    System.out.println();
		    
		   }
	  
   }
   
   public boolean isRecord(String email) {
	
	   if(!(DB.isEmpty())) {
		 for(Entry rec : DB) {
		  if(rec.getEmailAddress().equalsIgnoreCase(email))
				   return true;
		   }
		 return false;
	    }
	  
	   return false;
   }
   
   public void printAddressBook(){
	   
	   if(!DB.isEmpty()){
		   for(Entry record: DB) {
			   System.out.println(record);
		   }
	   }
	   else {
		   System.out.println("Address Book is empty!");
	   }
   }
   
public void SearchBook(String value,int choice) {
	   int recordCount = 0;
	 
	   if(!DB.isEmpty()){
		   for(Entry record: DB) {
			   if(choice == 1) {
				 
				//   System.out.println(record.getFirstName().substring(0, len));
				   if ((record.getFirstName().substring(0, record.getFirstName().length())).contains(value)){
					   System.out.println(record);
					   recordCount ++;
				   }
			   }
			   if(choice == 2) {
				   if((record.getLastName().substring(0, record.getLastName().length())).contains(value)){
					   System.out.println(record);
					   recordCount ++;
				   }
			   }
			   if(choice == 3){
				   if(record.getPhoneNumber().indexOf(value) != -1) {
					   System.out.println(record);
					   recordCount ++;
				   }
			   }
			   if(choice == 4) {
				   if(record.getEmailAddress().equalsIgnoreCase(value)) {
					   System.out.println(record);
					   recordCount ++;
				   }
			   }
			   
		 }
		   
		 
	   }
	   else {
		   System.out.println("Address Book is empty!");
		   System.out.println();
		   return;
	   }
	   
	   if(recordCount == 0) {
		   System.out.println("Record not found");
		   System.out.println();
	   }
	   else
	   {
		   System.out.println("Total record(s) found: " + recordCount);
		   System.out.println();
	   }
   }

   
   public void deleteAddressBook() {
	   
	   if(!DB.isEmpty()){
		  
		    DB.clear();
		    System.out.println("Address Book Cleared: ");
			System.out.println();
		    
	   }
	   else {
		   System.out.println("ERROR!! Address Book is empty: ");
		  //ystem.out.println();
	   }
	   
   }
   
}
