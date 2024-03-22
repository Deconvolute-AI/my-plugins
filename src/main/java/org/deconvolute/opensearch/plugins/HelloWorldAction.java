package org.deconvolute.opensearch.plugins;

import org.opensearch.client.node.NodeClient;
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.rest.BytesRestResponse;
import org.opensearch.rest.RestRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.opensearch.rest.RestRequest.Method.GET;
import static org.opensearch.rest.RestRequest.Method.POST;

public class HelloWorldAction extends BaseRestHandler {
    @Override
    public String getName() {
        return "rest_handler_hello_world";
    }

    @Override
    public List<Route> routes() {
        return Collections.unmodifiableList(
                Arrays.asList(
                        new Route(GET, "/_plugins/hello_world"),
                        new Route(POST, "/_plugins/hello_world")
                )
        );
    }

    @Override
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client)
            throws IOException {
        String name = request.hasContent() ? request.contentParser().mapStrings().get("name") : "";

        return channel -> {
            try {
                channel.sendResponse(HelloWorldService.buildResponse(name));
            } catch (final Exception e) {
                channel.sendResponse(new BytesRestResponse(channel, e));
            }
        };
    }
}
