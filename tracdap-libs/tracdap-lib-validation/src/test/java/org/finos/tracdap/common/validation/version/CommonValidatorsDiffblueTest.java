package org.finos.tracdap.common.validation.version;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import java.util.ArrayList;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Version;
import org.finos.tracdap.metadata.DatetimeValue;
import org.finos.tracdap.metadata.TagSelector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommonValidatorsDiffblueTest {
  /**
   * Test {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test exactMatch(Object, Object, ValidationContext); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.exactMatch(Object, Object, ValidationContext)"
  })
  void testExactMatch_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.exactMatch("Current", "Prior", ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>When {@code Current}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test exactMatch(Object, Object, ValidationContext); given 'Field Name'; when 'Current'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.exactMatch(Object, Object, ValidationContext)"
  })
  void testExactMatch_givenFieldName_whenCurrent_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.exactMatch("Current", "Prior", ctx);

    // Assert
    verify(ctx)
        .error(
            "Value of [Field Name] must not change between versions: prior = [Prior], new = [Current]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>When {@code Current}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test exactMatch(Object, Object, ValidationContext); given 'Field Name'; when 'Current'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.exactMatch(Object, Object, ValidationContext)"
  })
  void testExactMatch_givenFieldName_whenCurrent_thenCallsError2() {
    // Arrange
    DatetimeValue defaultInstance = DatetimeValue.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.exactMatch("Current", defaultInstance, ctx);

    // Assert
    verify(ctx)
        .error(
            "Value of [Field Name] must not change between versions: prior = [], new = [Current]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>When {@code Prior}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test exactMatch(Object, Object, ValidationContext); given 'Field Name'; when 'Prior'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.exactMatch(Object, Object, ValidationContext)"
  })
  void testExactMatch_givenFieldName_whenPrior_thenCallsError() {
    // Arrange
    DatetimeValue defaultInstance = DatetimeValue.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.exactMatch(defaultInstance, "Prior", ctx);

    // Assert
    verify(ctx)
        .error("Value of [Field Name] must not change between versions: prior = [Prior], new = []");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test exactMatch(Object, Object, ValidationContext); when ValidationContext; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.exactMatch(Object, Object, ValidationContext)"
  })
  void testExactMatch_whenValidationContext_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            CommonValidators.exactMatch(
                DatetimeValue.getDefaultInstance(),
                DatetimeValue.getDefaultInstance(),
                mock(ValidationContext.class)));
  }

  /**
   * Test {@link CommonValidators#equalOrGreater(Integer, Integer, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrGreater(Integer, Integer,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrGreater(Integer, Integer, ValidationContext); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrGreater(Integer, Integer, ValidationContext)"
  })
  void testEqualOrGreater_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.equalOrGreater(0, 1, ctx));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#equalOrGreater(Integer, Integer, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrGreater(Integer, Integer,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrGreater(Integer, Integer, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrGreater(Integer, Integer, ValidationContext)"
  })
  void testEqualOrGreater_givenFieldName_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.equalOrGreater(0, 1, ctx);

    // Assert
    verify(ctx)
        .error(
            "Value of [Field Name] cannot be lower than the previous version: prior = [1], new = [0]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#equalOrGreater(Integer, Integer, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrGreater(Integer, Integer,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrGreater(Integer, Integer, ValidationContext); when ValidationContext; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrGreater(Integer, Integer, ValidationContext)"
  })
  void testEqualOrGreater_whenValidationContext_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> CommonValidators.equalOrGreater(1, 1, mock(ValidationContext.class)));
  }

  /**
   * Test {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link ValidationContext} {@link ValidationContext#field()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test sameOneOf(Object, Object, ValidationContext); given EUnexpected(); when ValidationContext field() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.sameOneOf(Object, Object, ValidationContext)"
  })
  void testSameOneOf_givenEUnexpected_whenValidationContextFieldThrowEUnexpected() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenThrow(new EUnexpected());
    when(ctx.isOneOf()).thenReturn(true);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.sameOneOf("Current", "Prior", ctx));
    verify(ctx).field();
    verify(ctx).isOneOf();
  }

  /**
   * Test {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link ValidationContext} {@link ValidationContext#isOneOf()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test sameOneOf(Object, Object, ValidationContext); given EUnexpected(); when ValidationContext isOneOf() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.sameOneOf(Object, Object, ValidationContext)"
  })
  void testSameOneOf_givenEUnexpected_whenValidationContextIsOneOfThrowEUnexpected() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.isOneOf()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.sameOneOf("Current", "Prior", ctx));
    verify(ctx).isOneOf();
  }

  /**
   * Test {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link ValidationContext} {@link ValidationContext#isOneOf()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test sameOneOf(Object, Object, ValidationContext); given 'false'; when ValidationContext isOneOf() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.sameOneOf(Object, Object, ValidationContext)"
  })
  void testSameOneOf_givenFalse_whenValidationContextIsOneOfReturnFalse() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.isOneOf()).thenReturn(false);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.sameOneOf("Current", "Prior", ctx));
    verify(ctx).isOneOf();
  }

  /**
   * Test {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getNumber()} return one.
   *   <li>Then calls {@link Descriptors.OneofDescriptor#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test sameOneOf(Object, Object, ValidationContext); given FieldDescriptor getNumber() return one; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.sameOneOf(Object, Object, ValidationContext)"
  })
  void testSameOneOf_givenFieldDescriptorGetNumberReturnOne_thenCallsGetName() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getNumber()).thenReturn(10);

    FieldDescriptor fieldDescriptor2 = mock(FieldDescriptor.class);
    when(fieldDescriptor2.getNumber()).thenReturn(1);

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.field()).thenReturn(fieldDescriptor2);

    OneofDescriptor oneofDescriptor = mock(OneofDescriptor.class);
    when(oneofDescriptor.getName()).thenThrow(new EUnexpected());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.oneOf()).thenReturn(oneofDescriptor);
    when(ctx.prior()).thenReturn(validationContext);
    when(ctx.field()).thenReturn(fieldDescriptor);
    when(ctx.isOneOf()).thenReturn(true);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.sameOneOf("Current", "Prior", ctx));
    verify(fieldDescriptor2).getNumber();
    verify(fieldDescriptor).getNumber();
    verify(oneofDescriptor).getName();
    verify(ctx).field();
    verify(validationContext).field();
    verify(ctx).isOneOf();
    verify(ctx).oneOf();
    verify(ctx).prior();
  }

  /**
   * Test {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getNumber()} return ten.
   *   <li>Then calls {@link ValidationContext#prior()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test sameOneOf(Object, Object, ValidationContext); given FieldDescriptor getNumber() return ten; then calls prior()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.sameOneOf(Object, Object, ValidationContext)"
  })
  void testSameOneOf_givenFieldDescriptorGetNumberReturnTen_thenCallsPrior() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getNumber()).thenReturn(10);

    FieldDescriptor fieldDescriptor2 = mock(FieldDescriptor.class);
    when(fieldDescriptor2.getNumber()).thenReturn(10);

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.field()).thenReturn(fieldDescriptor2);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.prior()).thenReturn(validationContext);
    when(ctx.field()).thenReturn(fieldDescriptor);
    when(ctx.isOneOf()).thenReturn(true);

    // Act
    CommonValidators.sameOneOf("Current", "Prior", ctx);

    // Assert
    verify(fieldDescriptor2).getNumber();
    verify(fieldDescriptor).getNumber();
    verify(ctx).field();
    verify(validationContext).field();
    verify(ctx).isOneOf();
    verify(ctx).prior();
  }

  /**
   * Test {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getNumber()} return twelve.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test sameOneOf(Object, Object, ValidationContext); given FieldDescriptor getNumber() return twelve; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.sameOneOf(Object, Object, ValidationContext)"
  })
  void testSameOneOf_givenFieldDescriptorGetNumberReturnTwelve_thenCallsError() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getNumber()).thenReturn(10);

    FieldDescriptor fieldDescriptor2 = mock(FieldDescriptor.class);
    when(fieldDescriptor2.getNumber()).thenReturn(12);

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.fieldName()).thenReturn("Field Name");
    when(validationContext.field()).thenReturn(fieldDescriptor2);

    OneofDescriptor oneofDescriptor = mock(OneofDescriptor.class);
    when(oneofDescriptor.getName()).thenReturn("Name");

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    when(ctx.oneOf()).thenReturn(oneofDescriptor);
    when(ctx.prior()).thenReturn(validationContext);
    when(ctx.field()).thenReturn(fieldDescriptor);
    when(ctx.isOneOf()).thenReturn(true);

    // Act
    CommonValidators.sameOneOf("Current", "Prior", ctx);

    // Assert
    verify(fieldDescriptor2).getNumber();
    verify(fieldDescriptor).getNumber();
    verify(oneofDescriptor).getName();
    verify(ctx)
        .error(
            "Selected one of [Name] must not change between versions: prior = [Field Name], new = [Field Name]");
    verify(ctx).field();
    verify(validationContext).field();
    verify(ctx).fieldName();
    verify(validationContext).fieldName();
    verify(ctx).isOneOf();
    verify(ctx).oneOf();
    verify(ctx, atLeast(1)).prior();
  }

  /**
   * Test {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#getNumber()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link FieldDescriptor#getNumber()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test sameOneOf(Object, Object, ValidationContext); given FieldDescriptor getNumber() throw EUnexpected(); then calls getNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.sameOneOf(Object, Object, ValidationContext)"
  })
  void testSameOneOf_givenFieldDescriptorGetNumberThrowEUnexpected_thenCallsGetNumber() {
    // Arrange
    FieldDescriptor fieldDescriptor = mock(FieldDescriptor.class);
    when(fieldDescriptor.getNumber()).thenThrow(new EUnexpected());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.field()).thenReturn(fieldDescriptor);
    when(ctx.isOneOf()).thenReturn(true);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.sameOneOf("Current", "Prior", ctx));
    verify(fieldDescriptor).getNumber();
    verify(ctx).field();
    verify(ctx).isOneOf();
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenEUnexpected() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(ctx).getErrors();
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyOneOf(FieldDescriptor,
   *       Version, Class)} return {@link ValidationContext}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext applyOneOf(FieldDescriptor, Version, Class) return ValidationContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextApplyOneOfReturnValidationContext() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext5.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext10.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pop()).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext14);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext15);

    // Act
    CommonValidators.equalOrLaterVersion(current, prior, ctx);

    // Assert
    verify(validationContext15).apply(isA(Version.class));
    verify(validationContext12).apply(isA(Version.class));
    verify(validationContext9).apply(isA(Version.class));
    verify(validationContext4).apply(isA(Version.class));
    verify(validationContext8)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext7)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext3)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext2)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(ctx).getErrors();
    verify(validationContext10).getErrors();
    verify(validationContext5).getErrors();
    verify(validationContext14).pop();
    verify(validationContext11).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext13).push(isA(FieldDescriptor.class));
    verify(validationContext10).pushOneOf(isA(OneofDescriptor.class));
    verify(validationContext5).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyOneOf(FieldDescriptor,
   *       Version, Class)} throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext applyOneOf(FieldDescriptor, Version, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextApplyOneOfThrowEUnexpected() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext3.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext7);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext8).apply(isA(Version.class));
    verify(validationContext5).apply(isA(Version.class));
    verify(validationContext2).apply(isA(Version.class));
    verify(validationContext)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(ctx).getErrors();
    verify(validationContext3).getErrors();
    verify(validationContext7).pop();
    verify(validationContext4).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext6).push(isA(FieldDescriptor.class));
    verify(validationContext3).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyOneOf(FieldDescriptor,
   *       Version, Class)} throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext applyOneOf(FieldDescriptor, Version, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextApplyOneOfThrowEUnexpected2() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext4.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext8);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext9).apply(isA(Version.class));
    verify(validationContext6).apply(isA(Version.class));
    verify(validationContext3).apply(isA(Version.class));
    verify(validationContext2)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(ctx).getErrors();
    verify(validationContext4).getErrors();
    verify(validationContext8).pop();
    verify(validationContext5).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext7).push(isA(FieldDescriptor.class));
    verify(validationContext4).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyOneOf(FieldDescriptor,
   *       Version, Class)} throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext applyOneOf(FieldDescriptor, Version, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextApplyOneOfThrowEUnexpected3() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext3.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext8.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext12);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext13);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext13).apply(isA(Version.class));
    verify(validationContext10).apply(isA(Version.class));
    verify(validationContext7).apply(isA(Version.class));
    verify(validationContext2).apply(isA(Version.class));
    verify(validationContext6)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext5)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(ctx).getErrors();
    verify(validationContext8).getErrors();
    verify(validationContext3).getErrors();
    verify(validationContext12).pop();
    verify(validationContext9).pop();
    verify(validationContext4).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext11).push(isA(FieldDescriptor.class));
    verify(validationContext8).pushOneOf(isA(OneofDescriptor.class));
    verify(validationContext3).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyOneOf(FieldDescriptor,
   *       Version, Class)} throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext applyOneOf(FieldDescriptor, Version, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextApplyOneOfThrowEUnexpected4() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext4.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext9.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext13);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext14).apply(isA(Version.class));
    verify(validationContext11).apply(isA(Version.class));
    verify(validationContext8).apply(isA(Version.class));
    verify(validationContext3).apply(isA(Version.class));
    verify(validationContext7)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext6)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext2)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(ctx).getErrors();
    verify(validationContext9).getErrors();
    verify(validationContext4).getErrors();
    verify(validationContext13).pop();
    verify(validationContext10).pop();
    verify(validationContext5).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext12).push(isA(FieldDescriptor.class));
    verify(validationContext9).pushOneOf(isA(OneofDescriptor.class));
    verify(validationContext4).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Version)} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext apply(Version) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextApplyThrowEUnexpected() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Version<Object>>any())).thenThrow(new EUnexpected());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext).apply(isA(Version.class));
    verify(ctx).getErrors();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Version)} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext apply(Version) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextApplyThrowEUnexpected2() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Version<Object>>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext2.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext6);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext7).apply(isA(Version.class));
    verify(validationContext4).apply(isA(Version.class));
    verify(validationContext).apply(isA(Version.class));
    verify(ctx).getErrors();
    verify(validationContext2).getErrors();
    verify(validationContext6).pop();
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
    verify(validationContext2).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Version)} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext apply(Version) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextApplyThrowEUnexpected3() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Version<Object>>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext2.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext7.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext11);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext12);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext12).apply(isA(Version.class));
    verify(validationContext9).apply(isA(Version.class));
    verify(validationContext6).apply(isA(Version.class));
    verify(validationContext).apply(isA(Version.class));
    verify(validationContext5)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext4)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(ctx).getErrors();
    verify(validationContext7).getErrors();
    verify(validationContext2).getErrors();
    verify(validationContext11).pop();
    verify(validationContext8).pop();
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext10).push(isA(FieldDescriptor.class));
    verify(validationContext7).pushOneOf(isA(OneofDescriptor.class));
    verify(validationContext2).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Version)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext apply(Version) throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextApplyThrowEUnexpected_thenCallsPop() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Version<Object>>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext3);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext4).apply(isA(Version.class));
    verify(validationContext).apply(isA(Version.class));
    verify(ctx).getErrors();
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext2).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#getErrors()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext getErrors() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextGetErrorsThrowEUnexpected() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.getErrors()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext5);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext6).apply(isA(Version.class));
    verify(validationContext3).apply(isA(Version.class));
    verify(ctx).getErrors();
    verify(validationContext).getErrors();
    verify(validationContext5).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#getErrors()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext getErrors() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextGetErrorsThrowEUnexpected2() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.getErrors()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext6.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext10);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext11).apply(isA(Version.class));
    verify(validationContext8).apply(isA(Version.class));
    verify(validationContext5).apply(isA(Version.class));
    verify(validationContext4)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext3)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(ctx).getErrors();
    verify(validationContext6).getErrors();
    verify(validationContext).getErrors();
    verify(validationContext10).pop();
    verify(validationContext7).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext9).push(isA(FieldDescriptor.class));
    verify(validationContext6).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext pop() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextPopThrowEUnexpected() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext5.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext9);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext10).apply(isA(Version.class));
    verify(validationContext7).apply(isA(Version.class));
    verify(validationContext4).apply(isA(Version.class));
    verify(validationContext3)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext2)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(ctx).getErrors();
    verify(validationContext5).getErrors();
    verify(validationContext9).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext5).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext pop() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextPopThrowEUnexpected2() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext5.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Version<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext10.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pop()).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext14);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext15);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext15).apply(isA(Version.class));
    verify(validationContext12).apply(isA(Version.class));
    verify(validationContext9).apply(isA(Version.class));
    verify(validationContext4).apply(isA(Version.class));
    verify(validationContext8)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext7)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext3)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext2)
        .applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(ctx).getErrors();
    verify(validationContext10).getErrors();
    verify(validationContext5).getErrors();
    verify(validationContext14).pop();
    verify(validationContext11).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext13).push(isA(FieldDescriptor.class));
    verify(validationContext10).pushOneOf(isA(OneofDescriptor.class));
    verify(validationContext5).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextPopThrowEUnexpected_thenCallsPop() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext2).apply(isA(Version.class));
    verify(ctx).getErrors();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextPopThrowEUnexpected_thenCallsPop2() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext4);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext5).apply(isA(Version.class));
    verify(validationContext2).apply(isA(Version.class));
    verify(ctx).getErrors();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); given ValidationContext push(FieldDescriptor) throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"
  })
  void testEqualOrLaterVersion_givenValidationContextPushThrowEUnexpected_thenCallsPop() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.push(Mockito.<FieldDescriptor>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext2);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    // Act and Assert
    assertThrows(
        EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext3).apply(isA(Version.class));
    verify(ctx).getErrors();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext).push(isA(FieldDescriptor.class));
  }
}
