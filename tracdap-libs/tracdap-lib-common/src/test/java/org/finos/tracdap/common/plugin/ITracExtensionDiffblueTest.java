package org.finos.tracdap.common.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FileDescriptor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.finos.tracdap.common.config.ConfigManager;
import org.finos.tracdap.common.config.test.TestConfigExtension;
import org.finos.tracdap.common.middleware.CommonConcerns;
import org.finos.tracdap.common.middleware.CommonGrpcConcerns;
import org.finos.tracdap.common.middleware.CommonNettyConcerns;
import org.finos.tracdap.common.middleware.GrpcConcern;
import org.finos.tracdap.common.middleware.NettyConcern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ITracExtensionDiffblueTest {
  /**
   * Test {@link ITracExtension#configExtensions()}.
   *
   * <p>Method under test: {@link ITracExtension#configExtensions()}
   */
  @Test
  @DisplayName("Test configExtensions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ITracExtension.configExtensions()"})
  void testConfigExtensions() {
    // Arrange and Act
    List<FileDescriptor> actualConfigExtensionsResult =
        new TestConfigExtension().configExtensions();

    // Assert
    assertEquals(1, actualConfigExtensionsResult.size());
    FileDescriptor getResult = actualConfigExtensionsResult.get(0);
    assertEquals("tracdap.test.config", getResult.getPackage());
    assertEquals("tracdap/test/config/config_extensions.proto", getResult.getFullName());
    assertEquals("tracdap/test/config/config_extensions.proto", getResult.getName());
    assertEquals(1, getResult.getDependencies().size());
    assertEquals(1, getResult.getMessageTypes().size());
    assertTrue(getResult.getEnumTypes().isEmpty());
    assertTrue(getResult.getExtensions().isEmpty());
    assertTrue(getResult.getPublicDependencies().isEmpty());
    assertTrue(getResult.getServices().isEmpty());
  }

  /**
   * Test {@link ITracExtension#pluginTypes()}.
   *
   * <p>Method under test: {@link ITracExtension#pluginTypes()}
   */
  @Test
  @DisplayName("Test pluginTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ITracExtension.pluginTypes()"})
  void testPluginTypes() {
    // Arrange, Act and Assert
    assertTrue(new TestConfigExtension().pluginTypes().isEmpty());
  }

  /**
   * Test {@link ITracExtension#addServiceConcerns(CommonConcerns, ConfigManager, String)}.
   *
   * <p>Method under test: {@link ITracExtension#addServiceConcerns(CommonConcerns, ConfigManager,
   * String)}
   */
  @Test
  @DisplayName("Test addServiceConcerns(CommonConcerns, ConfigManager, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonConcerns ITracExtension.addServiceConcerns(CommonConcerns, ConfigManager, String)"
  })
  void testAddServiceConcerns() {
    // Arrange
    TestConfigExtension testConfigExtension = new TestConfigExtension();
    CommonGrpcConcerns serviceConcerns = new CommonGrpcConcerns("Concern Name");
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act
    CommonConcerns<GrpcConcern> actualAddServiceConcernsResult =
        testConfigExtension.addServiceConcerns(serviceConcerns, configManager, "Service Key");

    // Assert
    assertTrue(actualAddServiceConcernsResult instanceof CommonGrpcConcerns);
    assertEquals("Concern Name", actualAddServiceConcernsResult.concernName());
    assertSame(serviceConcerns, actualAddServiceConcernsResult);
  }

  /**
   * Test {@link ITracExtension#addGatewayConcerns(CommonConcerns, ConfigManager)}.
   *
   * <p>Method under test: {@link ITracExtension#addGatewayConcerns(CommonConcerns, ConfigManager)}
   */
  @Test
  @DisplayName("Test addGatewayConcerns(CommonConcerns, ConfigManager)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonConcerns ITracExtension.addGatewayConcerns(CommonConcerns, ConfigManager)"
  })
  void testAddGatewayConcerns() {
    // Arrange
    TestConfigExtension testConfigExtension = new TestConfigExtension();
    CommonNettyConcerns gatewayConcerns = new CommonNettyConcerns("Concern Name");
    Path workingDir = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    ConfigManager configManager =
        new ConfigManager("https://example.org/example", workingDir, new PluginManager());

    // Act
    CommonConcerns<NettyConcern> actualAddGatewayConcernsResult =
        testConfigExtension.addGatewayConcerns(gatewayConcerns, configManager);

    // Assert
    assertTrue(actualAddGatewayConcernsResult instanceof CommonNettyConcerns);
    assertEquals("Concern Name", actualAddGatewayConcernsResult.concernName());
    assertSame(gatewayConcerns, actualAddGatewayConcernsResult);
  }
}
