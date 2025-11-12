package org.finos.tracdap.common.data;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.ArrowType.Binary;
import org.apache.arrow.vector.types.pojo.ArrowType.Int;
import org.apache.arrow.vector.types.pojo.DictionaryEncoding;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.finos.tracdap.common.exception.EDataTypeNotSupported;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.metadata.BasicType;
import org.finos.tracdap.metadata.FieldSchema;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.finos.tracdap.metadata.StructSchema;
import org.finos.tracdap.metadata.TableSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ArrowSchemaDiffblueTest {
  /**
   * Test {@link ArrowSchema#tracToArrow(SchemaDefinition)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link ArrowSchema#tracToArrow(SchemaDefinition)}
   */
  @Test
  @DisplayName("Test tracToArrow(SchemaDefinition); when DefaultInstance; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema ArrowSchema.tracToArrow(SchemaDefinition)"})
  void testTracToArrow_whenDefaultInstance_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class, () -> ArrowSchema.tracToArrow(SchemaDefinition.getDefaultInstance()));
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   *
   * <p>Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    FieldType fieldType =
        new FieldType(
            true,
            ArrowSchema.ARROW_BASIC_BOOLEAN,
            new DictionaryEncoding(1L, true, new Int(1, true)));
    Field field = new Field("Name", fieldType, new ArrayList<>());
    fields.add(field);
    FieldType fieldType2 =
        new FieldType(
            false,
            ArrowSchema.ARROW_BASIC_BOOLEAN,
            new DictionaryEncoding(1L, true, new Int(1, true)));
    Field field2 = new Field("Name", fieldType2, new ArrayList<>());
    fields.add(field2);

    // Act
    SchemaDefinition actualArrowToTracResult = ArrowSchema.arrowToTrac(new Schema(fields));

    // Assert
    TableSchema table = actualArrowToTracResult.getTable();
    assertEquals(2, table.getFieldsList().size());
    assertEquals(2, table.getFieldsCount());
    assertEquals(26, table.getSerializedSize());
    assertEquals(30, actualArrowToTracResult.getSerializedSize());
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   *
   * <ul>
   *   <li>Then return DescriptorForType Oneofs size is one.
   * </ul>
   *
   * <p>Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema); then return DescriptorForType Oneofs size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_thenReturnDescriptorForTypeOneofsSizeIsOne() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    Schema arrowSchema = new Schema(fields, new HashMap<>());

    // Act
    SchemaDefinition actualArrowToTracResult = ArrowSchema.arrowToTrac(arrowSchema);

    // Assert
    Descriptor descriptorForType = actualArrowToTracResult.getDescriptorForType();
    List<OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    assertEquals(oneofs, descriptorForType.getRealOneofs());
    TableSchema table = actualArrowToTracResult.getTable();
    SchemaDefinition defaultInstanceForType = actualArrowToTracResult.getDefaultInstanceForType();
    TableSchema table2 = defaultInstanceForType.getTable();
    assertEquals(table, table2);
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualArrowToTracResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    StructSchema struct = actualArrowToTracResult.getStruct();
    assertSame(unknownFields, struct.getUnknownFields());
    assertSame(unknownFields, table.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(struct, defaultInstanceForType.getStruct());
    assertSame(struct, defaultInstanceForType.getStructOrBuilder());
    assertSame(struct, actualArrowToTracResult.getStructOrBuilder());
    StructSchema actualDefaultInstanceForType2 = struct.getDefaultInstanceForType();
    assertSame(struct, actualDefaultInstanceForType2);
    assertSame(table2, defaultInstanceForType.getTableOrBuilder());
    assertSame(table2, table.getDefaultInstanceForType());
    assertSame(table, actualArrowToTracResult.getTableOrBuilder());
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   *
   * <ul>
   *   <li>Then return Table FieldsList first FieldTypeValue is two.
   * </ul>
   *
   * <p>Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema); then return Table FieldsList first FieldTypeValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_thenReturnTableFieldsListFirstFieldTypeValueIsTwo() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    FieldType fieldType =
        new FieldType(
            true,
            ArrowSchema.ARROW_BASIC_INTEGER,
            new DictionaryEncoding(1L, true, new Int(1, true)));
    Field field = new Field("Name", fieldType, new ArrayList<>());
    fields.add(field);

    // Act
    SchemaDefinition actualArrowToTracResult = ArrowSchema.arrowToTrac(new Schema(fields));

    // Assert
    TableSchema table = actualArrowToTracResult.getTable();
    List<FieldSchema> fieldsList = table.getFieldsList();
    assertEquals(1, fieldsList.size());
    assertEquals(1, table.getFieldsCount());
    assertEquals(12, table.getSerializedSize());
    FieldSchema getResult = fieldsList.get(0);
    assertEquals(2, getResult.getFieldTypeValue());
    assertEquals(BasicType.INTEGER, getResult.getFieldType());
    assertEquals(Short.SIZE, actualArrowToTracResult.getSerializedSize());
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   *
   * <ul>
   *   <li>Then return Table FieldsList size is one.
   * </ul>
   *
   * <p>Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema); then return Table FieldsList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_thenReturnTableFieldsListSizeIsOne() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    FieldType fieldType =
        new FieldType(
            true,
            ArrowSchema.ARROW_BASIC_BOOLEAN,
            new DictionaryEncoding(1L, true, new Int(1, true)));
    Field field = new Field("Name", fieldType, new ArrayList<>());
    fields.add(field);

    // Act
    SchemaDefinition actualArrowToTracResult = ArrowSchema.arrowToTrac(new Schema(fields));

    // Assert
    TableSchema table = actualArrowToTracResult.getTable();
    assertEquals(1, table.getFieldsList().size());
    assertEquals(1, table.getFieldsCount());
    assertEquals(12, table.getSerializedSize());
    assertEquals(Short.SIZE, actualArrowToTracResult.getSerializedSize());
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   *
   * <ul>
   *   <li>Then return Table FieldsList size is two.
   * </ul>
   *
   * <p>Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema); then return Table FieldsList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_thenReturnTableFieldsListSizeIsTwo() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    FieldType fieldType =
        new FieldType(
            true,
            ArrowSchema.ARROW_BASIC_BOOLEAN,
            new DictionaryEncoding(1L, true, new Int(1, true)));
    Field field = new Field("Name", fieldType, new ArrayList<>());
    fields.add(field);
    FieldType fieldType2 =
        new FieldType(
            true,
            ArrowSchema.ARROW_BASIC_BOOLEAN,
            new DictionaryEncoding(1L, true, new Int(1, true)));
    Field field2 = new Field("Name", fieldType2, new ArrayList<>());
    fields.add(field2);

    // Act
    SchemaDefinition actualArrowToTracResult = ArrowSchema.arrowToTrac(new Schema(fields));

    // Assert
    TableSchema table = actualArrowToTracResult.getTable();
    assertEquals(2, table.getFieldsList().size());
    assertEquals(2, table.getFieldsCount());
    assertEquals(26, table.getSerializedSize());
    assertEquals(30, actualArrowToTracResult.getSerializedSize());
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   *
   * <ul>
   *   <li>Then throw {@link EDataTypeNotSupported}.
   * </ul>
   *
   * <p>Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema); then throw EDataTypeNotSupported")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_thenThrowEDataTypeNotSupported() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    Binary type = new Binary();
    FieldType fieldType =
        new FieldType(true, type, new DictionaryEncoding(1L, true, new Int(1, true)));
    Field field = new Field("Name", fieldType, new ArrayList<>());
    fields.add(field);

    // Act and Assert
    assertThrows(EDataTypeNotSupported.class, () -> ArrowSchema.arrowToTrac(new Schema(fields)));
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema(Iterable)} with fields is {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName(
      "Test arrowToTrac(Schema); when Schema(Iterable) with fields is ArrayList(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_whenSchemaWithFieldsIsArrayList_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> ArrowSchema.arrowToTrac(new Schema(new ArrayList<>())));
  }

  /**
   * Test {@link ArrowSchema#createRoot(Schema, BufferAllocator, int)} with {@code arrowSchema},
   * {@code arrowAllocator}, {@code initialCapacity}.
   *
   * <p>Method under test: {@link ArrowSchema#createRoot(Schema, BufferAllocator, int)}
   */
  @Test
  @DisplayName(
      "Test createRoot(Schema, BufferAllocator, int) with 'arrowSchema', 'arrowAllocator', 'initialCapacity'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"VectorSchemaRoot ArrowSchema.createRoot(Schema, BufferAllocator, int)"})
  void testCreateRootWithArrowSchemaArrowAllocatorInitialCapacity() {
    // Arrange
    Schema arrowSchema = new Schema(new ArrayList<>());

    // Act
    VectorSchemaRoot actualCreateRootResult = ArrowSchema.createRoot(arrowSchema, null, 1);

    // Assert
    assertEquals(0, actualCreateRootResult.getRowCount());
    assertTrue(actualCreateRootResult.getFieldVectors().isEmpty());
    assertEquals(arrowSchema, actualCreateRootResult.getSchema());
  }

  /**
   * Test {@link ArrowSchema#createRoot(Schema, BufferAllocator)} with {@code arrowSchema}, {@code
   * arrowAllocator}.
   *
   * <ul>
   *   <li>Then return RowCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ArrowSchema#createRoot(Schema, BufferAllocator)}
   */
  @Test
  @DisplayName(
      "Test createRoot(Schema, BufferAllocator) with 'arrowSchema', 'arrowAllocator'; then return RowCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"VectorSchemaRoot ArrowSchema.createRoot(Schema, BufferAllocator)"})
  void testCreateRootWithArrowSchemaArrowAllocator_thenReturnRowCountIsZero() {
    // Arrange
    Schema arrowSchema = new Schema(new ArrayList<>());

    // Act
    VectorSchemaRoot actualCreateRootResult = ArrowSchema.createRoot(arrowSchema, null);

    // Assert
    assertEquals(0, actualCreateRootResult.getRowCount());
    assertTrue(actualCreateRootResult.getFieldVectors().isEmpty());
    assertEquals(arrowSchema, actualCreateRootResult.getSchema());
  }
}
