<html>
<head>
<style>
span{
font-size:30px;
color:red;
margin-bottom:60px;
}
</style>
<script>
var xmlhttp;
var buttonClicked;
var message;
function sendData(button)
{
	//html page-->json string
	//to create json string we have to take help of javasccript
	//json given to server server created object from it means category object
	//and server send json string to client by creating and  converting it into json see in category controller class 
	//to take name and cid value from categoryform
	
	var cid=document.categoryform.cid.value;
	var name=document.categoryform.name.value;
	//created javascript object
	var javscriptobject={"cid":cid,"name":name};
	//
	xmlhttp=new XMLHttpRequest();
	//XMLHttpRequest() is predefined class of javascript
	 buttonClicked=button.value;
	if(buttonClicked=="post"){
		message="data posted successfully";
	xmlhttp.open("post","categoryapis/saveCategory"); //we never write localhost here beacuse Category controller are in same project
	}else{
		message="data updated successfully";
		xmlhttp.open("put","categoryapis/updateCategory");
	}
	
	xmlhttp.onload=displayResponse;// when response is loaded from api then call it we see like we see in response section of postmon on html page 
	var jsonstring=JSON.stringify(javscriptobject);//stringify fuction  it used to convert  javasript object into json
	xmlhttp.setRequestHeader('Content-type', 'application/json'); //same like we select row body json in postmon
	xmlhttp.send(jsonstring);// same like send button postmon
	alert("data is sent");
	}
	function displayResponse(){
		document.getElementById("message").innerHTML=message;
		alert(xmlhttp.responseText); // responseText is varible which display response data(JSON Strring) which we see generally in response section of postmon
	}
function getData(button)  {
	var cid=document.categoryform.cid.value;//reading cid value typed by user
	
	//created javascript object
	//var javscriptobject={"cid":cid,"name":name};
	//
	xmlhttp=new XMLHttpRequest(); //XMLHttpRequest() is predefined class of javascript
	buttonClicked=button.value;
	if(buttonClicked=="get"){
		message="data retrived successfully";
		xmlhttp.open("get","categoryapis/getCategory/"+cid); //we never write localhost here beacuse Category controller are in same project
	}
	else{
		message="data deleted successfully";
		xmlhttp.open("delete","categoryapis/deleteCategory/"+cid);
	}
	xmlhttp.onload=displayResponse2;// when response is loaded from api then call it we see like we see in response section of postmon on html page 
	
	
	xmlhttp.send();// same like send button postmon
}
function displayResponse2()
	{
		
		//obj is javscrpt objcect
	var jsonstring=xmlhttp.responseText;
	var obj=JSON.parse(jsonstring);
	//javascriptobject={message:record not found if not found}
	var name=obj.name;
	//when exception occur message varible value will be record not found and below condition will be satisfied
	if(obj.message!=undefined){
	
	document.categoryform.name.value="";
	document.getElementById("message").innerHTML=obj.message;

	}
	else{
		document.categoryform.name.value=name;
		document.getElementById("message").innerHTML=message;
		}
	}
	
 function getAllData(){
	 xmlhttp=new XMLHttpRequest();
	 xmlhttp.onload=displayResponse3;
	 xmlhttp.open("get","categoryapis/getAllCategory");
	 xmlhttp.send();
	 
 }
 function displayResponse3()
 {
	 alert(xmlhttp.responseText); // alljsonstring is array
	 var p1=document.getElementById("p1");
	 var data="";
	 var alljsonstring=xmlhttp.responseText;
	/* for(i=0;alljsonstring.length;i++){
		 var obj=JSON.parse(alljsonstring[i]);
		 data=data+obj+ "<br>";
	 }*/
	 p1.innerHTML=alljsonstring;
 }


</script>
<body>
<span id="message">Wating....</span>
<form name="categoryform">
<input type="text" placeholder="enter cid" name=cid><br><br>
<input type="text" placeholder="enter category name" name=name><br><br>
<input type=button value=post onclick="sendData(this)">
<input type=button value=get onclick="getData(this)">
<input type=button value=put onclick="sendData(this)">
<input type=button value=delete onclick="getData(this)">
<input type=button value=getall onclick="getAllData()">
</form>
<p id="p1">All data</p>
</body>
</head>
</html>