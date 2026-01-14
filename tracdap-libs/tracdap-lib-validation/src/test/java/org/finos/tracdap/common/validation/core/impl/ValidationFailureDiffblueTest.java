package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationFailureDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationFailure#ValidationFailure(ValidationLocation, String)}
   *   <li>{@link ValidationFailure#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidationFailure.<init>(ValidationLocation, String)",
    "String ValidationFailure.message()"
  })
  void testGettersAndSetters() {
    // Arrange
    ValidationLocation parent = new ValidationLocation(null, "Target", null, null, "Field Name");
    ValidationLocation location = new ValidationLocation(parent, "Target", null, "Field Name");

    // Act and Assert
    assertEquals(
        "Not all who wander are lost",
        new ValidationFailure(location, "Not all who wander are lost").message());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationFailure#ValidationFailure(ValidationLocation, String)}
   *   <li>{@link ValidationFailure#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidationFailure.<init>(ValidationLocation, String)",
    "String ValidationFailure.message()"
  })
  void testGettersAndSetters2() {
    // Arrange
    ValidationLocation parent = new ValidationLocation(null, "Target", null, null, "Field Name");
    ValidationLocation location = new ValidationLocation(parent, "Target", null, "Field Name");

    // Act and Assert
    assertEquals(
        "Not all who wander are lost",
        new ValidationFailure(location, "Not all who wander are lost").message());
  }

  /**
   * Test {@link ValidationFailure#fieldName()}.
   *
   * <ul>
   *   <li>Then return {@code Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationFailure#fieldName()}
   */
  @Test
  @DisplayName("Test fieldName(); then return 'Field Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ValidationFailure.fieldName()"})
  void testFieldName_thenReturnFieldName() {
    // Arrange
    ValidationLocation parent =
        new ValidationLocation(
            mock(ValidationLocation.class),
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");
    ValidationLocation location =
        new ValidationLocation(parent, "Target", mock(FieldDescriptor.class), "Field Name");

    // Act and Assert
    assertEquals(
        "Field Name", new ValidationFailure(location, "Not all who wander are lost").fieldName());
  }

  /**
   * Test {@link ValidationFailure#fieldName()}.
   *
   * <ul>
   *   <li>Then return {@code Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationFailure#fieldName()}
   */
  @Test
  @DisplayName("Test fieldName(); then return 'Field Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ValidationFailure.fieldName()"})
  void testFieldName_thenReturnFieldName2() {
    // Arrange
    ValidationLocation parent =
        new ValidationLocation(
            mock(ValidationLocation.class),
            "Target",
            mock(OneofDescriptor.class),
            mock(FieldDescriptor.class),
            "Field Name");
    ValidationLocation location =
        new ValidationLocation(parent, "Target", mock(FieldDescriptor.class), "Field Name");

    // Act and Assert
    assertEquals(
        "Field Name", new ValidationFailure(location, "Not all who wander are lost").fieldName());
  }
}
