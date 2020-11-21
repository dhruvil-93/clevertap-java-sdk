package com.clevertap.client;

import com.clevertap.api.DataCenterRegion;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class CleverTapClientBuilder {

  private final DataCenterRegion region;
  private final String accountId;
  private final String passcode;
  private HttpClient client;

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
      throw new IllegalArgumentException("accountId cannot be blank");
    }
    if (StringUtils.isBlank(passcode)) {
      throw new IllegalArgumentException("passcode cannot be null");
    }
    return new CleverTapClientBuilder(region, accountId, passcode);
  }

  public CleverTapClientBuilder withHttpClient(HttpClient client) {
    if (client == null) {
      throw new IllegalArgumentException("http client cannot be null");
    }
    this.client = client;
    return this;
  }

  public CleverTapClient build() {
    if (client == null) {
      client = HttpClientBuilder.create().build();
    }
    return new CleverTapClient(region, accountId, passcode, client);
  }
}
