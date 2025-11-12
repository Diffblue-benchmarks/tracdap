package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * Test {@link ValidationFailure#locationAndMessage()}.
   *
   * <p>Method under test: {@link ValidationFailure#locationAndMessage()}
   */
  @Test
  @DisplayName("Test locationAndMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ValidationFailure.locationAndMessage()"})
  void testLocationAndMessage() {
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

    // Act
    String actualLocationAndMessageResult =
        new ValidationFailure(location, "Not all who wander are lost").locationAndMessage();

    // Assert
    verify(field).isRepeated();
    verify(parent).isRoot();
    assertEquals(
        "Field Name.Field Name: Not all who wander are lost", actualLocationAndMessageResult);
  }

  /**
   * Test {@link ValidationFailure#location()}.
   *
   * <p>Method under test: {@link ValidationFailure#location()}
   */
  @Test
  @DisplayName("Test location()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ValidationFailure.location()"})
  void testLocation() {
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

    // Act
    String actualLocationResult =
        new ValidationFailure(location, "Not all who wander are lost").location();

    // Assert
    verify(field).isRepeated();
    verify(parent).isRoot();
    assertEquals("Field Name.Field Name", actualLocationResult);
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
}
