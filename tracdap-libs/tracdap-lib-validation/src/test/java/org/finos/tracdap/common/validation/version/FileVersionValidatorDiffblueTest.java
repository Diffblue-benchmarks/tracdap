package org.finos.tracdap.common.validation.version;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Version;
import org.finos.tracdap.metadata.FileDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FileVersionValidatorDiffblueTest {
  /**
   * Test {@link FileVersionValidator#fileVersion(FileDefinition, FileDefinition, ValidationContext)}.
   * <p>
   * Method under test: {@link FileVersionValidator#fileVersion(FileDefinition, FileDefinition, ValidationContext)}
   */
  @Test
  @DisplayName("Test fileVersion(FileDefinition, FileDefinition, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext FileVersionValidator.fileVersion(FileDefinition, FileDefinition, ValidationContext)"})
  void testFileVersion() {
    // Arrange
    FileDefinition current = FileDefinition.getDefaultInstance();
    FileDefinition prior = FileDefinition.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Version<Object>>any())).thenReturn(validationContext);
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
    when(validationContext11.apply(Mockito.<Version<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    // Act
    FileVersionValidator.fileVersion(current, prior, ctx);

    // Assert
    verify(validationContext8).apply(isA(Version.class));
    verify(validationContext5).apply(isA(Version.class));
    verify(validationContext2).apply(isA(Version.class));
    verify(validationContext11).apply(isA(Version.class), isA(Class.class));
    verify(validationContext10).pop();
    verify(validationContext7).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext9).push(isA(FieldDescriptor.class));
    verify(validationContext6).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link FileVersionValidator#sameExtension(String, String, ValidationContext)}.
   * <ul>
   *   <li>Given {@code Field Name}.</li>
   *   <li>When {@code .}.</li>
   *   <li>Then calls {@link ValidationContext#error(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileVersionValidator#sameExtension(String, String, ValidationContext)}
   */
  @Test
  @DisplayName("Test sameExtension(String, String, ValidationContext); given 'Field Name'; when '.'; then calls error(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext FileVersionValidator.sameExtension(String, String, ValidationContext)"})
  void testSameExtension_givenFieldName_whenDot_thenCallsError() {
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
