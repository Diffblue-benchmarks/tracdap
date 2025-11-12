package org.finos.tracdap.common.codec.json;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.arrow.memory.ArrowBuf;
import org.apache.arrow.vector.types.pojo.Schema;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JsonDecoderDiffblueTest {
  @InjectMocks private JsonDecoder jsonDecoder;

  @Mock private Schema schema;

  /**
   * Test {@link JsonDecoder#onNext(ArrowBuf)}.
   *
   * <ul>
   *   <li>Given {@link EUnexpected#EUnexpected()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link JsonDecoder#onNext(ArrowBuf)}
   */
  @Test
  @DisplayName("Test onNext(ArrowBuf); given EUnexpected(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonDecoder.onNext(ArrowBuf)"})
  void testOnNext_givenEUnexpected_thenThrowEUnexpected() {
    // Arrange
    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.nioBuffer()).thenThrow(new EUnexpected());
    doThrow(new EUnexpected()).when(chunk).close();

    // Act and Assert
    assertThrows(EUnexpected.class, () -> jsonDecoder.onNext(chunk));
    verify(chunk).close();
    verify(chunk).nioBuffer();
  }
}
