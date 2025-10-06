package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.Context;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserMetadataDiffblueTest {
  /**
   * Test {@link UserMetadata#set(Context, UserMetadata)}.
   *
   * <ul>
   *   <li>When {@link Context#ROOT}.
   *   <li>Then return fork fork fork fork fork Deadline is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserMetadata#set(Context, UserMetadata)}
   */
  @Test
  @DisplayName(
      "Test set(Context, UserMetadata); when ROOT; then return fork fork fork fork fork Deadline is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Context UserMetadata.set(Context, UserMetadata)"})
  void testSet_whenRoot_thenReturnForkForkForkForkForkDeadlineIsNull() {
    // Arrange and Act
    Context actualSetResult = UserMetadata.set(Context.ROOT, new UserMetadata("42", "janedoe"));

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
   * Test {@link UserMetadata#get(Context)}.
   *
   * <ul>
   *   <li>When {@link Context#ROOT}.
   *   <li>Then return delegateId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserMetadata#get(Context)}
   */
  @Test
  @DisplayName("Test get(Context); when ROOT; then return delegateId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserMetadata UserMetadata.get(Context)"})
  void testGet_whenRoot_thenReturnDelegateIdIsNull() {
    // Arrange and Act
    UserMetadata actualGetResult = UserMetadata.get(Context.ROOT);

    // Assert
    assertNull(actualGetResult.delegateId());
    assertNull(actualGetResult.delegateName());
    assertFalse(actualGetResult.hasDelegate());
    assertEquals(UserMetadata.UNKNOWN_USER_ID, actualGetResult.userId());
    assertEquals(UserMetadata.UNKNOWN_USER_NAME, actualGetResult.userName());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Delegate Name}.
   *   <li>Then return delegateId is {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserMetadata#UserMetadata(String, String, String, String)}
   *   <li>{@link UserMetadata#delegateId()}
   *   <li>{@link UserMetadata#delegateName()}
   *   <li>{@link UserMetadata#userId()}
   *   <li>{@link UserMetadata#userName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Delegate Name'; then return delegateId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserMetadata.<init>(String, String)",
    "void UserMetadata.<init>(String, String, String, String)",
    "String UserMetadata.delegateId()",
    "String UserMetadata.delegateName()",
    "String UserMetadata.userId()",
    "String UserMetadata.userName()"
  })
  void testGettersAndSetters_whenDelegateName_thenReturnDelegateIdIs42() {
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

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code janedoe}.
   *   <li>Then return delegateId is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserMetadata#UserMetadata(String, String)}
   *   <li>{@link UserMetadata#delegateId()}
   *   <li>{@link UserMetadata#delegateName()}
   *   <li>{@link UserMetadata#userId()}
   *   <li>{@link UserMetadata#userName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'janedoe'; then return delegateId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserMetadata.<init>(String, String)",
    "void UserMetadata.<init>(String, String, String, String)",
    "String UserMetadata.delegateId()",
    "String UserMetadata.delegateName()",
    "String UserMetadata.userId()",
    "String UserMetadata.userName()"
  })
  void testGettersAndSetters_whenJanedoe_thenReturnDelegateIdIsNull() {
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
   * Test {@link UserMetadata#hasDelegate()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserMetadata#hasDelegate()}
   */
  @Test
  @DisplayName("Test hasDelegate(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserMetadata.hasDelegate()"})
  void testHasDelegate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new UserMetadata("42", "janedoe").hasDelegate());
  }

  /**
   * Test {@link UserMetadata#hasDelegate()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserMetadata#hasDelegate()}
   */
  @Test
  @DisplayName("Test hasDelegate(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserMetadata.hasDelegate()"})
  void testHasDelegate_thenReturnTrue() {
    // Arrange
    UserMetadata userMetadata = new UserMetadata("42", "janedoe", "42", "Delegate Name");

    // Act and Assert
    assertTrue(userMetadata.hasDelegate());
  }
}
