package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.google.api.Advice;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.finos.tracdap.common.metadata.MetadataBundle;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationType;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.junit.jupiter.api.Test;

class ValidationContextImplDiffblueTest {
  /**
   * Method under test:
   * {@link ValidationContextImpl#forMethod(Message, Descriptors.MethodDescriptor)}
   */
  @Test
  void testForMethod() {
    // Arrange
    Advice msg = Advice.getDefaultInstance();

    // Act
    ValidationContext actualForMethodResult = ValidationContextImpl.forMethod(msg, null);

    // Assert
    assertTrue(actualForMethodResult instanceof ValidationContextImpl);
    ValidationKey keyResult = actualForMethodResult.key();
    assertEquals("Advice STATIC", keyResult.displayName());
    assertEquals("Advice", keyResult.shortName());
    assertNull(actualForMethodResult.field());
    assertNull(actualForMethodResult.getMetadataBundle());
    assertNull(actualForMethodResult.prior());
    assertNull(actualForMethodResult.getResources());
    assertEquals(ValidationType.STATIC, actualForMethodResult.validationType());
    assertEquals(ValidationType.STATIC, keyResult.validationType());
    assertFalse(actualForMethodResult.isOneOf());
    assertTrue(actualForMethodResult.getErrors().isEmpty());
    assertSame(msg, actualForMethodResult.target());
    assertSame(actualForMethodResult, actualForMethodResult.skip());
  }

  /**
   * Method under test: {@link ValidationContextImpl#forMessage(Message)}
   */
  @Test
  void testForMessage() {
    // Arrange
    Advice msg = Advice.getDefaultInstance();

    // Act
    ValidationContext actualForMessageResult = ValidationContextImpl.forMessage(msg);

    // Assert
    assertTrue(actualForMessageResult instanceof ValidationContextImpl);
    ValidationKey keyResult = actualForMessageResult.key();
    assertEquals("Advice STATIC", keyResult.displayName());
    assertEquals("Advice", keyResult.shortName());
    assertNull(actualForMessageResult.field());
    assertNull(actualForMessageResult.getMetadataBundle());
    assertNull(actualForMessageResult.prior());
    assertNull(actualForMessageResult.getResources());
    assertEquals(ValidationType.STATIC, actualForMessageResult.validationType());
    assertEquals(ValidationType.STATIC, keyResult.validationType());
    assertFalse(actualForMessageResult.isOneOf());
    assertTrue(actualForMessageResult.getErrors().isEmpty());
    assertSame(msg, actualForMessageResult.target());
    assertSame(actualForMessageResult, actualForMessageResult.skip());
  }

  /**
   * Method under test: {@link ValidationContextImpl#forVersion(Message, Message)}
   */
  @Test
  void testForVersion() {
    // Arrange
    Advice current = Advice.getDefaultInstance();
    Advice prior = Advice.getDefaultInstance();

    // Act
    ValidationContext actualForVersionResult = ValidationContextImpl.forVersion(current, prior);

    // Assert
    ValidationContext priorResult = actualForVersionResult.prior();
    assertTrue(priorResult instanceof ValidationContextImpl);
    assertTrue(actualForVersionResult instanceof ValidationContextImpl);
    ValidationKey keyResult = actualForVersionResult.key();
    assertEquals("Advice VERSION", keyResult.displayName());
    assertEquals("Advice", keyResult.shortName());
    assertNull(priorResult.field());
    assertNull(actualForVersionResult.field());
    assertNull(priorResult.getMetadataBundle());
    assertNull(actualForVersionResult.getMetadataBundle());
    assertNull(priorResult.prior());
    assertNull(priorResult.getResources());
    assertNull(actualForVersionResult.getResources());
    assertEquals(ValidationType.VERSION, priorResult.validationType());
    assertEquals(ValidationType.VERSION, actualForVersionResult.validationType());
    assertEquals(ValidationType.VERSION, keyResult.validationType());
    assertFalse(priorResult.isOneOf());
    assertFalse(actualForVersionResult.isOneOf());
    assertTrue(priorResult.getErrors().isEmpty());
    assertTrue(actualForVersionResult.getErrors().isEmpty());
    assertEquals(keyResult, priorResult.key());
    assertSame(prior, priorResult.target());
    assertSame(prior, actualForVersionResult.target());
    assertSame(actualForVersionResult, actualForVersionResult.skip());
  }

  /**
   * Method under test:
   * {@link ValidationContextImpl#forConsistency(Message, MetadataBundle, PlatformConfig)}
   */
  @Test
  void testForConsistency() {
    // Arrange
    Advice msg = Advice.getDefaultInstance();
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    PlatformConfig resources2 = PlatformConfig.getDefaultInstance();

    // Act
    ValidationContext actualForConsistencyResult = ValidationContextImpl.forConsistency(msg, metadata, resources2);

    // Assert
    assertTrue(actualForConsistencyResult instanceof ValidationContextImpl);
    ValidationKey keyResult = actualForConsistencyResult.key();
    assertEquals("Advice CONSISTENCY", keyResult.displayName());
    assertEquals("Advice", keyResult.shortName());
    assertNull(actualForConsistencyResult.field());
    assertNull(actualForConsistencyResult.prior());
    assertEquals(ValidationType.CONSISTENCY, actualForConsistencyResult.validationType());
    assertEquals(ValidationType.CONSISTENCY, keyResult.validationType());
    assertFalse(actualForConsistencyResult.isOneOf());
    assertTrue(actualForConsistencyResult.getErrors().isEmpty());
    assertSame(metadata, actualForConsistencyResult.getMetadataBundle());
    assertSame(msg, actualForConsistencyResult.target());
    assertSame(actualForConsistencyResult, actualForConsistencyResult.skip());
    assertSame(resources2, actualForConsistencyResult.getResources());
  }

  /**
   * Method under test:
   * {@link ValidationContextImpl#forConsistency(Message, MetadataBundle, PlatformConfig)}
   */
  @Test
  void testForConsistency2() {
    // Arrange
    Advice msg = Advice.getDefaultInstance();

    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    resources.computeIfPresent("foo", mock(BiFunction.class));
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    PlatformConfig resources2 = PlatformConfig.getDefaultInstance();

    // Act
    ValidationContext actualForConsistencyResult = ValidationContextImpl.forConsistency(msg, metadata, resources2);

    // Assert
    assertTrue(actualForConsistencyResult instanceof ValidationContextImpl);
    ValidationKey keyResult = actualForConsistencyResult.key();
    assertEquals("Advice CONSISTENCY", keyResult.displayName());
    assertEquals("Advice", keyResult.shortName());
    assertNull(actualForConsistencyResult.field());
    assertNull(actualForConsistencyResult.prior());
    assertEquals(ValidationType.CONSISTENCY, actualForConsistencyResult.validationType());
    assertEquals(ValidationType.CONSISTENCY, keyResult.validationType());
    assertFalse(actualForConsistencyResult.isOneOf());
    assertTrue(actualForConsistencyResult.getErrors().isEmpty());
    assertSame(metadata, actualForConsistencyResult.getMetadataBundle());
    assertSame(msg, actualForConsistencyResult.target());
    assertSame(actualForConsistencyResult, actualForConsistencyResult.skip());
    assertSame(resources2, actualForConsistencyResult.getResources());
  }
}
