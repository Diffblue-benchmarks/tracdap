package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationFailureDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationFailure#ValidationFailure(ValidationLocation, String)}
   *   <li>{@link ValidationFailure#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationFailure.<init>(ValidationLocation, String)", "String ValidationFailure.message()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        (new ValidationFailure(new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"),
            "Target", null, "Field Name"), "Not all who wander are lost")).message());
  }

  /**
   * Test {@link ValidationFailure#locationAndMessage()}.
   * <p>
   * Method under test: {@link ValidationFailure#locationAndMessage()}
   */
  @Test
  @DisplayName("Test locationAndMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationFailure.locationAndMessage()"})
  void testLocationAndMessage() {
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
   * Test {@link ValidationFailure#locationAndMessage()}.
   * <ul>
   *   <li>Then return {@code Field Name.Field Name: Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationFailure#locationAndMessage()}
   */
  @Test
  @DisplayName("Test locationAndMessage(); then return 'Field Name.Field Name: Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationFailure.locationAndMessage()"})
  void testLocationAndMessage_thenReturnFieldNameFieldNameNotAllWhoWanderAreLost() {
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
   * Test {@link ValidationFailure#locationAndMessage()}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationFailure#locationAndMessage()}
   */
  @Test
  @DisplayName("Test locationAndMessage(); then return 'Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationFailure.locationAndMessage()"})
  void testLocationAndMessage_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals("Not all who wander are lost",
        (new ValidationFailure(new ValidationLocation(null, "Target", null, "Field Name"),
            "Not all who wander are lost")).locationAndMessage());
  }

  /**
   * Test {@link ValidationFailure#location()}.
   * <ul>
   *   <li>Then return {@code Element Path.Field Name.Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationFailure#location()}
   */
  @Test
  @DisplayName("Test location(); then return 'Element Path.Field Name.Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationFailure.location()"})
  void testLocation_thenReturnElementPathFieldNameFieldName() {
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
   * Test {@link ValidationFailure#location()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationFailure#location()}
   */
  @Test
  @DisplayName("Test location(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationFailure.location()"})
  void testLocation_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new ValidationFailure(new ValidationLocation(null, "Target", null, "Field Name"),
        "Not all who wander are lost")).location());
  }

  /**
   * Test {@link ValidationFailure#location()}.
   * <ul>
   *   <li>Then return {@code Field Name.Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationFailure#location()}
   */
  @Test
  @DisplayName("Test location(); then return 'Field Name.Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationFailure.location()"})
  void testLocation_thenReturnFieldNameFieldName() {
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
   * Test {@link ValidationFailure#fieldName()}.
   * <ul>
   *   <li>Then return {@code Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationFailure#fieldName()}
   */
  @Test
  @DisplayName("Test fieldName(); then return 'Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationFailure.fieldName()"})
  void testFieldName_thenReturnFieldName() {
    // Arrange, Act and Assert
    assertEquals("Field Name",
        (new ValidationFailure(new ValidationLocation(
            new ValidationLocation(mock(ValidationLocation.class), "Target", null, null, "Field Name"), "Target", null,
            "Field Name"), "Not all who wander are lost")).fieldName());
  }
}
