package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.LogicalExpression;
import org.finos.tracdap.metadata.SearchExpression;
import org.finos.tracdap.metadata.SearchParameters;
import org.finos.tracdap.metadata.SearchTerm;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SearchValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link SearchValidator#searchParameters(SearchParameters, ValidationContext)}
   */
  @Test
  void testSearchParameters() {
    // Arrange
    SearchParameters msg = SearchParameters.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext17);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext18);

    // Act
    SearchValidator.searchParameters(msg, ctx);

    // Assert
    verify(validationContext18).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext14).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext10).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext5).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext17).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext13).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext9).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext16).pop();
    verify(validationContext12).pop();
    verify(validationContext7).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext15).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext11).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext6).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext3).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link SearchValidator#searchExpression(SearchExpression, ValidationContext)}
   */
  @Test
  void testSearchExpression() {
    // Arrange
    SearchExpression msg = SearchExpression.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyOneOf(Mockito.<Descriptors.FieldDescriptor>any(),
        Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyOneOf(Mockito.<Descriptors.FieldDescriptor>any(),
        Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext3);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushOneOf(Mockito.<Descriptors.OneofDescriptor>any())).thenReturn(validationContext4);

    // Act
    SearchValidator.searchExpression(msg, ctx);

    // Assert
    verify(validationContext4).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).applyOneOf(isA(Descriptors.FieldDescriptor.class), isA(ValidationFunction.Typed.class),
        isA(Class.class));
    verify(validationContext2).applyOneOf(isA(Descriptors.FieldDescriptor.class), isA(ValidationFunction.Typed.class),
        isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).pushOneOf(isA(Descriptors.OneofDescriptor.class));
  }

  /**
   * Method under test:
   * {@link SearchValidator#searchTerm(SearchTerm, ValidationContext)}
   */
  @Test
  void testSearchTerm() {
    // Arrange
    SearchTerm msg = SearchTerm.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.failed()).thenReturn(true);
    when(validationContext.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.applyIf(anyBoolean(), Mockito.<ValidationFunction.Basic>any()))
        .thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyIf(anyBoolean(), Mockito.<ValidationFunction.Basic>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyIf(anyBoolean(), Mockito.<ValidationFunction.Basic>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyIf(anyBoolean(), Mockito.<ValidationFunction.Basic>any()))
        .thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pop()).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext18);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext19);

    // Act
    SearchValidator.searchTerm(msg, ctx);

    // Assert
    verify(validationContext19).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext9).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext18).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext13).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext12).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext14).applyIf(eq(false), isA(ValidationFunction.Basic.class));
    verify(validationContext4).applyIf(eq(false), isA(ValidationFunction.Basic.class));
    verify(validationContext15).applyIf(eq(true), isA(ValidationFunction.Basic.class));
    verify(validationContext5).applyIf(eq(true), isA(ValidationFunction.Basic.class));
    verify(validationContext).failed();
    verify(validationContext17).pop();
    verify(validationContext11).pop();
    verify(validationContext7).pop();
    verify(validationContext2).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext16).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext10).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext6).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link SearchValidator#searchTerm(SearchTerm, ValidationContext)}
   */
  @Test
  void testSearchTerm2() {
    // Arrange
    SearchTerm msg = SearchTerm.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.applyIf(anyBoolean(), Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.failed()).thenReturn(false);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.applyIf(anyBoolean(), Mockito.<ValidationFunction.Basic>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.applyIf(anyBoolean(), Mockito.<ValidationFunction.Basic>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyIf(anyBoolean(), Mockito.<ValidationFunction.Basic>any()))
        .thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyIf(anyBoolean(), Mockito.<ValidationFunction.Basic>any()))
        .thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext19);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext20);

    // Act
    SearchValidator.searchTerm(msg, ctx);

    // Assert
    verify(validationContext20).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext10).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext19).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext14).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext13).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext9).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext4).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext15).applyIf(eq(false), isA(ValidationFunction.Basic.class));
    verify(validationContext5).applyIf(eq(false), isA(ValidationFunction.Basic.class));
    verify(validationContext16).applyIf(eq(true), isA(ValidationFunction.Basic.class));
    verify(validationContext6).applyIf(eq(true), isA(ValidationFunction.Basic.class));
    verify(validationContext).applyIf(eq(true), isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).failed();
    verify(validationContext18).pop();
    verify(validationContext12).pop();
    verify(validationContext8).pop();
    verify(validationContext3).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext17).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext11).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext7).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link SearchValidator#logicalExpression(LogicalExpression, ValidationContext)}
   */
  @Test
  void testLogicalExpression() {
    // Arrange
    LogicalExpression msg = LogicalExpression.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pushRepeated(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext2);
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
    SearchValidator.logicalExpression(msg, ctx);

    // Assert
    verify(validationContext6).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext5).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext3).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }
}
