package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.Test;

class ValidationLocationDiffblueTest {
  /**
   * Method under test: {@link ValidationLocation#isRoot()}
   */
  @Test
  void testIsRoot() {
    // Arrange, Act and Assert
    assertFalse((new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target",
        null, "Field Name")).isRoot());
  }

  /**
   * Method under test: {@link ValidationLocation#elementPath()}
   */
  @Test
  void testElementPath() {
    // Arrange, Act and Assert
    assertEquals("Field Name", (new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"),
        "Target", null, "Field Name")).elementPath());
    assertEquals("Field Name.Field Name.Field Name",
        (new ValidationLocation(new ValidationLocation(
            new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target", null,
                "Field Name"),
            "Target", null, null, "Field Name"), "Target", null, "Field Name")).elementPath());
  }

  /**
   * Method under test: {@link ValidationLocation#isOneOf()}
   */
  @Test
  void testIsOneOf() {
    // Arrange, Act and Assert
    assertFalse((new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target",
        null, "Field Name")).isOneOf());
  }

  /**
   * Method under test: {@link ValidationLocation#isRepeated()}
   */
  @Test
  void testIsRepeated() {
    // Arrange, Act and Assert
    assertFalse((new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target",
        null, "Field Name")).isRepeated());
  }

  /**
   * Method under test: {@link ValidationLocation#done()}
   */
  @Test
  void testDone() {
    // Arrange, Act and Assert
    assertFalse((new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target",
        null, "Field Name")).done());
  }

  /**
   * Method under test: {@link ValidationLocation#msg()}
   */
  @Test
  void testMsg() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class,
        () -> (new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target", null,
            "Field Name")).msg());
  }

  /**
   * Method under test: {@link ValidationLocation#msg()}
   */
  @Test
  void testMsg2() {
    // Arrange
    ValidationLocation parent = new ValidationLocation(null, "Target", null, null, "Field Name");

    DescriptorProtos.FeatureSetDefaults defaultInstance = DescriptorProtos.FeatureSetDefaults.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, (new ValidationLocation(parent, defaultInstance, null, "Field Name")).msg());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ValidationLocation#ValidationLocation(ValidationLocation, Object, Descriptors.FieldDescriptor, String)}
   *   <li>
   * {@link ValidationLocation#ValidationLocation(ValidationLocation, Object, Descriptors.OneofDescriptor, Descriptors.FieldDescriptor, String)}
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
  void testGettersAndSetters() {
    // Arrange
    ValidationLocation parent = new ValidationLocation(null, "Target", null, null, "Field Name");

    // Act
    ValidationLocation actualValidationLocation = new ValidationLocation(parent, "Target", null, "Field Name");
    actualValidationLocation.fail();
    actualValidationLocation.skip();
    boolean actualFailedResult = actualValidationLocation.failed();
    actualValidationLocation.field();
    String actualFieldNameResult = actualValidationLocation.fieldName();
    actualValidationLocation.method();
    actualValidationLocation.oneOf();
    ValidationLocation actualParentResult = actualValidationLocation.parent();
    boolean actualSkippedResult = actualValidationLocation.skipped();

    // Assert that nothing has changed
    assertEquals("Field Name", actualFieldNameResult);
    assertEquals("Target", actualValidationLocation.target());
    assertTrue(actualFailedResult);
    assertTrue(actualSkippedResult);
    assertSame(parent, actualParentResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ValidationLocation#ValidationLocation(ValidationLocation, Object, Descriptors.MethodDescriptor, Descriptors.OneofDescriptor, Descriptors.FieldDescriptor, String)}
   *   <li>
   * {@link ValidationLocation#ValidationLocation(ValidationLocation, Object, Descriptors.OneofDescriptor, Descriptors.FieldDescriptor, String)}
   *   <li>
   * {@link ValidationLocation#ValidationLocation(ValidationLocation, Object, Descriptors.FieldDescriptor, String)}
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
  void testGettersAndSetters2() {
    // Arrange
    ValidationLocation parent = new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"),
        "Target", null, "Field Name");

    // Act
    ValidationLocation actualValidationLocation = new ValidationLocation(parent, "Target", null, null, null,
        "Field Name");
    actualValidationLocation.fail();
    actualValidationLocation.skip();
    boolean actualFailedResult = actualValidationLocation.failed();
    actualValidationLocation.field();
    String actualFieldNameResult = actualValidationLocation.fieldName();
    actualValidationLocation.method();
    actualValidationLocation.oneOf();
    ValidationLocation actualParentResult = actualValidationLocation.parent();
    boolean actualSkippedResult = actualValidationLocation.skipped();

    // Assert that nothing has changed
    assertEquals("Field Name", actualFieldNameResult);
    assertEquals("Target", actualValidationLocation.target());
    assertTrue(actualFailedResult);
    assertTrue(actualSkippedResult);
    assertSame(parent, actualParentResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ValidationLocation#ValidationLocation(ValidationLocation, Object, Descriptors.OneofDescriptor, Descriptors.FieldDescriptor, String)}
   *   <li>
   * {@link ValidationLocation#ValidationLocation(ValidationLocation, Object, Descriptors.MethodDescriptor, Descriptors.OneofDescriptor, Descriptors.FieldDescriptor, String)}
   *   <li>
   * {@link ValidationLocation#ValidationLocation(ValidationLocation, Object, Descriptors.FieldDescriptor, String)}
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
  void testGettersAndSetters3() {
    // Arrange
    ValidationLocation parent = new ValidationLocation(
        new ValidationLocation(null, "Target", null, null, null, "Field Name"), "Target", null, "Field Name");

    // Act
    ValidationLocation actualValidationLocation = new ValidationLocation(parent, "Target", null, null, "Field Name");
    actualValidationLocation.fail();
    actualValidationLocation.skip();
    boolean actualFailedResult = actualValidationLocation.failed();
    actualValidationLocation.field();
    String actualFieldNameResult = actualValidationLocation.fieldName();
    actualValidationLocation.method();
    actualValidationLocation.oneOf();
    ValidationLocation actualParentResult = actualValidationLocation.parent();
    boolean actualSkippedResult = actualValidationLocation.skipped();

    // Assert that nothing has changed
    assertEquals("Field Name", actualFieldNameResult);
    assertEquals("Target", actualValidationLocation.target());
    assertTrue(actualFailedResult);
    assertTrue(actualSkippedResult);
    assertSame(parent, actualParentResult);
  }
}
