package org.finos.tracdap.common.validation.version;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SchemaVersionValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition, ValidationContext)}
   */
  @Test
  void testSchema() {
    // Arrange
    SchemaDefinition current = SchemaDefinition.getDefaultInstance();
    SchemaDefinition prior = SchemaDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> SchemaVersionValidator.schema(current, prior, ctx));
    verify(validationContext2).apply(isA(ValidationFunction.Version.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition, ValidationContext)}
   */
  @Test
  void testSchema2() {
    // Arrange
    SchemaDefinition current = SchemaDefinition.getDefaultInstance();
    SchemaDefinition prior = SchemaDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> SchemaVersionValidator.schema(current, prior, ctx));
    verify(validationContext2).apply(isA(ValidationFunction.Version.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition, ValidationContext)}
   */
  @Test
  void testSchema3() {
    // Arrange
    SchemaDefinition current = SchemaDefinition.getDefaultInstance();
    SchemaDefinition prior = SchemaDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<ValidationFunction.Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> SchemaVersionValidator.schema(current, prior, ctx));
    verify(validationContext).apply(isA(ValidationFunction.Version.class), isA(Class.class));
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition, ValidationContext)}
   */
  @Test
  void testSchema4() {
    // Arrange
    SchemaDefinition current = SchemaDefinition.getDefaultInstance();
    SchemaDefinition prior = SchemaDefinition.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> SchemaVersionValidator.schema(current, prior, ctx));
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }
}
