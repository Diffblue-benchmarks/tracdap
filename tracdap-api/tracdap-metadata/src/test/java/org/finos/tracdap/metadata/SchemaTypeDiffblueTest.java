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

class SchemaTypeDiffblueTest {
  /**
   * Test {@link SchemaType#getNumber()}.
   * <ul>
   *   <li>Given {@code SCHEMA_TYPE_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'SCHEMA_TYPE_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SchemaType.getNumber()"})
  void testGetNumber_givenSchemaTypeNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, SchemaType.SCHEMA_TYPE_NOT_SET.getNumber());
  }

  /**
   * Test {@link SchemaType#getNumber()}.
   * <ul>
   *   <li>Given {@link SchemaType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SchemaType.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SchemaType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link SchemaType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaType SchemaType.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SchemaType.valueOf(42));
  }

  /**
   * Test {@link SchemaType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code TABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'TABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaType SchemaType.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnTable() {
    // Arrange, Act and Assert
    assertEquals(SchemaType.TABLE, SchemaType.valueOf(1));
  }

  /**
   * Test {@link SchemaType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code STRUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'STRUCT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaType SchemaType.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnStruct() {
    // Arrange, Act and Assert
    assertEquals(SchemaType.STRUCT, SchemaType.valueOf(2));
  }

  /**
   * Test {@link SchemaType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code SCHEMA_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'SCHEMA_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaType SchemaType.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnSchemaTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, SchemaType.valueOf(0));
  }

  /**
   * Test {@link SchemaType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaType SchemaType.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SchemaType.forNumber(42));
  }

  /**
   * Test {@link SchemaType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code TABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'TABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaType SchemaType.forNumber(int)"})
  void testForNumber_whenOne_thenReturnTable() {
    // Arrange, Act and Assert
    assertEquals(SchemaType.TABLE, SchemaType.forNumber(1));
  }

  /**
   * Test {@link SchemaType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code STRUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'STRUCT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaType SchemaType.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnStruct() {
    // Arrange, Act and Assert
    assertEquals(SchemaType.STRUCT, SchemaType.forNumber(2));
  }

  /**
   * Test {@link SchemaType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code SCHEMA_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'SCHEMA_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaType SchemaType.forNumber(int)"})
  void testForNumber_whenZero_thenReturnSchemaTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, SchemaType.forNumber(0));
  }

  /**
   * Test {@link SchemaType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SchemaType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<SchemaType> actualInternalGetValueMapResult = SchemaType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link SchemaType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code TABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'TABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SchemaType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsTable() {
    // Arrange and Act
    EnumLiteMap<SchemaType> actualInternalGetValueMapResult = SchemaType.internalGetValueMap();

    // Assert
    assertEquals(SchemaType.TABLE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link SchemaType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code STRUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'STRUCT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SchemaType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsStruct() {
    // Arrange and Act
    EnumLiteMap<SchemaType> actualInternalGetValueMapResult = SchemaType.internalGetValueMap();

    // Assert
    assertEquals(SchemaType.STRUCT, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link SchemaType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code SCHEMA_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'SCHEMA_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap SchemaType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsSchemaTypeNotSet() {
    // Arrange and Act
    EnumLiteMap<SchemaType> actualInternalGetValueMapResult = SchemaType.internalGetValueMap();

    // Assert
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link SchemaType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code SCHEMA_TYPE_NOT_SET}.</li>
   *   <li>Then return Name is {@code SCHEMA_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given 'SCHEMA_TYPE_NOT_SET'; then return Name is 'SCHEMA_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor SchemaType.getValueDescriptor()"})
  void testGetValueDescriptor_givenSchemaTypeNotSet_thenReturnNameIsSchemaTypeNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = SchemaType.SCHEMA_TYPE_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("SCHEMA_TYPE_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.SchemaType.SCHEMA_TYPE_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link SchemaType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link SchemaType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor SchemaType.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> SchemaType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link SchemaType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link SchemaType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor SchemaType.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = SchemaType.SCHEMA_TYPE_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("SchemaType", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.SchemaType", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link SchemaType#getDescriptor()}.
   * <p>
   * Method under test: {@link SchemaType#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor SchemaType.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = SchemaType.getDescriptor();

    // Assert
    assertEquals("SchemaType", actualDescriptor.getName());
    assertEquals("tracdap.metadata.SchemaType", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}
