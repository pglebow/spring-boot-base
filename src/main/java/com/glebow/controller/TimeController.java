/**
 * 
 */
package com.glebow.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pglebow
 *
 */
@RestController
@RequestMapping(path = "/time")
public class TimeController {

    private DateFormat df = SimpleDateFormat.getDateTimeInstance();

    @GetMapping
    public String getTime() {
        Date d = new Date();
        
        return df.format(d);
    }

}
