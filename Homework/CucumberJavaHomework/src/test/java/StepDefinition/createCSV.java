package StepDefinition;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.opencsv.CSVWriter;

import io.cucumber.java.en.*;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;


public class createCSV {

@Given("^new CSV file is opened$")
public void new_csv_file_is_opened() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	List<String[]> csvFile = randomData();
	
	try (CSVWriter writer =new CSVWriter(new FileWriter("testData//sample1.csv"))) {
		writer.writeAll(csvFile);
	}
	//try (CSVWriter writer =new CSVWriter(new FileWriter("testData//sample1.csv"))) {
	//throw new io.cucumber.java.PendingException();
	
	}
@When("^data entry is started$")
public static List<String[]> randomData() throws IOException {
	// TODO Auto-generated method stub
	String[] header= {"id", "firstName", "lastName", "email", "companyId"};
	String[] row1= {id(), firstName(), lastName(), eMail().concat("@emailIntrum.lv"), companyId()};
	String[] row2= {id(), firstName(), lastName(), eMail().concat("@emailIntrum.lv"), companyId()};
	String[] row3= {id(), firstName(), lastName(), eMail().concat("@emailIntrum.lv"), companyId()};
	String[] row4= {id(), firstName(), lastName(), eMail().concat("@emailIntrum.lv"), companyId()};
	String[] row5= {id(), firstName(), lastName(), eMail().concat("@emailIntrum.lv"), companyId()};
	
	List<String[]> list = new ArrayList<>();
	
	list.add(header);
	list.add(row1);
	list.add(row2);
	list.add(row3);
	list.add(row4);
	list.add(row5);
			
	return list;
}

@And("I add id")
public static String id() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	String uuidId=String.format("%10d", new BigInteger(UUID.randomUUID().toString().replace("-", " "),16));
	String halfNumber= uuidId.substring(0, 5);
	return halfNumber;
}

@And("I add firstName")
public static String firstName() {
	// TODO Auto-generated method stub
	String uuidFirstName=UUID.randomUUID().toString();
	String halfdata=uuidFirstName.substring(0,10);
	return halfdata;
}

@And("I add lastName")
public static String lastName() {
	// TODO Auto-generated method stub
	String uuidLastName=UUID.randomUUID().toString();
	String halfdata=uuidLastName.substring(0,10);
	return halfdata;
}

@And("I add eMail")
public static String eMail() {
	// TODO Auto-generated method stub
	String uuidEmail=UUID.randomUUID().toString();
	String halfdata=uuidEmail.substring(0,20);
	return halfdata;
}

@And("I add companyId")
public static String companyId() {
	// TODO Auto-generated method stub
	String uuidCompanyId=String.format("%10d", new BigInteger(UUID.randomUUID().toString().replace("-", ""),16));
	String halfNumber= uuidCompanyId.substring(0, 5);
	return halfNumber;
}

@Then("CSV file is generated")
public void csv_file_is_generated() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("CSV File is generated");
    //throw new io.cucumber.java.PendingException();
}
}