package org.finos.tracdap.common.validation.consistency;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.metadata.ModelDefinition;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ModelConsistencyValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link ModelConsistencyValidator#modelDefinition(ModelDefinition, ValidationContext)}
   */
  @Test
  void testModelDefinition() {
    // Arrange
    ModelDefinition model = ModelDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext2);

    // Act
    ModelConsistencyValidator.modelDefinition(model, ctx);

    // Assert
    verify(validationContext2, atLeast(1)).apply(Mockito.<ValidationFunction.Typed<String>>any());
    verify(validationContext, atLeast(1)).pop();
    verify(ctx, atLeast(1)).push(Mockito.<Descriptors.FieldDescriptor>any());
  }

  /**
   * Method under test:
   * {@link ModelConsistencyValidator#isKnownModelRepo(String, ValidationContext)}
   */
  @Test
  void testIsKnownModelRepo() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    when(ctx.getResources()).thenReturn(PlatformConfig.getDefaultInstance());

    // Act
    ModelConsistencyValidator.isKnownModelRepo("Repo Name", ctx);

    // Assert
    verify(ctx).error(eq("Model repository [Repo Name] is not available in the TRAC platform"));
    verify(ctx).getResources();
  }
}
