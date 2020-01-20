function getData(data, aula) {
	if (data == null)
		return;
	tabella = document.getElementById("orario");
	tabella.innerHTML = '';
	formatData = data.split("/")
	riga = document.createElement('tr');
	tabella.appendChild(riga);
	for (var k = 8; k < 19; k++) {
		col = document.createElement('td');
		col.setAttribute("id", k);
		riga.appendChild(col);
	}
	var xhttp = new XMLHttpRequest();
	xhttp.responseType = 'json';
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			for (var i = 0; i < this.response.length; i++) {

				materia = this.response[i]
				oraI = this.response[i + 1]
				oraF = this.response[i + 2]
				desc = this.response[i + 3]
				colspan = oraF - oraI + 1;
				
				for (var k = oraI; k < oraF + 1; k++) {
					col = document.getElementById(k)
					col.style.background = "#fa6661"
					if (k == oraI) {
						col.style.textAlign = "center";
						col.setAttribute("colspan", colspan)
						col.innerHTML = materia + "<br><br>" + desc;
					}
					else{
						col.remove()
					}
					
				}
				i += 3;
			}
		}
	}
	xhttp.open("GET", "CalGetter?data=" + formatData[2] + "-" + formatData[0]
			+ "-" + formatData[1] + "&aula=" + aula, true);
	xhttp.send();
}