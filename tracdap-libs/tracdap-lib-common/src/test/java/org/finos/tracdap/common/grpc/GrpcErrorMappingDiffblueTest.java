package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GrpcErrorMappingDiffblueTest {
  /**
   * Test {@link GrpcErrorMapping#processError(Throwable)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code INTERNAL: Internal server error}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcErrorMapping#processError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test processError(Throwable); then return LocalizedMessage is 'INTERNAL: Internal server error'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StatusRuntimeException GrpcErrorMapping.processError(Throwable)"})
  void testProcessError_thenReturnLocalizedMessageIsInternalInternalServerError() {
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
    assertEquals(Code.INTERNAL, status.getCode());
    assertFalse(status.isOk());
  }

  /**
   * Test {@link GrpcErrorMapping#processError(Throwable)}.
   *
   * <ul>
   *   <li>Then return Status Cause is {@link Throwable#Throwable(String)} with {@code log4j}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcErrorMapping#processError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test processError(Throwable); then return Status Cause is Throwable(String) with 'log4j'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StatusRuntimeException GrpcErrorMapping.processError(Throwable)"})
  void testProcessError_thenReturnStatusCauseIsThrowableWithLog4j() {
    // Arrange
    Throwable error = new Throwable("log4j");

    // Act
    StatusRuntimeException actualProcessErrorResult = GrpcErrorMapping.processError(error);

    // Assert
    assertSame(error, actualProcessErrorResult.getStatus().getCause());
    assertSame(error, actualProcessErrorResult.getCause());
  }

  /**
   * Test {@link GrpcErrorMapping#processError(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Status Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcErrorMapping#processError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test processError(Throwable); when Throwable(); then return Status Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StatusRuntimeException GrpcErrorMapping.processError(Throwable)"})
  void testProcessError_whenThrowable_thenReturnStatusCauseIsThrowable() {
    // Arrange
    Throwable error = new Throwable();

    // Act
    StatusRuntimeException actualProcessErrorResult = GrpcErrorMapping.processError(error);

    // Assert
    assertSame(error, actualProcessErrorResult.getStatus().getCause());
    assertSame(error, actualProcessErrorResult.getCause());
  }
}
