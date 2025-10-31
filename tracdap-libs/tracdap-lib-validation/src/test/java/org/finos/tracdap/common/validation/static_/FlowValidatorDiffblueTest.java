package org.finos.tracdap.common.validation.static_;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#applyRepeated(Typed, Class)} throw {@link EUnexpected#EUnexpected()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test flow(FlowDefinition, ValidationContext); given ValidationContext applyRepeated(Typed, Class) throw EUnexpected()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextApplyRepeatedThrowEUnexpected() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyMapValues(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext7);
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test flow(FlowDefinition, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextApplyThrowEUnexpected_thenThrowEUnexpected() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Basic>any())).thenThrow(new EUnexpected());
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyMapValues(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext6);
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code false}.</li>
   *   <li>Then calls {@link ValidationContext#apply(Typed, Class)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test flow(FlowDefinition, ValidationContext); given ValidationContext failed() return 'false'; then calls apply(Typed, Class)")
  @Tag("MaintainedByDiffblue")
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
    when(validationContext3.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyMapValues(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext9);
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code true}.</li>
   *   <li>Then calls {@link ValidationContext#failed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test flow(FlowDefinition, ValidationContext); given ValidationContext failed() return 'true'; then calls failed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextFailedReturnTrue_thenCallsFailed() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(true);
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyMapValues(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext9);
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then calls {@link ValidationContext#failed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test flow(FlowDefinition, ValidationContext); given ValidationContext failed() throw EUnexpected(); then calls failed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextFailedThrowEUnexpected_thenCallsFailed() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenThrow(new EUnexpected());
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyMapValues(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext9);
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test flow(FlowDefinition, ValidationContext); given ValidationContext pop() throw EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextPopThrowEUnexpected_thenThrowEUnexpected() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyMapValues(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext8);
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pushRepeated(FieldDescriptor)} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flow(FlowDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test flow(FlowDefinition, ValidationContext); given ValidationContext pushRepeated(FieldDescriptor) throw EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext FlowValidator.flow(FlowDefinition, ValidationContext)"})
  void testFlow_givenValidationContextPushRepeatedThrowEUnexpected_thenThrowEUnexpected() {
    // Arrange
    FlowDefinition flow = FlowDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pushRepeated(Mockito.<FieldDescriptor>any())).thenThrow(new EUnexpected());
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyMapValues(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyMapKeys(Mockito.<Typed<String>>any())).thenReturn(validationContext5);
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Typed)} return {@link ValidationContext}.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Typed) return ValidationContext; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
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
    when(validationContext10.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);
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
    when(validationContext18.applyRepeated(Mockito.<Typed<String>>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pop()).thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyRepeated(Mockito.<Typed<String>>any())).thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.apply(Mockito.<Basic>any())).thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext26);
    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext27);
    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<Basic>any())).thenReturn(validationContext28);
    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext29);
    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.pop()).thenReturn(validationContext30);
    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.applyRepeated(Mockito.<Typed<String>>any())).thenReturn(validationContext31);
    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.apply(Mockito.<Basic>any())).thenReturn(validationContext32);
    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext33);
    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext34);
    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.apply(Mockito.<Basic>any())).thenReturn(validationContext35);
    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext36);
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Typed)} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowNode(FlowNode, ValidationContext); given ValidationContext apply(Typed) throw EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextApplyThrowEUnexpected_thenThrowEUnexpected() {
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
    when(validationContext9.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);
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
    when(validationContext17.applyRepeated(Mockito.<Typed<String>>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Basic>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.pop()).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.applyRepeated(Mockito.<Typed<String>>any())).thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Basic>any())).thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext26);
    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.apply(Mockito.<Basic>any())).thenReturn(validationContext27);
    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext28);
    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.pop()).thenReturn(validationContext29);
    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.applyRepeated(Mockito.<Typed<String>>any())).thenReturn(validationContext30);
    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.apply(Mockito.<Basic>any())).thenReturn(validationContext31);
    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext32);
    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext33);
    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.apply(Mockito.<Basic>any())).thenReturn(validationContext34);
    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext35);
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowNode(FlowNode, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowNode(FlowNode, ValidationContext); given ValidationContext pop() throw EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext FlowValidator.flowNode(FlowNode, ValidationContext)"})
  void testFlowNode_givenValidationContextPopThrowEUnexpected_thenThrowEUnexpected() {
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
    when(validationContext10.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);
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
    when(validationContext18.applyRepeated(Mockito.<Typed<String>>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pop()).thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyRepeated(Mockito.<Typed<String>>any())).thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.apply(Mockito.<Basic>any())).thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext26);
    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext27);
    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<Basic>any())).thenReturn(validationContext28);
    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext29);
    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.pop()).thenReturn(validationContext30);
    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.applyRepeated(Mockito.<Typed<String>>any())).thenReturn(validationContext31);
    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.apply(Mockito.<Basic>any())).thenReturn(validationContext32);
    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext33);
    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext34);
    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.apply(Mockito.<Basic>any())).thenReturn(validationContext35);
    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext36);
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
   * Test {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}.
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>When {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} throw {@link EUnexpected#EUnexpected()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowSocket(FlowSocket, ValidationContext); given EUnexpected(); when ValidationContext push(FieldDescriptor) throw EUnexpected()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Typed)} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then calls {@link ValidationContext#apply(Typed)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowSocket(FlowSocket, ValidationContext); given ValidationContext apply(Typed) throw EUnexpected(); then calls apply(Typed)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Typed)} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then calls {@link ValidationContext#pop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowSocket(FlowSocket, ValidationContext); given ValidationContext apply(Typed) throw EUnexpected(); then calls pop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext FlowValidator.flowSocket(FlowSocket, ValidationContext)"})
  void testFlowSocket_givenValidationContextApplyThrowEUnexpected_thenCallsPop() {
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then calls {@link ValidationContext#pop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowSocket(FlowSocket, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then calls pop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext FlowValidator.flowSocket(FlowSocket, ValidationContext)"})
  void testFlowSocket_givenValidationContextApplyThrowEUnexpected_thenCallsPop2() {
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Basic)} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowSocket(FlowSocket, ValidationContext); given ValidationContext apply(Basic) throw EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then calls {@link ValidationContext#pop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowSocket(FlowSocket, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls pop()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then calls {@link ValidationContext#pop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowSocket(FlowSocket, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls pop()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} return {@link ValidationContext}.</li>
   *   <li>Then calls {@link ValidationContext#pop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowSocket(FlowSocket, ValidationContext); given ValidationContext push(FieldDescriptor) return ValidationContext; then calls pop()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} throw {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then calls {@link ValidationContext#pop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowValidator#flowSocket(FlowSocket, ValidationContext)}
   */
  @Test
  @DisplayName("Test flowSocket(FlowSocket, ValidationContext); given ValidationContext push(FieldDescriptor) throw EUnexpected(); then calls pop()")
  @Tag("MaintainedByDiffblue")
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
