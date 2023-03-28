package com.tech.langParser;


import org.mvel2.MVEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class MVELParser {
	Logger log = LoggerFactory.getLogger(MVELParser.class);
    public boolean parseMvelExpression( String expression, Map<String, Object> inputObjects){
    
    	
        try {
            return MVEL.evalToBoolean(expression,inputObjects);
        }catch (Exception e){
        	

            log.error("Can not parse Mvel Expression : {} Error: {}", expression, e.getMessage());
        }
        return false;
    }
}
