package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.grpc.GrpcServiceRegister.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GrpcServiceRegisterDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GrpcServiceRegister Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    GrpcServiceRegister actualBuildResult = GrpcServiceRegister.newBuilder().build();

    // Assert
    assertTrue(actualBuildResult.methodMap.isEmpty());
    assertTrue(actualBuildResult.serviceMap.isEmpty());
  }

  /**
   * Test Builder {@link Builder#registerServices(List)}.
   * <p>
   * Method under test: {@link Builder#registerServices(List)}
   */
  @Test
  @DisplayName("Test Builder registerServices(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.registerServices(List)"})
  void testBuilderRegisterServices() {
    // Arrange
    Builder newBuilderResult = GrpcServiceRegister.newBuilder();

    // Act and Assert
    assertSame(newBuilderResult, newBuilderResult.registerServices(new ArrayList<>()));
  }

  /**
   * Test {@link GrpcServiceRegister#newBuilder()}.
   * <p>
   * Method under test: {@link GrpcServiceRegister#newBuilder()}
   */
  @Test
  @DisplayName("Test newBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder GrpcServiceRegister.newBuilder()"})
  void testNewBuilder() {
    // Arrange
    GrpcServiceRegister buildResult = GrpcServiceRegister.newBuilder().build();

    // Act
    Builder actualNewBuilderResult = buildResult.newBuilder();

    // Assert
    assertTrue(actualNewBuilderResult.methodMap.isEmpty());
    assertTrue(actualNewBuilderResult.serviceMap.isEmpty());
  }
}
