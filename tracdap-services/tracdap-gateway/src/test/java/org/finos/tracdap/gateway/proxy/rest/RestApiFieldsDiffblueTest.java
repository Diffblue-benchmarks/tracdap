package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.Message.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.finos.tracdap.api.FileWriteRequest;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RestApiFieldsDiffblueTest {
  /**
   * Test {@link RestApiFields#isSegmentCapture(String)}.
   *
   * <ul>
   *   <li>When {@code Path Segment}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiFields#isSegmentCapture(String)}
   */
  @Test
  @DisplayName("Test isSegmentCapture(String); when 'Path Segment'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RestApiFields.isSegmentCapture(String)"})
  void testIsSegmentCapture_whenPathSegment_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RestApiFields.isSegmentCapture("Path Segment"));
  }

  /**
   * Test {@link RestApiFields#isSegmentCapture(String)}.
   *
   * <ul>
   *   <li>When {@code {U.U.U}}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiFields#isSegmentCapture(String)}
   */
  @Test
  @DisplayName("Test isSegmentCapture(String); when '{U.U.U}'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RestApiFields.isSegmentCapture(String)"})
  void testIsSegmentCapture_whenUUU_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RestApiFields.isSegmentCapture("{U.U.U}"));
  }

  /**
   * Test {@link RestApiFields#prepareFieldsForPathSegment(Descriptor, String)}.
   *
   * <ul>
   *   <li>When {@code Path Segment}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RestApiFields#prepareFieldsForPathSegment(Descriptor, String)}
   */
  @Test
  @DisplayName(
      "Test prepareFieldsForPathSegment(Descriptor, String); when 'Path Segment'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestApiFields.prepareFieldsForPathSegment(Descriptor, String)"})
  void testPrepareFieldsForPathSegment_whenPathSegment_thenReturnEmpty() {
    // Arrange and Act
    List<FieldDescriptor> actualPrepareFieldsForPathSegmentResult =
        RestApiFields.prepareFieldsForPathSegment(FileWriteRequest.getDescriptor(), "Path Segment");

    // Assert
    assertTrue(actualPrepareFieldsForPathSegmentResult.isEmpty());
  }

  /**
   * Test {@link RestApiFields#prepareFieldsForPathSegment(Descriptor, String)}.
   *
   * <ul>
   *   <li>When {@code {U.U.U}}.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiFields#prepareFieldsForPathSegment(Descriptor, String)}
   */
  @Test
  @DisplayName(
      "Test prepareFieldsForPathSegment(Descriptor, String); when '{U.U.U}'; then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestApiFields.prepareFieldsForPathSegment(Descriptor, String)"})
  void testPrepareFieldsForPathSegment_whenUUU_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(
        EStartup.class,
        () ->
            RestApiFields.prepareFieldsForPathSegment(FileWriteRequest.getDescriptor(), "{U.U.U}"));
  }

  /**
   * Test {@link RestApiFields#prepareFieldDescriptors(Descriptor, String)}.
   *
   * <ul>
   *   <li>When {@code *}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RestApiFields#prepareFieldDescriptors(Descriptor, String)}
   */
  @Test
  @DisplayName("Test prepareFieldDescriptors(Descriptor, String); when '*'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestApiFields.prepareFieldDescriptors(Descriptor, String)"})
  void testPrepareFieldDescriptors_whenAsterisk_thenReturnEmpty() {
    // Arrange and Act
    List<FieldDescriptor> actualPrepareFieldDescriptorsResult =
        RestApiFields.prepareFieldDescriptors(FileWriteRequest.getDescriptor(), "*");

    // Assert
    assertTrue(actualPrepareFieldDescriptorsResult.isEmpty());
  }

  /**
   * Test {@link RestApiFields#prepareFieldDescriptors(Descriptor, String)}.
   *
   * <ul>
   *   <li>When {@code Dr Jane Doe}.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiFields#prepareFieldDescriptors(Descriptor, String)}
   */
  @Test
  @DisplayName(
      "Test prepareFieldDescriptors(Descriptor, String); when 'Dr Jane Doe'; then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestApiFields.prepareFieldDescriptors(Descriptor, String)"})
  void testPrepareFieldDescriptors_whenDrJaneDoe_thenThrowEStartup() {
    // Arrange, Act and Assert
    assertThrows(
        EStartup.class,
        () ->
            RestApiFields.prepareFieldDescriptors(FileWriteRequest.getDescriptor(), "Dr Jane Doe"));
  }

  /**
   * Test {@link RestApiFields#prepareSubFieldMapper(List)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor}.
   *   <li>Then calls {@link Message.Builder#getFieldBuilder(FieldDescriptor)}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiFields#prepareSubFieldMapper(List)}
   */
  @Test
  @DisplayName(
      "Test prepareSubFieldMapper(List); given FieldDescriptor; then calls getFieldBuilder(FieldDescriptor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function RestApiFields.prepareSubFieldMapper(List)"})
  void testPrepareSubFieldMapper_givenFieldDescriptor_thenCallsGetFieldBuilder() {
    // Arrange
    ArrayList<FieldDescriptor> fields = new ArrayList<>();
    fields.add(mock(FieldDescriptor.class));
    fields.add(mock(FieldDescriptor.class));

    // Act
    Function<Builder, Builder> actualPrepareSubFieldMapperResult =
        RestApiFields.prepareSubFieldMapper(fields);
    Builder builder = mock(Builder.class);
    when(builder.getFieldBuilder(Mockito.<FieldDescriptor>any())).thenReturn(mock(Builder.class));
    actualPrepareSubFieldMapperResult.apply(builder);

    // Assert
    verify(builder).getFieldBuilder(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link RestApiFields#prepareSubFieldMapper(List)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor}.
   *   <li>Then return apply {@link Message.Builder} is {@link Message.Builder}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiFields#prepareSubFieldMapper(List)}
   */
  @Test
  @DisplayName(
      "Test prepareSubFieldMapper(List); given FieldDescriptor; then return apply Builder is Builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function RestApiFields.prepareSubFieldMapper(List)"})
  void testPrepareSubFieldMapper_givenFieldDescriptor_thenReturnApplyBuilderIsBuilder() {
    // Arrange
    ArrayList<FieldDescriptor> fields = new ArrayList<>();
    fields.add(mock(FieldDescriptor.class));

    // Act
    Function<Builder, Builder> actualPrepareSubFieldMapperResult =
        RestApiFields.prepareSubFieldMapper(fields);
    Builder builder = mock(Builder.class);
    Builder actualApplyResult = actualPrepareSubFieldMapperResult.apply(builder);

    // Assert
    assertSame(builder, actualApplyResult);
  }

  /**
   * Test {@link RestApiFields#prepareSubFieldMapper(List)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor}.
   *   <li>Then return apply {@link Message.Builder} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiFields#prepareSubFieldMapper(List)}
   */
  @Test
  @DisplayName(
      "Test prepareSubFieldMapper(List); given FieldDescriptor; then return apply Builder is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function RestApiFields.prepareSubFieldMapper(List)"})
  void testPrepareSubFieldMapper_givenFieldDescriptor_thenReturnApplyBuilderIsNull() {
    // Arrange
    ArrayList<FieldDescriptor> fields = new ArrayList<>();
    fields.add(mock(FieldDescriptor.class));
    fields.add(mock(FieldDescriptor.class));

    // Act
    Function<Builder, Builder> actualPrepareSubFieldMapperResult =
        RestApiFields.prepareSubFieldMapper(fields);
    Builder builder = mock(Builder.class);
    when(builder.getFieldBuilder(Mockito.<FieldDescriptor>any())).thenReturn(null);
    when(builder.newBuilderForField(Mockito.<FieldDescriptor>any())).thenReturn(null);
    when(builder.setField(Mockito.<FieldDescriptor>any(), Mockito.<Object>any())).thenReturn(null);
    Builder actualApplyResult = actualPrepareSubFieldMapperResult.apply(builder);

    // Assert
    verify(builder).getFieldBuilder(isA(FieldDescriptor.class));
    verify(builder).newBuilderForField(isA(FieldDescriptor.class));
    verify(builder).setField(isA(FieldDescriptor.class), isNull());
    assertNull(actualApplyResult);
  }

  /**
   * Test {@link RestApiFields#prepareSubFieldMapper(List)}.
   *
   * <ul>
   *   <li>Given {@link FieldDescriptor}.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiFields#prepareSubFieldMapper(List)}
   */
  @Test
  @DisplayName("Test prepareSubFieldMapper(List); given FieldDescriptor; then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function RestApiFields.prepareSubFieldMapper(List)"})
  void testPrepareSubFieldMapper_givenFieldDescriptor_thenThrowEStartup() {
    // Arrange
    ArrayList<FieldDescriptor> fields = new ArrayList<>();
    fields.add(mock(FieldDescriptor.class));
    fields.add(mock(FieldDescriptor.class));

    // Act
    Function<Builder, Builder> actualPrepareSubFieldMapperResult =
        RestApiFields.prepareSubFieldMapper(fields);
    Builder builder = mock(Builder.class);
    when(builder.getFieldBuilder(Mockito.<FieldDescriptor>any()))
        .thenThrow(EStartup.quietShutdown(1));

    // Assert
    assertThrows(EStartup.class, () -> actualPrepareSubFieldMapperResult.apply(builder));
    verify(builder).getFieldBuilder(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link RestApiFields#prepareSubFieldMapper(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return apply {@link Message.Builder} is {@link Message.Builder}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiFields#prepareSubFieldMapper(List)}
   */
  @Test
  @DisplayName(
      "Test prepareSubFieldMapper(List); when ArrayList(); then return apply Builder is Builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function RestApiFields.prepareSubFieldMapper(List)"})
  void testPrepareSubFieldMapper_whenArrayList_thenReturnApplyBuilderIsBuilder() {
    // Arrange and Act
    Function<Builder, Builder> actualPrepareSubFieldMapperResult =
        RestApiFields.prepareSubFieldMapper(new ArrayList<>());
    Builder builder = mock(Builder.class);
    Builder actualApplyResult = actualPrepareSubFieldMapperResult.apply(builder);

    // Assert
    assertSame(builder, actualApplyResult);
  }
}
