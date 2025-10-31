package org.finos.tracdap.common.codec.arrow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.arrow.vector.ipc.InvalidArrowFileException;
import org.finos.tracdap.common.exception.EDataCorruption;
import org.finos.tracdap.common.exception.ETrac;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.Test;

class ArrowErrorMappingDiffblueTest {
  /**
   * Method under test: {@link ArrowErrorMapping#mapDecodingError(Throwable)}
   */
  @Test
  void testMapDecodingError() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> ArrowErrorMapping.mapDecodingError(new Throwable()));
    assertThrows(EDataCorruption.class, () -> ArrowErrorMapping.mapDecodingError(new IOException("foo")));
  }

  /**
   * Method under test: {@link ArrowErrorMapping#mapDecodingError(Throwable)}
   */
  @Test
  void testMapDecodingError2() {
    // Arrange and Act
    ETrac actualMapDecodingErrorResult = ArrowErrorMapping.mapDecodingError(new EUnexpected());

    // Assert
    assertTrue(actualMapDecodingErrorResult instanceof EUnexpected);
    assertEquals("Unexpected internal error (this is a bug)", actualMapDecodingErrorResult.getLocalizedMessage());
    assertEquals("Unexpected internal error (this is a bug)", actualMapDecodingErrorResult.getMessage());
    assertNull(actualMapDecodingErrorResult.getCause());
    assertEquals(0, actualMapDecodingErrorResult.getSuppressed().length);
  }

  /**
   * Method under test: {@link ArrowErrorMapping#mapDecodingError(Throwable)}
   */
  @Test
  void testMapDecodingError3() {
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
    assertNull(((EDataCorruption) actualMapDecodingErrorResult).getDetails());
    assertEquals(0, actualMapDecodingErrorResult.getSuppressed().length);
    assertSame(e, actualMapDecodingErrorResult.getCause());
  }

  /**
   * Method under test: {@link ArrowErrorMapping#mapDecodingError(Throwable)}
   */
  @Test
  void testMapDecodingError4() {
    // Arrange
    IllegalArgumentException e = new IllegalArgumentException("foo");

    // Act
    ETrac actualMapDecodingErrorResult = ArrowErrorMapping.mapDecodingError(e);

    // Assert
    assertTrue(actualMapDecodingErrorResult instanceof EDataCorruption);
    assertEquals("Arrow decoding failed, content is garbled", actualMapDecodingErrorResult.getLocalizedMessage());
    assertEquals("Arrow decoding failed, content is garbled", actualMapDecodingErrorResult.getMessage());
    assertNull(((EDataCorruption) actualMapDecodingErrorResult).getDetails());
    assertEquals(0, actualMapDecodingErrorResult.getSuppressed().length);
    assertSame(e, actualMapDecodingErrorResult.getCause());
  }

  /**
   * Method under test: {@link ArrowErrorMapping#mapDecodingError(Throwable)}
   */
  @Test
  void testMapDecodingError5() {
    // Arrange
    IndexOutOfBoundsException e = new IndexOutOfBoundsException("foo");

    // Act
    ETrac actualMapDecodingErrorResult = ArrowErrorMapping.mapDecodingError(e);

    // Assert
    assertTrue(actualMapDecodingErrorResult instanceof EDataCorruption);
    assertEquals("Arrow decoding failed, content is garbled", actualMapDecodingErrorResult.getLocalizedMessage());
    assertEquals("Arrow decoding failed, content is garbled", actualMapDecodingErrorResult.getMessage());
    assertNull(((EDataCorruption) actualMapDecodingErrorResult).getDetails());
    assertEquals(0, actualMapDecodingErrorResult.getSuppressed().length);
    assertSame(e, actualMapDecodingErrorResult.getCause());
  }
}
