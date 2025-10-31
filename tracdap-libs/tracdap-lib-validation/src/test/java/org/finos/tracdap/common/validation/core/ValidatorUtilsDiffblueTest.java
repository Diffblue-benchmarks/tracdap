package org.finos.tracdap.common.validation.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Any;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat.FieldType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidatorUtilsDiffblueTest {
  /**
   * Test {@link ValidatorUtils#field(Descriptor, int)}.
   * <p>
   * Method under test: {@link ValidatorUtils#field(Descriptor, int)}
   */
  @Test
  @DisplayName("Test field(Descriptor, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldDescriptor ValidatorUtils.field(Descriptor, int)"})
  void testField() {
    // Arrange
    Descriptor msg = Any.getDescriptor();

    // Act
    FieldDescriptor actualFieldResult = ValidatorUtils.field(msg, 1);

    // Assert
    assertEquals("", actualFieldResult.getDefaultValue());
    assertEquals("google.protobuf.Any.type_url", actualFieldResult.getFullName());
    assertEquals("typeUrl", actualFieldResult.getJsonName());
    assertEquals("type_url", actualFieldResult.getName());
    assertNull(actualFieldResult.getContainingOneof());
    assertNull(actualFieldResult.getRealContainingOneof());
    assertEquals(0, actualFieldResult.getIndex());
    assertEquals(1, actualFieldResult.getNumber());
    assertEquals(JavaType.STRING, actualFieldResult.getJavaType());
    assertEquals(Type.STRING, actualFieldResult.getType());
    assertEquals(FieldType.STRING, actualFieldResult.getLiteType());
    assertEquals(WireFormat.JavaType.STRING, actualFieldResult.getLiteJavaType());
    assertFalse(actualFieldResult.hasDefaultValue());
    assertFalse(actualFieldResult.hasPresence());
    assertFalse(actualFieldResult.isExtension());
    assertFalse(actualFieldResult.isMapField());
    assertFalse(actualFieldResult.isPackable());
    assertFalse(actualFieldResult.isPacked());
    assertFalse(actualFieldResult.isRepeated());
    assertFalse(actualFieldResult.isRequired());
    assertTrue(actualFieldResult.isOptional());
    assertSame(msg, actualFieldResult.getContainingType());
  }
}
