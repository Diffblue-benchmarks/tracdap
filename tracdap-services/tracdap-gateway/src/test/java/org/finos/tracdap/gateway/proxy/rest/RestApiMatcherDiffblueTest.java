package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.google.api.Advice;
import com.google.protobuf.Message;
import io.netty.handler.codec.http.HttpMethod;
import java.net.URI;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class RestApiMatcherDiffblueTest {
  /**
   * Method under test: {@link RestApiMatcher#matches(HttpMethod, URI)}
   */
  @Test
  void testMatches() {
    // Arrange
    HttpMethod httpMethod = HttpMethod.valueOf("Name");
    RestApiMatcher restApiMatcher = new RestApiMatcher(httpMethod, "https://example.org/example",
        Advice.getDefaultInstance());

    // Act and Assert
    assertFalse(restApiMatcher.matches(HttpMethod.valueOf("Name"),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Method under test: {@link RestApiMatcher#matches(HttpMethod, URI)}
   */
  @Test
  void testMatches2() {
    // Arrange, Act and Assert
    assertFalse((new RestApiMatcher(null, "https://example.org/example", Advice.getDefaultInstance())).matches(null,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Method under test: {@link RestApiMatcher#matches(HttpMethod, URI)}
   */
  @Test
  void testMatches3() {
    // Arrange, Act and Assert
    assertFalse((new RestApiMatcher(null, "https://example.org/example", Advice.getDefaultInstance())).matches(null,
        Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toUri()));
  }

  /**
   * Method under test:
   * {@link RestApiMatcher#RestApiMatcher(HttpMethod, String, Message)}
   */
  @Test
  void testNewRestApiMatcher() {
    // Arrange
    HttpMethod httpMethod = HttpMethod.valueOf("Name");

    // Act
    RestApiMatcher actualRestApiMatcher = new RestApiMatcher(httpMethod, "https://example.org/example",
        Advice.getDefaultInstance());

    // Assert
    assertFalse(actualRestApiMatcher.matches(HttpMethod.valueOf("*"),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Method under test:
   * {@link RestApiMatcher#RestApiMatcher(HttpMethod, String, Message)}
   */
  @Test
  void testNewRestApiMatcher2() {
    // Arrange, Act and Assert
    assertFalse((new RestApiMatcher(null, "https://example.org/example", Advice.getDefaultInstance())).matches(null,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }
}
