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

class MetadataVersionDiffblueTest {
  /**
   * Test {@link MetadataVersion#getNumber()}.
   * <ul>
   *   <li>Given {@code METADATA_VERSION_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'METADATA_VERSION_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataVersion.getNumber()"})
  void testGetNumber_givenMetadataVersionNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataVersion.METADATA_VERSION_NOT_SET.getNumber());
  }

  /**
   * Test {@link MetadataVersion#getNumber()}.
   * <ul>
   *   <li>Given {@link MetadataVersion#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataVersion.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataVersion.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link MetadataVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataVersion MetadataVersion.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MetadataVersion.valueOf(42));
  }

  /**
   * Test {@link MetadataVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code V1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'V1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataVersion MetadataVersion.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnV1() {
    // Arrange, Act and Assert
    assertEquals(MetadataVersion.V1, MetadataVersion.valueOf(1));
  }

  /**
   * Test {@link MetadataVersion#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code METADATA_VERSION_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'METADATA_VERSION_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataVersion MetadataVersion.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnMetadataVersionNotSet() {
    // Arrange, Act and Assert
    assertEquals(MetadataVersion.METADATA_VERSION_NOT_SET, MetadataVersion.valueOf(0));
  }

  /**
   * Test {@link MetadataVersion#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataVersion MetadataVersion.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MetadataVersion.forNumber(42));
  }

  /**
   * Test {@link MetadataVersion#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code V1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'V1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataVersion MetadataVersion.forNumber(int)"})
  void testForNumber_whenOne_thenReturnV1() {
    // Arrange, Act and Assert
    assertEquals(MetadataVersion.V1, MetadataVersion.forNumber(1));
  }

  /**
   * Test {@link MetadataVersion#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code METADATA_VERSION_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'METADATA_VERSION_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataVersion MetadataVersion.forNumber(int)"})
  void testForNumber_whenZero_thenReturnMetadataVersionNotSet() {
    // Arrange, Act and Assert
    assertEquals(MetadataVersion.METADATA_VERSION_NOT_SET, MetadataVersion.forNumber(0));
  }

  /**
   * Test {@link MetadataVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MetadataVersion.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<MetadataVersion> actualInternalGetValueMapResult = MetadataVersion.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link MetadataVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code V1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'V1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MetadataVersion.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsV1() {
    // Arrange and Act
    EnumLiteMap<MetadataVersion> actualInternalGetValueMapResult = MetadataVersion.internalGetValueMap();

    // Assert
    assertEquals(MetadataVersion.V1, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link MetadataVersion#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code METADATA_VERSION_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'METADATA_VERSION_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap MetadataVersion.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsMetadataVersionNotSet() {
    // Arrange and Act
    EnumLiteMap<MetadataVersion> actualInternalGetValueMapResult = MetadataVersion.internalGetValueMap();

    // Assert
    assertEquals(MetadataVersion.METADATA_VERSION_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link MetadataVersion#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link MetadataVersion#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor MetadataVersion.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MetadataVersion.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link MetadataVersion#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code METADATA_VERSION_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataVersion#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); then return Name is 'METADATA_VERSION_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor MetadataVersion.getValueDescriptor()"})
  void testGetValueDescriptor_thenReturnNameIsMetadataVersionNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = MetadataVersion.METADATA_VERSION_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("METADATA_VERSION_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.MetadataVersion.METADATA_VERSION_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link MetadataVersion#getDescriptorForType()}.
   * <p>
   * Method under test: {@link MetadataVersion#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor MetadataVersion.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = MetadataVersion.METADATA_VERSION_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("MetadataVersion", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.MetadataVersion", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(1, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link MetadataVersion#getDescriptor()}.
   * <p>
   * Method under test: {@link MetadataVersion#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor MetadataVersion.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = MetadataVersion.getDescriptor();

    // Assert
    assertEquals("MetadataVersion", actualDescriptor.getName());
    assertEquals("tracdap.metadata.MetadataVersion", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}
