package rebuild;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class MapsReader {
    String[][] Map;
    JSONParser parser;
    
    MapsReader(int diff) throws FileNotFoundException, IOException, ParseException {
	parser = new JSONParser();
	
	Object obj = parser.parse(new FileReader("src/test/resources/maps/maps.json"));
	JSONObject jsonObject = (JSONObject)obj;
	JSONArray map;
	
	if(diff == 1) {
	    map = (JSONArray)jsonObject.get("easy");
	} else if(diff == 2) {
	    map = (JSONArray)jsonObject.get("medium");
	} else if(diff == 3) {
	    map = (JSONArray)jsonObject.get("hard");
	}
	
	Iterator cols = map.iterator();
	
	ArrayList<String[]> columns = new ArrayList<String[]>();
	
	
	
	
	try {
	       

	       

	       System.out.println("Subjects:");
	       Iterator iterator = subjects.iterator();
	       while (iterator.hasNext()) {
	          System.out.println(iterator.next());
	       }
	    } catch(Exception e) {
	       e.printStackTrace();
	    }
	
    }

    
    
}
