package org.finos.tracdap.common.codec.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.finos.tracdap.common.codec.json.JsonStreamParser.Handler;
import org.finos.tracdap.common.codec.json.JsonStreamParser.ParseState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonStreamParserDiffblueTest {
  /**
   * Test {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}.
   * <ul>
   *   <li>Given {@link TreeTraversingParser#TreeTraversingParser(JsonNode)} with n is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}
   */
  @Test
  @DisplayName("Test new JsonStreamParser(JsonFactory, Handler); given TreeTraversingParser(JsonNode) with n is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonStreamParser.<init>(JsonFactory, Handler)"})
  void testNewJsonStreamParser_givenTreeTraversingParserWithNIsInstance() throws IOException {
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
   * Test {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}.
   * <ul>
   *   <li>Then return nextToken is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}
   */
  @Test
  @DisplayName("Test new JsonStreamParser(JsonFactory, Handler); then return nextToken is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonStreamParser.<init>(JsonFactory, Handler)"})
  void testNewJsonStreamParser_thenReturnNextTokenIsNull() throws IOException {
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
   * Test {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}.
   * <ul>
   *   <li>When {@link JsonFactory#JsonFactory()}.</li>
   *   <li>Then return nextToken is {@code NOT_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}
   */
  @Test
  @DisplayName("Test new JsonStreamParser(JsonFactory, Handler); when JsonFactory(); then return nextToken is 'NOT_AVAILABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonStreamParser.<init>(JsonFactory, Handler)"})
  void testNewJsonStreamParser_whenJsonFactory_thenReturnNextTokenIsNotAvailable() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();

    // Act and Assert
    assertEquals(JsonToken.NOT_AVAILABLE, (new JsonStreamParser(factory,
        new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true))).nextToken());
  }

  /**
   * Test {@link JsonStreamParser#close()}.
   * <p>
   * Method under test: {@link JsonStreamParser#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonStreamParser.close()"})
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
   * Test {@link JsonStreamParser#nextToken()}.
   * <p>
   * Method under test: {@link JsonStreamParser#nextToken()}
   */
  @Test
  @DisplayName("Test nextToken()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonToken JsonStreamParser.nextToken()"})
  void testNextToken() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();

    // Act and Assert
    assertEquals(JsonToken.NOT_AVAILABLE, (new JsonStreamParser(factory,
        new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true))).nextToken());
  }

  /**
   * Test {@link JsonStreamParser#acceptToken(JsonToken)}.
   * <ul>
   *   <li>When {@code NOT_AVAILABLE}.</li>
   *   <li>Then throw {@link JsonParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonStreamParser#acceptToken(JsonToken)}
   */
  @Test
  @DisplayName("Test acceptToken(JsonToken); when 'NOT_AVAILABLE'; then throw JsonParseException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonStreamParser.acceptToken(JsonToken)"})
  void testAcceptToken_whenNotAvailable_thenThrowJsonParseException() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> (new JsonStreamParser(factory,
            new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true)))
            .acceptToken(JsonToken.NOT_AVAILABLE));
  }

  /**
   * Test ParseState new {@link ParseState} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ParseState}
   */
  @Test
  @DisplayName("Test ParseState new ParseState (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ParseState.<init>()"})
  void testParseStateNewParseState() {
    // Arrange and Act
    ParseState actualParseState = new ParseState();

    // Assert
    assertNull(actualParseState.fieldName);
    assertNull(actualParseState.stateType);
  }
}
