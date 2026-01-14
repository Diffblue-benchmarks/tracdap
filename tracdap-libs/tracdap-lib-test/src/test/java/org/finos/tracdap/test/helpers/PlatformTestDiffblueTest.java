package org.finos.tracdap.test.helpers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link Builder#addTenant(String)}
   */
  @Test
  @DisplayName("Test Builder addTenant(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTenant(String)"})
  void testBuilderAddTenant() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddTenantResult = builder.addTenant("Test Tenant");

    // Assert
    assertSame(builder, actualAddTenantResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlatformTest Builder.build()",
    "Builder Builder.manageDataPrefix(boolean)",
    "Builder Builder.prepareLocalExecutor(boolean)",
    "Builder Builder.runDbDeploy(boolean)",
    "Builder Builder.storageFormat(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    PlatformTest actualPlatformTest =
        new Builder()
            .manageDataPrefix(true)
            .prepareLocalExecutor(true)
            .runDbDeploy(true)
            .storageFormat("Storage Format")
            .build();

    // Assert
    assertNull(actualPlatformTest.platformConfigUrl());
    assertNull(actualPlatformTest.tracRepoDir());
    assertNull(actualPlatformTest.workingDir());
    assertNull(actualPlatformTest.configManager());
    assertNull(actualPlatformTest.pluginManager());
    assertNull(actualPlatformTest.platformConfig());
  }

  /**
   * Test Builder {@link Builder#clientConcern(GrpcConcern)}.
   *
   * <p>Method under test: {@link Builder#clientConcern(GrpcConcern)}
   */
  @Test
  @DisplayName("Test Builder clientConcern(GrpcConcern)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    PlatformTest platformTest = new Builder().build();
    assertNull(platformTest.platformConfigUrl());
    assertNull(platformTest.tracRepoDir());
    assertNull(platformTest.workingDir());
    assertNull(platformTest.configManager());
    assertNull(platformTest.pluginManager());
    assertNull(platformTest.platformConfig());
  }

  /**
   * Test Builder {@link Builder#preStartAction(Consumer)}.
   *
   * <p>Method under test: {@link Builder#preStartAction(Consumer)}
   */
  @Test
  @DisplayName("Test Builder preStartAction(Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.preStartAction(Consumer)"})
  void testBuilderPreStartAction() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPreStartActionResult = builder.preStartAction(mock(Consumer.class));

    // Assert
    assertSame(builder, actualPreStartActionResult);
  }

  /**
   * Test Builder {@link Builder#startService(Class)}.
   *
   * <p>Method under test: {@link Builder#startService(Class)}
   */
  @Test
  @DisplayName("Test Builder startService(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.startService(Class)"})
  void testBuilderStartService() {
    // Arrange
    Builder builder = new Builder();
    Class<TracServiceBase> serviceClass = TracServiceBase.class;

    // Act
    Builder actualStartServiceResult = builder.startService(serviceClass);

    // Assert
    assertSame(builder, actualStartServiceResult);
  }

  /**
   * Test {@link PlatformTest#hasMetaSvc()}.
   *
   * <p>Method under test: {@link PlatformTest#hasMetaSvc()}
   */
  @Test
  @DisplayName("Test hasMetaSvc()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlatformTest.hasMetaSvc()"})
  void testHasMetaSvc() {
    // Arrange, Act and Assert
    assertFalse(
        new Builder()
            .prepareLocalExecutor(true)
            .manageDataPrefix(true)
            .runDbDeploy(true)
            .storageFormat("Storage Format")
            .build()
            .hasMetaSvc());
  }

  /**
   * Test {@link PlatformTest#hasDataSvc()}.
   *
   * <p>Method under test: {@link PlatformTest#hasDataSvc()}
   */
  @Test
  @DisplayName("Test hasDataSvc()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlatformTest.hasDataSvc()"})
  void testHasDataSvc() {
    // Arrange, Act and Assert
    assertFalse(
        new Builder()
            .prepareLocalExecutor(true)
            .manageDataPrefix(true)
            .runDbDeploy(true)
            .storageFormat("Storage Format")
            .build()
            .hasDataSvc());
  }

  /**
   * Test {@link PlatformTest#hasOrchSvc()}.
   *
   * <p>Method under test: {@link PlatformTest#hasOrchSvc()}
   */
  @Test
  @DisplayName("Test hasOrchSvc()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlatformTest.hasOrchSvc()"})
  void testHasOrchSvc() {
    // Arrange, Act and Assert
    assertFalse(
        new Builder()
            .prepareLocalExecutor(true)
            .manageDataPrefix(true)
            .runDbDeploy(true)
            .storageFormat("Storage Format")
            .build()
            .hasOrchSvc());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConfigManager PlatformTest.configManager()",
    "Builder PlatformTest.forConfig(String)",
    "Builder PlatformTest.forConfig(String, String)",
    "PlatformConfig PlatformTest.platformConfig()",
    "URL PlatformTest.platformConfigUrl()",
    "PluginManager PlatformTest.pluginManager()",
    "Path PlatformTest.tracRepoDir()",
    "Path PlatformTest.workingDir()"
  })
  void testGettersAndSetters() {
    // Arrange
    PlatformTest platformTest =
        new Builder()
            .prepareLocalExecutor(true)
            .manageDataPrefix(true)
            .runDbDeploy(true)
            .storageFormat("Storage Format")
            .build();

    // Act
    platformTest.forConfig("Test Config");
    platformTest.forConfig("Test Config", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    ConfigManager actualConfigManagerResult = platformTest.configManager();
    PlatformConfig actualPlatformConfigResult = platformTest.platformConfig();
    URL actualPlatformConfigUrlResult = platformTest.platformConfigUrl();
    PluginManager actualPluginManagerResult = platformTest.pluginManager();
    Path actualTracRepoDirResult = platformTest.tracRepoDir();

    // Assert
    assertNull(actualPlatformConfigUrlResult);
    assertNull(actualTracRepoDirResult);
    assertNull(platformTest.workingDir());
    assertNull(actualConfigManagerResult);
    assertNull(actualPluginManagerResult);
    assertNull(actualPlatformConfigResult);
  }
}
