package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.ModelDefinition;
import org.finos.tracdap.metadata.ModelInputSchema;
import org.finos.tracdap.metadata.ModelOutputSchema;
import org.finos.tracdap.metadata.ModelParameter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ModelValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link ModelValidator#model(ModelDefinition, ValidationContext)}
   */
  @Test
  void testModel() {
    // Arrange
    ModelDefinition msg = ModelDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext3);
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
    when(validationContext10.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext10);
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
    when(validationContext17.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext17);
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
    when(validationContext23.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.pop()).thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext26);
    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext27);
    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext28);
    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.pop()).thenReturn(validationContext29);
    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext30);
    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext31);
    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext32);
    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.pop()).thenReturn(validationContext33);
    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext34);
    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext35);
    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext36);
    ValidationContext validationContext38 = mock(ValidationContext.class);
    when(validationContext38.pop()).thenReturn(validationContext37);
    ValidationContext validationContext39 = mock(ValidationContext.class);
    when(validationContext39.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext38);
    ValidationContext validationContext40 = mock(ValidationContext.class);
    when(validationContext40.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext39);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext40);

    // Act
    ModelValidator.model(msg, ctx);

    // Assert
    verify(validationContext40).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext36).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext32).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext28).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext24).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext18).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext11).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext4).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext39).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext35).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext31).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext27).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext23).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext20).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext19).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext17).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext13).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext12).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext10).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext6).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext5).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext3).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext16).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext9).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext38).pop();
    verify(validationContext34).pop();
    verify(validationContext30).pop();
    verify(validationContext26).pop();
    verify(validationContext22).pop();
    verify(validationContext15).pop();
    verify(validationContext8).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext37).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext33).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext29).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext25).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext21).pushMap(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext14).pushMap(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext7).pushMap(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link ModelValidator#modelDetails(Descriptors.FieldDescriptor, Descriptors.FieldDescriptor, Descriptors.FieldDescriptor, Descriptors.FieldDescriptor, Descriptors.FieldDescriptor, ValidationContext)}
   */
  @Test
  void testModelDetails() {
    // Arrange
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
    ModelValidator.modelDetails(null, null, null, null, null, ctx);

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
    verify(ctx).push(isNull());
    verify(validationContext16).push(isNull());
    verify(validationContext12).push(isNull());
    verify(validationContext8).push(isNull());
    verify(validationContext4).push(isNull());
  }

  /**
   * Method under test:
   * {@link ModelValidator#modelParameter(ModelParameter, ValidationContext)}
   */
  @Test
  void testModelParameter() {
    // Arrange
    ModelParameter msg = ModelParameter.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext5);
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
    when(validationContext14.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext14);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext15);

    // Act
    ModelValidator.modelParameter(msg, ctx);

    // Assert
    verify(validationContext15).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext11).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext7).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext10).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext14).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext13).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext12).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext8).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).pushMap(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link ModelValidator#modelInputSchema(ModelInputSchema, ValidationContext)}
   */
  @Test
  void testModelInputSchema() {
    // Arrange
    ModelInputSchema msg = ModelInputSchema.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);
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
    when(validationContext10.error(Mockito.<String>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext10);
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
    ModelValidator.modelInputSchema(msg, ctx);

    // Assert
    verify(validationContext14).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext7).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext6).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext13).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext10).error(eq("Object type [OBJECT_TYPE_NOT_SET] is not supported"));
    verify(validationContext12).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext11).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext8).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).pushMap(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link ModelValidator#modelOutputSchema(ModelOutputSchema, ValidationContext)}
   */
  @Test
  void testModelOutputSchema() {
    // Arrange
    ModelOutputSchema msg = ModelOutputSchema.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);
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
    when(validationContext10.error(Mockito.<String>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext10);
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
    ModelValidator.modelOutputSchema(msg, ctx);

    // Assert
    verify(validationContext14).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext7).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext6).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext13).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext10).error(eq("Object type [OBJECT_TYPE_NOT_SET] is not supported"));
    verify(validationContext12).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext11).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext8).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).pushMap(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link ModelValidator#modelEntryPoint(String, ValidationContext)}
   */
  @Test
  void testModelEntryPoint() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ModelValidator.modelEntryPoint("Model Entry Point", ctx);

    // Assert
    verify(ctx).error(eq("Invalid model entry point [Model Entry Point] (expected format: pkg.sub_pkg.ModelClass)"));
  }

  /**
   * Method under test:
   * {@link ModelValidator#modelVersion(String, ValidationContext)}
   */
  @Test
  void testModelVersion() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ModelValidator.modelVersion("Model Version", ctx);

    // Assert
    verify(ctx).error(eq(
        "Invalid model version [Model Version] (version can contain letters, numbers, hyphen, underscore and period, starting with a letter or number)"));
  }
}
