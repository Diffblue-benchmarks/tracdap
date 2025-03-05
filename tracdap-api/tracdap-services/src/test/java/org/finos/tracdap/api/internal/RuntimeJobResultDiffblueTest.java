package org.finos.tracdap.api.internal;

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
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
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
import org.finos.tracdap.metadata.JobStatusCode;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RuntimeJobResultDiffblueTest {
  /**
   * Test {@link RuntimeJobResult#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when four; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RuntimeJobResult.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenFour_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = RuntimeJobResult.getDefaultInstance()
        .internalGetMapFieldReflection(4);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link RuntimeJobResult#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when ten; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor RuntimeJobResult.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenTen_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> RuntimeJobResult.getDefaultInstance().internalGetMapFieldReflection(10));
  }

  /**
   * Test {@link RuntimeJobResult#hasJobId()}.
   * <p>
   * Method under test: {@link RuntimeJobResult#hasJobId()}
   */
  @Test
  @DisplayName("Test hasJobId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobResult.hasJobId()"})
  void testHasJobId() {
    // Arrange, Act and Assert
    assertFalse(RuntimeJobResult.getDefaultInstance().hasJobId());
  }

  /**
   * Test {@link RuntimeJobResult#getJobId()}.
   * <p>
   * Method under test: {@link RuntimeJobResult#getJobId()}
   */
  @Test
  @DisplayName("Test getJobId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagHeader RuntimeJobResult.getJobId()"})
  void testGetJobId() {
    // Arrange and Act
    TagHeader actualJobId = RuntimeJobResult.getDefaultInstance().getJobId();

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
   * Test {@link RuntimeJobResult#getStatusCode()}.
   * <p>
   * Method under test: {@link RuntimeJobResult#getStatusCode()}
   */
  @Test
  @DisplayName("Test getStatusCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatusCode RuntimeJobResult.getStatusCode()"})
  void testGetStatusCode() {
    // Arrange, Act and Assert
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, RuntimeJobResult.getDefaultInstance().getStatusCode());
  }

  /**
   * Test {@link RuntimeJobResult#getStatusMessage()}.
   * <p>
   * Method under test: {@link RuntimeJobResult#getStatusMessage()}
   */
  @Test
  @DisplayName("Test getStatusMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuntimeJobResult.getStatusMessage()"})
  void testGetStatusMessage() {
    // Arrange, Act and Assert
    assertEquals("", RuntimeJobResult.getDefaultInstance().getStatusMessage());
  }

  /**
   * Test {@link RuntimeJobResult#getStatusMessageBytes()}.
   * <p>
   * Method under test: {@link RuntimeJobResult#getStatusMessageBytes()}
   */
  @Test
  @DisplayName("Test getStatusMessageBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString RuntimeJobResult.getStatusMessageBytes()"})
  void testGetStatusMessageBytes() {
    // Arrange
    RuntimeJobResult defaultInstance = RuntimeJobResult.getDefaultInstance();

    // Act
    ByteString actualStatusMessageBytes = defaultInstance.getStatusMessageBytes();

    // Assert
    ByteString byteString = actualStatusMessageBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualStatusMessageBytes);
    TagHeader jobId = defaultInstance.getJobId();
    assertEquals(byteString, jobId.getObjectTimestamp().getIsoDatetimeBytes());
    assertEquals(byteString, jobId.getObjectIdBytes());
  }

  /**
   * Test {@link RuntimeJobResult#getResultsCount()}.
   * <p>
   * Method under test: {@link RuntimeJobResult#getResultsCount()}
   */
  @Test
  @DisplayName("Test getResultsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RuntimeJobResult.getResultsCount()"})
  void testGetResultsCount() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeJobResult.getDefaultInstance().getResultsCount());
  }

  /**
   * Test {@link RuntimeJobResult#containsResults(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#containsResults(String)}
   */
  @Test
  @DisplayName("Test containsResults(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobResult.containsResults(String)"})
  void testContainsResults_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RuntimeJobResult.getDefaultInstance().containsResults("Key"));
  }

  /**
   * Test {@link RuntimeJobResult#getResults()}.
   * <p>
   * Method under test: {@link RuntimeJobResult#getResults()}
   */
  @Test
  @DisplayName("Test getResults()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RuntimeJobResult.getResults()"})
  void testGetResults() {
    // Arrange, Act and Assert
    assertTrue(RuntimeJobResult.getDefaultInstance().getResults().isEmpty());
  }

  /**
   * Test {@link RuntimeJobResult#getResultsMap()}.
   * <p>
   * Method under test: {@link RuntimeJobResult#getResultsMap()}
   */
  @Test
  @DisplayName("Test getResultsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map RuntimeJobResult.getResultsMap()"})
  void testGetResultsMap() {
    // Arrange, Act and Assert
    assertTrue(RuntimeJobResult.getDefaultInstance().getResultsMap().isEmpty());
  }

  /**
   * Test {@link RuntimeJobResult#getResultsOrDefault(String, ObjectDefinition)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#getResultsOrDefault(String, ObjectDefinition)}
   */
  @Test
  @DisplayName("Test getResultsOrDefault(String, ObjectDefinition); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition RuntimeJobResult.getResultsOrDefault(String, ObjectDefinition)"})
  void testGetResultsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    RuntimeJobResult defaultInstance = RuntimeJobResult.getDefaultInstance();
    ObjectDefinition defaultValue = ObjectDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getResultsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link RuntimeJobResult#getResultsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#getResultsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getResultsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition RuntimeJobResult.getResultsOrThrow(String)"})
  void testGetResultsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RuntimeJobResult.getDefaultInstance().getResultsOrThrow("Key"));
  }

  /**
   * Test {@link RuntimeJobResult#isInitialized()}.
   * <p>
   * Method under test: {@link RuntimeJobResult#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobResult.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RuntimeJobResult.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link RuntimeJobResult#getSerializedSize()}.
   * <p>
   * Method under test: {@link RuntimeJobResult#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RuntimeJobResult.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeJobResult.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link RuntimeJobResult#equals(Object)}, and {@link RuntimeJobResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeJobResult#equals(Object)}
   *   <li>{@link RuntimeJobResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobResult.equals(Object)", "int RuntimeJobResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuntimeJobResult defaultInstance = RuntimeJobResult.getDefaultInstance();
    RuntimeJobResult defaultInstance2 = RuntimeJobResult.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link RuntimeJobResult#equals(Object)}, and {@link RuntimeJobResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeJobResult#equals(Object)}
   *   <li>{@link RuntimeJobResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobResult.equals(Object)", "int RuntimeJobResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuntimeJobResult defaultInstance = RuntimeJobResult.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link RuntimeJobResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobResult.equals(Object)", "int RuntimeJobResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobResult.getDefaultInstance(), 1);
  }

  /**
   * Test {@link RuntimeJobResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobResult.equals(Object)", "int RuntimeJobResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobResult.getDefaultInstance(), null);
  }

  /**
   * Test {@link RuntimeJobResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobResult.equals(Object)", "int RuntimeJobResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobResult.getDefaultInstance(), "Different type to RuntimeJobResult");
  }

  /**
   * Test {@link RuntimeJobResult#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeJobResult#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    RuntimeJobResult actualParseFromResult = RuntimeJobResult.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStatusMessage());
    assertEquals(0, actualParseFromResult.getResultsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatusCodeValue());
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, actualParseFromResult.getStatusCode());
    assertFalse(actualParseFromResult.hasJobId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getResults().isEmpty());
    assertTrue(actualParseFromResult.getResultsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobResult#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    RuntimeJobResult actualParseFromResult = RuntimeJobResult.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStatusMessage());
    assertEquals(0, actualParseFromResult.getResultsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatusCodeValue());
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, actualParseFromResult.getStatusCode());
    assertFalse(actualParseFromResult.hasJobId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getResults().isEmpty());
    assertTrue(actualParseFromResult.getResultsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobResult#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeJobResult#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    RuntimeJobResult actualParseFromResult = RuntimeJobResult.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStatusMessage());
    assertEquals(0, actualParseFromResult.getResultsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatusCodeValue());
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, actualParseFromResult.getStatusCode());
    assertFalse(actualParseFromResult.hasJobId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getResults().isEmpty());
    assertTrue(actualParseFromResult.getResultsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobResult#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    RuntimeJobResult actualParseFromResult = RuntimeJobResult.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStatusMessage());
    assertEquals(0, actualParseFromResult.getResultsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatusCodeValue());
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, actualParseFromResult.getStatusCode());
    assertFalse(actualParseFromResult.hasJobId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getResults().isEmpty());
    assertTrue(actualParseFromResult.getResultsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobResult#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeJobResult#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    RuntimeJobResult actualParseFromResult = RuntimeJobResult.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStatusMessage());
    assertEquals(0, actualParseFromResult.getResultsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStatusCodeValue());
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, actualParseFromResult.getStatusCode());
    assertFalse(actualParseFromResult.hasJobId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getResults().isEmpty());
    assertTrue(actualParseFromResult.getResultsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobResult#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeJobResult#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RuntimeJobResult.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RuntimeJobResult#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeJobResult.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RuntimeJobResult#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeJobResult.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RuntimeJobResult#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RuntimeJobResult.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RuntimeJobResult#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    RuntimeJobResult actualParseFromResult = RuntimeJobResult.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    TagHeader jobId = actualParseFromResult.getJobId();
    assertSame(unknownFields, jobId.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(jobId, actualParseFromResult.getJobIdOrBuilder());
    assertSame(jobId, jobId.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobResult#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    RuntimeJobResult actualParseFromResult = RuntimeJobResult.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    TagHeader jobId = actualParseFromResult.getJobId();
    assertSame(unknownFields, jobId.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(jobId, actualParseFromResult.getJobIdOrBuilder());
    assertSame(jobId, jobId.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RuntimeJobResult actualParseDelimitedFromResult = RuntimeJobResult.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertFalse(unknownFields.isEmpty());
    RuntimeJobResult defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    TagHeader jobId = actualParseDelimitedFromResult.getJobId();
    assertSame(jobId, defaultInstanceForType.getJobId());
    assertSame(jobId, defaultInstanceForType.getJobIdOrBuilder());
    assertSame(jobId, actualParseDelimitedFromResult.getJobIdOrBuilder());
    assertSame(jobId, jobId.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RuntimeJobResult actualParseDelimitedFromResult = RuntimeJobResult.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    TagHeader jobId = actualParseDelimitedFromResult.getJobId();
    assertSame(unknownFields, jobId.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(jobId, actualParseDelimitedFromResult.getJobIdOrBuilder());
    assertSame(jobId, jobId.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RuntimeJobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeJobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RuntimeJobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> RuntimeJobResult.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeJobResult.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeJobResult.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RuntimeJobResult actualParseDelimitedFromResult = RuntimeJobResult.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertFalse(unknownFields.isEmpty());
    RuntimeJobResult defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    TagHeader jobId = actualParseDelimitedFromResult.getJobId();
    assertSame(jobId, defaultInstanceForType.getJobId());
    assertSame(jobId, defaultInstanceForType.getJobIdOrBuilder());
    assertSame(jobId, actualParseDelimitedFromResult.getJobIdOrBuilder());
    assertSame(jobId, jobId.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RuntimeJobResult actualParseDelimitedFromResult = RuntimeJobResult.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    TagHeader jobId = actualParseDelimitedFromResult.getJobId();
    assertSame(unknownFields, jobId.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(jobId, actualParseDelimitedFromResult.getJobIdOrBuilder());
    assertSame(jobId, jobId.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RuntimeJobResult.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobResult#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobResult#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> RuntimeJobResult.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobResult#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link RuntimeJobResult#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobResult RuntimeJobResult.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    RuntimeJobResult defaultInstance = RuntimeJobResult.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}
