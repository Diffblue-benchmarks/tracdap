package org.finos.tracdap.common.validation.static_;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ProtocolMessageEnum;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.BasicType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommonValidatorsDiffblueTest {
  /**
   * Method under test:
   * {@link CommonValidators#primitiveType(BasicType, ValidationContext)}
   */
  @Test
  void testPrimitiveType() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.primitiveType(BasicType.BASIC_TYPE_NOT_SET, ctx);

    // Assert
    verify(ctx).error(eq("Type specified in [Field Name] is not a primitive type: [BASIC_TYPE_NOT_SET]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#primitiveType(BasicType, ValidationContext)}
   */
  @Test
  void testPrimitiveType2() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.primitiveType(BasicType.BASIC_TYPE_NOT_SET, ctx));
    verify(ctx).fieldName();
  }

  /**
   * Method under test: {@link CommonValidators#uuid(String, ValidationContext)}
   */
  @Test
  void testUuid() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.uuid("42", ctx);

    // Assert
    verify(ctx).error(eq("Value of [Field Name] is not a valid object ID: [42]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test: {@link CommonValidators#uuid(String, ValidationContext)}
   */
  @Test
  void testUuid2() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.uuid("42", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#identifier(String, ValidationContext)}
   */
  @Test
  void testIdentifier() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.identifier("42", ctx);

    // Assert
    verify(ctx).error(eq("[Field Name] is not a valid identifier: [42]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#identifier(String, ValidationContext)}
   */
  @Test
  void testIdentifier2() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.identifier("42", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#resourceKey(String, ValidationContext)}
   */
  @Test
  void testResourceKey() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.resourceKey("42", ctx);

    // Assert
    verify(ctx).error(eq("[Field Name] is not a valid resource key: [42]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#resourceKey(String, ValidationContext)}
   */
  @Test
  void testResourceKey2() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.resourceKey("42", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#notTracReserved(String, ValidationContext)}
   */
  @Test
  void testNotTracReserved() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.notTracReserved("trac-U", ctx);

    // Assert
    verify(ctx).error(eq("[Field Name] is a TRAC reserved identifier: [trac-U]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#notTracReserved(String, ValidationContext)}
   */
  @Test
  void testNotTracReserved2() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.notTracReserved("trac-U", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#fileName(String, ValidationContext)}
   */
  @Test
  void testFileName() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.fileName("42", ctx);

    // Assert
    verify(ctx).apply(isA(ValidationFunction.Typed.class));
  }

  /**
   * Method under test:
   * {@link CommonValidators#fileName(String, ValidationContext)}
   */
  @Test
  void testFileName2() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.fieldName()).thenReturn("Field Name");
    when(validationContext.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);

    // Act
    CommonValidators.fileName("U/U", ctx);

    // Assert
    verify(ctx).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext)
        .error(eq("[Field Name] contains characters not allowed in a filename (:, / or \\): [U/U]"));
    verify(validationContext).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#fileName(String, ValidationContext)}
   */
  @Test
  void testFileName3() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.fileName("U/U", ctx));
    verify(ctx).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  void testRelativePath() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(true);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);

    // Act
    CommonValidators.relativePath("Path", ctx);

    // Assert
    verify(ctx).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext).failed();
  }

  /**
   * Method under test:
   * {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  void testRelativePath2() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenThrow(new IllegalArgumentException("U:U"));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.relativePath("Path", ctx));
    verify(ctx).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext).failed();
  }

  /**
   * Method under test:
   * {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  void testRelativePath3() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(true);
    when(validationContext.fieldName()).thenReturn("Field Name");
    when(validationContext.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.fieldName()).thenReturn("Field Name");
    when(validationContext2.error(Mockito.<String>any())).thenReturn(validationContext);
    when(validationContext2.failed()).thenReturn(true);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext2);

    // Act
    CommonValidators.relativePath("U:U", ctx);

    // Assert
    verify(ctx).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext2).error(eq("[Field Name] contains characters not allowed in a relative path (:): [U:U]"));
    verify(validationContext).failed();
    verify(validationContext2).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  void testRelativePath4() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(true);
    when(validationContext.fieldName()).thenReturn("Field Name");
    when(validationContext.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.fieldName()).thenReturn("Field Name");
    when(validationContext2.error(Mockito.<String>any())).thenReturn(validationContext);
    when(validationContext2.failed()).thenReturn(true);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext2);

    // Act
    CommonValidators.relativePath("/", ctx);

    // Assert
    verify(ctx).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext2).error(eq("[Field Name] is an absolute path: [/]"));
    verify(validationContext).failed();
    verify(validationContext2).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  void testRelativePath5() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(false);
    when(validationContext.fieldName()).thenReturn("Field Name");
    when(validationContext.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.fieldName()).thenReturn("Field Name");
    when(validationContext2.error(Mockito.<String>any())).thenReturn(validationContext);
    when(validationContext2.failed()).thenReturn(true);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext2);

    // Act
    CommonValidators.relativePath("U:U", ctx);

    // Assert
    verify(ctx).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext2).error(eq("[Field Name] contains characters not allowed in a relative path (:): [U:U]"));
    verify(validationContext).error(eq("[Field Name] segment contains characters illegal characters: [U:U]"));
    verify(validationContext).failed();
    verify(validationContext2).fieldName();
    verify(validationContext).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#optionalTrue(boolean, ValidationContext)}
   */
  @Test
  void testOptionalTrue() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.optionalTrue(false, ctx);

    // Assert
    verify(ctx).error(eq("Optional field [Field Name] must either be omitted or set to 'true'"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#optionalTrue(boolean, ValidationContext)}
   */
  @Test
  void testOptionalTrue2() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.optionalTrue(false, ctx));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}
   */
  @Test
  void testNonZeroEnum() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.nonZeroEnum(DescriptorProtos.Edition.EDITION_UNKNOWN, ctx);

    // Assert
    verify(ctx).error(eq("Unrecognised value specified for [Field Name]: [EDITION_UNKNOWN]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}
   */
  @Test
  void testNonZeroEnum2() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> CommonValidators.nonZeroEnum(DescriptorProtos.Edition.EDITION_UNKNOWN, ctx));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}
   */
  @Test
  void testNonZeroEnum3() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Unrecognised value specified for [%s]: [%s]");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.nonZeroEnum(DescriptorProtos.ExtensionRangeOptions.VerificationState.DECLARATION, ctx);

    // Assert
    verify(ctx)
        .error(eq("Unrecognised value specified for [Unrecognised value specified for [%s]: [%s]]: [DECLARATION]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}
   */
  @Test
  void testNonZeroEnum4() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("foo");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.nonZeroEnum(DescriptorProtos.ExtensionRangeOptions.VerificationState.DECLARATION, ctx);

    // Assert
    verify(ctx).error(eq("Unrecognised value specified for [foo]: [DECLARATION]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#bytesNotEmpty(ByteString, ValidationContext)}
   */
  @Test
  void testBytesNotEmpty() {
    // Arrange
    ByteString content = mock(ByteString.class);
    when(content.isEmpty()).thenReturn(true);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.bytesNotEmpty(content, ctx);

    // Assert
    verify(content).isEmpty();
    verify(ctx).error(eq("[Field Name] cannot be empty"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#bytesNotEmpty(ByteString, ValidationContext)}
   */
  @Test
  void testBytesNotEmpty2() {
    // Arrange
    ByteString content = mock(ByteString.class);
    when(content.isEmpty()).thenReturn(true);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.bytesNotEmpty(content, ctx));
    verify(content).isEmpty();
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link CommonValidators#bytesNotEmpty(ByteString, ValidationContext)}
   */
  @Test
  void testBytesNotEmpty3() {
    // Arrange
    ByteString content = mock(ByteString.class);
    when(content.isEmpty()).thenReturn(false);

    // Act
    CommonValidators.bytesNotEmpty(content, mock(ValidationContext.class));

    // Assert
    verify(content).isEmpty();
  }
}
