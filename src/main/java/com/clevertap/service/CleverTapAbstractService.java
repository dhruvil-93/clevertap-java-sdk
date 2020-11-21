package com.clevertap.service;

import com.clevertap.api.DataCenterRegion;
import com.clevertap.exception.CleverTapException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.http.HttpHeaders;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class CleverTapAbstractService {

  private static final String ACCOUNT_ID_HEADER = "X-CleverTap-Account-Id";
  private static final String PASSCODE_HEADER = "X-CleverTap-Passcode";
  private final DataCenterRegion region;
  private final String accountId;
  private final String passcode;
  private final HttpClient client;

  private void addDefaultHeaders(HttpRequestBase requestBase) {
    requestBase.addHeader(new BasicHeader(ACCOUNT_ID_HEADER, accountId));
    requestBase.addHeader(new BasicHeader(PASSCODE_HEADER, passcode));
    requestBase.addHeader(
        new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType()));
  }

  protected HttpGet createBaseHttpGetRequest() {
    HttpGet get = new HttpGet(region.getUrl());
    addDefaultHeaders(get);
    return get;
  }

  protected HttpPost createBaseHttpPostRequest() {
    HttpPost post = new HttpPost(region.getUrl());
    addDefaultHeaders(post);
    return post;
  }

  protected void validateResponseStatusCode(StatusLine statusLine) throws CleverTapException {
    if (statusLine.getStatusCode() / 100 != 2) {
      throw new CleverTapException(
          statusLine.getStatusCode() + " - " + statusLine.getReasonPhrase());
    }
  }
}
