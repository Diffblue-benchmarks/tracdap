package org.finos.tracdap.common.validation.version;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>When {@code Current}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName("Test exactMatch(Object, Object, ValidationContext); given 'Field Name'; when 'Current'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.exactMatch(Object, Object, ValidationContext)"})
  void testExactMatch_givenFieldName_whenCurrent_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.exactMatch("Current", "Prior", ctx);

    // Assert
    verify(ctx).error(eq("Value of [Field Name] must not change between versions: prior = [Prior], new = [Current]"));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}.
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>When {@code Current}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName("Test exactMatch(Object, Object, ValidationContext); given 'Field Name'; when 'Current'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.exactMatch(Object, Object, ValidationContext)"})
  void testExactMatch_givenFieldName_whenCurrent_thenCallsError2() {
    // Arrange
    DatetimeValue defaultInstance = DatetimeValue.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.exactMatch("Current", defaultInstance, ctx);

    // Assert
    verify(ctx).error(eq("Value of [Field Name] must not change between versions: prior = [], new = [Current]"));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}.
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>When {@code Prior}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#exactMatch(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName("Test exactMatch(Object, Object, ValidationContext); given 'Field Name'; when 'Prior'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.exactMatch(Object, Object, ValidationContext)"})
  void testExactMatch_givenFieldName_whenPrior_thenCallsError() {
    // Arrange
    DatetimeValue defaultInstance = DatetimeValue.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.exactMatch(defaultInstance, "Prior", ctx);

    // Assert
    verify(ctx).error(eq("Value of [Field Name] must not change between versions: prior = [Prior], new = []"));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#equalOrGreater(Integer, Integer, ValidationContext)}.
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#equalOrGreater(Integer, Integer, ValidationContext)}
   */
  @Test
  @DisplayName("Test equalOrGreater(Integer, Integer, ValidationContext); given EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.equalOrGreater(Integer, Integer, ValidationContext)"})
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
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#equalOrGreater(Integer, Integer, ValidationContext)}
   */
  @Test
  @DisplayName("Test equalOrGreater(Integer, Integer, ValidationContext); given 'Field Name'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.equalOrGreater(Integer, Integer, ValidationContext)"})
  void testEqualOrGreater_givenFieldName_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    CommonValidators.equalOrGreater(0, 1, ctx);

    // Assert
    verify(ctx).error(eq("Value of [Field Name] cannot be lower than the previous version: prior = [1], new = [0]"));
    verify(ctx).fieldName();
  }

  /**
   * Test {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}.
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then calls {@link ValidationContext#field()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName("Test sameOneOf(Object, Object, ValidationContext); given EUnexpected(); then calls field()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.sameOneOf(Object, Object, ValidationContext)"})
  void testSameOneOf_givenEUnexpected_thenCallsField() {
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
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link ValidationContext} {@link ValidationContext#isOneOf()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#sameOneOf(Object, Object, ValidationContext)}
   */
  @Test
  @DisplayName("Test sameOneOf(Object, Object, ValidationContext); given 'false'; when ValidationContext isOneOf() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext CommonValidators.sameOneOf(Object, Object, ValidationContext)"})
  void testSameOneOf_givenFalse_whenValidationContextIsOneOfReturnFalse() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.isOneOf()).thenReturn(false);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> CommonValidators.sameOneOf("Current", "Prior", ctx));
    verify(ctx).isOneOf();
  }

  /**
   * Test {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}.
   * <p>
   * Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}
   */
  @Test
  @DisplayName("Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"})
  void testEqualOrLaterVersion() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Version<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Version<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext5.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Version<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Version<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext10.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext9);
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
    verify(validationContext8).applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext7).applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext3).applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext2).applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
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
   * <ul>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonValidators#equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)}
   */
  @Test
  @DisplayName("Test equalOrLaterVersion(TagSelector, TagSelector, ValidationContext); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext CommonValidators.equalOrLaterVersion(TagSelector, TagSelector, ValidationContext)"})
  void testEqualOrLaterVersion_thenThrowEUnexpected() {
    // Arrange
    TagSelector current = TagSelector.getDefaultInstance();
    TagSelector prior = TagSelector.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Version<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Version<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext5.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Version<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Version<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.getErrors()).thenReturn(new ArrayList<>());
    when(validationContext10.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext9);
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
    assertThrows(EUnexpected.class, () -> CommonValidators.equalOrLaterVersion(current, prior, ctx));
    verify(validationContext15).apply(isA(Version.class));
    verify(validationContext12).apply(isA(Version.class));
    verify(validationContext9).apply(isA(Version.class));
    verify(validationContext4).apply(isA(Version.class));
    verify(validationContext8).applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext7).applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext3).applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext2).applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
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
}
