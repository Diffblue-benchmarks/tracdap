package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class JobGroupTypeDiffblueTest {
  /**
   * Method under test: {@link JobGroupType#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(JobGroupType.forNumber(42));
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, JobGroupType.forNumber(0));
    assertEquals(JobGroupType.SEQUENTIAL_JOB_GROUP, JobGroupType.forNumber(1));
    assertEquals(JobGroupType.PARALLEL_JOB_GROUP, JobGroupType.forNumber(2));
  }

  /**
   * Method under test: {@link JobGroupType#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, JobGroupType.JOB_GROUP_TYPE_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> JobGroupType.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link JobGroupType#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> JobGroupType.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link JobGroupType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<JobGroupType> actualInternalGetValueMapResult = JobGroupType.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link JobGroupType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<JobGroupType> actualInternalGetValueMapResult = JobGroupType.internalGetValueMap();

    // Assert
    assertEquals(JobGroupType.SEQUENTIAL_JOB_GROUP, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link JobGroupType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<JobGroupType> actualInternalGetValueMapResult = JobGroupType.internalGetValueMap();

    // Assert
    assertEquals(JobGroupType.PARALLEL_JOB_GROUP, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link JobGroupType#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<JobGroupType> actualInternalGetValueMapResult = JobGroupType.internalGetValueMap();

    // Assert
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link JobGroupType#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(JobGroupType.valueOf(42));
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, JobGroupType.valueOf(0));
    assertEquals(JobGroupType.SEQUENTIAL_JOB_GROUP, JobGroupType.valueOf(1));
    assertEquals(JobGroupType.PARALLEL_JOB_GROUP, JobGroupType.valueOf(2));
  }
}
