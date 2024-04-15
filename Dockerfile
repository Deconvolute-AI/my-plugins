FROM opensearchproject/opensearch:2.12.0
ADD ./v1.0.0-beta.zip /usr/
RUN /usr/share/opensearch/bin/opensearch-plugin install file:///usr/v1.0.0-beta.zip