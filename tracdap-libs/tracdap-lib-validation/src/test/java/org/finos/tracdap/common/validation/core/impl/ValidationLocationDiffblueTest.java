package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSetDefaults;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationLocationDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object, FieldDescriptor, String)}
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object, Descriptors.OneofDescriptor, FieldDescriptor, String)}
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationLocation.<init>(ValidationLocation, Object, FieldDescriptor, String)",
      "void ValidationLocation.<init>(ValidationLocation, Object, MethodDescriptor, Descriptors.OneofDescriptor, FieldDescriptor, String)",
      "void ValidationLocation.<init>(ValidationLocation, Object, Descriptors.OneofDescriptor, FieldDescriptor, String)",
      "void ValidationLocation.fail()", "boolean ValidationLocation.failed()",
      "FieldDescriptor ValidationLocation.field()", "String ValidationLocation.fieldName()",
      "MethodDescriptor ValidationLocation.method()", "Descriptors.OneofDescriptor ValidationLocation.oneOf()",
      "ValidationLocation ValidationLocation.parent()", "void ValidationLocation.skip()",
      "boolean ValidationLocation.skipped()", "Object ValidationLocation.target()"})
  void testGettersAndSetters() {
    // Arrange
    ValidationLocation parent = new ValidationLocation(null, "Target", null, null, "Field Name");

    // Act
    ValidationLocation actualValidationLocation = new ValidationLocation(parent, "Target", null, "Field Name");
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object, MethodDescriptor, Descriptors.OneofDescriptor, FieldDescriptor, String)}
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object, Descriptors.OneofDescriptor, FieldDescriptor, String)}
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object, FieldDescriptor, String)}
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationLocation.<init>(ValidationLocation, Object, FieldDescriptor, String)",
      "void ValidationLocation.<init>(ValidationLocation, Object, MethodDescriptor, Descriptors.OneofDescriptor, FieldDescriptor, String)",
      "void ValidationLocation.<init>(ValidationLocation, Object, Descriptors.OneofDescriptor, FieldDescriptor, String)",
      "void ValidationLocation.fail()", "boolean ValidationLocation.failed()",
      "FieldDescriptor ValidationLocation.field()", "String ValidationLocation.fieldName()",
      "MethodDescriptor ValidationLocation.method()", "Descriptors.OneofDescriptor ValidationLocation.oneOf()",
      "ValidationLocation ValidationLocation.parent()", "void ValidationLocation.skip()",
      "boolean ValidationLocation.skipped()", "Object ValidationLocation.target()"})
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object, Descriptors.OneofDescriptor, FieldDescriptor, String)}
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object, MethodDescriptor, Descriptors.OneofDescriptor, FieldDescriptor, String)}
   *   <li>{@link ValidationLocation#ValidationLocation(ValidationLocation, Object, FieldDescriptor, String)}
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationLocation.<init>(ValidationLocation, Object, FieldDescriptor, String)",
      "void ValidationLocation.<init>(ValidationLocation, Object, MethodDescriptor, Descriptors.OneofDescriptor, FieldDescriptor, String)",
      "void ValidationLocation.<init>(ValidationLocation, Object, Descriptors.OneofDescriptor, FieldDescriptor, String)",
      "void ValidationLocation.fail()", "boolean ValidationLocation.failed()",
      "FieldDescriptor ValidationLocation.field()", "String ValidationLocation.fieldName()",
      "MethodDescriptor ValidationLocation.method()", "Descriptors.OneofDescriptor ValidationLocation.oneOf()",
      "ValidationLocation ValidationLocation.parent()", "void ValidationLocation.skip()",
      "boolean ValidationLocation.skipped()", "Object ValidationLocation.target()"})
  void testGettersAndSetters3() {
    // Arrange
    ValidationLocation parent = new ValidationLocation(
        new ValidationLocation(null, "Target", null, null, null, "Field Name"), "Target", null, "Field Name");

    // Act
    ValidationLocation actualValidationLocation = new ValidationLocation(parent, "Target", null, null, "Field Name");
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
   * Test {@link ValidationLocation#isRoot()}.
   * <p>
   * Method under test: {@link ValidationLocation#isRoot()}
   */
  @Test
  @DisplayName("Test isRoot()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationLocation.isRoot()"})
  void testIsRoot() {
    // Arrange, Act and Assert
    assertFalse((new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target",
        null, "Field Name")).isRoot());
  }

  /**
   * Test {@link ValidationLocation#elementPath()}.
   * <ul>
   *   <li>Then return {@code Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationLocation#elementPath()}
   */
  @Test
  @DisplayName("Test elementPath(); then return 'Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationLocation.elementPath()"})
  void testElementPath_thenReturnFieldName() {
    // Arrange, Act and Assert
    assertEquals("Field Name", (new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"),
        "Target", null, "Field Name")).elementPath());
  }

  /**
   * Test {@link ValidationLocation#elementPath()}.
   * <ul>
   *   <li>Then return {@code Field Name.Field Name.Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationLocation#elementPath()}
   */
  @Test
  @DisplayName("Test elementPath(); then return 'Field Name.Field Name.Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ValidationLocation.elementPath()"})
  void testElementPath_thenReturnFieldNameFieldNameFieldName() {
    // Arrange, Act and Assert
    assertEquals("Field Name.Field Name.Field Name",
        (new ValidationLocation(new ValidationLocation(
            new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target", null,
                "Field Name"),
            "Target", null, null, "Field Name"), "Target", null, "Field Name")).elementPath());
  }

  /**
   * Test {@link ValidationLocation#isOneOf()}.
   * <p>
   * Method under test: {@link ValidationLocation#isOneOf()}
   */
  @Test
  @DisplayName("Test isOneOf()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationLocation.isOneOf()"})
  void testIsOneOf() {
    // Arrange, Act and Assert
    assertFalse((new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target",
        null, "Field Name")).isOneOf());
  }

  /**
   * Test {@link ValidationLocation#isRepeated()}.
   * <p>
   * Method under test: {@link ValidationLocation#isRepeated()}
   */
  @Test
  @DisplayName("Test isRepeated()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationLocation.isRepeated()"})
  void testIsRepeated() {
    // Arrange, Act and Assert
    assertFalse((new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target",
        null, "Field Name")).isRepeated());
  }

  /**
   * Test {@link ValidationLocation#done()}.
   * <p>
   * Method under test: {@link ValidationLocation#done()}
   */
  @Test
  @DisplayName("Test done()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidationLocation.done()"})
  void testDone() {
    // Arrange, Act and Assert
    assertFalse((new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target",
        null, "Field Name")).done());
  }

  /**
   * Test {@link ValidationLocation#msg()}.
   * <ul>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationLocation#msg()}
   */
  @Test
  @DisplayName("Test msg(); then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"com.google.protobuf.Message ValidationLocation.msg()"})
  void testMsg_thenReturnDefaultInstance() {
    // Arrange
    ValidationLocation parent = new ValidationLocation(null, "Target", null, null, "Field Name");

    FeatureSetDefaults defaultInstance = FeatureSetDefaults.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, (new ValidationLocation(parent, defaultInstance, null, "Field Name")).msg());
  }

  /**
   * Test {@link ValidationLocation#msg()}.
   * <ul>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationLocation#msg()}
   */
  @Test
  @DisplayName("Test msg(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"com.google.protobuf.Message ValidationLocation.msg()"})
  void testMsg_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class,
        () -> (new ValidationLocation(new ValidationLocation(null, "Target", null, null, "Field Name"), "Target", null,
            "Field Name")).msg());
  }
}
