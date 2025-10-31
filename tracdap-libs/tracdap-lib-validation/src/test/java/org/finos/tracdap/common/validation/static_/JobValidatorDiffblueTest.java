package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.ImportModelJob;
import org.finos.tracdap.metadata.JobDefinition;
import org.finos.tracdap.metadata.RunFlowJob;
import org.finos.tracdap.metadata.RunModelJob;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobValidatorDiffblueTest {
  /**
   * Method under test: {@link JobValidator#job(JobDefinition, ValidationContext)}
   */
  @Test
  void testJob() {
    // Arrange
    JobDefinition msg = JobDefinition.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(mock(ValidationContext.class));

    // Act
    JobValidator.job(msg, ctx);

    // Assert
    verify(ctx).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
  }

  /**
   * Method under test:
   * {@link JobValidator#job(JobDefinition, boolean, ValidationContext)}
   */
  @Test
  void testJob2() {
    // Arrange
    JobDefinition msg = JobDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRegistered()).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext13);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext14);

    // Act
    JobValidator.job(msg, true, ctx);

    // Assert
    verify(validationContext14).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext10).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext9).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext5).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext13).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext4).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext8).applyRegistered();
    verify(validationContext12).pop();
    verify(validationContext7).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext6).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext11).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobValidator#job(JobDefinition, boolean, ValidationContext)}
   */
  @Test
  void testJob3() {
    // Arrange
    JobDefinition msg = JobDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRegistered()).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext13);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext14);

    // Act
    JobValidator.job(msg, false, ctx);

    // Assert
    verify(validationContext14).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext10).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext9).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext5).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext13).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext4).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext8).applyRegistered();
    verify(validationContext12).pop();
    verify(validationContext7).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext6).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext11).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobValidator#jobRequest(JobDefinition, ValidationContext)}
   */
  @Test
  void testJobRequest() {
    // Arrange
    JobDefinition msg = JobDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(mock(ValidationContext.class));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext);

    // Act
    JobValidator.jobRequest(msg, ctx);

    // Assert
    verify(validationContext).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(ctx).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
  }

  /**
   * Method under test:
   * {@link JobValidator#importModelJob(ImportModelJob, ValidationContext)}
   */
  @Test
  void testImportModelJob() {
    // Arrange
    ImportModelJob msg = ImportModelJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pop()).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext18);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext19);

    // Act
    JobValidator.importModelJob(msg, ctx);

    // Assert
    verify(validationContext19).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext15).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext11).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext7).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext18).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext14).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext10).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext6).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext17).pop();
    verify(validationContext13).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext16).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext12).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext8).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobValidator#runModelJob(RunModelJob, ValidationContext)}
   */
  @Test
  void testRunModelJob() {
    // Arrange
    RunModelJob msg = RunModelJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyMapValues(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyMapValues(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyMapValues(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.pop()).thenReturn(validationContext26);
    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext27);
    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext28);
    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext29);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext30);

    // Act
    JobValidator.runModelJob(msg, ctx);

    // Assert
    verify(validationContext30).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext29).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext28).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext25).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext24).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext20).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext19).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext13).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext12).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext6).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext5).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext23).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext18).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext16).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext11).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext9).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext4).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext17).applyMapValues(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext10).applyMapValues(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext3).applyMapValues(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext27).pop();
    verify(validationContext22).pop();
    verify(validationContext15).pop();
    verify(validationContext8).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext26).pushMap(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext21).pushMap(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext14).pushMap(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext7).pushMap(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobValidator#runFlowJob(RunFlowJob, ValidationContext)}
   */
  @Test
  void testRunFlowJob() {
    // Arrange
    RunFlowJob msg = RunFlowJob.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyMapValues(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyMapValues(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyMapValues(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.pop()).thenReturn(validationContext26);
    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext27);
    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.applyMapValues(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext28);
    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext29);
    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext30);
    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext31);
    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext32);
    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.pop()).thenReturn(validationContext33);
    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext34);
    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext35);
    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext36);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext37);

    // Act
    JobValidator.runFlowJob(msg, ctx);

    // Assert
    verify(validationContext37).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext36).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext35).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext32).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext31).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext25).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext24).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext20).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext19).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext13).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext12).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext6).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext5).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext30).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext28).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext23).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext18).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext16).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext11).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext9).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext4).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext29).applyMapValues(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext17).applyMapValues(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext10).applyMapValues(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext3).applyMapValues(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext34).pop();
    verify(validationContext27).pop();
    verify(validationContext22).pop();
    verify(validationContext15).pop();
    verify(validationContext8).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext33).pushMap(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext26).pushMap(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext21).pushMap(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext14).pushMap(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext7).pushMap(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link JobValidator#runModelOrFlow(ValidationContext, Descriptors.FieldDescriptor, Descriptors.FieldDescriptor, Descriptors.FieldDescriptor, Descriptors.FieldDescriptor)}
   */
  @Test
  void testRunModelOrFlow() {
    // Arrange
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyMapValues(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyMapValues(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyMapValues(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext24);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext25);

    // Act
    JobValidator.runModelOrFlow(ctx, null, null, null, null);

    // Assert
    verify(validationContext25).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext24).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext20).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext19).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext13).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext12).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext6).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext5).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext23).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext18).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext16).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext11).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext9).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext4).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext17).applyMapValues(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext10).applyMapValues(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext3).applyMapValues(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext22).pop();
    verify(validationContext15).pop();
    verify(validationContext8).pop();
    verify(validationContext).pop();
    verify(ctx).pushMap(isNull());
    verify(validationContext21).pushMap(isNull());
    verify(validationContext14).pushMap(isNull());
    verify(validationContext7).pushMap(isNull());
  }

  /**
   * Method under test:
   * {@link JobValidator#outputsMustBeEmpty(JobDefinition, ValidationContext)}
   */
  @Test
  void testOutputsMustBeEmpty() {
    // Arrange
    JobDefinition msg = JobDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext);

    // Act
    JobValidator.outputsMustBeEmpty(msg, ctx);

    // Assert
    verify(validationContext).pop();
    verify(ctx).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }
}
