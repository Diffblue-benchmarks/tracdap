package org.finos.tracdap.test.helpers;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Consumer;
import org.finos.tracdap.common.middleware.GrpcConcern;
import org.finos.tracdap.common.service.TracServiceBase;
import org.junit.jupiter.api.Test;

class PlatformTestDiffblueTest {
  /**
   * Method under test: {@link PlatformTest.Builder#addTenant(String)}
   */
  @Test
  void testBuilderAddTenant() {
    // Arrange
    PlatformTest.Builder builder = new PlatformTest.Builder();

    // Act and Assert
    assertSame(builder, builder.addTenant("Test Tenant"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTest.Builder#build()}
   *   <li>{@link PlatformTest.Builder#manageDataPrefix(boolean)}
   *   <li>{@link PlatformTest.Builder#prepareLocalExecutor(boolean)}
   *   <li>{@link PlatformTest.Builder#runDbDeploy(boolean)}
   *   <li>{@link PlatformTest.Builder#storageFormat(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    PlatformTest actualBuildResult = (new PlatformTest.Builder()).manageDataPrefix(true)
        .prepareLocalExecutor(true)
        .runDbDeploy(true)
        .storageFormat("Storage Format")
        .build();

    // Assert
    assertNull(actualBuildResult.platformConfigUrl());
    assertNull(actualBuildResult.tracRepoDir());
    assertNull(actualBuildResult.workingDir());
    assertNull(actualBuildResult.configManager());
    assertNull(actualBuildResult.pluginManager());
    assertNull(actualBuildResult.platformConfig());
  }

  /**
   * Method under test: {@link PlatformTest.Builder#clientConcern(GrpcConcern)}
   */
  @Test
  void testBuilderClientConcern() {
    // Arrange
    PlatformTest.Builder builder = new PlatformTest.Builder();
    GrpcConcern concern = mock(GrpcConcern.class);
    when(concern.concernName()).thenReturn("Concern Name");

    // Act
    PlatformTest.Builder actualClientConcernResult = builder.clientConcern(concern);

    // Assert
    verify(concern, atLeast(1)).concernName();
    assertSame(builder, actualClientConcernResult);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PlatformTest.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    PlatformTest buildResult = (new PlatformTest.Builder()).build();
    assertNull(buildResult.platformConfigUrl());
    assertNull(buildResult.tracRepoDir());
    assertNull(buildResult.workingDir());
    assertNull(buildResult.configManager());
    assertNull(buildResult.pluginManager());
    assertNull(buildResult.platformConfig());
  }

  /**
   * Method under test: {@link PlatformTest.Builder#preStartAction(Consumer)}
   */
  @Test
  void testBuilderPreStartAction() {
    // Arrange
    PlatformTest.Builder builder = new PlatformTest.Builder();

    // Act and Assert
    assertSame(builder, builder.preStartAction(mock(Consumer.class)));
  }

  /**
   * Method under test: {@link PlatformTest.Builder#startService(Class)}
   */
  @Test
  void testBuilderStartService() {
    // Arrange
    PlatformTest.Builder builder = new PlatformTest.Builder();
    Class<TracServiceBase> serviceClass = TracServiceBase.class;

    // Act and Assert
    assertSame(builder, builder.startService(serviceClass));
  }
}
