package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.metadata.TagSelector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MetadataBundleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MetadataBundle#MetadataBundle(Map, Map)}
   *   <li>{@link MetadataBundle#getResourceMapping()}
   *   <li>{@link MetadataBundle#getResources()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MetadataBundle.<init>(Map, Map)",
    "Map MetadataBundle.getResourceMapping()",
    "Map MetadataBundle.getResources()"
  })
  void testGettersAndSetters() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    HashMap<String, TagHeader> resourceMapping = new HashMap<>();

    // Act
    MetadataBundle actualMetadataBundle = new MetadataBundle(resources, resourceMapping);
    Map<String, TagHeader> actualResourceMapping = actualMetadataBundle.getResourceMapping();
    Map<String, ObjectDefinition> actualResources = actualMetadataBundle.getResources();

    // Assert
    assertTrue(actualResourceMapping.isEmpty());
    assertTrue(actualResources.isEmpty());
    assertSame(resourceMapping, actualResourceMapping);
    assertSame(resources, actualResources);
  }

  /**
   * Test {@link MetadataBundle#getResource(TagSelector)}.
   *
   * <ul>
   *   <li>Then calls {@link TagSelector#hasLatestObject()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBundle#getResource(TagSelector)}
   */
  @Test
  @DisplayName("Test getResource(TagSelector); then calls hasLatestObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition MetadataBundle.getResource(TagSelector)"})
  void testGetResource_thenCallsHasLatestObject() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadataBundle = new MetadataBundle(resources, new HashMap<>());

    TagSelector selector = mock(TagSelector.class);
    when(selector.getObjectType()).thenThrow(new EUnexpected());
    when(selector.hasLatestObject()).thenReturn(true);
    when(selector.hasObjectAsOf()).thenReturn(false);
    when(selector.hasObjectVersion()).thenReturn(false);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> metadataBundle.getResource(selector));
    verify(selector).getObjectType();
    verify(selector).hasLatestObject();
    verify(selector).hasObjectAsOf();
    verify(selector).hasObjectVersion();
  }

  /**
   * Test {@link MetadataBundle#getResource(TagSelector)}.
   *
   * <ul>
   *   <li>When {@link TagSelector} {@link TagSelector#hasObjectAsOf()} return {@code true}.
   *   <li>Then calls {@link TagSelector#hasObjectAsOf()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBundle#getResource(TagSelector)}
   */
  @Test
  @DisplayName(
      "Test getResource(TagSelector); when TagSelector hasObjectAsOf() return 'true'; then calls hasObjectAsOf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition MetadataBundle.getResource(TagSelector)"})
  void testGetResource_whenTagSelectorHasObjectAsOfReturnTrue_thenCallsHasObjectAsOf() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadataBundle = new MetadataBundle(resources, new HashMap<>());

    TagSelector selector = mock(TagSelector.class);
    when(selector.getObjectType()).thenThrow(new EUnexpected());
    when(selector.hasObjectAsOf()).thenReturn(true);
    when(selector.hasObjectVersion()).thenReturn(false);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> metadataBundle.getResource(selector));
    verify(selector).getObjectType();
    verify(selector).hasObjectAsOf();
    verify(selector).hasObjectVersion();
  }

  /**
   * Test {@link MetadataBundle#getResource(TagSelector)}.
   *
   * <ul>
   *   <li>When {@link TagSelector} {@link TagSelector#hasObjectVersion()} return {@code true}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBundle#getResource(TagSelector)}
   */
  @Test
  @DisplayName(
      "Test getResource(TagSelector); when TagSelector hasObjectVersion() return 'true'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition MetadataBundle.getResource(TagSelector)"})
  void testGetResource_whenTagSelectorHasObjectVersionReturnTrue_thenThrowEUnexpected() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadataBundle = new MetadataBundle(resources, new HashMap<>());

    TagSelector selector = mock(TagSelector.class);
    when(selector.getObjectType()).thenThrow(new EUnexpected());
    when(selector.hasObjectVersion()).thenReturn(true);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> metadataBundle.getResource(selector));
    verify(selector).getObjectType();
    verify(selector).hasObjectVersion();
  }

  /**
   * Test {@link MetadataBundle#withUpdate(TagSelector, ObjectDefinition)}.
   *
   * <ul>
   *   <li>Then calls {@link TagSelector#getObjectVersion()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBundle#withUpdate(TagSelector, ObjectDefinition)}
   */
  @Test
  @DisplayName("Test withUpdate(TagSelector, ObjectDefinition); then calls getObjectVersion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetadataBundle MetadataBundle.withUpdate(TagSelector, ObjectDefinition)"})
  void testWithUpdate_thenCallsGetObjectVersion() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadataBundle = new MetadataBundle(resources, new HashMap<>());

    TagSelector selector = mock(TagSelector.class);
    when(selector.getObjectVersion()).thenReturn(1);
    when(selector.getObjectId()).thenReturn("42");
    when(selector.getObjectType()).thenReturn(ObjectType.OBJECT_TYPE_NOT_SET);
    when(selector.hasObjectVersion()).thenReturn(true);

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () -> metadataBundle.withUpdate(selector, ObjectDefinition.getDefaultInstance()));
    verify(selector).getObjectId();
    verify(selector).getObjectType();
    verify(selector).getObjectVersion();
    verify(selector).hasObjectVersion();
  }

  /**
   * Test {@link MetadataBundle#withUpdate(TagSelector, ObjectDefinition)}.
   *
   * <ul>
   *   <li>When {@link TagSelector} {@link TagSelector#hasLatestObject()} return {@code true}.
   *   <li>Then calls {@link TagSelector#hasLatestObject()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBundle#withUpdate(TagSelector, ObjectDefinition)}
   */
  @Test
  @DisplayName(
      "Test withUpdate(TagSelector, ObjectDefinition); when TagSelector hasLatestObject() return 'true'; then calls hasLatestObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetadataBundle MetadataBundle.withUpdate(TagSelector, ObjectDefinition)"})
  void testWithUpdate_whenTagSelectorHasLatestObjectReturnTrue_thenCallsHasLatestObject() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadataBundle = new MetadataBundle(resources, new HashMap<>());

    TagSelector selector = mock(TagSelector.class);
    when(selector.getObjectId()).thenReturn("42");
    when(selector.getObjectType()).thenReturn(ObjectType.OBJECT_TYPE_NOT_SET);
    when(selector.hasLatestObject()).thenReturn(true);
    when(selector.hasObjectAsOf()).thenReturn(false);
    when(selector.hasObjectVersion()).thenReturn(false);

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () -> metadataBundle.withUpdate(selector, ObjectDefinition.getDefaultInstance()));
    verify(selector).getObjectId();
    verify(selector).getObjectType();
    verify(selector).hasLatestObject();
    verify(selector).hasObjectAsOf();
    verify(selector).hasObjectVersion();
  }

  /**
   * Test {@link MetadataBundle#withUpdate(TagSelector, ObjectDefinition)}.
   *
   * <ul>
   *   <li>When {@link TagSelector} {@link TagSelector#hasObjectAsOf()} return {@code true}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBundle#withUpdate(TagSelector, ObjectDefinition)}
   */
  @Test
  @DisplayName(
      "Test withUpdate(TagSelector, ObjectDefinition); when TagSelector hasObjectAsOf() return 'true'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetadataBundle MetadataBundle.withUpdate(TagSelector, ObjectDefinition)"})
  void testWithUpdate_whenTagSelectorHasObjectAsOfReturnTrue_thenThrowEUnexpected() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadataBundle = new MetadataBundle(resources, new HashMap<>());

    TagSelector selector = mock(TagSelector.class);
    when(selector.getObjectAsOf()).thenThrow(new EUnexpected());
    when(selector.getObjectId()).thenReturn("42");
    when(selector.getObjectType()).thenReturn(ObjectType.OBJECT_TYPE_NOT_SET);
    when(selector.hasObjectAsOf()).thenReturn(true);
    when(selector.hasObjectVersion()).thenReturn(false);

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () -> metadataBundle.withUpdate(selector, ObjectDefinition.getDefaultInstance()));
    verify(selector).getObjectAsOf();
    verify(selector).getObjectId();
    verify(selector).getObjectType();
    verify(selector).hasObjectAsOf();
    verify(selector).hasObjectVersion();
  }

  /**
   * Test {@link MetadataBundle#withUpdates(Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is DefaultInstance.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  @DisplayName(
      "Test withUpdates(Map); given 'foo'; when HashMap() 'foo' is DefaultInstance; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetadataBundle MetadataBundle.withUpdates(Map)"})
  void testWithUpdates_givenFoo_whenHashMapFooIsDefaultInstance_thenThrowETracInternal() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadataBundle = new MetadataBundle(resources, new HashMap<>());

    HashMap<String, ObjectDefinition> updates = new HashMap<>();
    updates.put("foo", ObjectDefinition.getDefaultInstance());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> metadataBundle.withUpdates(updates));
  }

  /**
   * Test {@link MetadataBundle#withUpdates(Map)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is DefaultInstance.
   *   <li>Then return Resources size is one.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  @DisplayName(
      "Test withUpdates(Map); given HashMap() 'foo' is DefaultInstance; then return Resources size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetadataBundle MetadataBundle.withUpdates(Map)"})
  void testWithUpdates_givenHashMapFooIsDefaultInstance_thenReturnResourcesSizeIsOne() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    resources.put("foo", ObjectDefinition.getDefaultInstance());
    MetadataBundle metadataBundle = new MetadataBundle(resources, new HashMap<>());

    HashMap<String, ObjectDefinition> updates = new HashMap<>();
    ObjectDefinition defaultInstance = ObjectDefinition.getDefaultInstance();
    updates.put("foo", defaultInstance);

    // Act and Assert
    Map<String, ObjectDefinition> resources2 = metadataBundle.withUpdates(updates).getResources();
    assertEquals(1, resources2.size());
    assertSame(defaultInstance, resources2.get("foo"));
  }

  /**
   * Test {@link MetadataBundle#withUpdates(Map)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is DefaultInstance.
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  @DisplayName(
      "Test withUpdates(Map); given HashMap() 'foo' is DefaultInstance; then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetadataBundle MetadataBundle.withUpdates(Map)"})
  void testWithUpdates_givenHashMapFooIsDefaultInstance_thenThrowETracInternal() {
    // Arrange
    HashMap<String, TagHeader> resourceMapping = new HashMap<>();
    resourceMapping.put("foo", TagHeader.getDefaultInstance());
    MetadataBundle metadataBundle = new MetadataBundle(new HashMap<>(), resourceMapping);

    HashMap<String, ObjectDefinition> updates = new HashMap<>();
    updates.put("foo", ObjectDefinition.getDefaultInstance());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> metadataBundle.withUpdates(updates));
  }

  /**
   * Test {@link MetadataBundle#withUpdates(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return ResourceMapping Empty.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  @DisplayName("Test withUpdates(Map); when HashMap(); then return ResourceMapping Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetadataBundle MetadataBundle.withUpdates(Map)"})
  void testWithUpdates_whenHashMap_thenReturnResourceMappingEmpty() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadataBundle = new MetadataBundle(resources, new HashMap<>());

    // Act
    MetadataBundle actualWithUpdatesResult = metadataBundle.withUpdates(new HashMap<>());

    // Assert
    assertTrue(actualWithUpdatesResult.getResourceMapping().isEmpty());
    assertTrue(actualWithUpdatesResult.getResources().isEmpty());
  }
}
