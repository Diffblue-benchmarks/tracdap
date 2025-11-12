package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolConfig;
import java.util.function.Function;
import java.util.function.Supplier;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProtocolHandlerDiffblueTest {
  /**
   * Test {@link ProtocolHandler#create()}.
   *
   * <p>Method under test: {@link ProtocolHandler#create()}
   */
  @Test
  @DisplayName("Test create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProtocolHandler ProtocolHandler.create()"})
  void testCreate() {
    // Arrange, Act and Assert
    assertFalse(ProtocolHandler.create().http2Supported());
  }

  /**
   * Test {@link ProtocolHandler#withHttp(Supplier)}.
   *
   * <p>Method under test: {@link ProtocolHandler#withHttp(Supplier)}
   */
  @Test
  @DisplayName("Test withHttp(Supplier)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProtocolHandler ProtocolHandler.withHttp(Supplier)"})
  void testWithHttp() {
    // Arrange
    ProtocolHandler createResult = ProtocolHandler.create();
    Supplier<ChannelHandler> httpSupplier = createResult::createHttpHandler;

    // Act and Assert
    assertFalse(createResult.withHttp(httpSupplier).http2Supported());
  }

  /**
   * Test {@link ProtocolHandler#withHttp2(Supplier)}.
   *
   * <p>Method under test: {@link ProtocolHandler#withHttp2(Supplier)}
   */
  @Test
  @DisplayName("Test withHttp2(Supplier)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProtocolHandler ProtocolHandler.withHttp2(Supplier)"})
  void testWithHttp2() {
    // Arrange
    ProtocolHandler createResult = ProtocolHandler.create();
    Supplier<ChannelHandler> http2Supplier = createResult::createHttpHandler;

    // Act and Assert
    assertTrue(createResult.withHttp2(http2Supplier).http2Supported());
  }

  /**
   * Test {@link ProtocolHandler#withWebsocket(Supplier, Function)}.
   *
   * <p>Method under test: {@link ProtocolHandler#withWebsocket(Supplier, Function)}
   */
  @Test
  @DisplayName("Test withWebsocket(Supplier, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProtocolHandler ProtocolHandler.withWebsocket(Supplier, Function)"})
  void testWithWebsocket() {
    // Arrange
    ProtocolHandler createResult = ProtocolHandler.create();
    Supplier<ChannelHandler> wsSupplier = createResult::createHttpHandler;
    Function<HttpRequest, WebSocketServerProtocolConfig> wsConfigSupplier =
        createResult::createWebSocketConfig;

    // Act and Assert
    assertFalse(createResult.withWebsocket(wsSupplier, wsConfigSupplier).http2Supported());
  }

  /**
   * Test {@link ProtocolHandler#httpSupported()}.
   *
   * <p>Method under test: {@link ProtocolHandler#httpSupported()}
   */
  @Test
  @DisplayName("Test httpSupported()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProtocolHandler.httpSupported()"})
  void testHttpSupported() {
    // Arrange, Act and Assert
    assertFalse(ProtocolHandler.create().httpSupported());
  }

  /**
   * Test {@link ProtocolHandler#createHttpHandler()}.
   *
   * <p>Method under test: {@link ProtocolHandler#createHttpHandler()}
   */
  @Test
  @DisplayName("Test createHttpHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChannelHandler ProtocolHandler.createHttpHandler()"})
  void testCreateHttpHandler() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> ProtocolHandler.create().createHttpHandler());
  }

  /**
   * Test {@link ProtocolHandler#http2Supported()}.
   *
   * <p>Method under test: {@link ProtocolHandler#http2Supported()}
   */
  @Test
  @DisplayName("Test http2Supported()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProtocolHandler.http2Supported()"})
  void testHttp2Supported() {
    // Arrange, Act and Assert
    assertFalse(ProtocolHandler.create().http2Supported());
  }

  /**
   * Test {@link ProtocolHandler#createHttp2Handler()}.
   *
   * <p>Method under test: {@link ProtocolHandler#createHttp2Handler()}
   */
  @Test
  @DisplayName("Test createHttp2Handler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChannelHandler ProtocolHandler.createHttp2Handler()"})
  void testCreateHttp2Handler() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> ProtocolHandler.create().createHttp2Handler());
  }

  /**
   * Test {@link ProtocolHandler#websocketSupported()}.
   *
   * <p>Method under test: {@link ProtocolHandler#websocketSupported()}
   */
  @Test
  @DisplayName("Test websocketSupported()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProtocolHandler.websocketSupported()"})
  void testWebsocketSupported() {
    // Arrange, Act and Assert
    assertFalse(ProtocolHandler.create().websocketSupported());
  }

  /**
   * Test {@link ProtocolHandler#createWebsocketHandler()}.
   *
   * <p>Method under test: {@link ProtocolHandler#createWebsocketHandler()}
   */
  @Test
  @DisplayName("Test createWebsocketHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChannelHandler ProtocolHandler.createWebsocketHandler()"})
  void testCreateWebsocketHandler() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> ProtocolHandler.create().createWebsocketHandler());
  }

  /**
   * Test {@link ProtocolHandler#createWebSocketConfig(HttpRequest)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link ProtocolHandler#createWebSocketConfig(HttpRequest)}
   */
  @Test
  @DisplayName("Test createWebSocketConfig(HttpRequest); when 'null'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WebSocketServerProtocolConfig ProtocolHandler.createWebSocketConfig(HttpRequest)"
  })
  void testCreateWebSocketConfig_whenNull_thenThrowETracInternal() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> ProtocolHandler.create().createWebSocketConfig(null));
  }
}
