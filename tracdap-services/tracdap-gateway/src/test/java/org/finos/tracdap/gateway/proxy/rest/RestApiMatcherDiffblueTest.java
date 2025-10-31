package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
import com.google.protobuf.Message;
import io.netty.handler.codec.http.HttpMethod;
import java.net.URI;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RestApiMatcherDiffblueTest {
  /**
   * Test {@link RestApiMatcher#RestApiMatcher(HttpMethod, String, Message)}.
   * <p>
   * Method under test: {@link RestApiMatcher#RestApiMatcher(HttpMethod, String, Message)}
   */
  @Test
  @DisplayName("Test new RestApiMatcher(HttpMethod, String, Message)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiMatcher.<init>(HttpMethod, String, Message)"})
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
   * Test {@link RestApiMatcher#RestApiMatcher(HttpMethod, String, Message)}.
   * <p>
   * Method under test: {@link RestApiMatcher#RestApiMatcher(HttpMethod, String, Message)}
   */
  @Test
  @DisplayName("Test new RestApiMatcher(HttpMethod, String, Message)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiMatcher.<init>(HttpMethod, String, Message)"})
  void testNewRestApiMatcher2() {
    // Arrange, Act and Assert
    assertFalse((new RestApiMatcher(null, "https://example.org/example", Advice.getDefaultInstance())).matches(null,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test {@link RestApiMatcher#matches(HttpMethod, URI)}.
   * <p>
   * Method under test: {@link RestApiMatcher#matches(HttpMethod, URI)}
   */
  @Test
  @DisplayName("Test matches(HttpMethod, URI)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestApiMatcher.matches(HttpMethod, URI)"})
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
   * Test {@link RestApiMatcher#matches(HttpMethod, URI)}.
   * <p>
   * Method under test: {@link RestApiMatcher#matches(HttpMethod, URI)}
   */
  @Test
  @DisplayName("Test matches(HttpMethod, URI)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestApiMatcher.matches(HttpMethod, URI)"})
  void testMatches2() {
    // Arrange, Act and Assert
    assertFalse((new RestApiMatcher(null, "https://example.org/example", Advice.getDefaultInstance())).matches(null,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
  }

  /**
   * Test {@link RestApiMatcher#matches(HttpMethod, URI)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo} and {@code 42} toUri.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiMatcher#matches(HttpMethod, URI)}
   */
  @Test
  @DisplayName("Test matches(HttpMethod, URI); when Property is 'java.io.tmpdir' is 'foo' and '42' toUri")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestApiMatcher.matches(HttpMethod, URI)"})
  void testMatches_whenPropertyIsJavaIoTmpdirIsFooAnd42ToUri() {
    // Arrange, Act and Assert
    assertFalse((new RestApiMatcher(null, "https://example.org/example", Advice.getDefaultInstance())).matches(null,
        Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toUri()));
  }
}
