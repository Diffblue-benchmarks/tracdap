package org.finos.tracdap.common.codec.json;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.finos.tracdap.common.codec.json.JsonStreamParser.ParseState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonStreamParserDiffblueTest {
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
