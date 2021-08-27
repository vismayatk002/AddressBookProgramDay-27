package com.addressbookprogramday_27;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OperateContact {

	HashMap<String, AddressBook> contactMap = new HashMap<>();
	   
    public void editContact(){

        String address;
        Scanner sc= new Scanner(System.in);
        System.out.print("\nEnter the First name for update Address : ");
        String editName = sc.nextLine();
        int flag = 1;
        for (String firstName : contactMap.keySet())
        {
            AddressBook contact = contactMap.get(firstName);

            if(editName.equals(contact.getFirstName())){
                System.out.print("\nEnter your new Address : ");
                address = sc.nextLine();
                contact.setAddress(address);
                flag = 0;
            }
        }
        if(flag == 1){
            System.out.print("\ncouldn't find the contact..");
        }
        else{
            System.out.print("\nYour contact updated.");
        }
    }
    public void deleteContact(){

        Scanner sc= new Scanner(System.in);
        System.out.print("\nEnter the First name for delete : ");
        String deleteName = sc.nextLine();
        int flag = 1;
        for (String firstName : contactMap.keySet())
        {
            AddressBook contact = contactMap.get(firstName);
            if(deleteName.equals(contact.getFirstName())){
                contactMap.remove(firstName);
                flag = 0;
            }
        }
        if(flag == 1){
            System.out.print("\ncouldn't find the contact..");
        } 
        else{
            System.out.print("\nYour contact deleted..");
        }
        sc.close();   
    }
    public void showContact(){

        for (String firstName : contactMap.keySet())
        {
            AddressBook contact = contactMap.get(firstName);

            System.out.print("\n-----------------");
            System.out.print("\nFirst Name  : " +  contact.getFirstName());
            System.out.print("\nLast Name   : " +  contact.getLastName());
            System.out.print("\nAddress     : " +  contact.getAddress());
            System.out.print("\nCity        : " +  contact.getCity());
            System.out.print("\nState       : " +  contact.getState());
            System.out.print("\nPone Number : " +  contact.getPhoneNo());
            System.out.print("\nE-mail      : " +  contact.getEmail());
            System.out.print("\nZip         : " +  contact.getZip());
        }
    }
    public void storeContact(String firstName, AddressBook contact){

        this.contactMap.put(firstName, contact);
    }
    public void searchPerson() {
    	 Scanner sc= new Scanner(System.in);
         System.out.print("\nEnter the city : ");
         String city = sc.nextLine();
         
         List<String> person = contactMap.entrySet() 
		         .stream() 
		         .filter(HashMap -> HashMap.getValue().getCity().equals(city))
		         .map(HashMap -> HashMap.getValue().getFirstName())
		         .collect(Collectors.toList());
         
         System.out.println(String.join(",", person));  
    }
    public void sortByName() {
    	
    	List<AddressBook> person = contactMap.entrySet()
    			.stream()
    			.sorted(HashMap.Entry.comparingByValue())
    			.map(HashMap -> HashMap.getValue())
		        .collect(Collectors.toList());
    	
    	for (AddressBook contact : person)
    	{
            System.out.print("\n-----------------");
            System.out.print("\nFirst Name  : " +  contact.getFirstName());
            System.out.print("\nLast Name   : " +  contact.getLastName());
            System.out.print("\nAddress     : " +  contact.getAddress());
            System.out.print("\nCity        : " +  contact.getCity());
            System.out.print("\nState       : " +  contact.getState());
            System.out.print("\nPone Number : " +  contact.getPhoneNo());
            System.out.print("\nE-mail      : " +  contact.getEmail());
            System.out.print("\nZip         : " +  contact.getZip());
        } 
    }
}
