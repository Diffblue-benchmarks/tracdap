package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class GrpcServiceRegisterDiffblueTest {
  /**
   * Method under test: {@link GrpcServiceRegister.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    GrpcServiceRegister actualBuildResult = GrpcServiceRegister.newBuilder().build();

    // Assert
    assertTrue(actualBuildResult.methodMap.isEmpty());
    assertTrue(actualBuildResult.serviceMap.isEmpty());
  }

  /**
   * Method under test: {@link GrpcServiceRegister.Builder#registerServices(List)}
   */
  @Test
  void testBuilderRegisterServices() {
    // Arrange
    GrpcServiceRegister.Builder newBuilderResult = GrpcServiceRegister.newBuilder();

    // Act
    GrpcServiceRegister.Builder actualRegisterServicesResult = newBuilderResult.registerServices(new ArrayList<>());

    // Assert
    assertTrue(newBuilderResult.serviceMap.isEmpty());
    assertSame(newBuilderResult, actualRegisterServicesResult);
  }
}
