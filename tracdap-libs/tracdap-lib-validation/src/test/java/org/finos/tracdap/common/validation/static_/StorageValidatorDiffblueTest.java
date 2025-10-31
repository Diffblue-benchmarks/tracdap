package org.finos.tracdap.common.validation.static_;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.StorageCopy;
import org.finos.tracdap.metadata.StorageDefinition;
import org.finos.tracdap.metadata.StorageIncarnation;
import org.finos.tracdap.metadata.StorageItem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StorageValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link StorageValidator#storageDefinition(StorageDefinition, ValidationContext)}
   */
  @Test
  void testStorageDefinition() {
    // Arrange
    StorageDefinition msg = StorageDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyMapValues(Mockito.<ValidationFunction.Typed<Object>>any(),
        Mockito.<Class<Object>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.applyMapKeys(Mockito.<ValidationFunction.Typed<String>>any()))
        .thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext3);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushMap(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext4);

    // Act
    StorageValidator.storageDefinition(msg, ctx);

    // Assert
    verify(validationContext4).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).applyMapKeys(isA(ValidationFunction.Typed.class));
    verify(validationContext2).applyMapValues(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).pushMap(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link StorageValidator#storageItem(StorageItem, ValidationContext)}
   */
  @Test
  void testStorageItem() {
    // Arrange
    StorageItem msg = StorageItem.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(
        validationContext2.applyRepeated(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext2);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushRepeated(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    StorageValidator.storageItem(msg, ctx);

    // Assert
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext2).applyRepeated(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext).pop();
    verify(ctx).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link StorageValidator#storageIncarnation(StorageIncarnation, ValidationContext)}
   */
  @Test
  void testStorageIncarnation() {
    // Arrange
    StorageIncarnation msg = StorageIncarnation.getDefaultInstance();
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
    when(validationContext6.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext9);
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
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext16);

    // Act
    StorageValidator.storageIncarnation(msg, ctx);

    // Assert
    verify(validationContext16).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext12).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext7).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext3).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext15).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext11).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext10).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).applyRepeated(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext14).pop();
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext13).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext8).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext4).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link StorageValidator#storageCopy(StorageCopy, ValidationContext)}
   */
  @Test
  void testStorageCopy() {
    // Arrange
    StorageCopy msg = StorageCopy.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
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
    when(validationContext11.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.apply(Mockito.<ValidationFunction.Basic>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pop()).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<ValidationFunction.Typed<String>>any())).thenReturn(validationContext14);
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
    StorageValidator.storageCopy(msg, ctx);

    // Assert
    verify(validationContext20).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext16).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext12).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext8).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext4).apply(isA(ValidationFunction.Basic.class));
    verify(validationContext19).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext15).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext11).apply(isA(ValidationFunction.Typed.class));
    verify(validationContext7).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(ValidationFunction.Typed.class), isA(Class.class));
    verify(validationContext18).pop();
    verify(validationContext14).pop();
    verify(validationContext10).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext17).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext13).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext9).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext5).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link StorageValidator#dataItemKey(String, ValidationContext)}
   */
  @Test
  void testDataItemKey() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    StorageValidator.dataItemKey("Data Item", ctx);

    // Assert
    verify(ctx).error(eq("Invalid data item key [Data Item]"));
  }
}
