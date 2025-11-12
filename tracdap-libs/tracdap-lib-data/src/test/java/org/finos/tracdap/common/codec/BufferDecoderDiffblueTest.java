package org.finos.tracdap.common.codec;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.codec.arrow.ArrowFileDecoder;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.BufferApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BufferDecoderDiffblueTest {
  @InjectMocks private ArrowFileDecoder arrowFileDecoder;

  /**
   * Test {@link BufferDecoder#dataInterface()}.
   *
   * <p>Method under test: {@link BufferDecoder#dataInterface()}
   */
  @Test
  @DisplayName("Test dataInterface()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferApi BufferDecoder.dataInterface()"})
  void testDataInterface() {
    // Arrange and Act
    BufferApi actualDataInterfaceResult = arrowFileDecoder.dataInterface();

    // Assert
    assertSame(arrowFileDecoder, actualDataInterfaceResult);
  }

  /**
   * Test {@link BufferDecoder#isReady()}.
   *
   * <p>Method under test: {@link BufferDecoder#isReady()}
   */
  @Test
  @DisplayName("Test isReady()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BufferDecoder.isReady()"})
  void testIsReady() {
    // Arrange, Act and Assert
    assertTrue(arrowFileDecoder.isReady());
  }
}
