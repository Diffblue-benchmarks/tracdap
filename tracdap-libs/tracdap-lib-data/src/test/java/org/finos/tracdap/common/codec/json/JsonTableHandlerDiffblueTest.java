package org.finos.tracdap.common.codec.json;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.ArrowType.Bool;
import org.apache.arrow.vector.types.pojo.ArrowType.Int;
import org.apache.arrow.vector.types.pojo.DictionaryEncoding;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonTableHandlerDiffblueTest {
  /**
   * Test {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Field} {@link Field#getName()} return {@code foo}.
   *   <li>Then calls {@link Field#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean); given Field getName() return 'foo'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonTableHandler.<init>(VectorSchemaRoot, Consumer, int, boolean)"})
  void testNewJsonTableHandler_givenFieldGetNameReturnFoo_thenCallsGetName() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getName()).thenReturn("foo");

    ArrayList<Field> fieldList = new ArrayList<>();
    FieldType fieldType =
        new FieldType(true, Bool.INSTANCE, new DictionaryEncoding(1L, true, new Int(1, true)));
    Field field2 = new Field("Name", fieldType, new ArrayList<>());
    fieldList.add(field2);
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
   *
   * <ul>
   *   <li>Given {@link Field} {@link Field#getName()} return {@code Name}.
   *   <li>Then calls {@link Field#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean); given Field getName() return 'Name'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link ArrowType.Int#Int(int, boolean)} with bitWidth is one and isSigned is {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean); given Int(int, boolean) with bitWidth is one and isSigned is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonTableHandler.<init>(VectorSchemaRoot, Consumer, int, boolean)"})
  void testNewJsonTableHandler_givenIntWithBitWidthIsOneAndIsSignedIsTrue() {
    // Arrange
    ArrayList<Field> fieldList = new ArrayList<>();
    FieldType fieldType =
        new FieldType(true, Bool.INSTANCE, new DictionaryEncoding(1L, true, new Int(1, true)));
    Field field = new Field("Name", fieldType, new ArrayList<>());
    fieldList.add(field);

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
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getFields()} return {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Schema#getFields()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean); given Schema getFields() return ArrayList(); then calls getFields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link Schema#Schema(Iterable)} with fields is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTableHandler#JsonTableHandler(VectorSchemaRoot, Consumer, int,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new JsonTableHandler(VectorSchemaRoot, Consumer, int, boolean); given Schema(Iterable) with fields is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link JsonTableHandler#close()}.
   *
   * <ul>
   *   <li>Given {@link VectorSchemaRoot} {@link VectorSchemaRoot#close()} does nothing.
   *   <li>Then calls {@link VectorSchemaRoot#close()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonTableHandler#close()}
   */
  @Test
  @DisplayName("Test close(); given VectorSchemaRoot close() does nothing; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonTableHandler.close()"})
  void testClose_givenVectorSchemaRootCloseDoesNothing_thenCallsClose() {
    // Arrange
    VectorSchemaRoot root = mock(VectorSchemaRoot.class);
    doNothing().when(root).close();
    when(root.getSchema()).thenReturn(new Schema(new ArrayList<>()));
    JsonTableHandler jsonTableHandler = new JsonTableHandler(root, mock(Consumer.class), 3, true);

    // Act
    jsonTableHandler.close();

    // Assert
    verify(root).close();
    verify(root).getSchema();
  }
}
