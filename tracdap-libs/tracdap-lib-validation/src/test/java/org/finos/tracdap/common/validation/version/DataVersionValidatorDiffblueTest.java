package org.finos.tracdap.common.validation.version;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Version;
import org.finos.tracdap.metadata.DataDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataVersionValidatorDiffblueTest {
  /**
   * Test {@link DataVersionValidator#data(DataDefinition, DataDefinition, ValidationContext)}.
   * <p>
   * Method under test: {@link DataVersionValidator#data(DataDefinition, DataDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test data(DataDefinition, DataDefinition, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataVersionValidator.data(DataDefinition, DataDefinition, ValidationContext)"})
  void testData() {
    // Arrange
    DataDefinition current = DataDefinition.getDefaultInstance();
    DataDefinition prior = DataDefinition.getDefaultInstance();
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
    when(validationContext5.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Version<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Version<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext6);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext7);

    // Act
    DataVersionValidator.data(current, prior, ctx);

    // Assert
    verify(validationContext7).apply(isA(Version.class));
    verify(validationContext2).apply(isA(Version.class), isA(Class.class));
    verify(validationContext6).applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext5).applyOneOf(isA(FieldDescriptor.class), isA(Version.class), isA(Class.class));
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(validationContext3).push(isA(FieldDescriptor.class));
    verify(ctx).pushOneOf(isA(OneofDescriptor.class));
  }
}
