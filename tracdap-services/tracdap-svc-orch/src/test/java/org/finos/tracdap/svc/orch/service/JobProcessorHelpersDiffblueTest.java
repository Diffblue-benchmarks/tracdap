package org.finos.tracdap.svc.orch.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.tracdap.api.MetadataBatchResponse;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.middleware.GrpcConcern;
import org.finos.tracdap.config.PlatformConfig;
import org.junit.jupiter.api.Test;

class JobProcessorHelpersDiffblueTest {
  /**
   * Method under test:
   * {@link JobProcessorHelpers#loadResourcesResponse(JobState, List, MetadataBatchResponse)}
   */
  @Test
  void testLoadResourcesResponse() {
    // Arrange
    JobProcessorHelpers jobProcessorHelpers = new JobProcessorHelpers(PlatformConfig.getDefaultInstance(), null,
        mock(GrpcConcern.class));
    JobState jobState = new JobState();

    ArrayList<String> mappingKeys = new ArrayList<>();
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");
    mappingKeys.add("Mapping Keys");

    // Act and Assert
    assertThrows(EUnexpected.class, () -> jobProcessorHelpers.loadResourcesResponse(jobState, mappingKeys,
        MetadataBatchResponse.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JobProcessorHelpers#loadResourcesResponse(JobState, List, MetadataBatchResponse)}
   */
  @Test
  void testLoadResourcesResponse2() {
    // Arrange
    JobProcessorHelpers jobProcessorHelpers = new JobProcessorHelpers(PlatformConfig.getDefaultInstance(), null,
        mock(GrpcConcern.class));
    JobState jobState = new JobState();

    ArrayList<String> mappingKeys = new ArrayList<>();
    mappingKeys.add("foo");

    // Act and Assert
    assertThrows(EUnexpected.class, () -> jobProcessorHelpers.loadResourcesResponse(jobState, mappingKeys,
        MetadataBatchResponse.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JobProcessorHelpers#loadResourcesResponse(JobState, List, MetadataBatchResponse)}
   */
  @Test
  void testLoadResourcesResponse3() {
    // Arrange
    JobProcessorHelpers jobProcessorHelpers = new JobProcessorHelpers(PlatformConfig.getDefaultInstance(), null,
        mock(GrpcConcern.class));
    JobState jobState = new JobState();

    ArrayList<String> mappingKeys = new ArrayList<>();
    mappingKeys.add("foo");
    mappingKeys.add("foo");

    // Act and Assert
    assertThrows(EUnexpected.class, () -> jobProcessorHelpers.loadResourcesResponse(jobState, mappingKeys,
        MetadataBatchResponse.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JobProcessorHelpers#allocateResultIds(JobState, Instant, Map)}
   */
  @Test
  void testAllocateResultIds() {
    // Arrange
    JobProcessorHelpers jobProcessorHelpers = new JobProcessorHelpers(PlatformConfig.getDefaultInstance(), null,
        mock(GrpcConcern.class));
    JobState jobState = new JobState();
    Instant jobTimestamp = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant();
    HashMap<String, MetadataWriteRequest> newResultIds = new HashMap<>();

    // Act
    JobState actualAllocateResultIdsResult = jobProcessorHelpers.allocateResultIds(jobState, jobTimestamp,
        newResultIds);

    // Assert
    assertTrue(newResultIds.isEmpty());
    assertTrue(jobState.resources.isEmpty());
    assertTrue(jobState.resultMapping.isEmpty());
    assertSame(jobState, actualAllocateResultIdsResult);
  }
}
