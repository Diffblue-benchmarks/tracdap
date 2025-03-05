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
import java.util.List;
import org.finos.tracdap.metadata.DataDefinition.Delta;
import org.finos.tracdap.metadata.DataDefinition.Part;
import org.finos.tracdap.metadata.DataDefinition.SchemaSpecifierCase;
import org.finos.tracdap.metadata.DataDefinition.Snap;
import org.finos.tracdap.metadata.SchemaDefinition.SchemaDetailsCase;
import org.finos.tracdap.metadata.TagSelector.ObjectCriteriaCase;
import org.finos.tracdap.metadata.TagSelector.TagCriteriaCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataDefinitionDiffblueTest {
  /**
   * Test Delta {@link Delta#equals(Object)}, and {@link Delta#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Delta#equals(Object)}
   *   <li>{@link Delta#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Delta equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Delta.equals(Object)", "int Delta.hashCode()"})
  void testDeltaEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Delta defaultInstance = Delta.getDefaultInstance();
    Delta defaultInstance2 = Delta.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Delta {@link Delta#equals(Object)}, and {@link Delta#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Delta#equals(Object)}
   *   <li>{@link Delta#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Delta equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Delta.equals(Object)", "int Delta.hashCode()"})
  void testDeltaEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Delta defaultInstance = Delta.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Delta {@link Delta#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#equals(Object)}
   */
  @Test
  @DisplayName("Test Delta equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Delta.equals(Object)", "int Delta.hashCode()"})
  void testDeltaEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Delta.getDefaultInstance(), 1);
  }

  /**
   * Test Delta {@link Delta#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#equals(Object)}
   */
  @Test
  @DisplayName("Test Delta equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Delta.equals(Object)", "int Delta.hashCode()"})
  void testDeltaEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Delta.getDefaultInstance(), null);
  }

  /**
   * Test Delta {@link Delta#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#equals(Object)}
   */
  @Test
  @DisplayName("Test Delta equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Delta.equals(Object)", "int Delta.hashCode()"})
  void testDeltaEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Delta.getDefaultInstance(), "Different type to Delta");
  }

  /**
   * Test Delta {@link Delta#getDataItem()}.
   * <p>
   * Method under test: {@link Delta#getDataItem()}
   */
  @Test
  @DisplayName("Test Delta getDataItem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Delta.getDataItem()"})
  void testDeltaGetDataItem() {
    // Arrange, Act and Assert
    assertEquals("", Delta.getDefaultInstance().getDataItem());
  }

  /**
   * Test Delta {@link Delta#getDataItemBytes()}.
   * <p>
   * Method under test: {@link Delta#getDataItemBytes()}
   */
  @Test
  @DisplayName("Test Delta getDataItemBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString Delta.getDataItemBytes()"})
  void testDeltaGetDataItemBytes() {
    // Arrange
    Delta defaultInstance = Delta.getDefaultInstance();

    // Act
    ByteString actualDataItemBytes = defaultInstance.getDataItemBytes();

    // Assert
    ByteString byteString = actualDataItemBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getJavaOuterClassnameBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDataItemBytes);
  }

  /**
   * Test Delta {@link Delta#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link Delta#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Delta getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.getDefaultInstanceForType()"})
  void testDeltaGetDefaultInstanceForType() {
    // Arrange
    Delta defaultInstance = Delta.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Delta {@link Delta#getSerializedSize()}.
   * <p>
   * Method under test: {@link Delta#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Delta getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Delta.getSerializedSize()"})
  void testDeltaGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Delta.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Delta {@link Delta#isInitialized()}.
   * <p>
   * Method under test: {@link Delta#isInitialized()}
   */
  @Test
  @DisplayName("Test Delta isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Delta.isInitialized()"})
  void testDeltaIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Delta.getDefaultInstance().isInitialized());
  }

  /**
   * Test Delta {@link Delta#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Delta#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Delta parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseDelimitedFrom(InputStream)"})
  void testDeltaParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Delta actualParseDelimitedFromResult = Delta.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getDataItem());
    assertEquals(0, actualParseDelimitedFromResult.getDeltaIndex());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Delta {@link Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testDeltaParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Delta actualParseDelimitedFromResult = Delta.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getDataItem());
    assertEquals(0, actualParseDelimitedFromResult.getDeltaIndex());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Delta {@link Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testDeltaParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Delta.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Delta {@link Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testDeltaParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Delta.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Delta {@link Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testDeltaParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Delta.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Delta {@link Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testDeltaParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Delta.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Delta {@link Delta#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Delta parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseDelimitedFrom(InputStream)"})
  void testDeltaParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Delta.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Delta {@link Delta#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Delta parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseDelimitedFrom(InputStream)"})
  void testDeltaParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Delta.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Delta {@link Delta#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Delta parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseDelimitedFrom(InputStream)"})
  void testDeltaParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Delta.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Delta {@link Delta#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Delta parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseDelimitedFrom(InputStream)"})
  void testDeltaParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Delta.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Delta {@link Delta#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link Delta#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(ByteBuffer)"})
  void testDeltaParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    Delta actualParseFromResult = Delta.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDataItem());
    assertEquals(0, actualParseFromResult.getDeltaIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Delta {@link Delta#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Delta#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testDeltaParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Delta actualParseFromResult = Delta.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDataItem());
    assertEquals(0, actualParseFromResult.getDeltaIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Delta {@link Delta#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Delta#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(byte[], ExtensionRegistryLite)"})
  void testDeltaParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    Delta actualParseFromResult = Delta.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDataItem());
    assertEquals(0, actualParseFromResult.getDeltaIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Delta {@link Delta#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link Delta#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(ByteString)"})
  void testDeltaParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Delta actualParseFromResult = Delta.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDataItem());
    assertEquals(0, actualParseFromResult.getDeltaIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDataItemBytes = data.EMPTY;
    assertEquals(expectedDataItemBytes, actualParseFromResult.getDataItemBytes());
  }

  /**
   * Test Delta {@link Delta#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Delta#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testDeltaParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Delta actualParseFromResult = Delta.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDataItem());
    assertEquals(0, actualParseFromResult.getDeltaIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDataItemBytes = data.EMPTY;
    assertEquals(expectedDataItemBytes, actualParseFromResult.getDataItemBytes());
  }

  /**
   * Test Delta {@link Delta#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Delta parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(byte[])"})
  void testDeltaParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Delta actualParseFromResult = Delta.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDataItem());
    assertEquals(0, actualParseFromResult.getDeltaIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Delta {@link Delta#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link Delta#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(CodedInputStream)"})
  void testDeltaParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Delta actualParseFromResult = Delta.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDataItem());
    assertEquals(0, actualParseFromResult.getDeltaIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Delta {@link Delta#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Delta#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testDeltaParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Delta actualParseFromResult = Delta.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDataItem());
    assertEquals(0, actualParseFromResult.getDeltaIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Delta {@link Delta#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Delta#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testDeltaParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Delta actualParseFromResult = Delta.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDataItem());
    assertEquals(0, actualParseFromResult.getDeltaIndex());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Delta {@link Delta#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Delta#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testDeltaParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Delta.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Delta {@link Delta#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testDeltaParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Delta.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Delta {@link Delta#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(InputStream)"})
  void testDeltaParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Delta.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Delta {@link Delta#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(InputStream)"})
  void testDeltaParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Delta.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Delta {@link Delta#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(InputStream)"})
  void testDeltaParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    Delta actualParseFromResult = Delta.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test Delta {@link Delta#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Delta#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Delta parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Delta Delta.parseFrom(InputStream)"})
  void testDeltaParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Delta actualParseFromResult = Delta.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataDefinition#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When {@link JobStatusCode#CANCELLED_VALUE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when CANCELLED_VALUE; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor DataDefinition.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenCancelled_value_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> DataDefinition.getDefaultInstance().internalGetMapFieldReflection(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link DataDefinition#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test internalGetMapFieldReflection(int); when three; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor DataDefinition.internalGetMapFieldReflection(int)"})
  void testInternalGetMapFieldReflection_whenThree_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = DataDefinition.getDefaultInstance()
        .internalGetMapFieldReflection(3);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test {@link DataDefinition#getSchemaSpecifierCase()}.
   * <p>
   * Method under test: {@link DataDefinition#getSchemaSpecifierCase()}
   */
  @Test
  @DisplayName("Test getSchemaSpecifierCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase DataDefinition.getSchemaSpecifierCase()"})
  void testGetSchemaSpecifierCase() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET,
        DataDefinition.getDefaultInstance().getSchemaSpecifierCase());
  }

  /**
   * Test {@link DataDefinition#hasSchemaId()}.
   * <p>
   * Method under test: {@link DataDefinition#hasSchemaId()}
   */
  @Test
  @DisplayName("Test hasSchemaId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataDefinition.hasSchemaId()"})
  void testHasSchemaId() {
    // Arrange, Act and Assert
    assertFalse(DataDefinition.getDefaultInstance().hasSchemaId());
  }

  /**
   * Test {@link DataDefinition#getSchemaId()}.
   * <p>
   * Method under test: {@link DataDefinition#getSchemaId()}
   */
  @Test
  @DisplayName("Test getSchemaId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector DataDefinition.getSchemaId()"})
  void testGetSchemaId() {
    // Arrange and Act
    TagSelector actualSchemaId = DataDefinition.getDefaultInstance().getSchemaId();

    // Assert
    assertEquals("", actualSchemaId.getInitializationErrorString());
    assertEquals("", actualSchemaId.getObjectId());
    assertEquals(0, actualSchemaId.getObjectTypeValue());
    assertEquals(0, actualSchemaId.getObjectVersion());
    assertEquals(0, actualSchemaId.getSerializedSize());
    assertEquals(0, actualSchemaId.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualSchemaId.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualSchemaId.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualSchemaId.getTagCriteriaCase());
    assertFalse(actualSchemaId.getLatestObject());
    assertFalse(actualSchemaId.getLatestTag());
    assertFalse(actualSchemaId.hasLatestObject());
    assertFalse(actualSchemaId.hasLatestTag());
    assertFalse(actualSchemaId.hasObjectAsOf());
    assertFalse(actualSchemaId.hasObjectVersion());
    assertFalse(actualSchemaId.hasTagAsOf());
    assertFalse(actualSchemaId.hasTagVersion());
    assertTrue(actualSchemaId.findInitializationErrors().isEmpty());
    assertTrue(actualSchemaId.getAllFields().isEmpty());
    assertTrue(actualSchemaId.isInitialized());
    assertSame(actualSchemaId, actualSchemaId.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataDefinition#hasSchema()}.
   * <p>
   * Method under test: {@link DataDefinition#hasSchema()}
   */
  @Test
  @DisplayName("Test hasSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataDefinition.hasSchema()"})
  void testHasSchema() {
    // Arrange, Act and Assert
    assertFalse(DataDefinition.getDefaultInstance().hasSchema());
  }

  /**
   * Test {@link DataDefinition#getSchema()}.
   * <p>
   * Method under test: {@link DataDefinition#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition DataDefinition.getSchema()"})
  void testGetSchema() {
    // Arrange and Act
    SchemaDefinition actualSchema = DataDefinition.getDefaultInstance().getSchema();

    // Assert
    assertEquals("", actualSchema.getInitializationErrorString());
    assertEquals(0, actualSchema.getPartTypeValue());
    assertEquals(0, actualSchema.getSchemaTypeValue());
    assertEquals(0, actualSchema.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualSchema.getPartType());
    assertEquals(SchemaDetailsCase.SCHEMADETAILS_NOT_SET, actualSchema.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, actualSchema.getSchemaType());
    assertFalse(actualSchema.hasStruct());
    assertFalse(actualSchema.hasTable());
    assertTrue(actualSchema.findInitializationErrors().isEmpty());
    assertTrue(actualSchema.getAllFields().isEmpty());
    assertTrue(actualSchema.isInitialized());
    assertSame(actualSchema, actualSchema.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataDefinition#getPartsCount()}.
   * <p>
   * Method under test: {@link DataDefinition#getPartsCount()}
   */
  @Test
  @DisplayName("Test getPartsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataDefinition.getPartsCount()"})
  void testGetPartsCount() {
    // Arrange, Act and Assert
    assertEquals(0, DataDefinition.getDefaultInstance().getPartsCount());
  }

  /**
   * Test {@link DataDefinition#containsParts(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#containsParts(String)}
   */
  @Test
  @DisplayName("Test containsParts(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataDefinition.containsParts(String)"})
  void testContainsParts_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DataDefinition.getDefaultInstance().containsParts("Key"));
  }

  /**
   * Test {@link DataDefinition#getParts()}.
   * <p>
   * Method under test: {@link DataDefinition#getParts()}
   */
  @Test
  @DisplayName("Test getParts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map DataDefinition.getParts()"})
  void testGetParts() {
    // Arrange, Act and Assert
    assertTrue(DataDefinition.getDefaultInstance().getParts().isEmpty());
  }

  /**
   * Test {@link DataDefinition#getPartsMap()}.
   * <p>
   * Method under test: {@link DataDefinition#getPartsMap()}
   */
  @Test
  @DisplayName("Test getPartsMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map DataDefinition.getPartsMap()"})
  void testGetPartsMap() {
    // Arrange, Act and Assert
    assertTrue(DataDefinition.getDefaultInstance().getPartsMap().isEmpty());
  }

  /**
   * Test {@link DataDefinition#getPartsOrDefault(String, Part)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#getPartsOrDefault(String, Part)}
   */
  @Test
  @DisplayName("Test getPartsOrDefault(String, Part); when 'Key'; then return DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part DataDefinition.getPartsOrDefault(String, Part)"})
  void testGetPartsOrDefault_whenKey_thenReturnDefaultInstance() {
    // Arrange
    DataDefinition defaultInstance = DataDefinition.getDefaultInstance();
    Part defaultValue = Part.getDefaultInstance();

    // Act and Assert
    assertSame(defaultValue, defaultInstance.getPartsOrDefault("Key", defaultValue));
  }

  /**
   * Test {@link DataDefinition#getPartsOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#getPartsOrThrow(String)}
   */
  @Test
  @DisplayName("Test getPartsOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part DataDefinition.getPartsOrThrow(String)"})
  void testGetPartsOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DataDefinition.getDefaultInstance().getPartsOrThrow("Key"));
  }

  /**
   * Test {@link DataDefinition#hasStorageId()}.
   * <p>
   * Method under test: {@link DataDefinition#hasStorageId()}
   */
  @Test
  @DisplayName("Test hasStorageId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataDefinition.hasStorageId()"})
  void testHasStorageId() {
    // Arrange, Act and Assert
    assertFalse(DataDefinition.getDefaultInstance().hasStorageId());
  }

  /**
   * Test {@link DataDefinition#getStorageId()}.
   * <p>
   * Method under test: {@link DataDefinition#getStorageId()}
   */
  @Test
  @DisplayName("Test getStorageId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector DataDefinition.getStorageId()"})
  void testGetStorageId() {
    // Arrange and Act
    TagSelector actualStorageId = DataDefinition.getDefaultInstance().getStorageId();

    // Assert
    assertEquals("", actualStorageId.getInitializationErrorString());
    assertEquals("", actualStorageId.getObjectId());
    assertEquals(0, actualStorageId.getObjectTypeValue());
    assertEquals(0, actualStorageId.getObjectVersion());
    assertEquals(0, actualStorageId.getSerializedSize());
    assertEquals(0, actualStorageId.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualStorageId.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualStorageId.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualStorageId.getTagCriteriaCase());
    assertFalse(actualStorageId.getLatestObject());
    assertFalse(actualStorageId.getLatestTag());
    assertFalse(actualStorageId.hasLatestObject());
    assertFalse(actualStorageId.hasLatestTag());
    assertFalse(actualStorageId.hasObjectAsOf());
    assertFalse(actualStorageId.hasObjectVersion());
    assertFalse(actualStorageId.hasTagAsOf());
    assertFalse(actualStorageId.hasTagVersion());
    assertTrue(actualStorageId.findInitializationErrors().isEmpty());
    assertTrue(actualStorageId.getAllFields().isEmpty());
    assertTrue(actualStorageId.isInitialized());
    assertSame(actualStorageId, actualStorageId.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataDefinition#isInitialized()}.
   * <p>
   * Method under test: {@link DataDefinition#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataDefinition.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DataDefinition.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link DataDefinition#getSerializedSize()}.
   * <p>
   * Method under test: {@link DataDefinition#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataDefinition.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DataDefinition.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link DataDefinition#equals(Object)}, and {@link DataDefinition#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition#equals(Object)}
   *   <li>{@link DataDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataDefinition.equals(Object)", "int DataDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataDefinition defaultInstance = DataDefinition.getDefaultInstance();
    DataDefinition defaultInstance2 = DataDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link DataDefinition#equals(Object)}, and {@link DataDefinition#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataDefinition#equals(Object)}
   *   <li>{@link DataDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataDefinition.equals(Object)", "int DataDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataDefinition defaultInstance = DataDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link DataDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataDefinition.equals(Object)", "int DataDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.getDefaultInstance(), 1);
  }

  /**
   * Test {@link DataDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataDefinition.equals(Object)", "int DataDefinition.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.getDefaultInstance(), null);
  }

  /**
   * Test {@link DataDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataDefinition.equals(Object)", "int DataDefinition.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataDefinition.getDefaultInstance(), "Different type to DataDefinition");
  }

  /**
   * Test {@link DataDefinition#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataDefinition#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    DataDefinition actualParseFromResult = DataDefinition.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, actualParseFromResult.getSchemaSpecifierCase());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasSchemaId());
    assertFalse(actualParseFromResult.hasStorageId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getParts().isEmpty());
    assertTrue(actualParseFromResult.getPartsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataDefinition#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    DataDefinition actualParseFromResult = DataDefinition.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, actualParseFromResult.getSchemaSpecifierCase());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasSchemaId());
    assertFalse(actualParseFromResult.hasStorageId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getParts().isEmpty());
    assertTrue(actualParseFromResult.getPartsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataDefinition#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataDefinition#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    DataDefinition actualParseFromResult = DataDefinition.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, actualParseFromResult.getSchemaSpecifierCase());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasSchemaId());
    assertFalse(actualParseFromResult.hasStorageId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getParts().isEmpty());
    assertTrue(actualParseFromResult.getPartsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataDefinition#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    DataDefinition actualParseFromResult = DataDefinition.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, actualParseFromResult.getSchemaSpecifierCase());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasSchemaId());
    assertFalse(actualParseFromResult.hasStorageId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getParts().isEmpty());
    assertTrue(actualParseFromResult.getPartsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    DataDefinition actualParseFromResult = DataDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPartsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, actualParseFromResult.getSchemaSpecifierCase());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasSchemaId());
    assertFalse(actualParseFromResult.hasStorageId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getParts().isEmpty());
    assertTrue(actualParseFromResult.getPartsMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DataDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DataDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DataDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DataDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    DataDefinition actualParseFromResult = DataDefinition.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    DataDefinition actualParseFromResult = DataDefinition.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        DataDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataDefinition actualParseDelimitedFromResult = DataDefinition.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> DataDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DataDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataDefinition.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, DataDefinition.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataDefinition actualParseDelimitedFromResult = DataDefinition.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> DataDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataDefinition#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link DataDefinition#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataDefinition DataDefinition.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    DataDefinition defaultInstance = DataDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#equals(Object)}, and {@link Part#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Part#equals(Object)}
   *   <li>{@link Part#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Part equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Part.equals(Object)", "int Part.hashCode()"})
  void testPartEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Part defaultInstance = Part.getDefaultInstance();
    Part defaultInstance2 = Part.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Part {@link Part#equals(Object)}, and {@link Part#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Part#equals(Object)}
   *   <li>{@link Part#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Part equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Part.equals(Object)", "int Part.hashCode()"})
  void testPartEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Part defaultInstance = Part.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Part {@link Part#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#equals(Object)}
   */
  @Test
  @DisplayName("Test Part equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Part.equals(Object)", "int Part.hashCode()"})
  void testPartEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Part.getDefaultInstance(), 1);
  }

  /**
   * Test Part {@link Part#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#equals(Object)}
   */
  @Test
  @DisplayName("Test Part equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Part.equals(Object)", "int Part.hashCode()"})
  void testPartEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Part.getDefaultInstance(), null);
  }

  /**
   * Test Part {@link Part#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#equals(Object)}
   */
  @Test
  @DisplayName("Test Part equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Part.equals(Object)", "int Part.hashCode()"})
  void testPartEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Part.getDefaultInstance(), "Different type to Part");
  }

  /**
   * Test Part {@link Part#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link Part#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Part getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.getDefaultInstanceForType()"})
  void testPartGetDefaultInstanceForType() {
    // Arrange
    Part defaultInstance = Part.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#getPartKey()}.
   * <p>
   * Method under test: {@link Part#getPartKey()}
   */
  @Test
  @DisplayName("Test Part getPartKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PartKey Part.getPartKey()"})
  void testPartGetPartKey() {
    // Arrange and Act
    PartKey actualPartKey = Part.getDefaultInstance().getPartKey();

    // Assert
    assertEquals("", actualPartKey.getInitializationErrorString());
    assertEquals("", actualPartKey.getOpaqueKey());
    assertEquals(0, actualPartKey.getPartTypeValue());
    assertEquals(0, actualPartKey.getPartValuesCount());
    assertEquals(0, actualPartKey.getSerializedSize());
    assertEquals(PartType.PART_ROOT, actualPartKey.getPartType());
    assertFalse(actualPartKey.hasPartRangeMax());
    assertFalse(actualPartKey.hasPartRangeMin());
    assertTrue(actualPartKey.findInitializationErrors().isEmpty());
    List<Value> partValuesList = actualPartKey.getPartValuesList();
    assertTrue(partValuesList.isEmpty());
    assertTrue(actualPartKey.getAllFields().isEmpty());
    assertTrue(actualPartKey.isInitialized());
    assertSame(actualPartKey, actualPartKey.getDefaultInstanceForType());
    assertSame(partValuesList, actualPartKey.getPartValuesOrBuilderList());
  }

  /**
   * Test Part {@link Part#getSerializedSize()}.
   * <p>
   * Method under test: {@link Part#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Part getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Part.getSerializedSize()"})
  void testPartGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Part.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Part {@link Part#getSnap()}.
   * <p>
   * Method under test: {@link Part#getSnap()}
   */
  @Test
  @DisplayName("Test Part getSnap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Part.getSnap()"})
  void testPartGetSnap() {
    // Arrange and Act
    Snap actualSnap = Part.getDefaultInstance().getSnap();

    // Assert
    assertEquals("", actualSnap.getInitializationErrorString());
    assertEquals(0, actualSnap.getDeltasCount());
    assertEquals(0, actualSnap.getSerializedSize());
    assertEquals(0, actualSnap.getSnapIndex());
    assertTrue(actualSnap.findInitializationErrors().isEmpty());
    List<Delta> deltasList = actualSnap.getDeltasList();
    assertTrue(deltasList.isEmpty());
    assertTrue(actualSnap.getAllFields().isEmpty());
    assertTrue(actualSnap.isInitialized());
    assertSame(actualSnap, actualSnap.getDefaultInstanceForType());
    assertSame(deltasList, actualSnap.getDeltasOrBuilderList());
  }

  /**
   * Test Part {@link Part#hasPartKey()}.
   * <p>
   * Method under test: {@link Part#hasPartKey()}
   */
  @Test
  @DisplayName("Test Part hasPartKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Part.hasPartKey()"})
  void testPartHasPartKey() {
    // Arrange, Act and Assert
    assertFalse(Part.getDefaultInstance().hasPartKey());
  }

  /**
   * Test Part {@link Part#hasSnap()}.
   * <p>
   * Method under test: {@link Part#hasSnap()}
   */
  @Test
  @DisplayName("Test Part hasSnap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Part.hasSnap()"})
  void testPartHasSnap() {
    // Arrange, Act and Assert
    assertFalse(Part.getDefaultInstance().hasSnap());
  }

  /**
   * Test Part {@link Part#isInitialized()}.
   * <p>
   * Method under test: {@link Part#isInitialized()}
   */
  @Test
  @DisplayName("Test Part isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Part.isInitialized()"})
  void testPartIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Part.getDefaultInstance().isInitialized());
  }

  /**
   * Test Part {@link Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPartParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, Part.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Part {@link Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPartParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Part actualParseDelimitedFromResult = Part.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Part {@link Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPartParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Part.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Part {@link Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPartParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Part.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Part {@link Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPartParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Part.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Part {@link Part#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Part parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseDelimitedFrom(InputStream)"})
  void testPartParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Part.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Part {@link Part#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Part parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseDelimitedFrom(InputStream)"})
  void testPartParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Part.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Part {@link Part#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Part parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseDelimitedFrom(InputStream)"})
  void testPartParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, Part.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Part {@link Part#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Part parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseDelimitedFrom(InputStream)"})
  void testPartParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Part actualParseDelimitedFromResult = Part.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Part {@link Part#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Part parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseDelimitedFrom(InputStream)"})
  void testPartParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Part.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Part {@link Part#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Part#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPartParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Part actualParseFromResult = Part.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPartKey());
    assertFalse(actualParseFromResult.hasSnap());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Part parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(ByteBuffer)"})
  void testPartParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Part actualParseFromResult = Part.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPartKey());
    assertFalse(actualParseFromResult.hasSnap());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Part#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPartParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    Part actualParseFromResult = Part.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPartKey());
    assertFalse(actualParseFromResult.hasSnap());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Part#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testPartParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Part actualParseFromResult = Part.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPartKey());
    assertFalse(actualParseFromResult.hasSnap());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Part parseFrom(ByteString) with 'ByteString'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(ByteString)"})
  void testPartParseFromWithByteString_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Part actualParseFromResult = Part.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPartKey());
    assertFalse(actualParseFromResult.hasSnap());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Part parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(byte[])"})
  void testPartParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Part actualParseFromResult = Part.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPartKey());
    assertFalse(actualParseFromResult.hasSnap());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link Part#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Part parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(CodedInputStream)"})
  void testPartParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Part actualParseFromResult = Part.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPartKey());
    assertFalse(actualParseFromResult.hasSnap());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Part#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testPartParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Part actualParseFromResult = Part.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPartKey());
    assertFalse(actualParseFromResult.hasSnap());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Part#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPartParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Part actualParseFromResult = Part.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasPartKey());
    assertFalse(actualParseFromResult.hasSnap());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Part#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPartParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Part.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Part {@link Part#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Part parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPartParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Part.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Part {@link Part#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Part parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(InputStream)"})
  void testPartParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Part.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Part {@link Part#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Part parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(InputStream)"})
  void testPartParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Part.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Part {@link Part#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Part parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(InputStream)"})
  void testPartParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    Part actualParseFromResult = Part.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    PartKey partKey = actualParseFromResult.getPartKey();
    assertSame(unknownFields, partKey.getUnknownFields());
    Snap snap = actualParseFromResult.getSnap();
    assertSame(unknownFields, snap.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(partKey, actualParseFromResult.getPartKeyOrBuilder());
    assertSame(partKey, partKey.getDefaultInstanceForType());
    assertSame(snap, actualParseFromResult.getSnapOrBuilder());
    assertSame(snap, snap.getDefaultInstanceForType());
  }

  /**
   * Test Part {@link Part#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Part#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Part parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Part Part.parseFrom(InputStream)"})
  void testPartParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Part actualParseFromResult = Part.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    PartKey partKey = actualParseFromResult.getPartKey();
    assertSame(unknownFields, partKey.getUnknownFields());
    Snap snap = actualParseFromResult.getSnap();
    assertSame(unknownFields, snap.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(partKey, actualParseFromResult.getPartKeyOrBuilder());
    assertSame(partKey, partKey.getDefaultInstanceForType());
    assertSame(snap, actualParseFromResult.getSnapOrBuilder());
    assertSame(snap, snap.getDefaultInstanceForType());
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.forNumber(int)"})
  void testSchemaSpecifierCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SchemaSpecifierCase.forNumber(42));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code SCHEMAID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase forNumber(int); when one; then return 'SCHEMAID'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.forNumber(int)"})
  void testSchemaSpecifierCaseForNumber_whenOne_thenReturnSchemaid() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMAID, SchemaSpecifierCase.forNumber(1));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase forNumber(int); when two; then return 'SCHEMA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.forNumber(int)"})
  void testSchemaSpecifierCaseForNumber_whenTwo_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMA, SchemaSpecifierCase.forNumber(2));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code SCHEMASPECIFIER_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase forNumber(int); when zero; then return 'SCHEMASPECIFIER_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.forNumber(int)"})
  void testSchemaSpecifierCaseForNumber_whenZero_thenReturnSchemaspecifierNotSet() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, SchemaSpecifierCase.forNumber(0));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#getNumber()}.
   * <p>
   * Method under test: {@link SchemaSpecifierCase#getNumber()}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SchemaSpecifierCase.getNumber()"})
  void testSchemaSpecifierCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, SchemaSpecifierCase.valueOf("SCHEMAID").getNumber());
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.valueOf(int)"})
  void testSchemaSpecifierCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SchemaSpecifierCase.valueOf(42));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code SCHEMAID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase valueOf(int) with 'value'; when one; then return 'SCHEMAID'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.valueOf(int)"})
  void testSchemaSpecifierCaseValueOfWithValue_whenOne_thenReturnSchemaid() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMAID, SchemaSpecifierCase.valueOf(1));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase valueOf(int) with 'value'; when two; then return 'SCHEMA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.valueOf(int)"})
  void testSchemaSpecifierCaseValueOfWithValue_whenTwo_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMA, SchemaSpecifierCase.valueOf(2));
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code SCHEMASPECIFIER_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase valueOf(int) with 'value'; when zero; then return 'SCHEMASPECIFIER_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.valueOf(int)"})
  void testSchemaSpecifierCaseValueOfWithValue_whenZero_thenReturnSchemaspecifierNotSet() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, SchemaSpecifierCase.valueOf(0));
  }

  /**
   * Test Snap {@link Snap#equals(Object)}, and {@link Snap#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Snap#equals(Object)}
   *   <li>{@link Snap#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Snap equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Snap.equals(Object)", "int Snap.hashCode()"})
  void testSnapEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Snap defaultInstance = Snap.getDefaultInstance();
    Snap defaultInstance2 = Snap.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Snap {@link Snap#equals(Object)}, and {@link Snap#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Snap#equals(Object)}
   *   <li>{@link Snap#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Snap equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Snap.equals(Object)", "int Snap.hashCode()"})
  void testSnapEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Snap defaultInstance = Snap.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Snap {@link Snap#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#equals(Object)}
   */
  @Test
  @DisplayName("Test Snap equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Snap.equals(Object)", "int Snap.hashCode()"})
  void testSnapEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Snap.getDefaultInstance(), 1);
  }

  /**
   * Test Snap {@link Snap#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#equals(Object)}
   */
  @Test
  @DisplayName("Test Snap equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Snap.equals(Object)", "int Snap.hashCode()"})
  void testSnapEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Snap.getDefaultInstance(), null);
  }

  /**
   * Test Snap {@link Snap#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#equals(Object)}
   */
  @Test
  @DisplayName("Test Snap equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Snap.equals(Object)", "int Snap.hashCode()"})
  void testSnapEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Snap.getDefaultInstance(), "Different type to Snap");
  }

  /**
   * Test Snap {@link Snap#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link Snap#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Snap getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.getDefaultInstanceForType()"})
  void testSnapGetDefaultInstanceForType() {
    // Arrange
    Snap defaultInstance = Snap.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Snap {@link Snap#getDeltasCount()}.
   * <p>
   * Method under test: {@link Snap#getDeltasCount()}
   */
  @Test
  @DisplayName("Test Snap getDeltasCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Snap.getDeltasCount()"})
  void testSnapGetDeltasCount() {
    // Arrange, Act and Assert
    assertEquals(0, Snap.getDefaultInstance().getDeltasCount());
  }

  /**
   * Test Snap {@link Snap#getSerializedSize()}.
   * <p>
   * Method under test: {@link Snap#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Snap getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Snap.getSerializedSize()"})
  void testSnapGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Snap.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Snap {@link Snap#isInitialized()}.
   * <p>
   * Method under test: {@link Snap#isInitialized()}
   */
  @Test
  @DisplayName("Test Snap isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Snap.isInitialized()"})
  void testSnapIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Snap.getDefaultInstance().isInitialized());
  }

  /**
   * Test Snap {@link Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Snap parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testSnapParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Snap actualParseDelimitedFromResult = Snap.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertFalse(unknownFields.isEmpty());
    assertSame(actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Snap {@link Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Snap parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testSnapParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Snap actualParseDelimitedFromResult = Snap.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Snap {@link Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Snap parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testSnapParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Snap.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Snap {@link Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Snap parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testSnapParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Snap.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Snap {@link Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Snap parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testSnapParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Snap.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Snap {@link Snap#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Snap parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseDelimitedFrom(InputStream)"})
  void testSnapParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Snap.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Snap {@link Snap#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Snap parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseDelimitedFrom(InputStream)"})
  void testSnapParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Snap.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Snap {@link Snap#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Snap parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseDelimitedFrom(InputStream)"})
  void testSnapParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Snap actualParseDelimitedFromResult = Snap.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertFalse(unknownFields.isEmpty());
    assertSame(actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Snap {@link Snap#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Snap parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseDelimitedFrom(InputStream)"})
  void testSnapParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Snap actualParseDelimitedFromResult = Snap.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Snap {@link Snap#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Snap parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseDelimitedFrom(InputStream)"})
  void testSnapParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Snap.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Snap {@link Snap#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Snap#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Snap parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testSnapParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Snap actualParseFromResult = Snap.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getDeltasCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSnapIndex());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Delta> deltasList = actualParseFromResult.getDeltasList();
    assertTrue(deltasList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(deltasList, actualParseFromResult.getDeltasOrBuilderList());
  }

  /**
   * Test Snap {@link Snap#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Snap parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseFrom(ByteBuffer)"})
  void testSnapParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Snap actualParseFromResult = Snap.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getDeltasCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSnapIndex());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Delta> deltasList = actualParseFromResult.getDeltasList();
    assertTrue(deltasList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(deltasList, actualParseFromResult.getDeltasOrBuilderList());
  }

  /**
   * Test Snap {@link Snap#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Snap#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Snap parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseFrom(byte[], ExtensionRegistryLite)"})
  void testSnapParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    Snap actualParseFromResult = Snap.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getDeltasCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSnapIndex());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Delta> deltasList = actualParseFromResult.getDeltasList();
    assertTrue(deltasList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(deltasList, actualParseFromResult.getDeltasOrBuilderList());
  }

  /**
   * Test Snap {@link Snap#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Snap parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseFrom(byte[])"})
  void testSnapParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Snap actualParseFromResult = Snap.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getDeltasCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSnapIndex());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Delta> deltasList = actualParseFromResult.getDeltasList();
    assertTrue(deltasList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(deltasList, actualParseFromResult.getDeltasOrBuilderList());
  }

  /**
   * Test Snap {@link Snap#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Snap#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Snap parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testSnapParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Snap actualParseFromResult = Snap.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getDeltasCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSnapIndex());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Delta> deltasList = actualParseFromResult.getDeltasList();
    assertTrue(deltasList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(deltasList, actualParseFromResult.getDeltasOrBuilderList());
  }

  /**
   * Test Snap {@link Snap#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Snap#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Snap parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testSnapParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Snap.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Snap {@link Snap#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Snap parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testSnapParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Snap.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Snap {@link Snap#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Snap parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseFrom(InputStream)"})
  void testSnapParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Snap.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Snap {@link Snap#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Snap parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseFrom(InputStream)"})
  void testSnapParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Snap.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Snap {@link Snap#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Snap parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseFrom(InputStream)"})
  void testSnapParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    Snap actualParseFromResult = Snap.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test Snap {@link Snap#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Snap#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Snap parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Snap Snap.parseFrom(InputStream)"})
  void testSnapParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Snap actualParseFromResult = Snap.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }
}
