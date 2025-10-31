package org.finos.tracdap.common.data;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.DictionaryEncoding;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.finos.tracdap.common.exception.EDataTypeNotSupported;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.junit.jupiter.api.Test;

class ArrowSchemaDiffblueTest {
  /**
   * Method under test: {@link ArrowSchema#tracToArrow(SchemaDefinition)}
   */
  @Test
  void testTracToArrow() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> ArrowSchema.tracToArrow(SchemaDefinition.getDefaultInstance()));
  }

  /**
   * Method under test: {@link ArrowSchema#arrowToTrac(Schema)}
   */
  @Test
  void testArrowToTrac() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    ArrowType.Binary type = new ArrowType.Binary();
    FieldType fieldType = new FieldType(true, type, new DictionaryEncoding(1L, true, new ArrowType.Int(1, true)));

    fields.add(new Field("Name", fieldType, new ArrayList<>()));

    // Act and Assert
    assertThrows(EDataTypeNotSupported.class, () -> ArrowSchema.arrowToTrac(new Schema(fields)));
  }
}
