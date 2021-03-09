package org.ehrbase.aqleditor.configuration;

import java.net.URI;
import java.net.URISyntaxException;
import lombok.RequiredArgsConstructor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.ehrbase.aqleditor.properties.EhrProperties;
import org.ehrbase.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.client.openehrclient.defaultrestclient.DefaultRestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EhrConfig {

  private final EhrProperties ehrProperties;

  @Bean
  public DefaultRestClient createEhrRestClient() throws URISyntaxException {
    CredentialsProvider provider = new BasicCredentialsProvider();
    provider.setCredentials(
        AuthScope.ANY,
        new UsernamePasswordCredentials(
            ehrProperties.getUsername(), ehrProperties.getPassword()));

    CloseableHttpClient httpClient =
        HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

    return new DefaultRestClient(
        new OpenEhrClientConfig(new URI(ehrProperties.getRestApiUrl())), null, httpClient);
  }
}
