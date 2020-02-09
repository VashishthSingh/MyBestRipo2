package com.csbestprog.CSBestProg1;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("getResource1")
public class AlienResource1 { 
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String geData(String data){
		System.out.println(data);
		Ripository1.getDataFromClient(data);
		return(data);
	}
}

