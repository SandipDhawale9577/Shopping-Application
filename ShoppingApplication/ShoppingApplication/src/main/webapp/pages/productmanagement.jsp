<html>
<head>
<style>
</style>
</head>
<script>

var xmlhttp;

function getAllData()
{
	
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onload=display; // value of onload property is name of that function which should be called when response is loaded from server

	xmlhttp.open("get","allProducts");
	xmlhttp.send();
							
}
function putAllData()
{
	var pid=document.productform.pid.value;
	var name=document.productform.name.value;
	var price=document.productform.price.value;
	var cid=document.productform.cid.value;
	var images=document.productform.images.value;
	var javscriptobject={"pid":pid,"name":name,"price":price,"cid":cid,"images":images};

	xmlhttp=new XMLHttpRequest();

	xmlhttp.open("put","updateproduct");
	xmlhttp.onload=display;
	var jsonstring=JSON.stringify(javscriptobject);
	xmlhttp.setRequestHeader('Content-type', 'application/json'); //same like we select row body json in postmon
	xmlhttp.send(jsonstring);// same like send button postmon
	alert("data is sent");
							
}
 
function deleteAllData()
{
	
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onload=display; // value of onload property is name of that function which should be called when response is loaded from server

	xmlhttp.open("delete","deleteproduct");
	xmlhttp.send();
							
}


function display()
{
		//alert("hello");

			
		var table=document.getElementById("table1");
		table.innerHTML=""; // clear existing rows from table

		var headingrow=document.createElement("tr");

		var pidheading=document.createElement("th");
		var nameheading=document.createElement("th");
		var priceheading=document.createElement("th");
		var imgheading=document.createElement("th");
		
		var pidvalue=document.createTextNode("product id");
		var namevalue=document.createTextNode("product name");
		var pricevalue=document.createTextNode("product price");
		var imgvalue=document.createTextNode("product image");
		
		pidheading.appendChild(pidvalue);
		nameheading.appendChild(namevalue);
		priceheading.appendChild(pricevalue);
		imgheading.appendChild(imgvalue);


		headingrow.appendChild(pidheading)
		headingrow.appendChild(nameheading)
		headingrow.appendChild(priceheading)
		headingrow.appendChild(imgheading)
		
		
		table.appendChild(headingrow);


		var data=xmlhttp.responseText;

		alert(data);
		
		
		// data ==> [ {"rno":1,"marks":70} , {"rno":2,"marks":80} ]
				
		data=data.substring(1,data.length-1);
		
		//alert(data);

		
		/*
		String s="java";  //  [java] 
		s=s.concat("KiranAcademy");// s==>[java KiranAcademy]
		sop(s);
		*/

		// data ==> {"rno":1,"marks":70} , {"rno":2,"marks":80} , {"rno":3,"marks":70}
		
		var newstr="";  // {""rno":1,"marks":70}

		// creating new string where we will add character #, so that we can split strings
		// based on # .
									
		for(var i=0;i<data.length;i++)
		{
		//	alert(data[i]);
			var character=data[i];
			if(character==',' && data[i+1]=='{')
			{
				newstr=newstr+"#";
			}
			else
			{
				newstr=newstr+character;
			}
			
		}

	//	alert(newstr);

		<!--  newstr ==> {"rno":1,"marks":70} # {"rno":2,"marks":80} # {"rno":3,"marks":70}-->
		
		var jsonstrings=newstr.split("#");



		
		for(var i=0;i<jsonstrings.length;i++)
		{

				var jsonrecord=jsonstrings[i];
				var object=JSON.parse(jsonrecord);
			var row=document.createElement("tr");
var pidtd=document.createElement("td");
				var nametd=document.createElement("td");
				var pricetd=document.createElement("td");
				var imagetd=document.createElement("td");
				
				var pidvalue=document.createTextNode(object.pid);
				var namevalue=document.createTextNode(object.name);
				var pricevalue=document.createTextNode(object.price);
				var productimage=document.createElement("img");
				productimage.src="/images/"+object.imagepath;
				
				productimage.width="40";
				productimage.height="40";
				
				//alert(productimage.src);
				
				pidtd.appendChild(pidvalue);
				nametd.appendChild(namevalue);
				pricetd.appendChild(pricevalue);
				imagetd.appendChild(productimage);
				
				row.appendChild(pidtd);
				row.appendChild(nametd);
				row.appendChild(pricetd);
				row.appendChild(imagetd);
				
				table.appendChild(row);
				
		}
		
}
</script>


<body>
<span id="message">${message}</span>

<form name ="productform" enctype="multipart/form-data">
			
			<input type="text" name="pid" placeholder="Enter product id"><span id="errorMessage"> </span><br><br>
			
			<input type="text" name="name" placeholder="Enter product name"><br><br>
			
			<input type="text" name="price" placeholder="Enter product price"><br><br>
			
			<input type="text" name="cid" placeholder="Enter category id"><br><br>
			
			<label>Select Photo	</label>
			<input type="file" name="images"><br><br>
						
			<input type="button" value="getall" onclick="getAllData()">
						
												<input type="button" value="delete" onclick="deleteAllData()">
						
			
			<input type=submit value=post formmethod=post formaction="saveproduct">
						<input type=submit value=put formmethod="put" formaction="updateproducts">
			

			<br><br><br>
						
			<table id="table1">
				
			</table>
			
</form>

<p id="p1"> Test </p>

</body>

</html>