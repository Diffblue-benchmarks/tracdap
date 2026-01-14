package org.finos.tracdap.common.validation.static_;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.Edition;
import com.google.protobuf.DescriptorProtos.ExtensionRangeOptions;
import com.google.protobuf.DescriptorProtos.ExtensionRangeOptions.VerificationState;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;
import com.google.protobuf.ProtocolMessageEnum;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.metadata.ArrayValue;
import org.finos.tracdap.metadata.BasicType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommonValidatorsDiffblueTest {
  /**
   * Test {@link CommonValidators#required(ValidationContext)} with {@code ctx}.
   *
   * <p>Method under test: {@link CommonValidators#required(ValidationContext)}
   */
  @Test
  @DisplayName("Test required(ValidationContext) with 'ctx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.required(ValidationContext)"})
  void testRequiredWithCtx() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.required(ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#omitted(ValidationContext)} with {@code ctx}.
   *
   * <p>Method under test: {@link CommonValidators#omitted(ValidationContext)}
   */
  @Test
  @DisplayName("Test omitted(ValidationContext) with 'ctx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.omitted(ValidationContext)"})
  void testOmittedWithCtx() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.omitted(ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#optional(ValidationContext)}.
   *
   * <p>Method under test: {@link CommonValidators#optional(ValidationContext)}
   */
  @Test
  @DisplayName("Test optional(ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.optional(ValidationContext)"})
  void testOptional() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.parentMsg()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.optional(ctx));
    verify(ctx).parentMsg();
  }

  /**
   * Test {@link CommonValidators#ifAndOnlyIf(boolean, String, boolean)} with {@code condition},
   * {@code qualifier}, {@code inverted}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#ifAndOnlyIf(boolean, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test ifAndOnlyIf(boolean, String, boolean) with 'condition', 'qualifier', 'inverted'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Basic CommonValidators.ifAndOnlyIf(boolean, String, boolean)"})
  void testIfAndOnlyIfWithConditionQualifierInverted_thenThrowIllegalArgumentException() {
    // Arrange and Act
    Basic actualIfAndOnlyIfResult = CommonValidators.ifAndOnlyIf(true, "Qualifier", true);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Assert
    assertThrows(IllegalArgumentException.class, () -> actualIfAndOnlyIfResult.apply(ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#ifAndOnlyIf(boolean, String, boolean)} with {@code condition},
   * {@code qualifier}, {@code inverted}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#ifAndOnlyIf(boolean, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test ifAndOnlyIf(boolean, String, boolean) with 'condition', 'qualifier', 'inverted'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Basic CommonValidators.ifAndOnlyIf(boolean, String, boolean)"})
  void testIfAndOnlyIfWithConditionQualifierInverted_thenThrowIllegalArgumentException2() {
    // Arrange and Act
    Basic actualIfAndOnlyIfResult = CommonValidators.ifAndOnlyIf(false, "Qualifier", false);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Assert
    assertThrows(IllegalArgumentException.class, () -> actualIfAndOnlyIfResult.apply(ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#ifAndOnlyIf(boolean, String)} with {@code condition}, {@code
   * qualifier}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#ifAndOnlyIf(boolean, String)}
   */
  @Test
  @DisplayName(
      "Test ifAndOnlyIf(boolean, String) with 'condition', 'qualifier'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Basic CommonValidators.ifAndOnlyIf(boolean, String)"})
  void testIfAndOnlyIfWithConditionQualifier_thenThrowIllegalArgumentException() {
    // Arrange and Act
    Basic actualIfAndOnlyIfResult = CommonValidators.ifAndOnlyIf(false, "Qualifier");
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Assert
    assertThrows(IllegalArgumentException.class, () -> actualIfAndOnlyIfResult.apply(ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#ifAndOnlyIf(boolean, String)} with {@code condition}, {@code
   * qualifier}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#ifAndOnlyIf(boolean, String)}
   */
  @Test
  @DisplayName(
      "Test ifAndOnlyIf(boolean, String) with 'condition', 'qualifier'; when 'true'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Basic CommonValidators.ifAndOnlyIf(boolean, String)"})
  void testIfAndOnlyIfWithConditionQualifier_whenTrue_thenThrowIllegalArgumentException() {
    // Arrange and Act
    Basic actualIfAndOnlyIfResult = CommonValidators.ifAndOnlyIf(true, "Qualifier");
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Assert
    assertThrows(IllegalArgumentException.class, () -> actualIfAndOnlyIfResult.apply(ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#onlyIf(boolean, String, boolean)} with {@code condition}, {@code
   * qualifier}, {@code inverted}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then calls {@link ValidationContext#fieldName()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#onlyIf(boolean, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test onlyIf(boolean, String, boolean) with 'condition', 'qualifier', 'inverted'; when 'false'; then calls fieldName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Basic CommonValidators.onlyIf(boolean, String, boolean)"})
  void testOnlyIfWithConditionQualifierInverted_whenFalse_thenCallsFieldName() {
    // Arrange and Act
    Basic actualOnlyIfResult = CommonValidators.onlyIf(false, "Qualifier", false);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Assert
    assertThrows(IllegalArgumentException.class, () -> actualOnlyIfResult.apply(ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#onlyIf(boolean, String, boolean)} with {@code condition}, {@code
   * qualifier}, {@code inverted}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then calls {@link ValidationContext#parentMsg()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#onlyIf(boolean, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test onlyIf(boolean, String, boolean) with 'condition', 'qualifier', 'inverted'; when 'true'; then calls parentMsg()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Basic CommonValidators.onlyIf(boolean, String, boolean)"})
  void testOnlyIfWithConditionQualifierInverted_whenTrue_thenCallsParentMsg() {
    // Arrange and Act
    Basic actualOnlyIfResult = CommonValidators.onlyIf(true, "Qualifier", true);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.parentMsg()).thenThrow(new IllegalArgumentException());

    // Assert
    assertThrows(IllegalArgumentException.class, () -> actualOnlyIfResult.apply(ctx));
    verify(ctx).parentMsg();
  }

  /**
   * Test {@link CommonValidators#onlyIf(boolean, String)} with {@code condition}, {@code
   * qualifier}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then calls {@link ValidationContext#fieldName()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#onlyIf(boolean, String)}
   */
  @Test
  @DisplayName(
      "Test onlyIf(boolean, String) with 'condition', 'qualifier'; when 'false'; then calls fieldName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Basic CommonValidators.onlyIf(boolean, String)"})
  void testOnlyIfWithConditionQualifier_whenFalse_thenCallsFieldName() {
    // Arrange and Act
    Basic actualOnlyIfResult = CommonValidators.onlyIf(false, "Qualifier");
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Assert
    assertThrows(IllegalArgumentException.class, () -> actualOnlyIfResult.apply(ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#onlyIf(boolean, String)} with {@code condition}, {@code
   * qualifier}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then calls {@link ValidationContext#parentMsg()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#onlyIf(boolean, String)}
   */
  @Test
  @DisplayName(
      "Test onlyIf(boolean, String) with 'condition', 'qualifier'; when 'true'; then calls parentMsg()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Basic CommonValidators.onlyIf(boolean, String)"})
  void testOnlyIfWithConditionQualifier_whenTrue_thenCallsParentMsg() {
    // Arrange and Act
    Basic actualOnlyIfResult = CommonValidators.onlyIf(true, "Qualifier");
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.parentMsg()).thenThrow(new IllegalArgumentException());

    // Assert
    assertThrows(IllegalArgumentException.class, () -> actualOnlyIfResult.apply(ctx));
    verify(ctx).parentMsg();
  }

  /**
   * Test {@link CommonValidators#primitiveType(BasicType, ValidationContext)} with {@code
   * basicType}, {@code ctx}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#primitiveType(BasicType, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test primitiveType(BasicType, ValidationContext) with 'basicType', 'ctx'; given 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.primitiveType(BasicType, ValidationContext)"
  })
  void testPrimitiveTypeWithBasicTypeCtx_givenFieldName_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.primitiveType(BasicType.BASIC_TYPE_NOT_SET, ctx);

    // Assert
    verify(ctx)
        .error("Type specified in [Field Name] is not a primitive type: [BASIC_TYPE_NOT_SET]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#primitiveType(BasicType, ValidationContext)} with {@code
   * basicType}, {@code ctx}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#primitiveType(BasicType, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test primitiveType(BasicType, ValidationContext) with 'basicType', 'ctx'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.primitiveType(BasicType, ValidationContext)"
  })
  void testPrimitiveTypeWithBasicTypeCtx_thenThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> CommonValidators.primitiveType(BasicType.BASIC_TYPE_NOT_SET, ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#uuid(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#uuid(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test uuid(String, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.uuid(String, ValidationContext)"})
  void testUuid_givenFieldName_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.uuid("42", ctx);

    // Assert
    verify(ctx).error("Value of [Field Name] is not a valid object ID: [42]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#uuid(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#uuid(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test uuid(String, ValidationContext); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.uuid(String, ValidationContext)"})
  void testUuid_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.uuid("42", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#decimal(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getType()} return {@code DOUBLE}.
   *   <li>When {@code 42}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#decimal(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test decimal(String, ValidationContext); given FieldDescriptor getType() return 'DOUBLE'; when '42'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.decimal(String, ValidationContext)"})
  void testDecimal_givenFieldDescriptorGetTypeReturnDouble_when42_thenThrowEUnexpected() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenReturn(Type.DOUBLE);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.decimal("42", ctx));
    verify(fieldDescriptor).getType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#decimal(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getType()} return {@link
   *       FieldDescriptor.Type#STRING}.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link FieldDescriptor#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#decimal(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test decimal(String, ValidationContext); given FieldDescriptor getType() return STRING; when '42'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.decimal(String, ValidationContext)"})
  void testDecimal_givenFieldDescriptorGetTypeReturnString_when42_thenCallsGetType() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenReturn(Type.STRING);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.decimal("42", ctx);

    // Assert
    verify(fieldDescriptor).getType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#decimal(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#decimal(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test decimal(String, ValidationContext); given FieldDescriptor getType() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.decimal(String, ValidationContext)"})
  void testDecimal_givenFieldDescriptorGetTypeThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenThrow(new IllegalArgumentException());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.decimal("42", ctx));
    verify(fieldDescriptor).getType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#decimal(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#decimal(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test decimal(String, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.decimal(String, ValidationContext)"})
  void testDecimal_givenFieldName_thenCallsError() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenReturn(Type.STRING);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.decimal("Value", ctx);

    // Assert
    verify(fieldDescriptor).getType();
    verify(ctx)
        .error(
            "Value of [Field Name] is not a valid decimal: [Value] Unparseable number: \"Value\"");
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#decimal(String, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#fieldName()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#decimal(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test decimal(String, ValidationContext); when ValidationContext fieldName() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.decimal(String, ValidationContext)"})
  void testDecimal_whenValidationContextFieldNameThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenReturn(Type.STRING);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.decimal("Value", ctx));
    verify(fieldDescriptor).getType();
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#decimal(String, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#field()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#decimal(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test decimal(String, ValidationContext); when ValidationContext field() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.decimal(String, ValidationContext)"})
  void testDecimal_whenValidationContextFieldThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.decimal("42", ctx));
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#isoDate(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getType()} return {@code DOUBLE}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#isoDate(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test isoDate(String, ValidationContext); given FieldDescriptor getType() return 'DOUBLE'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.isoDate(String, ValidationContext)"})
  void testIsoDate_givenFieldDescriptorGetTypeReturnDouble_thenThrowEUnexpected() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenReturn(Type.DOUBLE);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.isoDate("42", ctx));
    verify(fieldDescriptor).getType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#isoDate(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#isoDate(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test isoDate(String, ValidationContext); given FieldDescriptor getType() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.isoDate(String, ValidationContext)"})
  void testIsoDate_givenFieldDescriptorGetTypeThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenThrow(new IllegalArgumentException());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.isoDate("42", ctx));
    verify(fieldDescriptor).getType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#isoDate(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#isoDate(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test isoDate(String, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.isoDate(String, ValidationContext)"})
  void testIsoDate_givenFieldName_thenCallsError() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenReturn(Type.STRING);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.isoDate("42", ctx);

    // Assert
    verify(fieldDescriptor).getType();
    verify(ctx)
        .error(
            "Value of [Field Name] is not a valid date: [42] Text '42' could not be parsed at index 0");
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#isoDate(String, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#fieldName()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#isoDate(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test isoDate(String, ValidationContext); when ValidationContext fieldName() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.isoDate(String, ValidationContext)"})
  void testIsoDate_whenValidationContextFieldNameThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenReturn(Type.STRING);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.isoDate("42", ctx));
    verify(fieldDescriptor).getType();
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#isoDate(String, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#field()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#isoDate(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test isoDate(String, ValidationContext); when ValidationContext field() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.isoDate(String, ValidationContext)"})
  void testIsoDate_whenValidationContextFieldThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.isoDate("42", ctx));
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#isoDatetime(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getType()} return {@code DOUBLE}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#isoDatetime(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test isoDatetime(String, ValidationContext); given FieldDescriptor getType() return 'DOUBLE'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.isoDatetime(String, ValidationContext)"})
  void testIsoDatetime_givenFieldDescriptorGetTypeReturnDouble_thenThrowEUnexpected() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenReturn(Type.DOUBLE);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.isoDatetime("42", ctx));
    verify(fieldDescriptor).getType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#isoDatetime(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#isoDatetime(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test isoDatetime(String, ValidationContext); given FieldDescriptor getType() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.isoDatetime(String, ValidationContext)"})
  void testIsoDatetime_givenFieldDescriptorGetTypeThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenThrow(new IllegalArgumentException());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.isoDatetime("42", ctx));
    verify(fieldDescriptor).getType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#isoDatetime(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#isoDatetime(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test isoDatetime(String, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.isoDatetime(String, ValidationContext)"})
  void testIsoDatetime_givenFieldName_thenCallsError() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenReturn(Type.STRING);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.isoDatetime("42", ctx);

    // Assert
    verify(fieldDescriptor).getType();
    verify(ctx)
        .error(
            "Value of [Field Name] is not a valid datetime: [42] Text '42' could not be parsed at index 2");
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#isoDatetime(String, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#fieldName()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#isoDatetime(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test isoDatetime(String, ValidationContext); when ValidationContext fieldName() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.isoDatetime(String, ValidationContext)"})
  void testIsoDatetime_whenValidationContextFieldNameThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getType()).thenReturn(Type.STRING);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.isoDatetime("42", ctx));
    verify(fieldDescriptor).getType();
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#isoDatetime(String, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#field()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#isoDatetime(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test isoDatetime(String, ValidationContext); when ValidationContext field() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.isoDatetime(String, ValidationContext)"})
  void testIsoDatetime_whenValidationContextFieldThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.isoDatetime("42", ctx));
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#identifier(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#identifier(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test identifier(String, ValidationContext); given 'Field Name'; when '42'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.identifier(String, ValidationContext)"})
  void testIdentifier_givenFieldName_when42_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.identifier("42", ctx);

    // Assert
    verify(ctx).error("[Field Name] is not a valid identifier: [42]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#identifier(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#identifier(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test identifier(String, ValidationContext); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.identifier(String, ValidationContext)"})
  void testIdentifier_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.identifier("42", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#resourceKey(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#resourceKey(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test resourceKey(String, ValidationContext); given 'Field Name'; when '42'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.resourceKey(String, ValidationContext)"})
  void testResourceKey_givenFieldName_when42_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.resourceKey("42", ctx);

    // Assert
    verify(ctx).error("[Field Name] is not a valid resource key: [42]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#resourceKey(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#resourceKey(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test resourceKey(String, ValidationContext); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.resourceKey(String, ValidationContext)"})
  void testResourceKey_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.resourceKey("42", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#notTracReserved(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notTracReserved(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notTracReserved(String, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.notTracReserved(String, ValidationContext)"
  })
  void testNotTracReserved_givenFieldName_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.notTracReserved("trac-U", ctx);

    // Assert
    verify(ctx).error("[Field Name] is a TRAC reserved identifier: [trac-U]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#notTracReserved(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notTracReserved(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notTracReserved(String, ValidationContext); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.notTracReserved(String, ValidationContext)"
  })
  void testNotTracReserved_thenThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> CommonValidators.notTracReserved("trac-U", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#mimeType(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@code U/U+U}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#mimeType(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test mimeType(String, ValidationContext); given 'false'; when 'U/U+U'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.mimeType(String, ValidationContext)"})
  void testMimeType_givenFalse_whenUUU_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.failed()).thenReturn(false);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.mimeType("U/U+U", ctx);

    // Assert
    verify(ctx).error("Value of [Field Name] is not a registered mime type: [U/U+U]");
    verify(ctx).failed();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#mimeType(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#mimeType(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test mimeType(String, ValidationContext); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.mimeType(String, ValidationContext)"})
  void testMimeType_givenIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.mimeType("42", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#mimeType(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code true}.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#mimeType(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test mimeType(String, ValidationContext); given ValidationContext failed() return 'true'; when '42'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.mimeType(String, ValidationContext)"})
  void testMimeType_givenValidationContextFailedReturnTrue_when42_thenCallsError() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(true);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(validationContext);

    // Act
    CommonValidators.mimeType("42", ctx);

    // Assert
    verify(ctx).error("[Field Name] is not a valid mime type: [42]");
    verify(validationContext).failed();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#mimeType(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#mimeType(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test mimeType(String, ValidationContext); given ValidationContext failed() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.mimeType(String, ValidationContext)"})
  void testMimeType_givenValidationContextFailedThrowIllegalArgumentException() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenThrow(new IllegalArgumentException());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.mimeType("42", ctx));
    verify(ctx).error("[Field Name] is not a valid mime type: [42]");
    verify(validationContext).failed();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#mimeType(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#fieldName()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#mimeType(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test mimeType(String, ValidationContext); given ValidationContext fieldName() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.mimeType(String, ValidationContext)"})
  void testMimeType_givenValidationContextFieldNameThrowIllegalArgumentException() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.fieldName()).thenThrow(new IllegalArgumentException());
    when(validationContext.failed()).thenReturn(false);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.mimeType("/", ctx));
    verify(ctx).error("[Field Name] is not a valid mime type: [/]");
    verify(validationContext).failed();
    verify(ctx).fieldName();
    verify(validationContext).fieldName();
  }

  /**
   * Test {@link CommonValidators#relativePath(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test relativePath(String, ValidationContext); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_givenIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<String>>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.relativePath("Path", ctx));
    verify(ctx).apply(isA(Typed.class));
  }

  /**
   * Test {@link CommonValidators#relativePath(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code false}.
   *   <li>When {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test relativePath(String, ValidationContext); given ValidationContext failed() return 'false'; when 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_givenValidationContextFailedReturnFalse_whenPath() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(false);

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
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code false}.
   *   <li>When {@code U/U}.
   *   <li>Then calls {@link ValidationContext#failed()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test relativePath(String, ValidationContext); given ValidationContext failed() return 'false'; when 'U/U'; then calls failed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_givenValidationContextFailedReturnFalse_whenUU_thenCallsFailed() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(false);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    // Act
    CommonValidators.relativePath("U/U", ctx);

    // Assert
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext).failed();
  }

  /**
   * Test {@link CommonValidators#relativePath(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code true}.
   *   <li>When {@code Path}.
   *   <li>Then calls {@link ValidationContext#failed()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test relativePath(String, ValidationContext); given ValidationContext failed() return 'true'; when 'Path'; then calls failed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_givenValidationContextFailedReturnTrue_whenPath_thenCallsFailed() {
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
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test relativePath(String, ValidationContext); given ValidationContext failed() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_givenValidationContextFailedThrowIllegalArgumentException() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenThrow(new IllegalArgumentException());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.relativePath("Path", ctx));
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext).failed();
  }

  /**
   * Test {@link CommonValidators#relativePath(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#fieldName()} return {@code Field
   *       Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test relativePath(String, ValidationContext); given ValidationContext fieldName() return 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_givenValidationContextFieldNameReturnFieldName_thenCallsError() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(false);
    when(validationContext.fieldName()).thenReturn("Field Name");
    when(validationContext.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.fieldName()).thenReturn("Field Name");
    when(validationContext2.error(Mockito.<String>any())).thenReturn(validationContext);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext2);

    // Act
    CommonValidators.relativePath("U:U", ctx);

    // Assert
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext2)
        .error("[Field Name] contains characters not allowed in a relative path (:): [U:U]");
    verify(validationContext)
        .error("[Field Name] segment contains characters illegal characters: [U:U]");
    verify(validationContext).failed();
    verify(validationContext2).fieldName();
    verify(validationContext).fieldName();
  }

  /**
   * Test {@link CommonValidators#relativePath(String, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#fieldName()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test relativePath(String, ValidationContext); given ValidationContext fieldName() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_givenValidationContextFieldNameThrowIllegalArgumentException() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.fieldName()).thenThrow(new IllegalArgumentException());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.relativePath("U:U", ctx));
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext).fieldName();
  }

  /**
   * Test {@link CommonValidators#relativePath(String, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#relativePath(String, ValidationContext)}
   */
  @Test
  @DisplayName("Test relativePath(String, ValidationContext); when '/'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.relativePath(String, ValidationContext)"})
  void testRelativePath_whenSlash_thenCallsError() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(false);

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.fieldName()).thenReturn("Field Name");
    when(validationContext2.error(Mockito.<String>any())).thenReturn(validationContext);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext2);

    // Act
    CommonValidators.relativePath("/", ctx);

    // Assert
    verify(ctx).apply(isA(Typed.class));
    verify(validationContext2).error("[Field Name] is an absolute path: [/]");
    verify(validationContext).failed();
    verify(validationContext2).fieldName();
  }

  /**
   * Test {@link CommonValidators#notNegative(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getJavaType()} return {@code
   *       BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notNegative(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notNegative(Object, ValidationContext); given FieldDescriptor getJavaType() return 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.notNegative(Object, ValidationContext)"})
  void testNotNegative_givenFieldDescriptorGetJavaTypeReturnBoolean() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.BOOLEAN);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.notNegative(0, ctx));
    verify(fieldDescriptor).getJavaType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#notNegative(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getJavaType()} return {@code INT}.
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notNegative(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notNegative(Object, ValidationContext); given FieldDescriptor getJavaType() return 'INT'; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.notNegative(Object, ValidationContext)"})
  void testNotNegative_givenFieldDescriptorGetJavaTypeReturnInt_whenZero() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.INT);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.notNegative(0, ctx);

    // Assert
    verify(fieldDescriptor).getJavaType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#notNegative(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getJavaType()} return {@code LONG}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notNegative(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notNegative(Object, ValidationContext); given FieldDescriptor getJavaType() return 'LONG'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.notNegative(Object, ValidationContext)"})
  void testNotNegative_givenFieldDescriptorGetJavaTypeReturnLong_thenCallsError() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.LONG);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.notNegative(-1L, ctx);

    // Assert
    verify(fieldDescriptor).getJavaType();
    verify(ctx).error("Value of [Field Name] cannot be negative: [-1]");
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#notNegative(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getJavaType()} return {@code LONG}.
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notNegative(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notNegative(Object, ValidationContext); given FieldDescriptor getJavaType() return 'LONG'; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.notNegative(Object, ValidationContext)"})
  void testNotNegative_givenFieldDescriptorGetJavaTypeReturnLong_whenZero() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.LONG);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.notNegative(0L, ctx);

    // Assert
    verify(fieldDescriptor).getJavaType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#notNegative(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getJavaType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notNegative(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notNegative(Object, ValidationContext); given FieldDescriptor getJavaType() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.notNegative(Object, ValidationContext)"})
  void testNotNegative_givenFieldDescriptorGetJavaTypeThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenThrow(new IllegalArgumentException());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.notNegative("Value", ctx));
    verify(fieldDescriptor).getJavaType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#notNegative(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getMessageType()} return Descriptor.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notNegative(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notNegative(Object, ValidationContext); given FieldDescriptor getMessageType() return Descriptor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.notNegative(Object, ValidationContext)"})
  void testNotNegative_givenFieldDescriptorGetMessageTypeReturnDescriptor() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getMessageType()).thenReturn(ArrayValue.getDescriptor());
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.MESSAGE);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.notNegative("Value", ctx));
    verify(fieldDescriptor).getJavaType();
    verify(fieldDescriptor).getMessageType();
    verify(ctx, atLeast(1)).field();
  }

  /**
   * Test {@link CommonValidators#notNegative(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getMessageType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notNegative(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notNegative(Object, ValidationContext); given FieldDescriptor getMessageType() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.notNegative(Object, ValidationContext)"})
  void testNotNegative_givenFieldDescriptorGetMessageTypeThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getMessageType()).thenThrow(new IllegalArgumentException());
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.MESSAGE);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.notNegative("Value", ctx));
    verify(fieldDescriptor).getJavaType();
    verify(fieldDescriptor).getMessageType();
    verify(ctx, atLeast(1)).field();
  }

  /**
   * Test {@link CommonValidators#notNegative(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notNegative(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notNegative(Object, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.notNegative(Object, ValidationContext)"})
  void testNotNegative_givenFieldName_thenCallsError() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.INT);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.notNegative(-1, ctx);

    // Assert
    verify(fieldDescriptor).getJavaType();
    verify(ctx).error("Value of [Field Name] cannot be negative: [-1]");
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#notNegative(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#fieldName()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notNegative(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notNegative(Object, ValidationContext); when ValidationContext fieldName() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.notNegative(Object, ValidationContext)"})
  void testNotNegative_whenValidationContextFieldNameThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.INT);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.notNegative(-1, ctx));
    verify(fieldDescriptor).getJavaType();
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#notNegative(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#field()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#notNegative(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test notNegative(Object, ValidationContext); when ValidationContext field() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.notNegative(Object, ValidationContext)"})
  void testNotNegative_whenValidationContextFieldThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.notNegative("Value", ctx));
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#optionalTrue(boolean, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#optionalTrue(boolean, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test optionalTrue(boolean, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.optionalTrue(boolean, ValidationContext)"})
  void testOptionalTrue_givenFieldName_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.optionalTrue(false, ctx);

    // Assert
    verify(ctx).error("Optional field [Field Name] must either be omitted or set to 'true'");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#optionalTrue(boolean, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#optionalTrue(boolean, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test optionalTrue(boolean, ValidationContext); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.optionalTrue(boolean, ValidationContext)"})
  void testOptionalTrue_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.optionalTrue(false, ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#positive(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getJavaType()} return {@code
   *       BOOLEAN}.
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#positive(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test positive(Object, ValidationContext); given FieldDescriptor getJavaType() return 'BOOLEAN'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.positive(Object, ValidationContext)"})
  void testPositive_givenFieldDescriptorGetJavaTypeReturnBoolean_whenOne() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.BOOLEAN);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.positive(1, ctx));
    verify(fieldDescriptor).getJavaType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#positive(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getJavaType()} return {@code INT}.
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#positive(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test positive(Object, ValidationContext); given FieldDescriptor getJavaType() return 'INT'; when forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.positive(Object, ValidationContext)"})
  void testPositive_givenFieldDescriptorGetJavaTypeReturnInt_whenFortyTwo() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.INT);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.positive(42, ctx);

    // Assert
    verify(fieldDescriptor).getJavaType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#positive(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getJavaType()} return {@code LONG}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#positive(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test positive(Object, ValidationContext); given FieldDescriptor getJavaType() return 'LONG'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.positive(Object, ValidationContext)"})
  void testPositive_givenFieldDescriptorGetJavaTypeReturnLong_thenCallsError() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.LONG);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.positive(0L, ctx);

    // Assert
    verify(fieldDescriptor).getJavaType();
    verify(ctx).error("Value of [Field Name] must be positive: [0]");
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#positive(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getJavaType()} return {@code LONG}.
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#positive(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test positive(Object, ValidationContext); given FieldDescriptor getJavaType() return 'LONG'; when forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.positive(Object, ValidationContext)"})
  void testPositive_givenFieldDescriptorGetJavaTypeReturnLong_whenFortyTwo() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.LONG);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.positive(42L, ctx);

    // Assert
    verify(fieldDescriptor).getJavaType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#positive(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getJavaType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#positive(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test positive(Object, ValidationContext); given FieldDescriptor getJavaType() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.positive(Object, ValidationContext)"})
  void testPositive_givenFieldDescriptorGetJavaTypeThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenThrow(new IllegalArgumentException());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.positive("Value", ctx));
    verify(fieldDescriptor).getJavaType();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#positive(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getMessageType()} return Descriptor.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#positive(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test positive(Object, ValidationContext); given FieldDescriptor getMessageType() return Descriptor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.positive(Object, ValidationContext)"})
  void testPositive_givenFieldDescriptorGetMessageTypeReturnDescriptor() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getMessageType()).thenReturn(ArrayValue.getDescriptor());
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.MESSAGE);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.positive("Value", ctx));
    verify(fieldDescriptor).getJavaType();
    verify(fieldDescriptor).getMessageType();
    verify(ctx, atLeast(1)).field();
  }

  /**
   * Test {@link CommonValidators#positive(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getMessageType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#positive(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test positive(Object, ValidationContext); given FieldDescriptor getMessageType() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.positive(Object, ValidationContext)"})
  void testPositive_givenFieldDescriptorGetMessageTypeThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getMessageType()).thenThrow(new IllegalArgumentException());
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.MESSAGE);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.positive("Value", ctx));
    verify(fieldDescriptor).getJavaType();
    verify(fieldDescriptor).getMessageType();
    verify(ctx, atLeast(1)).field();
  }

  /**
   * Test {@link CommonValidators#positive(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#positive(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test positive(Object, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.positive(Object, ValidationContext)"})
  void testPositive_givenFieldName_thenCallsError() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.INT);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act
    CommonValidators.positive(0, ctx);

    // Assert
    verify(fieldDescriptor).getJavaType();
    verify(ctx).error("Value of [Field Name] must be positive: [0]");
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#positive(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#fieldName()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#positive(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test positive(Object, ValidationContext); when ValidationContext fieldName() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.positive(Object, ValidationContext)"})
  void testPositive_whenValidationContextFieldNameThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getJavaType()).thenReturn(JavaType.INT);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.positive(0, ctx));
    verify(fieldDescriptor).getJavaType();
    verify(ctx).field();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#positive(Object, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#field()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#positive(Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test positive(Object, ValidationContext); when ValidationContext field() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.positive(Object, ValidationContext)"})
  void testPositive_whenValidationContextFieldThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.positive("Value", ctx));
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#recognizedEnum(ProtocolMessageEnum, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#recognizedEnum(ProtocolMessageEnum,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test recognizedEnum(ProtocolMessageEnum, ValidationContext); given ValidationContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.recognizedEnum(ProtocolMessageEnum, ValidationContext)"
  })
  void testRecognizedEnum_givenValidationContext() {
    // Arrange
    EnumValueDescriptor enumValueDescriptor = mock(EnumValueDescriptor.class);
    when(enumValueDescriptor.getName()).thenReturn("Name");

    ProtocolMessageEnum protoEnum = mock(ProtocolMessageEnum.class);
    when(protoEnum.getValueDescriptor()).thenReturn(enumValueDescriptor);
    when(protoEnum.getNumber()).thenReturn(-1);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    when(ctx.fieldName()).thenReturn("Field Name");

    // Act
    CommonValidators.recognizedEnum(protoEnum, ctx);

    // Assert
    verify(enumValueDescriptor).getName();
    verify(protoEnum).getNumber();
    verify(protoEnum).getValueDescriptor();
    verify(ctx).error("Unrecognised value specified for [Field Name]: [Name]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#recognizedEnum(ProtocolMessageEnum, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#error(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#recognizedEnum(ProtocolMessageEnum,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test recognizedEnum(ProtocolMessageEnum, ValidationContext); when ValidationContext error(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.recognizedEnum(ProtocolMessageEnum, ValidationContext)"
  })
  void testRecognizedEnum_whenValidationContextErrorThrowIllegalArgumentException() {
    // Arrange
    EnumValueDescriptor enumValueDescriptor = mock(EnumValueDescriptor.class);
    when(enumValueDescriptor.getName()).thenReturn("Name");

    ProtocolMessageEnum protoEnum = mock(ProtocolMessageEnum.class);
    when(protoEnum.getValueDescriptor()).thenReturn(enumValueDescriptor);
    when(protoEnum.getNumber()).thenReturn(-1);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(ctx.fieldName()).thenReturn("Field Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> CommonValidators.recognizedEnum(protoEnum, ctx));
    verify(enumValueDescriptor).getName();
    verify(protoEnum).getNumber();
    verify(protoEnum).getValueDescriptor();
    verify(ctx).error("Unrecognised value specified for [Field Name]: [Name]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#recognizedEnum(ProtocolMessageEnum, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#fieldName()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#recognizedEnum(ProtocolMessageEnum,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test recognizedEnum(ProtocolMessageEnum, ValidationContext); when ValidationContext fieldName() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.recognizedEnum(ProtocolMessageEnum, ValidationContext)"
  })
  void testRecognizedEnum_whenValidationContextFieldNameThrowIllegalArgumentException() {
    // Arrange
    ProtocolMessageEnum protoEnum = mock(ProtocolMessageEnum.class);
    when(protoEnum.getNumber()).thenReturn(-1);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> CommonValidators.recognizedEnum(protoEnum, ctx));
    verify(protoEnum).getNumber();
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>When {@link ValidationContext} {@link ValidationContext#fieldName()} return {@code Field
   *       Name}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test nonZeroEnum(ProtocolMessageEnum, ValidationContext); given 'Field Name'; when ValidationContext fieldName() return 'Field Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.nonZeroEnum(ProtocolMessageEnum, ValidationContext)"
  })
  void testNonZeroEnum_givenFieldName_whenValidationContextFieldNameReturnFieldName() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.nonZeroEnum(Edition.EDITION_UNKNOWN, ctx);

    // Assert
    verify(ctx).error("Unrecognised value specified for [Field Name]: [EDITION_UNKNOWN]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ValidationContext} {@link ValidationContext#fieldName()} return {@code foo}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test nonZeroEnum(ProtocolMessageEnum, ValidationContext); given 'foo'; when ValidationContext fieldName() return 'foo'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.nonZeroEnum(ProtocolMessageEnum, ValidationContext)"
  })
  void testNonZeroEnum_givenFoo_whenValidationContextFieldNameReturnFoo_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("foo");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.nonZeroEnum(VerificationState.DECLARATION, ctx);

    // Assert
    verify(ctx).error("Unrecognised value specified for [foo]: [DECLARATION]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test nonZeroEnum(ProtocolMessageEnum, ValidationContext); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.nonZeroEnum(ProtocolMessageEnum, ValidationContext)"
  })
  void testNonZeroEnum_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> CommonValidators.nonZeroEnum(Edition.EDITION_UNKNOWN, ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Unrecognised value specified for [%s]: [%s]}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#nonZeroEnum(ProtocolMessageEnum,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test nonZeroEnum(ProtocolMessageEnum, ValidationContext); given 'Unrecognised value specified for [%s]: [%s]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.nonZeroEnum(ProtocolMessageEnum, ValidationContext)"
  })
  void testNonZeroEnum_givenUnrecognisedValueSpecifiedForSS() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Unrecognised value specified for [%s]: [%s]");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.nonZeroEnum(VerificationState.DECLARATION, ctx);

    // Assert
    verify(ctx)
        .error(
            "Unrecognised value specified for [Unrecognised value specified for [%s]: [%s]]: [DECLARATION]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#listNotEmpty(ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#isRepeated()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#listNotEmpty(ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test listNotEmpty(ValidationContext); given FieldDescriptor isRepeated() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.listNotEmpty(ValidationContext)"})
  void testListNotEmpty_givenFieldDescriptorIsRepeatedThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.isRepeated()).thenThrow(new IllegalArgumentException());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.listNotEmpty(ctx));
    verify(fieldDescriptor).isRepeated();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#listNotEmpty(ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#listNotEmpty(ValidationContext)}
   */
  @Test
  @DisplayName("Test listNotEmpty(ValidationContext); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.listNotEmpty(ValidationContext)"})
  void testListNotEmpty_givenIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.listNotEmpty(ctx));
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#listNotEmpty(ValidationContext)}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#listNotEmpty(ValidationContext)}
   */
  @Test
  @DisplayName("Test listNotEmpty(ValidationContext); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.listNotEmpty(ValidationContext)"})
  void testListNotEmpty_thenThrowETracInternal() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.isRepeated()).thenReturn(false);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.listNotEmpty(ctx));
    verify(fieldDescriptor).isRepeated();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#mapNotEmpty(ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#isMapField()} return {@code false}.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#mapNotEmpty(ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test mapNotEmpty(ValidationContext); given FieldDescriptor isMapField() return 'false'; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.mapNotEmpty(ValidationContext)"})
  void testMapNotEmpty_givenFieldDescriptorIsMapFieldReturnFalse_thenThrowETracInternal() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.isMapField()).thenReturn(false);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> CommonValidators.mapNotEmpty(ctx));
    verify(fieldDescriptor).isMapField();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#mapNotEmpty(ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#isMapField()} return {@code true}.
   *   <li>Then calls {@link ValidationContext#parentMsg()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#mapNotEmpty(ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test mapNotEmpty(ValidationContext); given FieldDescriptor isMapField() return 'true'; then calls parentMsg()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.mapNotEmpty(ValidationContext)"})
  void testMapNotEmpty_givenFieldDescriptorIsMapFieldReturnTrue_thenCallsParentMsg() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.isMapField()).thenReturn(true);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.parentMsg()).thenThrow(new IllegalArgumentException());
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.mapNotEmpty(ctx));
    verify(fieldDescriptor).isMapField();
    verify(ctx).field();
    verify(ctx).parentMsg();
  }

  /**
   * Test {@link CommonValidators#mapNotEmpty(ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#isMapField()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#mapNotEmpty(ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test mapNotEmpty(ValidationContext); given FieldDescriptor isMapField() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.mapNotEmpty(ValidationContext)"})
  void testMapNotEmpty_givenFieldDescriptorIsMapFieldThrowIllegalArgumentException() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.isMapField()).thenThrow(new IllegalArgumentException());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.mapNotEmpty(ctx));
    verify(fieldDescriptor).isMapField();
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#mapNotEmpty(ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#field()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#mapNotEmpty(ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test mapNotEmpty(ValidationContext); when ValidationContext field() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext CommonValidators.mapNotEmpty(ValidationContext)"})
  void testMapNotEmpty_whenValidationContextFieldThrowIllegalArgumentException() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CommonValidators.mapNotEmpty(ctx));
    verify(ctx).field();
  }

  /**
   * Test {@link CommonValidators#caseInsensitiveDuplicates(ValidationContext)}.
   *
   * <p>Method under test: {@link CommonValidators#caseInsensitiveDuplicates(ValidationContext)}
   */
  @Test
  @DisplayName("Test caseInsensitiveDuplicates(ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.caseInsensitiveDuplicates(ValidationContext)"
  })
  void testCaseInsensitiveDuplicates() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.parentMsg()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> CommonValidators.caseInsensitiveDuplicates(ctx));
    verify(ctx).parentMsg();
  }
}
