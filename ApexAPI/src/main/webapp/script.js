function getTable() {
	var tableCheck = document.getElementById('tableName');
	var values = tableCheck.options[tableCheck.selectedIndex].value;
	console.log(values);
	// var xmlHttp = new XMLHttpRequest();
	// xmlHttp.onreadystatechange = function() {
	// 	if(this.readyState == XMLHttpRequest.DONE && this.status == 200) {
	// 		var maps = this.responseText;
	// 		renderTable(maps);
	// 	}
	// }
	// xmlHttp.open("GET", "http://localhost:8080/maps" , true);
	// xmlHttp.send();
}









function login() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var header_value = "Basic " + btoa(username + ":" + password);
	console.log(header_value);


	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("", "http://localhost:8080");
	xmlHttp.setRequestHeader('Authorization', header_value);
	xmlHttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
		}
	}
	xmlHttp.send(header_value);
	
}



function update() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var header_value = "Basic " + btoa(username + ":" + password);

	var tableName = document.getElementById("updateTableName").value;
	var columnName = document.getElementById("columnName").value;
	var value = document.getElementById("value").value;
	var id = document.getElementById("updateID").value;
	var updateMethod = {
		"tableName" : tableName,
		"collumnName" : columnName,
		"value" : value,
		"id" : id
	}
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("PUT", "http://localhost:8080/update");
	xmlHttp.setRequestHeader('Authorization', header_value);
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
		}
	}
	xmlHttp.send(JSON.stringify(updateMethod));
}

//////////////////////////////MAPS///////////////////////////////////

function createMap() {	
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var header_value = "Basic " + btoa(username + ":" + password);

	var map_name = document.getElementById('mapName').value;

	var map = {
		"mapname" : map_name
	}


	
	var xmlHttp = new XMLHttpRequest();
	
	xmlHttp.open("POST", "http://localhost:8080/maps");
	xmlHttp.setRequestHeader('Authorization', header_value);

	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
		}
	}
	xmlHttp.send(JSON.stringify(map));
}

function getMaps() {
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function() {
		if(this.readyState == XMLHttpRequest.DONE && this.status == 200) {
			var maps = this.responseText;
			renderTable(maps);
		}
	}
	xmlHttp.open("GET", "http://localhost:8080/maps" , true);
	xmlHttp.send();
}

function renderTable(tableName) {
	var tableList = document.getElementById('tableList');
	tableList.innerHTML = "";
	var html = "<li>" + tableName + "</li>";
	tableList.innerHTML = tableList.innerHTML + html;
}

function deleteMaps() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var header_value = "Basic " + btoa(username + ":" + password);
	var id = document.getElementById('theID').value;

	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("DELETE", "http://localhost:8080/maps");
	xmlHttp.setRequestHeader('Authorization', header_value);

	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
		}
	}
	xmlHttp.send(id);
}





//////////////////////////////LEGENDS///////////////////////////////////

function createLegend() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var header_value = "Basic " + btoa(username + ":" + password);
	var legendname = document.getElementById('legendName').value;
	var passive = document.getElementById('passive').value;
	var tactical = document.getElementById('tactical').value;
	var ultimate = document.getElementById('ultimate').value;
	var description = document.getElementById('legendDescription').value;
	var legend = {
		"legendname": legendname,
		"passive": passive,
		"tactical": tactical,
		"ultimate": ultimate,
		"description": description
	}

	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/legends");
	xmlHttp.setRequestHeader('Authorization', header_value);

	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
		}
	}
	xmlHttp.send(JSON.stringify(legend));
}

function getLegends() {


	var xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function() {
		if(this.readyState == XMLHttpRequest.DONE && this.status == 200) {
			var legends = this.responseText;
			renderTable(legends);
			//console.log(maps)
		}
	}
	xmlHttp.open("GET", "http://localhost:8080/legends" , true);
	xmlHttp.send();
}

function deleteLegends() {
	var id = document.getElementById('theID').value;

	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("DELETE", "http://localhost:8080/legends");
	xmlHttp.setRequestHeader('Authorization', header_value);

	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
		}
	}
	xmlHttp.send(id);
}



//////////////////////////////ABILITIES/////////////////////////////////

function createAbility() {
	var legendID = document.getElementById('legendID').value;
	var abilityName = document.getElementById('abilityName').value;
	var abilityDescription = document.getElementById('abilityDescription').value;
	var ability = {
		"legendid": legendID,
		"abilityname": abilityName,
		"description": abilityDescription
	}


	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/abilities");
	xmlHttp.setRequestHeader('Authorization', header_value);

	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
			//getMaps();
		}
	}
	xmlHttp.send(JSON.stringify(ability));
}

function getAbilities() {


	var xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function() {
		if(this.readyState == XMLHttpRequest.DONE && this.status == 200) {
			var abilities = this.responseText;
			renderTable(abilities);
		}
	}
	xmlHttp.open("GET", "http://localhost:8080/abilities" , true);
	xmlHttp.send();
}

function deleteAbilities() {
	var id = document.getElementById('theID').value;

	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("DELETE", "http://localhost:8080/abilities");
	xmlHttp.setRequestHeader('Authorization', header_value);

	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
		}
	}
	xmlHttp.send(id);
}


//////////////////////////////WEAPONS///////////////////////////////////

function createWeapons() {
	var weaponName = document.getElementById('weaponName').value;
	var weaponClass = document.getElementById('weaponClass').value
	var ammoType = document.getElementById('ammoType').value;
	var bodyDamage = document.getElementById('bodyDamage').value;
	var headDamage = document.getElementById('headDamage').value;
	var legDamage = document.getElementById('legDamage').value;
	var magSize = document.getElementById('magSize').value;
	var bodyDPS = document.getElementById('bodyDPS').value;
	var RPM = document.getElementById('RPM').value;
	var firemodes = document.getElementById('firemodes').value;
	var weapon = {
		"weaponname": weaponName,
		"weaponclass": weaponClass,
		"ammotype": ammoType,
		"bodydamage": bodyDamage,
		"headdamage": headDamage,
		"legdamage": legDamage,
		"magsize": magSize,
		"bodydps": bodyDPS,
		"rpm": RPM,
		"firemodes": firemodes,
	}

	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/weapons");
	xmlHttp.setRequestHeader('Authorization', header_value);

	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
			
		}
	}
	xmlHttp.send(JSON.stringify(weapon));
}

function getWeapons() {


	var xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function() {
		if(this.readyState == XMLHttpRequest.DONE && this.status == 200) {
			var weapons = this.responseText;
			renderTable(weapons);
		}
	}
	xmlHttp.open("GET", "http://localhost:8080/weapons" , true);
	xmlHttp.send();
}

function deleteWeapons() {
	var id = document.getElementById('theID').value;
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("DELETE", "http://localhost:8080/weapons");
	xmlHttp.setRequestHeader('Authorization', header_value);

	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
		}
	}
	xmlHttp.send(id);
}


//////////////////////////////////////////////////////
/////////////////////////////////////////////////////
//////////////////////////////////////////////////////
///////////////////////////////////////////////////////


function clearResults() {
	var tableList = document.getElementById('tableList');
	tableList.innerHTML = "";

}


//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////
//////////////////////////////////////////////////////


var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight) {
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    }
  });
}

