package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
import com.google.protobuf.AnyProto;
import com.google.protobuf.BoolValue;
import com.google.protobuf.BytesValue;
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add Descriptor.</li>
   *   <li>Then calls {@link ITracExtension#configExtensions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigParser#ConfigParser(List)}
   */
  @Test
  @DisplayName("Test new ConfigParser(List); given ArrayList() add Descriptor; then calls configExtensions()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then calls {@link ITracExtension#configExtensions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigParser#ConfigParser(List)}
   */
  @Test
  @DisplayName("Test new ConfigParser(List); then calls configExtensions()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link EConfigParse}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigParser#ConfigParser(List)}
   */
  @Test
  @DisplayName("Test new ConfigParser(List); then throw EConfigParse")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConfigParser.<init>(List)"})
  void testNewConfigParser_thenThrowEConfigParse() {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.configExtensions()).thenThrow(new EConfigParse("Not all who wander are lost"));

    ArrayList<ITracExtension> extensions = new ArrayList<>();
    extensions.add(iTracExtension);

    // Act and Assert
    assertThrows(EConfigParse.class, () -> new ConfigParser(extensions));
    verify(iTracExtension).configExtensions();
  }

  /**
   * Test {@link ConfigParser#parseConfig(byte[], ConfigFormat, Class, boolean)} with {@code configData}, {@code configFormat}, {@code configClass}, {@code leniency}.
   * <p>
   * Method under test: {@link ConfigParser#parseConfig(byte[], ConfigFormat, Class, boolean)}
   */
  @Test
  @DisplayName("Test parseConfig(byte[], ConfigFormat, Class, boolean) with 'configData', 'configFormat', 'configClass', 'leniency'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigParser.parseConfig(byte[], ConfigFormat, Class, boolean)"})
  void testParseConfigWithConfigDataConfigFormatConfigClassLeniency() throws UnsupportedEncodingException {
    // Arrange
    ConfigParser configParser = new ConfigParser();
    byte[] configData = "AXAXAXAX".getBytes("UTF-8");
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EUnexpected.class, () -> configParser.parseConfig(configData, ConfigFormat.YAML, configClass, true));
  }

  /**
   * Test {@link ConfigParser#parseConfig(byte[], ConfigFormat, Class)} with {@code configData}, {@code configFormat}, {@code configClass}.
   * <ul>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigParser#parseConfig(byte[], ConfigFormat, Class)}
   */
  @Test
  @DisplayName("Test parseConfig(byte[], ConfigFormat, Class) with 'configData', 'configFormat', 'configClass'; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Message ConfigParser.parseConfig(byte[], ConfigFormat, Class)"})
  void testParseConfigWithConfigDataConfigFormatConfigClass_thenThrowEUnexpected() throws UnsupportedEncodingException {
    // Arrange
    ConfigParser configParser = new ConfigParser();
    byte[] configData = "AXAXAXAX".getBytes("UTF-8");
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EUnexpected.class, () -> configParser.parseConfig(configData, ConfigFormat.YAML, configClass));
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   * <p>
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName("Test quoteConfig(Message, ConfigFormat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig() throws UnsupportedEncodingException {
    // Arrange
    ConfigParser configParser = new ConfigParser();

    // Act
    byte[] actualQuoteConfigResult = configParser.quoteConfig(Advice.getDefaultInstance(), ConfigFormat.YAML);

    // Assert
    assertArrayEquals("--- {}\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   * <ul>
   *   <li>Given {@link ConfigParser#ConfigParser()}.</li>
   *   <li>Then return {@code --- opaqueKey: "part-root"} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName("Test quoteConfig(Message, ConfigFormat); given ConfigParser(); then return '--- opaqueKey: \"part-root\"' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig_givenConfigParser_thenReturnOpaqueKeyPartRootBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteConfigResult = (new ConfigParser()).quoteConfig(PartKeys.ROOT, ConfigFormat.YAML);

    // Assert
    assertArrayEquals("---\nopaqueKey: \"part-root\"\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   * <ul>
   *   <li>Given {@link ConfigParser#ConfigParser()}.</li>
   *   <li>When {@code PROTO}.</li>
   *   <li>Then return {@code part-root} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName("Test quoteConfig(Message, ConfigFormat); given ConfigParser(); when 'PROTO'; then return 'part-root' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig_givenConfigParser_whenProto_thenReturnPartRootBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteConfigResult = (new ConfigParser()).quoteConfig(PartKeys.ROOT, ConfigFormat.PROTO);

    // Assert
    assertArrayEquals("\n\tpart-root".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   * <ul>
   *   <li>Then return {@code --- ""} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName("Test quoteConfig(Message, ConfigFormat); then return '--- \"\"' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig_thenReturnDashDashDashSpaceQuotationMarkQuotationMarkBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.configExtensions()).thenReturn(new ArrayList<>());

    ArrayList<ITracExtension> extensions = new ArrayList<>();
    extensions.add(iTracExtension);
    ConfigParser configParser = new ConfigParser(extensions);

    // Act
    byte[] actualQuoteConfigResult = configParser.quoteConfig(BytesValue.getDefaultInstance(), ConfigFormat.YAML);

    // Assert
    verify(iTracExtension).configExtensions();
    assertArrayEquals("--- \"\"\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   * <ul>
   *   <li>Then return {@code --- ""} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName("Test quoteConfig(Message, ConfigFormat); then return '--- \"\"' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig_thenReturnDashDashDashSpaceQuotationMarkQuotationMarkBytesIsUtf82()
      throws UnsupportedEncodingException {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.configExtensions()).thenReturn(new ArrayList<>());
    ITracExtension iTracExtension2 = mock(ITracExtension.class);
    when(iTracExtension2.configExtensions()).thenReturn(new ArrayList<>());

    ArrayList<ITracExtension> extensions = new ArrayList<>();
    extensions.add(iTracExtension2);
    extensions.add(iTracExtension);
    ConfigParser configParser = new ConfigParser(extensions);

    // Act
    byte[] actualQuoteConfigResult = configParser.quoteConfig(BytesValue.getDefaultInstance(), ConfigFormat.YAML);

    // Assert
    verify(iTracExtension2).configExtensions();
    verify(iTracExtension).configExtensions();
    assertArrayEquals("--- \"\"\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   * <ul>
   *   <li>Then return {@code --- false} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName("Test quoteConfig(Message, ConfigFormat); then return '--- false' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig_thenReturnFalseBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.configExtensions()).thenReturn(new ArrayList<>());

    ArrayList<ITracExtension> extensions = new ArrayList<>();
    extensions.add(iTracExtension);
    ConfigParser configParser = new ConfigParser(extensions);

    // Act
    byte[] actualQuoteConfigResult = configParser.quoteConfig(BoolValue.getDefaultInstance(), ConfigFormat.YAML);

    // Assert
    verify(iTracExtension).configExtensions();
    assertArrayEquals("--- false\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   * <ul>
   *   <li>When {@code JSON}.</li>
   *   <li>Then return {@code { "opaqueKey": "part-root" }} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName("Test quoteConfig(Message, ConfigFormat); when 'JSON'; then return '{ \"opaqueKey\": \"part-root\" }' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig_whenJson_thenReturnOpaqueKeyPartRootBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteConfigResult = (new ConfigParser()).quoteConfig(PartKeys.ROOT, ConfigFormat.JSON);

    // Assert
    assertArrayEquals("{\n  \"opaqueKey\": \"part-root\"\n}".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Test {@link ConfigParser#quoteConfig(Message, ConfigFormat)}.
   * <ul>
   *   <li>When {@link PartKeys#ROOT}.</li>
   *   <li>Then return {@code --- opaqueKey: "part-root"} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  @DisplayName("Test quoteConfig(Message, ConfigFormat); when ROOT; then return '--- opaqueKey: \"part-root\"' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ConfigParser.quoteConfig(Message, ConfigFormat)"})
  void testQuoteConfig_whenRoot_thenReturnOpaqueKeyPartRootBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteConfigResult = (new ConfigParser(new ArrayList<>())).quoteConfig(PartKeys.ROOT,
        ConfigFormat.YAML);

    // Assert
    assertArrayEquals("---\nopaqueKey: \"part-root\"\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }
}
