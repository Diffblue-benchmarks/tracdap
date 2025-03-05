package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLiteMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TagOperationDiffblueTest {
  /**
   * Test {@link TagOperation#getNumber()}.
   * <ul>
   *   <li>Given {@code CREATE_OR_REPLACE_ATTR}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given 'CREATE_OR_REPLACE_ATTR'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TagOperation.getNumber()"})
  void testGetNumber_givenCreateOrReplaceAttr_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, TagOperation.CREATE_OR_REPLACE_ATTR.getNumber());
  }

  /**
   * Test {@link TagOperation#getNumber()}.
   * <ul>
   *   <li>Given {@link TagOperation#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber(); given UNRECOGNIZED; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TagOperation.getNumber()"})
  void testGetNumber_givenUnrecognized_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TagOperation.UNRECOGNIZED.getNumber());
  }

  /**
   * Test {@link TagOperation#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code DELETE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when five; then return 'DELETE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.valueOf(int)"})
  void testValueOfWithValue_whenFive_thenReturnDeleteAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.DELETE_ATTR, TagOperation.valueOf(5));
  }

  /**
   * Test {@link TagOperation#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.valueOf(int)"})
  void testValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TagOperation.valueOf(42));
  }

  /**
   * Test {@link TagOperation#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code APPEND_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when four; then return 'APPEND_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.valueOf(int)"})
  void testValueOfWithValue_whenFour_thenReturnAppendAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.APPEND_ATTR, TagOperation.valueOf(4));
  }

  /**
   * Test {@link TagOperation#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code CREATE_OR_APPEND_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when one; then return 'CREATE_OR_APPEND_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.valueOf(int)"})
  void testValueOfWithValue_whenOne_thenReturnCreateOrAppendAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.CREATE_OR_APPEND_ATTR, TagOperation.valueOf(1));
  }

  /**
   * Test {@link TagOperation#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code CLEAR_ALL_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when six; then return 'CLEAR_ALL_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.valueOf(int)"})
  void testValueOfWithValue_whenSix_thenReturnClearAllAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.CLEAR_ALL_ATTR, TagOperation.valueOf(6));
  }

  /**
   * Test {@link TagOperation#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code REPLACE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when three; then return 'REPLACE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.valueOf(int)"})
  void testValueOfWithValue_whenThree_thenReturnReplaceAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.REPLACE_ATTR, TagOperation.valueOf(3));
  }

  /**
   * Test {@link TagOperation#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code CREATE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when two; then return 'CREATE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.valueOf(int)"})
  void testValueOfWithValue_whenTwo_thenReturnCreateAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.CREATE_ATTR, TagOperation.valueOf(2));
  }

  /**
   * Test {@link TagOperation#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code CREATE_OR_REPLACE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'value'; when zero; then return 'CREATE_OR_REPLACE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.valueOf(int)"})
  void testValueOfWithValue_whenZero_thenReturnCreateOrReplaceAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.CREATE_OR_REPLACE_ATTR, TagOperation.valueOf(0));
  }

  /**
   * Test {@link TagOperation#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code DELETE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when five; then return 'DELETE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.forNumber(int)"})
  void testForNumber_whenFive_thenReturnDeleteAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.DELETE_ATTR, TagOperation.forNumber(5));
  }

  /**
   * Test {@link TagOperation#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.forNumber(int)"})
  void testForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TagOperation.forNumber(42));
  }

  /**
   * Test {@link TagOperation#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code APPEND_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when four; then return 'APPEND_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.forNumber(int)"})
  void testForNumber_whenFour_thenReturnAppendAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.APPEND_ATTR, TagOperation.forNumber(4));
  }

  /**
   * Test {@link TagOperation#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code CREATE_OR_APPEND_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when one; then return 'CREATE_OR_APPEND_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.forNumber(int)"})
  void testForNumber_whenOne_thenReturnCreateOrAppendAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.CREATE_OR_APPEND_ATTR, TagOperation.forNumber(1));
  }

  /**
   * Test {@link TagOperation#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code CLEAR_ALL_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when six; then return 'CLEAR_ALL_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.forNumber(int)"})
  void testForNumber_whenSix_thenReturnClearAllAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.CLEAR_ALL_ATTR, TagOperation.forNumber(6));
  }

  /**
   * Test {@link TagOperation#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code REPLACE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when three; then return 'REPLACE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.forNumber(int)"})
  void testForNumber_whenThree_thenReturnReplaceAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.REPLACE_ATTR, TagOperation.forNumber(3));
  }

  /**
   * Test {@link TagOperation#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code CREATE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when two; then return 'CREATE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.forNumber(int)"})
  void testForNumber_whenTwo_thenReturnCreateAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.CREATE_ATTR, TagOperation.forNumber(2));
  }

  /**
   * Test {@link TagOperation#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code CREATE_OR_REPLACE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#forNumber(int)}
   */
  @Test
  @DisplayName("Test forNumber(int); when zero; then return 'CREATE_OR_REPLACE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagOperation TagOperation.forNumber(int)"})
  void testForNumber_whenZero_thenReturnCreateOrReplaceAttr() {
    // Arrange, Act and Assert
    assertEquals(TagOperation.CREATE_OR_REPLACE_ATTR, TagOperation.forNumber(0));
  }

  /**
   * Test {@link TagOperation#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber {@link JobStatusCode#CANCELLED_VALUE} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber CANCELLED_VALUE is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap TagOperation.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberCancelled_valueIsNull() {
    // Arrange and Act
    EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Test {@link TagOperation#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber five is {@code DELETE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber five is 'DELETE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap TagOperation.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFiveIsDeleteAttr() {
    // Arrange and Act
    EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.DELETE_ATTR, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Test {@link TagOperation#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber four is {@code APPEND_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber four is 'APPEND_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap TagOperation.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberFourIsAppendAttr() {
    // Arrange and Act
    EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.APPEND_ATTR, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Test {@link TagOperation#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber one is {@code CREATE_OR_APPEND_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber one is 'CREATE_OR_APPEND_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap TagOperation.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberOneIsCreateOrAppendAttr() {
    // Arrange and Act
    EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.CREATE_OR_APPEND_ATTR, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test {@link TagOperation#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber six is {@code CLEAR_ALL_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber six is 'CLEAR_ALL_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap TagOperation.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberSixIsClearAllAttr() {
    // Arrange and Act
    EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.CLEAR_ALL_ATTR, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Test {@link TagOperation#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber three is {@code REPLACE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber three is 'REPLACE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap TagOperation.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberThreeIsReplaceAttr() {
    // Arrange and Act
    EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.REPLACE_ATTR, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test {@link TagOperation#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber two is {@code CREATE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber two is 'CREATE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap TagOperation.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberTwoIsCreateAttr() {
    // Arrange and Act
    EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.CREATE_ATTR, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test {@link TagOperation#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber zero is {@code CREATE_OR_REPLACE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test internalGetValueMap(); then return findValueByNumber zero is 'CREATE_OR_REPLACE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap TagOperation.internalGetValueMap()"})
  void testInternalGetValueMap_thenReturnFindValueByNumberZeroIsCreateOrReplaceAttr() {
    // Arrange and Act
    EnumLiteMap<TagOperation> actualInternalGetValueMapResult = TagOperation.internalGetValueMap();

    // Assert
    assertEquals(TagOperation.CREATE_OR_REPLACE_ATTR, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test {@link TagOperation#getValueDescriptor()}.
   * <ul>
   *   <li>Given {@link TagOperation#UNRECOGNIZED}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); given UNRECOGNIZED; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor TagOperation.getValueDescriptor()"})
  void testGetValueDescriptor_givenUnrecognized_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TagOperation.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test {@link TagOperation#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code CREATE_OR_REPLACE_ATTR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagOperation#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test getValueDescriptor(); then return Name is 'CREATE_OR_REPLACE_ATTR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor TagOperation.getValueDescriptor()"})
  void testGetValueDescriptor_thenReturnNameIsCreateOrReplaceAttr() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = TagOperation.CREATE_OR_REPLACE_ATTR.getValueDescriptor();

    // Assert
    assertEquals("CREATE_OR_REPLACE_ATTR", actualValueDescriptor.getName());
    assertEquals("tracdap.metadata.TagOperation.CREATE_OR_REPLACE_ATTR", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test {@link TagOperation#getDescriptorForType()}.
   * <p>
   * Method under test: {@link TagOperation#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor TagOperation.getDescriptorForType()"})
  void testGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = TagOperation.CREATE_OR_REPLACE_ATTR.getDescriptorForType();

    // Assert
    assertEquals("TagOperation", actualDescriptorForType.getName());
    assertEquals("tracdap.metadata.TagOperation", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(7, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test {@link TagOperation#getDescriptor()}.
   * <p>
   * Method under test: {@link TagOperation#getDescriptor()}
   */
  @Test
  @DisplayName("Test getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EnumDescriptor TagOperation.getDescriptor()"})
  void testGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = TagOperation.getDescriptor();

    // Assert
    assertEquals("TagOperation", actualDescriptor.getName());
    assertEquals("tracdap.metadata.TagOperation", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(7, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }
}
