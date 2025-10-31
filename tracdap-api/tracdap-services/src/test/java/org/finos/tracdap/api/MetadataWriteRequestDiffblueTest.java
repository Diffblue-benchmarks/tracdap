package org.finos.tracdap.api;

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
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.finos.tracdap.metadata.FlowEdge;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectDefinitionOrBuilder;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagSelectorOrBuilder;
import org.finos.tracdap.metadata.TagUpdate;
import org.finos.tracdap.metadata.TagUpdateOrBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataWriteRequestDiffblueTest {
  /**
   * Method under test: {@link MetadataWriteRequest#getTenant()}
   */
  @Test
  void testGetTenant() {
    // Arrange, Act and Assert
    assertEquals("", MetadataWriteRequest.getDefaultInstance().getTenant());
  }

  /**
   * Method under test: {@link MetadataWriteRequest#getTenantBytes()}
   */
  @Test
  void testGetTenantBytes() {
    // Arrange
    MetadataWriteRequest defaultInstance = MetadataWriteRequest.getDefaultInstance();

    // Act
    ByteString actualTenantBytes = defaultInstance.getTenantBytes();

    // Assert
    ByteString byteString = actualTenantBytes.EMPTY;
    assertEquals(byteString, actualTenantBytes);
    assertSame(byteString, defaultInstance.getDefinition().getCustom().getCustomData());
  }

  /**
   * Method under test: {@link MetadataWriteRequest#getObjectType()}
   */
  @Test
  void testGetObjectType() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, MetadataWriteRequest.getDefaultInstance().getObjectType());
  }

  /**
   * Method under test: {@link MetadataWriteRequest#hasPriorVersion()}
   */
  @Test
  void testHasPriorVersion() {
    // Arrange, Act and Assert
    assertFalse(MetadataWriteRequest.getDefaultInstance().hasPriorVersion());
  }

  /**
   * Method under test: {@link MetadataWriteRequest#hasDefinition()}
   */
  @Test
  void testHasDefinition() {
    // Arrange, Act and Assert
    assertFalse(MetadataWriteRequest.getDefaultInstance().hasDefinition());
  }

  /**
   * Method under test: {@link MetadataWriteRequest#getTagUpdatesCount()}
   */
  @Test
  void testGetTagUpdatesCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteRequest.getDefaultInstance().getTagUpdatesCount());
  }

  /**
   * Method under test: {@link MetadataWriteRequest#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MetadataWriteRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link MetadataWriteRequest#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteRequest#equals(Object)}
   *   <li>{@link MetadataWriteRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MetadataWriteRequest defaultInstance = MetadataWriteRequest.getDefaultInstance();
    MetadataWriteRequest defaultInstance2 = MetadataWriteRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteRequest#equals(Object)}
   *   <li>{@link MetadataWriteRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MetadataWriteRequest defaultInstance = MetadataWriteRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link MetadataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MetadataWriteRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link MetadataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetadataWriteRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetadataWriteRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetadataWriteRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataWriteRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MetadataWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetadataWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetadataWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetadataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetadataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> MetadataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link MetadataWriteRequest#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    MetadataWriteRequest defaultInstance = MetadataWriteRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MetadataWriteRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link MetadataWriteRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link MetadataWriteRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteRequest.getDefaultInstance(), "Different type to MetadataWriteRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteRequest#getDefaultInstance()}
   *   <li>{@link MetadataWriteRequest#getDescriptor()}
   *   <li>{@link MetadataWriteRequest#newBuilder()}
   *   <li>{@link MetadataWriteRequest#newBuilder(MetadataWriteRequest)}
   *   <li>{@link MetadataWriteRequest#newBuilderForType()}
   *   <li>{@link MetadataWriteRequest#toBuilder()}
   *   <li>{@link MetadataWriteRequest#getDefinitionOrBuilder()}
   *   <li>{@link MetadataWriteRequest#getObjectTypeValue()}
   *   <li>{@link MetadataWriteRequest#getParserForType()}
   *   <li>{@link MetadataWriteRequest#getPriorVersionOrBuilder()}
   *   <li>{@link MetadataWriteRequest#getTagUpdatesList()}
   *   <li>{@link MetadataWriteRequest#getTagUpdatesOrBuilderList()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MetadataWriteRequest actualDefaultInstance = MetadataWriteRequest.getDefaultInstance();
    MetadataWriteRequest actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    MetadataWriteRequest prototype = MetadataWriteRequest.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    ObjectDefinitionOrBuilder actualDefinitionOrBuilder = actualDefaultInstance.getDefinitionOrBuilder();
    int actualObjectTypeValue = actualDefaultInstance.getObjectTypeValue();
    actualDefaultInstance.getParserForType();
    TagSelectorOrBuilder actualPriorVersionOrBuilder = actualDefaultInstance.getPriorVersionOrBuilder();
    List<TagUpdate> actualTagUpdatesList = actualDefaultInstance.getTagUpdatesList();
    List<? extends TagUpdateOrBuilder> actualTagUpdatesOrBuilderList = actualDefaultInstance
        .getTagUpdatesOrBuilderList();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualObjectTypeValue);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    ObjectDefinition definition = actualDefaultInstance.getDefinition();
    assertSame(definition, actualDefinitionOrBuilder);
    assertSame(actualDefaultInstance.getPriorVersion(), actualPriorVersionOrBuilder);
    List<FlowEdge> edgesList = definition.getFlow().getEdgesList();
    assertSame(edgesList, actualTagUpdatesList);
    assertSame(edgesList, actualTagUpdatesOrBuilderList);
    assertSame(prototype, actualDefaultInstance2);
  }
}
