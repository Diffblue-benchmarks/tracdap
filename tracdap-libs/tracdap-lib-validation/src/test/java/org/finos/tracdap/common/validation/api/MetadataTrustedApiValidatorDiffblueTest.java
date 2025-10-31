package org.finos.tracdap.common.validation.api;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.api.MetadataBatchRequest;
import org.finos.tracdap.api.MetadataReadRequest;
import org.finos.tracdap.api.MetadataSearchRequest;
import org.finos.tracdap.api.MetadataWriteBatchRequest;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataTrustedApiValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link MetadataTrustedApiValidator#createObject(MetadataWriteRequest, ValidationContext)}
   */
  @Test
  void testCreateObject() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyIf(anyBoolean(), Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext13);
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
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext20);

    // Act
    MetadataTrustedApiValidator.createObject(msg, ctx);

    // Assert
    verify(validationContext20).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext16).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext7).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext4).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext19).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext15).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext14).applyIf(eq(false), isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext11).applyRepeated(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext18).pop();
    verify(validationContext13).pop();
    verify(validationContext9).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext17).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext8).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext5).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext12).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link MetadataTrustedApiValidator#updateObject(MetadataWriteRequest, ValidationContext)}
   */
  @Test
  void testUpdateObject() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext2);
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
    when(validationContext8.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext7);
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
    when(validationContext13.applyRepeated(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushRepeated(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyIf(anyBoolean(), Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pop()).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext22);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext23);

    // Act
    MetadataTrustedApiValidator.updateObject(msg, ctx);

    // Assert
    verify(validationContext23).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext19).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext10).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext4).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext22).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext18).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext9).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext3).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext17).applyIf(eq(true), isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext14).applyRepeated(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext21).pop();
    verify(validationContext16).pop();
    verify(validationContext12).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext20).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext11).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext5).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext15).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link MetadataTrustedApiValidator#updateTag(MetadataWriteRequest, ValidationContext)}
   */
  @Test
  void testUpdateTag() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext6);
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
    when(validationContext12.applyRepeated(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushRepeated(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyIf(anyBoolean(), Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext21);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext22);

    // Act
    MetadataTrustedApiValidator.updateTag(msg, ctx);

    // Assert
    verify(validationContext22).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext18).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext9).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext21).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext17).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext5).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext16).applyIf(eq(false), isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext20).pop();
    verify(validationContext15).pop();
    verify(validationContext11).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext19).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext10).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext3).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext14).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link MetadataTrustedApiValidator#preallocateId(MetadataWriteRequest, ValidationContext)}
   */
  @Test
  void testPreallocateId() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
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
    when(validationContext8.applyRepeated(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(
        validationContext9.applyRepeated(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pushRepeated(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyIf(anyBoolean(), Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext11);
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
    when(validationContext17.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext17);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext18);

    // Act
    MetadataTrustedApiValidator.preallocateId(msg, ctx);

    // Assert
    verify(validationContext18).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext14).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext5).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext17).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext13).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext12).applyIf(eq(false), isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext9).applyRepeated(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext8).applyRepeated(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext16).pop();
    verify(validationContext11).pop();
    verify(validationContext7).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext15).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext6).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext3).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext10).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link MetadataTrustedApiValidator#createPreallocatedObject(MetadataWriteRequest, ValidationContext)}
   */
  @Test
  void testCreatePreallocatedObject() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext6);
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
    when(validationContext12.applyRepeated(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(),
        Mockito.<Class<Object>>any(), Mockito.<Object>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushRepeated(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyIf(anyBoolean(), Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext21);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext22);

    // Act
    MetadataTrustedApiValidator.createPreallocatedObject(msg, ctx);

    // Assert
    verify(validationContext22).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext18).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext9).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext4).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext21).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext17).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext3).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext16).applyIf(eq(false), isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext13).applyRepeated(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(ValidationFunction.TypedArg.class), isA(Class.class),
        isA(Object.class));
    verify(validationContext20).pop();
    verify(validationContext15).pop();
    verify(validationContext11).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext19).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext10).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext5).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext14).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link MetadataTrustedApiValidator#writeBatch(MetadataWriteBatchRequest, ValidationContext)}
   */
  @Test
  void testWriteBatch() {
    // Arrange
    MetadataWriteBatchRequest msg = MetadataWriteBatchRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext3);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext4);

    // Act
    MetadataTrustedApiValidator.writeBatch(msg, ctx);

    // Assert
    verify(validationContext4).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext).error(eq("Write batch request does not contain any operations"));
    verify(validationContext2).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link MetadataTrustedApiValidator#readObject(MetadataReadRequest, ValidationContext)}
   */
  @Test
  void testReadObject() {
    // Arrange
    MetadataReadRequest msg = MetadataReadRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext6);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext7);

    // Act
    MetadataTrustedApiValidator.readObject(msg, ctx);

    // Assert
    verify(validationContext7).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext6).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link MetadataTrustedApiValidator#search(MetadataSearchRequest, ValidationContext)}
   */
  @Test
  void testSearch() {
    // Arrange
    MetadataSearchRequest msg = MetadataSearchRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext6);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext7);

    // Act
    MetadataTrustedApiValidator.search(msg, ctx);

    // Assert
    verify(validationContext7).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext6).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link MetadataTrustedApiValidator#readBatch(MetadataBatchRequest, ValidationContext)}
   */
  @Test
  void testReadBatch() {
    // Arrange
    MetadataBatchRequest msg = MetadataBatchRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(
        validationContext2.applyRepeated(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushRepeated(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext6);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext7);

    // Act
    MetadataTrustedApiValidator.readBatch(msg, ctx);

    // Assert
    verify(validationContext7).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext6).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext2).applyRepeated(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }
}
