package org.finos.tracdap.test.helpers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.URL;
import java.nio.file.Path;
import java.util.function.Consumer;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.middleware.GrpcConcern;
import org.finos.tracdap.common.plugin.PluginManager;
import org.finos.tracdap.common.service.TracServiceBase;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.test.helpers.PlatformTest.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlatformTestDiffblueTest {
  /**
   * Test Builder {@link Builder#addTenant(String)}.
   * <p>
   * Method under test: {@link Builder#addTenant(String)}
   */
  @Test
  @DisplayName("Test Builder addTenant(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTenant(String)"})
  void testBuilderAddTenant() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.addTenant("Test Tenant"));
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#manageDataPrefix(boolean)}
   *   <li>{@link Builder#prepareLocalExecutor(boolean)}
   *   <li>{@link Builder#runDbDeploy(boolean)}
   *   <li>{@link Builder#storageFormat(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PlatformTest Builder.build()", "Builder Builder.manageDataPrefix(boolean)",
      "Builder Builder.prepareLocalExecutor(boolean)", "Builder Builder.runDbDeploy(boolean)",
      "Builder Builder.storageFormat(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    PlatformTest actualBuildResult = (new Builder()).manageDataPrefix(true)
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
   * Test Builder {@link Builder#clientConcern(GrpcConcern)}.
   * <p>
   * Method under test: {@link Builder#clientConcern(GrpcConcern)}
   */
  @Test
  @DisplayName("Test Builder clientConcern(GrpcConcern)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.clientConcern(GrpcConcern)"})
  void testBuilderClientConcern() {
    // Arrange
    Builder builder = new Builder();
    GrpcConcern concern = mock(GrpcConcern.class);
    when(concern.concernName()).thenReturn("Concern Name");

    // Act
    Builder actualClientConcernResult = builder.clientConcern(concern);

    // Assert
    verify(concern, atLeast(1)).concernName();
    assertSame(builder, actualClientConcernResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    PlatformTest buildResult = (new Builder()).build();
    assertNull(buildResult.platformConfigUrl());
    assertNull(buildResult.tracRepoDir());
    assertNull(buildResult.workingDir());
    assertNull(buildResult.configManager());
    assertNull(buildResult.pluginManager());
    assertNull(buildResult.platformConfig());
  }

  /**
   * Test Builder {@link Builder#preStartAction(Consumer)}.
   * <p>
   * Method under test: {@link Builder#preStartAction(Consumer)}
   */
  @Test
  @DisplayName("Test Builder preStartAction(Consumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.preStartAction(Consumer)"})
  void testBuilderPreStartAction() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.preStartAction(mock(Consumer.class)));
  }

  /**
   * Test Builder {@link Builder#startService(Class)}.
   * <p>
   * Method under test: {@link Builder#startService(Class)}
   */
  @Test
  @DisplayName("Test Builder startService(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.startService(Class)"})
  void testBuilderStartService() {
    // Arrange
    Builder builder = new Builder();
    Class<TracServiceBase> serviceClass = TracServiceBase.class;

    // Act and Assert
    assertSame(builder, builder.startService(serviceClass));
  }

  /**
   * Test {@link PlatformTest#hasMetaSvc()}.
   * <p>
   * Method under test: {@link PlatformTest#hasMetaSvc()}
   */
  @Test
  @DisplayName("Test hasMetaSvc()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformTest.hasMetaSvc()"})
  void testHasMetaSvc() {
    // Arrange
    PlatformTest buildResult = (new Builder()).prepareLocalExecutor(true)
        .manageDataPrefix(true)
        .runDbDeploy(true)
        .storageFormat("Storage Format")
        .build();

    // Act and Assert
    assertFalse(buildResult.hasMetaSvc());
  }

  /**
   * Test {@link PlatformTest#hasDataSvc()}.
   * <p>
   * Method under test: {@link PlatformTest#hasDataSvc()}
   */
  @Test
  @DisplayName("Test hasDataSvc()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformTest.hasDataSvc()"})
  void testHasDataSvc() {
    // Arrange
    PlatformTest buildResult = (new Builder()).prepareLocalExecutor(true)
        .manageDataPrefix(true)
        .runDbDeploy(true)
        .storageFormat("Storage Format")
        .build();

    // Act and Assert
    assertFalse(buildResult.hasDataSvc());
  }

  /**
   * Test {@link PlatformTest#hasOrchSvc()}.
   * <p>
   * Method under test: {@link PlatformTest#hasOrchSvc()}
   */
  @Test
  @DisplayName("Test hasOrchSvc()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformTest.hasOrchSvc()"})
  void testHasOrchSvc() {
    // Arrange
    PlatformTest buildResult = (new Builder()).prepareLocalExecutor(true)
        .manageDataPrefix(true)
        .runDbDeploy(true)
        .storageFormat("Storage Format")
        .build();

    // Act and Assert
    assertFalse(buildResult.hasOrchSvc());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTest#forConfig(String)}
   *   <li>{@link PlatformTest#forConfig(String, String)}
   *   <li>{@link PlatformTest#configManager()}
   *   <li>{@link PlatformTest#platformConfig()}
   *   <li>{@link PlatformTest#platformConfigUrl()}
   *   <li>{@link PlatformTest#pluginManager()}
   *   <li>{@link PlatformTest#tracRepoDir()}
   *   <li>{@link PlatformTest#workingDir()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConfigManager PlatformTest.configManager()", "Builder PlatformTest.forConfig(String)",
      "Builder PlatformTest.forConfig(String, String)", "PlatformConfig PlatformTest.platformConfig()",
      "URL PlatformTest.platformConfigUrl()", "PluginManager PlatformTest.pluginManager()",
      "Path PlatformTest.tracRepoDir()", "Path PlatformTest.workingDir()"})
  void testGettersAndSetters() {
    // Arrange
    PlatformTest buildResult = (new Builder()).prepareLocalExecutor(true)
        .manageDataPrefix(true)
        .runDbDeploy(true)
        .storageFormat("Storage Format")
        .build();

    // Act
    buildResult.forConfig("Test Config");
    buildResult.forConfig("Test Config", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    ConfigManager actualConfigManagerResult = buildResult.configManager();
    PlatformConfig actualPlatformConfigResult = buildResult.platformConfig();
    URL actualPlatformConfigUrlResult = buildResult.platformConfigUrl();
    PluginManager actualPluginManagerResult = buildResult.pluginManager();
    Path actualTracRepoDirResult = buildResult.tracRepoDir();

    // Assert
    assertNull(actualPlatformConfigUrlResult);
    assertNull(actualTracRepoDirResult);
    assertNull(buildResult.workingDir());
    assertNull(actualConfigManagerResult);
    assertNull(actualPluginManagerResult);
    assertNull(actualPlatformConfigResult);
  }
}
