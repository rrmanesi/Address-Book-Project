
public class Entry {
	
	private String FirstName;
	private String LastName;
	private String PhoneNumber;
	private String EmailAddress;
	
	
	public Entry() {
		
	}
	public Entry(String firstName, String lastName, String phoneNumber, String emailAddress) {
		super();
		FirstName = firstName;
		LastName = lastName;
		PhoneNumber = phoneNumber;
		EmailAddress = emailAddress;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	
	
	
	
    @Override
	
    public String toString() 
	
    {
	
        return String.format("***************\nFirst Name: %s\nLast Name: %s\nPhone Number: %s\nEmail: %s\n*************",
	
                this.getFirstName(),
                this.getLastName(),
                this.getPhoneNumber(),
                this.getEmailAddress());
	
    }
	

}
