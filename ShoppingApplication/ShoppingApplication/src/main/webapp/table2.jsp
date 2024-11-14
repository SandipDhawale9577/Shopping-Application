<html>
	<head>
	
	<style>
			table,td,th
			{
				border:1px solid red;
			}
			
	</style>
	
			<script>
					function display()
					{
						var table=document.getElementById("table1");

						var headingrow=document.createElement("tr");

						var rollnoth=document.createElement("th");
						var nameth=document.createElement("th");

						var rollnovalue=document.createTextNode("rollno");
						var namevalue=document.createTextNode("name");


						rollnoth.appendChild(rollnovalue);
						nameth.appendChild(namevalue);

						headingrow.appendChild(rollnoth)
						headingrow.appendChild(nameth)

						table.appendChild(headingrow)


						var datarow=document.createElement("tr");

						var rollnotd=document.createElement("td");
						var nametd=document.createElement("td");

						var rollnovalue=document.createTextNode("1");
						var namevalue=document.createTextNode("sachin");


						rollnotd.appendChild(rollnovalue);
						nametd.appendChild(namevalue);

						datarow.appendChild(rollnotd)
						datarow.appendChild(nametd)

						table.appendChild(datarow)
						
				     }
		</script>
			
	</head>

	<body>
			<input type="button" value="all" onclick="display()">
			
			<table id="table1">
				
			</table>
			
	</body>

			
</html>