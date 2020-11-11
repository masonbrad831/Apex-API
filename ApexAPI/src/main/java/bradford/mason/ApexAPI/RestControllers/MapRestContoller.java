package bradford.mason.ApexAPI.RestControllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import bradford.mason.ApexAPI.DatabaseConnection;


@RestController
@RequestMapping("/maps")
public class MapRestContoller {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		
		@RequestMapping(path = "", method = RequestMethod.POST)
		public void createMap(@RequestBody Map<String, String> maps) {
			databaseConnection.CreateMap(maps.get("mapname"));
		}
		
		@RequestMapping(path = "", method = RequestMethod.GET)
		public String findMaps() {
			String[] line = databaseConnection.findByTable("maps").split("\\r?\\n");
			for (String element : line) {
				return element;

			}
			return "";
			
		}
		
		@RequestMapping(path = "id", method = RequestMethod.GET)
		public String findMapsById(@RequestBody int id) {
			return databaseConnection.findByID(id, "maps");
		}
		
	    @RequestMapping(path = "", method = RequestMethod.DELETE)
	    public String Delete(@RequestBody int id) {
	        databaseConnection.deleteById(id, "maps");
	        return "Successfully Deleted";
	        }
	    

	    
}