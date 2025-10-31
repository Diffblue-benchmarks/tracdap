package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ObjectValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link ObjectValidator#objectDefinition(ObjectDefinition, ValidationContext)}
   */
  @Test
  void testObjectDefinition() {
    // Arrange
    ObjectDefinition msg = ObjectDefinition.getDefaultInstance();
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
    when(validationContext6.applyRegistered()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext11);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext12);

    // Act
    ObjectValidator.objectDefinition(msg, ctx);

    // Assert
    verify(validationContext12).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext8).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext7).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext11).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext6).applyRegistered();
    verify(validationContext10).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).pushMap(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext9).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }

  /**
   * Method under test:
   * {@link ObjectValidator#objectType(ObjectDefinition, ObjectType, ValidationContext)}
   */
  @Test
  void testObjectType() {
    // Arrange
    ObjectDefinition msg = ObjectDefinition.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectValidator.objectType(msg, ObjectType.OBJECT_TYPE_NOT_SET, ctx);

    // Assert
    verify(ctx).error(
        eq("The given [Field Name] has the wrong object type: expected [OBJECT_TYPE_NOT_SET], got [UNRECOGNIZED]"));
    verify(ctx).fieldName();
  }
}
