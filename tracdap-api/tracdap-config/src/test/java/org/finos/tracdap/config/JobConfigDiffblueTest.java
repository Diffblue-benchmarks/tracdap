package org.finos.tracdap.config;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.finos.tracdap.metadata.JobDefinition;
import org.finos.tracdap.metadata.JobDefinition.JobDetailsCase;
import org.finos.tracdap.metadata.JobType;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobConfigDiffblueTest {
  /**
   * Test {@link JobConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor JobConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> JobConfig.getDefaultInstance().internalGetMapFieldReflection(PlatformConfig.TENANTS_FIELD_NUMBER));
  }

  /**
   * Test {@link JobConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when five; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor JobConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFive_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = JobConfig.getDefaultInstance()
        .internalGetMapFieldReflection(5);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link JobConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when four; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor JobConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFour_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = JobConfig.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link JobConfig#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when three; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor JobConfig.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenThree_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = JobConfig.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link JobConfig#hasJobId()}.
   * <p>
   * Method under test: {@link JobConfig#hasJobId()}
   */
  @Test
  @DisplayName("Test hasJobId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobConfig.hasJobId()"})
  void testHasJobId() {
    // Arrange, Act and Assert
    assertFalse(JobConfig.getDefaultInstance().hasJobId());
  }

  /**
   * Test {@link JobConfig#getJobId()}.
   * <p>
   * Method under test: {@link JobConfig#getJobId()}
   */
  @Test
  @DisplayName("Test getJobId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagHeader JobConfig.getJobId()"})
  void testGetJobId() {
    // Arrange and Act
    TagHeader actualJobId = JobConfig.getDefaultInstance().getJobId();

    // Assert
    assertEquals("", actualJobId.getInitializationErrorString());
    assertEquals("", actualJobId.getObjectId());
    assertEquals(0, actualJobId.getObjectTypeValue());
    assertEquals(0, actualJobId.getObjectVersion());
    assertEquals(0, actualJobId.getSerializedSize());
    assertEquals(0, actualJobId.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualJobId.getObjectType());
    assertFalse(actualJobId.getIsLatestObject());
    assertFalse(actualJobId.getIsLatestTag());
    assertFalse(actualJobId.hasObjectTimestamp());
    assertFalse(actualJobId.hasTagTimestamp());
    assertTrue(actualJobId.findInitializationErrors().isEmpty());
    assertTrue(actualJobId.getAllFields().isEmpty());
    assertTrue(actualJobId.isInitialized());
    assertSame(actualJobId, actualJobId.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobConfig#hasJob()}.
   * <p>
   * Method under test: {@link JobConfig#hasJob()}
   */
  @Test
  @DisplayName("Test hasJob()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobConfig.hasJob()"})
  void testHasJob() {
    // Arrange, Act and Assert
    assertFalse(JobConfig.getDefaultInstance().hasJob());
  }

  /**
   * Test {@link JobConfig#getJob()}.
   * <p>
   * Method under test: {@link JobConfig#getJob()}
   */
  @Test
  @DisplayName("Test getJob()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobConfig.getJob()"})
  void testGetJob() {
    // Arrange and Act
    JobDefinition actualJob = JobConfig.getDefaultInstance().getJob();

    // Assert
    assertEquals("", actualJob.getInitializationErrorString());
    assertEquals(0, actualJob.getJobTypeValue());
    assertEquals(0, actualJob.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualJob.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualJob.getJobType());
    assertFalse(actualJob.hasExportData());
    assertFalse(actualJob.hasImportData());
    assertFalse(actualJob.hasImportModel());
    assertFalse(actualJob.hasJobGroup());
    assertFalse(actualJob.hasResultId());
    assertFalse(actualJob.hasRunFlow());
    assertFalse(actualJob.hasRunModel());
    assertTrue(actualJob.findInitializationErrors().isEmpty());
    assertTrue(actualJob.getAllFields().isEmpty());
    assertTrue(actualJob.isInitialized());
    assertSame(actualJob, actualJob.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobConfig#getResourcesCount()}.
   * <p>
   * Method under test: {@link JobConfig#getResourcesCount()}
   */
  @Test
  @DisplayName("Test getResourcesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobConfig.getResourcesCount()"})
  void testGetResourcesCount() {
    // Arrange, Act and Assert
    assertEquals(0, JobConfig.getDefaultInstance().getResourcesCount());
  }

  /**
   * Test {@link JobConfig#containsResources(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#containsResources(String)}
   */
  @Test
  @DisplayName("Test containsResources(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobConfig.containsResources(String)"})
  void testContainsResources_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JobConfig.getDefaultInstance().containsResources("Key"));
  }

  /**
   * Test {@link JobConfig#getResources()}.
   * <p>
   * Method under test: {@link JobConfig#getResources()}
   */
  @Test
  @DisplayName("Test getResources()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map JobConfig.getResources()"})
  void testGetResources() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResources().isEmpty());
  }

  /**
   * Test {@link JobConfig#getResourcesMap()}.
   * <p>
   * Method under test: {@link JobConfig#getResourcesMap()}
   */
  @Test
  @DisplayName("Test getResourcesMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map JobConfig.getResourcesMap()"})
  void testGetResourcesMap() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResourcesMap().isEmpty());
  }

  /**
   * Test {@link JobConfig#getResourcesOrDefault(String, ObjectDefinition)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#getResourcesOrDefault(String, ObjectDefinition)}
   */
  @Test
  @DisplayName("Test getResourcesOrDefault(String, ObjectDefinition); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition JobConfig.getResourcesOrDefault(String, ObjectDefinition)"})
  void testGetResourcesOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    JobConfig defaultInstance = JobConfig.getDefaultInstance();
    ObjectDefinition defaultValue = ObjectDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getResourcesOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link JobConfig#getResourcesOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#getResourcesOrThrow(String)}
   */
  @Test
  @DisplayName("Test getResourcesOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition JobConfig.getResourcesOrThrow(String)"})
  void testGetResourcesOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JobConfig.getDefaultInstance().getResourcesOrThrow("Key"));
  }

  /**
   * Test {@link JobConfig#getResourceMappingCount()}.
   * <p>
   * Method under test: {@link JobConfig#getResourceMappingCount()}
   */
  @Test
  @DisplayName("Test getResourceMappingCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobConfig.getResourceMappingCount()"})
  void testGetResourceMappingCount() {
    // Arrange, Act and Assert
    assertEquals(0, JobConfig.getDefaultInstance().getResourceMappingCount());
  }

  /**
   * Test {@link JobConfig#containsResourceMapping(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#containsResourceMapping(String)}
   */
  @Test
  @DisplayName("Test containsResourceMapping(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobConfig.containsResourceMapping(String)"})
  void testContainsResourceMapping_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JobConfig.getDefaultInstance().containsResourceMapping("Key"));
  }

  /**
   * Test {@link JobConfig#getResourceMapping()}.
   * <p>
   * Method under test: {@link JobConfig#getResourceMapping()}
   */
  @Test
  @DisplayName("Test getResourceMapping()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map JobConfig.getResourceMapping()"})
  void testGetResourceMapping() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResourceMapping().isEmpty());
  }

  /**
   * Test {@link JobConfig#getResourceMappingMap()}.
   * <p>
   * Method under test: {@link JobConfig#getResourceMappingMap()}
   */
  @Test
  @DisplayName("Test getResourceMappingMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map JobConfig.getResourceMappingMap()"})
  void testGetResourceMappingMap() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResourceMappingMap().isEmpty());
  }

  /**
   * Test {@link JobConfig#getResourceMappingOrDefault(String, TagHeader)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#getResourceMappingOrDefault(String, TagHeader)}
   */
  @Test
  @DisplayName("Test getResourceMappingOrDefault(String, TagHeader); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagHeader JobConfig.getResourceMappingOrDefault(String, TagHeader)"})
  void testGetResourceMappingOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    JobConfig defaultInstance = JobConfig.getDefaultInstance();
    TagHeader defaultValue = TagHeader.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getResourceMappingOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link JobConfig#getResourceMappingOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#getResourceMappingOrThrow(String)}
   */
  @Test
  @DisplayName("Test getResourceMappingOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagHeader JobConfig.getResourceMappingOrThrow(String)"})
  void testGetResourceMappingOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JobConfig.getDefaultInstance().getResourceMappingOrThrow("Key"));
  }

  /**
   * Test {@link JobConfig#getResultMappingCount()}.
   * <p>
   * Method under test: {@link JobConfig#getResultMappingCount()}
   */
  @Test
  @DisplayName("Test getResultMappingCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobConfig.getResultMappingCount()"})
  void testGetResultMappingCount() {
    // Arrange, Act and Assert
    assertEquals(0, JobConfig.getDefaultInstance().getResultMappingCount());
  }

  /**
   * Test {@link JobConfig#containsResultMapping(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#containsResultMapping(String)}
   */
  @Test
  @DisplayName("Test containsResultMapping(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobConfig.containsResultMapping(String)"})
  void testContainsResultMapping_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JobConfig.getDefaultInstance().containsResultMapping("Key"));
  }

  /**
   * Test {@link JobConfig#getResultMapping()}.
   * <p>
   * Method under test: {@link JobConfig#getResultMapping()}
   */
  @Test
  @DisplayName("Test getResultMapping()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map JobConfig.getResultMapping()"})
  void testGetResultMapping() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResultMapping().isEmpty());
  }

  /**
   * Test {@link JobConfig#getResultMappingMap()}.
   * <p>
   * Method under test: {@link JobConfig#getResultMappingMap()}
   */
  @Test
  @DisplayName("Test getResultMappingMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map JobConfig.getResultMappingMap()"})
  void testGetResultMappingMap() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResultMappingMap().isEmpty());
  }

  /**
   * Test {@link JobConfig#getResultMappingOrDefault(String, TagHeader)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#getResultMappingOrDefault(String, TagHeader)}
   */
  @Test
  @DisplayName("Test getResultMappingOrDefault(String, TagHeader); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagHeader JobConfig.getResultMappingOrDefault(String, TagHeader)"})
  void testGetResultMappingOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    JobConfig defaultInstance = JobConfig.getDefaultInstance();
    TagHeader defaultValue = TagHeader.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getResultMappingOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link JobConfig#getResultMappingOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#getResultMappingOrThrow(String)}
   */
  @Test
  @DisplayName("Test getResultMappingOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagHeader JobConfig.getResultMappingOrThrow(String)"})
  void testGetResultMappingOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JobConfig.getDefaultInstance().getResultMappingOrThrow("Key"));
  }

  /**
   * Test {@link JobConfig#isInitialized()}.
   * <p>
   * Method under test: {@link JobConfig#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobConfig.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link JobConfig#getSerializedSize()}.
   * <p>
   * Method under test: {@link JobConfig#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobConfig.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JobConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link JobConfig#equals(Object)}, and {@link JobConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JobConfig#equals(Object)}
   *   <li>{@link JobConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobConfig.equals(Object)", "int JobConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JobConfig defaultInstance = JobConfig.getDefaultInstance();
    JobConfig defaultInstance2 = JobConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link JobConfig#equals(Object)}, and {@link JobConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JobConfig#equals(Object)}
   *   <li>{@link JobConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobConfig.equals(Object)", "int JobConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JobConfig defaultInstance = JobConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link JobConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobConfig.equals(Object)", "int JobConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobConfig.getDefaultInstance(), 1);
  }

  /**
   * Test {@link JobConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobConfig.equals(Object)", "int JobConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobConfig.getDefaultInstance(), null);
  }

  /**
   * Test {@link JobConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobConfig.equals(Object)", "int JobConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobConfig.getDefaultInstance(), "Different type to JobConfig");
  }

  /**
   * Test {@link JobConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobConfig#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    JobConfig actualParseFromResult = JobConfig.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceMappingCount());
    assertEquals(0, actualParseFromResult.getResourcesCount());
    assertEquals(0, actualParseFromResult.getResultMappingCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasJob());
    assertFalse(actualParseFromResult.hasJobId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getResourceMapping().isEmpty());
    assertTrue(actualParseFromResult.getResourceMappingMap().isEmpty());
    assertTrue(actualParseFromResult.getResources().isEmpty());
    assertTrue(actualParseFromResult.getResourcesMap().isEmpty());
    assertTrue(actualParseFromResult.getResultMapping().isEmpty());
    assertTrue(actualParseFromResult.getResultMappingMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobConfig#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    JobConfig actualParseFromResult = JobConfig.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceMappingCount());
    assertEquals(0, actualParseFromResult.getResourcesCount());
    assertEquals(0, actualParseFromResult.getResultMappingCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasJob());
    assertFalse(actualParseFromResult.hasJobId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getResourceMapping().isEmpty());
    assertTrue(actualParseFromResult.getResourceMappingMap().isEmpty());
    assertTrue(actualParseFromResult.getResources().isEmpty());
    assertTrue(actualParseFromResult.getResourcesMap().isEmpty());
    assertTrue(actualParseFromResult.getResultMapping().isEmpty());
    assertTrue(actualParseFromResult.getResultMappingMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobConfig#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobConfig#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    JobConfig actualParseFromResult = JobConfig.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceMappingCount());
    assertEquals(0, actualParseFromResult.getResourcesCount());
    assertEquals(0, actualParseFromResult.getResultMappingCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasJob());
    assertFalse(actualParseFromResult.hasJobId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getResourceMapping().isEmpty());
    assertTrue(actualParseFromResult.getResourceMappingMap().isEmpty());
    assertTrue(actualParseFromResult.getResources().isEmpty());
    assertTrue(actualParseFromResult.getResourcesMap().isEmpty());
    assertTrue(actualParseFromResult.getResultMapping().isEmpty());
    assertTrue(actualParseFromResult.getResultMappingMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobConfig#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    JobConfig actualParseFromResult = JobConfig.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceMappingCount());
    assertEquals(0, actualParseFromResult.getResourcesCount());
    assertEquals(0, actualParseFromResult.getResultMappingCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasJob());
    assertFalse(actualParseFromResult.hasJobId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getResourceMapping().isEmpty());
    assertTrue(actualParseFromResult.getResourceMappingMap().isEmpty());
    assertTrue(actualParseFromResult.getResources().isEmpty());
    assertTrue(actualParseFromResult.getResourcesMap().isEmpty());
    assertTrue(actualParseFromResult.getResultMapping().isEmpty());
    assertTrue(actualParseFromResult.getResultMappingMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    JobConfig actualParseFromResult = JobConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getResourceMappingCount());
    assertEquals(0, actualParseFromResult.getResourcesCount());
    assertEquals(0, actualParseFromResult.getResultMappingCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasJob());
    assertFalse(actualParseFromResult.hasJobId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getResourceMapping().isEmpty());
    assertTrue(actualParseFromResult.getResourceMappingMap().isEmpty());
    assertTrue(actualParseFromResult.getResources().isEmpty());
    assertTrue(actualParseFromResult.getResourcesMap().isEmpty());
    assertTrue(actualParseFromResult.getResultMapping().isEmpty());
    assertTrue(actualParseFromResult.getResultMappingMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JobConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link JobConfig#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link JobConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link JobConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link JobConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    JobConfig actualParseFromResult = JobConfig.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    JobDefinition job = actualParseFromResult.getJob();
    assertSame(unknownFields, job.getUnknownFields());
    TagHeader jobId = actualParseFromResult.getJobId();
    assertSame(unknownFields, jobId.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(job, actualParseFromResult.getJobOrBuilder());
    assertSame(job, job.getDefaultInstanceForType());
    assertSame(jobId, actualParseFromResult.getJobIdOrBuilder());
    assertSame(jobId, jobId.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobConfig#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Job UnknownFields is UnknownFields.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'; then return Job UnknownFields is UnknownFields")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull_thenReturnJobUnknownFieldsIsUnknownFields() throws IOException {
    // Arrange and Act
    JobConfig actualParseFromResult = JobConfig.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    JobDefinition job = actualParseFromResult.getJob();
    assertSame(unknownFields, job.getUnknownFields());
    TagHeader jobId = actualParseFromResult.getJobId();
    assertSame(unknownFields, jobId.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(job, actualParseFromResult.getJobOrBuilder());
    assertSame(job, job.getDefaultInstanceForType());
    assertSame(jobId, actualParseFromResult.getJobIdOrBuilder());
    assertSame(jobId, jobId.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JobConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, JobConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JobConfig actualParseDelimitedFromResult = JobConfig.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JobConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JobConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JobConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, JobConfig.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JobConfig actualParseDelimitedFromResult = JobConfig.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link JobConfig#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JobConfig.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link JobConfig#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link JobConfig#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobConfig JobConfig.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    JobConfig defaultInstance = JobConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}
