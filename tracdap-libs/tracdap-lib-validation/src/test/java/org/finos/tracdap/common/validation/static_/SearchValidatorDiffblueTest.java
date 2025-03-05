package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.metadata.LogicalExpression;
import org.finos.tracdap.metadata.SearchExpression;
import org.finos.tracdap.metadata.SearchParameters;
import org.finos.tracdap.metadata.SearchTerm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SearchValidatorDiffblueTest {
  /**
   * Test {@link SearchValidator#searchParameters(SearchParameters, ValidationContext)}.
   * <p>
   * Method under test: {@link SearchValidator#searchParameters(SearchParameters, ValidationContext)}
   */
  @Test
  @DisplayName("Test searchParameters(SearchParameters, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext SearchValidator.searchParameters(SearchParameters, ValidationContext)"})
  void testSearchParameters() {
    // Arrange
    SearchParameters msg = SearchParameters.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);

    // Act
    SearchValidator.searchParameters(msg, ctx);

    // Assert
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext17).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext13).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext9).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext16).pop();
    verify(validationContext12).pop();
    verify(validationContext7).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext15).push(isA(FieldDescriptor.class));
    verify(validationContext11).push(isA(FieldDescriptor.class));
    verify(validationContext6).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link SearchValidator#searchExpression(SearchExpression, ValidationContext)}.
   * <p>
   * Method under test: {@link SearchValidator#searchExpression(SearchExpression, ValidationContext)}
   */
  @Test
  @DisplayName("Test searchExpression(SearchExpression, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext SearchValidator.searchExpression(SearchExpression, ValidationContext)"})
  void testSearchExpression() {
    // Arrange
    SearchExpression msg = SearchExpression.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext4);

    // Act
    SearchValidator.searchExpression(msg, ctx);

    // Assert
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext3).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).pushOneOf(isA(OneofDescriptor.class));
  }

  /**
   * Test {@link SearchValidator#searchTerm(SearchTerm, ValidationContext)}.
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#failed()} return {@code true}.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchValidator#searchTerm(SearchTerm, ValidationContext)}
   */
  @Test
  @DisplayName("Test searchTerm(SearchTerm, ValidationContext); given ValidationContext failed() return 'true'; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext SearchValidator.searchTerm(SearchTerm, ValidationContext)"})
  void testSearchTerm_givenValidationContextFailedReturnTrue_thenCallsApply() {
    // Arrange
    SearchTerm msg = SearchTerm.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(true);
    when(validationContext.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyIf(anyBoolean(), Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyIf(anyBoolean(), Mockito.<Basic>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);
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
    when(validationContext13.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyIf(anyBoolean(), Mockito.<Basic>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyIf(anyBoolean(), Mockito.<Basic>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pop()).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext19);

    // Act
    SearchValidator.searchTerm(msg, ctx);

    // Assert
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Typed.class));
    verify(validationContext13).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext12).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext14).applyIf(eq(false), isA(Basic.class));
    verify(validationContext4).applyIf(eq(false), isA(Basic.class));
    verify(validationContext15).applyIf(eq(true), isA(Basic.class));
    verify(validationContext5).applyIf(eq(true), isA(Basic.class));
    verify(validationContext).failed();
    verify(validationContext17).pop();
    verify(validationContext11).pop();
    verify(validationContext7).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext16).push(isA(FieldDescriptor.class));
    verify(validationContext10).push(isA(FieldDescriptor.class));
    verify(validationContext6).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link SearchValidator#searchTerm(SearchTerm, ValidationContext)}.
   * <ul>
   *   <li>Then calls {@link ValidationContext#applyIf(boolean, Typed, Class)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchValidator#searchTerm(SearchTerm, ValidationContext)}
   */
  @Test
  @DisplayName("Test searchTerm(SearchTerm, ValidationContext); then calls applyIf(boolean, Typed, Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext SearchValidator.searchTerm(SearchTerm, ValidationContext)"})
  void testSearchTerm_thenCallsApplyIf() {
    // Arrange
    SearchTerm msg = SearchTerm.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.failed()).thenReturn(false);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyIf(anyBoolean(), Mockito.<Basic>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyIf(anyBoolean(), Mockito.<Basic>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyIf(anyBoolean(), Mockito.<Basic>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyIf(anyBoolean(), Mockito.<Basic>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Basic>any())).thenReturn(validationContext19);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext20);

    // Act
    SearchValidator.searchTerm(msg, ctx);

    // Assert
    verify(validationContext20).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Typed.class));
    verify(validationContext14).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext13).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext9).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext4).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext15).applyIf(eq(false), isA(Basic.class));
    verify(validationContext5).applyIf(eq(false), isA(Basic.class));
    verify(validationContext16).applyIf(eq(true), isA(Basic.class));
    verify(validationContext6).applyIf(eq(true), isA(Basic.class));
    verify(validationContext).applyIf(eq(true), isA(Typed.class), isA(Class.class));
    verify(validationContext2).failed();
    verify(validationContext18).pop();
    verify(validationContext12).pop();
    verify(validationContext8).pop();
    verify(validationContext3).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext17).push(isA(FieldDescriptor.class));
    verify(validationContext11).push(isA(FieldDescriptor.class));
    verify(validationContext7).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link SearchValidator#logicalExpression(LogicalExpression, ValidationContext)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchValidator#logicalExpression(LogicalExpression, ValidationContext)}
   */
  @Test
  @DisplayName("Test logicalExpression(LogicalExpression, ValidationContext); when DefaultInstance; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext SearchValidator.logicalExpression(LogicalExpression, ValidationContext)"})
  void testLogicalExpression_whenDefaultInstance_thenCallsApply() {
    // Arrange
    LogicalExpression msg = LogicalExpression.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
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
    SearchValidator.logicalExpression(msg, ctx);

    // Assert
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext3).pushRepeated(isA(FieldDescriptor.class));
  }
}
