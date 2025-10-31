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
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.finos.tracdap.api.internal.RuntimeJobInfoRequest.JobCase;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.TagSelector.ObjectCriteriaCase;
import org.finos.tracdap.metadata.TagSelector.TagCriteriaCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RuntimeJobInfoRequestDiffblueTest {
  /**
   * Test {@link RuntimeJobInfoRequest#getJobCase()}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#getJobCase()}
   */
  @Test
  @DisplayName("Test getJobCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobCase RuntimeJobInfoRequest.getJobCase()"})
  void testGetJobCase() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOB_NOT_SET, RuntimeJobInfoRequest.getDefaultInstance().getJobCase());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#hasJobSelector()}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#hasJobSelector()}
   */
  @Test
  @DisplayName("Test hasJobSelector()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobInfoRequest.hasJobSelector()"})
  void testHasJobSelector() {
    // Arrange, Act and Assert
    assertFalse(RuntimeJobInfoRequest.getDefaultInstance().hasJobSelector());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#getJobSelector()}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#getJobSelector()}
   */
  @Test
  @DisplayName("Test getJobSelector()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector RuntimeJobInfoRequest.getJobSelector()"})
  void testGetJobSelector() {
    // Arrange and Act
    TagSelector actualJobSelector = RuntimeJobInfoRequest.getDefaultInstance().getJobSelector();

    // Assert
    assertEquals("", actualJobSelector.getInitializationErrorString());
    assertEquals("", actualJobSelector.getObjectId());
    assertEquals(0, actualJobSelector.getObjectTypeValue());
    assertEquals(0, actualJobSelector.getObjectVersion());
    assertEquals(0, actualJobSelector.getSerializedSize());
    assertEquals(0, actualJobSelector.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualJobSelector.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualJobSelector.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualJobSelector.getTagCriteriaCase());
    assertFalse(actualJobSelector.getLatestObject());
    assertFalse(actualJobSelector.getLatestTag());
    assertFalse(actualJobSelector.hasLatestObject());
    assertFalse(actualJobSelector.hasLatestTag());
    assertFalse(actualJobSelector.hasObjectAsOf());
    assertFalse(actualJobSelector.hasObjectVersion());
    assertFalse(actualJobSelector.hasTagAsOf());
    assertFalse(actualJobSelector.hasTagVersion());
    assertTrue(actualJobSelector.findInitializationErrors().isEmpty());
    assertTrue(actualJobSelector.getAllFields().isEmpty());
    assertTrue(actualJobSelector.isInitialized());
    assertSame(actualJobSelector, actualJobSelector.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#hasJobKey()}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#hasJobKey()}
   */
  @Test
  @DisplayName("Test hasJobKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobInfoRequest.hasJobKey()"})
  void testHasJobKey() {
    // Arrange, Act and Assert
    assertFalse(RuntimeJobInfoRequest.getDefaultInstance().hasJobKey());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#getJobKey()}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#getJobKey()}
   */
  @Test
  @DisplayName("Test getJobKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String RuntimeJobInfoRequest.getJobKey()"})
  void testGetJobKey() {
    // Arrange, Act and Assert
    assertEquals("", RuntimeJobInfoRequest.getDefaultInstance().getJobKey());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#getJobKeyBytes()}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#getJobKeyBytes()}
   */
  @Test
  @DisplayName("Test getJobKeyBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString RuntimeJobInfoRequest.getJobKeyBytes()"})
  void testGetJobKeyBytes() {
    // Arrange
    RuntimeJobInfoRequest defaultInstance = RuntimeJobInfoRequest.getDefaultInstance();

    // Act
    ByteString actualJobKeyBytes = defaultInstance.getJobKeyBytes();

    // Assert
    ByteString byteString = actualJobKeyBytes.EMPTY;
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
    assertEquals(byteString, actualJobKeyBytes);
    TagSelector jobSelector = defaultInstance.getJobSelector();
    assertEquals(byteString, jobSelector.getObjectAsOf().getIsoDatetimeBytes());
    assertEquals(byteString, jobSelector.getObjectIdBytes());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#isInitialized()}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobInfoRequest.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RuntimeJobInfoRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RuntimeJobInfoRequest.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RuntimeJobInfoRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#equals(Object)}, and {@link RuntimeJobInfoRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeJobInfoRequest#equals(Object)}
   *   <li>{@link RuntimeJobInfoRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobInfoRequest.equals(Object)", "int RuntimeJobInfoRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuntimeJobInfoRequest defaultInstance = RuntimeJobInfoRequest.getDefaultInstance();
    RuntimeJobInfoRequest defaultInstance2 = RuntimeJobInfoRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#equals(Object)}, and {@link RuntimeJobInfoRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuntimeJobInfoRequest#equals(Object)}
   *   <li>{@link RuntimeJobInfoRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobInfoRequest.equals(Object)", "int RuntimeJobInfoRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuntimeJobInfoRequest defaultInstance = RuntimeJobInfoRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobInfoRequest.equals(Object)", "int RuntimeJobInfoRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobInfoRequest.getDefaultInstance(), 1);
  }

  /**
   * Test {@link RuntimeJobInfoRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobInfoRequest.equals(Object)", "int RuntimeJobInfoRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobInfoRequest.getDefaultInstance(), null);
  }

  /**
   * Test {@link RuntimeJobInfoRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuntimeJobInfoRequest.equals(Object)", "int RuntimeJobInfoRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuntimeJobInfoRequest.getDefaultInstance(), "Different type to RuntimeJobInfoRequest");
  }

  /**
   * Test JobCase {@link JobCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobCase JobCase.forNumber(int)"})
  void testJobCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobCase.forNumber(42));
  }

  /**
   * Test JobCase {@link JobCase#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code JOBSELECTOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobCase forNumber(int); when one; then return 'JOBSELECTOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobCase JobCase.forNumber(int)"})
  void testJobCaseForNumber_whenOne_thenReturnJobselector() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOBSELECTOR, JobCase.forNumber(1));
  }

  /**
   * Test JobCase {@link JobCase#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code JOBKEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobCase forNumber(int); when two; then return 'JOBKEY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobCase JobCase.forNumber(int)"})
  void testJobCaseForNumber_whenTwo_thenReturnJobkey() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOBKEY, JobCase.forNumber(2));
  }

  /**
   * Test JobCase {@link JobCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOB_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobCase forNumber(int); when zero; then return 'JOB_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobCase JobCase.forNumber(int)"})
  void testJobCaseForNumber_whenZero_thenReturnJobNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOB_NOT_SET, JobCase.forNumber(0));
  }

  /**
   * Test JobCase {@link JobCase#getNumber()}.
   * <p>
   * Method under test: {@link JobCase#getNumber()}
   */
  @Test
  @DisplayName("Test JobCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobCase.getNumber()"})
  void testJobCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, JobCase.valueOf("JOBSELECTOR").getNumber());
  }

  /**
   * Test JobCase {@link JobCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobCase JobCase.valueOf(int)"})
  void testJobCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobCase.valueOf(42));
  }

  /**
   * Test JobCase {@link JobCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code JOBSELECTOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobCase valueOf(int) with 'value'; when one; then return 'JOBSELECTOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobCase JobCase.valueOf(int)"})
  void testJobCaseValueOfWithValue_whenOne_thenReturnJobselector() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOBSELECTOR, JobCase.valueOf(1));
  }

  /**
   * Test JobCase {@link JobCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code JOBKEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobCase valueOf(int) with 'value'; when two; then return 'JOBKEY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobCase JobCase.valueOf(int)"})
  void testJobCaseValueOfWithValue_whenTwo_thenReturnJobkey() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOBKEY, JobCase.valueOf(2));
  }

  /**
   * Test JobCase {@link JobCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOB_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobCase valueOf(int) with 'value'; when zero; then return 'JOB_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobCase JobCase.valueOf(int)"})
  void testJobCaseValueOfWithValue_whenZero_thenReturnJobNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobCase.JOB_NOT_SET, JobCase.valueOf(0));
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    RuntimeJobInfoRequest actualParseFromResult = RuntimeJobInfoRequest.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getJobKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobCase.JOB_NOT_SET, actualParseFromResult.getJobCase());
    assertFalse(actualParseFromResult.hasJobKey());
    assertFalse(actualParseFromResult.hasJobSelector());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    RuntimeJobInfoRequest actualParseFromResult = RuntimeJobInfoRequest.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getJobKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobCase.JOB_NOT_SET, actualParseFromResult.getJobCase());
    assertFalse(actualParseFromResult.hasJobKey());
    assertFalse(actualParseFromResult.hasJobSelector());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    RuntimeJobInfoRequest actualParseFromResult = RuntimeJobInfoRequest.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getJobKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobCase.JOB_NOT_SET, actualParseFromResult.getJobCase());
    assertFalse(actualParseFromResult.hasJobKey());
    assertFalse(actualParseFromResult.hasJobSelector());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RuntimeJobInfoRequest actualParseFromResult = RuntimeJobInfoRequest.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getJobKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobCase.JOB_NOT_SET, actualParseFromResult.getJobCase());
    assertFalse(actualParseFromResult.hasJobKey());
    assertFalse(actualParseFromResult.hasJobSelector());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedJobKeyBytes = data.EMPTY;
    assertEquals(expectedJobKeyBytes, actualParseFromResult.getJobKeyBytes());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(ByteString)"})
  void testParseFromWithByteString_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RuntimeJobInfoRequest actualParseFromResult = RuntimeJobInfoRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getJobKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobCase.JOB_NOT_SET, actualParseFromResult.getJobCase());
    assertFalse(actualParseFromResult.hasJobKey());
    assertFalse(actualParseFromResult.hasJobSelector());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedJobKeyBytes = data.EMPTY;
    assertEquals(expectedJobKeyBytes, actualParseFromResult.getJobKeyBytes());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    RuntimeJobInfoRequest actualParseFromResult = RuntimeJobInfoRequest.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getJobKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobCase.JOB_NOT_SET, actualParseFromResult.getJobCase());
    assertFalse(actualParseFromResult.hasJobKey());
    assertFalse(actualParseFromResult.hasJobSelector());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    RuntimeJobInfoRequest actualParseFromResult = RuntimeJobInfoRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getJobKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobCase.JOB_NOT_SET, actualParseFromResult.getJobCase());
    assertFalse(actualParseFromResult.hasJobKey());
    assertFalse(actualParseFromResult.hasJobSelector());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    RuntimeJobInfoRequest actualParseFromResult = RuntimeJobInfoRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getJobKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobCase.JOB_NOT_SET, actualParseFromResult.getJobCase());
    assertFalse(actualParseFromResult.hasJobKey());
    assertFalse(actualParseFromResult.hasJobSelector());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    RuntimeJobInfoRequest actualParseFromResult = RuntimeJobInfoRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getJobKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobCase.JOB_NOT_SET, actualParseFromResult.getJobCase());
    assertFalse(actualParseFromResult.hasJobKey());
    assertFalse(actualParseFromResult.hasJobSelector());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RuntimeJobInfoRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> RuntimeJobInfoRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeJobInfoRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RuntimeJobInfoRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    RuntimeJobInfoRequest actualParseFromResult = RuntimeJobInfoRequest
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    TagSelector jobSelector = actualParseFromResult.getJobSelector();
    assertSame(unknownFields, jobSelector.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(jobSelector, actualParseFromResult.getJobSelectorOrBuilder());
    assertSame(jobSelector, jobSelector.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    RuntimeJobInfoRequest actualParseFromResult = RuntimeJobInfoRequest.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    TagSelector jobSelector = actualParseFromResult.getJobSelector();
    assertSame(unknownFields, jobSelector.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(jobSelector, actualParseFromResult.getJobSelectorOrBuilder());
    assertSame(jobSelector, jobSelector.getDefaultInstanceForType());
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuntimeJobInfoRequest RuntimeJobInfoRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RuntimeJobInfoRequest actualParseDelimitedFromResult = RuntimeJobInfoRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getJobKey());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(JobCase.JOB_NOT_SET, actualParseDelimitedFromResult.getJobCase());
    assertFalse(actualParseDelimitedFromResult.hasJobKey());
    assertFalse(actualParseDelimitedFromResult.hasJobSelector());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuntimeJobInfoRequest RuntimeJobInfoRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RuntimeJobInfoRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuntimeJobInfoRequest RuntimeJobInfoRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> RuntimeJobInfoRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuntimeJobInfoRequest RuntimeJobInfoRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeJobInfoRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuntimeJobInfoRequest RuntimeJobInfoRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RuntimeJobInfoRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RuntimeJobInfoRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RuntimeJobInfoRequest actualParseDelimitedFromResult = RuntimeJobInfoRequest.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getJobKey());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(JobCase.JOB_NOT_SET, actualParseDelimitedFromResult.getJobCase());
    assertFalse(actualParseDelimitedFromResult.hasJobKey());
    assertFalse(actualParseDelimitedFromResult.hasJobSelector());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RuntimeJobInfoRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RuntimeJobInfoRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RuntimeJobInfoRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RuntimeJobInfoRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link RuntimeJobInfoRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuntimeJobInfoRequest RuntimeJobInfoRequest.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    RuntimeJobInfoRequest defaultInstance = RuntimeJobInfoRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}
