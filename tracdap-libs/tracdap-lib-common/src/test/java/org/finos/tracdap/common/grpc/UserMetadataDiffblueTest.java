package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.grpc.Context;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.Test;

class UserMetadataDiffblueTest {
  /**
   * Method under test: {@link UserMetadata#set(Context, UserMetadata)}
   */
  @Test
  void testSet() {
    // Arrange
    Context context = Context.current();

    // Act
    Context actualSetResult = UserMetadata.set(context, new UserMetadata("42", "janedoe"));

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
   * Method under test: {@link UserMetadata#set(Context, UserMetadata)}
   */
  @Test
  void testSet2() {
    // Arrange
    Context context = Context.current();
    context.addListener(mock(Context.CancellationListener.class), mock(Executor.class));

    // Act
    Context actualSetResult = UserMetadata.set(context, new UserMetadata("42", "janedoe"));

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
   * Method under test: {@link UserMetadata#get(Context)}
   */
  @Test
  void testGet() {
    // Arrange and Act
    UserMetadata actualGetResult = UserMetadata.get(Context.current());

    // Assert
    assertNull(actualGetResult.delegateId());
    assertNull(actualGetResult.delegateName());
    assertFalse(actualGetResult.hasDelegate());
    assertEquals(UserMetadata.UNKNOWN_USER_ID, actualGetResult.userId());
    assertEquals(UserMetadata.UNKNOWN_USER_NAME, actualGetResult.userName());
  }

  /**
   * Method under test: {@link UserMetadata#get(Context)}
   */
  @Test
  void testGet2() {
    // Arrange
    Context context = Context.current();
    context.addListener(mock(Context.CancellationListener.class), mock(Executor.class));

    // Act
    UserMetadata actualGetResult = UserMetadata.get(context);

    // Assert
    assertNull(actualGetResult.delegateId());
    assertNull(actualGetResult.delegateName());
    assertFalse(actualGetResult.hasDelegate());
    assertEquals(UserMetadata.UNKNOWN_USER_ID, actualGetResult.userId());
    assertEquals(UserMetadata.UNKNOWN_USER_NAME, actualGetResult.userName());
  }

  /**
   * Method under test: {@link UserMetadata#hasDelegate()}
   */
  @Test
  void testHasDelegate() {
    // Arrange, Act and Assert
    assertFalse((new UserMetadata("42", "janedoe")).hasDelegate());
    assertTrue((new UserMetadata("42", "janedoe", "42", "Delegate Name")).hasDelegate());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserMetadata#UserMetadata(String, String)}
   *   <li>{@link UserMetadata#delegateId()}
   *   <li>{@link UserMetadata#delegateName()}
   *   <li>{@link UserMetadata#userId()}
   *   <li>{@link UserMetadata#userName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    UserMetadata actualUserMetadata = new UserMetadata("42", "janedoe");
    String actualDelegateIdResult = actualUserMetadata.delegateId();
    String actualDelegateNameResult = actualUserMetadata.delegateName();
    String actualUserIdResult = actualUserMetadata.userId();

    // Assert
    assertEquals("42", actualUserIdResult);
    assertEquals("janedoe", actualUserMetadata.userName());
    assertNull(actualDelegateIdResult);
    assertNull(actualDelegateNameResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserMetadata#UserMetadata(String, String, String, String)}
   *   <li>{@link UserMetadata#delegateId()}
   *   <li>{@link UserMetadata#delegateName()}
   *   <li>{@link UserMetadata#userId()}
   *   <li>{@link UserMetadata#userName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    UserMetadata actualUserMetadata = new UserMetadata("42", "janedoe", "42", "Delegate Name");
    String actualDelegateIdResult = actualUserMetadata.delegateId();
    String actualDelegateNameResult = actualUserMetadata.delegateName();
    String actualUserIdResult = actualUserMetadata.userId();

    // Assert
    assertEquals("42", actualDelegateIdResult);
    assertEquals("42", actualUserIdResult);
    assertEquals("Delegate Name", actualDelegateNameResult);
    assertEquals("janedoe", actualUserMetadata.userName());
  }
}
