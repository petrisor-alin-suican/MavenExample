package curs12;

import org.json.simple.parser.ParseException;

public class TestJsonProcessor {

	public static void main(String[] args) throws ParseException {

		JsonProcessor obj = new JsonProcessor();
		
		obj.writeJson();
		obj.readJson("listaObiecte");
		
		
		obj.deleteFromJsonFile("email");
		
	}

}
