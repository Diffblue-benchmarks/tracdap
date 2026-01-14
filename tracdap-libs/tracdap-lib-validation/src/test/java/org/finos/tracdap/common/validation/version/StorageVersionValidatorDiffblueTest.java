package org.finos.tracdap.common.validation.version;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Version;
import org.finos.tracdap.metadata.StorageCopy;
import org.finos.tracdap.metadata.StorageIncarnation;
import org.finos.tracdap.metadata.StorageItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StorageVersionValidatorDiffblueTest {
  /**
   * Test {@link StorageVersionValidator#item(StorageItem, StorageItem, ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#pushRepeated(FieldDescriptor)}
   *       return {@link ValidationContext}.
   *   <li>Then calls {@link ValidationContext#pop()}.
   * </ul>
   *
   * <p>Method under test: {@link StorageVersionValidator#item(StorageItem, StorageItem,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test item(StorageItem, StorageItem, ValidationContext); when ValidationContext pushRepeated(FieldDescriptor) return ValidationContext; then calls pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext StorageVersionValidator.item(StorageItem, StorageItem, ValidationContext)"
  })
  void testItem_whenValidationContextPushRepeatedReturnValidationContext_thenCallsPop() {
    // Arrange
    StorageItem current = StorageItem.getDefaultInstance();
    StorageItem prior = StorageItem.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext);

    // Act
    StorageVersionValidator.item(current, prior, ctx);

    // Assert
    verify(validationContext).pop();
    verify(ctx).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link StorageVersionValidator#incarnation(StorageIncarnation, StorageIncarnation,
   * ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#push(FieldDescriptor)} return
   *       {@link ValidationContext}.
   *   <li>Then calls {@link ValidationContext#apply(Version)}.
   * </ul>
   *
   * <p>Method under test: {@link StorageVersionValidator#incarnation(StorageIncarnation,
   * StorageIncarnation, ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test incarnation(StorageIncarnation, StorageIncarnation, ValidationContext); when ValidationContext push(FieldDescriptor) return ValidationContext; then calls apply(Version)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext StorageVersionValidator.incarnation(StorageIncarnation, StorageIncarnation, ValidationContext)"
  })
  void testIncarnation_whenValidationContextPushReturnValidationContext_thenCallsApply() {
    // Arrange
    StorageIncarnation current = StorageIncarnation.getDefaultInstance();
    StorageIncarnation prior = StorageIncarnation.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pushRepeated(Mockito.<FieldDescriptor>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.pop()).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext9);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);

    // Act
    StorageVersionValidator.incarnation(current, prior, ctx);

    // Assert
    verify(validationContext10).apply(isA(Version.class));
    verify(validationContext7).apply(isA(Version.class));
    verify(validationContext4).apply(isA(Version.class), isA(Class.class));
    verify(validationContext9).pop();
    verify(validationContext6).pop();
    verify(validationContext3).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
    verify(validationContext2).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link StorageVersionValidator#copy(StorageCopy, StorageCopy, ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ValidationContext} {@link ValidationContext#pop()} return {@link
   *       ValidationContext}.
   *   <li>Then calls {@link ValidationContext#apply(Version)}.
   * </ul>
   *
   * <p>Method under test: {@link StorageVersionValidator#copy(StorageCopy, StorageCopy,
   * ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test copy(StorageCopy, StorageCopy, ValidationContext); given ValidationContext pop() return ValidationContext; then calls apply(Version)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValidationContext StorageVersionValidator.copy(StorageCopy, StorageCopy, ValidationContext)"
  })
  void testCopy_givenValidationContextPopReturnValidationContext_thenCallsApply() {
    // Arrange
    StorageCopy current = StorageCopy.getDefaultInstance();
    StorageCopy prior = StorageCopy.getDefaultInstance();

    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));

    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);

    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);

    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);

    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext4);

    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);

    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);

    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext7);

    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext8);

    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pop()).thenReturn(validationContext9);

    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext10);

    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);

    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext13);

    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);

    // Act
    StorageVersionValidator.copy(current, prior, ctx);

    // Assert
    verify(validationContext14).apply(isA(Version.class));
    verify(validationContext11).apply(isA(Version.class));
    verify(validationContext8).apply(isA(Version.class));
    verify(validationContext5).apply(isA(Version.class));
    verify(validationContext2).apply(isA(Version.class), isA(Class.class));
    verify(validationContext13).pop();
    verify(validationContext10).pop();
    verify(validationContext7).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext12).push(isA(FieldDescriptor.class));
    verify(validationContext9).push(isA(FieldDescriptor.class));
    verify(validationContext6).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
  }
}
