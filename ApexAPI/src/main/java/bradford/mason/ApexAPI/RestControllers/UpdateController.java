package bradford.mason.ApexAPI.RestControllers;


import java.util.Map;

import org.springframework.web.bind.annotation.*;

import bradford.mason.ApexAPI.DatabaseConnection;

@RestController
@RequestMapping("/update")
public class UpdateController {
	
    DatabaseConnection databaseConnection = new DatabaseConnection();
    
	@RequestMapping(path = "", method = RequestMethod.PUT)
    public String Update(@RequestBody Map<String, String> update) {
    	databaseConnection.update(update.get("tableName"), update.get("collumnName"), update.get("value"), Integer.parseInt(update.get("id")));
    	return "Successfully Updated";
    }





	

}
