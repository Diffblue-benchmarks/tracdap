package org.finos.tracdap.gateway.proxy.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class GrpcUtilsDiffblueTest {
  /**
   * Method under test: {@link GrpcUtils#readLpmFlag(byte[])}
   */
  @Test
  void testReadLpmFlag() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals((short) 65, GrpcUtils.readLpmFlag("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link GrpcUtils#readLpmLength(byte[])}
   */
  @Test
  void testReadLpmLength() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1480677441L, GrpcUtils.readLpmLength("AXAXAXAX".getBytes("UTF-8")));
  }
}
