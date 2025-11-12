package org.finos.tracdap.common.codec.arrow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.EDataCorruption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArrowDecoderDiffblueTest {
  @InjectMocks private ArrowFileDecoder arrowFileDecoder;

  /**
   * Test {@link ArrowDecoder#onBuffer(List)}.
   *
   * <p>Method under test: {@link ArrowDecoder#onBuffer(List)}
   */
  @Test
  @DisplayName("Test onBuffer(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrowDecoder.onBuffer(List)"})
  void testOnBuffer() {
    // Arrange, Act and Assert
    assertThrows(EDataCorruption.class, () -> arrowFileDecoder.onBuffer(new ArrayList<>()));
  }
}
