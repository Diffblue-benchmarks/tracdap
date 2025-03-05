package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLiteMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MetadataFormatDiffblueTest {
  /**
   * Test {@link MetadataFormat#getNumber()}.
   * <ul>
   *   <li>Given {@code METADATA_FORMAT_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'METADATA_FORMAT_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataFormat.getNumber()"})
  void testGetNumber_givenMetadataFormatNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataFormat.METADATA_FORMAT_NOT_SET.getNumber());
  }

  /**
   * Test {@link MetadataFormat#getNumber()}.
   * <ul>
   *   <li>Given {@link MetadataFormat#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataFormat.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataFormat.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link MetadataFormat#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataFormat MetadataFormat.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MetadataFormat.valueOf(42));
  }

  /**
   * Test {@link MetadataFormat#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code PROTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'PROTO'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataFormat MetadataFormat.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnProto() {
    // Arrange, Act and Assert
    assertEquals(MetadataFormat.PROTO, MetadataFormat.valueOf(1));
  }

  /**
   * Test {@link MetadataFormat#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code YAML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'YAML'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataFormat MetadataFormat.valueOf(int)"})
  void testValueOfWithValue_whenThree_thenReturnYaml() {
    // Arrange, Act and Assert
    assertEquals(MetadataFormat.YAML, MetadataFormat.valueOf(3));
  }

  /**
   * Test {@link MetadataFormat#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code JSON}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'JSON'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataFormat MetadataFormat.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnJson() {
    // Arrange, Act and Assert
    assertEquals(MetadataFormat.JSON, MetadataFormat.valueOf(2));
  }

  /**
   * Test {@link MetadataFormat#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code METADATA_FORMAT_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'METADATA_FORMAT_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataFormat MetadataFormat.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnMetadataFormatNotSet() {
    // Arrange, Act and Assert
    assertEquals(MetadataFormat.METADATA_FORMAT_NOT_SET, MetadataFormat.valueOf(0));
  }

  /**
   * Test {@link MetadataFormat#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataFormat MetadataFormat.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MetadataFormat.forNumber(42));
  }

  /**
   * Test {@link MetadataFormat#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code PROTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'PROTO'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataFormat MetadataFormat.forNumber(int)"})
  void testForNumber_whenOne_thenReturnProto() {
    // Arrange, Act and Assert
    assertEquals(MetadataFormat.PROTO, MetadataFormat.forNumber(1));
  }

  /**
   * Test {@link MetadataFormat#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code YAML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'YAML'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataFormat MetadataFormat.forNumber(int)"})
  void testForNumber_whenThree_thenReturnYaml() {
    // Arrange, Act and Assert
    assertEquals(MetadataFormat.YAML, MetadataFormat.forNumber(3));
  }

  /**
   * Test {@link MetadataFormat#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code JSON}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'JSON'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataFormat MetadataFormat.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnJson() {
    // Arrange, Act and Assert
    assertEquals(MetadataFormat.JSON, MetadataFormat.forNumber(2));
  }

  /**
   * Test {@link MetadataFormat#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code METADATA_FORMAT_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'METADATA_FORMAT_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataFormat MetadataFormat.forNumber(int)"})
  void testForNumber_whenZero_thenReturnMetadataFormatNotSet() {
    // Arrange, Act and Assert
    assertEquals(MetadataFormat.METADATA_FORMAT_NOT_SET, MetadataFormat.forNumber(0));
  }

  /**
   * Test {@link MetadataFormat#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MetadataFormat.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<MetadataFormat> actualInternalGetValueMapResult = MetadataFormat.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link MetadataFormat#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code PROTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'PROTO'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MetadataFormat.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsProto() {
    // Arrange and Act
    EnumLiteMap<MetadataFormat> actualInternalGetValueMapResult = MetadataFormat.internalGetValueMap();

    // Assert
    assertEquals(MetadataFormat.PROTO, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link MetadataFormat#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code YAML}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'YAML'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MetadataFormat.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsYaml() {
    // Arrange and Act
    EnumLiteMap<MetadataFormat> actualInternalGetValueMapResult = MetadataFormat.internalGetValueMap();

    // Assert
    assertEquals(MetadataFormat.YAML, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link MetadataFormat#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code JSON}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'JSON'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MetadataFormat.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsJson() {
    // Arrange and Act
    EnumLiteMap<MetadataFormat> actualInternalGetValueMapResult = MetadataFormat.internalGetValueMap();

    // Assert
    assertEquals(MetadataFormat.JSON, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link MetadataFormat#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code METADATA_FORMAT_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'METADATA_FORMAT_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MetadataFormat.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsMetadataFormatNotSet() {
    // Arrange and Act
    EnumLiteMap<MetadataFormat> actualInternalGetValueMapResult = MetadataFormat.internalGetValueMap();

    // Assert
    assertEquals(MetadataFormat.METADATA_FORMAT_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link MetadataFormat#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link MetadataFormat#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor MetadataFormat.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MetadataFormat.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link MetadataFormat#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code METADATA_FORMAT_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataFormat#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); then return Name is 'METADATA_FORMAT_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor MetadataFormat.getValueDescriptor()"})
  void testGetValueDescriptor_thenReturnNameIsMetadataFormatNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = MetadataFormat.METADATA_FORMAT_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("METADATA_FORMAT_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.MetadataFormat.METADATA_FORMAT_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link MetadataFormat#getDescriptorForType()}.
   * <p>
   * Method under test: {@link MetadataFormat#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor MetadataFormat.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = MetadataFormat.METADATA_FORMAT_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("MetadataFormat", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.MetadataFormat", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(4, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link MetadataFormat#getDescriptor()}.
   * <p>
   * Method under test: {@link MetadataFormat#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor MetadataFormat.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = MetadataFormat.getDescriptor();

    // Assert
    assertEquals("MetadataFormat", actualDescriptor.getName());
    assertEquals("tracdap.metadata.MetadataFormat", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}
