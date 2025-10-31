package org.finos.tracdap.common.validation.version;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Version;
import org.finos.tracdap.metadata.CustomDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CustomVersionValidatorDiffblueTest {
  /**
   * Test {@link CustomVersionValidator#customVersion(CustomDefinition, CustomDefinition, ValidationContext)}.
   * <p>
   * Method under test: {@link CustomVersionValidator#customVersion(CustomDefinition, CustomDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test customVersion(CustomDefinition, CustomDefinition, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext CustomVersionValidator.customVersion(CustomDefinition, CustomDefinition, ValidationContext)"})
  void testCustomVersion() {
    // Arrange
    CustomDefinition current = CustomDefinition.getDefaultInstance();
    CustomDefinition prior = CustomDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext4);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);

    // Act
    CustomVersionValidator.customVersion(current, prior, ctx);

    // Assert
    verify(validationContext5).apply(isA(Version.class));
    verify(validationContext2).apply(isA(Version.class), isA(Class.class));
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
  }
}
