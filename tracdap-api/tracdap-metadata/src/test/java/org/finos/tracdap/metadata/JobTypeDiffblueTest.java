package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class JobTypeDiffblueTest {
  /**
   * Method under test: {@link JobType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(JobType.forNumber(42));
    assertEquals(JobType.JOB_TYPE_NOT_SET, JobType.forNumber(0));
    assertEquals(JobType.RUN_MODEL, JobType.forNumber(1));
    assertEquals(JobType.RUN_FLOW, JobType.forNumber(2));
    assertEquals(JobType.IMPORT_MODEL, JobType.forNumber(3));
    assertEquals(JobType.IMPORT_DATA, JobType.forNumber(4));
    assertEquals(JobType.EXPORT_DATA, JobType.forNumber(5));
    assertEquals(JobType.JOB_GROUP, JobType.forNumber(6));
  }

  /**
   * Method under test: {@link JobType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, JobType.JOB_TYPE_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> JobType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link JobType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> JobType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.RUN_MODEL, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.RUN_FLOW, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.IMPORT_MODEL, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.IMPORT_DATA, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap6() {
    // Arrange and Act
    Internal.EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.EXPORT_DATA, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap7() {
    // Arrange and Act
    Internal.EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link JobType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap8() {
    // Arrange and Act
    Internal.EnumLiteMap<JobType> actualInternalGetValueMapResult = JobType.internalGetValueMap();

    // Assert
    assertEquals(JobType.JOB_GROUP, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Method under test: {@link JobType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(JobType.valueOf(42));
    assertEquals(JobType.JOB_TYPE_NOT_SET, JobType.valueOf(0));
    assertEquals(JobType.RUN_MODEL, JobType.valueOf(1));
    assertEquals(JobType.RUN_FLOW, JobType.valueOf(2));
    assertEquals(JobType.IMPORT_MODEL, JobType.valueOf(3));
    assertEquals(JobType.IMPORT_DATA, JobType.valueOf(4));
    assertEquals(JobType.EXPORT_DATA, JobType.valueOf(5));
    assertEquals(JobType.JOB_GROUP, JobType.valueOf(6));
  }
}
