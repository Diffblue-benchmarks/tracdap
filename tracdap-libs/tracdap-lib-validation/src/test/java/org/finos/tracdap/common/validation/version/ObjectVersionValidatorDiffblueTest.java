package org.finos.tracdap.common.validation.version;

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
import org.finos.tracdap.common.validation.core.ValidationFunction.Version;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ObjectVersionValidatorDiffblueTest {
  /**
   * Test {@link ObjectVersionValidator#objectVersion(ObjectDefinition, ObjectDefinition,
   * ValidationContext)}.
   *
   * <p>Method under test: {@link ObjectVersionValidator#objectVersion(ObjectDefinition,
   * ObjectDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test objectVersion(ObjectDefinition, ObjectDefinition, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectVersionValidator.objectVersion(ObjectDefinition, ObjectDefinition, ValidationContext)"
  })
  void testObjectVersion() {
    // Arrange
    ObjectDefinition current = ObjectDefinition.getDefaultInstance();
    ObjectDefinition prior = ObjectDefinition.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext5);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);

    // Act
    ObjectVersionValidator.objectVersion(current, prior, ctx);

    // Assert
    verify(validationContext6).apply(isA(Version.class));
    verify(validationContext3).apply(isA(Version.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext4).pushOneOf(isA(OneofDescriptor.class));
  }
}
