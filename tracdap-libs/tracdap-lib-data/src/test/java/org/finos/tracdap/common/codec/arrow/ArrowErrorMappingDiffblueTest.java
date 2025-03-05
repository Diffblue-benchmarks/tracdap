package org.finos.tracdap.common.codec.arrow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.arrow.vector.ipc.InvalidArrowFileException;
import org.finos.tracdap.common.exception.EDataCorruption;
import org.finos.tracdap.common.exception.ETrac;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ArrowErrorMappingDiffblueTest {
  /**
   * Test {@link ArrowErrorMapping#mapDecodingError(Throwable)}.
   * <p>
   * Method under test: {@link ArrowErrorMapping#mapDecodingError(Throwable)}
   */
  @Test
  @DisplayName("Test mapDecodingError(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ETrac ArrowErrorMapping.mapDecodingError(Throwable)"})
  void testMapDecodingError() {
    // Arrange
    InvalidArrowFileException e = new InvalidArrowFileException("An error occurred");

    // Act
    ETrac actualMapDecodingErrorResult = ArrowErrorMapping.mapDecodingError(e);

    // Assert
    assertTrue(actualMapDecodingErrorResult instanceof EDataCorruption);
    assertEquals("Arrow decoding failed, file is invalid: An error occurred",
        actualMapDecodingErrorResult.getLocalizedMessage());
    assertEquals("Arrow decoding failed, file is invalid: An error occurred",
        actualMapDecodingErrorResult.getMessage());
    assertSame(e, actualMapDecodingErrorResult.getCause());
  }

  /**
   * Test {@link ArrowErrorMapping#mapDecodingError(Throwable)}.
   * <ul>
   *   <li>Then return Cause is {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowErrorMapping#mapDecodingError(Throwable)}
   */
  @Test
  @DisplayName("Test mapDecodingError(Throwable); then return Cause is IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ETrac ArrowErrorMapping.mapDecodingError(Throwable)"})
  void testMapDecodingError_thenReturnCauseIsIllegalArgumentExceptionWithFoo() {
    // Arrange
    IllegalArgumentException e = new IllegalArgumentException("foo");

    // Act
    ETrac actualMapDecodingErrorResult = ArrowErrorMapping.mapDecodingError(e);

    // Assert
    assertTrue(actualMapDecodingErrorResult instanceof EDataCorruption);
    assertEquals("Arrow decoding failed, content is garbled", actualMapDecodingErrorResult.getLocalizedMessage());
    assertEquals("Arrow decoding failed, content is garbled", actualMapDecodingErrorResult.getMessage());
    assertSame(e, actualMapDecodingErrorResult.getCause());
  }

  /**
   * Test {@link ArrowErrorMapping#mapDecodingError(Throwable)}.
   * <ul>
   *   <li>Then return Cause is {@link IndexOutOfBoundsException#IndexOutOfBoundsException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowErrorMapping#mapDecodingError(Throwable)}
   */
  @Test
  @DisplayName("Test mapDecodingError(Throwable); then return Cause is IndexOutOfBoundsException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ETrac ArrowErrorMapping.mapDecodingError(Throwable)"})
  void testMapDecodingError_thenReturnCauseIsIndexOutOfBoundsExceptionWithFoo() {
    // Arrange
    IndexOutOfBoundsException e = new IndexOutOfBoundsException("foo");

    // Act
    ETrac actualMapDecodingErrorResult = ArrowErrorMapping.mapDecodingError(e);

    // Assert
    assertTrue(actualMapDecodingErrorResult instanceof EDataCorruption);
    assertEquals("Arrow decoding failed, content is garbled", actualMapDecodingErrorResult.getLocalizedMessage());
    assertEquals("Arrow decoding failed, content is garbled", actualMapDecodingErrorResult.getMessage());
    assertSame(e, actualMapDecodingErrorResult.getCause());
  }

  /**
   * Test {@link ArrowErrorMapping#mapDecodingError(Throwable)}.
   * <ul>
   *   <li>When {@link EUnexpected#EUnexpected()}.</li>
   *   <li>Then return {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowErrorMapping#mapDecodingError(Throwable)}
   */
  @Test
  @DisplayName("Test mapDecodingError(Throwable); when EUnexpected(); then return EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ETrac ArrowErrorMapping.mapDecodingError(Throwable)"})
  void testMapDecodingError_whenEUnexpected_thenReturnEUnexpected() {
    // Arrange and Act
    ETrac actualMapDecodingErrorResult = ArrowErrorMapping.mapDecodingError(new EUnexpected());

    // Assert
    assertTrue(actualMapDecodingErrorResult instanceof EUnexpected);
    assertEquals("Unexpected internal error (this is a bug)", actualMapDecodingErrorResult.getLocalizedMessage());
    assertEquals("Unexpected internal error (this is a bug)", actualMapDecodingErrorResult.getMessage());
    assertNull(actualMapDecodingErrorResult.getCause());
  }

  /**
   * Test {@link ArrowErrorMapping#mapDecodingError(Throwable)}.
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link EDataCorruption}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowErrorMapping#mapDecodingError(Throwable)}
   */
  @Test
  @DisplayName("Test mapDecodingError(Throwable); when IOException(String) with 'foo'; then throw EDataCorruption")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ETrac ArrowErrorMapping.mapDecodingError(Throwable)"})
  void testMapDecodingError_whenIOExceptionWithFoo_thenThrowEDataCorruption() {
    // Arrange, Act and Assert
    assertThrows(EDataCorruption.class, () -> ArrowErrorMapping.mapDecodingError(new IOException("foo")));
  }

  /**
   * Test {@link ArrowErrorMapping#mapDecodingError(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArrowErrorMapping#mapDecodingError(Throwable)}
   */
  @Test
  @DisplayName("Test mapDecodingError(Throwable); when Throwable(); then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ETrac ArrowErrorMapping.mapDecodingError(Throwable)"})
  void testMapDecodingError_whenThrowable_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> ArrowErrorMapping.mapDecodingError(new Throwable()));
  }
}
