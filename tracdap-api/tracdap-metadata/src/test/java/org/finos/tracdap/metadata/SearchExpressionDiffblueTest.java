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
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SearchExpressionDiffblueTest {
  /**
   * Method under test: {@link SearchExpression.ExprCase#forNumber(int)}
   */
  @Test
  void testExprCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(SearchExpression.ExprCase.forNumber(42));
    assertEquals(SearchExpression.ExprCase.EXPR_NOT_SET, SearchExpression.ExprCase.forNumber(0));
    assertEquals(SearchExpression.ExprCase.TERM, SearchExpression.ExprCase.forNumber(1));
    assertEquals(SearchExpression.ExprCase.LOGICAL, SearchExpression.ExprCase.forNumber(2));
  }

  /**
   * Method under test: {@link SearchExpression.ExprCase#getNumber()}
   */
  @Test
  void testExprCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, SearchExpression.ExprCase.valueOf("TERM").getNumber());
  }

  /**
   * Method under test: {@link SearchExpression.ExprCase#valueOf(int)}
   */
  @Test
  void testExprCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(SearchExpression.ExprCase.valueOf(42));
    assertEquals(SearchExpression.ExprCase.EXPR_NOT_SET, SearchExpression.ExprCase.valueOf(0));
    assertEquals(SearchExpression.ExprCase.TERM, SearchExpression.ExprCase.valueOf(1));
    assertEquals(SearchExpression.ExprCase.LOGICAL, SearchExpression.ExprCase.valueOf(2));
  }

  /**
   * Method under test: {@link SearchExpression#getExprCase()}
   */
  @Test
  void testGetExprCase() {
    // Arrange, Act and Assert
    assertEquals(SearchExpression.ExprCase.EXPR_NOT_SET, SearchExpression.getDefaultInstance().getExprCase());
  }

  /**
   * Method under test: {@link SearchExpression#hasTerm()}
   */
  @Test
  void testHasTerm() {
    // Arrange, Act and Assert
    assertFalse(SearchExpression.getDefaultInstance().hasTerm());
  }

  /**
   * Method under test: {@link SearchExpression#hasLogical()}
   */
  @Test
  void testHasLogical() {
    // Arrange, Act and Assert
    assertFalse(SearchExpression.getDefaultInstance().hasLogical());
  }

  /**
   * Method under test: {@link SearchExpression#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SearchExpression.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test: {@link SearchExpression#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SearchExpression.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SearchExpression#equals(Object)}
   *   <li>{@link SearchExpression#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link SearchExpression#equals(Object)}
   *   <li>{@link SearchExpression#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SearchExpression defaultInstance = SearchExpression.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link SearchExpression#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SearchExpression.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link SearchExpression#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SearchExpression.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SearchExpression#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SearchExpression.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SearchExpression#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
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
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SearchExpression.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
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
   * Method under test: {@link SearchExpression#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
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
   * Method under test:
   * {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SearchExpression.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
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
   * Method under test:
   * {@link SearchExpression#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
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
   * Method under test: {@link SearchExpression#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    SearchExpression defaultInstance = SearchExpression.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link SearchExpression#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SearchExpression.getDefaultInstance(), "0123456789ABCDEF");
  }

  /**
   * Method under test: {@link SearchExpression#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SearchExpression.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link SearchExpression#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SearchExpression.getDefaultInstance(), "Different type to SearchExpression");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SearchExpression#getDefaultInstance()}
   *   <li>{@link SearchExpression#getDescriptor()}
   *   <li>{@link SearchExpression#newBuilder()}
   *   <li>{@link SearchExpression#newBuilder(SearchExpression)}
   *   <li>{@link SearchExpression#newBuilderForType()}
   *   <li>{@link SearchExpression#toBuilder()}
   *   <li>{@link SearchExpression#getLogicalOrBuilder()}
   *   <li>{@link SearchExpression#getParserForType()}
   *   <li>{@link SearchExpression#getTermOrBuilder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SearchExpression actualDefaultInstance = SearchExpression.getDefaultInstance();
    SearchExpression actualDefaultInstance2 = actualDefaultInstance.getDefaultInstance();
    Descriptors.Descriptor actualDescriptor = actualDefaultInstance.getDescriptor();
    actualDefaultInstance.newBuilder();
    SearchExpression prototype = SearchExpression.getDefaultInstance();
    actualDefaultInstance.newBuilder(prototype);
    actualDefaultInstance.newBuilderForType();
    actualDefaultInstance.toBuilder();
    LogicalExpressionOrBuilder actualLogicalOrBuilder = actualDefaultInstance.getLogicalOrBuilder();
    actualDefaultInstance.getParserForType();
    SearchTermOrBuilder actualTermOrBuilder = actualDefaultInstance.getTermOrBuilder();

    // Assert
    UnknownFieldSet unknownFields = actualDefaultInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertSame(actualDefaultInstance.getDescriptorForType(), actualDescriptor);
    assertSame(actualDefaultInstance.getLogical(), actualLogicalOrBuilder);
    assertSame(actualDefaultInstance.getTerm(), actualTermOrBuilder);
    assertSame(prototype, actualDefaultInstance2);
  }
}
