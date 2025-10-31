package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.http.HttpRequest;
import java.util.function.Function;
import java.util.function.Supplier;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.Test;

class ProtocolHandlerDiffblueTest {
  /**
   * Method under test: {@link ProtocolHandler#create()}
   */
  @Test
  void testCreate() {
    // Arrange, Act and Assert
    assertFalse(ProtocolHandler.create().http2Supported());
  }

  /**
   * Method under test: {@link ProtocolHandler#withHttp(Supplier)}
   */
  @Test
  void testWithHttp() {
    // Arrange
    ProtocolHandler createResult = ProtocolHandler.create();

    // Act and Assert
    assertFalse(createResult.withHttp(createResult::createHttp2Handler).http2Supported());
  }

  /**
   * Method under test: {@link ProtocolHandler#withHttp2(Supplier)}
   */
  @Test
  void testWithHttp2() {
    // Arrange
    ProtocolHandler createResult = ProtocolHandler.create();

    // Act and Assert
    assertTrue(createResult.withHttp2(createResult::createHttp2Handler).http2Supported());
  }

  /**
   * Method under test: {@link ProtocolHandler#withWebsocket(Supplier, Function)}
   */
  @Test
  void testWithWebsocket() {
    // Arrange
    ProtocolHandler createResult = ProtocolHandler.create();
    Supplier<ChannelHandler> wsSupplier = createResult::createHttp2Handler;

    // Act and Assert
    assertFalse(createResult.withWebsocket(wsSupplier, createResult::createWebSocketConfig).http2Supported());
  }

  /**
   * Method under test: {@link ProtocolHandler#httpSupported()}
   */
  @Test
  void testHttpSupported() {
    // Arrange, Act and Assert
    assertFalse(ProtocolHandler.create().httpSupported());
  }

  /**
   * Method under test: {@link ProtocolHandler#createHttpHandler()}
   */
  @Test
  void testCreateHttpHandler() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> ProtocolHandler.create().createHttpHandler());
  }

  /**
   * Method under test: {@link ProtocolHandler#http2Supported()}
   */
  @Test
  void testHttp2Supported() {
    // Arrange, Act and Assert
    assertFalse(ProtocolHandler.create().http2Supported());
  }

  /**
   * Method under test: {@link ProtocolHandler#createHttp2Handler()}
   */
  @Test
  void testCreateHttp2Handler() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> ProtocolHandler.create().createHttp2Handler());
  }

  /**
   * Method under test: {@link ProtocolHandler#websocketSupported()}
   */
  @Test
  void testWebsocketSupported() {
    // Arrange, Act and Assert
    assertFalse(ProtocolHandler.create().websocketSupported());
  }

  /**
   * Method under test: {@link ProtocolHandler#createWebsocketHandler()}
   */
  @Test
  void testCreateWebsocketHandler() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> ProtocolHandler.create().createWebsocketHandler());
  }

  /**
   * Method under test: {@link ProtocolHandler#createWebSocketConfig(HttpRequest)}
   */
  @Test
  void testCreateWebSocketConfig() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> ProtocolHandler.create().createWebSocketConfig(null));
  }
}
