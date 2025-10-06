package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.api.TracErrorDetails;
import org.finos.tracdap.api.TracErrorItem;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationType;
import org.finos.tracdap.metadata.ArrayValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationResultDiffblueTest {
  /**
   * Test {@link ValidationResult#pass(ValidationType, String)}.
   *
   * <p>Method under test: {@link ValidationResult#pass(ValidationType, String)}
   */
  @Test
  @DisplayName("Test pass(ValidationType, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult ValidationResult.pass(ValidationType, String)"})
  void testPass() {
    // Arrange and Act
    ValidationResult actualPassResult = ValidationResult.pass(ValidationType.STATIC, "Short Name");

    // Assert
    assertTrue(actualPassResult.failures().isEmpty());
    assertTrue(actualPassResult.ok());
  }

  /**
   * Test {@link ValidationResult#forContext(ValidationContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return failures Empty.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#forContext(ValidationContext)}
   */
  @Test
  @DisplayName("Test forContext(ValidationContext); given ArrayList(); then return failures Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult ValidationResult.forContext(ValidationContext)"})
  void testForContext_givenArrayList_thenReturnFailuresEmpty() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(ArrayValue.getDescriptor()));

    // Act
    ValidationResult actualForContextResult = ValidationResult.forContext(ctx);

    // Assert
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
    assertTrue(actualForContextResult.failures().isEmpty());
    assertTrue(actualForContextResult.ok());
  }

  /**
   * Test {@link ValidationResult#forContext(ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#getErrors()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#forContext(ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test forContext(ValidationContext); when ValidationContext getErrors() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult ValidationResult.forContext(ValidationContext)"})
  void testForContext_whenValidationContextGetErrorsThrowEUnexpected() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenThrow(new EUnexpected());
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(ArrayValue.getDescriptor()));

    // Act and Assert
    assertThrows(EUnexpected.class, () -> ValidationResult.forContext(ctx));
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
  }

  /**
   * Test {@link ValidationResult#forContext(ValidationContext)}.
   *
   * <ul>
   *   <li>When {@link ValidationContext} {@link ValidationContext#validationType()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#forContext(ValidationContext)}
   */
  @Test
  @DisplayName(
      "Test forContext(ValidationContext); when ValidationContext validationType() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult ValidationResult.forContext(ValidationContext)"})
  void testForContext_whenValidationContextValidationTypeThrowEUnexpected() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.validationType()).thenThrow(new EUnexpected());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> ValidationResult.forContext(ctx));
    verify(ctx).validationType();
  }

  /**
   * Test {@link ValidationResult#ValidationResult(ValidationType, String, List)}.
   *
   * <ul>
   *   <li>Then return not ok.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#ValidationResult(ValidationType, String, List)}
   */
  @Test
  @DisplayName("Test new ValidationResult(ValidationType, String, List); then return not ok")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidationResult.<init>(ValidationType, String, List)"})
  void testNewValidationResult_thenReturnNotOk() {
    // Arrange
    ArrayList<ValidationFailure> failures = new ArrayList<>();
    ValidationLocation parent =
        new ValidationLocation(
            mock(ValidationLocation.class),
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");
    ValidationLocation location =
        new ValidationLocation(parent, "Target", mock(FieldDescriptor.class), "Field Name");
    failures.add(new ValidationFailure(location, "Not all who wander are lost"));

    // Act
    ValidationResult actualValidationResult =
        new ValidationResult(ValidationType.STATIC, "Short Name", failures);

    // Assert
    assertFalse(actualValidationResult.ok());
    assertEquals(failures, actualValidationResult.failures());
  }

  /**
   * Test {@link ValidationResult#ValidationResult(ValidationType, String, List)}.
   *
   * <ul>
   *   <li>Then return not ok.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#ValidationResult(ValidationType, String, List)}
   */
  @Test
  @DisplayName("Test new ValidationResult(ValidationType, String, List); then return not ok")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidationResult.<init>(ValidationType, String, List)"})
  void testNewValidationResult_thenReturnNotOk2() {
    // Arrange
    ArrayList<ValidationFailure> failures = new ArrayList<>();
    ValidationLocation parent =
        new ValidationLocation(
            mock(ValidationLocation.class),
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");
    ValidationLocation location =
        new ValidationLocation(parent, "Target", mock(FieldDescriptor.class), "Field Name");
    failures.add(new ValidationFailure(location, "Not all who wander are lost"));
    ValidationLocation parent2 =
        new ValidationLocation(
            mock(ValidationLocation.class),
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");
    ValidationLocation location2 =
        new ValidationLocation(parent2, "Target", mock(FieldDescriptor.class), "Field Name");
    failures.add(new ValidationFailure(location2, "Not all who wander are lost"));

    // Act
    ValidationResult actualValidationResult =
        new ValidationResult(ValidationType.STATIC, "Short Name", failures);

    // Assert
    assertFalse(actualValidationResult.ok());
    assertEquals(failures, actualValidationResult.failures());
  }

  /**
   * Test {@link ValidationResult#ValidationResult(ValidationType, String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return failures Empty.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#ValidationResult(ValidationType, String, List)}
   */
  @Test
  @DisplayName(
      "Test new ValidationResult(ValidationType, String, List); when ArrayList(); then return failures Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidationResult.<init>(ValidationType, String, List)"})
  void testNewValidationResult_whenArrayList_thenReturnFailuresEmpty() {
    // Arrange and Act
    ValidationResult actualValidationResult =
        new ValidationResult(ValidationType.STATIC, "Short Name", new ArrayList<>());

    // Assert
    assertTrue(actualValidationResult.failures().isEmpty());
    assertTrue(actualValidationResult.ok());
  }

  /**
   * Test {@link ValidationResult#ok()}.
   *
   * <ul>
   *   <li>Given pass {@code STATIC} and {@code Short Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#ok()}
   */
  @Test
  @DisplayName("Test ok(); given pass 'STATIC' and 'Short Name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationResult.ok()"})
  void testOk_givenPassStaticAndShortName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ValidationResult.pass(ValidationType.STATIC, "Short Name").ok());
  }

  /**
   * Test {@link ValidationResult#ok()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#ok()}
   */
  @Test
  @DisplayName("Test ok(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationResult.ok()"})
  void testOk_thenReturnFalse() {
    // Arrange
    ArrayList<ValidationFailure> failures = new ArrayList<>();
    ValidationLocation parent =
        new ValidationLocation(
            mock(ValidationLocation.class),
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");
    ValidationLocation location =
        new ValidationLocation(parent, "Target", mock(FieldDescriptor.class), "Field Name");
    failures.add(new ValidationFailure(location, "Not all who wander are lost"));
    ValidationResult validationResult =
        new ValidationResult(ValidationType.STATIC, "Short Name", failures);

    // Act and Assert
    assertFalse(validationResult.ok());
  }

  /**
   * Test {@link ValidationResult#failures()}.
   *
   * <p>Method under test: {@link ValidationResult#failures()}
   */
  @Test
  @DisplayName("Test failures()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ValidationResult.failures()"})
  void testFailures() {
    // Arrange, Act and Assert
    assertTrue(ValidationResult.pass(ValidationType.STATIC, "Short Name").failures().isEmpty());
  }

  /**
   * Test {@link ValidationResult#failureMessage()}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#isRepeated()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  @DisplayName("Test failureMessage(); given FieldDescriptor isRepeated() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ValidationResult.failureMessage()"})
  void testFailureMessage_givenFieldDescriptorIsRepeatedThrowEUnexpected() {
    // Arrange
    FieldDescriptor field = mock(FieldDescriptor.class);
    when(field.isRepeated()).thenThrow(new EUnexpected());
    ValidationLocation parent =
        new ValidationLocation(
            mock(ValidationLocation.class),
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");

    ValidationLocation location = new ValidationLocation(parent, "Target", field, "Field Name");
    ValidationFailure validationFailure =
        new ValidationFailure(location, "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure);
    ValidationResult validationResult =
        new ValidationResult(ValidationType.STATIC, "Short Name", failures);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> validationResult.failureMessage());
    verify(field).isRepeated();
  }

  /**
   * Test {@link ValidationResult#failureMessage()}.
   *
   * <ul>
   *   <li>Given pass {@code STATIC} and {@code Short Name}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  @DisplayName(
      "Test failureMessage(); given pass 'STATIC' and 'Short Name'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ValidationResult.failureMessage()"})
  void testFailureMessage_givenPassStaticAndShortName_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ValidationResult.pass(ValidationType.STATIC, "Short Name").failureMessage());
  }

  /**
   * Test {@link ValidationResult#failureMessage()}.
   *
   * <ul>
   *   <li>Given {@link ValidationLocation} {@link ValidationLocation#isRoot()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  @DisplayName("Test failureMessage(); given ValidationLocation isRoot() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ValidationResult.failureMessage()"})
  void testFailureMessage_givenValidationLocationIsRootThrowEUnexpected() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenThrow(new EUnexpected());
    ValidationLocation parent2 =
        new ValidationLocation(
            parent,
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");

    FieldDescriptor field = mock(FieldDescriptor.class);
    when(field.isRepeated()).thenReturn(true);

    ValidationLocation location = new ValidationLocation(parent2, "Target", field, "Field Name");
    ValidationFailure validationFailure =
        new ValidationFailure(location, "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure);
    ValidationResult validationResult =
        new ValidationResult(ValidationType.STATIC, "Short Name", failures);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> validationResult.failureMessage());
    verify(field).isRepeated();
    verify(parent).isRoot();
  }

  /**
   * Test {@link ValidationResult#failureMessage()}.
   *
   * <ul>
   *   <li>Then return {@code Field Name.Field Name: Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  @DisplayName(
      "Test failureMessage(); then return 'Field Name.Field Name: Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ValidationResult.failureMessage()"})
  void testFailureMessage_thenReturnFieldNameFieldNameNotAllWhoWanderAreLost() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);
    ValidationLocation parent2 =
        new ValidationLocation(
            parent,
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");

    FieldDescriptor field = mock(FieldDescriptor.class);
    when(field.isRepeated()).thenReturn(true);

    ValidationLocation location = new ValidationLocation(parent2, "Target", field, "Field Name");
    ValidationFailure validationFailure =
        new ValidationFailure(location, "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure);
    ValidationResult validationResult =
        new ValidationResult(ValidationType.STATIC, "Short Name", failures);

    // Act
    String actualFailureMessageResult = validationResult.failureMessage();

    // Assert
    verify(field).isRepeated();
    verify(parent).isRoot();
    assertEquals("Field Name.Field Name: Not all who wander are lost", actualFailureMessageResult);
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   *
   * <p>Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails() {
    // Arrange
    ValidationResult validationResult =
        new ValidationResult(ValidationType.VERSION, "Short Name", new ArrayList<>());

    // Act
    TracErrorDetails actualErrorDetailsResult = validationResult.errorDetails();

    // Assert
    assertEquals(
        "Version compatability check failed for [Short Name}",
        actualErrorDetailsResult.getMessageBytes().toStringUtf8());
    assertEquals(
        "Version compatability check failed for [Short Name}",
        actualErrorDetailsResult.getMessage());
    assertEquals(55, actualErrorDetailsResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualErrorDetailsResult.getUnknownFields();
    TracErrorDetails defaultInstanceForType = actualErrorDetailsResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   *
   * <p>Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails2() {
    // Arrange
    ValidationResult validationResult =
        new ValidationResult(ValidationType.CONSISTENCY, "Short Name", new ArrayList<>());

    // Act
    TracErrorDetails actualErrorDetailsResult = validationResult.errorDetails();

    // Assert
    assertEquals(
        "Consistency check failed for [Short Name]",
        actualErrorDetailsResult.getMessageBytes().toStringUtf8());
    assertEquals(
        "Consistency check failed for [Short Name]", actualErrorDetailsResult.getMessage());
    assertEquals(45, actualErrorDetailsResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualErrorDetailsResult.getUnknownFields();
    TracErrorDetails defaultInstanceForType = actualErrorDetailsResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   *
   * <p>Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails3() {
    // Arrange
    ValidationResult validationResult =
        new ValidationResult(ValidationType.UNDEFINED, "Short Name", new ArrayList<>());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> validationResult.errorDetails());
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor} {@link FieldDescriptor#isRepeated()} throw {@link
   *       EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails(); given FieldDescriptor isRepeated() throw EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails_givenFieldDescriptorIsRepeatedThrowEUnexpected() {
    // Arrange
    FieldDescriptor field = mock(FieldDescriptor.class);
    when(field.isRepeated()).thenThrow(new EUnexpected());
    ValidationLocation parent =
        new ValidationLocation(
            mock(ValidationLocation.class),
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");

    ValidationLocation location = new ValidationLocation(parent, "Target", field, "Field Name");
    ValidationFailure validationFailure =
        new ValidationFailure(location, "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure);
    ValidationResult validationResult =
        new ValidationResult(ValidationType.STATIC, "Short Name", failures);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> validationResult.errorDetails());
    verify(field).isRepeated();
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   *
   * <ul>
   *   <li>Given pass {@code STATIC} and {@code Short Name}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails(); given pass 'STATIC' and 'Short Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails_givenPassStaticAndShortName() {
    // Arrange and Act
    TracErrorDetails actualErrorDetailsResult =
        ValidationResult.pass(ValidationType.STATIC, "Short Name").errorDetails();

    // Assert
    UnknownFieldSet unknownFields = actualErrorDetailsResult.getUnknownFields();
    TracErrorDetails defaultInstanceForType = actualErrorDetailsResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   *
   * <ul>
   *   <li>Given {@link ValidationLocation} {@link ValidationLocation#isRoot()} throw {@link
   *       EUnexpected#EUnexpected()}.
   *   <li>Then calls {@link ValidationLocation#isRoot()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName(
      "Test errorDetails(); given ValidationLocation isRoot() throw EUnexpected(); then calls isRoot()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails_givenValidationLocationIsRootThrowEUnexpected_thenCallsIsRoot() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenThrow(new EUnexpected());
    ValidationLocation parent2 =
        new ValidationLocation(
            parent,
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");

    FieldDescriptor field = mock(FieldDescriptor.class);
    when(field.isRepeated()).thenReturn(true);

    ValidationLocation location = new ValidationLocation(parent2, "Target", field, "Field Name");
    ValidationFailure validationFailure =
        new ValidationFailure(location, "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure);
    ValidationResult validationResult =
        new ValidationResult(ValidationType.STATIC, "Short Name", failures);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> validationResult.errorDetails());
    verify(field).isRepeated();
    verify(parent).isRoot();
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   *
   * <ul>
   *   <li>Then return DescriptorForType File MessageTypes size is two.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails(); then return DescriptorForType File MessageTypes size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails_thenReturnDescriptorForTypeFileMessageTypesSizeIsTwo() {
    // Arrange
    ValidationResult validationResult =
        new ValidationResult(ValidationType.STATIC, "Short Name", new ArrayList<>());

    // Act and Assert
    assertEquals(
        2,
        validationResult.errorDetails().getDescriptorForType().getFile().getMessageTypes().size());
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   *
   * <ul>
   *   <li>Then return ItemsList size is one.
   * </ul>
   *
   * <p>Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails(); then return ItemsList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails_thenReturnItemsListSizeIsOne() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);
    ValidationLocation parent2 =
        new ValidationLocation(
            parent,
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");

    FieldDescriptor field = mock(FieldDescriptor.class);
    when(field.isRepeated()).thenReturn(true);

    ValidationLocation location = new ValidationLocation(parent2, "Target", field, "Field Name");
    ValidationFailure validationFailure =
        new ValidationFailure(location, "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure);
    ValidationResult validationResult =
        new ValidationResult(ValidationType.STATIC, "Short Name", failures);

    // Act
    TracErrorDetails actualErrorDetailsResult = validationResult.errorDetails();

    // Assert
    verify(field).isRepeated();
    verify(parent).isRoot();
    assertEquals(1, actualErrorDetailsResult.getItemsList().size());
    assertEquals(1, actualErrorDetailsResult.getItemsCount());
    assertEquals(3, actualErrorDetailsResult.getAllFields().size());
    assertEquals(92, actualErrorDetailsResult.getSerializedSize());
    TracErrorDetails defaultInstanceForType = actualErrorDetailsResult.getDefaultInstanceForType();
    List<TracErrorItem> itemsList = defaultInstanceForType.getItemsList();
    assertTrue(itemsList.isEmpty());
    assertSame(itemsList, defaultInstanceForType.getItemsOrBuilderList());
  }
}
