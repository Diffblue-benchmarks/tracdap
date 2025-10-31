package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.finos.tracdap.metadata.JobDefinition.JobDetailsCase;
import org.finos.tracdap.metadata.JobGroup.JobGroupDetailsCase;
import org.finos.tracdap.metadata.TagSelector.ObjectCriteriaCase;
import org.finos.tracdap.metadata.TagSelector.TagCriteriaCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JobDefinitionDiffblueTest {
  /**
   * Test {@link JobDefinition#getJobDetailsCase()}.
   * <p>
   * Method under test: {@link JobDefinition#getJobDetailsCase()}
   */
  @Test
  @DisplayName("Test getJobDetailsCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDefinition.getJobDetailsCase()"})
  void testGetJobDetailsCase() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, JobDefinition.getDefaultInstance().getJobDetailsCase());
  }

  /**
   * Test {@link JobDefinition#getJobType()}.
   * <p>
   * Method under test: {@link JobDefinition#getJobType()}
   */
  @Test
  @DisplayName("Test getJobType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobType JobDefinition.getJobType()"})
  void testGetJobType() {
    // Arrange, Act and Assert
    assertEquals(JobType.JOB_TYPE_NOT_SET, JobDefinition.getDefaultInstance().getJobType());
  }

  /**
   * Test {@link JobDefinition#hasRunModel()}.
   * <p>
   * Method under test: {@link JobDefinition#hasRunModel()}
   */
  @Test
  @DisplayName("Test hasRunModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.hasRunModel()"})
  void testHasRunModel() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasRunModel());
  }

  /**
   * Test {@link JobDefinition#getRunModel()}.
   * <p>
   * Method under test: {@link JobDefinition#getRunModel()}
   */
  @Test
  @DisplayName("Test getRunModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunModelJob JobDefinition.getRunModel()"})
  void testGetRunModel() {
    // Arrange and Act
    RunModelJob actualRunModel = JobDefinition.getDefaultInstance().getRunModel();

    // Assert
    assertEquals("", actualRunModel.getInitializationErrorString());
    assertEquals(0, actualRunModel.getInputsCount());
    assertEquals(0, actualRunModel.getOutputAttrsCount());
    assertEquals(0, actualRunModel.getOutputsCount());
    assertEquals(0, actualRunModel.getParametersCount());
    assertEquals(0, actualRunModel.getPriorOutputsCount());
    assertEquals(0, actualRunModel.getSerializedSize());
    assertFalse(actualRunModel.hasModel());
    assertTrue(actualRunModel.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualRunModel.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualRunModel.getAllFields().isEmpty());
    assertTrue(actualRunModel.getInputs().isEmpty());
    assertTrue(actualRunModel.getInputsMap().isEmpty());
    assertTrue(actualRunModel.getOutputs().isEmpty());
    assertTrue(actualRunModel.getOutputsMap().isEmpty());
    assertTrue(actualRunModel.getParameters().isEmpty());
    assertTrue(actualRunModel.getParametersMap().isEmpty());
    assertTrue(actualRunModel.getPriorOutputs().isEmpty());
    assertTrue(actualRunModel.getPriorOutputsMap().isEmpty());
    assertTrue(actualRunModel.isInitialized());
    assertSame(actualRunModel, actualRunModel.getDefaultInstanceForType());
    assertSame(outputAttrsList, actualRunModel.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link JobDefinition#hasRunFlow()}.
   * <p>
   * Method under test: {@link JobDefinition#hasRunFlow()}
   */
  @Test
  @DisplayName("Test hasRunFlow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.hasRunFlow()"})
  void testHasRunFlow() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasRunFlow());
  }

  /**
   * Test {@link JobDefinition#getRunFlow()}.
   * <p>
   * Method under test: {@link JobDefinition#getRunFlow()}
   */
  @Test
  @DisplayName("Test getRunFlow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RunFlowJob JobDefinition.getRunFlow()"})
  void testGetRunFlow() {
    // Arrange and Act
    RunFlowJob actualRunFlow = JobDefinition.getDefaultInstance().getRunFlow();

    // Assert
    assertEquals("", actualRunFlow.getInitializationErrorString());
    assertEquals(0, actualRunFlow.getInputsCount());
    assertEquals(0, actualRunFlow.getModelsCount());
    assertEquals(0, actualRunFlow.getOutputAttrsCount());
    assertEquals(0, actualRunFlow.getOutputsCount());
    assertEquals(0, actualRunFlow.getParametersCount());
    assertEquals(0, actualRunFlow.getPriorOutputsCount());
    assertEquals(0, actualRunFlow.getSerializedSize());
    assertFalse(actualRunFlow.hasFlow());
    assertTrue(actualRunFlow.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualRunFlow.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualRunFlow.getAllFields().isEmpty());
    assertTrue(actualRunFlow.getInputs().isEmpty());
    assertTrue(actualRunFlow.getInputsMap().isEmpty());
    assertTrue(actualRunFlow.getModels().isEmpty());
    assertTrue(actualRunFlow.getModelsMap().isEmpty());
    assertTrue(actualRunFlow.getOutputs().isEmpty());
    assertTrue(actualRunFlow.getOutputsMap().isEmpty());
    assertTrue(actualRunFlow.getParameters().isEmpty());
    assertTrue(actualRunFlow.getParametersMap().isEmpty());
    assertTrue(actualRunFlow.getPriorOutputs().isEmpty());
    assertTrue(actualRunFlow.getPriorOutputsMap().isEmpty());
    assertTrue(actualRunFlow.isInitialized());
    assertSame(actualRunFlow, actualRunFlow.getDefaultInstanceForType());
    assertSame(outputAttrsList, actualRunFlow.getOutputAttrsOrBuilderList());
  }

  /**
   * Test {@link JobDefinition#hasImportModel()}.
   * <p>
   * Method under test: {@link JobDefinition#hasImportModel()}
   */
  @Test
  @DisplayName("Test hasImportModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.hasImportModel()"})
  void testHasImportModel() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasImportModel());
  }

  /**
   * Test {@link JobDefinition#getImportModel()}.
   * <p>
   * Method under test: {@link JobDefinition#getImportModel()}
   */
  @Test
  @DisplayName("Test getImportModel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportModelJob JobDefinition.getImportModel()"})
  void testGetImportModel() {
    // Arrange and Act
    ImportModelJob actualImportModel = JobDefinition.getDefaultInstance().getImportModel();

    // Assert
    assertEquals("", actualImportModel.getInitializationErrorString());
    assertEquals("", actualImportModel.getEntryPoint());
    assertEquals("", actualImportModel.getLanguage());
    assertEquals("", actualImportModel.getPackage());
    assertEquals("", actualImportModel.getPackageGroup());
    assertEquals("", actualImportModel.getPath());
    assertEquals("", actualImportModel.getRepository());
    assertEquals("", actualImportModel.getVersion());
    assertEquals(0, actualImportModel.getModelAttrsCount());
    assertEquals(0, actualImportModel.getSerializedSize());
    assertFalse(actualImportModel.hasPackageGroup());
    assertTrue(actualImportModel.findInitializationErrors().isEmpty());
    List<TagUpdate> modelAttrsList = actualImportModel.getModelAttrsList();
    assertTrue(modelAttrsList.isEmpty());
    assertTrue(actualImportModel.getAllFields().isEmpty());
    assertTrue(actualImportModel.isInitialized());
    assertSame(modelAttrsList, actualImportModel.getModelAttrsOrBuilderList());
    assertSame(actualImportModel, actualImportModel.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#hasImportData()}.
   * <p>
   * Method under test: {@link JobDefinition#hasImportData()}
   */
  @Test
  @DisplayName("Test hasImportData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.hasImportData()"})
  void testHasImportData() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasImportData());
  }

  /**
   * Test {@link JobDefinition#getImportData()}.
   * <p>
   * Method under test: {@link JobDefinition#getImportData()}
   */
  @Test
  @DisplayName("Test getImportData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportDataJob JobDefinition.getImportData()"})
  void testGetImportData() {
    // Arrange and Act
    ImportDataJob actualImportData = JobDefinition.getDefaultInstance().getImportData();

    // Assert
    assertEquals("", actualImportData.getInitializationErrorString());
    assertEquals(0, actualImportData.getImportAttrsCount());
    assertEquals(0, actualImportData.getImportsCount());
    assertEquals(0, actualImportData.getInputsCount());
    assertEquals(0, actualImportData.getOutputAttrsCount());
    assertEquals(0, actualImportData.getOutputsCount());
    assertEquals(0, actualImportData.getParametersCount());
    assertEquals(0, actualImportData.getPriorOutputsCount());
    assertEquals(0, actualImportData.getSerializedSize());
    assertEquals(0, actualImportData.getStorageAccessCount());
    assertFalse(actualImportData.hasModel());
    assertTrue(actualImportData.findInitializationErrors().isEmpty());
    List<TagUpdate> importAttrsList = actualImportData.getImportAttrsList();
    assertTrue(importAttrsList.isEmpty());
    assertTrue(actualImportData.getStorageAccessList().isEmpty());
    assertTrue(actualImportData.getAllFields().isEmpty());
    assertTrue(actualImportData.getImports().isEmpty());
    assertTrue(actualImportData.getImportsMap().isEmpty());
    assertTrue(actualImportData.getInputs().isEmpty());
    assertTrue(actualImportData.getInputsMap().isEmpty());
    assertTrue(actualImportData.getOutputs().isEmpty());
    assertTrue(actualImportData.getOutputsMap().isEmpty());
    assertTrue(actualImportData.getParameters().isEmpty());
    assertTrue(actualImportData.getParametersMap().isEmpty());
    assertTrue(actualImportData.getPriorOutputs().isEmpty());
    assertTrue(actualImportData.getPriorOutputsMap().isEmpty());
    assertTrue(actualImportData.isInitialized());
    assertSame(importAttrsList, actualImportData.getImportAttrsOrBuilderList());
    assertSame(importAttrsList, actualImportData.getOutputAttrsList());
    assertSame(importAttrsList, actualImportData.getOutputAttrsOrBuilderList());
    assertSame(actualImportData, actualImportData.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#hasExportData()}.
   * <p>
   * Method under test: {@link JobDefinition#hasExportData()}
   */
  @Test
  @DisplayName("Test hasExportData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.hasExportData()"})
  void testHasExportData() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasExportData());
  }

  /**
   * Test {@link JobDefinition#getExportData()}.
   * <p>
   * Method under test: {@link JobDefinition#getExportData()}
   */
  @Test
  @DisplayName("Test getExportData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExportDataJob JobDefinition.getExportData()"})
  void testGetExportData() {
    // Arrange and Act
    ExportDataJob actualExportData = JobDefinition.getDefaultInstance().getExportData();

    // Assert
    assertEquals("", actualExportData.getInitializationErrorString());
    assertEquals(0, actualExportData.getExportsCount());
    assertEquals(0, actualExportData.getInputsCount());
    assertEquals(0, actualExportData.getOutputAttrsCount());
    assertEquals(0, actualExportData.getOutputsCount());
    assertEquals(0, actualExportData.getParametersCount());
    assertEquals(0, actualExportData.getPriorOutputsCount());
    assertEquals(0, actualExportData.getSerializedSize());
    assertEquals(0, actualExportData.getStorageAccessCount());
    assertFalse(actualExportData.hasModel());
    assertTrue(actualExportData.findInitializationErrors().isEmpty());
    List<TagUpdate> outputAttrsList = actualExportData.getOutputAttrsList();
    assertTrue(outputAttrsList.isEmpty());
    assertTrue(actualExportData.getStorageAccessList().isEmpty());
    assertTrue(actualExportData.getAllFields().isEmpty());
    assertTrue(actualExportData.getExports().isEmpty());
    assertTrue(actualExportData.getExportsMap().isEmpty());
    assertTrue(actualExportData.getInputs().isEmpty());
    assertTrue(actualExportData.getInputsMap().isEmpty());
    assertTrue(actualExportData.getOutputs().isEmpty());
    assertTrue(actualExportData.getOutputsMap().isEmpty());
    assertTrue(actualExportData.getParameters().isEmpty());
    assertTrue(actualExportData.getParametersMap().isEmpty());
    assertTrue(actualExportData.getPriorOutputs().isEmpty());
    assertTrue(actualExportData.getPriorOutputsMap().isEmpty());
    assertTrue(actualExportData.isInitialized());
    assertSame(outputAttrsList, actualExportData.getOutputAttrsOrBuilderList());
    assertSame(actualExportData, actualExportData.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#hasJobGroup()}.
   * <p>
   * Method under test: {@link JobDefinition#hasJobGroup()}
   */
  @Test
  @DisplayName("Test hasJobGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.hasJobGroup()"})
  void testHasJobGroup() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasJobGroup());
  }

  /**
   * Test {@link JobDefinition#getJobGroup()}.
   * <p>
   * Method under test: {@link JobDefinition#getJobGroup()}
   */
  @Test
  @DisplayName("Test getJobGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobGroup JobDefinition.getJobGroup()"})
  void testGetJobGroup() {
    // Arrange and Act
    JobGroup actualJobGroup = JobDefinition.getDefaultInstance().getJobGroup();

    // Assert
    assertEquals("", actualJobGroup.getInitializationErrorString());
    assertEquals(0, actualJobGroup.getJobGroupTypeValue());
    assertEquals(0, actualJobGroup.getSerializedSize());
    assertEquals(JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, actualJobGroup.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, actualJobGroup.getJobGroupType());
    assertFalse(actualJobGroup.hasParallel());
    assertFalse(actualJobGroup.hasSequential());
    assertTrue(actualJobGroup.findInitializationErrors().isEmpty());
    assertTrue(actualJobGroup.getAllFields().isEmpty());
    assertTrue(actualJobGroup.isInitialized());
    assertSame(actualJobGroup, actualJobGroup.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#hasResultId()}.
   * <p>
   * Method under test: {@link JobDefinition#hasResultId()}
   */
  @Test
  @DisplayName("Test hasResultId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.hasResultId()"})
  void testHasResultId() {
    // Arrange, Act and Assert
    assertFalse(JobDefinition.getDefaultInstance().hasResultId());
  }

  /**
   * Test {@link JobDefinition#getResultId()}.
   * <p>
   * Method under test: {@link JobDefinition#getResultId()}
   */
  @Test
  @DisplayName("Test getResultId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector JobDefinition.getResultId()"})
  void testGetResultId() {
    // Arrange and Act
    TagSelector actualResultId = JobDefinition.getDefaultInstance().getResultId();

    // Assert
    assertEquals("", actualResultId.getInitializationErrorString());
    assertEquals("", actualResultId.getObjectId());
    assertEquals(0, actualResultId.getObjectTypeValue());
    assertEquals(0, actualResultId.getObjectVersion());
    assertEquals(0, actualResultId.getSerializedSize());
    assertEquals(0, actualResultId.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualResultId.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualResultId.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualResultId.getTagCriteriaCase());
    assertFalse(actualResultId.getLatestObject());
    assertFalse(actualResultId.getLatestTag());
    assertFalse(actualResultId.hasLatestObject());
    assertFalse(actualResultId.hasLatestTag());
    assertFalse(actualResultId.hasObjectAsOf());
    assertFalse(actualResultId.hasObjectVersion());
    assertFalse(actualResultId.hasTagAsOf());
    assertFalse(actualResultId.hasTagVersion());
    assertTrue(actualResultId.findInitializationErrors().isEmpty());
    assertTrue(actualResultId.getAllFields().isEmpty());
    assertTrue(actualResultId.isInitialized());
    assertSame(actualResultId, actualResultId.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#isInitialized()}.
   * <p>
   * Method under test: {@link JobDefinition#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JobDefinition.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link JobDefinition#getSerializedSize()}.
   * <p>
   * Method under test: {@link JobDefinition#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobDefinition.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JobDefinition.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link JobDefinition#equals(Object)}, and {@link JobDefinition#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JobDefinition#equals(Object)}
   *   <li>{@link JobDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.equals(Object)", "int JobDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JobDefinition defaultInstance = JobDefinition.getDefaultInstance();
    JobDefinition defaultInstance2 = JobDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link JobDefinition#equals(Object)}, and {@link JobDefinition#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JobDefinition#equals(Object)}
   *   <li>{@link JobDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.equals(Object)", "int JobDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JobDefinition defaultInstance = JobDefinition.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link JobDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.equals(Object)", "int JobDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobDefinition.getDefaultInstance(), 1);
  }

  /**
   * Test {@link JobDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.equals(Object)", "int JobDefinition.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobDefinition.getDefaultInstance(), null);
  }

  /**
   * Test {@link JobDefinition#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JobDefinition.equals(Object)", "int JobDefinition.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JobDefinition.getDefaultInstance(), "Different type to JobDefinition");
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code IMPORTDATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when five; then return 'IMPORTDATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenFive_thenReturnImportdata() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.IMPORTDATA, JobDetailsCase.forNumber(5));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobDetailsCase.forNumber(42));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code IMPORTMODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when four; then return 'IMPORTMODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenFour_thenReturnImportmodel() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.IMPORTMODEL, JobDetailsCase.forNumber(4));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code JOBGROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when seven; then return 'JOBGROUP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenSeven_thenReturnJobgroup() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.JOBGROUP, JobDetailsCase.forNumber(7));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code EXPORTDATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when six; then return 'EXPORTDATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenSix_thenReturnExportdata() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.EXPORTDATA, JobDetailsCase.forNumber(6));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code RUNFLOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when three; then return 'RUNFLOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenThree_thenReturnRunflow() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.RUNFLOW, JobDetailsCase.forNumber(3));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code RUNMODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when two; then return 'RUNMODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenTwo_thenReturnRunmodel() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.RUNMODEL, JobDetailsCase.forNumber(2));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOBDETAILS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase forNumber(int); when zero; then return 'JOBDETAILS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.forNumber(int)"})
  void testJobDetailsCaseForNumber_whenZero_thenReturnJobdetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, JobDetailsCase.forNumber(0));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#getNumber()}.
   * <p>
   * Method under test: {@link JobDetailsCase#getNumber()}
   */
  @Test
  @DisplayName("Test JobDetailsCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JobDetailsCase.getNumber()"})
  void testJobDetailsCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(2, JobDetailsCase.valueOf("RUNMODEL").getNumber());
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code IMPORTDATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when five; then return 'IMPORTDATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenFive_thenReturnImportdata() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.IMPORTDATA, JobDetailsCase.valueOf(5));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JobDetailsCase.valueOf(42));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code IMPORTMODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when four; then return 'IMPORTMODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenFour_thenReturnImportmodel() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.IMPORTMODEL, JobDetailsCase.valueOf(4));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code JOBGROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when seven; then return 'JOBGROUP'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenSeven_thenReturnJobgroup() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.JOBGROUP, JobDetailsCase.valueOf(7));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code EXPORTDATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when six; then return 'EXPORTDATA'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenSix_thenReturnExportdata() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.EXPORTDATA, JobDetailsCase.valueOf(6));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code RUNFLOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when three; then return 'RUNFLOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenThree_thenReturnRunflow() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.RUNFLOW, JobDetailsCase.valueOf(3));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code RUNMODEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when two; then return 'RUNMODEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenTwo_thenReturnRunmodel() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.RUNMODEL, JobDetailsCase.valueOf(2));
  }

  /**
   * Test JobDetailsCase {@link JobDetailsCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code JOBDETAILS_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDetailsCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test JobDetailsCase valueOf(int) with 'value'; when zero; then return 'JOBDETAILS_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDetailsCase JobDetailsCase.valueOf(int)"})
  void testJobDetailsCaseValueOfWithValue_whenZero_thenReturnJobdetailsNotSet() {
    // Arrange, Act and Assert
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, JobDetailsCase.valueOf(0));
  }

  /**
   * Test {@link JobDefinition#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(ByteString)"})
  void testParseFromWithByteString_givenCodedInputStreamReadTagReturnFour() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Given {@link CodedInputStream} {@link CodedInputStream#readTag()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; given CodedInputStream readTag() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(ByteString)"})
  void testParseFromWithByteString_givenCodedInputStreamReadTagReturnZero() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getJobTypeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JobDetailsCase.JOBDETAILS_NOT_SET, actualParseFromResult.getJobDetailsCase());
    assertEquals(JobType.JOB_TYPE_NOT_SET, actualParseFromResult.getJobType());
    assertFalse(actualParseFromResult.hasExportData());
    assertFalse(actualParseFromResult.hasImportData());
    assertFalse(actualParseFromResult.hasImportModel());
    assertFalse(actualParseFromResult.hasJobGroup());
    assertFalse(actualParseFromResult.hasResultId());
    assertFalse(actualParseFromResult.hasRunFlow());
    assertFalse(actualParseFromResult.hasRunModel());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JobDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link JobDefinition#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobDefinition.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link JobDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JobDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link JobDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobDefinition.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link JobDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JobDefinition actualParseFromResult = JobDefinition.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JobDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        JobDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JobDefinition actualParseDelimitedFromResult = JobDefinition.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JobDefinition.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link JobDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JobDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link JobDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JobDefinition.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link JobDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, JobDefinition.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link JobDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JobDefinition actualParseDelimitedFromResult = JobDefinition.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link JobDefinition#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobDefinition#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JobDefinition.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link JobDefinition#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link JobDefinition#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobDefinition JobDefinition.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    JobDefinition defaultInstance = JobDefinition.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }
}
