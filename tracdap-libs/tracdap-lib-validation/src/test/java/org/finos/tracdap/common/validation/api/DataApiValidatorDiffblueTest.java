package org.finos.tracdap.common.validation.api;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import org.finos.tracdap.api.DataReadRequest;
import org.finos.tracdap.api.DataWriteRequest;
import org.finos.tracdap.api.DownloadRequest;
import org.finos.tracdap.api.FileReadRequest;
import org.finos.tracdap.api.FileWriteRequest;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.common.validation.core.ValidationFunction.TypedArg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataApiValidatorDiffblueTest {
  /**
   * Test {@link DataApiValidator#createDataset(DataWriteRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#createDataset(DataWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test createDataset(DataWriteRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.createDataset(DataWriteRequest, ValidationContext)"})
  void testCreateDataset() {
    // Arrange
    DataWriteRequest msg = DataWriteRequest.getDefaultInstance();
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
    when(validationContext6.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Basic>any())).thenReturn(validationContext20);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext21);

    // Act
    DataApiValidator.createDataset(msg, ctx);

    // Assert
    verify(validationContext21).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext17).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext9).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext7).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext6).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext8).applyOneOf(isA(FieldDescriptor.class), isA(TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext14).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext20).pop();
    verify(validationContext16).pop();
    verify(validationContext12).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext19).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
    verify(validationContext11).pushOneOf(isA(OneofDescriptor.class));
    verify(validationContext15).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#createSmallDataset(DataWriteRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#createSmallDataset(DataWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test createSmallDataset(DataWriteRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.createSmallDataset(DataWriteRequest, ValidationContext)"})
  void testCreateSmallDataset() {
    // Arrange
    DataWriteRequest msg = DataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pop()).thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Basic>any())).thenReturn(validationContext24);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext25);

    // Act
    DataApiValidator.createSmallDataset(msg, ctx);

    // Assert
    verify(validationContext25).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext21).apply(isA(Typed.class));
    verify(validationContext6).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext11).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyOneOf(isA(FieldDescriptor.class), isA(TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext18).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext17).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext24).pop();
    verify(validationContext20).pop();
    verify(validationContext16).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext23).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
    verify(validationContext15).pushOneOf(isA(OneofDescriptor.class));
    verify(validationContext19).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#updateDataset(DataWriteRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#updateDataset(DataWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test updateDataset(DataWriteRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.updateDataset(DataWriteRequest, ValidationContext)"})
  void testUpdateDataset() {
    // Arrange
    DataWriteRequest msg = DataWriteRequest.getDefaultInstance();
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
    when(validationContext6.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Basic>any())).thenReturn(validationContext22);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext23);

    // Act
    DataApiValidator.updateDataset(msg, ctx);

    // Assert
    verify(validationContext23).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext17).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext22).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext21).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext9).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext7).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext6).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext8).applyOneOf(isA(FieldDescriptor.class), isA(TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext14).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext20).pop();
    verify(validationContext16).pop();
    verify(validationContext12).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext19).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
    verify(validationContext11).pushOneOf(isA(OneofDescriptor.class));
    verify(validationContext15).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#updateSmallDataset(DataWriteRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#updateSmallDataset(DataWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test updateSmallDataset(DataWriteRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.updateSmallDataset(DataWriteRequest, ValidationContext)"})
  void testUpdateSmallDataset() {
    // Arrange
    DataWriteRequest msg = DataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyOneOf(Mockito.<FieldDescriptor>any(), Mockito.<Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushOneOf(Mockito.<OneofDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pop()).thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.apply(Mockito.<Basic>any())).thenReturn(validationContext26);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext27);

    // Act
    DataApiValidator.updateSmallDataset(msg, ctx);

    // Assert
    verify(validationContext27).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext21).apply(isA(Typed.class));
    verify(validationContext6).apply(isA(Typed.class));
    verify(validationContext26).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext25).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext13).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext11).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyOneOf(isA(FieldDescriptor.class), isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyOneOf(isA(FieldDescriptor.class), isA(TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext18).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext17).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext24).pop();
    verify(validationContext20).pop();
    verify(validationContext16).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext23).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
    verify(validationContext15).pushOneOf(isA(OneofDescriptor.class));
    verify(validationContext19).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#readDataset(DataReadRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#readDataset(DataReadRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test readDataset(DataReadRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.readDataset(DataReadRequest, ValidationContext)"})
  void testReadDataset() {
    // Arrange
    DataReadRequest msg = DataReadRequest.getDefaultInstance();
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
    when(validationContext6.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext5);
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
    when(validationContext11.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext12);

    // Act
    DataApiValidator.readDataset(msg, ctx);

    // Assert
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext7).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext10).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext9).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#readSmallDataset(DataReadRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#readSmallDataset(DataReadRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test readSmallDataset(DataReadRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.readSmallDataset(DataReadRequest, ValidationContext)"})
  void testReadSmallDataset() {
    // Arrange
    DataReadRequest msg = DataReadRequest.getDefaultInstance();
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
    when(validationContext6.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext5);
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
    when(validationContext11.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext12);

    // Act
    DataApiValidator.readSmallDataset(msg, ctx);

    // Assert
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext7).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext10).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext9).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#createFile(FileWriteRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#createFile(FileWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test createFile(FileWriteRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.createFile(FileWriteRequest, ValidationContext)"})
  void testCreateFile() {
    // Arrange
    FileWriteRequest msg = FileWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pop()).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);
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
    when(validationContext23.apply(Mockito.<Basic>any())).thenReturn(validationContext22);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext23);

    // Act
    DataApiValidator.createFile(msg, ctx);

    // Assert
    verify(validationContext23).apply(isA(Basic.class));
    verify(validationContext20).apply(isA(Basic.class));
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Typed.class));
    verify(validationContext11).apply(isA(Typed.class));
    verify(validationContext10).apply(isA(Typed.class));
    verify(validationContext6).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext16).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext15).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext22).pop();
    verify(validationContext18).pop();
    verify(validationContext14).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext21).push(isA(FieldDescriptor.class));
    verify(validationContext13).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
    verify(validationContext17).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#createSmallFile(FileWriteRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#createSmallFile(FileWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test createSmallFile(FileWriteRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.createSmallFile(FileWriteRequest, ValidationContext)"})
  void testCreateSmallFile() {
    // Arrange
    FileWriteRequest msg = FileWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
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
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);
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
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Basic>any())).thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.pop()).thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.apply(Mockito.<Basic>any())).thenReturn(validationContext26);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext27);

    // Act
    DataApiValidator.createSmallFile(msg, ctx);

    // Assert
    verify(validationContext27).apply(isA(Basic.class));
    verify(validationContext24).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext23).apply(isA(Typed.class));
    verify(validationContext15).apply(isA(Typed.class));
    verify(validationContext14).apply(isA(Typed.class));
    verify(validationContext10).apply(isA(Typed.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext20).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext19).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext26).pop();
    verify(validationContext22).pop();
    verify(validationContext18).pop();
    verify(validationContext13).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext25).push(isA(FieldDescriptor.class));
    verify(validationContext17).push(isA(FieldDescriptor.class));
    verify(validationContext12).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
    verify(validationContext21).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#updateFile(FileWriteRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#updateFile(FileWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test updateFile(FileWriteRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.updateFile(FileWriteRequest, ValidationContext)"})
  void testUpdateFile() {
    // Arrange
    FileWriteRequest msg = FileWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<Basic>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pop()).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);
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
    when(validationContext23.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Basic>any())).thenReturn(validationContext24);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext25);

    // Act
    DataApiValidator.updateFile(msg, ctx);

    // Assert
    verify(validationContext25).apply(isA(Basic.class));
    verify(validationContext20).apply(isA(Basic.class));
    verify(validationContext12).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Typed.class));
    verify(validationContext11).apply(isA(Typed.class));
    verify(validationContext10).apply(isA(Typed.class));
    verify(validationContext6).apply(isA(Typed.class));
    verify(validationContext24).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext23).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext16).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext15).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext22).pop();
    verify(validationContext18).pop();
    verify(validationContext14).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext21).push(isA(FieldDescriptor.class));
    verify(validationContext13).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
    verify(validationContext17).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#updateSmallFile(FileWriteRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#updateSmallFile(FileWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test updateSmallFile(FileWriteRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.updateSmallFile(FileWriteRequest, ValidationContext)"})
  void testUpdateSmallFile() {
    // Arrange
    FileWriteRequest msg = FileWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
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
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);
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
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Basic>any())).thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.pop()).thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext26);
    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext27);
    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<Basic>any())).thenReturn(validationContext28);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext29);

    // Act
    DataApiValidator.updateSmallFile(msg, ctx);

    // Assert
    verify(validationContext29).apply(isA(Basic.class));
    verify(validationContext24).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext23).apply(isA(Typed.class));
    verify(validationContext15).apply(isA(Typed.class));
    verify(validationContext14).apply(isA(Typed.class));
    verify(validationContext10).apply(isA(Typed.class));
    verify(validationContext28).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext27).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext20).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext19).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext26).pop();
    verify(validationContext22).pop();
    verify(validationContext18).pop();
    verify(validationContext13).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext25).push(isA(FieldDescriptor.class));
    verify(validationContext17).push(isA(FieldDescriptor.class));
    verify(validationContext12).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
    verify(validationContext21).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#readFile(FileReadRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#readFile(FileReadRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test readFile(FileReadRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.readFile(FileReadRequest, ValidationContext)"})
  void testReadFile() {
    // Arrange
    FileReadRequest msg = FileReadRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext);
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
    when(validationContext7.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    // Act
    DataApiValidator.readFile(msg, ctx);

    // Assert
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Typed.class));
    verify(validationContext3).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#readSmallFile(FileReadRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#readSmallFile(FileReadRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test readSmallFile(FileReadRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.readSmallFile(FileReadRequest, ValidationContext)"})
  void testReadSmallFile() {
    // Arrange
    FileReadRequest msg = FileReadRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext);
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
    when(validationContext7.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Basic>any())).thenReturn(validationContext7);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    // Act
    DataApiValidator.readSmallFile(msg, ctx);

    // Assert
    verify(validationContext8).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Typed.class));
    verify(validationContext3).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#downloadFile(DownloadRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#downloadFile(DownloadRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test downloadFile(DownloadRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.downloadFile(DownloadRequest, ValidationContext)"})
  void testDownloadFile() {
    // Arrange
    DownloadRequest msg = DownloadRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    // Act
    DataApiValidator.downloadFile(msg, ctx);

    // Assert
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Typed.class));
    verify(validationContext6).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link DataApiValidator#downloadLatestFile(DownloadRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link DataApiValidator#downloadLatestFile(DownloadRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test downloadLatestFile(DownloadRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext DataApiValidator.downloadLatestFile(DownloadRequest, ValidationContext)"})
  void testDownloadLatestFile() {
    // Arrange
    DownloadRequest msg = DownloadRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.pop()).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);

    // Act
    DataApiValidator.downloadLatestFile(msg, ctx);

    // Assert
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Typed.class));
    verify(validationContext5).apply(isA(Typed.class));
    verify(validationContext8).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext7).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
  }
}
