package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.api.TracErrorDetails;
import org.finos.tracdap.api.TracErrorItem;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationResultDiffblueTest {
  /**
   * Test {@link ValidationResult#pass(ValidationType, String)}.
   * <p>
   * Method under test: {@link ValidationResult#pass(ValidationType, String)}
   */
  @Test
  @DisplayName("Test pass(ValidationType, String)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return failures Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#forContext(ValidationContext)}
   */
  @Test
  @DisplayName("Test forContext(ValidationContext); given ArrayList(); then return failures Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ValidationResult.forContext(ValidationContext)"})
  void testForContext_givenArrayList_thenReturnFailuresEmpty() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(Any.getDescriptor()));

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
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#forContext(ValidationContext)}
   */
  @Test
  @DisplayName("Test forContext(ValidationContext); given EUnexpected(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult ValidationResult.forContext(ValidationContext)"})
  void testForContext_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenThrow(new EUnexpected());
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(Any.getDescriptor()));

    // Act and Assert
    assertThrows(EUnexpected.class, () -> ValidationResult.forContext(ctx));
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
  }

  /**
   * Test {@link ValidationResult#ValidationResult(ValidationType, String, List)}.
   * <ul>
   *   <li>Then return not ok.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#ValidationResult(ValidationType, String, List)}
   */
  @Test
  @DisplayName("Test new ValidationResult(ValidationType, String, List); then return not ok")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationResult.<init>(ValidationType, String, List)"})
  void testNewValidationResult_thenReturnNotOk() {
    // Arrange
    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(new ValidationFailure(new ValidationLocation(
        new ValidationLocation(mock(ValidationLocation.class), "Target", null, null, "Field Name"), "Target", null,
        "Field Name"), "Not all who wander are lost"));

    // Act
    ValidationResult actualValidationResult = new ValidationResult(ValidationType.STATIC, "Short Name", failures);

    // Assert
    assertFalse(actualValidationResult.ok());
    assertEquals(failures, actualValidationResult.failures());
  }

  /**
   * Test {@link ValidationResult#ValidationResult(ValidationType, String, List)}.
   * <ul>
   *   <li>Then return not ok.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#ValidationResult(ValidationType, String, List)}
   */
  @Test
  @DisplayName("Test new ValidationResult(ValidationType, String, List); then return not ok")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationResult.<init>(ValidationType, String, List)"})
  void testNewValidationResult_thenReturnNotOk2() {
    // Arrange
    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(new ValidationFailure(new ValidationLocation(
        new ValidationLocation(mock(ValidationLocation.class), "Target", null, null, "Field Name"), "Target", null,
        "Field Name"), "Not all who wander are lost"));
    failures.add(new ValidationFailure(new ValidationLocation(
        new ValidationLocation(mock(ValidationLocation.class), "Target", null, null, "Field Name"), "Target", null,
        "Field Name"), "Not all who wander are lost"));

    // Act
    ValidationResult actualValidationResult = new ValidationResult(ValidationType.STATIC, "Short Name", failures);

    // Assert
    assertFalse(actualValidationResult.ok());
    assertEquals(failures, actualValidationResult.failures());
  }

  /**
   * Test {@link ValidationResult#ValidationResult(ValidationType, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return failures Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#ValidationResult(ValidationType, String, List)}
   */
  @Test
  @DisplayName("Test new ValidationResult(ValidationType, String, List); when ArrayList(); then return failures Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationResult.<init>(ValidationType, String, List)"})
  void testNewValidationResult_whenArrayList_thenReturnFailuresEmpty() {
    // Arrange and Act
    ValidationResult actualValidationResult = new ValidationResult(ValidationType.STATIC, "Short Name",
        new ArrayList<>());

    // Assert
    assertTrue(actualValidationResult.failures().isEmpty());
    assertTrue(actualValidationResult.ok());
  }

  /**
   * Test {@link ValidationResult#ok()}.
   * <ul>
   *   <li>Given pass {@code STATIC} and {@code Short Name}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#ok()}
   */
  @Test
  @DisplayName("Test ok(); given pass 'STATIC' and 'Short Name'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationResult.ok()"})
  void testOk_givenPassStaticAndShortName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ValidationResult.pass(ValidationType.STATIC, "Short Name").ok());
  }

  /**
   * Test {@link ValidationResult#ok()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#ok()}
   */
  @Test
  @DisplayName("Test ok(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationResult.ok()"})
  void testOk_thenReturnFalse() {
    // Arrange
    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(new ValidationFailure(new ValidationLocation(
        new ValidationLocation(mock(ValidationLocation.class), "Target", null, null, "Field Name"), "Target", null,
        "Field Name"), "Not all who wander are lost"));

    // Act and Assert
    assertFalse((new ValidationResult(ValidationType.STATIC, "Short Name", failures)).ok());
  }

  /**
   * Test {@link ValidationResult#failures()}.
   * <p>
   * Method under test: {@link ValidationResult#failures()}
   */
  @Test
  @DisplayName("Test failures()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ValidationResult.failures()"})
  void testFailures() {
    // Arrange, Act and Assert
    assertTrue(ValidationResult.pass(ValidationType.STATIC, "Short Name").failures().isEmpty());
  }

  /**
   * Test {@link ValidationResult#failureMessage()}.
   * <p>
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  @DisplayName("Test failureMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationResult.failureMessage()"})
  void testFailureMessage() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);
    ValidationFailure validationFailure = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent2 = mock(ValidationLocation.class);
    when(parent2.isRoot()).thenReturn(true);
    ValidationFailure validationFailure2 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent2, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent3 = mock(ValidationLocation.class);
    when(parent3.isRoot()).thenReturn(true);
    ValidationFailure validationFailure3 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent3, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent4 = mock(ValidationLocation.class);
    when(parent4.isRoot()).thenReturn(true);
    ValidationFailure validationFailure4 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent4, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent5 = mock(ValidationLocation.class);
    when(parent5.isRoot()).thenReturn(true);
    ValidationFailure validationFailure5 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent5, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent6 = mock(ValidationLocation.class);
    when(parent6.isRoot()).thenReturn(true);
    ValidationFailure validationFailure6 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent6, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent7 = mock(ValidationLocation.class);
    when(parent7.isRoot()).thenReturn(true);
    ValidationFailure validationFailure7 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent7, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent8 = mock(ValidationLocation.class);
    when(parent8.isRoot()).thenReturn(true);
    ValidationFailure validationFailure8 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent8, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent9 = mock(ValidationLocation.class);
    when(parent9.isRoot()).thenReturn(true);
    ValidationFailure validationFailure9 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent9, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent10 = mock(ValidationLocation.class);
    when(parent10.isRoot()).thenReturn(true);
    ValidationFailure validationFailure10 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent10, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent11 = mock(ValidationLocation.class);
    when(parent11.isRoot()).thenReturn(true);
    ValidationFailure validationFailure11 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent11, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent12 = mock(ValidationLocation.class);
    when(parent12.isRoot()).thenReturn(true);
    ValidationFailure validationFailure12 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent12, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent13 = mock(ValidationLocation.class);
    when(parent13.isRoot()).thenReturn(true);
    ValidationFailure validationFailure13 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent13, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent14 = mock(ValidationLocation.class);
    when(parent14.isRoot()).thenReturn(true);
    ValidationFailure validationFailure14 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent14, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent15 = mock(ValidationLocation.class);
    when(parent15.isRoot()).thenReturn(true);
    ValidationFailure validationFailure15 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent15, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent16 = mock(ValidationLocation.class);
    when(parent16.isRoot()).thenReturn(true);
    ValidationFailure validationFailure16 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent16, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent17 = mock(ValidationLocation.class);
    when(parent17.isRoot()).thenReturn(true);
    ValidationFailure validationFailure17 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent17, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent18 = mock(ValidationLocation.class);
    when(parent18.isRoot()).thenReturn(true);
    ValidationFailure validationFailure18 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent18, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent19 = mock(ValidationLocation.class);
    when(parent19.isRoot()).thenReturn(true);
    ValidationFailure validationFailure19 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent19, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent20 = mock(ValidationLocation.class);
    when(parent20.isRoot()).thenReturn(true);
    ValidationFailure validationFailure20 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent20, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent21 = mock(ValidationLocation.class);
    when(parent21.isRoot()).thenReturn(true);
    ValidationFailure validationFailure21 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent21, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent22 = mock(ValidationLocation.class);
    when(parent22.isRoot()).thenReturn(true);
    ValidationFailure validationFailure22 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent22, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(new ValidationFailure(new ValidationLocation(null, "Target", null, "Field Name"),
        "Not all who wander are lost"));
    failures.add(validationFailure22);
    failures.add(validationFailure21);
    failures.add(validationFailure20);
    failures.add(validationFailure19);
    failures.add(validationFailure18);
    failures.add(validationFailure17);
    failures.add(validationFailure16);
    failures.add(validationFailure15);
    failures.add(validationFailure14);
    failures.add(validationFailure13);
    failures.add(validationFailure12);
    failures.add(validationFailure11);
    failures.add(validationFailure10);
    failures.add(validationFailure9);
    failures.add(validationFailure8);
    failures.add(validationFailure7);
    failures.add(validationFailure6);
    failures.add(validationFailure5);
    failures.add(validationFailure4);
    failures.add(validationFailure3);
    failures.add(validationFailure2);
    failures.add(validationFailure);

    // Act
    String actualFailureMessageResult = (new ValidationResult(ValidationType.STATIC, "Short Name", failures))
        .failureMessage();

    // Assert
    verify(parent22).isRoot();
    verify(parent21).isRoot();
    verify(parent20).isRoot();
    verify(parent19).isRoot();
    verify(parent18).isRoot();
    verify(parent17).isRoot();
    verify(parent16).isRoot();
    verify(parent15).isRoot();
    verify(parent14).isRoot();
    verify(parent13).isRoot();
    verify(parent12).isRoot();
    verify(parent11).isRoot();
    verify(parent10).isRoot();
    verify(parent9).isRoot();
    verify(parent8).isRoot();
    verify(parent7).isRoot();
    verify(parent6).isRoot();
    verify(parent5).isRoot();
    verify(parent4).isRoot();
    verify(parent3).isRoot();
    verify(parent2).isRoot();
    verify(parent).isRoot();
    assertEquals("There were multiple validation errors\n" + "Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n" + "Field Name.Field Name: Not all who wander are lost",
        actualFailureMessageResult);
  }

  /**
   * Test {@link ValidationResult#failureMessage()}.
   * <ul>
   *   <li>Given pass {@code STATIC} and {@code Short Name}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  @DisplayName("Test failureMessage(); given pass 'STATIC' and 'Short Name'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationResult.failureMessage()"})
  void testFailureMessage_givenPassStaticAndShortName_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ValidationResult.pass(ValidationType.STATIC, "Short Name").failureMessage());
  }

  /**
   * Test {@link ValidationResult#failureMessage()}.
   * <ul>
   *   <li>Given {@link ValidationLocation} {@link ValidationLocation#isRoot()} return {@code false}.</li>
   *   <li>Then calls {@link ValidationLocation#elementPath()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  @DisplayName("Test failureMessage(); given ValidationLocation isRoot() return 'false'; then calls elementPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationResult.failureMessage()"})
  void testFailureMessage_givenValidationLocationIsRootReturnFalse_thenCallsElementPath() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);
    when(parent.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent2 = mock(ValidationLocation.class);
    when(parent2.isRoot()).thenReturn(true);
    when(parent2.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure2 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent2, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent3 = mock(ValidationLocation.class);
    when(parent3.isRoot()).thenReturn(true);
    when(parent3.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure3 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent3, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent4 = mock(ValidationLocation.class);
    when(parent4.isRoot()).thenReturn(true);
    when(parent4.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure4 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent4, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent5 = mock(ValidationLocation.class);
    when(parent5.isRoot()).thenReturn(true);
    when(parent5.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure5 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent5, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent6 = mock(ValidationLocation.class);
    when(parent6.isRoot()).thenReturn(true);
    when(parent6.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure6 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent6, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent7 = mock(ValidationLocation.class);
    when(parent7.isRoot()).thenReturn(true);
    when(parent7.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure7 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent7, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent8 = mock(ValidationLocation.class);
    when(parent8.isRoot()).thenReturn(true);
    when(parent8.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure8 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent8, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent9 = mock(ValidationLocation.class);
    when(parent9.isRoot()).thenReturn(true);
    when(parent9.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure9 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent9, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent10 = mock(ValidationLocation.class);
    when(parent10.isRoot()).thenReturn(true);
    when(parent10.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure10 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent10, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent11 = mock(ValidationLocation.class);
    when(parent11.isRoot()).thenReturn(true);
    when(parent11.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure11 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent11, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent12 = mock(ValidationLocation.class);
    when(parent12.isRoot()).thenReturn(true);
    when(parent12.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure12 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent12, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent13 = mock(ValidationLocation.class);
    when(parent13.isRoot()).thenReturn(true);
    when(parent13.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure13 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent13, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent14 = mock(ValidationLocation.class);
    when(parent14.isRoot()).thenReturn(true);
    when(parent14.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure14 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent14, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent15 = mock(ValidationLocation.class);
    when(parent15.isRoot()).thenReturn(true);
    when(parent15.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure15 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent15, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent16 = mock(ValidationLocation.class);
    when(parent16.isRoot()).thenReturn(true);
    when(parent16.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure16 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent16, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent17 = mock(ValidationLocation.class);
    when(parent17.isRoot()).thenReturn(true);
    when(parent17.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure17 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent17, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent18 = mock(ValidationLocation.class);
    when(parent18.isRoot()).thenReturn(true);
    when(parent18.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure18 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent18, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent19 = mock(ValidationLocation.class);
    when(parent19.isRoot()).thenReturn(true);
    when(parent19.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure19 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent19, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent20 = mock(ValidationLocation.class);
    when(parent20.isRoot()).thenReturn(true);
    when(parent20.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure20 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent20, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent21 = mock(ValidationLocation.class);
    when(parent21.isRoot()).thenReturn(true);
    when(parent21.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure21 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent21, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent22 = mock(ValidationLocation.class);
    when(parent22.isRoot()).thenReturn(true);
    when(parent22.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure22 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent22, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent23 = mock(ValidationLocation.class);
    when(parent23.isRoot()).thenReturn(false);
    when(parent23.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure23 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent23, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure23);
    failures.add(validationFailure22);
    failures.add(validationFailure21);
    failures.add(validationFailure20);
    failures.add(validationFailure19);
    failures.add(validationFailure18);
    failures.add(validationFailure17);
    failures.add(validationFailure16);
    failures.add(validationFailure15);
    failures.add(validationFailure14);
    failures.add(validationFailure13);
    failures.add(validationFailure12);
    failures.add(validationFailure11);
    failures.add(validationFailure10);
    failures.add(validationFailure9);
    failures.add(validationFailure8);
    failures.add(validationFailure7);
    failures.add(validationFailure6);
    failures.add(validationFailure5);
    failures.add(validationFailure4);
    failures.add(validationFailure3);
    failures.add(validationFailure2);
    failures.add(validationFailure);

    // Act
    String actualFailureMessageResult = (new ValidationResult(ValidationType.STATIC, "Short Name", failures))
        .failureMessage();

    // Assert
    verify(parent23).elementPath();
    verify(parent23).isRoot();
    verify(parent22).isRoot();
    verify(parent21).isRoot();
    verify(parent20).isRoot();
    verify(parent19).isRoot();
    verify(parent18).isRoot();
    verify(parent17).isRoot();
    verify(parent16).isRoot();
    verify(parent15).isRoot();
    verify(parent14).isRoot();
    verify(parent13).isRoot();
    verify(parent12).isRoot();
    verify(parent11).isRoot();
    verify(parent10).isRoot();
    verify(parent9).isRoot();
    verify(parent8).isRoot();
    verify(parent7).isRoot();
    verify(parent6).isRoot();
    verify(parent5).isRoot();
    verify(parent4).isRoot();
    verify(parent3).isRoot();
    verify(parent2).isRoot();
    verify(parent).isRoot();
    assertEquals("There were multiple validation errors\n"
        + "Element Path.Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost\n" + "Field Name.Field Name: Not all who wander are lost",
        actualFailureMessageResult);
  }

  /**
   * Test {@link ValidationResult#failureMessage()}.
   * <ul>
   *   <li>Given {@link ValidationLocation} {@link ValidationLocation#isRoot()} return {@code true}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  @DisplayName("Test failureMessage(); given ValidationLocation isRoot() return 'true'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationResult.failureMessage()"})
  void testFailureMessage_givenValidationLocationIsRootReturnTrue_thenReturnAString() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);
    ValidationFailure validationFailure = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent2 = mock(ValidationLocation.class);
    when(parent2.isRoot()).thenReturn(true);
    ValidationFailure validationFailure2 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent2, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure2);
    failures.add(validationFailure);

    // Act
    String actualFailureMessageResult = (new ValidationResult(ValidationType.STATIC, "Short Name", failures))
        .failureMessage();

    // Assert
    verify(parent2).isRoot();
    verify(parent).isRoot();
    assertEquals("There were multiple validation errors\n" + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost", actualFailureMessageResult);
  }

  /**
   * Test {@link ValidationResult#failureMessage()}.
   * <ul>
   *   <li>Then return {@code Field Name.Field Name: Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  @DisplayName("Test failureMessage(); then return 'Field Name.Field Name: Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationResult.failureMessage()"})
  void testFailureMessage_thenReturnFieldNameFieldNameNotAllWhoWanderAreLost() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);
    ValidationFailure validationFailure = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure);

    // Act
    String actualFailureMessageResult = (new ValidationResult(ValidationType.STATIC, "Short Name", failures))
        .failureMessage();

    // Assert
    verify(parent).isRoot();
    assertEquals("Field Name.Field Name: Not all who wander are lost", actualFailureMessageResult);
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   * <p>
   * Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails() {
    // Arrange and Act
    TracErrorDetails actualErrorDetailsResult = ValidationResult.pass(ValidationType.VERSION, "Short Name")
        .errorDetails();

    // Assert
    assertEquals("Version compatability check failed for [Short Name}",
        actualErrorDetailsResult.getMessageBytes().toStringUtf8());
    assertEquals("Version compatability check failed for [Short Name}", actualErrorDetailsResult.getMessage());
    assertEquals(55, actualErrorDetailsResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualErrorDetailsResult.getUnknownFields();
    TracErrorDetails defaultInstanceForType = actualErrorDetailsResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   * <p>
   * Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails2() {
    // Arrange and Act
    TracErrorDetails actualErrorDetailsResult = ValidationResult.pass(ValidationType.CONSISTENCY, "Short Name")
        .errorDetails();

    // Assert
    assertEquals("Consistency check failed for [Short Name]",
        actualErrorDetailsResult.getMessageBytes().toStringUtf8());
    assertEquals("Consistency check failed for [Short Name]", actualErrorDetailsResult.getMessage());
    assertEquals(45, actualErrorDetailsResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualErrorDetailsResult.getUnknownFields();
    TracErrorDetails defaultInstanceForType = actualErrorDetailsResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   * <p>
   * Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails3() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);
    when(parent.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent2 = mock(ValidationLocation.class);
    when(parent2.isRoot()).thenReturn(true);
    when(parent2.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure2 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent2, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent3 = mock(ValidationLocation.class);
    when(parent3.isRoot()).thenReturn(true);
    when(parent3.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure3 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent3, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent4 = mock(ValidationLocation.class);
    when(parent4.isRoot()).thenReturn(true);
    when(parent4.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure4 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent4, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent5 = mock(ValidationLocation.class);
    when(parent5.isRoot()).thenReturn(true);
    when(parent5.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure5 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent5, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent6 = mock(ValidationLocation.class);
    when(parent6.isRoot()).thenReturn(true);
    when(parent6.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure6 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent6, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent7 = mock(ValidationLocation.class);
    when(parent7.isRoot()).thenReturn(true);
    when(parent7.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure7 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent7, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent8 = mock(ValidationLocation.class);
    when(parent8.isRoot()).thenReturn(true);
    when(parent8.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure8 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent8, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent9 = mock(ValidationLocation.class);
    when(parent9.isRoot()).thenReturn(true);
    when(parent9.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure9 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent9, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent10 = mock(ValidationLocation.class);
    when(parent10.isRoot()).thenReturn(true);
    when(parent10.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure10 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent10, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent11 = mock(ValidationLocation.class);
    when(parent11.isRoot()).thenReturn(true);
    when(parent11.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure11 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent11, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent12 = mock(ValidationLocation.class);
    when(parent12.isRoot()).thenReturn(true);
    when(parent12.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure12 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent12, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent13 = mock(ValidationLocation.class);
    when(parent13.isRoot()).thenReturn(true);
    when(parent13.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure13 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent13, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent14 = mock(ValidationLocation.class);
    when(parent14.isRoot()).thenReturn(true);
    when(parent14.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure14 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent14, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent15 = mock(ValidationLocation.class);
    when(parent15.isRoot()).thenReturn(true);
    when(parent15.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure15 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent15, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent16 = mock(ValidationLocation.class);
    when(parent16.isRoot()).thenReturn(true);
    when(parent16.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure16 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent16, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent17 = mock(ValidationLocation.class);
    when(parent17.isRoot()).thenReturn(true);
    when(parent17.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure17 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent17, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent18 = mock(ValidationLocation.class);
    when(parent18.isRoot()).thenReturn(true);
    when(parent18.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure18 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent18, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent19 = mock(ValidationLocation.class);
    when(parent19.isRoot()).thenReturn(true);
    when(parent19.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure19 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent19, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent20 = mock(ValidationLocation.class);
    when(parent20.isRoot()).thenReturn(true);
    when(parent20.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure20 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent20, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent21 = mock(ValidationLocation.class);
    when(parent21.isRoot()).thenReturn(true);
    when(parent21.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure21 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent21, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent22 = mock(ValidationLocation.class);
    when(parent22.isRoot()).thenReturn(true);
    when(parent22.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure22 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent22, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent23 = mock(ValidationLocation.class);
    when(parent23.isRoot()).thenReturn(false);
    when(parent23.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure23 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent23, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure23);
    failures.add(validationFailure22);
    failures.add(validationFailure21);
    failures.add(validationFailure20);
    failures.add(validationFailure19);
    failures.add(validationFailure18);
    failures.add(validationFailure17);
    failures.add(validationFailure16);
    failures.add(validationFailure15);
    failures.add(validationFailure14);
    failures.add(validationFailure13);
    failures.add(validationFailure12);
    failures.add(validationFailure11);
    failures.add(validationFailure10);
    failures.add(validationFailure9);
    failures.add(validationFailure8);
    failures.add(validationFailure7);
    failures.add(validationFailure6);
    failures.add(validationFailure5);
    failures.add(validationFailure4);
    failures.add(validationFailure3);
    failures.add(validationFailure2);
    failures.add(validationFailure);

    // Act
    TracErrorDetails actualErrorDetailsResult = (new ValidationResult(ValidationType.STATIC, "Short Name", failures))
        .errorDetails();

    // Assert
    verify(parent23).elementPath();
    verify(parent23).isRoot();
    verify(parent22).isRoot();
    verify(parent21).isRoot();
    verify(parent20).isRoot();
    verify(parent19).isRoot();
    verify(parent18).isRoot();
    verify(parent17).isRoot();
    verify(parent16).isRoot();
    verify(parent15).isRoot();
    verify(parent14).isRoot();
    verify(parent13).isRoot();
    verify(parent12).isRoot();
    verify(parent11).isRoot();
    verify(parent10).isRoot();
    verify(parent9).isRoot();
    verify(parent8).isRoot();
    verify(parent7).isRoot();
    verify(parent6).isRoot();
    verify(parent5).isRoot();
    verify(parent4).isRoot();
    verify(parent3).isRoot();
    verify(parent2).isRoot();
    verify(parent).isRoot();
    List<TracErrorItem> itemsList = actualErrorDetailsResult.getItemsList();
    assertEquals(23, itemsList.size());
    TracErrorItem getResult = itemsList.get(0);
    ByteString fieldPathBytes = getResult.getFieldPathBytes();
    assertEquals("Element Path.Field Name.Field Name", fieldPathBytes.toStringUtf8());
    assertEquals("Element Path.Field Name.Field Name", getResult.getFieldPath());
    assertEquals(1293, actualErrorDetailsResult.getSerializedSize());
    assertEquals(65, getResult.getSerializedSize());
    ByteIterator iteratorResult = fieldPathBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('E', iteratorResult.next().byteValue());
    assertEquals('l', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   * <ul>
   *   <li>Given pass {@code UNDEFINED} and {@code Short Name}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails(); given pass 'UNDEFINED' and 'Short Name'; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails_givenPassUndefinedAndShortName_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> ValidationResult.pass(ValidationType.UNDEFINED, "Short Name").errorDetails());
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   * <ul>
   *   <li>Then return ItemsList first FieldPath is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails(); then return ItemsList first FieldPath is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails_thenReturnItemsListFirstFieldPathIsEmptyString() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);
    ValidationFailure validationFailure = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent2 = mock(ValidationLocation.class);
    when(parent2.isRoot()).thenReturn(true);
    ValidationFailure validationFailure2 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent2, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent3 = mock(ValidationLocation.class);
    when(parent3.isRoot()).thenReturn(true);
    ValidationFailure validationFailure3 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent3, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent4 = mock(ValidationLocation.class);
    when(parent4.isRoot()).thenReturn(true);
    ValidationFailure validationFailure4 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent4, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent5 = mock(ValidationLocation.class);
    when(parent5.isRoot()).thenReturn(true);
    ValidationFailure validationFailure5 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent5, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent6 = mock(ValidationLocation.class);
    when(parent6.isRoot()).thenReturn(true);
    ValidationFailure validationFailure6 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent6, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent7 = mock(ValidationLocation.class);
    when(parent7.isRoot()).thenReturn(true);
    ValidationFailure validationFailure7 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent7, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent8 = mock(ValidationLocation.class);
    when(parent8.isRoot()).thenReturn(true);
    ValidationFailure validationFailure8 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent8, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent9 = mock(ValidationLocation.class);
    when(parent9.isRoot()).thenReturn(true);
    ValidationFailure validationFailure9 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent9, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent10 = mock(ValidationLocation.class);
    when(parent10.isRoot()).thenReturn(true);
    ValidationFailure validationFailure10 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent10, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent11 = mock(ValidationLocation.class);
    when(parent11.isRoot()).thenReturn(true);
    ValidationFailure validationFailure11 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent11, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent12 = mock(ValidationLocation.class);
    when(parent12.isRoot()).thenReturn(true);
    ValidationFailure validationFailure12 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent12, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent13 = mock(ValidationLocation.class);
    when(parent13.isRoot()).thenReturn(true);
    ValidationFailure validationFailure13 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent13, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent14 = mock(ValidationLocation.class);
    when(parent14.isRoot()).thenReturn(true);
    ValidationFailure validationFailure14 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent14, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent15 = mock(ValidationLocation.class);
    when(parent15.isRoot()).thenReturn(true);
    ValidationFailure validationFailure15 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent15, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent16 = mock(ValidationLocation.class);
    when(parent16.isRoot()).thenReturn(true);
    ValidationFailure validationFailure16 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent16, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent17 = mock(ValidationLocation.class);
    when(parent17.isRoot()).thenReturn(true);
    ValidationFailure validationFailure17 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent17, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent18 = mock(ValidationLocation.class);
    when(parent18.isRoot()).thenReturn(true);
    ValidationFailure validationFailure18 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent18, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent19 = mock(ValidationLocation.class);
    when(parent19.isRoot()).thenReturn(true);
    ValidationFailure validationFailure19 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent19, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent20 = mock(ValidationLocation.class);
    when(parent20.isRoot()).thenReturn(true);
    ValidationFailure validationFailure20 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent20, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent21 = mock(ValidationLocation.class);
    when(parent21.isRoot()).thenReturn(true);
    ValidationFailure validationFailure21 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent21, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent22 = mock(ValidationLocation.class);
    when(parent22.isRoot()).thenReturn(true);
    ValidationFailure validationFailure22 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent22, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(new ValidationFailure(new ValidationLocation(null, "Target", null, "Field Name"),
        "Not all who wander are lost"));
    failures.add(validationFailure22);
    failures.add(validationFailure21);
    failures.add(validationFailure20);
    failures.add(validationFailure19);
    failures.add(validationFailure18);
    failures.add(validationFailure17);
    failures.add(validationFailure16);
    failures.add(validationFailure15);
    failures.add(validationFailure14);
    failures.add(validationFailure13);
    failures.add(validationFailure12);
    failures.add(validationFailure11);
    failures.add(validationFailure10);
    failures.add(validationFailure9);
    failures.add(validationFailure8);
    failures.add(validationFailure7);
    failures.add(validationFailure6);
    failures.add(validationFailure5);
    failures.add(validationFailure4);
    failures.add(validationFailure3);
    failures.add(validationFailure2);
    failures.add(validationFailure);

    // Act
    TracErrorDetails actualErrorDetailsResult = (new ValidationResult(ValidationType.STATIC, "Short Name", failures))
        .errorDetails();

    // Assert
    verify(parent22).isRoot();
    verify(parent21).isRoot();
    verify(parent20).isRoot();
    verify(parent19).isRoot();
    verify(parent18).isRoot();
    verify(parent17).isRoot();
    verify(parent16).isRoot();
    verify(parent15).isRoot();
    verify(parent14).isRoot();
    verify(parent13).isRoot();
    verify(parent12).isRoot();
    verify(parent11).isRoot();
    verify(parent10).isRoot();
    verify(parent9).isRoot();
    verify(parent8).isRoot();
    verify(parent7).isRoot();
    verify(parent6).isRoot();
    verify(parent5).isRoot();
    verify(parent4).isRoot();
    verify(parent3).isRoot();
    verify(parent2).isRoot();
    verify(parent).isRoot();
    List<TracErrorItem> itemsList = actualErrorDetailsResult.getItemsList();
    assertEquals(23, itemsList.size());
    TracErrorItem getResult = itemsList.get(0);
    assertEquals("", getResult.getFieldPath());
    assertEquals(1, getResult.getAllFields().size());
    assertEquals(1257, actualErrorDetailsResult.getSerializedSize());
    assertEquals(29, getResult.getSerializedSize());
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   * <ul>
   *   <li>Then return ItemsList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails(); then return ItemsList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails_thenReturnItemsListSizeIsOne() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);
    ValidationFailure validationFailure = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure);

    // Act
    TracErrorDetails actualErrorDetailsResult = (new ValidationResult(ValidationType.STATIC, "Short Name", failures))
        .errorDetails();

    // Assert
    verify(parent).isRoot();
    assertEquals(1, actualErrorDetailsResult.getItemsList().size());
    assertEquals(1, actualErrorDetailsResult.getItemsCount());
    assertEquals(92, actualErrorDetailsResult.getSerializedSize());
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   * <ul>
   *   <li>Then return SerializedSize is one hundred forty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails(); then return SerializedSize is one hundred forty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails_thenReturnSerializedSizeIsOneHundredFortySix() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);
    ValidationFailure validationFailure = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ValidationLocation parent2 = mock(ValidationLocation.class);
    when(parent2.isRoot()).thenReturn(true);
    ValidationFailure validationFailure2 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent2, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> failures = new ArrayList<>();
    failures.add(validationFailure2);
    failures.add(validationFailure);

    // Act
    TracErrorDetails actualErrorDetailsResult = (new ValidationResult(ValidationType.STATIC, "Short Name", failures))
        .errorDetails();

    // Assert
    verify(parent2).isRoot();
    verify(parent).isRoot();
    assertEquals(146, actualErrorDetailsResult.getSerializedSize());
    List<TracErrorItem> itemsList = actualErrorDetailsResult.getItemsList();
    assertEquals(2, itemsList.size());
    assertEquals(2, actualErrorDetailsResult.getItemsCount());
    assertEquals(itemsList.get(0), itemsList.get(1));
  }

  /**
   * Test {@link ValidationResult#errorDetails()}.
   * <ul>
   *   <li>Then return SerializedSize is thirty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  @DisplayName("Test errorDetails(); then return SerializedSize is thirty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TracErrorDetails ValidationResult.errorDetails()"})
  void testErrorDetails_thenReturnSerializedSizeIsThirtyEight() {
    // Arrange and Act
    TracErrorDetails actualErrorDetailsResult = ValidationResult.pass(ValidationType.STATIC, "Short Name")
        .errorDetails();

    // Assert
    assertEquals(38, actualErrorDetailsResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualErrorDetailsResult.getUnknownFields();
    TracErrorDetails defaultInstanceForType = actualErrorDetailsResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }
}
