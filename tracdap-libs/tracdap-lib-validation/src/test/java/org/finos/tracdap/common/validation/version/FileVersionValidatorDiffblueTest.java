package org.finos.tracdap.common.validation.version;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.metadata.FileDefinition;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FileVersionValidatorDiffblueTest {
  /**
   * Method under test:
   * {@link FileVersionValidator#fileVersion(FileDefinition, FileDefinition, ValidationContext)}
   */
  @Test
  void testFileVersion() {
    // Arrange
    FileDefinition current = FileDefinition.getDefaultInstance();
    FileDefinition prior = FileDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<ValidationFunction.Version<Object>>any())).thenReturn(validationContext);
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
    when(validationContext11.apply(Mockito.<ValidationFunction.Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<Descriptors.FieldDescriptor>any())).thenReturn(validationContext11);

    // Act
    FileVersionValidator.fileVersion(current, prior, ctx);

    // Assert
    verify(validationContext8).apply(isA(ValidationFunction.Version.class));
    verify(validationContext5).apply(isA(ValidationFunction.Version.class));
    verify(validationContext2).apply(isA(ValidationFunction.Version.class));
    verify(validationContext11).apply(isA(ValidationFunction.Version.class), isA(Class.class));
    verify(validationContext10).pop();
    verify(validationContext7).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext9).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext6).push(isA(Descriptors.FieldDescriptor.class));
    verify(validationContext3).push(isA(Descriptors.FieldDescriptor.class));
  }

  /**
   * Method under test:
   * {@link FileVersionValidator#sameExtension(String, String, ValidationContext)}
   */
  @Test
  void testSameExtension() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.fieldName()).thenReturn("Field Name");
    when(ctx.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));

    // Act
    FileVersionValidator.sameExtension(".", "Prior Name", ctx);

    // Assert
    verify(ctx).error(eq("File extension in field [Field Name] changed between versions: prior = [], new = [.]"));
    verify(ctx).fieldName();
  }
}
