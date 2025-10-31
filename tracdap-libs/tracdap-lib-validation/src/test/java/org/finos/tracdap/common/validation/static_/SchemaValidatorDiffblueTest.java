package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.FieldSchema;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.finos.tracdap.metadata.TableSchema;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SchemaValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link SchemaValidator#schema(SchemaDefinition, ValidationContext)}
   */
  @Test
  void testSchema() {
    // Arrange
    SchemaDefinition schema = SchemaDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext7);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext8);

    // Act
    SchemaValidator.schema(schema, ctx);

    // Assert
    verify(validationContext8).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext4).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext7).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext5).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }

  /**
   * Method under test:
   * {@link SchemaValidator#tableSchema(TableSchema, ValidationContext)}
   */
  @Test
  void testTableSchema() {
    // Arrange
    TableSchema table = TableSchema.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(
        validationContext2.applyRepeated(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushRepeated(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    SchemaValidator.tableSchema(table, ctx);

    // Assert
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).applyRepeated(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link SchemaValidator#dynamicSchema(SchemaDefinition, ValidationContext)}
   */
  @Test
  void testDynamicSchema() {
    // Arrange
    SchemaDefinition schema = SchemaDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext5);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext6);

    // Act
    SchemaValidator.dynamicSchema(schema, ctx);

    // Assert
    verify(validationContext6).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext5).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext3).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }

  /**
   * Method under test:
   * {@link SchemaValidator#fieldSchema(FieldSchema, ValidationContext)}
   */
  @Test
  void testFieldSchema() {
    // Arrange
    FieldSchema field = FieldSchema.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext15);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext16);

    // Act
    SchemaValidator.fieldSchema(field, ctx);

    // Assert
    verify(validationContext16).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext8).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext15).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext14).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext11).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext13).pop();
    verify(validationContext10).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext12).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext9).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).push(isA(Descriptors.FieldDescriptor.class));
  }
}
