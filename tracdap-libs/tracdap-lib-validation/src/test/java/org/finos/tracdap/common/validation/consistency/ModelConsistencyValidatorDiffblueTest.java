package org.finos.tracdap.common.validation.consistency;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.metadata.ModelDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ModelConsistencyValidatorDiffblueTest {
  /**
   * Test {@link ModelConsistencyValidator#modelDefinition(ModelDefinition, ValidationContext)}.
   *
   * <p>Method under test: {@link ModelConsistencyValidator#modelDefinition(ModelDefinition,
   * ValidationContext)}
   */
  @Test
  @DisplayName("Test modelDefinition(ModelDefinition, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ModelConsistencyValidator.modelDefinition(ModelDefinition, ValidationContext)"
  })
  void testModelDefinition() {
    // Arrange
    ModelDefinition model = ModelDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    // Act
    ModelConsistencyValidator.modelDefinition(model, ctx);

    // Assert
    verify(validationContext2, atLeast(1)).apply(Mockito.<Typed<String>>any());
    verify(validationContext, atLeast(1)).pop();
    verify(ctx, atLeast(1)).push(Mockito.<FieldDescriptor>any());
  }
}
