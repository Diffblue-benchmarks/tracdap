package org.finos.tracdap.common.validation.version;

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
import org.finos.tracdap.common.validation.core.ValidationFunction.Version;
import org.finos.tracdap.metadata.ModelDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ModelVersionValidatorDiffblueTest {
  /**
   * Test {@link ModelVersionValidator#modelVersion(ModelDefinition, ModelDefinition,
   * ValidationContext)}.
   *
   * <p>Method under test: {@link ModelVersionValidator#modelVersion(ModelDefinition,
   * ModelDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test modelVersion(ModelDefinition, ModelDefinition, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ModelVersionValidator.modelVersion(ModelDefinition, ModelDefinition, ValidationContext)"
  })
  void testModelVersion() {
    // Arrange
    ModelDefinition current = ModelDefinition.getDefaultInstance();
    ModelDefinition prior = ModelDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.pop()).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext22);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext23);

    // Act
    ModelVersionValidator.modelVersion(current, prior, ctx);

    // Assert
    verify(validationContext23).apply(isA(Version.class));
    verify(validationContext20).apply(isA(Version.class));
    verify(validationContext17).apply(isA(Version.class));
    verify(validationContext14).apply(isA(Version.class));
    verify(validationContext11).apply(isA(Version.class));
    verify(validationContext8).apply(isA(Version.class));
    verify(validationContext5).apply(isA(Version.class));
    verify(validationContext2).apply(isA(Version.class));
    verify(validationContext22).pop();
    verify(validationContext19).pop();
    verify(validationContext16).pop();
    verify(validationContext13).pop();
    verify(validationContext10).pop();
    verify(validationContext7).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext21).push(isA(FieldDescriptor.class));
    verify(validationContext18).push(isA(FieldDescriptor.class));
    verify(validationContext15).push(isA(FieldDescriptor.class));
    verify(validationContext12).push(isA(FieldDescriptor.class));
    verify(validationContext9).push(isA(FieldDescriptor.class));
    verify(validationContext6).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
  }
}
