package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.google.protobuf.Any;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.Test;

class RestApiFieldsDiffblueTest {
  /**
   * Method under test: {@link RestApiFields#isSegmentCapture(String)}
   */
  @Test
  void testIsSegmentCapture() {
    // Arrange, Act and Assert
    assertFalse(RestApiFields.isSegmentCapture("Path Segment"));
    assertTrue(RestApiFields.isSegmentCapture("{U.U.U}"));
  }

  /**
   * Method under test:
   * {@link RestApiFields#prepareFieldsForPathSegment(Descriptors.Descriptor, String)}
   */
  @Test
  void testPrepareFieldsForPathSegment() {
    // Arrange and Act
    List<Descriptors.FieldDescriptor> actualPrepareFieldsForPathSegmentResult = RestApiFields
        .prepareFieldsForPathSegment(Any.getDescriptor(), "Path Segment");

    // Assert
    assertTrue(actualPrepareFieldsForPathSegmentResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link RestApiFields#prepareFieldsForPathSegment(Descriptors.Descriptor, String)}
   */
  @Test
  void testPrepareFieldsForPathSegment2() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> RestApiFields.prepareFieldsForPathSegment(Any.getDescriptor(), "{U.U.U}"));
  }

  /**
   * Method under test:
   * {@link RestApiFields#prepareFieldDescriptors(Descriptors.Descriptor, String)}
   */
  @Test
  void testPrepareFieldDescriptors() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> RestApiFields.prepareFieldDescriptors(Any.getDescriptor(), "Dr Jane Doe"));
  }

  /**
   * Method under test:
   * {@link RestApiFields#prepareFieldDescriptors(Descriptors.Descriptor, String)}
   */
  @Test
  void testPrepareFieldDescriptors2() {
    // Arrange and Act
    List<Descriptors.FieldDescriptor> actualPrepareFieldDescriptorsResult = RestApiFields.prepareFieldDescriptors(null,
        "*");

    // Assert
    assertTrue(actualPrepareFieldDescriptorsResult.isEmpty());
  }

  /**
   * Method under test: {@link RestApiFields#prepareSubFieldMapper(List)}
   */
  @Test
  void testPrepareSubFieldMapper() {
    // Arrange and Act
    Function<Message.Builder, Message.Builder> actualPrepareSubFieldMapperResult = RestApiFields
        .prepareSubFieldMapper(new ArrayList<>());
    Message.Builder builder = mock(Message.Builder.class);

    // Assert
    assertSame(builder, actualPrepareSubFieldMapperResult.apply(builder));
  }
}
