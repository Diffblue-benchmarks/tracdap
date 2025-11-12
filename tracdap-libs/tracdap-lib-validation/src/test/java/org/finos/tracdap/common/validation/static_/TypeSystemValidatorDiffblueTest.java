package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.metadata.DateValue;
import org.finos.tracdap.metadata.DatetimeValue;
import org.finos.tracdap.metadata.DecimalValue;
import org.finos.tracdap.metadata.TypeDescriptor;
import org.finos.tracdap.metadata.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TypeSystemValidatorDiffblueTest {
  /**
   * Test {@link TypeSystemValidator#typeDescriptor(TypeDescriptor, ValidationContext)}.
   *
   * <p>Method under test: {@link TypeSystemValidator#typeDescriptor(TypeDescriptor,
   * ValidationContext)}
   */
  @Test
  @DisplayName("Test typeDescriptor(TypeDescriptor, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext TypeSystemValidator.typeDescriptor(TypeDescriptor, ValidationContext)"
  })
  void testTypeDescriptor() {
    // Arrange
    TypeDescriptor typeDescriptor = TypeDescriptor.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

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
    when(validationContext6.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    // Act
    TypeSystemValidator.typeDescriptor(typeDescriptor, ctx);

    // Assert
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link TypeSystemValidator#value(Value, ValidationContext)}.
   *
   * <p>Method under test: {@link TypeSystemValidator#value(Value, ValidationContext)}
   */
  @Test
  @DisplayName("Test value(Value, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext TypeSystemValidator.value(Value, ValidationContext)"})
  void testValue() {
    // Arrange
    Value value = Value.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    TypeSystemValidator.value(value, ctx);

    // Assert
    verify(ctx).error("Type cannot be inferred for null value");
  }

  /**
   * Test {@link TypeSystemValidator#valueWithType(Value, TypeDescriptor, ValidationContext)}.
   *
   * <p>Method under test: {@link TypeSystemValidator#valueWithType(Value, TypeDescriptor,
   * ValidationContext)}
   */
  @Test
  @DisplayName("Test valueWithType(Value, TypeDescriptor, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext TypeSystemValidator.valueWithType(Value, TypeDescriptor, ValidationContext)"
  })
  void testValueWithType() {
    // Arrange
    Value value = Value.getDefaultInstance();
    TypeDescriptor expectedType = TypeDescriptor.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    TypeSystemValidator.valueWithType(value, expectedType, ctx);

    // Assert
    verify(ctx).error("Type cannot be inferred for null value");
  }

  /**
   * Test {@link TypeSystemValidator#decimalValue(DecimalValue, ValidationContext)}.
   *
   * <p>Method under test: {@link TypeSystemValidator#decimalValue(DecimalValue, ValidationContext)}
   */
  @Test
  @DisplayName("Test decimalValue(DecimalValue, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext TypeSystemValidator.decimalValue(DecimalValue, ValidationContext)"
  })
  void testDecimalValue() {
    // Arrange
    DecimalValue msg = DecimalValue.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    TypeSystemValidator.decimalValue(msg, ctx);

    // Assert
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link TypeSystemValidator#dateValue(DateValue, ValidationContext)}.
   *
   * <p>Method under test: {@link TypeSystemValidator#dateValue(DateValue, ValidationContext)}
   */
  @Test
  @DisplayName("Test dateValue(DateValue, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext TypeSystemValidator.dateValue(DateValue, ValidationContext)"
  })
  void testDateValue() {
    // Arrange
    DateValue msg = DateValue.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    TypeSystemValidator.dateValue(msg, ctx);

    // Assert
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link TypeSystemValidator#datetimeValue(DatetimeValue, ValidationContext)}.
   *
   * <p>Method under test: {@link TypeSystemValidator#datetimeValue(DatetimeValue,
   * ValidationContext)}
   */
  @Test
  @DisplayName("Test datetimeValue(DatetimeValue, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext TypeSystemValidator.datetimeValue(DatetimeValue, ValidationContext)"
  })
  void testDatetimeValue() {
    // Arrange
    DatetimeValue msg = DatetimeValue.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    TypeSystemValidator.datetimeValue(msg, ctx);

    // Assert
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }
}
