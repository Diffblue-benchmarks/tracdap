package org.finos.tracdap.common.validation.consistency;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.metadata.ImportModelJob;
import org.finos.tracdap.metadata.JobDefinition;
import org.finos.tracdap.metadata.RunFlowJob;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobConsistencyValidatorDiffblueTest {
  /**
   * Test {@link JobConsistencyValidator#job(JobDefinition, ValidationContext)}.
   * <p>
   * Method under test: {@link JobConsistencyValidator#job(JobDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test job(JobDefinition, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext JobConsistencyValidator.job(JobDefinition, ValidationContext)"})
  void testJob() {
    // Arrange
    JobDefinition job = JobDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.job(job, ctx));
    verify(validationContext2).applyRegistered();
    verify(validationContext).pop();
    verify(ctx).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link JobConsistencyValidator#job(JobDefinition, ValidationContext)}.
   * <p>
   * Method under test: {@link JobConsistencyValidator#job(JobDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test job(JobDefinition, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext JobConsistencyValidator.job(JobDefinition, ValidationContext)"})
  void testJob2() {
    // Arrange
    JobDefinition job = JobDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRegistered()).thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.job(job, ctx));
    verify(validationContext).applyRegistered();
    verify(ctx).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link JobConsistencyValidator#job(JobDefinition, ValidationContext)}.
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} return {@link ValidationContext}.</li>
   *   <li>Then calls {@link ValidationContext#pop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConsistencyValidator#job(JobDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test job(JobDefinition, ValidationContext); given ValidationContext pop() return ValidationContext; then calls pop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext JobConsistencyValidator.job(JobDefinition, ValidationContext)"})
  void testJob_givenValidationContextPopReturnValidationContext_thenCallsPop() {
    // Arrange
    JobDefinition job = JobDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext2);

    // Act
    JobConsistencyValidator.job(job, ctx);

    // Assert
    verify(validationContext2).applyRegistered();
    verify(validationContext).pop();
    verify(ctx).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link JobConsistencyValidator#importModelJob(ImportModelJob, ValidationContext)}.
   * <p>
   * Method under test: {@link JobConsistencyValidator#importModelJob(ImportModelJob, ValidationContext)}
   */
  @Test
  @DisplayName("Test importModelJob(ImportModelJob, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext JobConsistencyValidator.importModelJob(ImportModelJob, ValidationContext)"})
  void testImportModelJob() {
    // Arrange
    ImportModelJob job = ImportModelJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.importModelJob(job, ctx));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link JobConsistencyValidator#importModelJob(ImportModelJob, ValidationContext)}.
   * <p>
   * Method under test: {@link JobConsistencyValidator#importModelJob(ImportModelJob, ValidationContext)}
   */
  @Test
  @DisplayName("Test importModelJob(ImportModelJob, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext JobConsistencyValidator.importModelJob(ImportModelJob, ValidationContext)"})
  void testImportModelJob2() {
    // Arrange
    ImportModelJob job = ImportModelJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Typed<String>>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.importModelJob(job, ctx));
    verify(validationContext).apply(isA(Typed.class));
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link JobConsistencyValidator#importModelJob(ImportModelJob, ValidationContext)}.
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} return {@link ValidationContext}.</li>
   *   <li>Then calls {@link ValidationContext#pop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConsistencyValidator#importModelJob(ImportModelJob, ValidationContext)}
   */
  @Test
  @DisplayName("Test importModelJob(ImportModelJob, ValidationContext); given ValidationContext pop() return ValidationContext; then calls pop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext JobConsistencyValidator.importModelJob(ImportModelJob, ValidationContext)"})
  void testImportModelJob_givenValidationContextPopReturnValidationContext_thenCallsPop() {
    // Arrange
    ImportModelJob job = ImportModelJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    // Act
    JobConsistencyValidator.importModelJob(job, ctx);

    // Assert
    verify(validationContext2, atLeast(1)).apply(Mockito.<Typed<String>>any());
    verify(validationContext, atLeast(1)).pop();
    verify(ctx, atLeast(1)).push(Mockito.<FieldDescriptor>any());
  }

  /**
   * Test {@link JobConsistencyValidator#runFlowJob(RunFlowJob, ValidationContext)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link ValidationContext} {@link ValidationContext#failed()} return {@code true}.</li>
   *   <li>Then calls {@link ValidationContext#failed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConsistencyValidator#runFlowJob(RunFlowJob, ValidationContext)}
   */
  @Test
  @DisplayName("Test runFlowJob(RunFlowJob, ValidationContext); given 'true'; when ValidationContext failed() return 'true'; then calls failed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext JobConsistencyValidator.runFlowJob(RunFlowJob, ValidationContext)"})
  void testRunFlowJob_givenTrue_whenValidationContextFailedReturnTrue_thenCallsFailed() {
    // Arrange
    RunFlowJob job = RunFlowJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.failed()).thenReturn(true);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    JobConsistencyValidator.runFlowJob(job, ctx);

    // Assert
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(ctx).failed();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link JobConsistencyValidator#runFlowJob(RunFlowJob, ValidationContext)}.
   * <ul>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConsistencyValidator#runFlowJob(RunFlowJob, ValidationContext)}
   */
  @Test
  @DisplayName("Test runFlowJob(RunFlowJob, ValidationContext); then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext JobConsistencyValidator.runFlowJob(RunFlowJob, ValidationContext)"})
  void testRunFlowJob_thenThrowETracInternal() {
    // Arrange
    RunFlowJob job = RunFlowJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.runFlowJob(job, ctx));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }
}
