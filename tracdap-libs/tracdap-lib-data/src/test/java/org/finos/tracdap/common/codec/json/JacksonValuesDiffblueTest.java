package org.finos.tracdap.common.codec.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.impl.SimpleTokenWriteContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.NullVector;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JacksonValuesDiffblueTest {
  /**
   * Test {@link JacksonValues#setEmptyString(FieldVector, int)}.
   *
   * <ul>
   *   <li>When {@link NullVector#NullVector()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonValues#setEmptyString(FieldVector, int)}
   */
  @Test
  @DisplayName("Test setEmptyString(FieldVector, int); when NullVector(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonValues.setEmptyString(FieldVector, int)"})
  void testSetEmptyString_whenNullVector_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> JacksonValues.setEmptyString(new NullVector(), 1));
  }

  /**
   * Test {@link JacksonValues#getAndGenerate(FieldVector, int, JsonGenerator)}.
   *
   * <p>Method under test: {@link JacksonValues#getAndGenerate(FieldVector, int, JsonGenerator)}
   */
  @Test
  @DisplayName("Test getAndGenerate(FieldVector, int, JsonGenerator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonValues.getAndGenerate(FieldVector, int, JsonGenerator)"})
  void testGetAndGenerate() throws IOException {
    // Arrange
    NullVector vector = new NullVector();
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);
    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();

    CsvGenerator generator = new CsvGenerator(ctxt, 1, 1, codec, null);

    // Act
    JacksonValues.getAndGenerate(vector, 1, generator);

    // Assert
    SimpleTokenWriteContext outputContext = generator.getOutputContext();
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
  }

  /**
   * Test {@link JacksonValues#getAndGenerate(FieldVector, int, JsonGenerator)}.
   *
   * <p>Method under test: {@link JacksonValues#getAndGenerate(FieldVector, int, JsonGenerator)}
   */
  @Test
  @DisplayName("Test getAndGenerate(FieldVector, int, JsonGenerator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonValues.getAndGenerate(FieldVector, int, JsonGenerator)"})
  void testGetAndGenerate2() throws IOException {
    // Arrange
    NullVector vector = new NullVector();
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);
    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();

    UTF8JsonGenerator generator =
        new UTF8JsonGenerator(ctxt, 1, codec, new ByteArrayOutputStream());

    // Act
    JacksonValues.getAndGenerate(vector, 1, generator);

    // Assert
    JsonStreamContext outputContext = generator.getOutputContext();
    assertTrue(outputContext instanceof JsonWriteContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(4, generator.getOutputBuffered());
    assertTrue(outputContext.hasCurrentIndex());
  }
}
