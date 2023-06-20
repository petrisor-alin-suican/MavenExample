package curs12;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonProcessor {

	@SuppressWarnings("unchecked")
	public void writeJson() {
	  JSONObject obj = new JSONObject();
	  obj.put("name", "Test");
	  obj.put("email", "email@test.com");
	  
	  
	  JSONArray list = new JSONArray();
	  list.add("Oject 1");
	  list.add("Oject 2");
	  list.add("Oject 3");
	  list.add("Oject 4");
	  
	  obj.put("listaObiecte", list);
	  
	  try(FileWriter file = new FileWriter("test.json")){
		  
		  file.write(obj.toJSONString());
		  
	  }catch(IOException e) {
		  
	  }
	}


	public void readJson(String key) throws ParseException {
		
		JSONParser parser = new JSONParser();
		
		try {
			FileReader file = new FileReader(("test.json"));
			JSONObject jsonObj = (JSONObject) parser.parse(file);
			
			System.out.println(jsonObj.get(key));
			
		}catch(IOException e) {
			
		}
	}

	
	public void updateJsonFile(String key, String value) {
		
         JSONParser parser = new JSONParser();
		
		try {
			FileReader file = new FileReader(("test.json"));
			JSONObject jsonObj = (JSONObject) parser.parse(file);
			
			JSONArray list =(JSONArray) jsonObj.get("listaObiecte");
			list.set(0, "Oject 0");
			
			jsonObj.put(key, value);
			
		
			
			try {
				FileWriter fileWriter = new FileWriter("test.json");
				fileWriter.write(jsonObj.toJSONString());
				fileWriter.close();
				
			}catch(Exception e) {}
			
		
		}	catch(Exception e){
			
		
		}
}
	
	
	public void deleteFromJsonFile(String key) {
		
		try(FileReader reader = new FileReader("test.json")){
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			jsonObject.remove(key);
			
			try(FileWriter file = new FileWriter("test.json")){
				file.write(jsonObject.toJSONString());
				
			}catch(Exception e) {
				
			}
			
			
		}catch(Exception e) {
			
		}
		
	}
}
	
	
	
	

