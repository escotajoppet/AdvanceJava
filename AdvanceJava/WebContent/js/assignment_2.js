var dropDown = document.getElementById("dropdown");
var texts = document.getElementById("texts");

dropDown.onchange = function(){
	texts.innerHTML = "";	
	texts.setAttribute("class", "alert alert-info");
	
	var h5 = document.createElement("h5");	
	var hr = document.createElement("hr");
	var setValues = document.createElement("input");
	
	h5.innerHTML = "Enter values of Elements" + "<br>";
	
	setValues.type = "submit";
	setValues.className = "btn btn-primary";
	setValues.value="Set Values!";
	setValues.name = "setvalues";
	setValues.id = "setvalues";
	
	texts.appendChild(h5);
	
	for(var i = 0; i<dropDown[dropDown.selectedIndex].value; i++){		
		var textBoxes = document.createElement("input");
		
		textBoxes.type = "text";
		textBoxes.name = "elements";
		textBoxes.className = "element";
		textBoxes.placeholder = (i+1);
		
		texts.appendChild(textBoxes);
	}
	
	texts.appendChild(hr);
	texts.appendChild(setValues);
};