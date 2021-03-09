package org.ehrbase.aqleditor.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "ehrbase")
public class EhrProperties {

  private String restApiUrl;

  private String username;

  private String password;
}