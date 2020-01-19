function getData(data, aula) {
	if (data == null) 
		return;
    input = document.getElementById("data");
    input.value = data;
    console.log(data)
    console.log(aula)
    tabella = document.getElementById("orario");
    tabella.innerHTML = '';
    var xhttp = new XMLHttpRequest();
	xhttp.responseType = 'json';
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			for (var i in this.response){
				
			}
			
		}
	}
	xhttp.open("GET", "CalGetter?data="+data, true);
    xhttp.send();
  }