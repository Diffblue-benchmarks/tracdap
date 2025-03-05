package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.Context;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RequestMetadataDiffblueTest {
  /**
   * Test {@link RequestMetadata#set(Context, RequestMetadata)}.
   * <ul>
   *   <li>When current.</li>
   *   <li>Then return fork fork fork fork fork Deadline is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMetadata#set(Context, RequestMetadata)}
   */
  @Test
  @DisplayName("Test set(Context, RequestMetadata); when current; then return fork fork fork fork fork Deadline is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Context RequestMetadata.set(Context, RequestMetadata)"})
  void testSet_whenCurrent_thenReturnForkForkForkForkForkDeadlineIsNull() {
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
    assertNull(forkResult5.getDeadline());
    assertNull(forkResult4.getDeadline());
    assertNull(forkResult3.getDeadline());
    assertNull(forkResult2.getDeadline());
    assertNull(forkResult.getDeadline());
    assertNull(actualSetResult.getDeadline());
    assertFalse(forkResult5.isCancelled());
    assertFalse(forkResult4.isCancelled());
    assertFalse(forkResult3.isCancelled());
    assertFalse(forkResult2.isCancelled());
    assertFalse(forkResult.isCancelled());
    assertFalse(actualSetResult.isCancelled());
  }

  /**
   * Test {@link RequestMetadata#get(Context)}.
   * <ul>
   *   <li>When current.</li>
   *   <li>Then return requestId is {@link RequestMetadata#UNKNOWN_REQUEST_ID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMetadata#get(Context)}
   */
  @Test
  @DisplayName("Test get(Context); when current; then return requestId is UNKNOWN_REQUEST_ID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequestMetadata RequestMetadata.get(Context)"})
  void testGet_whenCurrent_thenReturnRequestIdIsUnknown_request_id() {
    // Arrange and Act
    RequestMetadata actualGetResult = RequestMetadata.get(Context.current());

    // Assert
    assertEquals(RequestMetadata.UNKNOWN_REQUEST_ID, actualGetResult.requestId());
    OffsetDateTime expectedRequestTimestampResult = actualGetResult.UNKNOWN_REQUEST_TIMESTAMP;
    assertSame(expectedRequestTimestampResult, actualGetResult.requestTimestamp());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RequestMetadata#RequestMetadata(String, OffsetDateTime)}
   *   <li>{@link RequestMetadata#requestId()}
   *   <li>{@link RequestMetadata#requestTimestamp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RequestMetadata.<init>(String, OffsetDateTime)", "String RequestMetadata.requestId()",
      "OffsetDateTime RequestMetadata.requestTimestamp()"})
  void testGettersAndSetters() {
    // Arrange and Act
    RequestMetadata actualRequestMetadata = new RequestMetadata("42", RequestMetadata.UNKNOWN_REQUEST_TIMESTAMP);
    String actualRequestIdResult = actualRequestMetadata.requestId();

    // Assert
    assertEquals("42", actualRequestIdResult);
    assertSame(actualRequestMetadata.UNKNOWN_REQUEST_TIMESTAMP, actualRequestMetadata.requestTimestamp());
  }
}
