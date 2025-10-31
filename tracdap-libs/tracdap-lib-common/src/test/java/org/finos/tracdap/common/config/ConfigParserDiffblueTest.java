package org.finos.tracdap.common.config;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.Advice;
import com.google.protobuf.AnyProto;
import com.google.protobuf.BoolValue;
import com.google.protobuf.BytesValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.EConfigParse;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.metadata.PartKeys;
import org.finos.tracdap.common.plugin.ITracExtension;
import org.junit.jupiter.api.Test;

class ConfigParserDiffblueTest {
  /**
   * Method under test: {@link ConfigParser#ConfigParser(List)}
   */
  @Test
  void testNewConfigParser() {
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
   * Method under test:
   * {@link ConfigParser#parseConfig(byte[], ConfigFormat, Class)}
   */
  @Test
  void testParseConfig() throws UnsupportedEncodingException {
    // Arrange
    ConfigParser configParser = new ConfigParser();
    byte[] configData = "AXAXAXAX".getBytes("UTF-8");
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EUnexpected.class, () -> configParser.parseConfig(configData, ConfigFormat.YAML, configClass));
  }

  /**
   * Method under test:
   * {@link ConfigParser#parseConfig(byte[], ConfigFormat, Class, boolean)}
   */
  @Test
  void testParseConfig2() throws UnsupportedEncodingException {
    // Arrange
    ConfigParser configParser = new ConfigParser();
    byte[] configData = "AXAXAXAX".getBytes("UTF-8");
    Class<Message> configClass = Message.class;

    // Act and Assert
    assertThrows(EUnexpected.class, () -> configParser.parseConfig(configData, ConfigFormat.YAML, configClass, true));
  }

  /**
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  void testQuoteConfig() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteConfigResult = (new ConfigParser()).quoteConfig(PartKeys.ROOT, ConfigFormat.YAML);

    // Assert
    assertArrayEquals("---\nopaqueKey: \"part-root\"\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  void testQuoteConfig2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteConfigResult = (new ConfigParser()).quoteConfig(PartKeys.ROOT, ConfigFormat.PROTO);

    // Assert
    assertArrayEquals("\n\tpart-root".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  void testQuoteConfig3() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteConfigResult = (new ConfigParser()).quoteConfig(PartKeys.ROOT, ConfigFormat.JSON);

    // Assert
    assertArrayEquals("{\n  \"opaqueKey\": \"part-root\"\n}".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  void testQuoteConfig4() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteConfigResult = (new ConfigParser(new ArrayList<>())).quoteConfig(PartKeys.ROOT,
        ConfigFormat.YAML);

    // Assert
    assertArrayEquals("---\nopaqueKey: \"part-root\"\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  void testQuoteConfig5() throws UnsupportedEncodingException {
    // Arrange
    ConfigParser configParser = new ConfigParser();

    // Act
    byte[] actualQuoteConfigResult = configParser.quoteConfig(Advice.getDefaultInstance(), ConfigFormat.YAML);

    // Assert
    assertArrayEquals("--- {}\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  void testQuoteConfig6() throws UnsupportedEncodingException {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.configExtensions()).thenReturn(new ArrayList<>());

    ArrayList<ITracExtension> extensions = new ArrayList<>();
    extensions.add(iTracExtension);

    // Act
    byte[] actualQuoteConfigResult = (new ConfigParser(extensions)).quoteConfig(PartKeys.ROOT, ConfigFormat.YAML);

    // Assert
    verify(iTracExtension).configExtensions();
    assertArrayEquals("---\nopaqueKey: \"part-root\"\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  void testQuoteConfig7() throws UnsupportedEncodingException {
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
    byte[] actualQuoteConfigResult = configParser.quoteConfig(BoolValue.getDefaultInstance(), ConfigFormat.YAML);

    // Assert
    verify(iTracExtension2).configExtensions();
    verify(iTracExtension).configExtensions();
    assertArrayEquals("--- false\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  void testQuoteConfig8() throws UnsupportedEncodingException {
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
   * Method under test: {@link ConfigParser#quoteConfig(Message, ConfigFormat)}
   */
  @Test
  void testQuoteConfig9() throws UnsupportedEncodingException {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.configExtensions()).thenReturn(new ArrayList<>());
    ITracExtension iTracExtension2 = mock(ITracExtension.class);
    when(iTracExtension2.configExtensions()).thenReturn(new ArrayList<>());
    ITracExtension iTracExtension3 = mock(ITracExtension.class);
    when(iTracExtension3.configExtensions()).thenReturn(new ArrayList<>());

    ArrayList<ITracExtension> extensions = new ArrayList<>();
    extensions.add(iTracExtension3);
    extensions.add(iTracExtension2);
    extensions.add(iTracExtension);
    ConfigParser configParser = new ConfigParser(extensions);

    // Act
    byte[] actualQuoteConfigResult = configParser.quoteConfig(BytesValue.getDefaultInstance(), ConfigFormat.YAML);

    // Assert
    verify(iTracExtension3).configExtensions();
    verify(iTracExtension2).configExtensions();
    verify(iTracExtension).configExtensions();
    assertArrayEquals("--- \"\"\n".getBytes("UTF-8"), actualQuoteConfigResult);
  }

  /**
   * Method under test: {@link ConfigParser#ConfigParser(List)}
   */
  @Test
  void testNewConfigParser2() {
    // Arrange
    ArrayList<Descriptors.FileDescriptor> fileDescriptorList = new ArrayList<>();
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
   * Method under test: {@link ConfigParser#ConfigParser(List)}
   */
  @Test
  void testNewConfigParser3() {
    // Arrange
    ITracExtension iTracExtension = mock(ITracExtension.class);
    when(iTracExtension.configExtensions()).thenThrow(new EConfigParse("Not all who wander are lost"));

    ArrayList<ITracExtension> extensions = new ArrayList<>();
    extensions.add(iTracExtension);

    // Act and Assert
    assertThrows(EConfigParse.class, () -> new ConfigParser(extensions));
    verify(iTracExtension).configExtensions();
  }
}
