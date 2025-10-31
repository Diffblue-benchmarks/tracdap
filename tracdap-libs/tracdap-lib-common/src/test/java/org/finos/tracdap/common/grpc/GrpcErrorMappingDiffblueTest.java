package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.Test;

class GrpcErrorMappingDiffblueTest {
  /**
   * Method under test: {@link GrpcErrorMapping#processError(Throwable)}
   */
  @Test
  void testProcessError() {
    // Arrange
    Throwable error = new Throwable();

    // Act
    StatusRuntimeException actualProcessErrorResult = GrpcErrorMapping.processError(error);

    // Assert
    assertEquals("INTERNAL: Internal server error", actualProcessErrorResult.getLocalizedMessage());
    assertEquals("INTERNAL: Internal server error", actualProcessErrorResult.getMessage());
    Status status = actualProcessErrorResult.getStatus();
    assertEquals("Internal server error", status.getDescription());
    assertEquals(0, actualProcessErrorResult.getSuppressed().length);
    assertEquals(Status.Code.INTERNAL, status.getCode());
    assertFalse(status.isOk());
    assertSame(error, status.getCause());
    assertSame(error, actualProcessErrorResult.getCause());
  }

  /**
   * Method under test: {@link GrpcErrorMapping#processError(Throwable)}
   */
  @Test
  void testProcessError2() {
    // Arrange
    Throwable error = new Throwable("log4j");

    // Act
    StatusRuntimeException actualProcessErrorResult = GrpcErrorMapping.processError(error);

    // Assert
    assertEquals("INTERNAL: Internal server error", actualProcessErrorResult.getLocalizedMessage());
    assertEquals("INTERNAL: Internal server error", actualProcessErrorResult.getMessage());
    Status status = actualProcessErrorResult.getStatus();
    assertEquals("Internal server error", status.getDescription());
    assertEquals(0, actualProcessErrorResult.getSuppressed().length);
    assertEquals(Status.Code.INTERNAL, status.getCode());
    assertFalse(status.isOk());
    assertSame(error, status.getCause());
    assertSame(error, actualProcessErrorResult.getCause());
  }

  /**
   * Method under test: {@link GrpcErrorMapping#processError(Throwable)}
   */
  @Test
  void testProcessError3() {
    // Arrange and Act
    StatusRuntimeException actualProcessErrorResult = GrpcErrorMapping.processError(null);

    // Assert
    assertEquals("INTERNAL: Internal server error", actualProcessErrorResult.getLocalizedMessage());
    assertEquals("INTERNAL: Internal server error", actualProcessErrorResult.getMessage());
    Status status = actualProcessErrorResult.getStatus();
    assertEquals("Internal server error", status.getDescription());
    assertNull(status.getCause());
    assertNull(actualProcessErrorResult.getCause());
    assertEquals(0, actualProcessErrorResult.getSuppressed().length);
    assertEquals(Status.Code.INTERNAL, status.getCode());
    assertFalse(status.isOk());
  }
}
