package org.finos.tracdap.common.codec.json;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonRecyclerPools;
import com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.NullVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.finos.tracdap.common.codec.json.JsonStreamParser.Handler;
import org.finos.tracdap.common.codec.json.JsonStreamParser.ParseState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonStreamParserDiffblueTest {
  /**
   * Test {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}.
   *
   * <ul>
   *   <li>Given {@code CANONICALIZE_FIELD_NAMES}.
   * </ul>
   *
   * <p>Method under test: {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}
   */
  @Test
  @DisplayName("Test new JsonStreamParser(JsonFactory, Handler); given 'CANONICALIZE_FIELD_NAMES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonStreamParser.<init>(JsonFactory, Handler)"})
  void testNewJsonStreamParser_givenCanonicalizeFieldNames() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();
    factory.disable(Feature.CANONICALIZE_FIELD_NAMES);
    JsonTableHandler handler =
        new JsonTableHandler(
            new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true);

    // Act
    JsonStreamParser actualJsonStreamParser = new JsonStreamParser(factory, handler);

    // Assert
    assertEquals(JsonToken.NOT_AVAILABLE, actualJsonStreamParser.nextToken());
  }

  /**
   * Test {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}.
   *
   * <ul>
   *   <li>Given construct three.
   * </ul>
   *
   * <p>Method under test: {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}
   */
  @Test
  @DisplayName("Test new JsonStreamParser(JsonFactory, Handler); given construct three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonStreamParser.<init>(JsonFactory, Handler)"})
  void testNewJsonStreamParser_givenConstructThree() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();
    factory.setRecyclerPool(BoundedPool.construct(3));
    JsonTableHandler handler =
        new JsonTableHandler(
            new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true);

    // Act
    JsonStreamParser actualJsonStreamParser = new JsonStreamParser(factory, handler);

    // Assert
    assertEquals(JsonToken.NOT_AVAILABLE, actualJsonStreamParser.nextToken());
  }

  /**
   * Test {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}.
   *
   * <ul>
   *   <li>Given {@code INTERN_FIELD_NAMES}.
   * </ul>
   *
   * <p>Method under test: {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}
   */
  @Test
  @DisplayName("Test new JsonStreamParser(JsonFactory, Handler); given 'INTERN_FIELD_NAMES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonStreamParser.<init>(JsonFactory, Handler)"})
  void testNewJsonStreamParser_givenInternFieldNames() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();
    factory.disable(Feature.INTERN_FIELD_NAMES);
    JsonTableHandler handler =
        new JsonTableHandler(
            new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true);

    // Act
    JsonStreamParser actualJsonStreamParser = new JsonStreamParser(factory, handler);

    // Assert
    assertEquals(JsonToken.NOT_AVAILABLE, actualJsonStreamParser.nextToken());
  }

  /**
   * Test {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}.
   *
   * <ul>
   *   <li>Given {@link NullVector#NullVector()}.
   *   <li>When {@link MappingJsonFactory#MappingJsonFactory()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}
   */
  @Test
  @DisplayName(
      "Test new JsonStreamParser(JsonFactory, Handler); given NullVector(); when MappingJsonFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonStreamParser.<init>(JsonFactory, Handler)"})
  void testNewJsonStreamParser_givenNullVector_whenMappingJsonFactory() throws IOException {
    // Arrange
    MappingJsonFactory factory = new MappingJsonFactory();

    ArrayList<FieldVector> vectors = new ArrayList<>();
    vectors.add(new NullVector());
    JsonTableHandler handler =
        new JsonTableHandler(new VectorSchemaRoot(vectors), mock(Consumer.class), 3, true);

    // Act
    JsonStreamParser actualJsonStreamParser = new JsonStreamParser(factory, handler);

    // Assert
    assertEquals(JsonToken.NOT_AVAILABLE, actualJsonStreamParser.nextToken());
  }

  /**
   * Test {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}.
   *
   * <ul>
   *   <li>Given {@code USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING}.
   * </ul>
   *
   * <p>Method under test: {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}
   */
  @Test
  @DisplayName(
      "Test new JsonStreamParser(JsonFactory, Handler); given 'USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonStreamParser.<init>(JsonFactory, Handler)"})
  void testNewJsonStreamParser_givenUseThreadLocalForBufferRecycling() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();
    factory.disable(Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING);
    JsonTableHandler handler =
        new JsonTableHandler(
            new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true);

    // Act
    JsonStreamParser actualJsonStreamParser = new JsonStreamParser(factory, handler);

    // Assert
    assertEquals(JsonToken.NOT_AVAILABLE, actualJsonStreamParser.nextToken());
  }

  /**
   * Test {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}.
   *
   * <ul>
   *   <li>When {@link JsonFactory#JsonFactory()}.
   *   <li>Then return nextToken is {@code NOT_AVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link JsonStreamParser#JsonStreamParser(JsonFactory, Handler)}
   */
  @Test
  @DisplayName(
      "Test new JsonStreamParser(JsonFactory, Handler); when JsonFactory(); then return nextToken is 'NOT_AVAILABLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonStreamParser.<init>(JsonFactory, Handler)"})
  void testNewJsonStreamParser_whenJsonFactory_thenReturnNextTokenIsNotAvailable()
      throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();
    JsonTableHandler handler =
        new JsonTableHandler(
            new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true);

    // Act
    JsonStreamParser actualJsonStreamParser = new JsonStreamParser(factory, handler);

    // Assert
    assertEquals(JsonToken.NOT_AVAILABLE, actualJsonStreamParser.nextToken());
  }

  /**
   * Test {@link JsonStreamParser#close()}.
   *
   * <p>Method under test: {@link JsonStreamParser#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonStreamParser.close()"})
  void testClose() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();
    JsonTableHandler handler =
        new JsonTableHandler(
            new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true);

    JsonStreamParser jsonStreamParser = new JsonStreamParser(factory, handler);

    // Act
    jsonStreamParser.close();

    // Assert
    assertNull(jsonStreamParser.nextToken());
  }

  /**
   * Test {@link JsonStreamParser#nextToken()}.
   *
   * <p>Method under test: {@link JsonStreamParser#nextToken()}
   */
  @Test
  @DisplayName("Test nextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonToken JsonStreamParser.nextToken()"})
  void testNextToken() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();
    JsonTableHandler handler =
        new JsonTableHandler(
            new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true);

    JsonStreamParser jsonStreamParser = new JsonStreamParser(factory, handler);

    // Act and Assert
    assertEquals(JsonToken.NOT_AVAILABLE, jsonStreamParser.nextToken());
  }

  /**
   * Test {@link JsonStreamParser#acceptToken(JsonToken)}.
   *
   * <ul>
   *   <li>When {@code NOT_AVAILABLE}.
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonStreamParser#acceptToken(JsonToken)}
   */
  @Test
  @DisplayName("Test acceptToken(JsonToken); when 'NOT_AVAILABLE'; then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonStreamParser.acceptToken(JsonToken)"})
  void testAcceptToken_whenNotAvailable_thenThrowJsonParseException() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();
    JsonTableHandler handler =
        new JsonTableHandler(
            new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true);

    JsonStreamParser jsonStreamParser = new JsonStreamParser(factory, handler);

    // Act and Assert
    assertThrows(
        JsonParseException.class, () -> jsonStreamParser.acceptToken(JsonToken.NOT_AVAILABLE));
  }

  /**
   * Test {@link JsonStreamParser#acceptToken(JsonToken)}.
   *
   * <ul>
   *   <li>When {@code START_ARRAY}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link JsonStreamParser#acceptToken(JsonToken)}
   */
  @Test
  @DisplayName("Test acceptToken(JsonToken); when 'START_ARRAY'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonStreamParser.acceptToken(JsonToken)"})
  void testAcceptToken_whenStartArray_thenDoesNotThrow() throws IOException {
    // Arrange
    JsonFactory factory = new JsonFactory();
    JsonTableHandler handler =
        new JsonTableHandler(
            new VectorSchemaRoot(new ArrayList<>()), mock(Consumer.class), 3, true);

    JsonStreamParser jsonStreamParser = new JsonStreamParser(factory, handler);

    // Act and Assert
    assertDoesNotThrow(() -> jsonStreamParser.acceptToken(JsonToken.START_ARRAY));
  }

  /**
   * Test ParseState new {@link ParseState} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ParseState}
   */
  @Test
  @DisplayName("Test ParseState new ParseState (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ParseState.<init>()"})
  void testParseStateNewParseState() {
    // Arrange and Act
    ParseState actualParseState = new ParseState();

    // Assert
    assertNull(actualParseState.fieldName);
    assertNull(actualParseState.stateType);
  }
}
