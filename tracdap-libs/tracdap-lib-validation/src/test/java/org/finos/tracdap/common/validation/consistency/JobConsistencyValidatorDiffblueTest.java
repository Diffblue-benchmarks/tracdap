package org.finos.tracdap.common.validation.consistency;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.ImportModelJob;
import org.finos.tracdap.metadata.JobDefinition;
import org.finos.tracdap.metadata.RunFlowJob;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobConsistencyValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link JobConsistencyValidator#job(JobDefinition, ValidationContext)}
   */
  @Test
  void testJob() {
    // Arrange
    JobDefinition job = JobDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext2);

    // Act
    JobConsistencyValidator.job(job, ctx);

    // Assert
    verify(validationContext2).applyRegistered();
    verify(validationContext).pop();
    verify(ctx).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobConsistencyValidator#job(JobDefinition, ValidationContext)}
   */
  @Test
  void testJob2() {
    // Arrange
    JobDefinition job = JobDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.job(job, ctx));
    verify(validationContext2).applyRegistered();
    verify(validationContext).pop();
    verify(ctx).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobConsistencyValidator#job(JobDefinition, ValidationContext)}
   */
  @Test
  void testJob3() {
    // Arrange
    JobDefinition job = JobDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyRegistered()).thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.job(job, ctx));
    verify(validationContext).applyRegistered();
    verify(ctx).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobConsistencyValidator#job(JobDefinition, ValidationContext)}
   */
  @Test
  void testJob4() {
    // Arrange
    JobDefinition job = JobDefinition.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.job(job, ctx));
    verify(ctx).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobConsistencyValidator#importModelJob(ImportModelJob, ValidationContext)}
   */
  @Test
  void testImportModelJob() {
    // Arrange
    ImportModelJob job = ImportModelJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext2);

    // Act
    JobConsistencyValidator.importModelJob(job, ctx);

    // Assert
    verify(validationContext2, atLeast(1)).apply(Mockito.<ValidationFunction.Typed<String>>any());
    verify(validationContext, atLeast(1)).pop();
    verify(ctx, atLeast(1)).push(Mockito.<Descriptors.FieldDescriptor>any());
  }

  /**
   * Method under test:
   * {@link JobConsistencyValidator#importModelJob(ImportModelJob, ValidationContext)}
   */
  @Test
  void testImportModelJob2() {
    // Arrange
    ImportModelJob job = ImportModelJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.importModelJob(job, ctx));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobConsistencyValidator#importModelJob(ImportModelJob, ValidationContext)}
   */
  @Test
  void testImportModelJob3() {
    // Arrange
    ImportModelJob job = ImportModelJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.importModelJob(job, ctx));
    verify(validationContext).apply(isA(ValidationFunction.Typed.class));
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobConsistencyValidator#importModelJob(ImportModelJob, ValidationContext)}
   */
  @Test
  void testImportModelJob4() {
    // Arrange
    ImportModelJob job = ImportModelJob.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.importModelJob(job, ctx));
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobConsistencyValidator#runFlowJob(RunFlowJob, ValidationContext)}
   */
  @Test
  void testRunFlowJob() {
    // Arrange
    RunFlowJob job = RunFlowJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.failed()).thenReturn(true);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    JobConsistencyValidator.runFlowJob(job, ctx);

    // Assert
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(ctx).failed();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobConsistencyValidator#runFlowJob(RunFlowJob, ValidationContext)}
   */
  @Test
  void testRunFlowJob2() {
    // Arrange
    RunFlowJob job = RunFlowJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new ETracInternal("Not all who wander are lost"));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JobConsistencyValidator.runFlowJob(job, ctx));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }
}
