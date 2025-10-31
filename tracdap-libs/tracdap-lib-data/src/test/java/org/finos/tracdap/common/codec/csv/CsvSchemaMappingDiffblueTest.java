package org.finos.tracdap.common.codec.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Column;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.ColumnType;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.ArrowType.Binary;
import org.apache.arrow.vector.types.pojo.ArrowType.Int;
import org.apache.arrow.vector.types.pojo.DictionaryEncoding;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.finos.tracdap.common.data.ArrowSchema;
import org.finos.tracdap.common.exception.EDataTypeNotSupported;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CsvSchemaMappingDiffblueTest {
  /**
   * Test {@link CsvSchemaMapping#arrowToCsv(Schema)}.
   * <ul>
   *   <li>Then return Columns next Index is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvSchemaMapping#arrowToCsv(Schema)}
   */
  @Test
  @DisplayName("Test arrowToCsv(Schema); then return Columns next Index is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder CsvSchemaMapping.arrowToCsv(Schema)"})
  void testArrowToCsv_thenReturnColumnsNextIndexIsZero() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    FieldType fieldType = new FieldType(true, ArrowSchema.ARROW_BASIC_BOOLEAN,
        new DictionaryEncoding(1L, true, new Int(1, true)));

    fields.add(new Field("Name", fieldType, new ArrayList<>()));

    // Act
    Builder actualArrowToCsvResult = CsvSchemaMapping.arrowToCsv(new Schema(fields));

    // Assert
    Iterator<Column> columns = actualArrowToCsvResult.getColumns();
    Column nextResult = columns.next();
    assertEquals("", nextResult.getArrayElementSeparator());
    assertEquals("Name", nextResult.getName());
    assertNull(nextResult.getNext());
    assertNull(nextResult.getValueDecorator());
    assertEquals(0, nextResult.getIndex());
    assertEquals(1, actualArrowToCsvResult.size());
    assertEquals(ColumnType.BOOLEAN, nextResult.getType());
    assertFalse(nextResult.isArray());
    assertFalse(columns.hasNext());
  }

  /**
   * Test {@link CsvSchemaMapping#arrowToCsv(Schema)}.
   * <ul>
   *   <li>Then throw {@link EDataTypeNotSupported}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvSchemaMapping#arrowToCsv(Schema)}
   */
  @Test
  @DisplayName("Test arrowToCsv(Schema); then throw EDataTypeNotSupported")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder CsvSchemaMapping.arrowToCsv(Schema)"})
  void testArrowToCsv_thenThrowEDataTypeNotSupported() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    Binary type = new Binary();
    FieldType fieldType = new FieldType(true, type, new DictionaryEncoding(1L, true, new Int(1, true)));

    fields.add(new Field("Name", fieldType, new ArrayList<>()));

    // Act and Assert
    assertThrows(EDataTypeNotSupported.class, () -> CsvSchemaMapping.arrowToCsv(new Schema(fields)));
  }

  /**
   * Test {@link CsvSchemaMapping#arrowToCsv(Schema)}.
   * <ul>
   *   <li>When {@link Schema#Schema(Iterable)} with fields is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CsvSchemaMapping#arrowToCsv(Schema)}
   */
  @Test
  @DisplayName("Test arrowToCsv(Schema); when Schema(Iterable) with fields is ArrayList(); then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder CsvSchemaMapping.arrowToCsv(Schema)"})
  void testArrowToCsv_whenSchemaWithFieldsIsArrayList_thenReturnSizeIsZero() {
    // Arrange and Act
    Builder actualArrowToCsvResult = CsvSchemaMapping.arrowToCsv(new Schema(new ArrayList<>()));

    // Assert
    assertEquals(0, actualArrowToCsvResult.size());
    assertFalse(actualArrowToCsvResult.getColumns().hasNext());
  }
}
