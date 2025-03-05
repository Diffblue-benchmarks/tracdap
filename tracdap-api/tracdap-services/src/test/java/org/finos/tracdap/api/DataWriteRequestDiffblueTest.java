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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.finos.tracdap.api.DataWriteRequest.SchemaSpecifierCase;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.PartType;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.finos.tracdap.metadata.SchemaDefinition.SchemaDetailsCase;
import org.finos.tracdap.metadata.SchemaType;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.TagSelector.ObjectCriteriaCase;
import org.finos.tracdap.metadata.TagSelector.TagCriteriaCase;
import org.finos.tracdap.metadata.TagUpdate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataWriteRequestDiffblueTest {
  /**
   * Test {@link DataWriteRequest#getSchemaSpecifierCase()}.
   * <p>
   * Method under test: {@link DataWriteRequest#getSchemaSpecifierCase()}
   */
  @Test
  @DisplayName("Test getSchemaSpecifierCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase DataWriteRequest.getSchemaSpecifierCase()"})
  void testGetSchemaSpecifierCase() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET,
        DataWriteRequest.getDefaultInstance().getSchemaSpecifierCase());
  }

  /**
   * Test {@link DataWriteRequest#getTenant()}.
   * <p>
   * Method under test: {@link DataWriteRequest#getTenant()}
   */
  @Test
  @DisplayName("Test getTenant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String DataWriteRequest.getTenant()"})
  void testGetTenant() {
    // Arrange, Act and Assert
    assertEquals("", DataWriteRequest.getDefaultInstance().getTenant());
  }

  /**
   * Test {@link DataWriteRequest#getTenantBytes()}.
   * <p>
   * Method under test: {@link DataWriteRequest#getTenantBytes()}
   */
  @Test
  @DisplayName("Test getTenantBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString DataWriteRequest.getTenantBytes()"})
  void testGetTenantBytes() {
    // Arrange
    DataWriteRequest defaultInstance = DataWriteRequest.getDefaultInstance();

    // Act
    ByteString actualTenantBytes = defaultInstance.getTenantBytes();

    // Assert
    ByteString byteString = actualTenantBytes.EMPTY;
    assertEquals(byteString, actualTenantBytes);
    assertSame(byteString, defaultInstance.getContent());
  }

  /**
   * Test {@link DataWriteRequest#hasPriorVersion()}.
   * <p>
   * Method under test: {@link DataWriteRequest#hasPriorVersion()}
   */
  @Test
  @DisplayName("Test hasPriorVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataWriteRequest.hasPriorVersion()"})
  void testHasPriorVersion() {
    // Arrange, Act and Assert
    assertFalse(DataWriteRequest.getDefaultInstance().hasPriorVersion());
  }

  /**
   * Test {@link DataWriteRequest#getPriorVersion()}.
   * <p>
   * Method under test: {@link DataWriteRequest#getPriorVersion()}
   */
  @Test
  @DisplayName("Test getPriorVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector DataWriteRequest.getPriorVersion()"})
  void testGetPriorVersion() {
    // Arrange and Act
    TagSelector actualPriorVersion = DataWriteRequest.getDefaultInstance().getPriorVersion();

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
   * Test {@link DataWriteRequest#getTagUpdatesCount()}.
   * <p>
   * Method under test: {@link DataWriteRequest#getTagUpdatesCount()}
   */
  @Test
  @DisplayName("Test getTagUpdatesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataWriteRequest.getTagUpdatesCount()"})
  void testGetTagUpdatesCount() {
    // Arrange, Act and Assert
    assertEquals(0, DataWriteRequest.getDefaultInstance().getTagUpdatesCount());
  }

  /**
   * Test {@link DataWriteRequest#hasSchemaId()}.
   * <p>
   * Method under test: {@link DataWriteRequest#hasSchemaId()}
   */
  @Test
  @DisplayName("Test hasSchemaId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataWriteRequest.hasSchemaId()"})
  void testHasSchemaId() {
    // Arrange, Act and Assert
    assertFalse(DataWriteRequest.getDefaultInstance().hasSchemaId());
  }

  /**
   * Test {@link DataWriteRequest#getSchemaId()}.
   * <p>
   * Method under test: {@link DataWriteRequest#getSchemaId()}
   */
  @Test
  @DisplayName("Test getSchemaId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector DataWriteRequest.getSchemaId()"})
  void testGetSchemaId() {
    // Arrange and Act
    TagSelector actualSchemaId = DataWriteRequest.getDefaultInstance().getSchemaId();

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
   * Test {@link DataWriteRequest#hasSchema()}.
   * <p>
   * Method under test: {@link DataWriteRequest#hasSchema()}
   */
  @Test
  @DisplayName("Test hasSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataWriteRequest.hasSchema()"})
  void testHasSchema() {
    // Arrange, Act and Assert
    assertFalse(DataWriteRequest.getDefaultInstance().hasSchema());
  }

  /**
   * Test {@link DataWriteRequest#getSchema()}.
   * <p>
   * Method under test: {@link DataWriteRequest#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaDefinition DataWriteRequest.getSchema()"})
  void testGetSchema() {
    // Arrange and Act
    SchemaDefinition actualSchema = DataWriteRequest.getDefaultInstance().getSchema();

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
   * Test {@link DataWriteRequest#getFormat()}.
   * <p>
   * Method under test: {@link DataWriteRequest#getFormat()}
   */
  @Test
  @DisplayName("Test getFormat()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String DataWriteRequest.getFormat()"})
  void testGetFormat() {
    // Arrange, Act and Assert
    assertEquals("", DataWriteRequest.getDefaultInstance().getFormat());
  }

  /**
   * Test {@link DataWriteRequest#getFormatBytes()}.
   * <p>
   * Method under test: {@link DataWriteRequest#getFormatBytes()}
   */
  @Test
  @DisplayName("Test getFormatBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString DataWriteRequest.getFormatBytes()"})
  void testGetFormatBytes() {
    // Arrange
    DataWriteRequest defaultInstance = DataWriteRequest.getDefaultInstance();

    // Act
    ByteString actualFormatBytes = defaultInstance.getFormatBytes();

    // Assert
    ByteString byteString = actualFormatBytes.EMPTY;
    assertEquals(byteString, actualFormatBytes);
    assertSame(byteString, defaultInstance.getContent());
  }

  /**
   * Test {@link DataWriteRequest#isInitialized()}.
   * <p>
   * Method under test: {@link DataWriteRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataWriteRequest.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DataWriteRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link DataWriteRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link DataWriteRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataWriteRequest.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DataWriteRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link DataWriteRequest#equals(Object)}, and {@link DataWriteRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataWriteRequest#equals(Object)}
   *   <li>{@link DataWriteRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataWriteRequest.equals(Object)", "int DataWriteRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataWriteRequest defaultInstance = DataWriteRequest.getDefaultInstance();
    DataWriteRequest defaultInstance2 = DataWriteRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link DataWriteRequest#equals(Object)}, and {@link DataWriteRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataWriteRequest#equals(Object)}
   *   <li>{@link DataWriteRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataWriteRequest.equals(Object)", "int DataWriteRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataWriteRequest defaultInstance = DataWriteRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link DataWriteRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataWriteRequest.equals(Object)", "int DataWriteRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataWriteRequest.getDefaultInstance(), 1);
  }

  /**
   * Test {@link DataWriteRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataWriteRequest.equals(Object)", "int DataWriteRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataWriteRequest.getDefaultInstance(), null);
  }

  /**
   * Test {@link DataWriteRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataWriteRequest.equals(Object)", "int DataWriteRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataWriteRequest.getDefaultInstance(), "Different type to DataWriteRequest");
  }

  /**
   * Test {@link DataWriteRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataWriteRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    DataWriteRequest actualParseFromResult = DataWriteRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormat());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, actualParseFromResult.getSchemaSpecifierCase());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasSchemaId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link DataWriteRequest#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    DataWriteRequest actualParseFromResult = DataWriteRequest.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormat());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, actualParseFromResult.getSchemaSpecifierCase());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasSchemaId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link DataWriteRequest#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataWriteRequest#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    DataWriteRequest actualParseFromResult = DataWriteRequest.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormat());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, actualParseFromResult.getSchemaSpecifierCase());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasSchemaId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link DataWriteRequest#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    DataWriteRequest actualParseFromResult = DataWriteRequest.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormat());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, actualParseFromResult.getSchemaSpecifierCase());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasSchemaId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link DataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    DataWriteRequest actualParseFromResult = DataWriteRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFormat());
    assertEquals("", actualParseFromResult.getTenant());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagUpdatesCount());
    assertEquals(SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, actualParseFromResult.getSchemaSpecifierCase());
    assertFalse(actualParseFromResult.hasPriorVersion());
    assertFalse(actualParseFromResult.hasSchema());
    assertFalse(actualParseFromResult.hasSchemaId());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualParseFromResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(tagUpdatesList, actualParseFromResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link DataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataWriteRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataWriteRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DataWriteRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataWriteRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DataWriteRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataWriteRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DataWriteRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    DataWriteRequest actualParseFromResult = DataWriteRequest.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataWriteRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    DataWriteRequest actualParseFromResult = DataWriteRequest.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        DataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataWriteRequest actualParseDelimitedFromResult = DataWriteRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataWriteRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DataWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataWriteRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, DataWriteRequest.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataWriteRequest actualParseDelimitedFromResult = DataWriteRequest.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DataWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataWriteRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataWriteRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataWriteRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DataWriteRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link DataWriteRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataWriteRequest DataWriteRequest.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    DataWriteRequest defaultInstance = DataWriteRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase forNumber(int); when five; then return 'SCHEMA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.forNumber(int)"})
  void testSchemaSpecifierCaseForNumber_whenFive_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMA, SchemaSpecifierCase.forNumber(5));
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
   *   <li>When four.</li>
   *   <li>Then return {@code SCHEMAID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase forNumber(int); when four; then return 'SCHEMAID'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.forNumber(int)"})
  void testSchemaSpecifierCaseForNumber_whenFour_thenReturnSchemaid() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMAID, SchemaSpecifierCase.forNumber(4));
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
    assertEquals(4, SchemaSpecifierCase.valueOf("SCHEMAID").getNumber());
  }

  /**
   * Test SchemaSpecifierCase {@link SchemaSpecifierCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase valueOf(int) with 'value'; when five; then return 'SCHEMA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.valueOf(int)"})
  void testSchemaSpecifierCaseValueOfWithValue_whenFive_thenReturnSchema() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMA, SchemaSpecifierCase.valueOf(5));
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
   *   <li>When four.</li>
   *   <li>Then return {@code SCHEMAID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaSpecifierCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test SchemaSpecifierCase valueOf(int) with 'value'; when four; then return 'SCHEMAID'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaSpecifierCase SchemaSpecifierCase.valueOf(int)"})
  void testSchemaSpecifierCaseValueOfWithValue_whenFour_thenReturnSchemaid() {
    // Arrange, Act and Assert
    assertEquals(SchemaSpecifierCase.SCHEMAID, SchemaSpecifierCase.valueOf(4));
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
}
