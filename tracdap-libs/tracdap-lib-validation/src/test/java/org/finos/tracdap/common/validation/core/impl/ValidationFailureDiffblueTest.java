package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ValidationFailureDiffblueTest {
  /**
   * Method under test: {@link ValidationFailure#locationAndMessage()}
   */
  @Test
  void testLocationAndMessage() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);

    // Act
    String actualLocationAndMessageResult = (new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost")).locationAndMessage();

    // Assert
    verify(parent).isRoot();
    assertEquals("Field Name.Field Name: Not all who wander are lost", actualLocationAndMessageResult);
  }

  /**
   * Method under test: {@link ValidationFailure#locationAndMessage()}
   */
  @Test
  void testLocationAndMessage2() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(false);
    when(parent.elementPath()).thenReturn("Element Path");

    // Act
    String actualLocationAndMessageResult = (new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost")).locationAndMessage();

    // Assert
    verify(parent).elementPath();
    verify(parent).isRoot();
    assertEquals("Element Path.Field Name.Field Name: Not all who wander are lost", actualLocationAndMessageResult);
  }

  /**
   * Method under test: {@link ValidationFailure#locationAndMessage()}
   */
  @Test
  void testLocationAndMessage3() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        (new ValidationFailure(new ValidationLocation(null, "Target", null, "Field Name"),
            "Not all who wander are lost")).locationAndMessage());
  }

  /**
   * Method under test: {@link ValidationFailure#location()}
   */
  @Test
  void testLocation() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(true);

    // Act
    String actualLocationResult = (new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost")).location();

    // Assert
    verify(parent).isRoot();
    assertEquals("Field Name.Field Name", actualLocationResult);
  }

  /**
   * Method under test: {@link ValidationFailure#location()}
   */
  @Test
  void testLocation2() {
    // Arrange
    ValidationLocation parent = mock(ValidationLocation.class);
    when(parent.isRoot()).thenReturn(false);
    when(parent.elementPath()).thenReturn("Element Path");

    // Act
    String actualLocationResult = (new ValidationFailure(
        new ValidationLocation(new ValidationLocation(parent, "Target", null, null, "Field Name"), "Target", null,
            "Field Name"),
        "Not all who wander are lost")).location();

    // Assert
    verify(parent).elementPath();
    verify(parent).isRoot();
    assertEquals("Element Path.Field Name.Field Name", actualLocationResult);
  }

  /**
   * Method under test: {@link ValidationFailure#location()}
   */
  @Test
  void testLocation3() {
    // Arrange, Act and Assert
    assertEquals("", (new ValidationFailure(new ValidationLocation(null, "Target", null, "Field Name"),
        "Not all who wander are lost")).location());
  }

  /**
   * Method under test: {@link ValidationFailure#fieldName()}
   */
  @Test
  void testFieldName() {
    // Arrange, Act and Assert
    assertEquals("Field Name",
        (new ValidationFailure(new ValidationLocation(
            new ValidationLocation(mock(ValidationLocation.class), "Target", null, null, "Field Name"), "Target", null,
            "Field Name"), "Not all who wander are lost")).fieldName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationFailure#ValidationFailure(ValidationLocation, String)}
   *   <li>{@link ValidationFailure#message()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        (new ValidationFailure(new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"),
            "Target", null, "Field Name"), "Not all who wander are lost")).message());
  }
}
