package org.finos.tracdap.metadata;

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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ImportModelJobDiffblueTest {
  /**
   * Test {@link ImportModelJob#getLanguage()}.
   * <p>
   * Method under test: {@link ImportModelJob#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ImportModelJob.getLanguage()"})
  void testGetLanguage() {
    // Arrange, Act and Assert
    assertEquals("", ImportModelJob.getDefaultInstance().getLanguage());
  }

  /**
   * Test {@link ImportModelJob#getLanguageBytes()}.
   * <p>
   * Method under test: {@link ImportModelJob#getLanguageBytes()}
   */
  @Test
  @DisplayName("Test getLanguageBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ImportModelJob.getLanguageBytes()"})
  void testGetLanguageBytes() {
    // Arrange
    ImportModelJob defaultInstance = ImportModelJob.getDefaultInstance();

    // Act
    ByteString actualLanguageBytes = defaultInstance.getLanguageBytes();

    // Assert
    ByteString byteString = actualLanguageBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, actualLanguageBytes);
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ImportModelJob#getRepository()}.
   * <p>
   * Method under test: {@link ImportModelJob#getRepository()}
   */
  @Test
  @DisplayName("Test getRepository()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ImportModelJob.getRepository()"})
  void testGetRepository() {
    // Arrange, Act and Assert
    assertEquals("", ImportModelJob.getDefaultInstance().getRepository());
  }

  /**
   * Test {@link ImportModelJob#getRepositoryBytes()}.
   * <p>
   * Method under test: {@link ImportModelJob#getRepositoryBytes()}
   */
  @Test
  @DisplayName("Test getRepositoryBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ImportModelJob.getRepositoryBytes()"})
  void testGetRepositoryBytes() {
    // Arrange
    ImportModelJob defaultInstance = ImportModelJob.getDefaultInstance();

    // Act
    ByteString actualRepositoryBytes = defaultInstance.getRepositoryBytes();

    // Assert
    ByteString byteString = actualRepositoryBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, actualRepositoryBytes);
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ImportModelJob#hasPackageGroup()}.
   * <p>
   * Method under test: {@link ImportModelJob#hasPackageGroup()}
   */
  @Test
  @DisplayName("Test hasPackageGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportModelJob.hasPackageGroup()"})
  void testHasPackageGroup() {
    // Arrange, Act and Assert
    assertFalse(ImportModelJob.getDefaultInstance().hasPackageGroup());
  }

  /**
   * Test {@link ImportModelJob#getPackageGroup()}.
   * <p>
   * Method under test: {@link ImportModelJob#getPackageGroup()}
   */
  @Test
  @DisplayName("Test getPackageGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ImportModelJob.getPackageGroup()"})
  void testGetPackageGroup() {
    // Arrange, Act and Assert
    assertEquals("", ImportModelJob.getDefaultInstance().getPackageGroup());
  }

  /**
   * Test {@link ImportModelJob#getPackageGroupBytes()}.
   * <p>
   * Method under test: {@link ImportModelJob#getPackageGroupBytes()}
   */
  @Test
  @DisplayName("Test getPackageGroupBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ImportModelJob.getPackageGroupBytes()"})
  void testGetPackageGroupBytes() {
    // Arrange
    ImportModelJob defaultInstance = ImportModelJob.getDefaultInstance();

    // Act
    ByteString actualPackageGroupBytes = defaultInstance.getPackageGroupBytes();

    // Assert
    ByteString byteString = actualPackageGroupBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, actualPackageGroupBytes);
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ImportModelJob#getPackage()}.
   * <p>
   * Method under test: {@link ImportModelJob#getPackage()}
   */
  @Test
  @DisplayName("Test getPackage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ImportModelJob.getPackage()"})
  void testGetPackage() {
    // Arrange, Act and Assert
    assertEquals("", ImportModelJob.getDefaultInstance().getPackage());
  }

  /**
   * Test {@link ImportModelJob#getPackageBytes()}.
   * <p>
   * Method under test: {@link ImportModelJob#getPackageBytes()}
   */
  @Test
  @DisplayName("Test getPackageBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ImportModelJob.getPackageBytes()"})
  void testGetPackageBytes() {
    // Arrange
    ImportModelJob defaultInstance = ImportModelJob.getDefaultInstance();

    // Act
    ByteString actualPackageBytes = defaultInstance.getPackageBytes();

    // Assert
    ByteString byteString = actualPackageBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, actualPackageBytes);
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ImportModelJob#getVersion()}.
   * <p>
   * Method under test: {@link ImportModelJob#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ImportModelJob.getVersion()"})
  void testGetVersion() {
    // Arrange, Act and Assert
    assertEquals("", ImportModelJob.getDefaultInstance().getVersion());
  }

  /**
   * Test {@link ImportModelJob#getVersionBytes()}.
   * <p>
   * Method under test: {@link ImportModelJob#getVersionBytes()}
   */
  @Test
  @DisplayName("Test getVersionBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ImportModelJob.getVersionBytes()"})
  void testGetVersionBytes() {
    // Arrange
    ImportModelJob defaultInstance = ImportModelJob.getDefaultInstance();

    // Act
    ByteString actualVersionBytes = defaultInstance.getVersionBytes();

    // Assert
    ByteString byteString = actualVersionBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, actualVersionBytes);
  }

  /**
   * Test {@link ImportModelJob#getEntryPoint()}.
   * <p>
   * Method under test: {@link ImportModelJob#getEntryPoint()}
   */
  @Test
  @DisplayName("Test getEntryPoint()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ImportModelJob.getEntryPoint()"})
  void testGetEntryPoint() {
    // Arrange, Act and Assert
    assertEquals("", ImportModelJob.getDefaultInstance().getEntryPoint());
  }

  /**
   * Test {@link ImportModelJob#getEntryPointBytes()}.
   * <p>
   * Method under test: {@link ImportModelJob#getEntryPointBytes()}
   */
  @Test
  @DisplayName("Test getEntryPointBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ImportModelJob.getEntryPointBytes()"})
  void testGetEntryPointBytes() {
    // Arrange
    ImportModelJob defaultInstance = ImportModelJob.getDefaultInstance();

    // Act
    ByteString actualEntryPointBytes = defaultInstance.getEntryPointBytes();

    // Assert
    ByteString byteString = actualEntryPointBytes.EMPTY;
    assertEquals(byteString, actualEntryPointBytes);
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, defaultInstance.getPathBytes());
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ImportModelJob#getPath()}.
   * <p>
   * Method under test: {@link ImportModelJob#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ImportModelJob.getPath()"})
  void testGetPath() {
    // Arrange, Act and Assert
    assertEquals("", ImportModelJob.getDefaultInstance().getPath());
  }

  /**
   * Test {@link ImportModelJob#getPathBytes()}.
   * <p>
   * Method under test: {@link ImportModelJob#getPathBytes()}
   */
  @Test
  @DisplayName("Test getPathBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ImportModelJob.getPathBytes()"})
  void testGetPathBytes() {
    // Arrange
    ImportModelJob defaultInstance = ImportModelJob.getDefaultInstance();

    // Act
    ByteString actualPathBytes = defaultInstance.getPathBytes();

    // Assert
    ByteString byteString = actualPathBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getEntryPointBytes());
    assertEquals(byteString, defaultInstance.getLanguageBytes());
    assertEquals(byteString, defaultInstance.getPackageBytes());
    assertEquals(byteString, defaultInstance.getPackageGroupBytes());
    assertEquals(byteString, actualPathBytes);
    assertEquals(byteString, defaultInstance.getRepositoryBytes());
    assertEquals(byteString, defaultInstance.getVersionBytes());
  }

  /**
   * Test {@link ImportModelJob#getModelAttrsCount()}.
   * <p>
   * Method under test: {@link ImportModelJob#getModelAttrsCount()}
   */
  @Test
  @DisplayName("Test getModelAttrsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportModelJob.getModelAttrsCount()"})
  void testGetModelAttrsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ImportModelJob.getDefaultInstance().getModelAttrsCount());
  }

  /**
   * Test {@link ImportModelJob#isInitialized()}.
   * <p>
   * Method under test: {@link ImportModelJob#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportModelJob.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ImportModelJob.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link ImportModelJob#getSerializedSize()}.
   * <p>
   * Method under test: {@link ImportModelJob#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ImportModelJob.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ImportModelJob.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link ImportModelJob#equals(Object)}, and {@link ImportModelJob#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImportModelJob#equals(Object)}
   *   <li>{@link ImportModelJob#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportModelJob.equals(Object)", "int ImportModelJob.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImportModelJob defaultInstance = ImportModelJob.getDefaultInstance();
    ImportModelJob defaultInstance2 = ImportModelJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link ImportModelJob#equals(Object)}, and {@link ImportModelJob#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImportModelJob#equals(Object)}
   *   <li>{@link ImportModelJob#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportModelJob.equals(Object)", "int ImportModelJob.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImportModelJob defaultInstance = ImportModelJob.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link ImportModelJob#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportModelJob.equals(Object)", "int ImportModelJob.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImportModelJob.getDefaultInstance(), 1);
  }

  /**
   * Test {@link ImportModelJob#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportModelJob.equals(Object)", "int ImportModelJob.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImportModelJob.getDefaultInstance(), null);
  }

  /**
   * Test {@link ImportModelJob#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportModelJob.equals(Object)", "int ImportModelJob.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImportModelJob.getDefaultInstance(), "Different type to ImportModelJob");
  }

  /**
   * Test {@link ImportModelJob#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ImportModelJob actualParseFromResult = ImportModelJob.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getModelAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualParseFromResult.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(modelAttrsList, actualParseFromResult.getModelAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportModelJob#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ImportModelJob actualParseFromResult = ImportModelJob.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getModelAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualParseFromResult.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(modelAttrsList, actualParseFromResult.getModelAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportModelJob#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ImportModelJob actualParseFromResult = ImportModelJob.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getModelAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualParseFromResult.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(modelAttrsList, actualParseFromResult.getModelAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportModelJob#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ImportModelJob actualParseFromResult = ImportModelJob.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getModelAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualParseFromResult.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getEntryPointBytes());
    assertEquals(byteString, actualParseFromResult.getLanguageBytes());
    assertEquals(byteString, actualParseFromResult.getPackageBytes());
    assertEquals(byteString, actualParseFromResult.getPackageGroupBytes());
    assertEquals(byteString, actualParseFromResult.getPathBytes());
    assertEquals(byteString, actualParseFromResult.getRepositoryBytes());
    assertEquals(byteString, actualParseFromResult.getVersionBytes());
    assertSame(modelAttrsList, actualParseFromResult.getModelAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportModelJob#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(ByteString)"})
  void testParseFromWithByteString_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ImportModelJob actualParseFromResult = ImportModelJob.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getModelAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualParseFromResult.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getEntryPointBytes());
    assertEquals(byteString, actualParseFromResult.getLanguageBytes());
    assertEquals(byteString, actualParseFromResult.getPackageBytes());
    assertEquals(byteString, actualParseFromResult.getPackageGroupBytes());
    assertEquals(byteString, actualParseFromResult.getPathBytes());
    assertEquals(byteString, actualParseFromResult.getRepositoryBytes());
    assertEquals(byteString, actualParseFromResult.getVersionBytes());
    assertSame(modelAttrsList, actualParseFromResult.getModelAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportModelJob#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    ImportModelJob actualParseFromResult = ImportModelJob.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getModelAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualParseFromResult.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(modelAttrsList, actualParseFromResult.getModelAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportModelJob#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ImportModelJob actualParseFromResult = ImportModelJob.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getModelAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualParseFromResult.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(modelAttrsList, actualParseFromResult.getModelAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportModelJob#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ImportModelJob actualParseFromResult = ImportModelJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getModelAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualParseFromResult.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(modelAttrsList, actualParseFromResult.getModelAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportModelJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ImportModelJob actualParseFromResult = ImportModelJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getEntryPoint());
    assertEquals("", actualParseFromResult.getLanguage());
    assertEquals("", actualParseFromResult.getPackage());
    assertEquals("", actualParseFromResult.getPackageGroup());
    assertEquals("", actualParseFromResult.getPath());
    assertEquals("", actualParseFromResult.getRepository());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getModelAttrsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPackageGroup());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualParseFromResult.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(modelAttrsList, actualParseFromResult.getModelAttrsOrBuilderList());
  }

  /**
   * Test {@link ImportModelJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ImportModelJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ImportModelJob#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ImportModelJob.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ImportModelJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ImportModelJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ImportModelJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ImportModelJob.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ImportModelJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    ImportModelJob actualParseFromResult = ImportModelJob.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link ImportModelJob#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ImportModelJob actualParseFromResult = ImportModelJob.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link ImportModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ImportModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ImportModelJob actualParseDelimitedFromResult = ImportModelJob.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getEntryPoint());
    assertEquals("", actualParseDelimitedFromResult.getLanguage());
    assertEquals("", actualParseDelimitedFromResult.getPackage());
    assertEquals("", actualParseDelimitedFromResult.getPackageGroup());
    assertEquals("", actualParseDelimitedFromResult.getPath());
    assertEquals("", actualParseDelimitedFromResult.getRepository());
    assertEquals("", actualParseDelimitedFromResult.getVersion());
    assertEquals(0, actualParseDelimitedFromResult.getModelAttrsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.hasPackageGroup());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualParseDelimitedFromResult.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(modelAttrsList, actualParseDelimitedFromResult.getModelAttrsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ImportModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ImportModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ImportModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ImportModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ImportModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ImportModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ImportModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ImportModelJob.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportModelJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ImportModelJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportModelJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ImportModelJob actualParseDelimitedFromResult = ImportModelJob.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getEntryPoint());
    assertEquals("", actualParseDelimitedFromResult.getLanguage());
    assertEquals("", actualParseDelimitedFromResult.getPackage());
    assertEquals("", actualParseDelimitedFromResult.getPackageGroup());
    assertEquals("", actualParseDelimitedFromResult.getPath());
    assertEquals("", actualParseDelimitedFromResult.getRepository());
    assertEquals("", actualParseDelimitedFromResult.getVersion());
    assertEquals(0, actualParseDelimitedFromResult.getModelAttrsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.hasPackageGroup());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualParseDelimitedFromResult.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(modelAttrsList, actualParseDelimitedFromResult.getModelAttrsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ImportModelJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ImportModelJob.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ImportModelJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImportModelJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportModelJob#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportModelJob#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ImportModelJob.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ImportModelJob#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ImportModelJob#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob ImportModelJob.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    ImportModelJob defaultInstance = ImportModelJob.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}
