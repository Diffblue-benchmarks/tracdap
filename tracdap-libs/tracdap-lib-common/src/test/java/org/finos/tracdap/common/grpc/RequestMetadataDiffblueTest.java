package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import io.grpc.Context;
import java.time.OffsetDateTime;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.Test;

class RequestMetadataDiffblueTest {
  /**
   * Method under test: {@link RequestMetadata#set(Context, RequestMetadata)}
   */
  @Test
  void testSet() {
    // Arrange
    Context context = Context.current();

    // Act
    Context actualSetResult = RequestMetadata.set(context,
        new RequestMetadata("42", RequestMetadata.UNKNOWN_REQUEST_TIMESTAMP));

    // Assert
    Context forkResult = actualSetResult.fork();
    Context forkResult2 = forkResult.fork();
    Context forkResult3 = forkResult2.fork();
    Context forkResult4 = forkResult3.fork();
    Context forkResult5 = forkResult4.fork();
    Context forkResult6 = forkResult5.fork();
    Context forkResult7 = forkResult6.fork();
    Context forkResult8 = forkResult7.fork();
    assertNull(forkResult8.getDeadline());
    assertNull(forkResult7.getDeadline());
    assertNull(forkResult6.getDeadline());
    assertNull(forkResult5.getDeadline());
    assertNull(forkResult4.getDeadline());
    assertNull(forkResult3.getDeadline());
    assertNull(forkResult2.getDeadline());
    assertNull(forkResult.getDeadline());
    assertNull(actualSetResult.getDeadline());
    assertFalse(forkResult8.isCancelled());
    assertFalse(forkResult7.isCancelled());
    assertFalse(forkResult6.isCancelled());
    assertFalse(forkResult5.isCancelled());
    assertFalse(forkResult4.isCancelled());
    assertFalse(forkResult3.isCancelled());
    assertFalse(forkResult2.isCancelled());
    assertFalse(forkResult.isCancelled());
    assertFalse(actualSetResult.isCancelled());
  }

  /**
   * Method under test: {@link RequestMetadata#set(Context, RequestMetadata)}
   */
  @Test
  void testSet2() {
    // Arrange
    Context context = Context.current();
    context.addListener(mock(Context.CancellationListener.class), mock(Executor.class));

    // Act
    Context actualSetResult = RequestMetadata.set(context,
        new RequestMetadata("42", RequestMetadata.UNKNOWN_REQUEST_TIMESTAMP));

    // Assert
    Context forkResult = actualSetResult.fork();
    Context forkResult2 = forkResult.fork();
    Context forkResult3 = forkResult2.fork();
    Context forkResult4 = forkResult3.fork();
    Context forkResult5 = forkResult4.fork();
    Context forkResult6 = forkResult5.fork();
    Context forkResult7 = forkResult6.fork();
    Context forkResult8 = forkResult7.fork();
    assertNull(forkResult8.getDeadline());
    assertNull(forkResult7.getDeadline());
    assertNull(forkResult6.getDeadline());
    assertNull(forkResult5.getDeadline());
    assertNull(forkResult4.getDeadline());
    assertNull(forkResult3.getDeadline());
    assertNull(forkResult2.getDeadline());
    assertNull(forkResult.getDeadline());
    assertNull(actualSetResult.getDeadline());
    assertFalse(forkResult8.isCancelled());
    assertFalse(forkResult7.isCancelled());
    assertFalse(forkResult6.isCancelled());
    assertFalse(forkResult5.isCancelled());
    assertFalse(forkResult4.isCancelled());
    assertFalse(forkResult3.isCancelled());
    assertFalse(forkResult2.isCancelled());
    assertFalse(forkResult.isCancelled());
    assertFalse(actualSetResult.isCancelled());
  }

  /**
   * Method under test: {@link RequestMetadata#get(Context)}
   */
  @Test
  void testGet() {
    // Arrange and Act
    RequestMetadata actualGetResult = RequestMetadata.get(Context.current());

    // Assert
    assertEquals(RequestMetadata.UNKNOWN_REQUEST_ID, actualGetResult.requestId());
    OffsetDateTime expectedRequestTimestampResult = actualGetResult.UNKNOWN_REQUEST_TIMESTAMP;
    assertSame(expectedRequestTimestampResult, actualGetResult.requestTimestamp());
  }

  /**
   * Method under test: {@link RequestMetadata#get(Context)}
   */
  @Test
  void testGet2() {
    // Arrange
    Context context = Context.current();
    context.addListener(mock(Context.CancellationListener.class), mock(Executor.class));

    // Act
    RequestMetadata actualGetResult = RequestMetadata.get(context);

    // Assert
    assertEquals(RequestMetadata.UNKNOWN_REQUEST_ID, actualGetResult.requestId());
    OffsetDateTime expectedRequestTimestampResult = actualGetResult.UNKNOWN_REQUEST_TIMESTAMP;
    assertSame(expectedRequestTimestampResult, actualGetResult.requestTimestamp());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RequestMetadata#RequestMetadata(String, OffsetDateTime)}
   *   <li>{@link RequestMetadata#requestId()}
   *   <li>{@link RequestMetadata#requestTimestamp()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RequestMetadata actualRequestMetadata = new RequestMetadata("42", RequestMetadata.UNKNOWN_REQUEST_TIMESTAMP);
    String actualRequestIdResult = actualRequestMetadata.requestId();

    // Assert
    assertEquals("42", actualRequestIdResult);
    assertSame(actualRequestMetadata.UNKNOWN_REQUEST_TIMESTAMP, actualRequestMetadata.requestTimestamp());
  }
}
