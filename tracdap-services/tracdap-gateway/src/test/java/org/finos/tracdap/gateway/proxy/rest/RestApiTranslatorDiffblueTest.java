package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.api.Advice;
import com.google.protobuf.Message;
import io.grpc.Status;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.util.AsciiString;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class RestApiTranslatorDiffblueTest {
  /**
   * Method under test:
   * {@link RestApiTranslator#RestApiTranslator(Message, Message, String, String, String)}
   */
  @Test
  void testNewRestApiTranslator() {
    // Arrange
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new RestApiTranslator<>(defaultInstance, Advice.getDefaultInstance(),
        "{", "Not all who wander are lost", "Not all who wander are lost"));

  }

  /**
   * Method under test:
   * {@link RestApiTranslator#RestApiTranslator(Message, Message, String, String, String)}
   */
  @Test
  void testNewRestApiTranslator2() throws UnsupportedEncodingException {
    // Arrange
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act
    RestApiTranslator<Message, Message> actualRestApiTranslator = new RestApiTranslator<>(defaultInstance,
        Advice.getDefaultInstance(), "https://example.org/example", "*", "*");

    // Assert
    HttpResponseStatus translateGrpcErrorCodeResult = actualRestApiTranslator.translateGrpcErrorCode(Status.Code.OK);
    assertEquals("OK", translateGrpcErrorCodeResult.reasonPhrase());
    assertEquals(200, translateGrpcErrorCodeResult.code());
    AsciiString codeAsTextResult = translateGrpcErrorCodeResult.codeAsText();
    assertEquals(3, codeAsTextResult.length());
    assertEquals(HttpStatusClass.SUCCESS, translateGrpcErrorCodeResult.codeClass());
    assertFalse(codeAsTextResult.isEmpty());
    assertTrue(codeAsTextResult.isEntireArrayUsed());
    assertSame(codeAsTextResult, codeAsTextResult.toLowerCase());
    assertSame(codeAsTextResult, codeAsTextResult.toUpperCase());
    byte[] expectedArrayResult = "200".getBytes("UTF-8");
    assertArrayEquals(expectedArrayResult, codeAsTextResult.array());
    byte[] expectedToByteArrayResult = "200".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, codeAsTextResult.toByteArray());
    char[] expectedToCharArrayResult = "200".toCharArray();
    assertArrayEquals(expectedToCharArrayResult, codeAsTextResult.toCharArray());
  }
}
