package org.deconvolute.opensearch.plugins;

import org.opensearch.core.rest.RestStatus;
import org.opensearch.rest.BytesRestResponse;
import org.opensearch.rest.RestResponse;

public class HelloWorldService {

    public static RestResponse buildResponse(String name) {
        String space = name.isEmpty()? "" : " ";
        final String message = "Hi" + space + name + "! Your plugin is installed and working:)";
        return new BytesRestResponse(RestStatus.OK, message);
    }
}
