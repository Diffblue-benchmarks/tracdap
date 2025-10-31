package org.finos.tracdap.svc.meta.dal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.metadata.Tag;
import org.finos.tracdap.metadata.TagHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MetadataBatchUpdateDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MetadataBatchUpdate#MetadataBatchUpdate(List, List, List, List, List)}
   *   <li>{@link MetadataBatchUpdate#getNewObjects()}
   *   <li>{@link MetadataBatchUpdate#getNewTags()}
   *   <li>{@link MetadataBatchUpdate#getNewVersions()}
   *   <li>{@link MetadataBatchUpdate#getPreallocatedIds()}
   *   <li>{@link MetadataBatchUpdate#getPreallocatedObjects()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MetadataBatchUpdate.<init>(List, List, List, List, List)",
      "List MetadataBatchUpdate.getNewObjects()", "List MetadataBatchUpdate.getNewTags()",
      "List MetadataBatchUpdate.getNewVersions()", "List MetadataBatchUpdate.getPreallocatedIds()",
      "List MetadataBatchUpdate.getPreallocatedObjects()"})
  void testGettersAndSetters() {
    // Arrange
    ArrayList<TagHeader> preallocatedIds = new ArrayList<>();
    ArrayList<Tag> preallocatedObjects = new ArrayList<>();
    ArrayList<Tag> newObjects = new ArrayList<>();
    ArrayList<Tag> newVersions = new ArrayList<>();
    ArrayList<Tag> newTags = new ArrayList<>();

    // Act
    MetadataBatchUpdate actualMetadataBatchUpdate = new MetadataBatchUpdate(preallocatedIds, preallocatedObjects,
        newObjects, newVersions, newTags);
    List<Tag> actualNewObjects = actualMetadataBatchUpdate.getNewObjects();
    List<Tag> actualNewTags = actualMetadataBatchUpdate.getNewTags();
    List<Tag> actualNewVersions = actualMetadataBatchUpdate.getNewVersions();
    List<TagHeader> actualPreallocatedIds = actualMetadataBatchUpdate.getPreallocatedIds();
    List<Tag> actualPreallocatedObjects = actualMetadataBatchUpdate.getPreallocatedObjects();

    // Assert
    assertTrue(actualNewObjects.isEmpty());
    assertTrue(actualNewTags.isEmpty());
    assertTrue(actualNewVersions.isEmpty());
    assertTrue(actualPreallocatedIds.isEmpty());
    assertTrue(actualPreallocatedObjects.isEmpty());
    assertSame(newObjects, actualNewObjects);
    assertSame(newTags, actualNewTags);
    assertSame(newVersions, actualNewVersions);
    assertSame(preallocatedIds, actualPreallocatedIds);
    assertSame(preallocatedObjects, actualPreallocatedObjects);
  }

  /**
   * Test {@link MetadataBatchUpdate#toString()}.
   * <p>
   * Method under test: {@link MetadataBatchUpdate#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MetadataBatchUpdate.toString()"})
  void testToString() {
    // Arrange
    ArrayList<TagHeader> preallocatedIds = new ArrayList<>();
    ArrayList<Tag> preallocatedObjects = new ArrayList<>();
    ArrayList<Tag> newObjects = new ArrayList<>();
    ArrayList<Tag> newVersions = new ArrayList<>();

    // Act and Assert
    assertEquals("{preallocatedIds = 0, preallocatedObjects = 0, newObjects = 0, newVersions = 0, newTags = 0}",
        (new MetadataBatchUpdate(preallocatedIds, preallocatedObjects, newObjects, newVersions, new ArrayList<>()))
            .toString());
  }
}
