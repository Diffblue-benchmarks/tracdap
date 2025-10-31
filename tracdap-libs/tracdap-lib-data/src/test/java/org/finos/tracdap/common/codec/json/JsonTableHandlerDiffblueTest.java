package org.finos.tracdap.common.codec.json;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.NullVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.ArrowType.Int;
import org.apache.arrow.vector.types.pojo.DictionaryEncoding;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.finos.tracdap.common.codec.json.JsonStreamParser.ParseState;
import org.finos.tracdap.common.data.ArrowSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JsonTableHandlerDiffblueTest {
  /**
   * Test {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}.
   * <ul>
   *   <li>Given {@link Field} {@link Field#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link Field#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}
   */
  @Test
  @DisplayName("Test new JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean); given Field getName() return 'Name'; then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.<init>(VectorSchemaRoot, Consumer, int, boolean)"})
  void testNewJsonTableHandler_givenFieldGetNameReturnName_thenCallsGetName() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getName()).thenReturn("Name");

    ArrayList<Field> fieldList = new ArrayList<>();
    fieldList.add(field);
    Schema schema = mock(Schema.class);
    when(schema.getFields()).thenReturn(fieldList);
    VectorSchemaRoot root = mock(VectorSchemaRoot.class);
    when(root.getSchema()).thenReturn(schema);

    // Act
    new JsonTableHandler(root, mock(Consumer.class), 3, true);

    // Assert
    verify(root).getSchema();
    verify(field).getName();
    verify(schema, atLeast(1)).getFields();
  }

  /**
   * Test {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}.
   * <ul>
   *   <li>Given {@link ArrowType.Int#Int(int, boolean)} with bitWidth is one and isSigned is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}
   */
  @Test
  @DisplayName("Test new JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean); given Int(int, boolean) with bitWidth is one and isSigned is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.<init>(VectorSchemaRoot, Consumer, int, boolean)"})
  void testNewJsonTableHandler_givenIntWithBitWidthIsOneAndIsSignedIsTrue() {
    // Arrange
    ArrayList<Field> fieldList = new ArrayList<>();
    FieldType fieldType = new FieldType(true, ArrowSchema.ARROW_BASIC_BOOLEAN,
        new DictionaryEncoding(1L, true, new Int(1, true)));

    fieldList.add(new Field("Name", fieldType, new ArrayList<>()));
    Schema schema = mock(Schema.class);
    when(schema.getFields()).thenReturn(fieldList);
    VectorSchemaRoot root = mock(VectorSchemaRoot.class);
    when(root.getSchema()).thenReturn(schema);

    // Act
    new JsonTableHandler(root, mock(Consumer.class), 3, true);

    // Assert
    verify(root).getSchema();
    verify(schema, atLeast(1)).getFields();
  }

  /**
   * Test {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}.
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getFields()} return {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Schema#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}
   */
  @Test
  @DisplayName("Test new JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean); given Schema getFields() return ArrayList(); then calls getFields()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.<init>(VectorSchemaRoot, Consumer, int, boolean)"})
  void testNewJsonTableHandler_givenSchemaGetFieldsReturnArrayList_thenCallsGetFields() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getFields()).thenReturn(new ArrayList<>());
    VectorSchemaRoot root = mock(VectorSchemaRoot.class);
    when(root.getSchema()).thenReturn(schema);

    // Act
    new JsonTableHandler(root, mock(Consumer.class), 3, true);

    // Assert
    verify(root).getSchema();
    verify(schema).getFields();
  }

  /**
   * Test {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}.
   * <ul>
   *   <li>Given {@link Schema#Schema(Iterable)} with fields is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}
   */
  @Test
  @DisplayName("Test new JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean); given Schema(Iterable) with fields is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.<init>(VectorSchemaRoot, Consumer, int, boolean)"})
  void testNewJsonTableHandler_givenSchemaWithFieldsIsArrayList() {
    // Arrange
    VectorSchemaRoot root = mock(VectorSchemaRoot.class);
    when(root.getSchema()).thenReturn(new Schema(new ArrayList<>()));

    // Act
    new JsonTableHandler(root, mock(Consumer.class), 3, true);

    // Assert
    verify(root).getSchema();
  }

  /**
   * Test {@link JsonTableHandler#handlePushArray(JsonParser, ParseState, ParseState, int)}.
   * <p>
   * Method under test: {@link JsonTableHandler#handlePushArray(JsonParser, ParseState, ParseState, int)}
   */
  @Test
  @DisplayName("Test handlePushArray(JsonParser, ParseState, ParseState, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handlePushArray(JsonParser, ParseState, ParseState, int)"})
  void testHandlePushArray() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();
    JsonParserDelegate lexer = new JsonParserDelegate(
        new UTF8StreamJsonParser(ctxt, 1, in, codec, null, "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));
    ParseState state = new ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class, () -> jsonTableHandler.handlePushArray(lexer, state, new ParseState(), 2));
  }

  /**
   * Test {@link JsonTableHandler#handlePushArray(JsonParser, ParseState, ParseState, int)}.
   * <p>
   * Method under test: {@link JsonTableHandler#handlePushArray(JsonParser, ParseState, ParseState, int)}
   */
  @Test
  @DisplayName("Test handlePushArray(JsonParser, ParseState, ParseState, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handlePushArray(JsonParser, ParseState, ParseState, int)"})
  void testHandlePushArray2() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();
    JsonParserDelegate lexer = new JsonParserDelegate(
        new UTF8StreamJsonParser(ctxt, -1, in, codec, null, "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));
    ParseState state = new ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class, () -> jsonTableHandler.handlePushArray(lexer, state, new ParseState(), 2));
  }

  /**
   * Test {@link JsonTableHandler#handlePushArray(JsonParser, ParseState, ParseState, int)}.
   * <ul>
   *   <li>When {@link TreeTraversingParser#TreeTraversingParser(JsonNode)} with n is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#handlePushArray(JsonParser, ParseState, ParseState, int)}
   */
  @Test
  @DisplayName("Test handlePushArray(JsonParser, ParseState, ParseState, int); when TreeTraversingParser(JsonNode) with n is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handlePushArray(JsonParser, ParseState, ParseState, int)"})
  void testHandlePushArray_whenTreeTraversingParserWithNIsInstance() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    ParseState state = new ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class, () -> jsonTableHandler.handlePushArray(lexer, state, new ParseState(), 2));
  }

  /**
   * Test {@link JsonTableHandler#handlePopArray(JsonParser, ParseState, ParseState, int)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NullVector#NullVector()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#handlePopArray(JsonParser, ParseState, ParseState, int)}
   */
  @Test
  @DisplayName("Test handlePopArray(JsonParser, ParseState, ParseState, int); given ArrayList() add NullVector()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handlePopArray(JsonParser, ParseState, ParseState, int)"})
  void testHandlePopArray_givenArrayListAddNullVector() {
    // Arrange
    ArrayList<FieldVector> vectors = new ArrayList<>();
    vectors.add(new NullVector());
    VectorSchemaRoot root = new VectorSchemaRoot(vectors);
    Consumer<Void> batchSignal = mock(Consumer.class);
    doNothing().when(batchSignal).accept(Mockito.<Void>any());
    JsonTableHandler jsonTableHandler = new JsonTableHandler(root, batchSignal, 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    ParseState state = new ParseState();

    // Act
    jsonTableHandler.handlePopArray(lexer, state, new ParseState(), 2);

    // Assert
    verify(batchSignal).accept(isNull());
  }

  /**
   * Test {@link JsonTableHandler#handlePopArray(JsonParser, ParseState, ParseState, int)}.
   * <ul>
   *   <li>Given {@link VectorSchemaRoot#VectorSchemaRoot(Iterable)} with vectors is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#handlePopArray(JsonParser, ParseState, ParseState, int)}
   */
  @Test
  @DisplayName("Test handlePopArray(JsonParser, ParseState, ParseState, int); given VectorSchemaRoot(Iterable) with vectors is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handlePopArray(JsonParser, ParseState, ParseState, int)"})
  void testHandlePopArray_givenVectorSchemaRootWithVectorsIsArrayList() {
    // Arrange
    Consumer<Void> batchSignal = mock(Consumer.class);
    doNothing().when(batchSignal).accept(Mockito.<Void>any());
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()), batchSignal, 3,
        true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    ParseState state = new ParseState();

    // Act
    jsonTableHandler.handlePopArray(lexer, state, new ParseState(), 2);

    // Assert
    verify(batchSignal).accept(isNull());
  }

  /**
   * Test {@link JsonTableHandler#handlePopArray(JsonParser, ParseState, ParseState, int)}.
   * <ul>
   *   <li>Then calls {@link VectorSchemaRoot#getSchema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#handlePopArray(JsonParser, ParseState, ParseState, int)}
   */
  @Test
  @DisplayName("Test handlePopArray(JsonParser, ParseState, ParseState, int); then calls getSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handlePopArray(JsonParser, ParseState, ParseState, int)"})
  void testHandlePopArray_thenCallsGetSchema() {
    // Arrange
    VectorSchemaRoot root = mock(VectorSchemaRoot.class);
    doNothing().when(root).setRowCount(anyInt());
    when(root.getSchema()).thenReturn(new Schema(new ArrayList<>()));
    Consumer<Void> batchSignal = mock(Consumer.class);
    doNothing().when(batchSignal).accept(Mockito.<Void>any());
    JsonTableHandler jsonTableHandler = new JsonTableHandler(root, batchSignal, 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    ParseState state = new ParseState();

    // Act
    jsonTableHandler.handlePopArray(lexer, state, new ParseState(), 2);

    // Assert
    verify(batchSignal).accept(isNull());
    verify(root).getSchema();
    verify(root).setRowCount(eq(0));
  }

  /**
   * Test {@link JsonTableHandler#handlePushObject(JsonParser, ParseState, ParseState, int)}.
   * <p>
   * Method under test: {@link JsonTableHandler#handlePushObject(JsonParser, ParseState, ParseState, int)}
   */
  @Test
  @DisplayName("Test handlePushObject(JsonParser, ParseState, ParseState, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handlePushObject(JsonParser, ParseState, ParseState, int)"})
  void testHandlePushObject() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    JsonParserDelegate lexer = new JsonParserDelegate(
        new UTF8StreamJsonParser(ctxt, 2, in, JsonMapper.builder().findAndAddModules().build(), null,
            new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 1, 3, true));
    ParseState state = new ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class, () -> jsonTableHandler.handlePushObject(lexer, state, new ParseState(), 2));
  }

  /**
   * Test {@link JsonTableHandler#handlePushObject(JsonParser, ParseState, ParseState, int)}.
   * <p>
   * Method under test: {@link JsonTableHandler#handlePushObject(JsonParser, ParseState, ParseState, int)}
   */
  @Test
  @DisplayName("Test handlePushObject(JsonParser, ParseState, ParseState, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handlePushObject(JsonParser, ParseState, ParseState, int)"})
  void testHandlePushObject2() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    JsonParserDelegate lexer = new JsonParserDelegate(
        new UTF8StreamJsonParser(ctxt, -1, in, JsonMapper.builder().findAndAddModules().build(), null,
            new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 1, 3, true));
    ParseState state = new ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class, () -> jsonTableHandler.handlePushObject(lexer, state, new ParseState(), 2));
  }

  /**
   * Test {@link JsonTableHandler#handlePushObject(JsonParser, ParseState, ParseState, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then throw {@link JsonParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#handlePushObject(JsonParser, ParseState, ParseState, int)}
   */
  @Test
  @DisplayName("Test handlePushObject(JsonParser, ParseState, ParseState, int); when three; then throw JsonParseException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handlePushObject(JsonParser, ParseState, ParseState, int)"})
  void testHandlePushObject_whenThree_thenThrowJsonParseException() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    ParseState state = new ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class, () -> jsonTableHandler.handlePushObject(lexer, state, new ParseState(), 3));
  }

  /**
   * Test {@link JsonTableHandler#handlePushObject(JsonParser, ParseState, ParseState, int)}.
   * <ul>
   *   <li>When {@link TreeTraversingParser#TreeTraversingParser(JsonNode)} with n is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#handlePushObject(JsonParser, ParseState, ParseState, int)}
   */
  @Test
  @DisplayName("Test handlePushObject(JsonParser, ParseState, ParseState, int); when TreeTraversingParser(JsonNode) with n is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handlePushObject(JsonParser, ParseState, ParseState, int)"})
  void testHandlePushObject_whenTreeTraversingParserWithNIsInstance() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    ParseState state = new ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class, () -> jsonTableHandler.handlePushObject(lexer, state, new ParseState(), 2));
  }

  /**
   * Test {@link JsonTableHandler#handleArrayValue(JsonParser, ParseState, int)}.
   * <p>
   * Method under test: {@link JsonTableHandler#handleArrayValue(JsonParser, ParseState, int)}
   */
  @Test
  @DisplayName("Test handleArrayValue(JsonParser, ParseState, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handleArrayValue(JsonParser, ParseState, int)"})
  void testHandleArrayValue() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();
    JsonParserDelegate lexer = new JsonParserDelegate(
        new UTF8StreamJsonParser(ctxt, 1, in, codec, null, "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> jsonTableHandler.handleArrayValue(lexer, new ParseState(), 2));
  }

  /**
   * Test {@link JsonTableHandler#handleArrayValue(JsonParser, ParseState, int)}.
   * <p>
   * Method under test: {@link JsonTableHandler#handleArrayValue(JsonParser, ParseState, int)}
   */
  @Test
  @DisplayName("Test handleArrayValue(JsonParser, ParseState, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handleArrayValue(JsonParser, ParseState, int)"})
  void testHandleArrayValue2() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();
    JsonParserDelegate lexer = new JsonParserDelegate(
        new UTF8StreamJsonParser(ctxt, -1, in, codec, null, "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> jsonTableHandler.handleArrayValue(lexer, new ParseState(), 2));
  }

  /**
   * Test {@link JsonTableHandler#handleArrayValue(JsonParser, ParseState, int)}.
   * <ul>
   *   <li>When {@link TreeTraversingParser#TreeTraversingParser(JsonNode)} with n is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#handleArrayValue(JsonParser, ParseState, int)}
   */
  @Test
  @DisplayName("Test handleArrayValue(JsonParser, ParseState, int); when TreeTraversingParser(JsonNode) with n is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.handleArrayValue(JsonParser, ParseState, int)"})
  void testHandleArrayValue_whenTreeTraversingParserWithNIsInstance() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> jsonTableHandler.handleArrayValue(lexer, new ParseState(), 2));
  }

  /**
   * Test {@link JsonTableHandler#close()}.
   * <ul>
   *   <li>Given {@link VectorSchemaRoot} {@link VectorSchemaRoot#close()} does nothing.</li>
   *   <li>Then calls {@link VectorSchemaRoot#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonTableHandler#close()}
   */
  @Test
  @DisplayName("Test close(); given VectorSchemaRoot close() does nothing; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JsonTableHandler.close()"})
  void testClose_givenVectorSchemaRootCloseDoesNothing_thenCallsClose() {
    // Arrange
    VectorSchemaRoot root = mock(VectorSchemaRoot.class);
    doNothing().when(root).close();
    when(root.getSchema()).thenReturn(new Schema(new ArrayList<>()));

    // Act
    (new JsonTableHandler(root, mock(Consumer.class), 3, true)).close();

    // Assert
    verify(root).close();
    verify(root).getSchema();
  }
}
