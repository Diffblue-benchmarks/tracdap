package org.finos.tracdap.common.validation.static_;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.metadata.FlowDefinition;
import org.finos.tracdap.metadata.FlowNode;
import org.finos.tracdap.metadata.FlowSocket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowValidatorDiffblueTest {
  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link ValidationContext} {@link ValidationContext#pushMap(FieldDescriptor)} throw
   *       {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given EUnexpected(); when ValidationContext pushMap(FieldDescriptor) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenEUnexpected_whenValidationContextPushMapThrowEUnexpected() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(ctx).pushMap(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyMapKeys(Typed)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext applyMapKeys(Typed) throw EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextApplyMapKeysThrowEUnexpected_thenThrowEUnexpected() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyMapKeys(Mockito.<Typed<String>>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext).applyMapKeys(isA(Typed.class));
    verify(ctx).pushMap(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyMapKeys(Typed)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext applyMapKeys(Typed) throw EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextApplyMapKeysThrowEUnexpected_thenThrowEUnexpected2() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyMapKeys(Mockito.<Typed<String>>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).applyMapKeys(isA(Typed.class));
    verify(validationContext).applyMapKeys(isA(Typed.class));
    verify(ctx).pushMap(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyMapValues(Typed, Class)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext applyMapValues(Typed, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextApplyMapValuesThrowEUnexpected() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyMapValues(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext4).applyMapKeys(isA(Typed.class));
    verify(validationContext3).applyMapKeys(isA(Typed.class));
    verify(validationContext).applyMapValues(isA(Typed.class), isA(Class.class));
    verify(ctx).pushMap(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed, Class)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext applyRepeated(Typed, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextApplyRepeatedThrowEUnexpected() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyMapValues(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext8).applyMapKeys(isA(Typed.class));
    verify(validationContext7).applyMapKeys(isA(Typed.class));
    verify(validationContext5).applyMapValues(isA(Typed.class), isA(Class.class));
    verify(validationContext).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext4).pop();
    verify(ctx).pushMap(isA(FieldDescriptor.class));
    verify(validationContext3).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pushRepeated(FieldDescriptor)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then calls pushRepeated(FieldDescriptor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextApplyThrowEUnexpected_thenCallsPushRepeated() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyMapValues(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext7).applyMapKeys(isA(Typed.class));
    verify(validationContext6).applyMapKeys(isA(Typed.class));
    verify(validationContext4).applyMapValues(isA(Typed.class), isA(Class.class));
    verify(validationContext3).pop();
    verify(ctx).pushMap(isA(FieldDescriptor.class));
    verify(validationContext2).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextApplyThrowEUnexpected_thenThrowEUnexpected() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(validationContext).apply(isA(Basic.class));
    verify(ctx).pushMap(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextApplyThrowEUnexpected_thenThrowEUnexpected2() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext3).applyMapKeys(isA(Typed.class));
    verify(validationContext2).applyMapKeys(isA(Typed.class));
    verify(ctx).pushMap(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code false}.
   *   <li>Then calls {@link ValidationContext#apply(Typed, Class)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext failed() return 'false'; then calls apply(Typed, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextFailedReturnFalse_thenCallsApply() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(false);
    when(validationContext.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyMapValues(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    // Act
    FlowValidator.flow(flow, ctx);

    // Assert
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyMapKeys(isA(Typed.class));
    verify(validationContext9).applyMapKeys(isA(Typed.class));
    verify(validationContext7).applyMapValues(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext).failed();
    verify(validationContext6).pop();
    verify(validationContext2).pop();
    verify(ctx).pushMap(isA(FieldDescriptor.class));
    verify(validationContext5).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code true}.
   *   <li>Then calls {@link ValidationContext#failed()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext failed() return 'true'; then calls failed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextFailedReturnTrue_thenCallsFailed() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(true);

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyMapValues(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    // Act
    FlowValidator.flow(flow, ctx);

    // Assert
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext10).applyMapKeys(isA(Typed.class));
    verify(validationContext9).applyMapKeys(isA(Typed.class));
    verify(validationContext7).applyMapValues(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext).failed();
    verify(validationContext6).pop();
    verify(validationContext2).pop();
    verify(ctx).pushMap(isA(FieldDescriptor.class));
    verify(validationContext5).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#failed()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext failed() throw EUnexpected(); then calls failed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextFailedThrowEUnexpected_thenCallsFailed() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyMapValues(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext10).applyMapKeys(isA(Typed.class));
    verify(validationContext9).applyMapKeys(isA(Typed.class));
    verify(validationContext7).applyMapValues(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext).failed();
    verify(validationContext6).pop();
    verify(validationContext2).pop();
    verify(ctx).pushMap(isA(FieldDescriptor.class));
    verify(validationContext5).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed, Class)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls applyRepeated(Typed, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextPopThrowEUnexpected_thenCallsApplyRepeated() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyMapValues(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext9).applyMapKeys(isA(Typed.class));
    verify(validationContext8).applyMapKeys(isA(Typed.class));
    verify(validationContext6).applyMapValues(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).pushMap(isA(FieldDescriptor.class));
    verify(validationContext4).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextPopThrowEUnexpected_thenCallsPop() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyMapValues(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext5).applyMapKeys(isA(Typed.class));
    verify(validationContext4).applyMapKeys(isA(Typed.class));
    verify(validationContext2).applyMapValues(isA(Typed.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).pushMap(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flow(FlowDefinition, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pushRepeated(FieldDescriptor)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flow(FlowDefinition, ValidationContext); given ValidationContext pushRepeated(FieldDescriptor) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextPushRepeatedThrowEUnexpected() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyMapValues(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyMapKeys(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flow(flow, ctx));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext6).applyMapKeys(isA(Typed.class));
    verify(validationContext5).applyMapKeys(isA(Typed.class));
    verify(validationContext3).applyMapValues(isA(Typed.class), isA(Class.class));
    verify(validationContext2).pop();
    verify(ctx).pushMap(isA(FieldDescriptor.class));
    verify(validationContext).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} throw
   *       {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given EUnexpected(); when ValidationContext push(FieldDescriptor) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenEUnexpected_whenValidationContextPushThrowEUnexpected() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed, Class)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext applyRepeated(Typed, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyRepeatedThrowEUnexpected() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext4).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext3).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed, Class)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext applyRepeated(Typed, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyRepeatedThrowEUnexpected2() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext5).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext4).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed)} throw
   *       {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext applyRepeated(Typed) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyRepeatedThrowEUnexpected3() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(Mockito.<Typed<String>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext).applyRepeated(isA(Typed.class));
    verify(validationContext4).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext7).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext6).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed, Class)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext applyRepeated(Typed, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyRepeatedThrowEUnexpected4() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Basic>any())).thenReturn(validationContext12);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext13);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext13).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext12).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext5).applyRepeated(isA(Typed.class));
    verify(validationContext8).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext7).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext11).pop();
    verify(validationContext4).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext10).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext3).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed, Class)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext applyRepeated(Typed, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyRepeatedThrowEUnexpected5() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext13).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).applyRepeated(isA(Typed.class));
    verify(validationContext9).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext8).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext12).pop();
    verify(validationContext5).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext11).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext4).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed)} throw
   *       {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext applyRepeated(Typed) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyRepeatedThrowEUnexpected6() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(Mockito.<Typed<String>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pop()).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext15).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext8).applyRepeated(isA(Typed.class));
    verify(validationContext).applyRepeated(isA(Typed.class));
    verify(validationContext11).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext4).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext14).pop();
    verify(validationContext7).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext13).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext6).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed, Class)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext applyRepeated(Typed, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyRepeatedThrowEUnexpected7() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Basic>any())).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Basic>any())).thenReturn(validationContext19);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext20);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext20).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext13).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(Typed.class));
    verify(validationContext5).applyRepeated(isA(Typed.class));
    verify(validationContext15).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext14).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext8).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext7).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext18).pop();
    verify(validationContext11).pop();
    verify(validationContext4).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext17).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext10).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext3).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed, Class)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext applyRepeated(Typed, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyRepeatedThrowEUnexpected8() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Basic>any())).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.pop()).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Basic>any())).thenReturn(validationContext20);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext21);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext21).apply(isA(Basic.class));
    verify(validationContext17).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext20).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(Typed.class));
    verify(validationContext6).applyRepeated(isA(Typed.class));
    verify(validationContext16).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext15).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext9).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext8).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext19).pop();
    verify(validationContext12).pop();
    verify(validationContext5).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext18).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext11).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext4).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed)} throw
   *       {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext applyRepeated(Typed) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyRepeatedThrowEUnexpected9() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(Mockito.<Typed<String>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pop()).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pop()).thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Basic>any())).thenReturn(validationContext22);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext23);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext23).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext15).applyRepeated(isA(Typed.class));
    verify(validationContext8).applyRepeated(isA(Typed.class));
    verify(validationContext).applyRepeated(isA(Typed.class));
    verify(validationContext18).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext17).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext11).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext4).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext21).pop();
    verify(validationContext14).pop();
    verify(validationContext7).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext20).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext13).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext6).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed, Class)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext applyRepeated(Typed, Class) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyRepeatedThrowEUnexpected10() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Basic>any())).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Basic>any())).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Basic>any())).thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Basic>any())).thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.apply(Mockito.<Basic>any())).thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.pop()).thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext29);

    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.apply(Mockito.<Basic>any())).thenReturn(validationContext30);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext31);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext31).apply(isA(Basic.class));
    verify(validationContext27).apply(isA(Basic.class));
    verify(validationContext24).apply(isA(Basic.class));
    verify(validationContext20).apply(isA(Basic.class));
    verify(validationContext17).apply(isA(Basic.class));
    verify(validationContext13).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext30).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext5).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext23).applyRepeated(isA(Typed.class));
    verify(validationContext16).applyRepeated(isA(Typed.class));
    verify(validationContext9).applyRepeated(isA(Typed.class));
    verify(validationContext26).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext25).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext19).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext18).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext11).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext29).pop();
    verify(validationContext22).pop();
    verify(validationContext15).pop();
    verify(validationContext8).pop();
    verify(validationContext4).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext7).push(isA(FieldDescriptor.class));
    verify(validationContext28).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext21).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext14).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext3).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Typed)} return {@link
   *       ValidationContext}.
   *   <li>Then calls {@link ValidationContext#apply(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Typed) return ValidationContext; then calls apply(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyReturnValidationContext_thenCallsApply() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Basic>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pop()).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pop()).thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.apply(Mockito.<Basic>any())).thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<Basic>any())).thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext29);

    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.pop()).thenReturn(validationContext30);

    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext31);

    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.apply(Mockito.<Basic>any())).thenReturn(validationContext32);

    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext33);

    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext34);

    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.apply(Mockito.<Basic>any())).thenReturn(validationContext35);

    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext36);

    ValidationContext validationContext38 = mock(ValidationContext.class);
    when(validationContext38.pop()).thenReturn(validationContext37);

    ValidationContext validationContext39 = mock(ValidationContext.class);
    when(validationContext39.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext38);

    ValidationContext validationContext40 = mock(ValidationContext.class);
    when(validationContext40.apply(Mockito.<Basic>any())).thenReturn(validationContext39);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext40);

    // Act
    FlowValidator.flowNode(msg, ctx);

    // Assert
    verify(validationContext40).apply(isA(Basic.class));
    verify(validationContext36).apply(isA(Basic.class));
    verify(validationContext33).apply(isA(Basic.class));
    verify(validationContext29).apply(isA(Basic.class));
    verify(validationContext26).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext15).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext39).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext14).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext32).applyRepeated(isA(Typed.class));
    verify(validationContext25).applyRepeated(isA(Typed.class));
    verify(validationContext18).applyRepeated(isA(Typed.class));
    verify(validationContext35).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext34).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext28).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext27).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext21).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext20).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext38).pop();
    verify(validationContext31).pop();
    verify(validationContext24).pop();
    verify(validationContext17).pop();
    verify(validationContext13).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext16).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
    verify(validationContext8).pushMap(isA(FieldDescriptor.class));
    verify(validationContext37).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext30).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext23).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext12).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Typed)} return {@link
   *       ValidationContext}.
   *   <li>Then calls {@link ValidationContext#apply(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Typed) return ValidationContext; then calls apply(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyReturnValidationContext_thenCallsApply2() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Basic>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pop()).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pop()).thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.apply(Mockito.<Basic>any())).thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<Basic>any())).thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext29);

    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.pop()).thenReturn(validationContext30);

    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext31);

    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.apply(Mockito.<Basic>any())).thenReturn(validationContext32);

    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext33);

    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext34);

    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.apply(Mockito.<Basic>any())).thenReturn(validationContext35);

    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext36);

    ValidationContext validationContext38 = mock(ValidationContext.class);
    when(validationContext38.pop()).thenReturn(validationContext37);

    ValidationContext validationContext39 = mock(ValidationContext.class);
    when(validationContext39.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext38);

    ValidationContext validationContext40 = mock(ValidationContext.class);
    when(validationContext40.apply(Mockito.<Basic>any())).thenReturn(validationContext39);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext40);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext40).apply(isA(Basic.class));
    verify(validationContext36).apply(isA(Basic.class));
    verify(validationContext33).apply(isA(Basic.class));
    verify(validationContext29).apply(isA(Basic.class));
    verify(validationContext26).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext15).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext39).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext14).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext32).applyRepeated(isA(Typed.class));
    verify(validationContext25).applyRepeated(isA(Typed.class));
    verify(validationContext18).applyRepeated(isA(Typed.class));
    verify(validationContext35).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext34).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext28).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext27).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext21).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext20).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext38).pop();
    verify(validationContext31).pop();
    verify(validationContext24).pop();
    verify(validationContext17).pop();
    verify(validationContext13).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext16).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
    verify(validationContext8).pushMap(isA(FieldDescriptor.class));
    verify(validationContext37).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext30).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext23).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext12).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Typed, Class)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#apply(Typed, Class)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Typed, Class) throw EUnexpected(); then calls apply(Typed, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenCallsApply() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Typed.class), isA(Class.class));
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Typed)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#apply(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Typed) throw EUnexpected(); then calls apply(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenCallsApply2() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Typed<String>>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Basic>any())).thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.pop()).thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Basic>any())).thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.apply(Mockito.<Basic>any())).thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.pop()).thenReturn(validationContext29);

    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext30);

    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.apply(Mockito.<Basic>any())).thenReturn(validationContext31);

    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext32);

    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext33);

    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.apply(Mockito.<Basic>any())).thenReturn(validationContext34);

    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext35);

    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.pop()).thenReturn(validationContext36);

    ValidationContext validationContext38 = mock(ValidationContext.class);
    when(validationContext38.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext37);

    ValidationContext validationContext39 = mock(ValidationContext.class);
    when(validationContext39.apply(Mockito.<Basic>any())).thenReturn(validationContext38);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext39);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext39).apply(isA(Basic.class));
    verify(validationContext35).apply(isA(Basic.class));
    verify(validationContext32).apply(isA(Basic.class));
    verify(validationContext28).apply(isA(Basic.class));
    verify(validationContext25).apply(isA(Basic.class));
    verify(validationContext21).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Typed.class));
    verify(validationContext38).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext13).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext31).applyRepeated(isA(Typed.class));
    verify(validationContext24).applyRepeated(isA(Typed.class));
    verify(validationContext17).applyRepeated(isA(Typed.class));
    verify(validationContext34).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext33).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext27).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext26).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext20).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext19).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext9).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext37).pop();
    verify(validationContext30).pop();
    verify(validationContext23).pop();
    verify(validationContext16).pop();
    verify(validationContext12).pop();
    verify(validationContext8).pop();
    verify(validationContext4).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext15).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
    verify(validationContext7).pushMap(isA(FieldDescriptor.class));
    verify(validationContext36).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext29).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext22).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext11).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed, Class)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then calls applyRepeated(Typed, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenCallsApplyRepeated() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext6).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext5).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenCallsApplyRepeated2() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext12);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext4).applyRepeated(isA(Typed.class));
    verify(validationContext7).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext6).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext10).pop();
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext9).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext2).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenCallsApplyRepeated3() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Basic>any())).thenReturn(validationContext14);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext15);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext15).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext7).applyRepeated(isA(Typed.class));
    verify(validationContext10).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext9).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext13).pop();
    verify(validationContext6).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext12).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext5).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenCallsApplyRepeated4() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Basic>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pop()).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext19);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext15).apply(isA(Basic.class));
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext11).applyRepeated(isA(Typed.class));
    verify(validationContext4).applyRepeated(isA(Typed.class));
    verify(validationContext14).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext7).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext6).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext17).pop();
    verify(validationContext10).pop();
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext16).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext9).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext2).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenCallsApplyRepeated5() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Basic>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext22);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext15).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext21).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext14).applyRepeated(isA(Typed.class));
    verify(validationContext7).applyRepeated(isA(Typed.class));
    verify(validationContext17).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext16).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext9).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext20).pop();
    verify(validationContext13).pop();
    verify(validationContext6).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext19).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext12).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext5).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenCallsApplyRepeated6() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Basic>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pop()).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pop()).thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.apply(Mockito.<Basic>any())).thenReturn(validationContext25);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext26);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext26).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext15).apply(isA(Basic.class));
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext25).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext18).applyRepeated(isA(Typed.class));
    verify(validationContext11).applyRepeated(isA(Typed.class));
    verify(validationContext4).applyRepeated(isA(Typed.class));
    verify(validationContext21).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext20).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext14).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext7).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext6).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext24).pop();
    verify(validationContext17).pop();
    verify(validationContext10).pop();
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext2).push(isA(FieldDescriptor.class));
    verify(validationContext23).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext16).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext9).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Typed, Class)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Typed, Class) throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenCallsApplyRepeated7() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Basic>any())).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Basic>any())).thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Basic>any())).thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.pop()).thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.apply(Mockito.<Basic>any())).thenReturn(validationContext26);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext27);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext27).apply(isA(Basic.class));
    verify(validationContext23).apply(isA(Basic.class));
    verify(validationContext20).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext13).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext26).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext19).applyRepeated(isA(Typed.class));
    verify(validationContext12).applyRepeated(isA(Typed.class));
    verify(validationContext5).applyRepeated(isA(Typed.class));
    verify(validationContext22).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext21).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext15).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext14).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext8).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext7).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext25).pop();
    verify(validationContext18).pop();
    verify(validationContext11).pop();
    verify(validationContext4).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
    verify(validationContext24).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext17).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext10).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenCallsApplyRepeated8() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pop()).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pop()).thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Basic>any())).thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.apply(Mockito.<Basic>any())).thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.pop()).thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.apply(Mockito.<Basic>any())).thenReturn(validationContext29);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext30);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext30).apply(isA(Basic.class));
    verify(validationContext26).apply(isA(Basic.class));
    verify(validationContext23).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext29).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext4).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext22).applyRepeated(isA(Typed.class));
    verify(validationContext15).applyRepeated(isA(Typed.class));
    verify(validationContext8).applyRepeated(isA(Typed.class));
    verify(validationContext25).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext24).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext18).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext17).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext11).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext28).pop();
    verify(validationContext21).pop();
    verify(validationContext14).pop();
    verify(validationContext7).pop();
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext6).push(isA(FieldDescriptor.class));
    verify(validationContext27).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext20).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext13).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext2).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pushRepeated(FieldDescriptor)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then calls pushRepeated(FieldDescriptor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenCallsPushRepeated() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext2).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenThrowEUnexpected() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext).apply(isA(Basic.class));
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPopThrowEUnexpected_thenCallsApplyRepeated() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(Typed.class));
    verify(validationContext5).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext4).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext8).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext7).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPopThrowEUnexpected_thenCallsApplyRepeated2() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Basic>any())).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Basic>any())).thenReturn(validationContext16);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext17);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext17).apply(isA(Basic.class));
    verify(validationContext13).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext9).applyRepeated(isA(Typed.class));
    verify(validationContext2).applyRepeated(isA(Typed.class));
    verify(validationContext12).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext11).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext5).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext4).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext15).pop();
    verify(validationContext8).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext14).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext7).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPopThrowEUnexpected_thenCallsApplyRepeated3() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Basic>any())).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Basic>any())).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Basic>any())).thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Basic>any())).thenReturn(validationContext23);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext24);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext24).apply(isA(Basic.class));
    verify(validationContext20).apply(isA(Basic.class));
    verify(validationContext17).apply(isA(Basic.class));
    verify(validationContext13).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext23).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext16).applyRepeated(isA(Typed.class));
    verify(validationContext9).applyRepeated(isA(Typed.class));
    verify(validationContext2).applyRepeated(isA(Typed.class));
    verify(validationContext19).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext18).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext11).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext5).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext4).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext22).pop();
    verify(validationContext15).pop();
    verify(validationContext8).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext21).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext14).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext7).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPopThrowEUnexpected_thenCallsApplyRepeated4() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Basic>any())).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.pop()).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Basic>any())).thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Basic>any())).thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.pop()).thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.apply(Mockito.<Basic>any())).thenReturn(validationContext27);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext28);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext28).apply(isA(Basic.class));
    verify(validationContext24).apply(isA(Basic.class));
    verify(validationContext21).apply(isA(Basic.class));
    verify(validationContext17).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext27).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext20).applyRepeated(isA(Typed.class));
    verify(validationContext13).applyRepeated(isA(Typed.class));
    verify(validationContext6).applyRepeated(isA(Typed.class));
    verify(validationContext23).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext22).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext16).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext15).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext9).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext8).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext26).pop();
    verify(validationContext19).pop();
    verify(validationContext12).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
    verify(validationContext25).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext18).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext11).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPopThrowEUnexpected_thenCallsApplyRepeated5() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Basic>any())).thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.pop()).thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Basic>any())).thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.apply(Mockito.<Basic>any())).thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.pop()).thenReturn(validationContext29);

    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext30);

    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.apply(Mockito.<Basic>any())).thenReturn(validationContext31);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext32);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext32).apply(isA(Basic.class));
    verify(validationContext28).apply(isA(Basic.class));
    verify(validationContext25).apply(isA(Basic.class));
    verify(validationContext21).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext31).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext24).applyRepeated(isA(Typed.class));
    verify(validationContext17).applyRepeated(isA(Typed.class));
    verify(validationContext10).applyRepeated(isA(Typed.class));
    verify(validationContext27).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext26).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext20).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext19).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext30).pop();
    verify(validationContext23).pop();
    verify(validationContext16).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext29).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext22).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext15).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext4).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPopThrowEUnexpected_thenCallsPop() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pushMap(FieldDescriptor)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls pushMap(FieldDescriptor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPopThrowEUnexpected_thenCallsPushMap() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Basic>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Basic>any())).thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.pop()).thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<Basic>any())).thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext29);

    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext30);

    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.apply(Mockito.<Basic>any())).thenReturn(validationContext31);

    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext32);

    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.pop()).thenReturn(validationContext33);

    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext34);

    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.apply(Mockito.<Basic>any())).thenReturn(validationContext35);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext36);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext36).apply(isA(Basic.class));
    verify(validationContext32).apply(isA(Basic.class));
    verify(validationContext29).apply(isA(Basic.class));
    verify(validationContext25).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext15).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext35).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext10).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext28).applyRepeated(isA(Typed.class));
    verify(validationContext21).applyRepeated(isA(Typed.class));
    verify(validationContext14).applyRepeated(isA(Typed.class));
    verify(validationContext31).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext30).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext24).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext23).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext17).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext16).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext6).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext34).pop();
    verify(validationContext27).pop();
    verify(validationContext20).pop();
    verify(validationContext13).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext12).push(isA(FieldDescriptor.class));
    verify(validationContext4).pushMap(isA(FieldDescriptor.class));
    verify(validationContext33).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext26).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext19).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext8).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pushMap(FieldDescriptor)} return
   *       {@link ValidationContext}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pushMap(FieldDescriptor) return ValidationContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPushMapReturnValidationContext() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Basic>any())).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Basic>any())).thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Basic>any())).thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.pop()).thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.apply(Mockito.<Basic>any())).thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.apply(Mockito.<Basic>any())).thenReturn(validationContext29);

    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext30);

    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.pop()).thenReturn(validationContext31);

    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext32);

    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.apply(Mockito.<Basic>any())).thenReturn(validationContext33);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext34);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext34).apply(isA(Basic.class));
    verify(validationContext30).apply(isA(Basic.class));
    verify(validationContext27).apply(isA(Basic.class));
    verify(validationContext23).apply(isA(Basic.class));
    verify(validationContext20).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext13).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext33).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext26).applyRepeated(isA(Typed.class));
    verify(validationContext19).applyRepeated(isA(Typed.class));
    verify(validationContext12).applyRepeated(isA(Typed.class));
    verify(validationContext29).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext28).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext22).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext21).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext15).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext14).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext4).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext32).pop();
    verify(validationContext25).pop();
    verify(validationContext18).pop();
    verify(validationContext11).pop();
    verify(validationContext7).pop();
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext10).push(isA(FieldDescriptor.class));
    verify(validationContext2).pushMap(isA(FieldDescriptor.class));
    verify(validationContext31).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext24).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext17).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext6).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pushMap(FieldDescriptor)} return
   *       {@link ValidationContext}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pushMap(FieldDescriptor) return ValidationContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPushMapReturnValidationContext2() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Basic>any())).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.pop()).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Basic>any())).thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Basic>any())).thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.pop()).thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.apply(Mockito.<Basic>any())).thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext29);

    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.apply(Mockito.<Basic>any())).thenReturn(validationContext30);

    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext31);

    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.pop()).thenReturn(validationContext32);

    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext33);

    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.apply(Mockito.<Basic>any())).thenReturn(validationContext34);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext35);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext35).apply(isA(Basic.class));
    verify(validationContext31).apply(isA(Basic.class));
    verify(validationContext28).apply(isA(Basic.class));
    verify(validationContext24).apply(isA(Basic.class));
    verify(validationContext21).apply(isA(Basic.class));
    verify(validationContext17).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext34).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext9).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext27).applyRepeated(isA(Typed.class));
    verify(validationContext20).applyRepeated(isA(Typed.class));
    verify(validationContext13).applyRepeated(isA(Typed.class));
    verify(validationContext30).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext29).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext23).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext22).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext16).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext15).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext5).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext33).pop();
    verify(validationContext26).pop();
    verify(validationContext19).pop();
    verify(validationContext12).pop();
    verify(validationContext8).pop();
    verify(validationContext4).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext11).push(isA(FieldDescriptor.class));
    verify(validationContext3).pushMap(isA(FieldDescriptor.class));
    verify(validationContext32).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext25).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext18).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext7).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pushMap(FieldDescriptor)} return
   *       {@link ValidationContext}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pushMap(FieldDescriptor) return ValidationContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPushMapReturnValidationContext3() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Basic>any())).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Basic>any())).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Basic>any())).thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Basic>any())).thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.apply(Mockito.<Basic>any())).thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.pop()).thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext29);

    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.apply(Mockito.<Basic>any())).thenReturn(validationContext30);

    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext31);

    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext32);

    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.apply(Mockito.<Basic>any())).thenReturn(validationContext33);

    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext34);

    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.pop()).thenReturn(validationContext35);

    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext36);

    ValidationContext validationContext38 = mock(ValidationContext.class);
    when(validationContext38.apply(Mockito.<Basic>any())).thenReturn(validationContext37);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext38);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext38).apply(isA(Basic.class));
    verify(validationContext34).apply(isA(Basic.class));
    verify(validationContext31).apply(isA(Basic.class));
    verify(validationContext27).apply(isA(Basic.class));
    verify(validationContext24).apply(isA(Basic.class));
    verify(validationContext20).apply(isA(Basic.class));
    verify(validationContext17).apply(isA(Basic.class));
    verify(validationContext13).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext37).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext12).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext30).applyRepeated(isA(Typed.class));
    verify(validationContext23).applyRepeated(isA(Typed.class));
    verify(validationContext16).applyRepeated(isA(Typed.class));
    verify(validationContext33).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext32).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext26).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext25).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext19).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext18).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext8).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext36).pop();
    verify(validationContext29).pop();
    verify(validationContext22).pop();
    verify(validationContext15).pop();
    verify(validationContext11).pop();
    verify(validationContext7).pop();
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext14).push(isA(FieldDescriptor.class));
    verify(validationContext2).push(isA(FieldDescriptor.class));
    verify(validationContext6).pushMap(isA(FieldDescriptor.class));
    verify(validationContext35).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext28).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext21).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext10).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pushMap(FieldDescriptor)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pushMap(FieldDescriptor)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pushMap(FieldDescriptor) throw EUnexpected(); then calls pushMap(FieldDescriptor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPushMapThrowEUnexpected_thenCallsPushMap() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pushMap(Mockito.<FieldDescriptor>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Basic>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pop()).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pop()).thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.apply(Mockito.<Basic>any())).thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<Basic>any())).thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext29);

    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.pop()).thenReturn(validationContext30);

    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext31);

    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.apply(Mockito.<Basic>any())).thenReturn(validationContext32);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext33);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext33).apply(isA(Basic.class));
    verify(validationContext29).apply(isA(Basic.class));
    verify(validationContext26).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext15).apply(isA(Basic.class));
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext32).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext25).applyRepeated(isA(Typed.class));
    verify(validationContext18).applyRepeated(isA(Typed.class));
    verify(validationContext11).applyRepeated(isA(Typed.class));
    verify(validationContext28).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext27).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext21).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext20).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext14).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext31).pop();
    verify(validationContext24).pop();
    verify(validationContext17).pop();
    verify(validationContext10).pop();
    verify(validationContext6).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext9).push(isA(FieldDescriptor.class));
    verify(validationContext).pushMap(isA(FieldDescriptor.class));
    verify(validationContext30).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext23).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext16).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext5).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pushRepeated(FieldDescriptor)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pushRepeated(FieldDescriptor) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPushRepeatedThrowEUnexpected() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pushRepeated(FieldDescriptor)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pushRepeated(FieldDescriptor) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPushRepeatedThrowEUnexpected2() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class));
    verify(validationContext6).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext5).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext9).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext8).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pushRepeated(FieldDescriptor)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pushRepeated(FieldDescriptor) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPushRepeatedThrowEUnexpected3() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext17).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(Typed.class));
    verify(validationContext3).applyRepeated(isA(Typed.class));
    verify(validationContext13).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext6).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext5).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext16).pop();
    verify(validationContext9).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext15).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext8).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pushRepeated(FieldDescriptor)}
   *       throw {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext pushRepeated(FieldDescriptor) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPushRepeatedThrowEUnexpected4() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Basic>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Basic>any())).thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.pop()).thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<Basic>any())).thenReturn(validationContext28);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext29);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext29).apply(isA(Basic.class));
    verify(validationContext25).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext15).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext28).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext21).applyRepeated(isA(Typed.class));
    verify(validationContext14).applyRepeated(isA(Typed.class));
    verify(validationContext7).applyRepeated(isA(Typed.class));
    verify(validationContext24).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext23).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext17).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext16).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext9).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext27).pop();
    verify(validationContext20).pop();
    verify(validationContext13).pop();
    verify(validationContext6).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
    verify(validationContext26).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext19).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext12).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#applyRepeated(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext push(FieldDescriptor) throw EUnexpected(); then calls applyRepeated(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPushThrowEUnexpected_thenCallsApplyRepeated() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.push(Mockito.<FieldDescriptor>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Basic>any())).thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.pop()).thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Basic>any())).thenReturn(validationContext24);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext25);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext25).apply(isA(Basic.class));
    verify(validationContext21).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext24).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext17).applyRepeated(isA(Typed.class));
    verify(validationContext10).applyRepeated(isA(Typed.class));
    verify(validationContext3).applyRepeated(isA(Typed.class));
    verify(validationContext20).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext19).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext6).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext5).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext23).pop();
    verify(validationContext16).pop();
    verify(validationContext9).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext).push(isA(FieldDescriptor.class));
    verify(validationContext22).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext15).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext8).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowNode(FlowNode, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pushMap(FieldDescriptor)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowNode(FlowNode, ValidationContext); given ValidationContext push(FieldDescriptor) throw EUnexpected(); then calls pushMap(FieldDescriptor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPushThrowEUnexpected_thenCallsPushMap() {
    // Arrange
    FlowNode msg = FlowNode.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.push(Mockito.<FieldDescriptor>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pop()).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pop()).thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Basic>any())).thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext23);

    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext24);

    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.apply(Mockito.<Basic>any())).thenReturn(validationContext25);

    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext26);

    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.pop()).thenReturn(validationContext27);

    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.applyRepeated(Mockito.<Typed<String>>any()))
        .thenReturn(validationContext28);

    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.apply(Mockito.<Basic>any())).thenReturn(validationContext29);

    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext30);

    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext31);

    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.apply(Mockito.<Basic>any())).thenReturn(validationContext32);

    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext33);

    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.pop()).thenReturn(validationContext34);

    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext35);

    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.apply(Mockito.<Basic>any())).thenReturn(validationContext36);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext37);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowNode(msg, ctx));
    verify(validationContext37).apply(isA(Basic.class));
    verify(validationContext33).apply(isA(Basic.class));
    verify(validationContext30).apply(isA(Basic.class));
    verify(validationContext26).apply(isA(Basic.class));
    verify(validationContext23).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext36).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext11).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext29).applyRepeated(isA(Typed.class));
    verify(validationContext22).applyRepeated(isA(Typed.class));
    verify(validationContext15).applyRepeated(isA(Typed.class));
    verify(validationContext32).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext31).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext25).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext24).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext18).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext17).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext7).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext35).pop();
    verify(validationContext28).pop();
    verify(validationContext21).pop();
    verify(validationContext14).pop();
    verify(validationContext10).pop();
    verify(validationContext6).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext13).push(isA(FieldDescriptor.class));
    verify(validationContext).push(isA(FieldDescriptor.class));
    verify(validationContext5).pushMap(isA(FieldDescriptor.class));
    verify(validationContext34).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext27).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext20).pushRepeated(isA(FieldDescriptor.class));
    verify(validationContext9).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} throw
   *       {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowSocket(FlowSocket, ValidationContext); given EUnexpected(); when ValidationContext push(FieldDescriptor) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowSocket(FlowSocket, ValidationContext)"})
  void testFlowSocket_givenEUnexpected_whenValidationContextPushThrowEUnexpected() {
    // Arrange
    FlowSocket msg = FlowSocket.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowSocket(msg, ctx));
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Typed)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#apply(Typed)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowSocket(FlowSocket, ValidationContext); given ValidationContext apply(Typed) throw EUnexpected(); then calls apply(Typed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowSocket(FlowSocket, ValidationContext)"})
  void testFlowSocket_givenValidationContextApplyThrowEUnexpected_thenCallsApply() {
    // Arrange
    FlowSocket msg = FlowSocket.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Typed<String>>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowSocket(msg, ctx));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Typed.class));
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowSocket(FlowSocket, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowSocket(FlowSocket, ValidationContext)"})
  void testFlowSocket_givenValidationContextApplyThrowEUnexpected_thenCallsPop() {
    // Arrange
    FlowSocket msg = FlowSocket.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowSocket(msg, ctx));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Typed.class));
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext2).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Typed)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowSocket(FlowSocket, ValidationContext); given ValidationContext apply(Typed) throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowSocket(FlowSocket, ValidationContext)"})
  void testFlowSocket_givenValidationContextApplyThrowEUnexpected_thenCallsPop2() {
    // Arrange
    FlowSocket msg = FlowSocket.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Typed<String>>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowSocket(msg, ctx));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Typed.class));
    verify(validationContext).apply(isA(Typed.class));
    verify(validationContext4).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowSocket(FlowSocket, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowSocket(FlowSocket, ValidationContext)"})
  void testFlowSocket_givenValidationContextApplyThrowEUnexpected_thenThrowEUnexpected() {
    // Arrange
    FlowSocket msg = FlowSocket.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowSocket(msg, ctx));
    verify(validationContext).apply(isA(Basic.class));
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowSocket(FlowSocket, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowSocket(FlowSocket, ValidationContext)"})
  void testFlowSocket_givenValidationContextPopThrowEUnexpected_thenCallsPop() {
    // Arrange
    FlowSocket msg = FlowSocket.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowSocket(msg, ctx));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowSocket(FlowSocket, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowSocket(FlowSocket, ValidationContext)"})
  void testFlowSocket_givenValidationContextPopThrowEUnexpected_thenCallsPop2() {
    // Arrange
    FlowSocket msg = FlowSocket.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowSocket(msg, ctx));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} return
   *       {@link ValidationContext}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowSocket(FlowSocket, ValidationContext); given ValidationContext push(FieldDescriptor) return ValidationContext; then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowSocket(FlowSocket, ValidationContext)"})
  void testFlowSocket_givenValidationContextPushReturnValidationContext_thenCallsPop() {
    // Arrange
    FlowSocket msg = FlowSocket.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    // Act
    FlowValidator.flowSocket(msg, ctx);

    // Assert
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test flowSocket(FlowSocket, ValidationContext); given ValidationContext push(FieldDescriptor) throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext FlowValidator.flowSocket(FlowSocket, ValidationContext)"})
  void testFlowSocket_givenValidationContextPushThrowEUnexpected_thenCallsPop() {
    // Arrange
    FlowSocket msg = FlowSocket.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.push(Mockito.<FieldDescriptor>any())).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> FlowValidator.flowSocket(msg, ctx));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Typed.class));
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext).push(isA(FieldDescriptor.class));
  }
}
