package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.metadata.FlowNode;
import org.finos.tracdap.metadata.ModelInputSchema;
import org.finos.tracdap.metadata.ModelOutputSchema;
import org.finos.tracdap.metadata.ModelParameter;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NodeMetadataDiffblueTest {
  /**
   * Test {@link NodeMetadata#runtimeObjectType()}.
   *
   * <p>Method under test: {@link NodeMetadata#runtimeObjectType()}
   */
  @Test
  @DisplayName("Test runtimeObjectType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NodeMetadata.runtimeObjectType()"})
  void testRuntimeObjectType() {
    // Arrange
    NodeMetadata nodeMetadata =
        new NodeMetadata(
            FlowNode.getDefaultInstance(),
            ModelParameter.getDefaultInstance(),
            ModelInputSchema.getDefaultInstance(),
            ModelOutputSchema.getDefaultInstance(),
            null,
            Value.getDefaultInstance());

    // Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, nodeMetadata.runtimeObjectType());
  }

  /**
   * Test {@link NodeMetadata#runtimeObjectType()}.
   *
   * <p>Method under test: {@link NodeMetadata#runtimeObjectType()}
   */
  @Test
  @DisplayName("Test runtimeObjectType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType NodeMetadata.runtimeObjectType()"})
  void testRuntimeObjectType2() {
    // Arrange
    NodeMetadata nodeMetadata =
        new NodeMetadata(
            FlowNode.getDefaultInstance(),
            ModelParameter.getDefaultInstance(),
            ModelInputSchema.getDefaultInstance(),
            ModelOutputSchema.getDefaultInstance(),
            ObjectDefinition.getDefaultInstance(),
            Value.getDefaultInstance());

    // Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, nodeMetadata.runtimeObjectType());
  }
}
