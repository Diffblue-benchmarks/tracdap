package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.api.Advice;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import org.junit.jupiter.api.Test;

class RestApiMethodDiffblueTest {
  /**
   * Method under test:
   * {@link RestApiMethod#POST(Descriptors.MethodDescriptor, Message, Message, String, String, String)}
   */
  @Test
  void testPOST() {
    // Arrange
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act
    RestApiMethod<Message, Message> actualPOSTResult = RestApiMethod.POST(null, defaultInstance,
        Advice.getDefaultInstance(), "https://example.org/example", "*", "*");

    // Assert
    assertNull(actualPOSTResult.grpcMethod);
    assertFalse(actualPOSTResult.isDownload);
    assertTrue(actualPOSTResult.hasBody);
  }

  /**
   * Method under test:
   * {@link RestApiMethod#GET(Descriptors.MethodDescriptor, Message, Message, String, String)}
   */
  @Test
  void testGET() {
    // Arrange
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act
    RestApiMethod<Message, Message> actualGETResult = RestApiMethod.GET(null, defaultInstance,
        Advice.getDefaultInstance(), "https://example.org/example", "*");

    // Assert
    assertNull(actualGETResult.grpcMethod);
    assertFalse(actualGETResult.hasBody);
    assertFalse(actualGETResult.isDownload);
  }
}
