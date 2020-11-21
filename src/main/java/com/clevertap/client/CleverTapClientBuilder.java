package com.clevertap.client;

import com.clevertap.api.DataCenterRegion;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.core.Configuration;

@Getter(AccessLevel.PACKAGE)
public class CleverTapClientBuilder {

  private final DataCenterRegion region;
  private final String accountId;
  private final String passcode;
  private Configuration configuration;

  private CleverTapClientBuilder(DataCenterRegion region, String accountId, String passcode) {
    this.region = region;
    this.accountId = accountId;
    this.passcode = passcode;
  }

  public static CleverTapClientBuilder builder(
      DataCenterRegion region, String accountId, String passcode) {
    if (region == null) {
      throw new IllegalArgumentException("region cannot be null");
    }
    if (StringUtils.isBlank(accountId)) {
      throw new IllegalArgumentException("account id cannot be blank");
    }
    if (StringUtils.isBlank(passcode)) {
      throw new IllegalArgumentException("passcode cannot be blank");
    }
    return new CleverTapClientBuilder(region, accountId, passcode);
  }

  public CleverTapClientBuilder withHttpClientConfiguration(Configuration configuration) {
    if (configuration == null) {
      throw new IllegalArgumentException("http client configuration cannot be null");
    }
    this.configuration = configuration;
    return this;
  }

  public CleverTapClient build() {
    if (configuration == null) {
      configuration = new ClientConfig();
    }
    return new CleverTapClient(region, accountId, passcode, configuration);
  }
}
