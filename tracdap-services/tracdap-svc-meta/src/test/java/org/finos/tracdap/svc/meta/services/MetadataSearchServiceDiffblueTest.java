package org.finos.tracdap.svc.meta.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.metadata.SearchParameters;
import org.finos.tracdap.metadata.Tag;
import org.finos.tracdap.svc.meta.dal.IMetadataDal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataSearchServiceDiffblueTest {
  /**
   * Test {@link MetadataSearchService#search(String, SearchParameters)}.
   *
   * <ul>
   *   <li>Given {@link IMetadataDal} {@link IMetadataDal#search(String, SearchParameters)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MetadataSearchService#search(String, SearchParameters)}
   */
  @Test
  @DisplayName(
      "Test search(String, SearchParameters); given IMetadataDal search(String, SearchParameters) return ArrayList(); then return Empty")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MetadataSearchService.search(String, SearchParameters)"})
  void testSearch_givenIMetadataDalSearchReturnArrayList_thenReturnEmpty() {
    // Arrange
    IMetadataDal dal = mock(IMetadataDal.class);
    when(dal.search(Mockito.<String>any(), Mockito.<SearchParameters>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Tag> actualSearchResult =
        new MetadataSearchService(dal).search("Tenant", SearchParameters.getDefaultInstance());

    // Assert
    verify(dal).search(eq("Tenant"), isA(SearchParameters.class));
    assertTrue(actualSearchResult.isEmpty());
  }
}
