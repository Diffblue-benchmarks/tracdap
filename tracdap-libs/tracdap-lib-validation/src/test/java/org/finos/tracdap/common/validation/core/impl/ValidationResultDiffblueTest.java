package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Any;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationType;
import org.junit.jupiter.api.Test;

class ValidationResultDiffblueTest {
  /**
   * Method under test: {@link ValidationResult#pass(ValidationType, String)}
   */
  @Test
  void testPass() {
    // Arrange and Act
    ValidationResult actualPassResult = ValidationResult.pass(ValidationType.STATIC, "Short Name");

    // Assert
    assertTrue(actualPassResult.failures().isEmpty());
    assertTrue(actualPassResult.ok());
  }

  /**
   * Method under test: {@link ValidationResult#forContext(ValidationContext)}
   */
  @Test
  void testForContext() {
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
   * Method under test: {@link ValidationResult#forContext(ValidationContext)}
   */
  @Test
  void testForContext2() {
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
   * Method under test: {@link ValidationResult#ok()}
   */
  @Test
  void testOk() {
    // Arrange, Act and Assert
    assertTrue(ValidationResult.pass(ValidationType.STATIC, "Short Name").ok());
  }

  /**
   * Method under test: {@link ValidationResult#ok()}
   */
  @Test
  void testOk2() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(Any.getDescriptor()));

    // Act
    boolean actualOkResult = ValidationResult.forContext(ctx).ok();

    // Assert
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
    assertTrue(actualOkResult);
  }

  /**
   * Method under test: {@link ValidationResult#ok()}
   */
  @Test
  void testOk3() {
    // Arrange
    ArrayList<ValidationFailure> validationFailureList = new ArrayList<>();
    validationFailureList.add(new ValidationFailure(new ValidationLocation(
        new ValidationLocation(mock(ValidationLocation.class), "Target", null, null, "Field Name"), "Target", null,
        "Field Name"), "Not all who wander are lost"));
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(validationFailureList);
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(Any.getDescriptor()));

    // Act
    boolean actualOkResult = ValidationResult.forContext(ctx).ok();

    // Assert
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
    assertFalse(actualOkResult);
  }

  /**
   * Method under test: {@link ValidationResult#failures()}
   */
  @Test
  void testFailures() {
    // Arrange, Act and Assert
    assertTrue(ValidationResult.pass(ValidationType.STATIC, "Short Name").failures().isEmpty());
  }

  /**
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  void testFailureMessage() {
    // Arrange, Act and Assert
    assertEquals("", ValidationResult.pass(ValidationType.STATIC, "Short Name").failureMessage());
  }

  /**
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  void testFailureMessage2() {
    // Arrange
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(new ArrayList<>());
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(Any.getDescriptor()));

    // Act
    String actualFailureMessageResult = ValidationResult.forContext(ctx).failureMessage();

    // Assert
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
    assertEquals("", actualFailureMessageResult);
  }

  /**
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  void testFailureMessage3() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);
    ValidationFailure validationFailure = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> validationFailureList = new ArrayList<>();
    validationFailureList.add(validationFailure);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(validationFailureList);
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(Any.getDescriptor()));

    // Act
    String actualFailureMessageResult = ValidationResult.forContext(ctx).failureMessage();

    // Assert
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
    verify(parent).isRoot();
    assertEquals("Field Name.Field Name: Not all who wander are lost", actualFailureMessageResult);
  }

  /**
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  void testFailureMessage4() {
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

    ArrayList<ValidationFailure> validationFailureList = new ArrayList<>();
    validationFailureList.add(validationFailure2);
    validationFailureList.add(validationFailure);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(validationFailureList);
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(Any.getDescriptor()));

    // Act
    String actualFailureMessageResult = ValidationResult.forContext(ctx).failureMessage();

    // Assert
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
    verify(parent2).isRoot();
    verify(parent).isRoot();
    assertEquals("There were multiple validation errors\n" + "Field Name.Field Name: Not all who wander are lost\n"
        + "Field Name.Field Name: Not all who wander are lost", actualFailureMessageResult);
  }

  /**
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  void testFailureMessage5() {
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

    ValidationLocation parent23 = mock(ValidationLocation.class);
    when(parent23.isRoot()).thenThrow(new EUnexpected());
    ValidationFailure validationFailure23 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent23, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> validationFailureList = new ArrayList<>();
    validationFailureList.add(validationFailure23);
    validationFailureList.add(validationFailure22);
    validationFailureList.add(validationFailure21);
    validationFailureList.add(validationFailure20);
    validationFailureList.add(validationFailure19);
    validationFailureList.add(validationFailure18);
    validationFailureList.add(validationFailure17);
    validationFailureList.add(validationFailure16);
    validationFailureList.add(validationFailure15);
    validationFailureList.add(validationFailure14);
    validationFailureList.add(validationFailure13);
    validationFailureList.add(validationFailure12);
    validationFailureList.add(validationFailure11);
    validationFailureList.add(validationFailure10);
    validationFailureList.add(validationFailure9);
    validationFailureList.add(validationFailure8);
    validationFailureList.add(validationFailure7);
    validationFailureList.add(validationFailure6);
    validationFailureList.add(validationFailure5);
    validationFailureList.add(validationFailure4);
    validationFailureList.add(validationFailure3);
    validationFailureList.add(validationFailure2);
    validationFailureList.add(validationFailure);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(validationFailureList);
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(Any.getDescriptor()));

    // Act and Assert
    assertThrows(EUnexpected.class, () -> ValidationResult.forContext(ctx).failureMessage());
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
    verify(parent23).isRoot();
  }

  /**
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  void testFailureMessage6() {
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
    when(parent22.isRoot()).thenReturn(false);
    when(parent22.elementPath()).thenReturn("Element Path");
    ValidationFailure validationFailure22 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent22, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> validationFailureList = new ArrayList<>();
    validationFailureList.add(validationFailure22);
    validationFailureList.add(validationFailure21);
    validationFailureList.add(validationFailure20);
    validationFailureList.add(validationFailure19);
    validationFailureList.add(validationFailure18);
    validationFailureList.add(validationFailure17);
    validationFailureList.add(validationFailure16);
    validationFailureList.add(validationFailure15);
    validationFailureList.add(validationFailure14);
    validationFailureList.add(validationFailure13);
    validationFailureList.add(validationFailure12);
    validationFailureList.add(validationFailure11);
    validationFailureList.add(validationFailure10);
    validationFailureList.add(validationFailure9);
    validationFailureList.add(validationFailure8);
    validationFailureList.add(validationFailure7);
    validationFailureList.add(validationFailure6);
    validationFailureList.add(validationFailure5);
    validationFailureList.add(validationFailure4);
    validationFailureList.add(validationFailure3);
    validationFailureList.add(validationFailure2);
    validationFailureList.add(validationFailure);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(validationFailureList);
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(Any.getDescriptor()));

    // Act
    String actualFailureMessageResult = ValidationResult.forContext(ctx).failureMessage();

    // Assert
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
    verify(parent22).elementPath();
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
        + "Field Name.Field Name: Not all who wander are lost\n" + "Field Name.Field Name: Not all who wander are lost",
        actualFailureMessageResult);
  }

  /**
   * Method under test: {@link ValidationResult#failureMessage()}
   */
  @Test
  void testFailureMessage7() {
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

    ArrayList<ValidationFailure> validationFailureList = new ArrayList<>();
    validationFailureList.add(new ValidationFailure(new ValidationLocation(null, "Target", null, "Field Name"),
        "Not all who wander are lost"));
    validationFailureList.add(validationFailure21);
    validationFailureList.add(validationFailure20);
    validationFailureList.add(validationFailure19);
    validationFailureList.add(validationFailure18);
    validationFailureList.add(validationFailure17);
    validationFailureList.add(validationFailure16);
    validationFailureList.add(validationFailure15);
    validationFailureList.add(validationFailure14);
    validationFailureList.add(validationFailure13);
    validationFailureList.add(validationFailure12);
    validationFailureList.add(validationFailure11);
    validationFailureList.add(validationFailure10);
    validationFailureList.add(validationFailure9);
    validationFailureList.add(validationFailure8);
    validationFailureList.add(validationFailure7);
    validationFailureList.add(validationFailure6);
    validationFailureList.add(validationFailure5);
    validationFailureList.add(validationFailure4);
    validationFailureList.add(validationFailure3);
    validationFailureList.add(validationFailure2);
    validationFailureList.add(validationFailure);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(validationFailureList);
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(Any.getDescriptor()));

    // Act
    String actualFailureMessageResult = ValidationResult.forContext(ctx).failureMessage();

    // Assert
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
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
        + "Field Name.Field Name: Not all who wander are lost\n" + "Field Name.Field Name: Not all who wander are lost",
        actualFailureMessageResult);
  }

  /**
   * Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  void testErrorDetails() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> ValidationResult.pass(ValidationType.UNDEFINED, "Short Name").errorDetails());
  }

  /**
   * Method under test: {@link ValidationResult#errorDetails()}
   */
  @Test
  void testErrorDetails2() {
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

    ValidationLocation parent23 = mock(ValidationLocation.class);
    when(parent23.isRoot()).thenThrow(new EUnexpected());
    ValidationFailure validationFailure23 = new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent23, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost");

    ArrayList<ValidationFailure> validationFailureList = new ArrayList<>();
    validationFailureList.add(validationFailure23);
    validationFailureList.add(validationFailure22);
    validationFailureList.add(validationFailure21);
    validationFailureList.add(validationFailure20);
    validationFailureList.add(validationFailure19);
    validationFailureList.add(validationFailure18);
    validationFailureList.add(validationFailure17);
    validationFailureList.add(validationFailure16);
    validationFailureList.add(validationFailure15);
    validationFailureList.add(validationFailure14);
    validationFailureList.add(validationFailure13);
    validationFailureList.add(validationFailure12);
    validationFailureList.add(validationFailure11);
    validationFailureList.add(validationFailure10);
    validationFailureList.add(validationFailure9);
    validationFailureList.add(validationFailure8);
    validationFailureList.add(validationFailure7);
    validationFailureList.add(validationFailure6);
    validationFailureList.add(validationFailure5);
    validationFailureList.add(validationFailure4);
    validationFailureList.add(validationFailure3);
    validationFailureList.add(validationFailure2);
    validationFailureList.add(validationFailure);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.getErrors()).thenReturn(validationFailureList);
    when(ctx.validationType()).thenReturn(ValidationType.STATIC);
    when(ctx.key()).thenReturn(ValidationKey.forConsistency(Any.getDescriptor()));

    // Act and Assert
    assertThrows(EUnexpected.class, () -> ValidationResult.forContext(ctx).errorDetails());
    verify(ctx).getErrors();
    verify(ctx).key();
    verify(ctx).validationType();
    verify(parent23).isRoot();
  }

  /**
   * Method under test:
   * {@link ValidationResult#ValidationResult(ValidationType, String, List)}
   */
  @Test
  void testNewValidationResult() {
    // Arrange and Act
    ValidationResult actualValidationResult = new ValidationResult(ValidationType.STATIC, "Short Name",
        new ArrayList<>());

    // Assert
    assertTrue(actualValidationResult.failures().isEmpty());
    assertTrue(actualValidationResult.ok());
  }

  /**
   * Method under test:
   * {@link ValidationResult#ValidationResult(ValidationType, String, List)}
   */
  @Test
  void testNewValidationResult2() {
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
   * Method under test:
   * {@link ValidationResult#ValidationResult(ValidationType, String, List)}
   */
  @Test
  void testNewValidationResult3() {
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
}
