package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.IDialect;
import org.finos.tracdap.svc.meta.dal.jdbc.dialects.OracleDialect;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcErrorDiffblueTest {
  /**
   * Method under test:
   * {@link JdbcError#objectNotFound(SQLException, IDialect, JdbcMetadataDal.ObjectParts, boolean, boolean)}
   */
  @Test
  void testObjectNotFound() {
    // Arrange
    SQLException error = new SQLException();
    IDialect dialect = mock(IDialect.class);
    when(dialect.mapErrorCode(Mockito.<SQLException>any())).thenReturn(JdbcErrorCode.UNKNOWN_ERROR_CODE);

    // Act
    JdbcError.objectNotFound(error, dialect, new JdbcMetadataDal.ObjectParts(), true, true);

    // Assert
    verify(dialect).mapErrorCode(isA(SQLException.class));
  }

  /**
   * Method under test:
   * {@link JdbcError#objectNotFound(SQLException, IDialect, JdbcMetadataDal.ObjectParts, boolean, boolean)}
   */
  @Test
  void testObjectNotFound2() {
    // Arrange
    SQLException error = new SQLException();
    IDialect dialect = mock(IDialect.class);
    when(dialect.mapErrorCode(Mockito.<SQLException>any())).thenReturn(JdbcErrorCode.UNKNOWN_ERROR_CODE);

    // Act
    JdbcError.objectNotFound(error, dialect, new JdbcMetadataDal.ObjectParts(), false, true);

    // Assert
    verify(dialect).mapErrorCode(isA(SQLException.class));
  }

  /**
   * Method under test:
   * {@link JdbcError#wrongObjectType(SQLException, IDialect, JdbcMetadataDal.ObjectParts)}
   */
  @Test
  void testWrongObjectType() {
    // Arrange
    SQLException error = new SQLException();
    IDialect dialect = mock(IDialect.class);
    when(dialect.mapErrorCode(Mockito.<SQLException>any())).thenReturn(JdbcErrorCode.UNKNOWN_ERROR_CODE);

    // Act
    JdbcError.wrongObjectType(error, dialect, new JdbcMetadataDal.ObjectParts());

    // Assert
    verify(dialect).mapErrorCode(isA(SQLException.class));
  }

  /**
   * Method under test:
   * {@link JdbcError#duplicateObjectId(SQLException, IDialect, JdbcMetadataDal.ObjectParts)}
   */
  @Test
  void testDuplicateObjectId() {
    // Arrange
    SQLException error = new SQLException();
    IDialect dialect = mock(IDialect.class);
    when(dialect.mapErrorCode(Mockito.<SQLException>any())).thenReturn(JdbcErrorCode.UNKNOWN_ERROR_CODE);

    // Act
    JdbcError.duplicateObjectId(error, dialect, new JdbcMetadataDal.ObjectParts());

    // Assert
    verify(dialect).mapErrorCode(isA(SQLException.class));
  }

  /**
   * Method under test:
   * {@link JdbcError#idNotPreallocated(SQLException, IDialect, JdbcMetadataDal.ObjectParts)}
   */
  @Test
  void testIdNotPreallocated() {
    // Arrange
    SQLException error = new SQLException();
    IDialect dialect = mock(IDialect.class);
    when(dialect.mapErrorCode(Mockito.<SQLException>any())).thenReturn(JdbcErrorCode.UNKNOWN_ERROR_CODE);

    // Act
    JdbcError.idNotPreallocated(error, dialect, new JdbcMetadataDal.ObjectParts());

    // Assert
    verify(dialect).mapErrorCode(isA(SQLException.class));
  }

  /**
   * Method under test:
   * {@link JdbcError#idAlreadyInUse(SQLException, IDialect, JdbcMetadataDal.ObjectParts)}
   */
  @Test
  void testIdAlreadyInUse() {
    // Arrange
    SQLException error = new SQLException();
    IDialect dialect = mock(IDialect.class);
    when(dialect.mapErrorCode(Mockito.<SQLException>any())).thenReturn(JdbcErrorCode.UNKNOWN_ERROR_CODE);

    // Act
    JdbcError.idAlreadyInUse(error, dialect, new JdbcMetadataDal.ObjectParts());

    // Assert
    verify(dialect).mapErrorCode(isA(SQLException.class));
  }

  /**
   * Method under test:
   * {@link JdbcError#priorVersionMissing(SQLException, IDialect, JdbcMetadataDal.ObjectParts)}
   */
  @Test
  void testPriorVersionMissing() {
    // Arrange
    SQLException error = new SQLException();
    IDialect dialect = mock(IDialect.class);
    when(dialect.mapErrorCode(Mockito.<SQLException>any())).thenReturn(JdbcErrorCode.UNKNOWN_ERROR_CODE);

    // Act
    JdbcError.priorVersionMissing(error, dialect, new JdbcMetadataDal.ObjectParts());

    // Assert
    verify(dialect).mapErrorCode(isA(SQLException.class));
  }

  /**
   * Method under test:
   * {@link JdbcError#versionSuperseded(SQLException, IDialect, JdbcMetadataDal.ObjectParts)}
   */
  @Test
  void testVersionSuperseded() {
    // Arrange
    SQLException error = new SQLException();
    IDialect dialect = mock(IDialect.class);
    when(dialect.mapErrorCode(Mockito.<SQLException>any())).thenReturn(JdbcErrorCode.UNKNOWN_ERROR_CODE);

    // Act
    JdbcError.versionSuperseded(error, dialect, new JdbcMetadataDal.ObjectParts());

    // Assert
    verify(dialect).mapErrorCode(isA(SQLException.class));
  }

  /**
   * Method under test:
   * {@link JdbcError#priorTagMissing(SQLException, IDialect, JdbcMetadataDal.ObjectParts)}
   */
  @Test
  void testPriorTagMissing() {
    // Arrange
    SQLException error = new SQLException();
    IDialect dialect = mock(IDialect.class);
    when(dialect.mapErrorCode(Mockito.<SQLException>any())).thenReturn(JdbcErrorCode.UNKNOWN_ERROR_CODE);

    // Act
    JdbcError.priorTagMissing(error, dialect, new JdbcMetadataDal.ObjectParts());

    // Assert
    verify(dialect).mapErrorCode(isA(SQLException.class));
  }

  /**
   * Method under test:
   * {@link JdbcError#tagSuperseded(SQLException, IDialect, JdbcMetadataDal.ObjectParts)}
   */
  @Test
  void testTagSuperseded() {
    // Arrange
    SQLException error = new SQLException();
    IDialect dialect = mock(IDialect.class);
    when(dialect.mapErrorCode(Mockito.<SQLException>any())).thenReturn(JdbcErrorCode.UNKNOWN_ERROR_CODE);

    // Act
    JdbcError.tagSuperseded(error, dialect, new JdbcMetadataDal.ObjectParts());

    // Assert
    verify(dialect).mapErrorCode(isA(SQLException.class));
  }

  /**
   * Method under test: {@link JdbcError#catchAll(SQLException, IDialect)}
   */
  @Test
  void testCatchAll() {
    // Arrange
    SQLException error = new SQLException();

    // Act
    ETracInternal actualCatchAllResult = JdbcError.catchAll(error, new OracleDialect());

    // Assert
    assertEquals("Unrecognised SQL Error code: ORACLE, sqlstate = null, error code = 0",
        actualCatchAllResult.getLocalizedMessage());
    assertEquals("Unrecognised SQL Error code: ORACLE, sqlstate = null, error code = 0",
        actualCatchAllResult.getMessage());
    assertEquals(0, actualCatchAllResult.getSuppressed().length);
    assertSame(error, actualCatchAllResult.getCause());
  }
}
