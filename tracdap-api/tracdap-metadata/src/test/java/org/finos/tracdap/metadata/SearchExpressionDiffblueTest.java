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
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.finos.tracdap.metadata.SearchExpression.ExprCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SearchExpressionDiffblueTest {
  /**
   * Test ExprCase {@link ExprCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExprCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ExprCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExprCase ExprCase.forNumber(int)"})
  void testExprCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ExprCase.forNumber(42));
  }

  /**
   * Test ExprCase {@link ExprCase#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code TERM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExprCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ExprCase forNumber(int); when one; then return 'TERM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExprCase ExprCase.forNumber(int)"})
  void testExprCaseForNumber_whenOne_thenReturnTerm() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.TERM, ExprCase.forNumber(1));
  }

  /**
   * Test ExprCase {@link ExprCase#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code LOGICAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExprCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ExprCase forNumber(int); when two; then return 'LOGICAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExprCase ExprCase.forNumber(int)"})
  void testExprCaseForNumber_whenTwo_thenReturnLogical() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.LOGICAL, ExprCase.forNumber(2));
  }

  /**
   * Test ExprCase {@link ExprCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code EXPR_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExprCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ExprCase forNumber(int); when zero; then return 'EXPR_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExprCase ExprCase.forNumber(int)"})
  void testExprCaseForNumber_whenZero_thenReturnExprNotSet() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.EXPR_NOT_SET, ExprCase.forNumber(0));
  }

  /**
   * Test ExprCase {@link ExprCase#getNumber()}.
   * <p>
   * Method under test: {@link ExprCase#getNumber()}
   */
  @Test
  @DisplayName("Test ExprCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ExprCase.getNumber()"})
  void testExprCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, ExprCase.valueOf("TERM").getNumber());
  }

  /**
   * Test ExprCase {@link ExprCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExprCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ExprCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExprCase ExprCase.valueOf(int)"})
  void testExprCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ExprCase.valueOf(42));
  }

  /**
   * Test ExprCase {@link ExprCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code TERM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExprCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ExprCase valueOf(int) with 'value'; when one; then return 'TERM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExprCase ExprCase.valueOf(int)"})
  void testExprCaseValueOfWithValue_whenOne_thenReturnTerm() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.TERM, ExprCase.valueOf(1));
  }

  /**
   * Test ExprCase {@link ExprCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code LOGICAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExprCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ExprCase valueOf(int) with 'value'; when two; then return 'LOGICAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExprCase ExprCase.valueOf(int)"})
  void testExprCaseValueOfWithValue_whenTwo_thenReturnLogical() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.LOGICAL, ExprCase.valueOf(2));
  }

  /**
   * Test ExprCase {@link ExprCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code EXPR_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExprCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ExprCase valueOf(int) with 'value'; when zero; then return 'EXPR_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExprCase ExprCase.valueOf(int)"})
  void testExprCaseValueOfWithValue_whenZero_thenReturnExprNotSet() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.EXPR_NOT_SET, ExprCase.valueOf(0));
  }

  /**
   * Test {@link SearchExpression#getExprCase()}.
   * <p>
   * Method under test: {@link SearchExpression#getExprCase()}
   */
  @Test
  @DisplayName("Test getExprCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExprCase SearchExpression.getExprCase()"})
  void testGetExprCase() {
    // Arrange, Act and Assert
    assertEquals(ExprCase.EXPR_NOT_SET, SearchExpression.getDefaultInstance().getExprCase());
  }

  /**
   * Test {@link SearchExpression#hasTerm()}.
   * <p>
   * Method under test: {@link SearchExpression#hasTerm()}
   */
  @Test
  @DisplayName("Test hasTerm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SearchExpression.hasTerm()"})
  void testHasTerm() {
    // Arrange, Act and Assert
    assertFalse(SearchExpression.getDefaultInstance().hasTerm());
  }

  /**
   * Test {@link SearchExpression#getTerm()}.
   * <p>
   * Method under test: {@link SearchExpression#getTerm()}
   */
  @Test
  @DisplayName("Test getTerm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchTerm SearchExpression.getTerm()"})
  void testGetTerm() {
    // Arrange and Act
    SearchTerm actualTerm = SearchExpression.getDefaultInstance().getTerm();

    // Assert
    assertEquals("", actualTerm.getInitializationErrorString());
    assertEquals("", actualTerm.getAttrName());
    assertEquals(0, actualTerm.getAttrTypeValue());
    assertEquals(0, actualTerm.getOperatorValue());
    assertEquals(0, actualTerm.getSerializedSize());
    assertEquals(BasicType.BASIC_TYPE_NOT_SET, actualTerm.getAttrType());
    assertEquals(SearchOperator.SEARCH_OPERATOR_NOT_SET, actualTerm.getOperator());
    assertFalse(actualTerm.hasSearchValue());
    assertTrue(actualTerm.findInitializationErrors().isEmpty());
    assertTrue(actualTerm.getAllFields().isEmpty());
    assertTrue(actualTerm.isInitialized());
    assertSame(actualTerm, actualTerm.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#hasLogical()}.
   * <p>
   * Method under test: {@link SearchExpression#hasLogical()}
   */
  @Test
  @DisplayName("Test hasLogical()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SearchExpression.hasLogical()"})
  void testHasLogical() {
    // Arrange, Act and Assert
    assertFalse(SearchExpression.getDefaultInstance().hasLogical());
  }

  /**
   * Test {@link SearchExpression#getLogical()}.
   * <p>
   * Method under test: {@link SearchExpression#getLogical()}
   */
  @Test
  @DisplayName("Test getLogical()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalExpression SearchExpression.getLogical()"})
  void testGetLogical() {
    // Arrange and Act
    LogicalExpression actualLogical = SearchExpression.getDefaultInstance().getLogical();

    // Assert
    assertEquals("", actualLogical.getInitializationErrorString());
    assertEquals(0, actualLogical.getExprCount());
    assertEquals(0, actualLogical.getOperatorValue());
    assertEquals(0, actualLogical.getSerializedSize());
    assertEquals(LogicalOperator.LOGICAL_OPERATOR_NOT_SET, actualLogical.getOperator());
    assertTrue(actualLogical.findInitializationErrors().isEmpty());
    List<SearchExpression> exprList = actualLogical.getExprList();
    assertTrue(exprList.isEmpty());
    assertTrue(actualLogical.getAllFields().isEmpty());
    assertTrue(actualLogical.isInitialized());
    assertSame(exprList, actualLogical.getExprOrBuilderList());
    assertSame(actualLogical, actualLogical.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#isInitialized()}.
   * <p>
   * Method under test: {@link SearchExpression#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SearchExpression.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SearchExpression.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link SearchExpression#getSerializedSize()}.
   * <p>
   * Method under test: {@link SearchExpression#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SearchExpression.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SearchExpression.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link SearchExpression#equals(Object)}, and {@link SearchExpression#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SearchExpression#equals(Object)}
   *   <li>{@link SearchExpression#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SearchExpression.equals(Object)", "int SearchExpression.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SearchExpression defaultInstance = SearchExpression.getDefaultInstance();
    SearchExpression defaultInstance2 = SearchExpression.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link SearchExpression#equals(Object)}, and {@link SearchExpression#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SearchExpression#equals(Object)}
   *   <li>{@link SearchExpression#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SearchExpression.equals(Object)", "int SearchExpression.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SearchExpression defaultInstance = SearchExpression.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link SearchExpression#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SearchExpression.equals(Object)", "int SearchExpression.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SearchExpression.getDefaultInstance(), "0123456789ABCDEF");
  }

  /**
   * Test {@link SearchExpression#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SearchExpression.equals(Object)", "int SearchExpression.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SearchExpression.getDefaultInstance(), null);
  }

  /**
   * Test {@link SearchExpression#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SearchExpression.equals(Object)", "int SearchExpression.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SearchExpression.getDefaultInstance(), "Different type to SearchExpression");
  }

  /**
   * Test {@link SearchExpression#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    SearchExpression actualParseFromResult = SearchExpression.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ExprCase.EXPR_NOT_SET, actualParseFromResult.getExprCase());
    assertFalse(actualParseFromResult.hasLogical());
    assertFalse(actualParseFromResult.hasTerm());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    SearchExpression actualParseFromResult = SearchExpression.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ExprCase.EXPR_NOT_SET, actualParseFromResult.getExprCase());
    assertFalse(actualParseFromResult.hasLogical());
    assertFalse(actualParseFromResult.hasTerm());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    SearchExpression actualParseFromResult = SearchExpression.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ExprCase.EXPR_NOT_SET, actualParseFromResult.getExprCase());
    assertFalse(actualParseFromResult.hasLogical());
    assertFalse(actualParseFromResult.hasTerm());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SearchExpression actualParseFromResult = SearchExpression.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ExprCase.EXPR_NOT_SET, actualParseFromResult.getExprCase());
    assertFalse(actualParseFromResult.hasLogical());
    assertFalse(actualParseFromResult.hasTerm());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(ByteString)"})
  void testParseFromWithByteString_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    SearchExpression actualParseFromResult = SearchExpression.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ExprCase.EXPR_NOT_SET, actualParseFromResult.getExprCase());
    assertFalse(actualParseFromResult.hasLogical());
    assertFalse(actualParseFromResult.hasTerm());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    SearchExpression actualParseFromResult = SearchExpression.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ExprCase.EXPR_NOT_SET, actualParseFromResult.getExprCase());
    assertFalse(actualParseFromResult.hasLogical());
    assertFalse(actualParseFromResult.hasTerm());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SearchExpression actualParseFromResult = SearchExpression.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ExprCase.EXPR_NOT_SET, actualParseFromResult.getExprCase());
    assertFalse(actualParseFromResult.hasLogical());
    assertFalse(actualParseFromResult.hasTerm());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    SearchExpression actualParseFromResult = SearchExpression.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ExprCase.EXPR_NOT_SET, actualParseFromResult.getExprCase());
    assertFalse(actualParseFromResult.hasLogical());
    assertFalse(actualParseFromResult.hasTerm());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    SearchExpression actualParseFromResult = SearchExpression.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(ExprCase.EXPR_NOT_SET, actualParseFromResult.getExprCase());
    assertFalse(actualParseFromResult.hasLogical());
    assertFalse(actualParseFromResult.hasTerm());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SearchExpression.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link SearchExpression#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SearchExpression.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link SearchExpression#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SearchExpression.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link SearchExpression#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SearchExpression.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link SearchExpression#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    SearchExpression actualParseFromResult = SearchExpression.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    LogicalExpression logical = actualParseFromResult.getLogical();
    assertSame(unknownFields, logical.getUnknownFields());
    SearchTerm term = actualParseFromResult.getTerm();
    assertSame(unknownFields, term.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(logical, logical.getDefaultInstanceForType());
    assertSame(logical, actualParseFromResult.getLogicalOrBuilder());
    assertSame(term, actualParseFromResult.getTermOrBuilder());
    assertSame(term, term.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    SearchExpression actualParseFromResult = SearchExpression.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    LogicalExpression logical = actualParseFromResult.getLogical();
    assertSame(unknownFields, logical.getUnknownFields());
    SearchTerm term = actualParseFromResult.getTerm();
    assertSame(unknownFields, term.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(logical, logical.getDefaultInstanceForType());
    assertSame(logical, actualParseFromResult.getLogicalOrBuilder());
    assertSame(term, actualParseFromResult.getTermOrBuilder());
    assertSame(term, term.getDefaultInstanceForType());
  }

  /**
   * Test {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SearchExpression actualParseDelimitedFromResult = SearchExpression.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    assertEquals(2, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(oneofs, descriptorForType.getRealOneofs());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    LogicalExpression logical = actualParseDelimitedFromResult.getLogical();
    assertSame(unknownFields, logical.getUnknownFields());
    SearchTerm term = actualParseDelimitedFromResult.getTerm();
    assertSame(unknownFields, term.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(logical, logical.getDefaultInstanceForType());
    assertSame(logical, actualParseDelimitedFromResult.getLogicalOrBuilder());
    assertSame(term, actualParseDelimitedFromResult.getTermOrBuilder());
    assertSame(term, term.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SearchExpression.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SearchExpression.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        SearchExpression.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SearchExpression.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link SearchExpression#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SearchExpression.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link SearchExpression#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SearchExpression.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link SearchExpression#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, SearchExpression.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link SearchExpression#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return UnknownFields SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return UnknownFields SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnUnknownFieldsSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    SearchExpression actualParseDelimitedFromResult = SearchExpression.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    assertEquals(2, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(unknownFields.isEmpty());
    assertEquals(oneofs, descriptorForType.getRealOneofs());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    LogicalExpression logical = actualParseDelimitedFromResult.getLogical();
    assertSame(unknownFields, logical.getUnknownFields());
    SearchTerm term = actualParseDelimitedFromResult.getTerm();
    assertSame(unknownFields, term.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(logical, logical.getDefaultInstanceForType());
    assertSame(logical, actualParseDelimitedFromResult.getLogicalOrBuilder());
    assertSame(term, actualParseDelimitedFromResult.getTermOrBuilder());
    assertSame(term, term.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link SearchExpression#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SearchExpression.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link SearchExpression#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link SearchExpression#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchExpression SearchExpression.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    SearchExpression defaultInstance = SearchExpression.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}
