package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
import com.google.protobuf.Message;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.util.AsciiString;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RestApiTranslatorDiffblueTest {
  /**
   * Test {@link RestApiTranslator#RestApiTranslator(Message, Message, String, String, String)}.
   * <ul>
   *   <li>Then return translateGrpcErrorCode {@code OK} reasonPhrase is {@code OK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiTranslator#RestApiTranslator(Message, Message, String, String, String)}
   */
  @Test
  @DisplayName("Test new RestApiTranslator(Message, Message, String, String, String); then return translateGrpcErrorCode 'OK' reasonPhrase is 'OK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiTranslator.<init>(Message, Message, String, String, String)"})
  void testNewRestApiTranslator_thenReturnTranslateGrpcErrorCodeOkReasonPhraseIsOk()
      throws UnsupportedEncodingException {
    // Arrange
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act
    RestApiTranslator<Message, Message> actualRestApiTranslator = new RestApiTranslator<>(defaultInstance,
        Advice.getDefaultInstance(), "https://example.org/example", "*", "*");

    // Assert
    HttpResponseStatus translateGrpcErrorCodeResult = actualRestApiTranslator.translateGrpcErrorCode(Code.OK);
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

  /**
   * Test {@link RestApiTranslator#RestApiTranslator(Message, Message, String, String, String)}.
   * <ul>
   *   <li>When {@code {}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiTranslator#RestApiTranslator(Message, Message, String, String, String)}
   */
  @Test
  @DisplayName("Test new RestApiTranslator(Message, Message, String, String, String); when '{'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestApiTranslator.<init>(Message, Message, String, String, String)"})
  void testNewRestApiTranslator_whenLeftCurlyBracket_thenThrowRuntimeException() {
    // Arrange
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> new RestApiTranslator<>(defaultInstance, Advice.getDefaultInstance(),
        "{", "Not all who wander are lost", "Not all who wander are lost"));

  }
}
