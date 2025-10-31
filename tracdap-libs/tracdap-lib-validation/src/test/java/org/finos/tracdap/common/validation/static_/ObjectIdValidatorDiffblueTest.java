package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.metadata.TagSelector;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ObjectIdValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link ObjectIdValidator#tagHeader(TagHeader, ValidationContext)}
   */
  @Test
  void testTagHeader() {
    // Arrange
    TagHeader msg = TagHeader.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(true);
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
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
    when(validationContext12.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pop()).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext23);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext24);

    // Act
    ObjectIdValidator.tagHeader(msg, ctx);

    // Assert
    verify(validationContext24).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext20).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext16).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext12).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext8).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext4).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext19).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext23).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext15).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext11).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext).failed();
    verify(validationContext22).pop();
    verify(validationContext18).pop();
    verify(validationContext14).pop();
    verify(validationContext10).pop();
    verify(validationContext6).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext21).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext17).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext13).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext9).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext5).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link ObjectIdValidator#tagSelector(TagSelector, ValidationContext)}
   */
  @Test
  void testTagSelector() {
    // Arrange
    TagSelector msg = TagSelector.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyOneOf(Mockito.<Descriptors.FieldDescriptor>any(),
        Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyOneOf(Mockito.<Descriptors.FieldDescriptor>any(),
        Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyOneOf(Mockito.<Descriptors.FieldDescriptor>any(),
        Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyOneOf(Mockito.<Descriptors.FieldDescriptor>any(),
        Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyOneOf(Mockito.<Descriptors.FieldDescriptor>any(),
        Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyOneOf(Mockito.<Descriptors.FieldDescriptor>any(),
        Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pop()).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext18);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext19);

    // Act
    ObjectIdValidator.tagSelector(msg, ctx);

    // Assert
    verify(validationContext19).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext15).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext11).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext5).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext14).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext18).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext10).applyOneOf(isA(Descriptors.FieldDescriptor.class), isA(ValidationFunction.Typed.class),
        isA(Class.class));
    verify(validationContext9).applyOneOf(isA(Descriptors.FieldDescriptor.class), isA(ValidationFunction.Typed.class),
        isA(Class.class));
    verify(validationContext8).applyOneOf(isA(Descriptors.FieldDescriptor.class), isA(ValidationFunction.Typed.class),
        isA(Class.class));
    verify(validationContext4).applyOneOf(isA(Descriptors.FieldDescriptor.class), isA(ValidationFunction.Typed.class),
        isA(Class.class));
    verify(validationContext3).applyOneOf(isA(Descriptors.FieldDescriptor.class), isA(ValidationFunction.Typed.class),
        isA(Class.class));
    verify(validationContext2).applyOneOf(isA(Descriptors.FieldDescriptor.class), isA(ValidationFunction.Typed.class),
        isA(Class.class));
    verify(validationContext17).pop();
    verify(validationContext13).pop();
    verify(validationContext7).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext16).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext12).pushOneOf(isA(Descriptors.OneofDescriptor.class));
    verify(validationContext6).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }

  /**
   * Method under test:
   * {@link ObjectIdValidator#preallocated(TagSelector, ValidationContext)}
   */
  @Test
  void testPreallocated() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.fieldName()).thenReturn("Field Name");
    when(validationContext.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext4);
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
    ObjectIdValidator.preallocated(selector, ctx);

    // Assert
    verify(validationContext8).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext4).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext7).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext).error(
        eq("The [Field Name] selector is not a preallocated object ID (object and tag version must be set to zero)"));
    verify(validationContext).fieldName();
    verify(validationContext6).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext5).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link ObjectIdValidator#selectorType(TagSelector, List, ValidationContext)}
   */
  @Test
  void testSelectorType() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();
    ArrayList<ObjectType> allowedTypes = new ArrayList<>();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.selectorType(selector, allowedTypes, ctx);

    // Assert
    verify(ctx).error(eq("Wrong object type in [Field Name] selector: allowed [], got [OBJECT_TYPE_NOT_SET]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link ObjectIdValidator#selectorType(TagSelector, ObjectType, ValidationContext)}
   */
  @Test
  void testSelectorType2() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.selectorType(selector, ObjectType.DATA, ctx);

    // Assert
    verify(ctx).error(eq("Wrong object type in [Field Name] selector: expected [DATA], got [OBJECT_TYPE_NOT_SET]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link ObjectIdValidator#selectorForLatest(TagSelector, ValidationContext)}
   */
  @Test
  void testSelectorForLatest() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.selectorForLatest(selector, ctx);

    // Assert
    verify(ctx).error(eq(
        "The [Field Name] selector must refer to the latest object and tag version, fixed versions are not allowed"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link ObjectIdValidator#explicitObjectVersion(TagSelector, ValidationContext)}
   */
  @Test
  void testExplicitObjectVersion() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.explicitObjectVersion(selector, ctx);

    // Assert
    verify(ctx).error(eq("The [Field Name] selector must use an explicit [objectVersion]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link ObjectIdValidator#explicitTagVersion(TagSelector, ValidationContext)}
   */
  @Test
  void testExplicitTagVersion() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.explicitTagVersion(selector, ctx);

    // Assert
    verify(ctx).error(eq("The [Field Name] selector must use an explicit [tagVersion]"));
    verify(ctx).fieldName();
  }

  /**
   * Method under test:
   * {@link ObjectIdValidator#versioningSupported(ObjectType, ValidationContext)}
   */
  @Test
  void testVersioningSupported() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    ObjectIdValidator.versioningSupported(ObjectType.OBJECT_TYPE_NOT_SET, ctx);

    // Assert
    verify(ctx).error(eq("Object type [OBJECT_TYPE_NOT_SET] does not support versioning"));
  }
}
