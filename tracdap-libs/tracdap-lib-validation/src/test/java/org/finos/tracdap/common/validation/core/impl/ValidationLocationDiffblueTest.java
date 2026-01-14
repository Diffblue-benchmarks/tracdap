package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationLocationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object, FieldDescriptor,
   *       String)}
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object,
   *       Descriptors.OneofDescriptor, FieldDescriptor, String)}
   *   <li>{@link ValidationLocation#fail()}
   *   <li>{@link ValidationLocation#skip()}
   *   <li>{@link ValidationLocation#failed()}
   *   <li>{@link ValidationLocation#field()}
   *   <li>{@link ValidationLocation#fieldName()}
   *   <li>{@link ValidationLocation#method()}
   *   <li>{@link ValidationLocation#oneOf()}
   *   <li>{@link ValidationLocation#parent()}
   *   <li>{@link ValidationLocation#skipped()}
   *   <li>{@link ValidationLocation#target()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidationLocation.<init>(ValidationLocation, Object, FieldDescriptor, String)",
    "void ValidationLocation.<init>(ValidationLocation, Object, MethodDescriptor, Descriptors.OneofDescriptor, FieldDescriptor, String)",
    "void ValidationLocation.<init>(ValidationLocation, Object, Descriptors.OneofDescriptor, FieldDescriptor, String)",
    "void ValidationLocation.fail()",
    "boolean ValidationLocation.failed()",
    "FieldDescriptor ValidationLocation.field()",
    "String ValidationLocation.fieldName()",
    "MethodDescriptor ValidationLocation.method()",
    "Descriptors.OneofDescriptor ValidationLocation.oneOf()",
    "ValidationLocation ValidationLocation.parent()",
    "void ValidationLocation.skip()",
    "boolean ValidationLocation.skipped()",
    "Object ValidationLocation.target()"
  })
  void testGettersAndSetters() {
    // Arrange
    ValidationLocation parent = new ValidationLocation(null, "Target", null, null, "Field Name");

    // Act
    ValidationLocation actualValidationLocation =
        new ValidationLocation(parent, "Target", null, "Field Name");
    actualValidationLocation.fail();
    actualValidationLocation.skip();
    boolean actualFailedResult = actualValidationLocation.failed();
    FieldDescriptor actualFieldResult = actualValidationLocation.field();
    String actualFieldNameResult = actualValidationLocation.fieldName();
    MethodDescriptor actualMethodResult = actualValidationLocation.method();
    OneofDescriptor actualOneOfResult = actualValidationLocation.oneOf();
    ValidationLocation actualParentResult = actualValidationLocation.parent();
    boolean actualSkippedResult = actualValidationLocation.skipped();

    // Assert
    assertEquals("Field Name", actualFieldNameResult);
    assertEquals("Target", actualValidationLocation.target());
    assertNull(actualFieldResult);
    assertNull(actualMethodResult);
    assertNull(actualOneOfResult);
    assertTrue(actualFailedResult);
    assertTrue(actualSkippedResult);
    assertSame(parent, actualParentResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object,
   *       MethodDescriptor, Descriptors.OneofDescriptor, FieldDescriptor, String)}
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object,
   *       Descriptors.OneofDescriptor, FieldDescriptor, String)}
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object, FieldDescriptor,
   *       String)}
   *   <li>{@link ValidationLocation#fail()}
   *   <li>{@link ValidationLocation#skip()}
   *   <li>{@link ValidationLocation#failed()}
   *   <li>{@link ValidationLocation#field()}
   *   <li>{@link ValidationLocation#fieldName()}
   *   <li>{@link ValidationLocation#method()}
   *   <li>{@link ValidationLocation#oneOf()}
   *   <li>{@link ValidationLocation#parent()}
   *   <li>{@link ValidationLocation#skipped()}
   *   <li>{@link ValidationLocation#target()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidationLocation.<init>(ValidationLocation, Object, FieldDescriptor, String)",
    "void ValidationLocation.<init>(ValidationLocation, Object, MethodDescriptor, Descriptors.OneofDescriptor, FieldDescriptor, String)",
    "void ValidationLocation.<init>(ValidationLocation, Object, Descriptors.OneofDescriptor, FieldDescriptor, String)",
    "void ValidationLocation.fail()",
    "boolean ValidationLocation.failed()",
    "FieldDescriptor ValidationLocation.field()",
    "String ValidationLocation.fieldName()",
    "MethodDescriptor ValidationLocation.method()",
    "Descriptors.OneofDescriptor ValidationLocation.oneOf()",
    "ValidationLocation ValidationLocation.parent()",
    "void ValidationLocation.skip()",
    "boolean ValidationLocation.skipped()",
    "Object ValidationLocation.target()"
  })
  void testGettersAndSetters2() {
    // Arrange
    ValidationLocation parent = new ValidationLocation(null, "Target", null, null, "Field Name");
    ValidationLocation parent2 = new ValidationLocation(parent, "Target", null, "Field Name");

    // Act
    ValidationLocation actualValidationLocation =
        new ValidationLocation(parent2, "Target", null, null, null, "Field Name");
    actualValidationLocation.fail();
    actualValidationLocation.skip();
    boolean actualFailedResult = actualValidationLocation.failed();
    FieldDescriptor actualFieldResult = actualValidationLocation.field();
    String actualFieldNameResult = actualValidationLocation.fieldName();
    MethodDescriptor actualMethodResult = actualValidationLocation.method();
    OneofDescriptor actualOneOfResult = actualValidationLocation.oneOf();
    ValidationLocation actualParentResult = actualValidationLocation.parent();
    boolean actualSkippedResult = actualValidationLocation.skipped();

    // Assert
    assertEquals("Field Name", actualFieldNameResult);
    assertEquals("Target", actualValidationLocation.target());
    assertNull(actualFieldResult);
    assertNull(actualMethodResult);
    assertNull(actualOneOfResult);
    assertTrue(actualFailedResult);
    assertTrue(actualSkippedResult);
    assertSame(parent2, actualParentResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object,
   *       Descriptors.OneofDescriptor, FieldDescriptor, String)}
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object,
   *       MethodDescriptor, Descriptors.OneofDescriptor, FieldDescriptor, String)}
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object, FieldDescriptor,
   *       String)}
   *   <li>{@link ValidationLocation#fail()}
   *   <li>{@link ValidationLocation#skip()}
   *   <li>{@link ValidationLocation#failed()}
   *   <li>{@link ValidationLocation#field()}
   *   <li>{@link ValidationLocation#fieldName()}
   *   <li>{@link ValidationLocation#method()}
   *   <li>{@link ValidationLocation#oneOf()}
   *   <li>{@link ValidationLocation#parent()}
   *   <li>{@link ValidationLocation#skipped()}
   *   <li>{@link ValidationLocation#target()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidationLocation.<init>(ValidationLocation, Object, FieldDescriptor, String)",
    "void ValidationLocation.<init>(ValidationLocation, Object, MethodDescriptor, Descriptors.OneofDescriptor, FieldDescriptor, String)",
    "void ValidationLocation.<init>(ValidationLocation, Object, Descriptors.OneofDescriptor, FieldDescriptor, String)",
    "void ValidationLocation.fail()",
    "boolean ValidationLocation.failed()",
    "FieldDescriptor ValidationLocation.field()",
    "String ValidationLocation.fieldName()",
    "MethodDescriptor ValidationLocation.method()",
    "Descriptors.OneofDescriptor ValidationLocation.oneOf()",
    "ValidationLocation ValidationLocation.parent()",
    "void ValidationLocation.skip()",
    "boolean ValidationLocation.skipped()",
    "Object ValidationLocation.target()"
  })
  void testGettersAndSetters3() {
    // Arrange
    ValidationLocation parent =
        new ValidationLocation(null, "Target", null, null, null, "Field Name");
    ValidationLocation parent2 = new ValidationLocation(parent, "Target", null, "Field Name");

    // Act
    ValidationLocation actualValidationLocation =
        new ValidationLocation(parent2, "Target", null, null, "Field Name");
    actualValidationLocation.fail();
    actualValidationLocation.skip();
    boolean actualFailedResult = actualValidationLocation.failed();
    FieldDescriptor actualFieldResult = actualValidationLocation.field();
    String actualFieldNameResult = actualValidationLocation.fieldName();
    MethodDescriptor actualMethodResult = actualValidationLocation.method();
    OneofDescriptor actualOneOfResult = actualValidationLocation.oneOf();
    ValidationLocation actualParentResult = actualValidationLocation.parent();
    boolean actualSkippedResult = actualValidationLocation.skipped();

    // Assert
    assertEquals("Field Name", actualFieldNameResult);
    assertEquals("Target", actualValidationLocation.target());
    assertNull(actualFieldResult);
    assertNull(actualMethodResult);
    assertNull(actualOneOfResult);
    assertTrue(actualFailedResult);
    assertTrue(actualSkippedResult);
    assertSame(parent2, actualParentResult);
  }

  /**
   * Test {@link ValidationLocation#done()}.
   *
   * <p>Method under test: {@link ValidationLocation#done()}
   */
  @Test
  @DisplayName("Test done()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationLocation.done()"})
  void testDone() {
    // Arrange
    ValidationLocation parent =
        new ValidationLocation(
            null, "Target", mock(OneofDescriptor.class), mock(FieldDescriptor.class), "Field Name");
    ValidationLocation validationLocation =
        new ValidationLocation(parent, "Target", mock(FieldDescriptor.class), "Field Name");

    // Act and Assert
    assertFalse(validationLocation.done());
  }
}
