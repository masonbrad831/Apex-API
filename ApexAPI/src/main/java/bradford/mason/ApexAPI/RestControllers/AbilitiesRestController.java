package bradford.mason.ApexAPI.RestControllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bradford.mason.ApexAPI.DatabaseConnection;

@RestController
@RequestMapping("/abilities")
public class AbilitiesRestController {

	DatabaseConnection databaseConnection = new DatabaseConnection();
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public void createLegends(@RequestBody Map<String, String> abilities) {
		databaseConnection.CreateAbilities(Integer.parseInt(abilities.get("legendid")), abilities.get("abilityname"), abilities.get("description"));
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public String findLegends() {
		return databaseConnection.findByTable("abilities");

	}
	
	@RequestMapping(path = "/id", method = RequestMethod.GET)
	public String findAbilitiesById(@RequestBody int id) {
		return databaseConnection.findByID(id, "abilities");
	}
	
	
    @RequestMapping(path = "", method = RequestMethod.DELETE)
    public String Delete(@RequestBody int id) {
        databaseConnection.deleteById(id, "abilitites");
        return "Successfully Deleted";
        
    }
}
