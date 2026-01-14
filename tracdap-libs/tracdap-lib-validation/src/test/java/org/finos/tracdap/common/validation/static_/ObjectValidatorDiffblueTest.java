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
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ObjectValidatorDiffblueTest {
  /**
   * Test {@link ObjectValidator#objectDefinition(ObjectDefinition, ValidationContext)}.
   *
   * <p>Method under test: {@link ObjectValidator#objectDefinition(ObjectDefinition,
   * ValidationContext)}
   */
  @Test
  @DisplayName("Test objectDefinition(ObjectDefinition, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectValidator.objectDefinition(ObjectDefinition, ValidationContext)"
  })
  void testObjectDefinition() {
    // Arrange
    ObjectDefinition msg = ObjectDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushMap(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyRegistered()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext12);

    // Act
    ObjectValidator.objectDefinition(msg, ctx);

    // Assert
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).applyRegistered();
    verify(validationContext10).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext4).pushMap(isA(FieldDescriptor.class));
    verify(validationContext9).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link ObjectValidator#objectType(ObjectDefinition, ObjectType, ValidationContext)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectValidator#objectType(ObjectDefinition, ObjectType,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test objectType(ObjectDefinition, ObjectType, ValidationContext); when DefaultInstance; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectValidator.objectType(ObjectDefinition, ObjectType, ValidationContext)"
  })
  void testObjectType_whenDefaultInstance_thenCallsError() {
    // Arrange
    ObjectDefinition msg = ObjectDefinition.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectValidator.objectType(msg, ObjectType.OBJECT_TYPE_NOT_SET, ctx);

    // Assert
    verify(ctx)
        .error(
            "The given [Field Name] has the wrong object type: expected [OBJECT_TYPE_NOT_SET], got [UNRECOGNIZED]");
    verify(ctx).fieldName();
  }
}
