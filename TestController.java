package com.ceva.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceva.bank.common.beans.Record;

@RestController
public class TestController {
	private Logger log = Logger.getLogger(TestController.class);
	
	@RequestMapping(value = "/list/save.action", method = RequestMethod.POST, produces = {
			"application/json ; charset=utf-8",
			"application/xml ; charset=utf-8" })
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody List<Record> bean) {
		log.info("chat send.."+bean.toString());
		log.info(bean.toString());
		try{
				log.info("Fetching Ads.. passed Validation");
				for(Record record:bean){
					log.info(record.toString());
				}
				return new ResponseEntity<>(bean, HttpStatus.OK);
		}catch(Exception e){
			log.error("Error..:"+e.getLocalizedMessage());
			e.printStackTrace();
			return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		}finally{

		}
	}

}
