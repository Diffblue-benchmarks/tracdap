package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.isA;
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
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.metadata.TagUpdate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TagUpdateValidatorDiffblueTest {
  /**
   * Test {@link TagUpdateValidator#tagUpdate(TagUpdate, ValidationContext)}.
   *
   * <p>Method under test: {@link TagUpdateValidator#tagUpdate(TagUpdate, ValidationContext)}
   */
  @Test
  @DisplayName("Test tagUpdate(TagUpdate, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext TagUpdateValidator.tagUpdate(TagUpdate, ValidationContext)"
  })
  void testTagUpdate() {
    // Arrange
    TagUpdate msg = TagUpdate.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Basic>any())).thenReturn(validationContext12);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext13);

    // Act
    TagUpdateValidator.tagUpdate(msg, ctx);

    // Assert
    verify(validationContext13).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Typed.class));
    verify(validationContext12).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext4).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext11).pop();
    verify(validationContext7).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext10).push(isA(FieldDescriptor.class));
    verify(validationContext6).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link TagUpdateValidator#reservedAttrs(TagUpdate, boolean, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code Attr Name}.
   *   <li>When {@link TagUpdate} {@link TagUpdate#getAttrName()} return {@code Attr Name}.
   * </ul>
   *
   * <p>Method under test: {@link TagUpdateValidator#reservedAttrs(TagUpdate, boolean,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test reservedAttrs(TagUpdate, boolean, ValidationContext); given 'Attr Name'; when TagUpdate getAttrName() return 'Attr Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext TagUpdateValidator.reservedAttrs(TagUpdate, boolean, ValidationContext)"
  })
  void testReservedAttrs_givenAttrName_whenTagUpdateGetAttrNameReturnAttrName() {
    // Arrange
    TagUpdate msg = mock(TagUpdate.class);
    when(msg.getAttrName()).thenReturn("Attr Name");

    // Act
    TagUpdateValidator.reservedAttrs(msg, false, mock(ValidationContext.class));

    // Assert
    verify(msg).getAttrName();
  }

  /**
   * Test {@link TagUpdateValidator#reservedAttrs(TagUpdate, boolean, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code trac-U}.
   *   <li>When {@link TagUpdate} {@link TagUpdate#getAttrName()} return {@code trac-U}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TagUpdateValidator#reservedAttrs(TagUpdate, boolean,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test reservedAttrs(TagUpdate, boolean, ValidationContext); given 'trac-U'; when TagUpdate getAttrName() return 'trac-U'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext TagUpdateValidator.reservedAttrs(TagUpdate, boolean, ValidationContext)"
  })
  void testReservedAttrs_givenTracU_whenTagUpdateGetAttrNameReturnTracU_thenCallsError() {
    // Arrange
    TagUpdate msg = mock(TagUpdate.class);
    when(msg.getAttrName()).thenReturn("trac-U");

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    TagUpdateValidator.reservedAttrs(msg, false, ctx);

    // Assert
    verify(ctx).error("Attribute name [trac-U] is a reserved identifier");
    verify(msg, atLeast(1)).getAttrName();
  }
}
