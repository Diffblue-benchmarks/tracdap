package org.finos.tracdap.metadata;

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
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TagSelectorDiffblueTest {
  /**
   * Method under test: {@link TagSelector#getObjectCriteriaCase()}
   */
  @Test
  void testGetObjectCriteriaCase() {
    // Arrange, Act and Assert
    assertEquals(TagSelector.ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET,
        TagSelector.getDefaultInstance().getObjectCriteriaCase());
  }

  /**
   * Method under test: {@link TagSelector#getTagCriteriaCase()}
   */
  @Test
  void testGetTagCriteriaCase() {
    // Arrange, Act and Assert
    assertEquals(TagSelector.TagCriteriaCase.TAGCRITERIA_NOT_SET,
        TagSelector.getDefaultInstance().getTagCriteriaCase());
  }

  /**
   * Method under test: {@link TagSelector#getObjectType()}
   */
  @Test
  void testGetObjectType() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, TagSelector.getDefaultInstance().getObjectType());
  }

  /**
   * Method under test: {@link TagSelector#getObjectId()}
   */
  @Test
  void testGetObjectId() {
    // Arrange, Act and Assert
    assertEquals("", TagSelector.getDefaultInstance().getObjectId());
  }

  /**
   * Method under test: {@link TagSelector#getObjectIdBytes()}
   */
  @Test
  void testGetObjectIdBytes() {
    // Arrange
    TagSelector defaultInstance = TagSelector.getDefaultInstance();

    // Act
    ByteString actualObjectIdBytes = defaultInstance.getObjectIdBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    ByteString byteString = actualObjectIdBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(6).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(7).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, actualObjectIdBytes);
  }

  /**
   * Method under test: {@link TagSelector#hasLatestObject()}
   */
  @Test
  void testHasLatestObject() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasLatestObject());
  }

  /**
   * Method under test: {@link TagSelector#getLatestObject()}
   */
  @Test
  void testGetLatestObject() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().getLatestObject());
  }

  /**
   * Method under test: {@link TagSelector#hasObjectVersion()}
   */
  @Test
  void testHasObjectVersion() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasObjectVersion());
  }

  /**
   * Method under test: {@link TagSelector#getObjectVersion()}
   */
  @Test
  void testGetObjectVersion() {
    // Arrange, Act and Assert
    assertEquals(0, TagSelector.getDefaultInstance().getObjectVersion());
  }

  /**
   * Method under test: {@link TagSelector#hasObjectAsOf()}
   */
  @Test
  void testHasObjectAsOf() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasObjectAsOf());
  }

  /**
   * Method under test: {@link TagSelector#hasLatestTag()}
   */
  @Test
  void testHasLatestTag() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasLatestTag());
  }

  /**
   * Method under test: {@link TagSelector#getLatestTag()}
   */
  @Test
  void testGetLatestTag() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().getLatestTag());
  }

  /**
   * Method under test: {@link TagSelector#hasTagVersion()}
   */
  @Test
  void testHasTagVersion() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasTagVersion());
  }

  /**
   * Method under test: {@link TagSelector#getTagVersion()}
   */
  @Test
  void testGetTagVersion() {
    // Arrange, Act and Assert
    assertEquals(0, TagSelector.getDefaultInstance().getTagVersion());
  }

  /**
   * Method under test: {@link TagSelector#hasTagAsOf()}
   */
  @Test
  void testHasTagAsOf() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasTagAsOf());
  }

  /**
   * Method under test: {@link TagSelector#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TagSelector.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link TagSelector#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TagSelector.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TagSelector#equals(Object)}
   *   <li>{@link TagSelector#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TagSelector defaultInstance = TagSelector.getDefaultInstance();
    TagSelector defaultInstance2 = TagSelector.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TagSelector#equals(Object)}
   *   <li>{@link TagSelector#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TagSelector defaultInstance = TagSelector.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TagSelector.ObjectCriteriaCase#forNumber(int)}
   */
  @Test
  void testObjectCriteriaCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(TagSelector.ObjectCriteriaCase.forNumber(42));
    assertEquals(TagSelector.ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, TagSelector.ObjectCriteriaCase.forNumber(0));
    assertEquals(TagSelector.ObjectCriteriaCase.LATESTOBJECT, TagSelector.ObjectCriteriaCase.forNumber(3));
    assertEquals(TagSelector.ObjectCriteriaCase.OBJECTVERSION, TagSelector.ObjectCriteriaCase.forNumber(4));
    assertEquals(TagSelector.ObjectCriteriaCase.OBJECTASOF, TagSelector.ObjectCriteriaCase.forNumber(5));
  }

  /**
   * Method under test: {@link TagSelector.ObjectCriteriaCase#getNumber()}
   */
  @Test
  void testObjectCriteriaCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, TagSelector.ObjectCriteriaCase.valueOf("LATESTOBJECT").getNumber());
  }

  /**
   * Method under test: {@link TagSelector.ObjectCriteriaCase#valueOf(int)}
   */
  @Test
  void testObjectCriteriaCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(TagSelector.ObjectCriteriaCase.valueOf(42));
    assertEquals(TagSelector.ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, TagSelector.ObjectCriteriaCase.valueOf(0));
    assertEquals(TagSelector.ObjectCriteriaCase.LATESTOBJECT, TagSelector.ObjectCriteriaCase.valueOf(3));
    assertEquals(TagSelector.ObjectCriteriaCase.OBJECTVERSION, TagSelector.ObjectCriteriaCase.valueOf(4));
    assertEquals(TagSelector.ObjectCriteriaCase.OBJECTASOF, TagSelector.ObjectCriteriaCase.valueOf(5));
  }

  /**
   * Method under test: {@link TagSelector#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TagSelector.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link TagSelector#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TagSelector.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TagSelector#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TagSelector.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TagSelector#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TagSelector.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TagSelector.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TagSelector.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TagSelector.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TagSelector.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TagSelector.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TagSelector.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> TagSelector.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TagSelector.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link TagSelector#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    TagSelector defaultInstance = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TagSelector#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TagSelector.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TagSelector#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TagSelector.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TagSelector#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TagSelector.getDefaultInstance(), "Different type to TagSelector");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TagSelector#getDefaultInstance()}
   *   <li>{@link TagSelector#getDescriptor()}
   *   <li>{@link TagSelector#newBuilder()}
   *   <li>{@link TagSelector#newBuilder(TagSelector)}
   *   <li>{@link TagSelector#newBuilderForType()}
   *   <li>{@link TagSelector#toBuilder()}
   *   <li>{@link TagSelector#getObjectAsOfOrBuilder()}
   *   <li>{@link TagSelector#getObjectTypeValue()}
   *   <li>{@link TagSelector#getParserForType()}
   *   <li>{@link TagSelector#getTagAsOfOrBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TagSelector actualDefaultInstance = TagSelector.getDefaultInstance();
    TagSelector actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    TagSelector prototype = TagSelector.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    DatetimeValueOrBuilder actualObjectAsOfOrBuilder = actualDefaultInstance.getObjectAsOfOrBuilder();
    int actualObjectTypeValue = actualDefaultInstance.getObjectTypeValue();
    actualDefaultInstance.getParserForType();
    DatetimeValueOrBuilder actualTagAsOfOrBuilder = actualDefaultInstance.getTagAsOfOrBuilder();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualObjectTypeValue);
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    DatetimeValue objectAsOf = actualDefaultInstance.getObjectAsOf();
    assertSame(objectAsOf, actualObjectAsOfOrBuilder);
    assertSame(objectAsOf, actualTagAsOfOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }

  /**
   * Method under test: {@link TagSelector.TagCriteriaCase#forNumber(int)}
   */
  @Test
  void testTagCriteriaCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(TagSelector.TagCriteriaCase.forNumber(42));
    assertEquals(TagSelector.TagCriteriaCase.TAGCRITERIA_NOT_SET, TagSelector.TagCriteriaCase.forNumber(0));
    assertEquals(TagSelector.TagCriteriaCase.LATESTTAG, TagSelector.TagCriteriaCase.forNumber(6));
    assertEquals(TagSelector.TagCriteriaCase.TAGVERSION, TagSelector.TagCriteriaCase.forNumber(7));
    assertEquals(TagSelector.TagCriteriaCase.TAGASOF, TagSelector.TagCriteriaCase.forNumber(8));
  }

  /**
   * Method under test: {@link TagSelector.TagCriteriaCase#getNumber()}
   */
  @Test
  void testTagCriteriaCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(6, TagSelector.TagCriteriaCase.valueOf("LATESTTAG").getNumber());
  }

  /**
   * Method under test: {@link TagSelector.TagCriteriaCase#valueOf(int)}
   */
  @Test
  void testTagCriteriaCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(TagSelector.TagCriteriaCase.valueOf(42));
    assertEquals(TagSelector.TagCriteriaCase.TAGCRITERIA_NOT_SET, TagSelector.TagCriteriaCase.valueOf(0));
    assertEquals(TagSelector.TagCriteriaCase.LATESTTAG, TagSelector.TagCriteriaCase.valueOf(6));
    assertEquals(TagSelector.TagCriteriaCase.TAGVERSION, TagSelector.TagCriteriaCase.valueOf(7));
    assertEquals(TagSelector.TagCriteriaCase.TAGASOF, TagSelector.TagCriteriaCase.valueOf(8));
  }
}
