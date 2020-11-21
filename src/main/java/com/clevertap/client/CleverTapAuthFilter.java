package com.clevertap.client;

import lombok.AllArgsConstructor;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

@AllArgsConstructor
public class CleverTapAuthFilter implements ClientRequestFilter {

  private static final String ACCOUNT_ID_HEADER = "X-CleverTap-Account-Id";
  private static final String PASSCODE_HEADER = "X-CleverTap-Passcode";

  private final String accountId;
  private final String passcode;

  @Override
  public void filter(ClientRequestContext clientRequestContext) {
    clientRequestContext.getHeaders().add(ACCOUNT_ID_HEADER, accountId);
    clientRequestContext.getHeaders().add(PASSCODE_HEADER, passcode);
  }
}
