package org.finos.tracdap.common.validation.static_;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.Edition;
import com.google.protobuf.DescriptorProtos.ExtensionRangeOptions;
import com.google.protobuf.DescriptorProtos.ExtensionRangeOptions.VerificationState;
import com.google.protobuf.ProtocolMessageEnum;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.metadata.BasicType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommonValidatorsDiffblueTest {
  /**
   * Test {@link CommonValidators#primitiveType(BasicType, ValidationContext)} with {@code basicType}, {@code ctx}.
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#primitiveType(BasicType, ValidationContext)}
   */
  @Test
  @DisplayName("Test primitiveType(BasicType, ValidationContext) with 'basicType', 'ctx'; given 'Field Name'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.primitiveType(BasicType, ValidationContext)"})
  void testPrimitiveTypeWithBasicTypeCtx_givenFieldName_thenCallsError() {
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
   * Test {@link CommonValidators#primitiveType(BasicType, ValidationContext)} with {@code basicType}, {@code ctx}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#primitiveType(BasicType, ValidationContext)}
   */
  @Test
  @DisplayName("Test primitiveType(BasicType, ValidationContext) with 'basicType', 'ctx'; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.primitiveType(BasicType, ValidationContext)"})
  void testPrimitiveTypeWithBasicTypeCtx_thenThrowETracInternal() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.primitiveType(BasicType.BASIC_TYPE_NOT_SET, ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#uuid(String, ValidationContext)}.
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#uuid(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test uuid(String, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.uuid(String, ValidationContext)"})
  void testUuid_givenFieldName_thenCallsError() {
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
   * Test {@link CommonValidators#uuid(String, ValidationContext)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#uuid(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test uuid(String, ValidationContext); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.uuid(String, ValidationContext)"})
  void testUuid_thenThrowETracInternal() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.uuid("42", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#identifier(String, ValidationContext)}.
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#identifier(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test identifier(String, ValidationContext); given 'Field Name'; when '42'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.identifier(String, ValidationContext)"})
  void testIdentifier_givenFieldName_when42_thenCallsError() {
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
   * Test {@link CommonValidators#identifier(String, ValidationContext)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#identifier(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test identifier(String, ValidationContext); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.identifier(String, ValidationContext)"})
  void testIdentifier_thenThrowETracInternal() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.identifier("42", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#resourceKey(String, ValidationContext)}.
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#resourceKey(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test resourceKey(String, ValidationContext); given 'Field Name'; when '42'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.resourceKey(String, ValidationContext)"})
  void testResourceKey_givenFieldName_when42_thenCallsError() {
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
   * Test {@link CommonValidators#resourceKey(String, ValidationContext)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#resourceKey(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test resourceKey(String, ValidationContext); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.resourceKey(String, ValidationContext)"})
  void testResourceKey_thenThrowETracInternal() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.resourceKey("42", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#notTracReserved(String, ValidationContext)}.
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#notTracReserved(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test notTracReserved(String, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.notTracReserved(String, ValidationContext)"})
  void testNotTracReserved_givenFieldName_thenCallsError() {
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
   * Test {@link CommonValidators#notTracReserved(String, ValidationContext)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#notTracReserved(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test notTracReserved(String, ValidationContext); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.notTracReserved(String, ValidationContext)"})
  void testNotTracReserved_thenThrowETracInternal() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.notTracReserved("trac-U", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#fileName(String, ValidationContext)}.
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#fieldName()} return {@code Field Name}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#fileName(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test fileName(String, ValidationContext); given ValidationContext fieldName() return 'Field Name'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.fileName(String, ValidationContext)"})
  void testFileName_givenValidationContextFieldNameReturnFieldName_thenCallsError() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.fieldName()).thenReturn("Field Name");
    when(validationContext.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    // Act
    CommonValidators.fileName("U/U", ctx);

    // Assert
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext)
        .error(eq("[Field Name] contains characters not allowed in a filename (:, / or \\): [U/U]"));
    verify(validationContext).fieldName();
  }

  /**
   * Test {@link CommonValidators#fileName(String, ValidationContext)}.
   * <ul>
   *   <li>Given {@link ValidationContext}.</li>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#fileName(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test fileName(String, ValidationContext); given ValidationContext; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.fileName(String, ValidationContext)"})
  void testFileName_givenValidationContext_when42() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.fileName("42", ctx);

    // Assert
    verify(ctx).apply(isA(Typed.class));
  }

  /**
   * Test {@link CommonValidators#fileName(String, ValidationContext)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#fileName(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test fileName(String, ValidationContext); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.fileName(String, ValidationContext)"})
  void testFileName_thenThrowETracInternal() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.fileName("U/U", ctx));
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext).fieldName();
  }

  /**
   * Test {@link CommonValidators#relativePath(String, ValidationContext)}.
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code false}.</li>
   *   <li>When {@code U:U}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test relativePath(String, ValidationContext); given ValidationContext failed() return 'false'; when 'U:U'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_givenValidationContextFailedReturnFalse_whenUU_thenCallsError() {
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
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext2);

    // Act
    CommonValidators.relativePath("U:U", ctx);

    // Assert
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext2).error(eq("[Field Name] contains characters not allowed in a relative path (:): [U:U]"));
    verify(validationContext).error(eq("[Field Name] segment contains characters illegal characters: [U:U]"));
    verify(validationContext).failed();
    verify(validationContext2).fieldName();
    verify(validationContext).fieldName();
  }

  /**
   * Test {@link CommonValidators#relativePath(String, ValidationContext)}.
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code true}.</li>
   *   <li>When {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test relativePath(String, ValidationContext); given ValidationContext failed() return 'true'; when 'Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_givenValidationContextFailedReturnTrue_whenPath() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(true);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    // Act
    CommonValidators.relativePath("Path", ctx);

    // Assert
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext).failed();
  }

  /**
   * Test {@link CommonValidators#relativePath(String, ValidationContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test relativePath(String, ValidationContext); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_thenThrowIllegalArgumentException() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenThrow(new IllegalArgumentException("U:U"));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.relativePath("Path", ctx));
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext).failed();
  }

  /**
   * Test {@link CommonValidators#relativePath(String, ValidationContext)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test relativePath(String, ValidationContext); when '/'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_whenSlash_thenCallsError() {
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
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext2);

    // Act
    CommonValidators.relativePath("/", ctx);

    // Assert
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext2).error(eq("[Field Name] is an absolute path: [/]"));
    verify(validationContext).failed();
    verify(validationContext2).fieldName();
  }

  /**
   * Test {@link CommonValidators#relativePath(String, ValidationContext)}.
   * <ul>
   *   <li>When {@code U:U}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test relativePath(String, ValidationContext); when 'U:U'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_whenUU_thenCallsError() {
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
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext2);

    // Act
    CommonValidators.relativePath("U:U", ctx);

    // Assert
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext2).error(eq("[Field Name] contains characters not allowed in a relative path (:): [U:U]"));
    verify(validationContext).failed();
    verify(validationContext2).fieldName();
  }

  /**
   * Test {@link CommonValidators#optionalTrue(boolean, ValidationContext)}.
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#optionalTrue(boolean, ValidationContext)}
   */
  @Test
  @DisplayName("Test optionalTrue(boolean, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.optionalTrue(boolean, ValidationContext)"})
  void testOptionalTrue_givenFieldName_thenCallsError() {
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
   * Test {@link CommonValidators#optionalTrue(boolean, ValidationContext)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#optionalTrue(boolean, ValidationContext)}
   */
  @Test
  @DisplayName("Test optionalTrue(boolean, ValidationContext); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.optionalTrue(boolean, ValidationContext)"})
  void testOptionalTrue_thenThrowETracInternal() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.optionalTrue(false, ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}.
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>When {@link ValidationContext} {@link ValidationContext#fieldName()} return {@code Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}
   */
  @Test
  @DisplayName("Test nonZeroEnum(ProtocolMessageEnum, ValidationContext); given 'Field Name'; when ValidationContext fieldName() return 'Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.nonZeroEnum(ProtocolMessageEnum, ValidationContext)"})
  void testNonZeroEnum_givenFieldName_whenValidationContextFieldNameReturnFieldName() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.nonZeroEnum(Edition.EDITION_UNKNOWN, ctx);

    // Assert
    verify(ctx).error(eq("Unrecognised value specified for [Field Name]: [EDITION_UNKNOWN]"));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ValidationContext} {@link ValidationContext#fieldName()} return {@code foo}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}
   */
  @Test
  @DisplayName("Test nonZeroEnum(ProtocolMessageEnum, ValidationContext); given 'foo'; when ValidationContext fieldName() return 'foo'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.nonZeroEnum(ProtocolMessageEnum, ValidationContext)"})
  void testNonZeroEnum_givenFoo_whenValidationContextFieldNameReturnFoo_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("foo");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.nonZeroEnum(VerificationState.DECLARATION, ctx);

    // Assert
    verify(ctx).error(eq("Unrecognised value specified for [foo]: [DECLARATION]"));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}.
   * <ul>
   *   <li>Given {@code Unrecognised value specified for [%s]: [%s]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}
   */
  @Test
  @DisplayName("Test nonZeroEnum(ProtocolMessageEnum, ValidationContext); given 'Unrecognised value specified for [%s]: [%s]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.nonZeroEnum(ProtocolMessageEnum, ValidationContext)"})
  void testNonZeroEnum_givenUnrecognisedValueSpecifiedForSS() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Unrecognised value specified for [%s]: [%s]");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.nonZeroEnum(VerificationState.DECLARATION, ctx);

    // Assert
    verify(ctx)
        .error(eq("Unrecognised value specified for [Unrecognised value specified for [%s]: [%s]]: [DECLARATION]"));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}
   */
  @Test
  @DisplayName("Test nonZeroEnum(ProtocolMessageEnum, ValidationContext); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.nonZeroEnum(ProtocolMessageEnum, ValidationContext)"})
  void testNonZeroEnum_thenThrowETracInternal() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.nonZeroEnum(Edition.EDITION_UNKNOWN, ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#bytesNotEmpty(ByteString, ValidationContext)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link ByteString} {@link ByteString#isEmpty()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#bytesNotEmpty(ByteString, ValidationContext)}
   */
  @Test
  @DisplayName("Test bytesNotEmpty(ByteString, ValidationContext); given 'false'; when ByteString isEmpty() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.bytesNotEmpty(ByteString, ValidationContext)"})
  void testBytesNotEmpty_givenFalse_whenByteStringIsEmptyReturnFalse() {
    // Arrange
    ByteString content = mock(ByteString.class);
    when(content.isEmpty()).thenReturn(false);

    // Act
    CommonValidators.bytesNotEmpty(content, mock(ValidationContext.class));

    // Assert
    verify(content).isEmpty();
  }

  /**
   * Test {@link CommonValidators#bytesNotEmpty(ByteString, ValidationContext)}.
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#bytesNotEmpty(ByteString, ValidationContext)}
   */
  @Test
  @DisplayName("Test bytesNotEmpty(ByteString, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.bytesNotEmpty(ByteString, ValidationContext)"})
  void testBytesNotEmpty_givenFieldName_thenCallsError() {
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
   * Test {@link CommonValidators#bytesNotEmpty(ByteString, ValidationContext)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#bytesNotEmpty(ByteString, ValidationContext)}
   */
  @Test
  @DisplayName("Test bytesNotEmpty(ByteString, ValidationContext); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.bytesNotEmpty(ByteString, ValidationContext)"})
  void testBytesNotEmpty_thenThrowETracInternal() {
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
}
