package org.finos.tracdap.common.validation.version;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.DataDefinition;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataVersionValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link DataVersionValidator#data(DataDefinition, DataDefinition, ValidationContext)}
   */
  @Test
  void testData() {
    // Arrange
    DataDefinition current = DataDefinition.getDefaultInstance();
    DataDefinition prior = DataDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyOneOf(Mockito.<Descriptors.FieldDescriptor>any(),
        Mockito.<ValidationFunction.Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyOneOf(Mockito.<Descriptors.FieldDescriptor>any(),
        Mockito.<ValidationFunction.Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Version<Object>>any())).thenReturn(validationContext6);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext7);

    // Act
    DataVersionValidator.data(current, prior, ctx);

    // Assert
    verify(validationContext7).apply(isA(ValidationFunction.Version.class));
    verify(validationContext2).apply(isA(ValidationFunction.Version.class), isA(Class.class));
    verify(validationContext6).applyOneOf(isA(Descriptors.FieldDescriptor.class), isA(ValidationFunction.Version.class),
        isA(Class.class));
    verify(validationContext5).applyOneOf(isA(Descriptors.FieldDescriptor.class), isA(ValidationFunction.Version.class),
        isA(Class.class));
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(validationContext3).push(isA(Descriptors.FieldDescriptor.class));
    verify(ctx).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }
}
