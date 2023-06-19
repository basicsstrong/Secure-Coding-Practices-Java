package com.basicsstrong.securecoding;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SerializationDemo {

	public static void main(String[] args) throws Exception {
    	String xmlFile = "/malicious-data.xml";
    	if(validXML(xmlFile)) {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(xmlFile)))) {
        	 Person person =   (Person) decoder.readObject();
        	 System.out.println(person.getName());
        	 System.out.println(person.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    	}
    }

	private static boolean validXML(String xmlFile) {
		try(BufferedReader reader = new BufferedReader(new FileReader(xmlFile))){
			StringBuilder xmlBuilder = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				xmlBuilder.append(line);
			}
			
			String string = xmlBuilder.toString();
			if(string.contains("java.lang.Runtime")) {
				System.out.println("This xml is not allowed here");
				return false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}
   
}



