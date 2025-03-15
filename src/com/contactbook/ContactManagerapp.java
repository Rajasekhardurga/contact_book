package com.contactbook;

	import java.io.File;
	import com.contactbook.DBConnection;

	import java.io.FileInputStream;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.util.Scanner;

	public class ContactManagerapp {

	    public static void addContact(String phoneNumber, String name, String email) {
	        try (Connection con = DBConnection.getConnection()) {
	            String query = "INSERT INTO contacts (phone_number, name, email) VALUES (?, ?, ?)";

	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, phoneNumber);
	            ps.setString(2, name);
	            ps.setString(3, email);

	            // Read the image file
	           // File image = new File(imagePath);
	           // FileInputStream fis = new FileInputStream(image);
	            //ps.setBinaryStream(4, fis, (int) image.length());

	            int rows = ps.executeUpdate();
	            if (rows > 0) {
	                System.out.println("Contact added successfully!");
	            }

	           //  fis.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter phone number: ");
	        String phoneNumber = sc.nextLine();

	        System.out.print("Enter your name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter your email address: ");
	        String email = sc.nextLine();

	       // System.out.print("Enter image path: ");
	        //String imagePath = sc.nextLine();

	        // Insert contact
	        addContact(phoneNumber, name, email);

	        sc.close();
	    }
	}