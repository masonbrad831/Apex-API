package bradford.mason.ApexAPI.RestControllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bradford.mason.ApexAPI.DatabaseConnection;


@RestController
@RequestMapping("/weapons")
public class WeaponRestController {

	DatabaseConnection databaseConnection = new DatabaseConnection();
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public void createLegends(@RequestBody Map<String, String> weapons) {
		databaseConnection.CreateWeapons(weapons.get("weaponname"), weapons.get("weaponclass"), weapons.get("ammotype"), Integer.parseInt(weapons.get("bodydamage")), Integer.parseInt(weapons.get("headdamage")), Integer.parseInt(weapons.get("legdamage")),
				Integer.parseInt(weapons.get("magsize")),Integer.parseInt(weapons.get("bodydps")),Integer.parseInt(weapons.get("rpm")), weapons.get("firemodes"));
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public String findLegends() {
		return databaseConnection.findByTable("weapons");
	}
	
	@RequestMapping(path = "/id", method = RequestMethod.GET)
	public String findWeaponsById(@RequestBody int id) {
		return databaseConnection.findByID(id, "weapons");
	}
	
	
    @RequestMapping(path = "", method = RequestMethod.DELETE)
    public String Delete(@RequestBody int id) {
        databaseConnection.deleteById(id, "weapons");
        return "Successfully Deleted";
    }        
}