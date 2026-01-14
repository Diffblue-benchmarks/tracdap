package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GraphSectionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GraphSection#GraphSection(Map, List, List)}
   *   <li>{@link GraphSection#inputs()}
   *   <li>{@link GraphSection#nodes()}
   *   <li>{@link GraphSection#outputs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphSection.<init>(Map, List, List)",
    "List GraphSection.inputs()",
    "Map GraphSection.nodes()",
    "List GraphSection.outputs()"
  })
  void testGettersAndSetters() {
    // Arrange
    HashMap<NodeId, Node<Object>> nodes = new HashMap<>();
    ArrayList<NodeId> inputs = new ArrayList<>();
    ArrayList<NodeId> outputs = new ArrayList<>();

    // Act
    GraphSection<Object> actualGraphSection = new GraphSection<>(nodes, inputs, outputs);
    List<NodeId> actualInputsResult = actualGraphSection.inputs();
    Map<NodeId, Node<Object>> actualNodesResult = actualGraphSection.nodes();
    List<NodeId> actualOutputsResult = actualGraphSection.outputs();

    // Assert
    assertTrue(actualInputsResult.isEmpty());
    assertTrue(actualOutputsResult.isEmpty());
    assertTrue(actualNodesResult.isEmpty());
    assertSame(inputs, actualInputsResult);
    assertSame(outputs, actualOutputsResult);
    assertSame(nodes, actualNodesResult);
  }
}
