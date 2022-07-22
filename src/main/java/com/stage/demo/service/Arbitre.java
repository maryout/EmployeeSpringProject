package com.stage.demo.service;

public class Arbitre {

	public static boolean show(String carte) {
		
	    if (carte.equals("Jaune") ) {
	    	return true ;
	    }
	    else if (carte.equals("Rouge")) {
	    	return true ;
	    }
	    else {
	    	return false ;
	    }
	}

}
