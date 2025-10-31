package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.DateValue;
import org.finos.tracdap.metadata.DatetimeValue;
import org.finos.tracdap.metadata.DecimalValue;
import org.finos.tracdap.metadata.TypeDescriptor;
import org.finos.tracdap.metadata.Value;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TypeSystemValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link TypeSystemValidator#typeDescriptor(TypeDescriptor, ValidationContext)}
   */
  @Test
  void testTypeDescriptor() {
    // Arrange
    TypeDescriptor typeDescriptor = TypeDescriptor.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext10);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext11);

    // Act
    TypeSystemValidator.typeDescriptor(typeDescriptor, ctx);

    // Assert
    verify(validationContext11).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext7).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext10).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext8).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link TypeSystemValidator#value(Value, ValidationContext)}
   */
  @Test
  void testValue() {
    // Arrange
    Value value = Value.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    TypeSystemValidator.value(value, ctx);

    // Assert
    verify(ctx).error(eq("Type cannot be inferred for null value"));
  }

  /**
   * Method under test:
   * {@link TypeSystemValidator#valueWithType(Value, TypeDescriptor, ValidationContext)}
   */
  @Test
  void testValueWithType() {
    // Arrange
    Value value = Value.getDefaultInstance();
    TypeDescriptor expectedType = TypeDescriptor.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    TypeSystemValidator.valueWithType(value, expectedType, ctx);

    // Assert
    verify(ctx).error(eq("Type cannot be inferred for null value"));
  }

  /**
   * Method under test:
   * {@link TypeSystemValidator#decimalValue(DecimalValue, ValidationContext)}
   */
  @Test
  void testDecimalValue() {
    // Arrange
    DecimalValue msg = DecimalValue.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    TypeSystemValidator.decimalValue(msg, ctx);

    // Assert
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link TypeSystemValidator#dateValue(DateValue, ValidationContext)}
   */
  @Test
  void testDateValue() {
    // Arrange
    DateValue msg = DateValue.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    TypeSystemValidator.dateValue(msg, ctx);

    // Assert
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link TypeSystemValidator#datetimeValue(DatetimeValue, ValidationContext)}
   */
  @Test
  void testDatetimeValue() {
    // Arrange
    DatetimeValue msg = DatetimeValue.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    TypeSystemValidator.datetimeValue(msg, ctx);

    // Assert
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }
}
