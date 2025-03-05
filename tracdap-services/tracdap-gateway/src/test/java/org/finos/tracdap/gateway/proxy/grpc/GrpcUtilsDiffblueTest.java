package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GrpcUtilsDiffblueTest {
  /**
   * Test {@link GrpcUtils#readLpmFlag(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcUtils#readLpmFlag(byte[])}
   */
  @Test
  @DisplayName("Test readLpmFlag(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"short GrpcUtils.readLpmFlag(byte[])"})
  void testReadLpmFlag_whenAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals((short) 65, GrpcUtils.readLpmFlag("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link GrpcUtils#readLpmLength(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code 1480677441}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GrpcUtils#readLpmLength(byte[])}
   */
  @Test
  @DisplayName("Test readLpmLength(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '1480677441'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long GrpcUtils.readLpmLength(byte[])"})
  void testReadLpmLength_whenAxaxaxaxBytesIsUtf8_thenReturn1480677441() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1480677441L, GrpcUtils.readLpmLength("AXAXAXAX".getBytes("UTF-8")));
  }
}
