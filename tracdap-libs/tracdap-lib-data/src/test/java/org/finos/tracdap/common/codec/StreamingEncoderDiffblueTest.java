package org.finos.tracdap.common.codec;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.codec.arrow.ArrowFileEncoder;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.ArrowApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StreamingEncoderDiffblueTest {
  @InjectMocks private ArrowFileEncoder arrowFileEncoder;

  /**
   * Test {@link StreamingEncoder#dataInterface()}.
   *
   * <p>Method under test: {@link StreamingEncoder#dataInterface()}
   */
  @Test
  @DisplayName("Test dataInterface()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPipeline.ArrowApi StreamingEncoder.dataInterface()"})
  void testDataInterface() {
    // Arrange and Act
    ArrowApi actualDataInterfaceResult = arrowFileEncoder.dataInterface();

    // Assert
    assertSame(arrowFileEncoder, actualDataInterfaceResult);
  }
}
