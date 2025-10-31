package org.finos.tracdap.common.codec.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.junit.jupiter.api.Test;

class JsonStreamParserDiffblueTest {
  /**
   * Method under test: {@link JsonStreamParser#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();
    JsonStreamParser jsonStreamParser = new JsonStreamParser(factory,
        new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true));

    // Act
    jsonStreamParser.close();

    // Assert
    assertNull(jsonStreamParser.nextToken());
  }

  /**
   * Method under test: {@link JsonStreamParser#nextToken()}
   */
  @Test
  void testNextToken() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();

    // Act and Assert
    assertEquals(JsonToken.NOT_AVAILABLE, (new JsonStreamParser(factory,
        new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true))).nextToken());
  }

  /**
   * Method under test: {@link JsonStreamParser#acceptToken(JsonToken)}
   */
  @Test
  void testAcceptToken() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> (new JsonStreamParser(factory,
            new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true)))
            .acceptToken(JsonToken.NOT_AVAILABLE));
  }

  /**
   * Method under test:
   * {@link JsonStreamParser#JsonStreamParser(JsonFactory, JsonStreamParser.Handler)}
   */
  @Test
  void testNewJsonStreamParser() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();

    // Act and Assert
    assertEquals(JsonToken.NOT_AVAILABLE, (new JsonStreamParser(factory,
        new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true))).nextToken());
  }

  /**
   * Method under test:
   * {@link JsonStreamParser#JsonStreamParser(JsonFactory, JsonStreamParser.Handler)}
   */
  @Test
  void testNewJsonStreamParser2() throws IOException {
    // Arrange
    JsonFactory factory = mock(JsonFactory.class);
    when(factory.createNonBlockingByteBufferParser())
        .thenReturn(new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance())));

    // Act
    JsonStreamParser actualJsonStreamParser = new JsonStreamParser(factory,
        new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true));

    // Assert
    verify(factory).createNonBlockingByteBufferParser();
    assertEquals(JsonToken.NOT_AVAILABLE, actualJsonStreamParser.nextToken());
  }

  /**
   * Method under test:
   * {@link JsonStreamParser#JsonStreamParser(JsonFactory, JsonStreamParser.Handler)}
   */
  @Test
  void testNewJsonStreamParser3() throws IOException {
    // Arrange
    NonBlockingByteBufferJsonParser d = mock(NonBlockingByteBufferJsonParser.class);
    BufferRecycler br = new BufferRecycler();
    when(d.getNonBlockingInputFeeder())
        .thenReturn(new NonBlockingByteBufferJsonParser(new IOContext(br, ContentReference.redacted(), true), 1, null));
    JsonFactory factory = mock(JsonFactory.class);
    when(factory.createNonBlockingByteBufferParser()).thenReturn(new JsonParserDelegate(d));

    // Act
    JsonStreamParser actualJsonStreamParser = new JsonStreamParser(factory,
        new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true));

    // Assert
    verify(factory).createNonBlockingByteBufferParser();
    verify(d).getNonBlockingInputFeeder();
    assertNull(actualJsonStreamParser.nextToken());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link JsonStreamParser.ParseState}
   */
  @Test
  void testParseStateNewParseState() {
    // Arrange and Act
    JsonStreamParser.ParseState actualParseState = new JsonStreamParser.ParseState();

    // Assert
    assertNull(actualParseState.fieldName);
    assertNull(actualParseState.stateType);
  }
}
