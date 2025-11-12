package org.finos.tracdap.common.codec;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.codec.arrow.ArrowStreamDecoder;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.StreamApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StreamingDecoderDiffblueTest {
  @InjectMocks private ArrowStreamDecoder arrowStreamDecoder;

  /**
   * Test {@link StreamingDecoder#dataInterface()}.
   *
   * <p>Method under test: {@link StreamingDecoder#dataInterface()}
   */
  @Test
  @DisplayName("Test dataInterface()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPipeline.StreamApi StreamingDecoder.dataInterface()"})
  void testDataInterface() {
    // Arrange and Act
    StreamApi actualDataInterfaceResult = arrowStreamDecoder.dataInterface();

    // Assert
    assertSame(arrowStreamDecoder, actualDataInterfaceResult);
  }
}
