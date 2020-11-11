package bradford.mason.ApexAPI.RestControllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bradford.mason.ApexAPI.DatabaseConnection;


@RestController
@RequestMapping("/legends")
public class LegendRestController {

	DatabaseConnection databaseConnection = new DatabaseConnection();
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public void createLegends(@RequestBody Map<String, String> legends) {
		databaseConnection.CreateLegends(legends.get("legendname"),legends.get("passive"), legends.get("tactical"), legends.get("tactical"), legends.get("description"));
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public String findLegends() {
		return databaseConnection.findByTable("legends");
	}
	
	@RequestMapping(path = "/id", method = RequestMethod.GET)
	public String findLegendsById(@RequestBody int id) {
		return databaseConnection.findByID(id, "legends");
	}
	
	
	
    @RequestMapping(path = "", method = RequestMethod.DELETE)
    public String Delete(@RequestBody int id) {
        databaseConnection.deleteById(id, "legends");
        return "Successfully Deleted";
    }
}
