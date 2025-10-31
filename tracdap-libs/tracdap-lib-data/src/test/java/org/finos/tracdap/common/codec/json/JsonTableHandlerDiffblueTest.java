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
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.apache.arrow.vector.types.pojo.DictionaryEncoding;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.finos.tracdap.common.data.ArrowSchema;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JsonTableHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link JsonTableHandler#handlePushArray(JsonParser, JsonStreamParser.ParseState, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandlePushArray() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    JsonStreamParser.ParseState state = new JsonStreamParser.ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> jsonTableHandler.handlePushArray(lexer, state, new JsonStreamParser.ParseState(), 2));
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handlePushArray(JsonParser, JsonStreamParser.ParseState, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandlePushArray2() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ObjectMapper codec = new ObjectMapper();
    JsonParserDelegate lexer = new JsonParserDelegate(
        new UTF8StreamJsonParser(ctxt, 1, in, codec, null, "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));
    JsonStreamParser.ParseState state = new JsonStreamParser.ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> jsonTableHandler.handlePushArray(lexer, state, new JsonStreamParser.ParseState(), 2));
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handlePushArray(JsonParser, JsonStreamParser.ParseState, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandlePushArray3() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ObjectMapper codec = new ObjectMapper();
    JsonParserDelegate lexer = new JsonParserDelegate(
        new UTF8StreamJsonParser(ctxt, -1, in, codec, null, "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));
    JsonStreamParser.ParseState state = new JsonStreamParser.ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> jsonTableHandler.handlePushArray(lexer, state, new JsonStreamParser.ParseState(), 2));
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handlePopArray(JsonParser, JsonStreamParser.ParseState, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandlePopArray() {
    // Arrange
    Consumer<Void> batchSignal = mock(Consumer.class);
    doNothing().when(batchSignal).accept(Mockito.<Void>any());
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()), batchSignal, 3,
        true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    JsonStreamParser.ParseState state = new JsonStreamParser.ParseState();

    // Act
    jsonTableHandler.handlePopArray(lexer, state, new JsonStreamParser.ParseState(), 2);

    // Assert
    verify(batchSignal).accept(isNull());
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handlePopArray(JsonParser, JsonStreamParser.ParseState, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandlePopArray2() {
    // Arrange
    ArrayList<FieldVector> vectors = new ArrayList<>();
    vectors.add(new NullVector());
    VectorSchemaRoot root = new VectorSchemaRoot(vectors);
    Consumer<Void> batchSignal = mock(Consumer.class);
    doNothing().when(batchSignal).accept(Mockito.<Void>any());
    JsonTableHandler jsonTableHandler = new JsonTableHandler(root, batchSignal, 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    JsonStreamParser.ParseState state = new JsonStreamParser.ParseState();

    // Act
    jsonTableHandler.handlePopArray(lexer, state, new JsonStreamParser.ParseState(), 2);

    // Assert
    verify(batchSignal).accept(isNull());
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handlePopArray(JsonParser, JsonStreamParser.ParseState, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandlePopArray3() {
    // Arrange
    VectorSchemaRoot root = mock(VectorSchemaRoot.class);
    doNothing().when(root).setRowCount(anyInt());
    when(root.getSchema()).thenReturn(new Schema(new ArrayList<>()));
    Consumer<Void> batchSignal = mock(Consumer.class);
    doNothing().when(batchSignal).accept(Mockito.<Void>any());
    JsonTableHandler jsonTableHandler = new JsonTableHandler(root, batchSignal, 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    JsonStreamParser.ParseState state = new JsonStreamParser.ParseState();

    // Act
    jsonTableHandler.handlePopArray(lexer, state, new JsonStreamParser.ParseState(), 2);

    // Assert that nothing has changed
    verify(batchSignal).accept(isNull());
    verify(root).getSchema();
    verify(root).setRowCount(eq(0));
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handlePushObject(JsonParser, JsonStreamParser.ParseState, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandlePushObject() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    JsonStreamParser.ParseState state = new JsonStreamParser.ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> jsonTableHandler.handlePushObject(lexer, state, new JsonStreamParser.ParseState(), 2));
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handlePushObject(JsonParser, JsonStreamParser.ParseState, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandlePushObject2() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    JsonParserDelegate lexer = new JsonParserDelegate(new UTF8StreamJsonParser(ctxt, 2, in, new ObjectMapper(), null,
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 1, 3, true));
    JsonStreamParser.ParseState state = new JsonStreamParser.ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> jsonTableHandler.handlePushObject(lexer, state, new JsonStreamParser.ParseState(), 2));
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handlePushObject(JsonParser, JsonStreamParser.ParseState, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandlePushObject3() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    JsonStreamParser.ParseState state = new JsonStreamParser.ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> jsonTableHandler.handlePushObject(lexer, state, new JsonStreamParser.ParseState(), 3));
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handlePushObject(JsonParser, JsonStreamParser.ParseState, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandlePushObject4() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    JsonParserDelegate lexer = new JsonParserDelegate(new UTF8StreamJsonParser(ctxt, -1, in, new ObjectMapper(), null,
        new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 1, 3, true));
    JsonStreamParser.ParseState state = new JsonStreamParser.ParseState();

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> jsonTableHandler.handlePushObject(lexer, state, new JsonStreamParser.ParseState(), 2));
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handleArrayValue(JsonParser, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandleArrayValue() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    JsonParserDelegate lexer = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> jsonTableHandler.handleArrayValue(lexer, new JsonStreamParser.ParseState(), 2));
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handleArrayValue(JsonParser, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandleArrayValue2() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ObjectMapper codec = new ObjectMapper();
    JsonParserDelegate lexer = new JsonParserDelegate(
        new UTF8StreamJsonParser(ctxt, 1, in, codec, null, "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> jsonTableHandler.handleArrayValue(lexer, new JsonStreamParser.ParseState(), 2));
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#handleArrayValue(JsonParser, JsonStreamParser.ParseState, int)}
   */
  @Test
  void testHandleArrayValue3() throws IOException {
    // Arrange
    JsonTableHandler jsonTableHandler = new JsonTableHandler(new VectorSchemaRoot(new ArrayList<>()),
        mock(Consumer.class), 3, true);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ObjectMapper codec = new ObjectMapper();
    JsonParserDelegate lexer = new JsonParserDelegate(
        new UTF8StreamJsonParser(ctxt, -1, in, codec, null, "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> jsonTableHandler.handleArrayValue(lexer, new JsonStreamParser.ParseState(), 2));
  }

  /**
   * Method under test: {@link JsonTableHandler#close()}
   */
  @Test
  void testClose() {
    // Arrange
    VectorSchemaRoot root = mock(VectorSchemaRoot.class);
    doNothing().when(root).close();
    when(root.getSchema()).thenReturn(new Schema(new ArrayList<>()));

    // Act
    (new JsonTableHandler(root, mock(Consumer.class), 3, true)).close();

    // Assert that nothing has changed
    verify(root).close();
    verify(root).getSchema();
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}
   */
  @Test
  void testNewJsonTableHandler() {
    // Arrange
    VectorSchemaRoot root = mock(VectorSchemaRoot.class);
    when(root.getSchema()).thenReturn(new Schema(new ArrayList<>()));

    // Act
    new JsonTableHandler(root, mock(Consumer.class), 3, true);

    // Assert
    verify(root).getSchema();
  }

  /**
   * Method under test:
   * {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}
   */
  @Test
  void testNewJsonTableHandler2() {
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
   * Method under test:
   * {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}
   */
  @Test
  void testNewJsonTableHandler3() {
    // Arrange
    ArrayList<Field> fieldList = new ArrayList<>();
    FieldType fieldType = new FieldType(true, ArrowSchema.ARROW_BASIC_BOOLEAN,
        new DictionaryEncoding(1L, true, new ArrowType.Int(1, true)));

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
   * Method under test:
   * {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}
   */
  @Test
  void testNewJsonTableHandler4() {
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
}
