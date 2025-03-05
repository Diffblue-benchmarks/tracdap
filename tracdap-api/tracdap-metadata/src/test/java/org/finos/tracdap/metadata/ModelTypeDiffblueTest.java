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

class ModelTypeDiffblueTest {
  /**
   * Test {@link ModelType#getNumber()}.
   * <ul>
   *   <li>Given {@code STANDARD_MODEL}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'STANDARD_MODEL'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelType.getNumber()"})
  void testGetNumber_givenStandardModel_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ModelType.STANDARD_MODEL.getNumber());
  }

  /**
   * Test {@link ModelType#getNumber()}.
   * <ul>
   *   <li>Given {@link ModelType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ModelType.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ModelType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link ModelType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelType ModelType.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ModelType.valueOf(42));
  }

  /**
   * Test {@link ModelType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code DATA_IMPORT_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'DATA_IMPORT_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelType ModelType.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnDataImportModel() {
    // Arrange, Act and Assert
    assertEquals(ModelType.DATA_IMPORT_MODEL, ModelType.valueOf(1));
  }

  /**
   * Test {@link ModelType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code DATA_EXPORT_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'DATA_EXPORT_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelType ModelType.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnDataExportModel() {
    // Arrange, Act and Assert
    assertEquals(ModelType.DATA_EXPORT_MODEL, ModelType.valueOf(2));
  }

  /**
   * Test {@link ModelType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code STANDARD_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'STANDARD_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelType ModelType.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnStandardModel() {
    // Arrange, Act and Assert
    assertEquals(ModelType.STANDARD_MODEL, ModelType.valueOf(0));
  }

  /**
   * Test {@link ModelType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelType ModelType.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ModelType.forNumber(42));
  }

  /**
   * Test {@link ModelType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code DATA_IMPORT_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'DATA_IMPORT_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelType ModelType.forNumber(int)"})
  void testForNumber_whenOne_thenReturnDataImportModel() {
    // Arrange, Act and Assert
    assertEquals(ModelType.DATA_IMPORT_MODEL, ModelType.forNumber(1));
  }

  /**
   * Test {@link ModelType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code DATA_EXPORT_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'DATA_EXPORT_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelType ModelType.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnDataExportModel() {
    // Arrange, Act and Assert
    assertEquals(ModelType.DATA_EXPORT_MODEL, ModelType.forNumber(2));
  }

  /**
   * Test {@link ModelType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code STANDARD_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'STANDARD_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelType ModelType.forNumber(int)"})
  void testForNumber_whenZero_thenReturnStandardModel() {
    // Arrange, Act and Assert
    assertEquals(ModelType.STANDARD_MODEL, ModelType.forNumber(0));
  }

  /**
   * Test {@link ModelType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ModelType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<ModelType> actualInternalGetValueMapResult = ModelType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link ModelType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code DATA_IMPORT_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'DATA_IMPORT_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ModelType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsDataImportModel() {
    // Arrange and Act
    EnumLiteMap<ModelType> actualInternalGetValueMapResult = ModelType.internalGetValueMap();

    // Assert
    assertEquals(ModelType.DATA_IMPORT_MODEL, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link ModelType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code DATA_EXPORT_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'DATA_EXPORT_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ModelType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsDataExportModel() {
    // Arrange and Act
    EnumLiteMap<ModelType> actualInternalGetValueMapResult = ModelType.internalGetValueMap();

    // Assert
    assertEquals(ModelType.DATA_EXPORT_MODEL, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link ModelType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code STANDARD_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'STANDARD_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ModelType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsStandardModel() {
    // Arrange and Act
    EnumLiteMap<ModelType> actualInternalGetValueMapResult = ModelType.internalGetValueMap();

    // Assert
    assertEquals(ModelType.STANDARD_MODEL, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link ModelType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code STANDARD_MODEL}.</li>
   *   <li>Then return Name is {@code STANDARD_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given 'STANDARD_MODEL'; then return Name is 'STANDARD_MODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ModelType.getValueDescriptor()"})
  void testGetValueDescriptor_givenStandardModel_thenReturnNameIsStandardModel() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = ModelType.STANDARD_MODEL.getValueDescriptor();

    // Assert
    assertEquals("STANDARD_MODEL", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.ModelType.STANDARD_MODEL", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link ModelType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link ModelType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModelType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ModelType.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ModelType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link ModelType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link ModelType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor ModelType.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = ModelType.STANDARD_MODEL.getDescriptorForType();

    // Assert
    assertEquals("ModelType", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.ModelType", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link ModelType#getDescriptor()}.
   * <p>
   * Method under test: {@link ModelType#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor ModelType.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = ModelType.getDescriptor();

    // Assert
    assertEquals("ModelType", actualDescriptor.getName());
    assertEquals("tracdap.metadata.ModelType", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}
