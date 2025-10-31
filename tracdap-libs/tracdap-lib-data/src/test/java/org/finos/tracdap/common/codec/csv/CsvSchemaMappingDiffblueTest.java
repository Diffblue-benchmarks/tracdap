package org.finos.tracdap.common.codec.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.DictionaryEncoding;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.finos.tracdap.common.data.ArrowSchema;
import org.finos.tracdap.common.exception.EDataTypeNotSupported;
import org.junit.jupiter.api.Test;

class CsvSchemaMappingDiffblueTest {
  /**
   * Method under test: {@link CsvSchemaMapping#arrowToCsv(Schema)}
   */
  @Test
  void testArrowToCsv() {
    // Arrange and Act
    CsvSchema.Builder actualArrowToCsvResult = CsvSchemaMapping.arrowToCsv(new Schema(new ArrayList<>()));

    // Assert
    assertEquals(0, actualArrowToCsvResult.size());
    assertFalse(actualArrowToCsvResult.getColumns().hasNext());
  }

  /**
   * Method under test: {@link CsvSchemaMapping#arrowToCsv(Schema)}
   */
  @Test
  void testArrowToCsv2() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    FieldType fieldType = new FieldType(true, ArrowSchema.ARROW_BASIC_BOOLEAN,
        new DictionaryEncoding(1L, true, new ArrowType.Int(1, true)));

    fields.add(new Field("Name", fieldType, new ArrayList<>()));

    // Act
    CsvSchema.Builder actualArrowToCsvResult = CsvSchemaMapping.arrowToCsv(new Schema(fields));

    // Assert
    Iterator<CsvSchema.Column> columns = actualArrowToCsvResult.getColumns();
    CsvSchema.Column nextResult = columns.next();
    assertEquals("", nextResult.getArrayElementSeparator());
    assertEquals("Name", nextResult.getName());
    assertNull(nextResult.getNext());
    assertNull(nextResult.getValueDecorator());
    assertEquals(0, nextResult.getIndex());
    assertEquals(1, actualArrowToCsvResult.size());
    assertEquals(CsvSchema.ColumnType.BOOLEAN, nextResult.getType());
    assertFalse(nextResult.isArray());
    assertFalse(columns.hasNext());
  }

  /**
   * Method under test: {@link CsvSchemaMapping#arrowToCsv(Schema)}
   */
  @Test
  void testArrowToCsv3() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    FieldType fieldType = new FieldType(true, ArrowSchema.ARROW_BASIC_BOOLEAN,
        new DictionaryEncoding(1L, true, new ArrowType.Int(1, true)));

    fields.add(new Field("Name", fieldType, new ArrayList<>()));
    FieldType fieldType2 = new FieldType(true, ArrowSchema.ARROW_BASIC_BOOLEAN,
        new DictionaryEncoding(1L, true, new ArrowType.Int(1, true)));

    fields.add(new Field("Name", fieldType2, new ArrayList<>()));

    // Act
    CsvSchema.Builder actualArrowToCsvResult = CsvSchemaMapping.arrowToCsv(new Schema(fields));

    // Assert
    Iterator<CsvSchema.Column> columns = actualArrowToCsvResult.getColumns();
    CsvSchema.Column nextResult = columns.next();
    assertEquals("", nextResult.getArrayElementSeparator());
    CsvSchema.Column nextResult2 = columns.next();
    assertEquals("", nextResult2.getArrayElementSeparator());
    assertEquals("Name", nextResult.getName());
    assertEquals("Name", nextResult2.getName());
    assertNull(nextResult.getNext());
    assertNull(nextResult2.getNext());
    assertNull(nextResult.getValueDecorator());
    assertNull(nextResult2.getValueDecorator());
    assertEquals(0, nextResult.getIndex());
    assertEquals(1, nextResult2.getIndex());
    assertEquals(2, actualArrowToCsvResult.size());
    assertEquals(CsvSchema.ColumnType.BOOLEAN, nextResult.getType());
    assertEquals(CsvSchema.ColumnType.BOOLEAN, nextResult2.getType());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(columns.hasNext());
  }

  /**
   * Method under test: {@link CsvSchemaMapping#arrowToCsv(Schema)}
   */
  @Test
  void testArrowToCsv4() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    ArrowType.Binary type = new ArrowType.Binary();
    FieldType fieldType = new FieldType(true, type, new DictionaryEncoding(1L, true, new ArrowType.Int(1, true)));

    fields.add(new Field("Name", fieldType, new ArrayList<>()));

    // Act and Assert
    assertThrows(EDataTypeNotSupported.class, () -> CsvSchemaMapping.arrowToCsv(new Schema(fields)));
  }
}
