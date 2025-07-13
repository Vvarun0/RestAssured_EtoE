package org.filters;

import io.restassured.filter.Filter;

import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {

        logRequest(requestSpec);
        Response response = ctx.next(requestSpec,responseSpec); //request is going to be executed further from here as we have intercepted
        logResponse(response);
        return response;// test for assertions
    }

    public void logRequest(FilterableRequestSpecification requestSpec)
    {
        logger.info("BASE URL :"+requestSpec.getBaseUri());
        logger.info("REQUEST HEADER :"+requestSpec.getHeaders());
        logger.info("REQUEST PAYLOAD :"+requestSpec.getBody());

    }

    public void logResponse(Response response)
    {
        logger.info("StatusCode :"+response.getStatusCode());
        logger.info("Body:"+response.getBody().prettyPrint());
        logger.info("Response Header :"+response.headers());


    }
}
