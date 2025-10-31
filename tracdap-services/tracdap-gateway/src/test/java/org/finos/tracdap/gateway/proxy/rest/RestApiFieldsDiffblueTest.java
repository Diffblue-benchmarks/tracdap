package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Any;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.Message.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RestApiFieldsDiffblueTest {
  /**
   * Test {@link RestApiFields#isSegmentCapture(String)}.
   * <ul>
   *   <li>When {@code Path Segment}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiFields#isSegmentCapture(String)}
   */
  @Test
  @DisplayName("Test isSegmentCapture(String); when 'Path Segment'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestApiFields.isSegmentCapture(String)"})
  void testIsSegmentCapture_whenPathSegment_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RestApiFields.isSegmentCapture("Path Segment"));
  }

  /**
   * Test {@link RestApiFields#isSegmentCapture(String)}.
   * <ul>
   *   <li>When {@code {U.U.U}}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiFields#isSegmentCapture(String)}
   */
  @Test
  @DisplayName("Test isSegmentCapture(String); when '{U.U.U}'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RestApiFields.isSegmentCapture(String)"})
  void testIsSegmentCapture_whenUUU_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RestApiFields.isSegmentCapture("{U.U.U}"));
  }

  /**
   * Test {@link RestApiFields#prepareFieldsForPathSegment(Descriptor, String)}.
   * <ul>
   *   <li>When {@code Path Segment}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiFields#prepareFieldsForPathSegment(Descriptor, String)}
   */
  @Test
  @DisplayName("Test prepareFieldsForPathSegment(Descriptor, String); when 'Path Segment'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RestApiFields.prepareFieldsForPathSegment(Descriptor, String)"})
  void testPrepareFieldsForPathSegment_whenPathSegment_thenReturnEmpty() {
    // Arrange and Act
    List<FieldDescriptor> actualPrepareFieldsForPathSegmentResult = RestApiFields
        .prepareFieldsForPathSegment(Any.getDescriptor(), "Path Segment");

    // Assert
    assertTrue(actualPrepareFieldsForPathSegmentResult.isEmpty());
  }

  /**
   * Test {@link RestApiFields#prepareFieldsForPathSegment(Descriptor, String)}.
   * <ul>
   *   <li>When {@code {U.U.U}}.</li>
   *   <li>Then throw {@link EStartup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiFields#prepareFieldsForPathSegment(Descriptor, String)}
   */
  @Test
  @DisplayName("Test prepareFieldsForPathSegment(Descriptor, String); when '{U.U.U}'; then throw EStartup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RestApiFields.prepareFieldsForPathSegment(Descriptor, String)"})
  void testPrepareFieldsForPathSegment_whenUUU_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> RestApiFields.prepareFieldsForPathSegment(Any.getDescriptor(), "{U.U.U}"));
  }

  /**
   * Test {@link RestApiFields#prepareFieldDescriptors(Descriptor, String)}.
   * <ul>
   *   <li>When {@code *}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiFields#prepareFieldDescriptors(Descriptor, String)}
   */
  @Test
  @DisplayName("Test prepareFieldDescriptors(Descriptor, String); when '*'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RestApiFields.prepareFieldDescriptors(Descriptor, String)"})
  void testPrepareFieldDescriptors_whenAsterisk_thenReturnEmpty() {
    // Arrange and Act
    List<FieldDescriptor> actualPrepareFieldDescriptorsResult = RestApiFields.prepareFieldDescriptors(null, "*");

    // Assert
    assertTrue(actualPrepareFieldDescriptorsResult.isEmpty());
  }

  /**
   * Test {@link RestApiFields#prepareFieldDescriptors(Descriptor, String)}.
   * <ul>
   *   <li>When Descriptor.</li>
   *   <li>Then throw {@link EStartup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestApiFields#prepareFieldDescriptors(Descriptor, String)}
   */
  @Test
  @DisplayName("Test prepareFieldDescriptors(Descriptor, String); when Descriptor; then throw EStartup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RestApiFields.prepareFieldDescriptors(Descriptor, String)"})
  void testPrepareFieldDescriptors_whenDescriptor_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> RestApiFields.prepareFieldDescriptors(Any.getDescriptor(), "Dr Jane Doe"));
  }

  /**
   * Test {@link RestApiFields#prepareSubFieldMapper(List)}.
   * <p>
   * Method under test: {@link RestApiFields#prepareSubFieldMapper(List)}
   */
  @Test
  @DisplayName("Test prepareSubFieldMapper(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Function RestApiFields.prepareSubFieldMapper(List)"})
  void testPrepareSubFieldMapper() {
    // Arrange and Act
    Function<Builder, Builder> actualPrepareSubFieldMapperResult = RestApiFields
        .prepareSubFieldMapper(new ArrayList<>());
    Builder builder = mock(Builder.class);

    // Assert
    assertSame(builder, actualPrepareSubFieldMapperResult.apply(builder));
  }
}
