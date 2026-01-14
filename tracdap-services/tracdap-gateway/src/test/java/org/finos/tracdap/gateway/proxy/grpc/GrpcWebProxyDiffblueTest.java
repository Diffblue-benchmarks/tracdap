package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GrpcWebProxyDiffblueTest {
  /**
   * Test {@link GrpcWebProxy#GrpcWebProxy(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#GrpcWebProxy(int)}
   */
  @Test
  @DisplayName("Test new GrpcWebProxy(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.<init>(int)"})
  void testNewGrpcWebProxy_whenOne() {
    // Arrange, Act and Assert
    assertFalse(new GrpcWebProxy(1).isSharable());
  }

  /**
   * Test {@link GrpcWebProxy#GrpcWebProxy(int)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link GrpcWebProxy#GrpcWebProxy(int)}
   */
  @Test
  @DisplayName("Test new GrpcWebProxy(int); when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GrpcWebProxy.<init>(int)"})
  void testNewGrpcWebProxy_whenTwo() {
    // Arrange, Act and Assert
    assertFalse(new GrpcWebProxy(2).isSharable());
  }
}
