package org.finos.tracdap.config;

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

class DeploymentLayoutDiffblueTest {
  /**
   * Test {@link DeploymentLayout#getNumber()}.
   * <ul>
   *   <li>Given {@code LAYOUT_NOT_SET}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'LAYOUT_NOT_SET'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DeploymentLayout.getNumber()"})
  void testGetNumber_givenLayoutNotSet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, DeploymentLayout.LAYOUT_NOT_SET.getNumber());
  }

  /**
   * Test {@link DeploymentLayout#getNumber()}.
   * <ul>
   *   <li>Given {@link DeploymentLayout#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DeploymentLayout.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DeploymentLayout.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link DeploymentLayout#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeploymentLayout DeploymentLayout.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DeploymentLayout.valueOf(42));
  }

  /**
   * Test {@link DeploymentLayout#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code SANDBOX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'SANDBOX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeploymentLayout DeploymentLayout.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnSandbox() {
    // Arrange, Act and Assert
    assertEquals(DeploymentLayout.SANDBOX, DeploymentLayout.valueOf(1));
  }

  /**
   * Test {@link DeploymentLayout#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code CUSTOM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'CUSTOM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeploymentLayout DeploymentLayout.valueOf(int)"})
  void testValueOfWithValue_whenThree_thenReturnCustom() {
    // Arrange, Act and Assert
    assertEquals(DeploymentLayout.CUSTOM, DeploymentLayout.valueOf(3));
  }

  /**
   * Test {@link DeploymentLayout#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code HOSTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'HOSTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeploymentLayout DeploymentLayout.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnHosted() {
    // Arrange, Act and Assert
    assertEquals(DeploymentLayout.HOSTED, DeploymentLayout.valueOf(2));
  }

  /**
   * Test {@link DeploymentLayout#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code LAYOUT_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'LAYOUT_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeploymentLayout DeploymentLayout.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnLayoutNotSet() {
    // Arrange, Act and Assert
    assertEquals(DeploymentLayout.LAYOUT_NOT_SET, DeploymentLayout.valueOf(0));
  }

  /**
   * Test {@link DeploymentLayout#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeploymentLayout DeploymentLayout.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DeploymentLayout.forNumber(42));
  }

  /**
   * Test {@link DeploymentLayout#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code SANDBOX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'SANDBOX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeploymentLayout DeploymentLayout.forNumber(int)"})
  void testForNumber_whenOne_thenReturnSandbox() {
    // Arrange, Act and Assert
    assertEquals(DeploymentLayout.SANDBOX, DeploymentLayout.forNumber(1));
  }

  /**
   * Test {@link DeploymentLayout#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code CUSTOM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'CUSTOM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeploymentLayout DeploymentLayout.forNumber(int)"})
  void testForNumber_whenThree_thenReturnCustom() {
    // Arrange, Act and Assert
    assertEquals(DeploymentLayout.CUSTOM, DeploymentLayout.forNumber(3));
  }

  /**
   * Test {@link DeploymentLayout#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code HOSTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'HOSTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeploymentLayout DeploymentLayout.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnHosted() {
    // Arrange, Act and Assert
    assertEquals(DeploymentLayout.HOSTED, DeploymentLayout.forNumber(2));
  }

  /**
   * Test {@link DeploymentLayout#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code LAYOUT_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'LAYOUT_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeploymentLayout DeploymentLayout.forNumber(int)"})
  void testForNumber_whenZero_thenReturnLayoutNotSet() {
    // Arrange, Act and Assert
    assertEquals(DeploymentLayout.LAYOUT_NOT_SET, DeploymentLayout.forNumber(0));
  }

  /**
   * Test {@link DeploymentLayout#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code SANDBOX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'SANDBOX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap DeploymentLayout.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsSandbox() {
    // Arrange and Act
    EnumLiteMap<DeploymentLayout> actualInternalGetValueMapResult = DeploymentLayout.internalGetValueMap();

    // Assert
    assertEquals(DeploymentLayout.SANDBOX, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link DeploymentLayout#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link PlatformConfig#TENANTS_FIELD_NUMBER} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber TENANTS_FIELD_NUMBER is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap DeploymentLayout.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTenants_field_numberIsNull() {
    // Arrange and Act
    EnumLiteMap<DeploymentLayout> actualInternalGetValueMapResult = DeploymentLayout.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(PlatformConfig.TENANTS_FIELD_NUMBER));
  }

  /**
   * Test {@link DeploymentLayout#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code CUSTOM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'CUSTOM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap DeploymentLayout.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsCustom() {
    // Arrange and Act
    EnumLiteMap<DeploymentLayout> actualInternalGetValueMapResult = DeploymentLayout.internalGetValueMap();

    // Assert
    assertEquals(DeploymentLayout.CUSTOM, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link DeploymentLayout#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code HOSTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'HOSTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap DeploymentLayout.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsHosted() {
    // Arrange and Act
    EnumLiteMap<DeploymentLayout> actualInternalGetValueMapResult = DeploymentLayout.internalGetValueMap();

    // Assert
    assertEquals(DeploymentLayout.HOSTED, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link DeploymentLayout#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code LAYOUT_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'LAYOUT_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap DeploymentLayout.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsLayoutNotSet() {
    // Arrange and Act
    EnumLiteMap<DeploymentLayout> actualInternalGetValueMapResult = DeploymentLayout.internalGetValueMap();

    // Assert
    assertEquals(DeploymentLayout.LAYOUT_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link DeploymentLayout#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@code LAYOUT_NOT_SET}.</li>
   *   <li>Then return Name is {@code LAYOUT_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given 'LAYOUT_NOT_SET'; then return Name is 'LAYOUT_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor DeploymentLayout.getValueDescriptor()"})
  void testGetValueDescriptor_givenLayoutNotSet_thenReturnNameIsLayoutNotSet() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = DeploymentLayout.LAYOUT_NOT_SET.getValueDescriptor();

    // Assert
    assertEquals("LAYOUT_NOT_SET", actualValueDescriptor.getName());
    assertEquals("tracdap.config.DeploymentLayout.LAYOUT_NOT_SET", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link DeploymentLayout#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link DeploymentLayout#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeploymentLayout#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor DeploymentLayout.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> DeploymentLayout.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link DeploymentLayout#getDescriptorForType()}.
   * <p>
   * Method under test: {@link DeploymentLayout#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor DeploymentLayout.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = DeploymentLayout.LAYOUT_NOT_SET.getDescriptorForType();

    // Assert
    assertEquals("DeploymentLayout", actualDescriptorForType.getName());
    assertEquals("tracdap.config.DeploymentLayout", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(1, actualDescriptorForType.getIndex());
    assertEquals(4, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link DeploymentLayout#getDescriptor()}.
   * <p>
   * Method under test: {@link DeploymentLayout#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor DeploymentLayout.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = DeploymentLayout.getDescriptor();

    // Assert
    assertEquals("DeploymentLayout", actualDescriptor.getName());
    assertEquals("tracdap.config.DeploymentLayout", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(1, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}
