package ru.max314.testhttp;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Created by max on 06.08.2015.
 */
public class Part03 extends ServerResource {
    @Get("txt")
    public String toString() {
        return "hello, world";
    }
}
