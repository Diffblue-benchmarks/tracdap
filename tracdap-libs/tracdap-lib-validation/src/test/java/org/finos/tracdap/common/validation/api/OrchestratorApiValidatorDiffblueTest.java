package org.finos.tracdap.common.validation.api;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import org.finos.tracdap.api.JobRequest;
import org.finos.tracdap.api.JobStatusRequest;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.common.validation.core.ValidationFunction.TypedArg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrchestratorApiValidatorDiffblueTest {
  /**
   * Test {@link OrchestratorApiValidator#validateJob(JobRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link OrchestratorApiValidator#validateJob(JobRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test validateJob(JobRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext OrchestratorApiValidator.validateJob(JobRequest, ValidationContext)"})
  void testValidateJob() {
    // Arrange
    JobRequest msg = JobRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
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
    when(validationContext10.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    // Act
    OrchestratorApiValidator.validateJob(msg, ctx);

    // Assert
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Typed.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link OrchestratorApiValidator#submitJob(JobRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link OrchestratorApiValidator#submitJob(JobRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test submitJob(JobRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext OrchestratorApiValidator.submitJob(JobRequest, ValidationContext)"})
  void testSubmitJob() {
    // Arrange
    JobRequest msg = JobRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
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
    when(validationContext10.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    // Act
    OrchestratorApiValidator.submitJob(msg, ctx);

    // Assert
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Typed.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link OrchestratorApiValidator#checkJob(JobStatusRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link OrchestratorApiValidator#checkJob(JobStatusRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test checkJob(JobStatusRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext OrchestratorApiValidator.checkJob(JobStatusRequest, ValidationContext)"})
  void testCheckJob() {
    // Arrange
    JobStatusRequest msg = JobStatusRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext);
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
    when(validationContext7.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    // Act
    OrchestratorApiValidator.checkJob(msg, ctx);

    // Assert
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Typed.class));
    verify(validationContext3).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
  }
}
