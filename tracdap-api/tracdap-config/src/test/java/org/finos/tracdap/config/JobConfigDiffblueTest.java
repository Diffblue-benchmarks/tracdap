package org.finos.tracdap.config;

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
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.finos.tracdap.metadata.JobDefinitionOrBuilder;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.metadata.TagHeaderOrBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobConfigDiffblueTest {
  /**
   * Method under test: {@link JobConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> JobConfig.getDefaultInstance().internalGetMapFieldReflection(PlatformConfig.TENANTS_FIELD_NUMBER));
  }

  /**
   * Method under test: {@link JobConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection2() {
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
   * Method under test: {@link JobConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection3() {
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
   * Method under test: {@link JobConfig#internalGetMapFieldReflection(int)}
   */
  @Test
  void testInternalGetMapFieldReflection4() {
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
   * Method under test: {@link JobConfig#hasJobId()}
   */
  @Test
  void testHasJobId() {
    // Arrange, Act and Assert
    assertFalse(JobConfig.getDefaultInstance().hasJobId());
  }

  /**
   * Method under test: {@link JobConfig#hasJob()}
   */
  @Test
  void testHasJob() {
    // Arrange, Act and Assert
    assertFalse(JobConfig.getDefaultInstance().hasJob());
  }

  /**
   * Method under test: {@link JobConfig#getResourcesCount()}
   */
  @Test
  void testGetResourcesCount() {
    // Arrange, Act and Assert
    assertEquals(0, JobConfig.getDefaultInstance().getResourcesCount());
  }

  /**
   * Method under test: {@link JobConfig#containsResources(String)}
   */
  @Test
  void testContainsResources() {
    // Arrange, Act and Assert
    assertFalse(JobConfig.getDefaultInstance().containsResources("Key"));
  }

  /**
   * Method under test: {@link JobConfig#getResources()}
   */
  @Test
  void testGetResources() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResources().isEmpty());
  }

  /**
   * Method under test: {@link JobConfig#getResourcesMap()}
   */
  @Test
  void testGetResourcesMap() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResourcesMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link JobConfig#getResourcesOrDefault(String, ObjectDefinition)}
   */
  @Test
  void testGetResourcesOrDefault() {
    // Arrange
    JobConfig defaultInstance = JobConfig.getDefaultInstance();
    ObjectDefinition defaultValue = ObjectDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getResourcesOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link JobConfig#getResourcesOrThrow(String)}
   */
  @Test
  void testGetResourcesOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JobConfig.getDefaultInstance().getResourcesOrThrow("Key"));
  }

  /**
   * Method under test: {@link JobConfig#getResourceMappingCount()}
   */
  @Test
  void testGetResourceMappingCount() {
    // Arrange, Act and Assert
    assertEquals(0, JobConfig.getDefaultInstance().getResourceMappingCount());
  }

  /**
   * Method under test: {@link JobConfig#containsResourceMapping(String)}
   */
  @Test
  void testContainsResourceMapping() {
    // Arrange, Act and Assert
    assertFalse(JobConfig.getDefaultInstance().containsResourceMapping("Key"));
  }

  /**
   * Method under test: {@link JobConfig#getResourceMapping()}
   */
  @Test
  void testGetResourceMapping() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResourceMapping().isEmpty());
  }

  /**
   * Method under test: {@link JobConfig#getResourceMappingMap()}
   */
  @Test
  void testGetResourceMappingMap() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResourceMappingMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link JobConfig#getResourceMappingOrDefault(String, TagHeader)}
   */
  @Test
  void testGetResourceMappingOrDefault() {
    // Arrange
    JobConfig defaultInstance = JobConfig.getDefaultInstance();
    TagHeader defaultValue = TagHeader.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getResourceMappingOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link JobConfig#getResourceMappingOrThrow(String)}
   */
  @Test
  void testGetResourceMappingOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JobConfig.getDefaultInstance().getResourceMappingOrThrow("Key"));
  }

  /**
   * Method under test: {@link JobConfig#getResultMappingCount()}
   */
  @Test
  void testGetResultMappingCount() {
    // Arrange, Act and Assert
    assertEquals(0, JobConfig.getDefaultInstance().getResultMappingCount());
  }

  /**
   * Method under test: {@link JobConfig#containsResultMapping(String)}
   */
  @Test
  void testContainsResultMapping() {
    // Arrange, Act and Assert
    assertFalse(JobConfig.getDefaultInstance().containsResultMapping("Key"));
  }

  /**
   * Method under test: {@link JobConfig#getResultMapping()}
   */
  @Test
  void testGetResultMapping() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResultMapping().isEmpty());
  }

  /**
   * Method under test: {@link JobConfig#getResultMappingMap()}
   */
  @Test
  void testGetResultMappingMap() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().getResultMappingMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link JobConfig#getResultMappingOrDefault(String, TagHeader)}
   */
  @Test
  void testGetResultMappingOrDefault() {
    // Arrange
    JobConfig defaultInstance = JobConfig.getDefaultInstance();
    TagHeader defaultValue = TagHeader.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getResultMappingOrDefault("Key", defaultValue));
  }

  /**
   * Method under test: {@link JobConfig#getResultMappingOrThrow(String)}
   */
  @Test
  void testGetResultMappingOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JobConfig.getDefaultInstance().getResultMappingOrThrow("Key"));
  }

  /**
   * Method under test: {@link JobConfig#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JobConfig.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link JobConfig#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JobConfig.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobConfig#equals(Object)}
   *   <li>{@link JobConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link JobConfig#equals(Object)}
   *   <li>{@link JobConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JobConfig defaultInstance = JobConfig.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JobConfig#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link JobConfig#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobConfig.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JobConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobConfig.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JobConfig#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
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
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobConfig.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
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
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
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
   * Method under test: {@link JobConfig#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
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
   * Method under test:
   * {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobConfig.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
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
   * Method under test:
   * {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
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
   * Method under test:
   * {@link JobConfig#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
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
   * Method under test: {@link JobConfig#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    JobConfig defaultInstance = JobConfig.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link JobConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobConfig.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JobConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobConfig.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JobConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobConfig.getDefaultInstance(), "Different type to JobConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobConfig#getDefaultInstance()}
   *   <li>{@link JobConfig#getDescriptor()}
   *   <li>{@link JobConfig#newBuilder()}
   *   <li>{@link JobConfig#newBuilder(JobConfig)}
   *   <li>{@link JobConfig#newBuilderForType()}
   *   <li>{@link JobConfig#toBuilder()}
   *   <li>{@link JobConfig#getJobIdOrBuilder()}
   *   <li>{@link JobConfig#getJobOrBuilder()}
   *   <li>{@link JobConfig#getParserForType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    JobConfig actualDefaultInstance = JobConfig.getDefaultInstance();
    JobConfig actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    JobConfig prototype = JobConfig.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    TagHeaderOrBuilder actualJobIdOrBuilder = actualDefaultInstance.getJobIdOrBuilder();
    JobDefinitionOrBuilder actualJobOrBuilder = actualDefaultInstance.getJobOrBuilder();
    actualDefaultInstance.getParserForType();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getJob(), actualJobOrBuilder);
    assertSame(actualDefaultInstance.getJobId(), actualJobIdOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}
