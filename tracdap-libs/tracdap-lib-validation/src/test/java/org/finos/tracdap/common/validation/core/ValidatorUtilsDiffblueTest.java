package org.finos.tracdap.common.validation.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat.FieldType;
import org.finos.tracdap.metadata.ArrayValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidatorUtilsDiffblueTest {
  /**
   * Test {@link ValidatorUtils#field(Descriptor, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return JsonName is {@code items}.
   * </ul>
   *
   * <p>Method under test: {@link ValidatorUtils#field(Descriptor, int)}
   */
  @Test
  @DisplayName("Test field(Descriptor, int); when one; then return JsonName is 'items'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldDescriptor ValidatorUtils.field(Descriptor, int)"})
  void testField_whenOne_thenReturnJsonNameIsItems() {
    // Arrange
    Descriptor msg = ArrayValue.getDescriptor();

    // Act
    FieldDescriptor actualFieldResult = ValidatorUtils.field(msg, 1);

    // Assert
    assertEquals("items", actualFieldResult.getJsonName());
    assertEquals("items", actualFieldResult.getName());
    assertEquals("tracdap.metadata.ArrayValue.items", actualFieldResult.getFullName());
    assertNull(actualFieldResult.getContainingOneof());
    assertNull(actualFieldResult.getRealContainingOneof());
    assertEquals(0, actualFieldResult.getIndex());
    assertEquals(1, actualFieldResult.getNumber());
    assertEquals(JavaType.MESSAGE, actualFieldResult.getJavaType());
    assertEquals(Type.MESSAGE, actualFieldResult.getType());
    assertEquals(FieldType.MESSAGE, actualFieldResult.getLiteType());
    assertEquals(WireFormat.JavaType.MESSAGE, actualFieldResult.getLiteJavaType());
    assertFalse(actualFieldResult.hasDefaultValue());
    assertFalse(actualFieldResult.hasPresence());
    assertFalse(actualFieldResult.isExtension());
    assertFalse(actualFieldResult.isMapField());
    assertFalse(actualFieldResult.isOptional());
    assertFalse(actualFieldResult.isPackable());
    assertFalse(actualFieldResult.isPacked());
    assertFalse(actualFieldResult.isRequired());
    assertTrue(actualFieldResult.isRepeated());
    assertSame(msg, actualFieldResult.getContainingType());
  }

  /**
   * Test {@link ValidatorUtils#field(Descriptor, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidatorUtils#field(Descriptor, int)}
   */
  @Test
  @DisplayName("Test field(Descriptor, int); when zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldDescriptor ValidatorUtils.field(Descriptor, int)"})
  void testField_whenZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ValidatorUtils.field(ArrayValue.getDescriptor(), 0));
  }
}
