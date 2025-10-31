package org.finos.tracdap.common.validation.version;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.StorageCopy;
import org.finos.tracdap.metadata.StorageIncarnation;
import org.finos.tracdap.metadata.StorageItem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StorageVersionValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link StorageVersionValidator#item(StorageItem, StorageItem, ValidationContext)}
   */
  @Test
  void testItem() {
    // Arrange
    StorageItem current = StorageItem.getDefaultInstance();
    StorageItem prior = StorageItem.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushRepeated(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext);

    // Act
    StorageVersionValidator.item(current, prior, ctx);

    // Assert
    verify(validationContext).pop();
    verify(ctx).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link StorageVersionValidator#incarnation(StorageIncarnation, StorageIncarnation, ValidationContext)}
   */
  @Test
  void testIncarnation() {
    // Arrange
    StorageIncarnation current = StorageIncarnation.getDefaultInstance();
    StorageIncarnation prior = StorageIncarnation.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pushRepeated(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<ValidationFunction.Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<ValidationFunction.Version<Object>>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<ValidationFunction.Version<Object>>any())).thenReturn(validationContext9);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext10);

    // Act
    StorageVersionValidator.incarnation(current, prior, ctx);

    // Assert
    verify(validationContext10).apply(isA(ValidationFunction.Version.class));
    verify(validationContext7).apply(isA(ValidationFunction.Version.class));
    verify(validationContext4).apply(isA(ValidationFunction.Version.class), isA(Class.class));
    verify(validationContext9).pop();
    verify(validationContext6).pop();
    verify(validationContext3).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext8).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext5).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext2).pushRepeated(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link StorageVersionValidator#incarnation(StorageIncarnation, StorageIncarnation, ValidationContext)}
   */
  @Test
  void testIncarnation2() {
    // Arrange
    StorageIncarnation current = StorageIncarnation.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.parentMsg()).thenReturn(null);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<ValidationFunction.TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(mock(ValidationContext.class));
    when(ctx.prior()).thenReturn(validationContext);

    // Act
    StorageVersionValidator.incarnation(current, null, ctx);

    // Assert
    verify(ctx).apply(isA(ValidationFunction.TypedArg.class), isA(Class.class), isNull());
    verify(validationContext).parentMsg();
    verify(ctx).prior();
  }

  /**
   * Method under test:
   * {@link StorageVersionValidator#copy(StorageCopy, StorageCopy, ValidationContext)}
   */
  @Test
  void testCopy() {
    // Arrange
    StorageCopy current = StorageCopy.getDefaultInstance();
    StorageCopy prior = StorageCopy.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<ValidationFunction.Version<Object>>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<ValidationFunction.Version<Object>>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<ValidationFunction.Version<Object>>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<ValidationFunction.Version<Object>>any())).thenReturn(validationContext13);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext14);

    // Act
    StorageVersionValidator.copy(current, prior, ctx);

    // Assert
    verify(validationContext14).apply(isA(ValidationFunction.Version.class));
    verify(validationContext11).apply(isA(ValidationFunction.Version.class));
    verify(validationContext8).apply(isA(ValidationFunction.Version.class));
    verify(validationContext5).apply(isA(ValidationFunction.Version.class));
    verify(validationContext2).apply(isA(ValidationFunction.Version.class), isA(Class.class));
    verify(validationContext13).pop();
    verify(validationContext10).pop();
    verify(validationContext7).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext12).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext9).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext6).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext3).push(isA(Descriptors.FieldDescriptor.class));
  }
}
