package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;

class JobStatusCodeDiffblueTest {
  /**
   * Method under test: {@link JobStatusCode#forNumber(int)}
   */
  @Test
  void testForNumber() {
    // Arrange, Act and Assert
    assertNull(JobStatusCode.forNumber(42));
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, JobStatusCode.forNumber(0));
    assertEquals(JobStatusCode.PREPARING, JobStatusCode.forNumber(1));
    assertEquals(JobStatusCode.VALIDATED, JobStatusCode.forNumber(2));
    assertEquals(JobStatusCode.PENDING, JobStatusCode.forNumber(3));
    assertEquals(JobStatusCode.QUEUED, JobStatusCode.forNumber(4));
    assertEquals(JobStatusCode.SUBMITTED, JobStatusCode.forNumber(5));
    assertEquals(JobStatusCode.RUNNING, JobStatusCode.forNumber(6));
    assertEquals(JobStatusCode.FINISHING, JobStatusCode.forNumber(7));
    assertEquals(JobStatusCode.SUCCEEDED, JobStatusCode.forNumber(8));
    assertEquals(JobStatusCode.FAILED, JobStatusCode.forNumber(JobStatusCode.FAILED_VALUE));
    assertEquals(JobStatusCode.CANCELLED, JobStatusCode.forNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link JobStatusCode#getNumber()}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, JobStatusCode.JOB_STATUS_CODE_NOT_SET.getNumber());
    assertThrows(IllegalArgumentException.class, () -> JobStatusCode.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test: {@link JobStatusCode#getValueDescriptor()}
   */
  @Test
  void testGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> JobStatusCode.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.CANCELLED,
        actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.CANCELLED_VALUE));
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.PREPARING, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.VALIDATED, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.PENDING, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.QUEUED, actualInternalGetValueMapResult.findValueByNumber(4));
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap6() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.SUBMITTED, actualInternalGetValueMapResult.findValueByNumber(5));
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap7() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap8() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.RUNNING, actualInternalGetValueMapResult.findValueByNumber(6));
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap9() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(-1));
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap10() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.FINISHING, actualInternalGetValueMapResult.findValueByNumber(7));
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap11() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.SUCCEEDED, actualInternalGetValueMapResult.findValueByNumber(8));
  }

  /**
   * Method under test: {@link JobStatusCode#internalGetValueMap()}
   */
  @Test
  void testInternalGetValueMap12() {
    // Arrange and Act
    Internal.EnumLiteMap<JobStatusCode> actualInternalGetValueMapResult = JobStatusCode.internalGetValueMap();

    // Assert
    assertEquals(JobStatusCode.FAILED, actualInternalGetValueMapResult.findValueByNumber(JobStatusCode.FAILED_VALUE));
  }

  /**
   * Method under test: {@link JobStatusCode#valueOf(int)}
   */
  @Test
  void testValueOf() {
    // Arrange, Act and Assert
    assertNull(JobStatusCode.valueOf(42));
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, JobStatusCode.valueOf(0));
    assertEquals(JobStatusCode.PREPARING, JobStatusCode.valueOf(1));
    assertEquals(JobStatusCode.VALIDATED, JobStatusCode.valueOf(2));
    assertEquals(JobStatusCode.PENDING, JobStatusCode.valueOf(3));
    assertEquals(JobStatusCode.QUEUED, JobStatusCode.valueOf(4));
    assertEquals(JobStatusCode.SUBMITTED, JobStatusCode.valueOf(5));
    assertEquals(JobStatusCode.RUNNING, JobStatusCode.valueOf(6));
    assertEquals(JobStatusCode.FINISHING, JobStatusCode.valueOf(7));
    assertEquals(JobStatusCode.SUCCEEDED, JobStatusCode.valueOf(8));
    assertEquals(JobStatusCode.FAILED, JobStatusCode.valueOf(JobStatusCode.FAILED_VALUE));
    assertEquals(JobStatusCode.CANCELLED, JobStatusCode.valueOf(JobStatusCode.CANCELLED_VALUE));
  }
}
