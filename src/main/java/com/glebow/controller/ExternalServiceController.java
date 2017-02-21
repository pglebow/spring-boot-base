/**
 * 
 */
package com.glebow.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.newrelic.api.agent.NewRelic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pglebow
 *
 */
@RestController
@RequestMapping(path = "/external")
@Slf4j
public class ExternalServiceController {

    @Value("${external.url}")
    private String url;
    
    @GetMapping
    public String getDateFromExternal() throws RestClientException, URISyntaxException {
        String retVal = url;
      
        log.info("Calling: " + url);
        
        NewRelic.addCustomParameter("userName", "externalUser");
        NewRelic.incrementCounter("getDateFromExternalCount");
        
        RestTemplate t = new RestTemplate();
        try {
            retVal = t.getForObject(new URI(url), String.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        
        return retVal;
    }

}
