package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Message;
import io.netty.buffer.AdaptiveByteBufAllocator;
import io.netty.buffer.ByteBufAllocator;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GrpcUtilsDiffblueTest {
  /**
   * Test {@link GrpcUtils#encodeLpm(Message, ByteBufAllocator)}.
   *
   * <p>Method under test: {@link GrpcUtils#encodeLpm(Message, ByteBufAllocator)}
   */
  @Test
  @DisplayName("Test encodeLpm(Message, ByteBufAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"io.netty.buffer.ByteBuf GrpcUtils.encodeLpm(Message, ByteBufAllocator)"})
  void testEncodeLpm() {
    // Arrange
    FileOptions defaultInstance = FileOptions.getDefaultInstance();

    // Act and Assert
    assertTrue(GrpcUtils.encodeLpm(defaultInstance, new AdaptiveByteBufAllocator()).isContiguous());
  }

  /**
   * Test {@link GrpcUtils#readLpmFlag(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#readLpmFlag(byte[])}
   */
  @Test
  @DisplayName("Test readLpmFlag(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short GrpcUtils.readLpmFlag(byte[])"})
  void testReadLpmFlag_whenAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals((short) 65, GrpcUtils.readLpmFlag("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link GrpcUtils#readLpmLength(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 1480677441}.
   * </ul>
   *
   * <p>Method under test: {@link GrpcUtils#readLpmLength(byte[])}
   */
  @Test
  @DisplayName(
      "Test readLpmLength(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '1480677441'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long GrpcUtils.readLpmLength(byte[])"})
  void testReadLpmLength_whenAxaxaxaxBytesIsUtf8_thenReturn1480677441()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1480677441L, GrpcUtils.readLpmLength("AXAXAXAX".getBytes("UTF-8")));
  }
}
