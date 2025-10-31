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

class ResourceTypeDiffblueTest {
  /**
   * Test {@link ResourceType#getNumber()}.
   * <ul>
   *   <li>Given {@code RESOURCE_TYPE_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'RESOURCE_TYPE_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ResourceType.getNumber()"})
  void testGetNumber_givenResourceTypeNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ResourceType.RESOURCE_TYPE_NOT_SET.getNumber());
  }

  /**
   * Test {@link ResourceType#getNumber()}.
   * <ul>
   *   <li>Given {@link ResourceType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ResourceType.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ResourceType.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link ResourceType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceType ResourceType.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ResourceType.valueOf(42));
  }

  /**
   * Test {@link ResourceType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code MODEL_REPOSITORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'MODEL_REPOSITORY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceType ResourceType.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnModelRepository() {
    // Arrange, Act and Assert
    assertEquals(ResourceType.MODEL_REPOSITORY, ResourceType.valueOf(1));
  }

  /**
   * Test {@link ResourceType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code INTERNAL_STORAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'INTERNAL_STORAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceType ResourceType.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnInternalStorage() {
    // Arrange, Act and Assert
    assertEquals(ResourceType.INTERNAL_STORAGE, ResourceType.valueOf(2));
  }

  /**
   * Test {@link ResourceType#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code RESOURCE_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'RESOURCE_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceType ResourceType.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnResourceTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(ResourceType.RESOURCE_TYPE_NOT_SET, ResourceType.valueOf(0));
  }

  /**
   * Test {@link ResourceType#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceType ResourceType.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ResourceType.forNumber(42));
  }

  /**
   * Test {@link ResourceType#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code MODEL_REPOSITORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'MODEL_REPOSITORY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceType ResourceType.forNumber(int)"})
  void testForNumber_whenOne_thenReturnModelRepository() {
    // Arrange, Act and Assert
    assertEquals(ResourceType.MODEL_REPOSITORY, ResourceType.forNumber(1));
  }

  /**
   * Test {@link ResourceType#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code INTERNAL_STORAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'INTERNAL_STORAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceType ResourceType.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnInternalStorage() {
    // Arrange, Act and Assert
    assertEquals(ResourceType.INTERNAL_STORAGE, ResourceType.forNumber(2));
  }

  /**
   * Test {@link ResourceType#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code RESOURCE_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'RESOURCE_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceType ResourceType.forNumber(int)"})
  void testForNumber_whenZero_thenReturnResourceTypeNotSet() {
    // Arrange, Act and Assert
    assertEquals(ResourceType.RESOURCE_TYPE_NOT_SET, ResourceType.forNumber(0));
  }

  /**
   * Test {@link ResourceType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ResourceType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<ResourceType> actualInternalGetValueMapResult = ResourceType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link ResourceType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code MODEL_REPOSITORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'MODEL_REPOSITORY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ResourceType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsModelRepository() {
    // Arrange and Act
    EnumLiteMap<ResourceType> actualInternalGetValueMapResult = ResourceType.internalGetValueMap();

    // Assert
    assertEquals(ResourceType.MODEL_REPOSITORY, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link ResourceType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code INTERNAL_STORAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'INTERNAL_STORAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ResourceType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsInternalStorage() {
    // Arrange and Act
    EnumLiteMap<ResourceType> actualInternalGetValueMapResult = ResourceType.internalGetValueMap();

    // Assert
    assertEquals(ResourceType.INTERNAL_STORAGE, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link ResourceType#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code RESOURCE_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'RESOURCE_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap ResourceType.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsResourceTypeNotSet() {
    // Arrange and Act
    EnumLiteMap<ResourceType> actualInternalGetValueMapResult = ResourceType.internalGetValueMap();

    // Assert
    assertEquals(ResourceType.RESOURCE_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link ResourceType#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link ResourceType#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ResourceType.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ResourceType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link ResourceType#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code RESOURCE_TYPE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceType#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); then return Name is 'RESOURCE_TYPE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor ResourceType.getValueDescriptor()"})
  void testGetValueDescriptor_thenReturnNameIsResourceTypeNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = ResourceType.RESOURCE_TYPE_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("RESOURCE_TYPE_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.ResourceType.RESOURCE_TYPE_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link ResourceType#getDescriptorForType()}.
   * <p>
   * Method under test: {@link ResourceType#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor ResourceType.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = ResourceType.RESOURCE_TYPE_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("ResourceType", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.ResourceType", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(3, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link ResourceType#getDescriptor()}.
   * <p>
   * Method under test: {@link ResourceType#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor ResourceType.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = ResourceType.getDescriptor();

    // Assert
    assertEquals("ResourceType", actualDescriptor.getName());
    assertEquals("tracdap.metadata.ResourceType", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(3, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}
