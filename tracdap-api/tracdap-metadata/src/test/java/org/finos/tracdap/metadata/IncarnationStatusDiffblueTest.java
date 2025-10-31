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

class IncarnationStatusDiffblueTest {
  /**
   * Test {@link IncarnationStatus#getNumber()}.
   * <ul>
   *   <li>Given {@code INCARNATION_STATUS_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'INCARNATION_STATUS_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int IncarnationStatus.getNumber()"})
  void testGetNumber_givenIncarnationStatusNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, IncarnationStatus.INCARNATION_STATUS_NOT_SET.getNumber());
  }

  /**
   * Test {@link IncarnationStatus#getNumber()}.
   * <ul>
   *   <li>Given {@link IncarnationStatus#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int IncarnationStatus.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> IncarnationStatus.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link IncarnationStatus#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IncarnationStatus IncarnationStatus.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(IncarnationStatus.valueOf(42));
  }

  /**
   * Test {@link IncarnationStatus#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code INCARNATION_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'INCARNATION_AVAILABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IncarnationStatus IncarnationStatus.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnIncarnationAvailable() {
    // Arrange, Act and Assert
    assertEquals(IncarnationStatus.INCARNATION_AVAILABLE, IncarnationStatus.valueOf(1));
  }

  /**
   * Test {@link IncarnationStatus#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code INCARNATION_EXPUNGED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'INCARNATION_EXPUNGED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IncarnationStatus IncarnationStatus.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnIncarnationExpunged() {
    // Arrange, Act and Assert
    assertEquals(IncarnationStatus.INCARNATION_EXPUNGED, IncarnationStatus.valueOf(2));
  }

  /**
   * Test {@link IncarnationStatus#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code INCARNATION_STATUS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'INCARNATION_STATUS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IncarnationStatus IncarnationStatus.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnIncarnationStatusNotSet() {
    // Arrange, Act and Assert
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET, IncarnationStatus.valueOf(0));
  }

  /**
   * Test {@link IncarnationStatus#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IncarnationStatus IncarnationStatus.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(IncarnationStatus.forNumber(42));
  }

  /**
   * Test {@link IncarnationStatus#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code INCARNATION_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'INCARNATION_AVAILABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IncarnationStatus IncarnationStatus.forNumber(int)"})
  void testForNumber_whenOne_thenReturnIncarnationAvailable() {
    // Arrange, Act and Assert
    assertEquals(IncarnationStatus.INCARNATION_AVAILABLE, IncarnationStatus.forNumber(1));
  }

  /**
   * Test {@link IncarnationStatus#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code INCARNATION_EXPUNGED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'INCARNATION_EXPUNGED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IncarnationStatus IncarnationStatus.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnIncarnationExpunged() {
    // Arrange, Act and Assert
    assertEquals(IncarnationStatus.INCARNATION_EXPUNGED, IncarnationStatus.forNumber(2));
  }

  /**
   * Test {@link IncarnationStatus#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code INCARNATION_STATUS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'INCARNATION_STATUS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IncarnationStatus IncarnationStatus.forNumber(int)"})
  void testForNumber_whenZero_thenReturnIncarnationStatusNotSet() {
    // Arrange, Act and Assert
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET, IncarnationStatus.forNumber(0));
  }

  /**
   * Test {@link IncarnationStatus#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap IncarnationStatus.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<IncarnationStatus> actualInternalGetValueMapResult = IncarnationStatus.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link IncarnationStatus#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code INCARNATION_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'INCARNATION_AVAILABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap IncarnationStatus.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsIncarnationAvailable() {
    // Arrange and Act
    EnumLiteMap<IncarnationStatus> actualInternalGetValueMapResult = IncarnationStatus.internalGetValueMap();

    // Assert
    assertEquals(IncarnationStatus.INCARNATION_AVAILABLE, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link IncarnationStatus#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code INCARNATION_EXPUNGED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'INCARNATION_EXPUNGED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap IncarnationStatus.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsIncarnationExpunged() {
    // Arrange and Act
    EnumLiteMap<IncarnationStatus> actualInternalGetValueMapResult = IncarnationStatus.internalGetValueMap();

    // Assert
    assertEquals(IncarnationStatus.INCARNATION_EXPUNGED, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link IncarnationStatus#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code INCARNATION_STATUS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'INCARNATION_STATUS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap IncarnationStatus.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsIncarnationStatusNotSet() {
    // Arrange and Act
    EnumLiteMap<IncarnationStatus> actualInternalGetValueMapResult = IncarnationStatus.internalGetValueMap();

    // Assert
    assertEquals(IncarnationStatus.INCARNATION_STATUS_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link IncarnationStatus#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link IncarnationStatus#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor IncarnationStatus.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> IncarnationStatus.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link IncarnationStatus#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code INCARNATION_STATUS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncarnationStatus#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); then return Name is 'INCARNATION_STATUS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor IncarnationStatus.getValueDescriptor()"})
  void testGetValueDescriptor_thenReturnNameIsIncarnationStatusNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = IncarnationStatus.INCARNATION_STATUS_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("INCARNATION_STATUS_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.IncarnationStatus.INCARNATION_STATUS_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link IncarnationStatus#getDescriptorForType()}.
   * <p>
   * Method under test: {@link IncarnationStatus#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor IncarnationStatus.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = IncarnationStatus.INCARNATION_STATUS_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("IncarnationStatus", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.IncarnationStatus", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(1, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link IncarnationStatus#getDescriptor()}.
   * <p>
   * Method under test: {@link IncarnationStatus#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor IncarnationStatus.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = IncarnationStatus.getDescriptor();

    // Assert
    assertEquals("IncarnationStatus", actualDescriptor.getName());
    assertEquals("tracdap.metadata.IncarnationStatus", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}
