package org.finos.tracdap.svc.meta.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.sql.DataSource;
import org.finos.tracdap.api.PlatformInfoResponse;
import org.finos.tracdap.common.db.JdbcDialect;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.svc.meta.dal.IMetadataDal;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcMetadataDal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MetadataReadServiceDiffblueTest {
  /**
   * Test {@link MetadataReadService#MetadataReadService(IMetadataDal, PlatformConfig)}.
   *
   * <p>Method under test: {@link MetadataReadService#MetadataReadService(IMetadataDal,
   * PlatformConfig)}
   */
  @Test
  @DisplayName("Test new MetadataReadService(IMetadataDal, PlatformConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetadataReadService.<init>(IMetadataDal, PlatformConfig)"})
  void testNewMetadataReadService() {
    // Arrange
    JdbcMetadataDal dal = new JdbcMetadataDal(JdbcDialect.H2, mock(DataSource.class));

    // Act and Assert
    PlatformInfoResponse platformInfoResult =
        new MetadataReadService(dal, PlatformConfig.getDefaultInstance()).platformInfo();
    assertEquals("", platformInfoResult.getInitializationErrorString());
    assertEquals("DEVELOPMENT (Unpackaged)", platformInfoResult.getTracVersion());
    assertEquals("ENVIRONMENT_NOT_SET", platformInfoResult.getEnvironment());
    assertEquals(0, platformInfoResult.getDeploymentInfoCount());
    assertEquals(2, platformInfoResult.getAllFields().size());
    assertEquals(47, platformInfoResult.getSerializedSize());
    assertFalse(platformInfoResult.getProduction());
    assertTrue(platformInfoResult.findInitializationErrors().isEmpty());
    assertTrue(platformInfoResult.getDeploymentInfo().isEmpty());
    assertTrue(platformInfoResult.getDeploymentInfoMap().isEmpty());
  }
}
