package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MetadataBundleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataBundle#MetadataBundle(Map, Map)}
   *   <li>{@link MetadataBundle#getResourceMapping()}
   *   <li>{@link MetadataBundle#getResources()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataBundle.<init>(Map, Map)", "Map MetadataBundle.getResourceMapping()",
      "Map MetadataBundle.getResources()"})
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
   * Test {@link MetadataBundle#withUpdates(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is DefaultInstance.</li>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  @DisplayName("Test withUpdates(Map); given 'foo'; when HashMap() 'foo' is DefaultInstance; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is DefaultInstance.</li>
   *   <li>Then return Resources size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  @DisplayName("Test withUpdates(Map); given HashMap() 'foo' is DefaultInstance; then return Resources size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is DefaultInstance.</li>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  @DisplayName("Test withUpdates(Map); given HashMap() 'foo' is DefaultInstance; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return ResourceMapping Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  @DisplayName("Test withUpdates(Map); when HashMap(); then return ResourceMapping Empty")
  @Tag("MaintainedByDiffblue")
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
