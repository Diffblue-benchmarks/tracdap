package org.finos.tracdap.common.validation.version;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.CustomDefinition;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CustomVersionValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link CustomVersionValidator#customVersion(CustomDefinition, CustomDefinition, ValidationContext)}
   */
  @Test
  void testCustomVersion() {
    // Arrange
    CustomDefinition current = CustomDefinition.getDefaultInstance();
    CustomDefinition prior = CustomDefinition.getDefaultInstance();
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
    when(validationContext5.apply(Mockito.<ValidationFunction.Version<Object>>any())).thenReturn(validationContext4);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext5);

    // Act
    CustomVersionValidator.customVersion(current, prior, ctx);

    // Assert
    verify(validationContext5).apply(isA(ValidationFunction.Version.class));
    verify(validationContext2).apply(isA(ValidationFunction.Version.class), isA(Class.class));
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext3).push(isA(Descriptors.FieldDescriptor.class));
  }
}
