package org.finos.tracdap.api;

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
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectDefinition.DefinitionCase;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.TagSelector.ObjectCriteriaCase;
import org.finos.tracdap.metadata.TagSelector.TagCriteriaCase;
import org.finos.tracdap.metadata.TagUpdate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataWriteRequestDiffblueTest {
  /**
   * Test {@link MetadataWriteRequest#getTenant()}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#getTenant()}
   */
  @Test
  @DisplayName("Test getTenant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MetadataWriteRequest.getTenant()"})
  void testGetTenant() {
    // Arrange, Act and Assert
    assertEquals("", MetadataWriteRequest.getDefaultInstance().getTenant());
  }

  /**
   * Test {@link MetadataWriteRequest#getTenantBytes()}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#getTenantBytes()}
   */
  @Test
  @DisplayName("Test getTenantBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString MetadataWriteRequest.getTenantBytes()"})
  void testGetTenantBytes() {
    // Arrange
    MetadataWriteRequest defaultInstance = MetadataWriteRequest.getDefaultInstance();

    // Act
    ByteString actualTenantBytes = defaultInstance.getTenantBytes();

    // Assert
    ByteString byteString = actualTenantBytes.EMPTY;
    assertEquals(byteString, actualTenantBytes);
    assertEquals(byteString, defaultInstance.getPriorVersion().getObjectIdBytes());
  }

  /**
   * Test {@link MetadataWriteRequest#getObjectType()}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#getObjectType()}
   */
  @Test
  @DisplayName("Test getObjectType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType MetadataWriteRequest.getObjectType()"})
  void testGetObjectType() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, MetadataWriteRequest.getDefaultInstance().getObjectType());
  }

  /**
   * Test {@link MetadataWriteRequest#hasPriorVersion()}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#hasPriorVersion()}
   */
  @Test
  @DisplayName("Test hasPriorVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteRequest.hasPriorVersion()"})
  void testHasPriorVersion() {
    // Arrange, Act and Assert
    assertFalse(MetadataWriteRequest.getDefaultInstance().hasPriorVersion());
  }

  /**
   * Test {@link MetadataWriteRequest#getPriorVersion()}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#getPriorVersion()}
   */
  @Test
  @DisplayName("Test getPriorVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector MetadataWriteRequest.getPriorVersion()"})
  void testGetPriorVersion() {
    // Arrange and Act
    TagSelector actualPriorVersion = MetadataWriteRequest.getDefaultInstance().getPriorVersion();

    // Assert
    assertEquals("", actualPriorVersion.getInitializationErrorString());
    assertEquals("", actualPriorVersion.getObjectId());
    assertEquals(0, actualPriorVersion.getObjectTypeValue());
    assertEquals(0, actualPriorVersion.getObjectVersion());
    assertEquals(0, actualPriorVersion.getSerializedSize());
    assertEquals(0, actualPriorVersion.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualPriorVersion.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualPriorVersion.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualPriorVersion.getTagCriteriaCase());
    assertFalse(actualPriorVersion.getLatestObject());
    assertFalse(actualPriorVersion.getLatestTag());
    assertFalse(actualPriorVersion.hasLatestObject());
    assertFalse(actualPriorVersion.hasLatestTag());
    assertFalse(actualPriorVersion.hasObjectAsOf());
    assertFalse(actualPriorVersion.hasObjectVersion());
    assertFalse(actualPriorVersion.hasTagAsOf());
    assertFalse(actualPriorVersion.hasTagVersion());
    assertTrue(actualPriorVersion.findInitializationErrors().isEmpty());
    assertTrue(actualPriorVersion.getAllFields().isEmpty());
    assertTrue(actualPriorVersion.isInitialized());
    assertSame(actualPriorVersion, actualPriorVersion.getDefaultInstanceForType());
  }

  /**
   * Test {@link MetadataWriteRequest#hasDefinition()}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#hasDefinition()}
   */
  @Test
  @DisplayName("Test hasDefinition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteRequest.hasDefinition()"})
  void testHasDefinition() {
    // Arrange, Act and Assert
    assertFalse(MetadataWriteRequest.getDefaultInstance().hasDefinition());
  }

  /**
   * Test {@link MetadataWriteRequest#getDefinition()}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#getDefinition()}
   */
  @Test
  @DisplayName("Test getDefinition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition MetadataWriteRequest.getDefinition()"})
  void testGetDefinition() {
    // Arrange and Act
    ObjectDefinition actualDefinition = MetadataWriteRequest.getDefaultInstance().getDefinition();

    // Assert
    assertEquals("", actualDefinition.getInitializationErrorString());
    assertEquals(0, actualDefinition.getObjectPropsCount());
    assertEquals(0, actualDefinition.getObjectTypeValue());
    assertEquals(0, actualDefinition.getSerializedSize());
    assertEquals(DefinitionCase.DEFINITION_NOT_SET, actualDefinition.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualDefinition.getObjectType());
    assertFalse(actualDefinition.hasCustom());
    assertFalse(actualDefinition.hasData());
    assertFalse(actualDefinition.hasFile());
    assertFalse(actualDefinition.hasFlow());
    assertFalse(actualDefinition.hasJob());
    assertFalse(actualDefinition.hasModel());
    assertFalse(actualDefinition.hasResult());
    assertFalse(actualDefinition.hasSchema());
    assertFalse(actualDefinition.hasStorage());
    assertTrue(actualDefinition.findInitializationErrors().isEmpty());
    assertTrue(actualDefinition.getAllFields().isEmpty());
    assertTrue(actualDefinition.getObjectProps().isEmpty());
    assertTrue(actualDefinition.getObjectPropsMap().isEmpty());
    assertTrue(actualDefinition.isInitialized());
    assertSame(actualDefinition, actualDefinition.getDefaultInstanceForType());
  }

  /**
   * Test {@link MetadataWriteRequest#getTagUpdatesCount()}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#getTagUpdatesCount()}
   */
  @Test
  @DisplayName("Test getTagUpdatesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataWriteRequest.getTagUpdatesCount()"})
  void testGetTagUpdatesCount() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteRequest.getDefaultInstance().getTagUpdatesCount());
  }

  /**
   * Test {@link MetadataWriteRequest#isInitialized()}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteRequest.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MetadataWriteRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link MetadataWriteRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetadataWriteRequest.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MetadataWriteRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link MetadataWriteRequest#equals(Object)}, and {@link MetadataWriteRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteRequest#equals(Object)}
   *   <li>{@link MetadataWriteRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteRequest.equals(Object)", "int MetadataWriteRequest.hashCode()"})
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
   * Test {@link MetadataWriteRequest#equals(Object)}, and {@link MetadataWriteRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataWriteRequest#equals(Object)}
   *   <li>{@link MetadataWriteRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteRequest.equals(Object)", "int MetadataWriteRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MetadataWriteRequest defaultInstance = MetadataWriteRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link MetadataWriteRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteRequest.equals(Object)", "int MetadataWriteRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteRequest.getDefaultInstance(), 1);
  }

  /**
   * Test {@link MetadataWriteRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteRequest.equals(Object)", "int MetadataWriteRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteRequest.getDefaultInstance(), null);
  }

  /**
   * Test {@link MetadataWriteRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetadataWriteRequest.equals(Object)", "int MetadataWriteRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetadataWriteRequest.getDefaultInstance(), "Different type to MetadataWriteRequest");
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    MetadataWriteRequest actualParseFromResult = MetadataWriteRequest.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    MetadataWriteRequest actualParseFromResult = MetadataWriteRequest.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    MetadataWriteRequest actualParseFromResult = MetadataWriteRequest.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    MetadataWriteRequest actualParseFromResult = MetadataWriteRequest.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedTenantBytes = data.EMPTY;
    assertEquals(expectedTenantBytes, actualParseFromResult.getTenantBytes());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(ByteString)"})
  void testParseFromWithByteString_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    MetadataWriteRequest actualParseFromResult = MetadataWriteRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedTenantBytes = data.EMPTY;
    assertEquals(expectedTenantBytes, actualParseFromResult.getTenantBytes());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    MetadataWriteRequest actualParseFromResult = MetadataWriteRequest.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    MetadataWriteRequest actualParseFromResult = MetadataWriteRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    MetadataWriteRequest actualParseFromResult = MetadataWriteRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    MetadataWriteRequest actualParseFromResult = MetadataWriteRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertFalse(actualParseFromResult.hasDefinition());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test {@link MetadataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetadataWriteRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MetadataWriteRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetadataWriteRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    MetadataWriteRequest actualParseFromResult = MetadataWriteRequest.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link MetadataWriteRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    MetadataWriteRequest actualParseFromResult = MetadataWriteRequest.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
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
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
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
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        MetadataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MetadataWriteRequest actualParseDelimitedFromResult = MetadataWriteRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
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
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
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
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetadataWriteRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, MetadataWriteRequest.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MetadataWriteRequest actualParseDelimitedFromResult = MetadataWriteRequest.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
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
   * Test {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
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
   * Test {@link MetadataWriteRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link MetadataWriteRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataWriteRequest.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    MetadataWriteRequest defaultInstance = MetadataWriteRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}
