package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;
import org.finos.tracdap.metadata.BasicType;
import org.finos.tracdap.metadata.DateValue;
import org.junit.jupiter.api.Test;

class MetadataCodecDiffblueTest {
  /**
   * Method under test: {@link MetadataCodec#encodeNativeObject(Object, Class)}
   */
  @Test
  void testEncodeNativeObject() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataCodec.encodeNativeObject("Value", clazz));
  }

  /**
   * Method under test: {@link MetadataCodec#encodeValue(Object, BasicType)}
   */
  @Test
  void testEncodeValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> MetadataCodec.encodeValue("Value", BasicType.BASIC_TYPE_NOT_SET));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataCodec#encodeDate(LocalDate)}
   *   <li>{@link MetadataCodec#decodeDate(DateValue)}
   * </ul>
   */
  @Test
  void testEncodeDateAndDecodeDate() {
    // Arrange
    LocalDate date = LocalDate.of(1970, 1, 1);

    // Act and Assert
    assertEquals(date, MetadataCodec.decodeDate(MetadataCodec.encodeDate(date)));
  }
}
