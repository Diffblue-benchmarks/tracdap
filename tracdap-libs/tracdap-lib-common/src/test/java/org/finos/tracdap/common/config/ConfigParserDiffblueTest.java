package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Message;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.EConfigParse;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.metadata.PartKeys;
import org.finos.tracdap.common.plugin.ITracExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConfigParserDiffblueTest {
  /**
   * Test {@link ConfigParser#ConfigParser(List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add Descriptor.
   *   <li>Then calls {@link ITracExtension#configExtensions()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigParser#ConfigParser(List)}
   */
  @Test
  @DisplayName(
      "Test new ConfigParser(List); given ArrayList() add Descriptor; then calls configExtensions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigParser.<init>(List)"})
  void testNewConfigParser_givenArrayListAddDescriptor_thenCallsConfigExtensions() {
    // Arrange
    ArrayList<FileDescriptor> fileDescriptorList = new ArrayList<>();
    fileDescriptorList.add(AnyProto.getDescriptor());

    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.configExtensions()).thenReturn(fileDescriptorList);

    ArrayList<ITracExtension> extensions = new ArrayList<>();
    extensions.add(iTracExtension);

    // Act
    new ConfigParser(extensions);

    // Assert
    verify(iTracExtension).configExtensions();
  }

  /**
   * Test {@link ConfigParser#ConfigParser(List)}.
   *
   * <ul>
   *   <li>Then calls {@link ITracExtension#configExtensions()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigParser#ConfigParser(List)}
   */
  @Test
  @DisplayName("Test new ConfigParser(List); then calls configExtensions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigParser.<init>(List)"})
  void testNewConfigParser_thenCallsConfigExtensions() {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.configExtensions()).thenReturn(new ArrayList<>());

    ArrayList<ITracExtension> extensions = new ArrayList<>();
    extensions.add(iTracExtension);

    // Act
    new ConfigParser(extensions);

    // Assert
    verify(iTracExtension).configExtensions();
  }

  /**
   * Test {@link ConfigParser#ConfigParser(List)}.
   *
   * <ul>
   *   <li>Then throw {@link EConfigParse}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigParser#ConfigParser(List)}
   */
  @Test
  @DisplayName("Test new ConfigParser(List); then throw EConfigParse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigParser.<init>(List)"})
  void testNewConfigParser_thenThrowEConfigParse() {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.configExtensions())
        .thenThrow(new EConfigParse("Not all who wander are lost"));

    ArrayList<ITracExtension> extensions = new ArrayList<>();
    extensions.add(iTracExtension);

    // Act and Assert
    assertThrows(EConfigParse.class, () -> new ConfigParser(extensions));
    verify(iTracExtension).configExtensions();
  }

  /**
   * Test {@link ConfigParser#ConfigParser(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ConfigParser#ConfigParser(List)}
   */
  @Test
  @DisplayName("Test new ConfigParser(List); when ArrayList(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigParser.<init>(List)"})
  void testNewConfigParser_whenArrayList_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new ConfigParser(new ArrayList<>()));
  }

  /**
   * Test {@link ConfigParser#parseConfig(byte[], ConfigFormat, Class, boolean)} with {@code
   * configData}, {@code configFormat}, {@code configClass}, {@code leniency}.
   *
   * <p>Method under test: {@link ConfigParser#parseConfig(byte[], ConfigFormat, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseConfig(byte[], ConfigFormat, Class, boolean) with 'configData', 'configFormat', 'configClass', 'leniency'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigParser.parseConfig(byte[], ConfigFormat, Class, boolean)"})
  void testParseConfigWithConfigDataConfigFormatConfigClassLeniency()
      throws UnsupportedEncodingException {
    // Arrange
    ConfigParser configParser = new ConfigParser();
    byte[] configData = "AXAXAXAX".getBytes("UTF-8");
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> configParser.parseConfig(configData, ConfigFormat.YAML, configClass, true));
  }

  /**
   * Test {@link ConfigParser#parseConfig(byte[], ConfigFormat, Class)} with {@code configData},
   * {@code configFormat}, {@code configClass}.
   *
   * <ul>
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigParser#parseConfig(byte[], ConfigFormat, Class)}
   */
  @Test
  @DisplayName(
      "Test parseConfig(byte[], ConfigFormat, Class) with 'configData', 'configFormat', 'configClass'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message ConfigParser.parseConfig(byte[], ConfigFormat, Class)"})
  void testParseConfigWithConfigDataConfigFormatConfigClass_thenThrowEUnexpected()
      throws UnsupportedEncodingException {
    // Arrange
    ConfigParser configParser = new ConfigParser();
    byte[] configData = "AXAXAXAX".getBytes("UTF-8");
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> configParser.parseConfig(configData, ConfigFormat.YAML, configClass));
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   *
   * <ul>
   *   <li>Given {@link ConfigParser#ConfigParser(List)} with extensions is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName(
      "Test quoteConfig(Message, ConfigFormat); given ConfigParser(List) with extensions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig_givenConfigParserWithExtensionsIsArrayList()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "---\nopaqueKey: \"part-root\"\n".getBytes("UTF-8"),
        new ConfigParser(new ArrayList<>()).quoteConfig(PartKeys.ROOT, ConfigFormat.YAML));
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   *
   * <ul>
   *   <li>Given {@link ConfigParser#ConfigParser()}.
   *   <li>When {@code PROTO}.
   *   <li>Then return {@code part-root} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName(
      "Test quoteConfig(Message, ConfigFormat); given ConfigParser(); when 'PROTO'; then return 'part-root' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig_givenConfigParser_whenProto_thenReturnPartRootBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "\n\tpart-root".getBytes("UTF-8"),
        new ConfigParser().quoteConfig(PartKeys.ROOT, ConfigFormat.PROTO));
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   *
   * <ul>
   *   <li>When {@code JSON}.
   *   <li>Then return {@code { "opaqueKey": "part-root" }} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName(
      "Test quoteConfig(Message, ConfigFormat); when 'JSON'; then return '{ \"opaqueKey\": \"part-root\" }' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig_whenJson_thenReturnOpaqueKeyPartRootBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "{\n  \"opaqueKey\": \"part-root\"\n}".getBytes("UTF-8"),
        new ConfigParser().quoteConfig(PartKeys.ROOT, ConfigFormat.JSON));
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   *
   * <ul>
   *   <li>When {@code YAML}.
   *   <li>Then return {@code --- opaqueKey: "part-root"} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName(
      "Test quoteConfig(Message, ConfigFormat); when 'YAML'; then return '--- opaqueKey: \"part-root\"' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig_whenYaml_thenReturnOpaqueKeyPartRootBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "---\nopaqueKey: \"part-root\"\n".getBytes("UTF-8"),
        new ConfigParser().quoteConfig(PartKeys.ROOT, ConfigFormat.YAML));
  }
}
