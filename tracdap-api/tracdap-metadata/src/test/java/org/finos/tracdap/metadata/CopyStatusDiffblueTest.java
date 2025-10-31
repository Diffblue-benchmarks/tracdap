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

class CopyStatusDiffblueTest {
  /**
   * Test {@link CopyStatus#getNumber()}.
   * <ul>
   *   <li>Given {@code COPY_STATUS_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'COPY_STATUS_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CopyStatus.getNumber()"})
  void testGetNumber_givenCopyStatusNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, CopyStatus.COPY_STATUS_NOT_SET.getNumber());
  }

  /**
   * Test {@link CopyStatus#getNumber()}.
   * <ul>
   *   <li>Given {@link CopyStatus#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CopyStatus.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CopyStatus.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link CopyStatus#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CopyStatus CopyStatus.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(CopyStatus.valueOf(42));
  }

  /**
   * Test {@link CopyStatus#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code COPY_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'COPY_AVAILABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CopyStatus CopyStatus.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnCopyAvailable() {
    // Arrange, Act and Assert
    assertEquals(CopyStatus.COPY_AVAILABLE, CopyStatus.valueOf(1));
  }

  /**
   * Test {@link CopyStatus#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code COPY_EXPUNGED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'COPY_EXPUNGED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CopyStatus CopyStatus.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnCopyExpunged() {
    // Arrange, Act and Assert
    assertEquals(CopyStatus.COPY_EXPUNGED, CopyStatus.valueOf(2));
  }

  /**
   * Test {@link CopyStatus#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code COPY_STATUS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'COPY_STATUS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CopyStatus CopyStatus.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnCopyStatusNotSet() {
    // Arrange, Act and Assert
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, CopyStatus.valueOf(0));
  }

  /**
   * Test {@link CopyStatus#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CopyStatus CopyStatus.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(CopyStatus.forNumber(42));
  }

  /**
   * Test {@link CopyStatus#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code COPY_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'COPY_AVAILABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CopyStatus CopyStatus.forNumber(int)"})
  void testForNumber_whenOne_thenReturnCopyAvailable() {
    // Arrange, Act and Assert
    assertEquals(CopyStatus.COPY_AVAILABLE, CopyStatus.forNumber(1));
  }

  /**
   * Test {@link CopyStatus#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code COPY_EXPUNGED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'COPY_EXPUNGED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CopyStatus CopyStatus.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnCopyExpunged() {
    // Arrange, Act and Assert
    assertEquals(CopyStatus.COPY_EXPUNGED, CopyStatus.forNumber(2));
  }

  /**
   * Test {@link CopyStatus#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code COPY_STATUS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'COPY_STATUS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CopyStatus CopyStatus.forNumber(int)"})
  void testForNumber_whenZero_thenReturnCopyStatusNotSet() {
    // Arrange, Act and Assert
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, CopyStatus.forNumber(0));
  }

  /**
   * Test {@link CopyStatus#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap CopyStatus.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<CopyStatus> actualInternalGetValueMapResult = CopyStatus.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link CopyStatus#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code COPY_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'COPY_AVAILABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap CopyStatus.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsCopyAvailable() {
    // Arrange and Act
    EnumLiteMap<CopyStatus> actualInternalGetValueMapResult = CopyStatus.internalGetValueMap();

    // Assert
    assertEquals(CopyStatus.COPY_AVAILABLE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link CopyStatus#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code COPY_EXPUNGED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'COPY_EXPUNGED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap CopyStatus.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsCopyExpunged() {
    // Arrange and Act
    EnumLiteMap<CopyStatus> actualInternalGetValueMapResult = CopyStatus.internalGetValueMap();

    // Assert
    assertEquals(CopyStatus.COPY_EXPUNGED, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link CopyStatus#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code COPY_STATUS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'COPY_STATUS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap CopyStatus.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsCopyStatusNotSet() {
    // Arrange and Act
    EnumLiteMap<CopyStatus> actualInternalGetValueMapResult = CopyStatus.internalGetValueMap();

    // Assert
    assertEquals(CopyStatus.COPY_STATUS_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link CopyStatus#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code COPY_STATUS_NOT_SET}.</li>
   *   <li>Then return Name is {@code COPY_STATUS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given 'COPY_STATUS_NOT_SET'; then return Name is 'COPY_STATUS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor CopyStatus.getValueDescriptor()"})
  void testGetValueDescriptor_givenCopyStatusNotSet_thenReturnNameIsCopyStatusNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = CopyStatus.COPY_STATUS_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("COPY_STATUS_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.CopyStatus.COPY_STATUS_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link CopyStatus#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link CopyStatus#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CopyStatus#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor CopyStatus.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> CopyStatus.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link CopyStatus#getDescriptorForType()}.
   * <p>
   * Method under test: {@link CopyStatus#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor CopyStatus.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = CopyStatus.COPY_STATUS_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("CopyStatus", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.CopyStatus", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link CopyStatus#getDescriptor()}.
   * <p>
   * Method under test: {@link CopyStatus#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor CopyStatus.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = CopyStatus.getDescriptor();

    // Assert
    assertEquals("CopyStatus", actualDescriptor.getName());
    assertEquals("tracdap.metadata.CopyStatus", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}
