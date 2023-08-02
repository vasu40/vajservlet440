  function validate(frm){
	  
	//Empty the error message
	document.getElementById("pnameErr").innerHTML="";
	document.getElementById("pageErr").innerHTML="";
	
	//read from data
	let name=frm.pname.value;
	let age=frm.page.value;
	
	//write client side validations
	let vflage=true;
	if(name==""){
		
		vflage=false;
		document.getElementById("pnameErr").innerHTML="<b>person name is required</b>";
		}
     else if(name.length<5 ||name.length>10){
		
		 vflage=false;
		document.getElementById("pnameErr").innerHTML="<b>person name is must contain 5 to 10 cahs</b>";
	     } 
	  if(age==""){
	
		  vflage=false;	  
		document.getElementById("pageErr").innerHTML="<b>person age is required</b>";
	    }
	    else if(isNaN(age)){
			vflage=false;
			document.getElementById("pageErr").innerHTML="<b>person age must be numeric</b>";
		}
		else if(age<0 ||age>125){
			//alert("age must be o to 125");
			vflage=false;
			document.getElementById("pageErr").innerHTML="<b>person age through  0 to 125</b>";
		}
		return vflage;
	}