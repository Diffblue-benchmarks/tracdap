package org.finos.tracdap.common.validation.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Message;
import java.util.HashMap;
import org.finos.tracdap.common.metadata.MetadataBundle;
import org.finos.tracdap.common.validation.core.impl.ValidationContextImpl;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationContextDiffblueTest {
  /**
   * Test {@link ValidationContext#forMethod(Message, MethodDescriptor)}.
   * <p>
   * Method under test: {@link ValidationContext#forMethod(Message, MethodDescriptor)}
   */
  @Test
  @DisplayName("Test forMethod(Message, MethodDescriptor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext ValidationContext.forMethod(Message, MethodDescriptor)"})
  void testForMethod() {
    // Arrange
    Advice msg = Advice.getDefaultInstance();

    // Act
    ValidationContext actualForMethodResult = ValidationContext.forMethod(msg, null);

    // Assert
    Object targetResult = actualForMethodResult.target();
    assertTrue(targetResult instanceof Advice);
    assertTrue(actualForMethodResult instanceof ValidationContextImpl);
    assertNull(actualForMethodResult.field());
    assertNull(actualForMethodResult.getMetadataBundle());
    assertNull(actualForMethodResult.prior());
    assertNull(actualForMethodResult.getResources());
    assertEquals(ValidationType.STATIC, actualForMethodResult.validationType());
    assertFalse(actualForMethodResult.isOneOf());
    assertTrue(actualForMethodResult.getErrors().isEmpty());
    assertSame(msg, targetResult);
    assertSame(actualForMethodResult, actualForMethodResult.skip());
  }

  /**
   * Test {@link ValidationContext#forMessage(Message)}.
   * <p>
   * Method under test: {@link ValidationContext#forMessage(Message)}
   */
  @Test
  @DisplayName("Test forMessage(Message)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext ValidationContext.forMessage(Message)"})
  void testForMessage() {
    // Arrange
    Advice msg = Advice.getDefaultInstance();

    // Act
    ValidationContext actualForMessageResult = ValidationContext.forMessage(msg);

    // Assert
    Object targetResult = actualForMessageResult.target();
    assertTrue(targetResult instanceof Advice);
    assertTrue(actualForMessageResult instanceof ValidationContextImpl);
    assertNull(actualForMessageResult.field());
    assertNull(actualForMessageResult.getMetadataBundle());
    assertNull(actualForMessageResult.prior());
    assertNull(actualForMessageResult.getResources());
    assertEquals(ValidationType.STATIC, actualForMessageResult.validationType());
    assertFalse(actualForMessageResult.isOneOf());
    assertTrue(actualForMessageResult.getErrors().isEmpty());
    assertSame(msg, targetResult);
    assertSame(actualForMessageResult, actualForMessageResult.skip());
  }

  /**
   * Test {@link ValidationContext#forVersion(Message, Message)}.
   * <p>
   * Method under test: {@link ValidationContext#forVersion(Message, Message)}
   */
  @Test
  @DisplayName("Test forVersion(Message, Message)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext ValidationContext.forVersion(Message, Message)"})
  void testForVersion() {
    // Arrange
    Advice current = Advice.getDefaultInstance();
    Advice prior = Advice.getDefaultInstance();

    // Act
    ValidationContext actualForVersionResult = ValidationContext.forVersion(current, prior);

    // Assert
    Object targetResult = actualForVersionResult.target();
    assertTrue(targetResult instanceof Advice);
    assertTrue(actualForVersionResult.prior() instanceof ValidationContextImpl);
    assertTrue(actualForVersionResult instanceof ValidationContextImpl);
    assertNull(actualForVersionResult.field());
    assertNull(actualForVersionResult.getMetadataBundle());
    assertNull(actualForVersionResult.getResources());
    assertEquals(ValidationType.VERSION, actualForVersionResult.validationType());
    assertFalse(actualForVersionResult.isOneOf());
    assertTrue(actualForVersionResult.getErrors().isEmpty());
    assertSame(prior, targetResult);
    assertSame(actualForVersionResult, actualForVersionResult.skip());
  }

  /**
   * Test {@link ValidationContext#forConsistency(Message, MetadataBundle, PlatformConfig)}.
   * <p>
   * Method under test: {@link ValidationContext#forConsistency(Message, MetadataBundle, PlatformConfig)}
   */
  @Test
  @DisplayName("Test forConsistency(Message, MetadataBundle, PlatformConfig)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext ValidationContext.forConsistency(Message, MetadataBundle, PlatformConfig)"})
  void testForConsistency() {
    // Arrange
    Advice msg = Advice.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    PlatformConfig resources2 = PlatformConfig.getDefaultInstance();

    // Act
    ValidationContext actualForConsistencyResult = ValidationContext.forConsistency(msg, metadata, resources2);

    // Assert
    Object targetResult = actualForConsistencyResult.target();
    assertTrue(targetResult instanceof Advice);
    assertTrue(actualForConsistencyResult instanceof ValidationContextImpl);
    assertNull(actualForConsistencyResult.field());
    assertNull(actualForConsistencyResult.prior());
    assertEquals(ValidationType.CONSISTENCY, actualForConsistencyResult.validationType());
    assertFalse(actualForConsistencyResult.isOneOf());
    assertTrue(actualForConsistencyResult.getErrors().isEmpty());
    assertSame(metadata, actualForConsistencyResult.getMetadataBundle());
    assertSame(msg, targetResult);
    assertSame(actualForConsistencyResult, actualForConsistencyResult.skip());
    assertSame(resources2, actualForConsistencyResult.getResources());
  }
}
