package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.TagUpdate;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TagUpdateValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link TagUpdateValidator#tagUpdate(TagUpdate, ValidationContext)}
   */
  @Test
  void testTagUpdate() {
    // Arrange
    TagUpdate msg = TagUpdate.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);
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
    when(validationContext8.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext12);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext13);

    // Act
    TagUpdateValidator.tagUpdate(msg, ctx);

    // Assert
    verify(validationContext13).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext9).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext5).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext8).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext12).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext4).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext11).pop();
    verify(validationContext7).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext10).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext6).push(isA(Descriptors.FieldDescriptor.class));
  }
}
