package org.finos.tracdap.common.codec.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.types.pojo.Schema;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.ArrowApi;
import org.finos.tracdap.common.exception.EDataCorruption;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CsvDecoderDiffblueTest {
  @Mock private BufferAllocator bufferAllocator;

  @InjectMocks private CsvDecoder csvDecoder;

  @Mock private CsvParser csvParser;

  @Mock private CsvSchema csvSchema;

  @Mock private Schema schema;

  @Mock private VectorSchemaRoot vectorSchemaRoot;

  /**
   * Test {@link CsvDecoder#CsvDecoder(BufferAllocator, Schema)}.
   *
   * <p>Method under test: {@link CsvDecoder#CsvDecoder(BufferAllocator, Schema)}
   */
  @Test
  @DisplayName("Test new CsvDecoder(BufferAllocator, Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsvDecoder.<init>(BufferAllocator, Schema)"})
  void testNewCsvDecoder() {
    // Arrange and Act
    CsvDecoder actualCsvDecoder = new CsvDecoder(bufferAllocator, schema);

    // Assert
    assertFalse(actualCsvDecoder.isDone());
    assertTrue(actualCsvDecoder.isReady());
    Class<ArrowApi> expectedConsumerTypeResult = ArrowApi.class;
    assertEquals(expectedConsumerTypeResult, actualCsvDecoder.consumerType());
  }

  /**
   * Test {@link CsvDecoder#onBuffer(List)}.
   *
   * <p>Method under test: {@link CsvDecoder#onBuffer(List)}
   */
  @Test
  @DisplayName("Test onBuffer(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsvDecoder.onBuffer(List)"})
  void testOnBuffer() {
    // Arrange, Act and Assert
    assertThrows(EDataCorruption.class, () -> csvDecoder.onBuffer(new ArrayList<>()));
  }

  /**
   * Test {@link CsvDecoder#doParse(CsvParser, CsvSchema, VectorSchemaRoot)}.
   *
   * <p>Method under test: {@link CsvDecoder#doParse(CsvParser, CsvSchema, VectorSchemaRoot)}
   */
  @Test
  @DisplayName("Test doParse(CsvParser, CsvSchema, VectorSchemaRoot)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CsvDecoder.doParse(CsvParser, CsvSchema, VectorSchemaRoot)"})
  void testDoParse() throws Exception {
    // Arrange
    when(csvParser.nextToken()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ETracInternal.class, () -> csvDecoder.doParse(csvParser, csvSchema, vectorSchemaRoot));
    verify(csvParser).nextToken();
  }

  /**
   * Test {@link CsvDecoder#doParse(CsvParser, CsvSchema, VectorSchemaRoot)}.
   *
   * <ul>
   *   <li>Then calls {@link VectorSchemaRoot#getVector(int)}.
   * </ul>
   *
   * <p>Method under test: {@link CsvDecoder#doParse(CsvParser, CsvSchema, VectorSchemaRoot)}
   */
  @Test
  @DisplayName("Test doParse(CsvParser, CsvSchema, VectorSchemaRoot); then calls getVector(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CsvDecoder.doParse(CsvParser, CsvSchema, VectorSchemaRoot)"})
  void testDoParse_thenCallsGetVector() throws Exception {
    // Arrange
    when(csvParser.nextToken()).thenReturn(JsonToken.VALUE_NULL);
    when(vectorSchemaRoot.getVector(anyInt()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ETracInternal.class, () -> csvDecoder.doParse(csvParser, csvSchema, vectorSchemaRoot));
    verify(csvParser).nextToken();
    verify(vectorSchemaRoot).getVector(0);
  }

  /**
   * Test {@link CsvDecoder#doParse(CsvParser, CsvSchema, VectorSchemaRoot)}.
   *
   * <ul>
   *   <li>Then calls {@link VectorSchemaRoot#getVector(int)}.
   * </ul>
   *
   * <p>Method under test: {@link CsvDecoder#doParse(CsvParser, CsvSchema, VectorSchemaRoot)}
   */
  @Test
  @DisplayName("Test doParse(CsvParser, CsvSchema, VectorSchemaRoot); then calls getVector(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CsvDecoder.doParse(CsvParser, CsvSchema, VectorSchemaRoot)"})
  void testDoParse_thenCallsGetVector2() throws Exception {
    // Arrange
    when(csvParser.nextToken()).thenReturn(JsonToken.VALUE_TRUE);
    when(vectorSchemaRoot.getVector(anyInt()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ETracInternal.class, () -> csvDecoder.doParse(csvParser, csvSchema, vectorSchemaRoot));
    verify(csvParser).nextToken();
    verify(vectorSchemaRoot).getVector(0);
  }

  /**
   * Test {@link CsvDecoder#handleErrors(Callable)}.
   *
   * <ul>
   *   <li>Given {@link Exception#Exception()}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link CsvDecoder#handleErrors(Callable)}
   */
  @Test
  @DisplayName("Test handleErrors(Callable); given Exception(); then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsvDecoder.handleErrors(Callable)"})
  void testHandleErrors_givenException_thenThrowEUnexpected() throws Exception {
    // Arrange
    Callable<Void> parseFunc = mock(Callable.class);
    when(parseFunc.call()).thenThrow(new Exception());

    // Act and Assert
    assertThrows(EUnexpected.class, () -> csvDecoder.handleErrors(parseFunc));
    verify(parseFunc).call();
  }

  /**
   * Test {@link CsvDecoder#handleErrors(Callable)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link EDataCorruption}.
   * </ul>
   *
   * <p>Method under test: {@link CsvDecoder#handleErrors(Callable)}
   */
  @Test
  @DisplayName("Test handleErrors(Callable); given IOException(); then throw EDataCorruption")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsvDecoder.handleErrors(Callable)"})
  void testHandleErrors_givenIOException_thenThrowEDataCorruption() throws Exception {
    // Arrange
    Callable<Void> parseFunc = mock(Callable.class);
    when(parseFunc.call()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(EDataCorruption.class, () -> csvDecoder.handleErrors(parseFunc));
    verify(parseFunc).call();
  }

  /**
   * Test {@link CsvDecoder#handleErrors(Callable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Callable} {@link Callable#call()} return {@code null}.
   *   <li>Then calls {@link Callable#call()}.
   * </ul>
   *
   * <p>Method under test: {@link CsvDecoder#handleErrors(Callable)}
   */
  @Test
  @DisplayName(
      "Test handleErrors(Callable); given 'null'; when Callable call() return 'null'; then calls call()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsvDecoder.handleErrors(Callable)"})
  void testHandleErrors_givenNull_whenCallableCallReturnNull_thenCallsCall() throws Exception {
    // Arrange
    Callable<Void> parseFunc = mock(Callable.class);
    when(parseFunc.call()).thenReturn(null);

    // Act
    csvDecoder.handleErrors(parseFunc);

    // Assert
    verify(parseFunc).call();
  }

  /**
   * Test {@link CsvDecoder#handleErrors(Callable)}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link CsvDecoder#handleErrors(Callable)}
   */
  @Test
  @DisplayName("Test handleErrors(Callable); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CsvDecoder.handleErrors(Callable)"})
  void testHandleErrors_thenThrowETracInternal() throws Exception {
    // Arrange
    Callable<Void> parseFunc = mock(Callable.class);
    when(parseFunc.call()).thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> csvDecoder.handleErrors(parseFunc));
    verify(parseFunc).call();
  }
}
