package com.clevertap.client;

import com.clevertap.api.DataCenterRegion;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class CleverTapClientBuilderTest {

  @Test
  void builder() {
    Throwable exception;

    exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> CleverTapClientBuilder.builder(null, "account id", "passcode"));
    assertEquals("region cannot be null", exception.getMessage());

    exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> CleverTapClientBuilder.builder(DataCenterRegion.EU, "  ", "passcode"));
    assertEquals("account id cannot be blank", exception.getMessage());

    exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> CleverTapClientBuilder.builder(DataCenterRegion.EU, "account id", "  "));
    assertEquals("passcode cannot be blank", exception.getMessage());

    assertDoesNotThrow(
        () -> CleverTapClientBuilder.builder(DataCenterRegion.EU, "account id", "passcode"));
  }

  @Test
  void withHttpClientConfiguration() {
    CleverTapClientBuilder builder =
        CleverTapClientBuilder.builder(DataCenterRegion.EU, "account id", "passcode");

    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> builder.withHttpClientConfiguration(null));
    assertEquals("http client configuration cannot be null", exception.getMessage());

    assertDoesNotThrow(() -> builder.withHttpClientConfiguration(new ClientConfig()));
  }

  @Test
  void build() {
    CleverTapClientBuilder builder =
        CleverTapClientBuilder.builder(DataCenterRegion.EU, "account id", "passcode");

    builder.build();
    assertNotNull(builder.getConfiguration());

    Configuration configuration = new ClientConfig();
    builder = builder.withHttpClientConfiguration(configuration);
    assertSame(configuration, builder.getConfiguration());
  }
}
