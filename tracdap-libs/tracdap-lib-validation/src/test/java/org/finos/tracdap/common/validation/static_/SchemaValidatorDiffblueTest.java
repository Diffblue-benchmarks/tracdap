package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.metadata.FieldSchema;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.finos.tracdap.metadata.TableSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SchemaValidatorDiffblueTest {
  /**
   * Test {@link SchemaValidator#schema(SchemaDefinition, ValidationContext)} with {@code schema},
   * {@code ctx}.
   *
   * <p>Method under test: {@link SchemaValidator#schema(SchemaDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test schema(SchemaDefinition, ValidationContext) with 'schema', 'ctx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext SchemaValidator.schema(SchemaDefinition, ValidationContext)"
  })
  void testSchemaWithSchemaCtx() {
    // Arrange
    SchemaDefinition schema = SchemaDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    // Act
    SchemaValidator.schema(schema, ctx);

    // Assert
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext5).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link SchemaValidator#tableSchema(TableSchema, ValidationContext)}.
   *
   * <p>Method under test: {@link SchemaValidator#tableSchema(TableSchema, ValidationContext)}
   */
  @Test
  @DisplayName("Test tableSchema(TableSchema, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext SchemaValidator.tableSchema(TableSchema, ValidationContext)"
  })
  void testTableSchema() {
    // Arrange
    TableSchema table = TableSchema.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(
            Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    SchemaValidator.tableSchema(table, ctx);

    // Assert
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link SchemaValidator#dynamicSchema(SchemaDefinition, ValidationContext)}.
   *
   * <p>Method under test: {@link SchemaValidator#dynamicSchema(SchemaDefinition,
   * ValidationContext)}
   */
  @Test
  @DisplayName("Test dynamicSchema(SchemaDefinition, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext SchemaValidator.dynamicSchema(SchemaDefinition, ValidationContext)"
  })
  void testDynamicSchema() {
    // Arrange
    SchemaDefinition schema = SchemaDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);

    // Act
    SchemaValidator.dynamicSchema(schema, ctx);

    // Assert
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext3).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link SchemaValidator#fieldSchema(FieldSchema, ValidationContext)}.
   *
   * <p>Method under test: {@link SchemaValidator#fieldSchema(FieldSchema, ValidationContext)}
   */
  @Test
  @DisplayName("Test fieldSchema(FieldSchema, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext SchemaValidator.fieldSchema(FieldSchema, ValidationContext)"
  })
  void testFieldSchema() {
    // Arrange
    FieldSchema field = FieldSchema.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);

    // Act
    SchemaValidator.fieldSchema(field, ctx);

    // Assert
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext15).apply(isA(Typed.class));
    verify(validationContext14).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext11).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext13).pop();
    verify(validationContext10).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext12).push(isA(FieldDescriptor.class));
    verify(validationContext9).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }
}
