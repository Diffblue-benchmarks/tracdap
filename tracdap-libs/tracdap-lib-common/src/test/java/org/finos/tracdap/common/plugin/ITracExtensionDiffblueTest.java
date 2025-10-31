package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.test.TestConfigExtension;
import org.finos.tracdap.common.middleware.CommonConcerns;
import org.finos.tracdap.common.middleware.CommonGrpcConcerns;
import org.finos.tracdap.common.middleware.CommonNettyConcerns;
import org.finos.tracdap.common.middleware.GrpcConcern;
import org.finos.tracdap.common.middleware.NettyConcern;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ITracExtensionDiffblueTest {
  /**
   * Method under test: {@link ITracExtension#pluginTypes()}
   */
  @Test
  void testPluginTypes() {
    // Arrange, Act and Assert
    assertTrue((new TestConfigExtension()).pluginTypes().isEmpty());
  }

  /**
   * Method under test: {@link ITracExtension#pluginTypes()}
   */
  @Test
  void testPluginTypes2() {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.pluginTypes()).thenReturn(new ArrayList<>());

    // Act
    iTracExtension.pluginTypes();

    // Assert
    verify(iTracExtension).pluginTypes();
  }

  /**
   * Method under test:
   * {@link ITracExtension#addServiceConcerns(CommonConcerns, ConfigManager, String)}
   */
  @Test
  void testAddServiceConcerns() {
    // Arrange
    TestConfigExtension testConfigExtension = new TestConfigExtension();
    CommonGrpcConcerns serviceConcerns = new CommonGrpcConcerns("Concern Name");
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    CommonConcerns<GrpcConcern> actualAddServiceConcernsResult = testConfigExtension.addServiceConcerns(serviceConcerns,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()), "Service Key");

    // Assert
    assertTrue(actualAddServiceConcernsResult instanceof CommonGrpcConcerns);
    assertEquals("Concern Name", actualAddServiceConcernsResult.concernName());
    assertSame(serviceConcerns, actualAddServiceConcernsResult);
  }

  /**
   * Method under test:
   * {@link ITracExtension#addServiceConcerns(CommonConcerns, ConfigManager, String)}
   */
  @Test
  void testAddServiceConcerns2() {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.addServiceConcerns(Mockito.<CommonConcerns<GrpcConcern>>any(), Mockito.<ConfigManager>any(),
        Mockito.<String>any())).thenReturn(new CommonGrpcConcerns("Concern Name"));
    CommonGrpcConcerns serviceConcerns = new CommonGrpcConcerns("Concern Name");
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    iTracExtension.addServiceConcerns(serviceConcerns,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()), "Service Key");

    // Assert
    verify(iTracExtension).addServiceConcerns(isA(CommonConcerns.class), isA(ConfigManager.class), eq("Service Key"));
  }

  /**
   * Method under test:
   * {@link ITracExtension#addGatewayConcerns(CommonConcerns, ConfigManager)}
   */
  @Test
  void testAddGatewayConcerns() {
    // Arrange
    TestConfigExtension testConfigExtension = new TestConfigExtension();
    CommonNettyConcerns gatewayConcerns = new CommonNettyConcerns("Concern Name");
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    CommonConcerns<NettyConcern> actualAddGatewayConcernsResult = testConfigExtension.addGatewayConcerns(
        gatewayConcerns, new ConfigManager("https://example.org/example", workingDir, new PluginManager()));

    // Assert
    assertTrue(actualAddGatewayConcernsResult instanceof CommonNettyConcerns);
    assertEquals("Concern Name", actualAddGatewayConcernsResult.concernName());
    assertSame(gatewayConcerns, actualAddGatewayConcernsResult);
  }

  /**
   * Method under test:
   * {@link ITracExtension#addGatewayConcerns(CommonConcerns, ConfigManager)}
   */
  @Test
  void testAddGatewayConcerns2() {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.addGatewayConcerns(Mockito.<CommonConcerns<NettyConcern>>any(), Mockito.<ConfigManager>any()))
        .thenReturn(new CommonNettyConcerns("Concern Name"));
    CommonNettyConcerns gatewayConcerns = new CommonNettyConcerns("Concern Name");
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    iTracExtension.addGatewayConcerns(gatewayConcerns,
        new ConfigManager("https://example.org/example", workingDir, new PluginManager()));

    // Assert
    verify(iTracExtension).addGatewayConcerns(isA(CommonConcerns.class), isA(ConfigManager.class));
  }
}
