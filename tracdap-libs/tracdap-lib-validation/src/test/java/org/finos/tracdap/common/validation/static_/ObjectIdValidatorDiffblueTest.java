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
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.metadata.TagSelector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ObjectIdValidatorDiffblueTest {
  /**
   * Test {@link ObjectIdValidator#tagHeader(TagHeader, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code true}.
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectIdValidator#tagHeader(TagHeader, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test tagHeader(TagHeader, ValidationContext); given ValidationContext failed() return 'true'; then calls apply(Basic)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationContext ObjectIdValidator.tagHeader(TagHeader, ValidationContext)"})
  void testTagHeader_givenValidationContextFailedReturnTrue_thenCallsApply() {
    // Arrange
    TagHeader msg = TagHeader.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(true);

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

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
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pop()).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext18);

    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Basic>any())).thenReturn(validationContext19);

    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext20);

    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(validationContext21);

    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext22);

    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Basic>any())).thenReturn(validationContext23);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext24);

    // Act
    ObjectIdValidator.tagHeader(msg, ctx);

    // Assert
    verify(validationContext24).apply(isA(Basic.class));
    verify(validationContext20).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Typed.class));
    verify(validationContext23).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext15).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext11).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext).failed();
    verify(validationContext22).pop();
    verify(validationContext18).pop();
    verify(validationContext14).pop();
    verify(validationContext10).pop();
    verify(validationContext6).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext21).push(isA(FieldDescriptor.class));
    verify(validationContext17).push(isA(FieldDescriptor.class));
    verify(validationContext13).push(isA(FieldDescriptor.class));
    verify(validationContext9).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link ObjectIdValidator#tagSelector(TagSelector, ValidationContext)}.
   *
   * <p>Method under test: {@link ObjectIdValidator#tagSelector(TagSelector, ValidationContext)}
   */
  @Test
  @DisplayName("Test tagSelector(TagSelector, ValidationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectIdValidator.tagSelector(TagSelector, ValidationContext)"
  })
  void testTagSelector() {
    // Arrange
    TagSelector msg = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Typed<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Typed<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Typed<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Typed<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Typed<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyOneOf(
            Mockito.<FieldDescriptor>any(),
            Mockito.<Typed<Object>>any(),
            Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushOneOf(Mockito.<OneofDescriptor>any()))
        .thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext13);

    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Basic>any())).thenReturn(validationContext14);

    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext15);

    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pop()).thenReturn(validationContext16);

    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);

    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext19);

    // Act
    ObjectIdValidator.tagSelector(msg, ctx);

    // Assert
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext15).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Typed.class));
    verify(validationContext18).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext10)
        .applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext9)
        .applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext8)
        .applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext4)
        .applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext3)
        .applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext2)
        .applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext17).pop();
    verify(validationContext13).pop();
    verify(validationContext7).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext16).push(isA(FieldDescriptor.class));
    verify(validationContext12).pushOneOf(isA(OneofDescriptor.class));
    verify(validationContext6).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link ObjectIdValidator#preallocated(TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectIdValidator#preallocated(TagSelector, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test preallocated(TagSelector, ValidationContext); when DefaultInstance; then calls apply(Basic)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectIdValidator.preallocated(TagSelector, ValidationContext)"
  })
  void testPreallocated_whenDefaultInstance_thenCallsApply() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.fieldName()).thenReturn("Field Name");
    when(validationContext.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

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
    ObjectIdValidator.preallocated(selector, ctx);

    // Assert
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Typed.class));
    verify(validationContext7).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext)
        .error(
            "The [Field Name] selector is not a preallocated object ID (object and tag version must be set to zero)");
    verify(validationContext).fieldName();
    verify(validationContext6).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link ObjectIdValidator#selectorType(TagSelector, List, ValidationContext)} with {@code
   * selector}, {@code allowedTypes}, {@code ctx}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectIdValidator#selectorType(TagSelector, List,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test selectorType(TagSelector, List, ValidationContext) with 'selector', 'allowedTypes', 'ctx'; when ArrayList(); then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectIdValidator.selectorType(TagSelector, List, ValidationContext)"
  })
  void testSelectorTypeWithSelectorAllowedTypesCtx_whenArrayList_thenCallsError() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();
    ArrayList<ObjectType> allowedTypes = new ArrayList<>();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.selectorType(selector, allowedTypes, ctx);

    // Assert
    verify(ctx)
        .error("Wrong object type in [Field Name] selector: allowed [], got [OBJECT_TYPE_NOT_SET]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link ObjectIdValidator#selectorType(TagSelector, ObjectType, ValidationContext)} with
   * {@code selector}, {@code requiredType}, {@code ctx}.
   *
   * <ul>
   *   <li>Given {@code Field Name}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectIdValidator#selectorType(TagSelector, ObjectType,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test selectorType(TagSelector, ObjectType, ValidationContext) with 'selector', 'requiredType', 'ctx'; given 'Field Name'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectIdValidator.selectorType(TagSelector, ObjectType, ValidationContext)"
  })
  void testSelectorTypeWithSelectorRequiredTypeCtx_givenFieldName_thenCallsError() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.selectorType(selector, ObjectType.DATA, ctx);

    // Assert
    verify(ctx)
        .error(
            "Wrong object type in [Field Name] selector: expected [DATA], got [OBJECT_TYPE_NOT_SET]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link ObjectIdValidator#selectorForLatest(TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectIdValidator#selectorForLatest(TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test selectorForLatest(TagSelector, ValidationContext); when DefaultInstance; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectIdValidator.selectorForLatest(TagSelector, ValidationContext)"
  })
  void testSelectorForLatest_whenDefaultInstance_thenCallsError() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.selectorForLatest(selector, ctx);

    // Assert
    verify(ctx)
        .error(
            "The [Field Name] selector must refer to the latest object and tag version, fixed versions are not allowed");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link ObjectIdValidator#fixedObjectVersion(TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TagSelector} {@link TagSelector#hasLatestObject()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectIdValidator#fixedObjectVersion(TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test fixedObjectVersion(TagSelector, ValidationContext); given 'false'; when TagSelector hasLatestObject() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectIdValidator.fixedObjectVersion(TagSelector, ValidationContext)"
  })
  void testFixedObjectVersion_givenFalse_whenTagSelectorHasLatestObjectReturnFalse() {
    // Arrange
    TagSelector selector = mock(TagSelector.class);
    when(selector.hasLatestObject()).thenReturn(false);

    // Act
    ObjectIdValidator.fixedObjectVersion(selector, mock(ValidationContext.class));

    // Assert
    verify(selector).hasLatestObject();
  }

  /**
   * Test {@link ObjectIdValidator#fixedObjectVersion(TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectIdValidator#fixedObjectVersion(TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test fixedObjectVersion(TagSelector, ValidationContext); given 'true'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectIdValidator.fixedObjectVersion(TagSelector, ValidationContext)"
  })
  void testFixedObjectVersion_givenTrue_thenCallsError() {
    // Arrange
    TagSelector selector = mock(TagSelector.class);
    when(selector.hasLatestObject()).thenReturn(true);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.fixedObjectVersion(selector, ctx);

    // Assert
    verify(ctx)
        .error(
            "The [Field Name] selector must refer to a fixed object version, [latestObject] is not allowed");
    verify(ctx).fieldName();
    verify(selector).hasLatestObject();
  }

  /**
   * Test {@link ObjectIdValidator#explicitObjectVersion(TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectIdValidator#explicitObjectVersion(TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test explicitObjectVersion(TagSelector, ValidationContext); when DefaultInstance; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectIdValidator.explicitObjectVersion(TagSelector, ValidationContext)"
  })
  void testExplicitObjectVersion_whenDefaultInstance_thenCallsError() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.explicitObjectVersion(selector, ctx);

    // Assert
    verify(ctx).error("The [Field Name] selector must use an explicit [objectVersion]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link ObjectIdValidator#explicitTagVersion(TagSelector, ValidationContext)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectIdValidator#explicitTagVersion(TagSelector,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test explicitTagVersion(TagSelector, ValidationContext); when DefaultInstance; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectIdValidator.explicitTagVersion(TagSelector, ValidationContext)"
  })
  void testExplicitTagVersion_whenDefaultInstance_thenCallsError() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.explicitTagVersion(selector, ctx);

    // Assert
    verify(ctx).error("The [Field Name] selector must use an explicit [tagVersion]");
    verify(ctx).fieldName();
  }

  /**
   * Test {@link ObjectIdValidator#versioningSupported(ObjectType, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@code OBJECT_TYPE_NOT_SET}.
   *   <li>Then calls {@link ValidationContext#error(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectIdValidator#versioningSupported(ObjectType,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test versioningSupported(ObjectType, ValidationContext); when 'OBJECT_TYPE_NOT_SET'; then calls error(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext ObjectIdValidator.versioningSupported(ObjectType, ValidationContext)"
  })
  void testVersioningSupported_whenObjectTypeNotSet_thenCallsError() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.versioningSupported(ObjectType.OBJECT_TYPE_NOT_SET, ctx);

    // Assert
    verify(ctx).error("Object type [OBJECT_TYPE_NOT_SET] does not support versioning");
  }
}
