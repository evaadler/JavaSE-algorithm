package ningM.com.adobe.app;

import ningM.com.adobe.service.Deduplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;


/**
 * Main Method of App
 * 
 * @author ningm
 *
 */
public class App {

	public static void main(String[] args) {
		Deduplication deDups = new Deduplication();
		//deDups.deDuplicate("/Users/fifi/Downloads/document/leads.json");

		deDups.deDuplicate2("leads.json");
	}
}
