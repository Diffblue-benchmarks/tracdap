package org.finos.tracdap.common.validation.version;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.util.ArrayList;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Version;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.finos.tracdap.metadata.TableSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SchemaVersionValidatorDiffblueTest {
  /**
   * Test {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition,
   * ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>When {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} throw
   *       {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test schema(SchemaDefinition, SchemaDefinition, ValidationContext); given EUnexpected(); when ValidationContext push(FieldDescriptor) throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext SchemaVersionValidator.schema(SchemaDefinition, SchemaDefinition, ValidationContext)"
  })
  void testSchema_givenEUnexpected_whenValidationContextPushThrowEUnexpected() {
    // Arrange
    SchemaDefinition current = SchemaDefinition.getDefaultInstance();
    SchemaDefinition prior = SchemaDefinition.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> SchemaVersionValidator.schema(current, prior, ctx));
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition,
   * ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#apply(Version, Class)} throw
   *       {@link EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#apply(Version, Class)}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test schema(SchemaDefinition, SchemaDefinition, ValidationContext); given ValidationContext apply(Version, Class) throw EUnexpected(); then calls apply(Version, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext SchemaVersionValidator.schema(SchemaDefinition, SchemaDefinition, ValidationContext)"
  })
  void testSchema_givenValidationContextApplyThrowEUnexpected_thenCallsApply() {
    // Arrange
    SchemaDefinition current = SchemaDefinition.getDefaultInstance();
    SchemaDefinition prior = SchemaDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.apply(Mockito.<Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenThrow(new EUnexpected());

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> SchemaVersionValidator.schema(current, prior, ctx));
    verify(validationContext).apply(isA(Version.class), isA(Class.class));
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition,
   * ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} return {@link
   *       ValidationContext}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test schema(SchemaDefinition, SchemaDefinition, ValidationContext); given ValidationContext pop() return ValidationContext; then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext SchemaVersionValidator.schema(SchemaDefinition, SchemaDefinition, ValidationContext)"
  })
  void testSchema_givenValidationContextPopReturnValidationContext_thenCallsPop() {
    // Arrange
    SchemaDefinition current = SchemaDefinition.getDefaultInstance();
    SchemaDefinition prior = SchemaDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> SchemaVersionValidator.schema(current, prior, ctx));
    verify(validationContext2).apply(isA(Version.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition,
   * ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaVersionValidator#schema(SchemaDefinition, SchemaDefinition,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test schema(SchemaDefinition, SchemaDefinition, ValidationContext); given ValidationContext pop() throw EUnexpected(); then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext SchemaVersionValidator.schema(SchemaDefinition, SchemaDefinition, ValidationContext)"
  })
  void testSchema_givenValidationContextPopThrowEUnexpected_thenCallsPop() {
    // Arrange
    SchemaDefinition current = SchemaDefinition.getDefaultInstance();
    SchemaDefinition prior = SchemaDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenThrow(new EUnexpected());

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> SchemaVersionValidator.schema(current, prior, ctx));
    verify(validationContext2).apply(isA(Version.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link SchemaVersionValidator#tableSchema(TableSchema, TableSchema, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link TableSchema#getFieldsList()}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaVersionValidator#tableSchema(TableSchema, TableSchema,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test tableSchema(TableSchema, TableSchema, ValidationContext); given ArrayList(); then calls getFieldsList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext SchemaVersionValidator.tableSchema(TableSchema, TableSchema, ValidationContext)"
  })
  void testTableSchema_givenArrayList_thenCallsGetFieldsList() {
    // Arrange
    TableSchema current = mock(TableSchema.class);
    when(current.getFieldsList()).thenReturn(new ArrayList<>());

    // Act
    SchemaVersionValidator.tableSchema(
        current, TableSchema.getDefaultInstance(), mock(ValidationContext.class));

    // Assert
    verify(current, atLeast(1)).getFieldsList();
  }

  /**
   * Test {@link SchemaVersionValidator#tableSchema(TableSchema, TableSchema, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link TableSchema#getFieldsList()}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaVersionValidator#tableSchema(TableSchema, TableSchema,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test tableSchema(TableSchema, TableSchema, ValidationContext); given ArrayList(); then calls getFieldsList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext SchemaVersionValidator.tableSchema(TableSchema, TableSchema, ValidationContext)"
  })
  void testTableSchema_givenArrayList_thenCallsGetFieldsList2() {
    // Arrange
    TableSchema current = mock(TableSchema.class);
    when(current.getFieldsList()).thenReturn(new ArrayList<>());

    TableSchema prior = mock(TableSchema.class);
    when(prior.getFieldsList()).thenReturn(new ArrayList<>());

    // Act
    SchemaVersionValidator.tableSchema(current, prior, mock(ValidationContext.class));

    // Assert
    verify(prior, atLeast(1)).getFieldsList();
    verify(current, atLeast(1)).getFieldsList();
  }
}
