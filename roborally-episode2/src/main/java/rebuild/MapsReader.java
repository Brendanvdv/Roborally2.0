package rebuild;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class MapsReader {
    String[][] map;
    JSONParser parser;
    

    JSONArray mapJ = null;
    
    MapsReader(int diff) throws FileNotFoundException, IOException, ParseException {
	parser = new JSONParser();
	
	Object obj = parser.parse(new FileReader("src/test/resources/maps/maps.json"));
	JSONObject jsonObject = (JSONObject)obj;
	
	
	if(diff == 1) {
	    mapJ = (JSONArray)jsonObject.get("easy");
	} else if(diff == 2) {
	    mapJ = (JSONArray)jsonObject.get("medium");
	} else if(diff == 3) {
	    mapJ = (JSONArray)jsonObject.get("hard");
	}
	
	map = new String[mapJ.size()][mapJ.size()];
	
	for(int i = 0; i < mapJ.size(); i++) {
	    JSONArray column = (JSONArray) mapJ.get(i);
	    
	    for(int j = 0; j < mapJ.size(); j++) {
		map[i][j] = (String) column.get(j);
	    }
	}
    }

    public JSONArray getMapJ() {
        return mapJ;
    }

    public void setMapJ(JSONArray mapJ) {
        this.mapJ = mapJ;
    }
    public String[][] getMap() {
        return map;
    }

    public void setMap(String[][] map) {
        this.map = map;
    }
    
    
}
