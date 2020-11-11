package bradford.mason.ApexAPI.RestControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class SecurityRestController {
	
	@RequestMapping(path = "/admin", method = RequestMethod.GET)
	public String adminLogin() {
		return "Admin Login";
	}

	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public String userLogin() {
		return "User Login";
	}

}
