package org.finos.tracdap.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowSchema#tracToArrow(SchemaDefinition)}
   */
  @Test
  @DisplayName("Test tracToArrow(SchemaDefinition); when DefaultInstance; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Schema ArrowSchema.tracToArrow(SchemaDefinition)"})
  void testTracToArrow_whenDefaultInstance_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> ArrowSchema.tracToArrow(SchemaDefinition.getDefaultInstance()));
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   * <ul>
   *   <li>Then return DescriptorForType Oneofs size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema); then return DescriptorForType Oneofs size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_thenReturnDescriptorForTypeOneofsSizeIsOne() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();

    // Act
    SchemaDefinition actualArrowToTracResult = ArrowSchema.arrowToTrac(new Schema(fields, new HashMap<>()));

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
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(struct, defaultInstanceForType.getStruct());
    assertSame(struct, defaultInstanceForType.getStructOrBuilder());
    assertSame(struct, actualArrowToTracResult.getStructOrBuilder());
    assertSame(struct, struct.getDefaultInstanceForType());
    assertSame(table2, defaultInstanceForType.getTableOrBuilder());
    assertSame(table2, table.getDefaultInstanceForType());
    assertSame(table, actualArrowToTracResult.getTableOrBuilder());
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   * <ul>
   *   <li>Then return Table FieldsList first FieldTypeValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema); then return Table FieldsList first FieldTypeValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_thenReturnTableFieldsListFirstFieldTypeValueIsOne() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    FieldType fieldType = new FieldType(true, ArrowSchema.ARROW_BASIC_BOOLEAN,
        new DictionaryEncoding(1L, true, new Int(1, true)));

    fields.add(new Field("Name", fieldType, new ArrayList<>()));

    // Act
    SchemaDefinition actualArrowToTracResult = ArrowSchema.arrowToTrac(new Schema(fields));

    // Assert
    TableSchema table = actualArrowToTracResult.getTable();
    List<FieldSchema> fieldsList = table.getFieldsList();
    assertEquals(1, fieldsList.size());
    FieldSchema getResult = fieldsList.get(0);
    assertEquals(1, getResult.getFieldTypeValue());
    assertEquals(1, table.getFieldsCount());
    assertEquals(12, table.getSerializedSize());
    assertEquals(BasicType.BOOLEAN, getResult.getFieldType());
    assertFalse(getResult.getNotNull());
    assertEquals(Short.SIZE, actualArrowToTracResult.getSerializedSize());
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   * <ul>
   *   <li>Then return Table FieldsList first FieldTypeValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema); then return Table FieldsList first FieldTypeValue is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_thenReturnTableFieldsListFirstFieldTypeValueIsTwo() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    FieldType fieldType = new FieldType(true, ArrowSchema.ARROW_BASIC_INTEGER,
        new DictionaryEncoding(1L, true, new Int(1, true)));

    fields.add(new Field("Name", fieldType, new ArrayList<>()));

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
    assertFalse(getResult.getNotNull());
    assertEquals(Short.SIZE, actualArrowToTracResult.getSerializedSize());
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   * <ul>
   *   <li>Then return Table FieldsList first NotNull.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema); then return Table FieldsList first NotNull")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_thenReturnTableFieldsListFirstNotNull() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    FieldType fieldType = new FieldType(false, ArrowSchema.ARROW_BASIC_BOOLEAN,
        new DictionaryEncoding(1L, true, new Int(1, true)));

    fields.add(new Field("Name", fieldType, new ArrayList<>()));

    // Act
    SchemaDefinition actualArrowToTracResult = ArrowSchema.arrowToTrac(new Schema(fields));

    // Assert
    TableSchema table = actualArrowToTracResult.getTable();
    List<FieldSchema> fieldsList = table.getFieldsList();
    assertEquals(1, fieldsList.size());
    FieldSchema getResult = fieldsList.get(0);
    assertEquals(1, getResult.getFieldTypeValue());
    assertEquals(1, table.getFieldsCount());
    assertEquals(12, table.getSerializedSize());
    assertEquals(BasicType.BOOLEAN, getResult.getFieldType());
    assertTrue(getResult.getNotNull());
    assertEquals(Short.SIZE, actualArrowToTracResult.getSerializedSize());
  }

  /**
   * Test {@link ArrowSchema#arrowToTrac(Schema)}.
   * <ul>
   *   <li>Then return Table FieldsList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema); then return Table FieldsList size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_thenReturnTableFieldsListSizeIsTwo() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    FieldType fieldType = new FieldType(true, ArrowSchema.ARROW_BASIC_BOOLEAN,
        new DictionaryEncoding(1L, true, new Int(1, true)));

    fields.add(new Field("Name", fieldType, new ArrayList<>()));
    FieldType fieldType2 = new FieldType(true, ArrowSchema.ARROW_BASIC_BOOLEAN,
        new DictionaryEncoding(1L, true, new Int(1, true)));

    fields.add(new Field("Name", fieldType2, new ArrayList<>()));

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
   * <ul>
   *   <li>Then throw {@link EDataTypeNotSupported}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  @DisplayName("Test arrowToTrac(Schema); then throw EDataTypeNotSupported")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition ArrowSchema.arrowToTrac(Schema)"})
  void testArrowToTrac_thenThrowEDataTypeNotSupported() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    Binary type = new Binary();
    FieldType fieldType = new FieldType(true, type, new DictionaryEncoding(1L, true, new Int(1, true)));

    fields.add(new Field("Name", fieldType, new ArrayList<>()));

    // Act and Assert
    assertThrows(EDataTypeNotSupported.class, () -> ArrowSchema.arrowToTrac(new Schema(fields)));
  }
}
