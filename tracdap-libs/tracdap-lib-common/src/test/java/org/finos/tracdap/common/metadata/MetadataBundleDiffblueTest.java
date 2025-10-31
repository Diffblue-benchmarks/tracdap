package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.Test;

class MetadataBundleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataBundle#MetadataBundle(Map, Map)}
   *   <li>{@link MetadataBundle#getResourceMapping()}
   *   <li>{@link MetadataBundle#getResources()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  void testWithUpdates() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    HashMap<String, TagHeader> resourceMapping = new HashMap<>();
    MetadataBundle metadataBundle = new MetadataBundle(resources, resourceMapping);

    // Act
    MetadataBundle actualWithUpdatesResult = metadataBundle.withUpdates(new HashMap<>());

    // Assert
    Map<String, TagHeader> resourceMapping2 = actualWithUpdatesResult.getResourceMapping();
    assertTrue(resourceMapping2.isEmpty());
    assertTrue(actualWithUpdatesResult.getResources().isEmpty());
    assertSame(resourceMapping, resourceMapping2);
  }

  /**
   * Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  void testWithUpdates2() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadataBundle = new MetadataBundle(resources, new HashMap<>());

    HashMap<String, ObjectDefinition> updates = new HashMap<>();
    updates.put("foo", ObjectDefinition.getDefaultInstance());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> metadataBundle.withUpdates(updates));
  }

  /**
   * Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  void testWithUpdates3() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    resources.put("foo", ObjectDefinition.getDefaultInstance());
    resources.putAll(new HashMap<>());
    HashMap<String, TagHeader> resourceMapping = new HashMap<>();
    MetadataBundle metadataBundle = new MetadataBundle(resources, resourceMapping);

    HashMap<String, ObjectDefinition> updates = new HashMap<>();
    updates.computeIfPresent("foo", mock(BiFunction.class));
    updates.put("foo", ObjectDefinition.getDefaultInstance());

    // Act
    MetadataBundle actualWithUpdatesResult = metadataBundle.withUpdates(updates);

    // Assert
    Map<String, TagHeader> resourceMapping2 = actualWithUpdatesResult.getResourceMapping();
    assertTrue(resourceMapping2.isEmpty());
    assertEquals(resources, actualWithUpdatesResult.getResources());
    assertSame(resourceMapping, resourceMapping2);
  }

  /**
   * Method under test: {@link MetadataBundle#withUpdates(Map)}
   */
  @Test
  void testWithUpdates4() {
    // Arrange
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    resources.put("42", ObjectDefinition.getDefaultInstance());

    HashMap<String, TagHeader> resourceMapping = new HashMap<>();
    resourceMapping.put("foo", TagHeader.getDefaultInstance());
    MetadataBundle metadataBundle = new MetadataBundle(resources, resourceMapping);

    HashMap<String, ObjectDefinition> updates = new HashMap<>();
    updates.computeIfPresent("foo", mock(BiFunction.class));
    updates.put("foo", ObjectDefinition.getDefaultInstance());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> metadataBundle.withUpdates(updates));
  }
}
