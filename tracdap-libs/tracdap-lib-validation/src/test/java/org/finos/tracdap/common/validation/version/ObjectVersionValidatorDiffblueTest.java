package org.finos.tracdap.common.validation.version;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ObjectVersionValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link ObjectVersionValidator#objectVersion(ObjectDefinition, ObjectDefinition, ValidationContext)}
   */
  @Test
  void testObjectVersion() {
    // Arrange
    ObjectDefinition current = ObjectDefinition.getDefaultInstance();
    ObjectDefinition prior = ObjectDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Version<Object>>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<ValidationFunction.Version<Object>>any())).thenReturn(validationContext5);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext6);

    // Act
    ObjectVersionValidator.objectVersion(current, prior, ctx);

    // Assert
    verify(validationContext6).apply(isA(ValidationFunction.Version.class));
    verify(validationContext3).apply(isA(ValidationFunction.Version.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }
}
