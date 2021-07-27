
import java.util.*;

/*
* ----Merge Duplicate Contacts----
* Welcome! Please read carefully through the comments above provided utility functions.
* You may start writing your code in the main() function.
*/

/*
* Used to store the parsed input data of contacts and to print data to output.
* You are not obliged to work with this class while processing the contacts in your code.
* This is only used by the readInputFromConsole() and printOutputToConsole() 
* functions to take or return contacts data from your code.
*/
class ContactData
{
    public String name;
    public String birthDate;
    public ArrayList<String> phoneNumbers;
    public int lastUpdateTime;
}

class MergeContacts {
    public static void main(String args[] ) throws Exception {

        ArrayList<ContactData> contactsInput = readConsoleInput();
        ArrayList<ContactData> mergedContacts = new ArrayList<ContactData>();
		
		//NOTE: WRITE YOUR CODE HERE. You may also create your own functions and import 
		//additional packages as required.
		
		  Map<String, ContactData> map = new HashMap<>(); 
		  HashSet<String> set = new HashSet<>();
		  ContactData contact = new ContactData();
		  int N= contactsInput.size(); 
		  for(int i =0;i<N;i++) {
			 contact = contactsInput.get(i);
			 int n= contact.phoneNumbers.size();
			 ArrayList<ContactData> duplicates = new ArrayList<ContactData>();
			 for(int j=0;j<n;j++)
			 {
				 map.put(contact.phoneNumbers.get(j), contact);		 
			 }
		  }
		  for(Map.Entry<String, ContactData> v: map.entrySet())
		  {
		  }
        printOutputToConsole(mergedContacts);

    }

//----INPUT PARSING - STARTS
    /*
    * Reads the contacts input data from the console and returns to your code.
    * This function also converts special input 'empty' to empty string.
	* 
	* !!!!! NOTE !!!!!
	* Changing the code inside this function is not recommended, 
	* as it may impact the output of your program.
	* 
    * Example Input:
    * 3
    * alice
    * 05-06-2000
    * 3
    * 12345678 empty (022)-2456-7890
    * 5
    * Bob Parson
    * empty
    * 1
    * 56728192
    * 10
    * Alice Weasley
    * empty
    * 2
    * 12345678 98765432
    * 20
    */
    private static ArrayList<ContactData> readConsoleInput()
    {
        Scanner s = new Scanner(System.in);
        int numberOfContacts = Integer.parseInt(s.nextLine());
        ArrayList<ContactData> contactsInputList = new ArrayList<ContactData>();
        for(int i = 0; i < numberOfContacts; i++)
        {
            ContactData contact = new ContactData();
            contactsInputList.add(contact);

            contact.name = s.nextLine(); 
            contact.birthDate = s.nextLine();
            if(contact.birthDate.equals("empty"))
            {
                contact.birthDate = "";
            }

            int numberOfPhones = Integer.parseInt(s.nextLine());
            contact.phoneNumbers = new ArrayList<String>();
            if(numberOfPhones > 0)
            {
                String[] phoneNumbersInput = s.nextLine().split(" ");
                for (int k = 0; k < phoneNumbersInput.length; k++) 
                {
                    contact.phoneNumbers.add(
                        (phoneNumbersInput[k].equals("empty") == false) ? 
                        phoneNumbersInput[k] : "");
                }
            }
            else
            {
                s.nextLine();
            }

            contact.lastUpdateTime = Integer.parseInt(s.nextLine());
        }
        return contactsInputList;
    }
//----INPUT PARSING - ENDS

//----OUTPUT PRINTING - STARTS
    /*
    * Takes the merged contacts data from your code and prints it to console in required format.
	* It takes care of printing the output in correct format and in correct order.
    * Also prints empty strings as special output 'empty'.
	* 
	* !!!!! NOTE !!!!!
	* Changing the code inside this function is not recommended, 
	* as it may impact the output of your program.
	* 
    * Example Output:
    * Alice Weasley
    * 05-06-2000
    * empty 12345678 (022)-2456-7890 98765432
    * 20
    * Bob Parson
    * empty
    * 56728192
    * 10
    * 
    */
    private static void printOutputToConsole(ArrayList<ContactData> mergedContacts)
    {
        mergedContacts.sort((ContactData c1, ContactData c2) -> c1.name.compareTo(c2.name));
        for (ContactData contactData : mergedContacts) 
        {
            System.out.println(contactData.name);

            System.out.println((contactData.birthDate.equals("") == false) ? 
                contactData.birthDate : "empty");

            if(contactData.phoneNumbers.isEmpty() == false)
            {
                Collections.sort(contactData.phoneNumbers);
                String phoneNumbersOut = "";
                for (String phone : contactData.phoneNumbers) 
                {
                    phoneNumbersOut = phoneNumbersOut + 
                    ((phone.equals("") == false) ? phone : "empty") + " ";
                }
                phoneNumbersOut = phoneNumbersOut.substring(0, phoneNumbersOut.length() - 1);
                System.out.println(phoneNumbersOut);
            }
            else
            {
                System.out.println();
            }

            System.out.println(contactData.lastUpdateTime);
        }
    }
//----OUTPUT PRINTING - ENDS
}