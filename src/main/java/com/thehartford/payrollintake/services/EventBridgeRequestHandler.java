package com.thehartford.payrollintake.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification.S3EventNotificationRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EventBridgeRequestHandler implements RequestHandler<S3Event, String> {
	private static final Logger logger = LoggerFactory.getLogger(EventBridgeRequestHandler.class);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public EventBridgeRequestHandler() {
    	
    }

	@Override
	public String handleRequest(S3Event input, Context context) {
		String response = new String("200 OK");
		S3EventNotificationRecord record = input.getRecords().get(0);
		String srcBucket = record.getS3().getBucket().getName();
		String srcKey = record.getS3().getObject().getUrlDecodedKey();
        logger.info("RECORD: " + record);
        logger.info("SOURCE BUCKET: " + srcBucket);
        logger.info("SOURCE KEY: " + srcKey);
		
		return response;
	}

}
