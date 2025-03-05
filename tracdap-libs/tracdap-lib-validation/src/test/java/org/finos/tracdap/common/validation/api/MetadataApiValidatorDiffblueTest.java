package org.finos.tracdap.common.validation.api;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import org.finos.tracdap.api.ClientConfigRequest;
import org.finos.tracdap.api.ListResourcesRequest;
import org.finos.tracdap.api.MetadataBatchRequest;
import org.finos.tracdap.api.MetadataGetRequest;
import org.finos.tracdap.api.MetadataReadRequest;
import org.finos.tracdap.api.MetadataSearchRequest;
import org.finos.tracdap.api.MetadataWriteBatchRequest;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.api.ResourceInfoRequest;
import org.finos.tracdap.common.validation.core.ValidationContext;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.finos.tracdap.common.validation.core.ValidationFunction.Basic;
import org.finos.tracdap.common.validation.core.ValidationFunction.Typed;
import org.finos.tracdap.common.validation.core.ValidationFunction.TypedArg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataApiValidatorDiffblueTest {
  /**
   * Test {@link MetadataApiValidator#createObject(MetadataWriteRequest, ValidationContext, boolean, String)} with {@code msg}, {@code ctx}, {@code apiTrust}, {@code expectedTenant}.
   * <ul>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#createObject(MetadataWriteRequest, ValidationContext, boolean, String)}
   */
  @Test
  @DisplayName("Test createObject(MetadataWriteRequest, ValidationContext, boolean, String) with 'msg', 'ctx', 'apiTrust', 'expectedTenant'; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext MetadataApiValidator.createObject(MetadataWriteRequest, ValidationContext, boolean, String)"})
  void testCreateObjectWithMsgCtxApiTrustExpectedTenant_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Basic>any())).thenReturn(validationContext20);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext21);

    // Act
    MetadataApiValidator.createObject(msg, ctx, true, "Expected Tenant");

    // Assert
    verify(validationContext21).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext20).apply(isA(Typed.class));
    verify(validationContext19).apply(isA(Typed.class));
    verify(validationContext15).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext14).applyIf(eq(false), isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext11).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext18).pop();
    verify(validationContext13).pop();
    verify(validationContext9).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext17).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
    verify(validationContext12).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#createObject(MetadataWriteRequest, ValidationContext, boolean, String)} with {@code msg}, {@code ctx}, {@code apiTrust}, {@code expectedTenant}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#createObject(MetadataWriteRequest, ValidationContext, boolean, String)}
   */
  @Test
  @DisplayName("Test createObject(MetadataWriteRequest, ValidationContext, boolean, String) with 'msg', 'ctx', 'apiTrust', 'expectedTenant'; when 'false'; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext MetadataApiValidator.createObject(MetadataWriteRequest, ValidationContext, boolean, String)"})
  void testCreateObjectWithMsgCtxApiTrustExpectedTenant_whenFalse_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Basic>any())).thenReturn(validationContext20);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext21);

    // Act
    MetadataApiValidator.createObject(msg, ctx, false, "Expected Tenant");

    // Assert
    verify(validationContext21).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext20).apply(isA(Typed.class));
    verify(validationContext19).apply(isA(Typed.class));
    verify(validationContext15).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext14).applyIf(eq(false), isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext11).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext18).pop();
    verify(validationContext13).pop();
    verify(validationContext9).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext17).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
    verify(validationContext12).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#createObject(MetadataWriteRequest, ValidationContext, boolean, String)} with {@code msg}, {@code ctx}, {@code apiTrust}, {@code expectedTenant}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#createObject(MetadataWriteRequest, ValidationContext, boolean, String)}
   */
  @Test
  @DisplayName("Test createObject(MetadataWriteRequest, ValidationContext, boolean, String) with 'msg', 'ctx', 'apiTrust', 'expectedTenant'; when 'null'; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext MetadataApiValidator.createObject(MetadataWriteRequest, ValidationContext, boolean, String)"})
  void testCreateObjectWithMsgCtxApiTrustExpectedTenant_whenNull_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.applyRegistered()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pop()).thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Basic>any())).thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.pop()).thenReturn(validationContext26);
    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext27);
    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext28);
    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext29);
    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.pop()).thenReturn(validationContext30);
    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext31);
    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext32);
    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.apply(Mockito.<Basic>any())).thenReturn(validationContext33);
    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext34);
    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.pop()).thenReturn(validationContext35);
    when(validationContext36.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext18);
    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext36);
    ValidationContext validationContext38 = mock(ValidationContext.class);
    when(validationContext38.apply(Mockito.<Basic>any())).thenReturn(validationContext37);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext38);

    // Act
    MetadataApiValidator.createObject(msg, ctx, true, null);

    // Assert
    verify(validationContext38).apply(isA(Basic.class));
    verify(validationContext34).apply(isA(Basic.class));
    verify(validationContext25).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext37).apply(isA(Typed.class));
    verify(validationContext33).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext21).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext32).applyIf(eq(false), isA(Typed.class), isA(Class.class));
    verify(validationContext20).applyRegistered();
    verify(validationContext29).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext28).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext36).pop();
    verify(validationContext31).pop();
    verify(validationContext27).pop();
    verify(validationContext24).pop();
    verify(validationContext19).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext35).push(isA(FieldDescriptor.class));
    verify(validationContext26).push(isA(FieldDescriptor.class));
    verify(validationContext23).push(isA(FieldDescriptor.class));
    verify(validationContext30).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#createObject(MetadataWriteRequest, ValidationContext)} with {@code msg}, {@code ctx}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#createObject(MetadataWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test createObject(MetadataWriteRequest, ValidationContext) with 'msg', 'ctx'; when DefaultInstance; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.createObject(MetadataWriteRequest, ValidationContext)"})
  void testCreateObjectWithMsgCtx_whenDefaultInstance_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.pop()).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.apply(Mockito.<Basic>any())).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.pop()).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.apply(Mockito.<Basic>any())).thenReturn(validationContext19);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext20);

    // Act
    MetadataApiValidator.createObject(msg, ctx);

    // Assert
    verify(validationContext20).apply(isA(Basic.class));
    verify(validationContext16).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Typed.class));
    verify(validationContext15).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext3).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext14).applyIf(eq(false), isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext11).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext10).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext18).pop();
    verify(validationContext13).pop();
    verify(validationContext9).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext17).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
    verify(validationContext12).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#updateObject(MetadataWriteRequest, ValidationContext, boolean, String)} with {@code msg}, {@code ctx}, {@code apiTrust}, {@code expectedTenant}.
   * <ul>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#updateObject(MetadataWriteRequest, ValidationContext, boolean, String)}
   */
  @Test
  @DisplayName("Test updateObject(MetadataWriteRequest, ValidationContext, boolean, String) with 'msg', 'ctx', 'apiTrust', 'expectedTenant'; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext MetadataApiValidator.updateObject(MetadataWriteRequest, ValidationContext, boolean, String)"})
  void testUpdateObjectWithMsgCtxApiTrustExpectedTenant_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pop()).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Basic>any())).thenReturn(validationContext23);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext24);

    // Act
    MetadataApiValidator.updateObject(msg, ctx, true, "Expected Tenant");

    // Assert
    verify(validationContext24).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext23).apply(isA(Typed.class));
    verify(validationContext22).apply(isA(Typed.class));
    verify(validationContext18).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext9).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext3).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext17).applyIf(eq(true), isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext14).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext21).pop();
    verify(validationContext16).pop();
    verify(validationContext12).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext20).push(isA(FieldDescriptor.class));
    verify(validationContext11).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
    verify(validationContext15).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#updateObject(MetadataWriteRequest, ValidationContext, boolean, String)} with {@code msg}, {@code ctx}, {@code apiTrust}, {@code expectedTenant}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#updateObject(MetadataWriteRequest, ValidationContext, boolean, String)}
   */
  @Test
  @DisplayName("Test updateObject(MetadataWriteRequest, ValidationContext, boolean, String) with 'msg', 'ctx', 'apiTrust', 'expectedTenant'; when 'false'; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext MetadataApiValidator.updateObject(MetadataWriteRequest, ValidationContext, boolean, String)"})
  void testUpdateObjectWithMsgCtxApiTrustExpectedTenant_whenFalse_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pop()).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<Basic>any())).thenReturn(validationContext23);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext24);

    // Act
    MetadataApiValidator.updateObject(msg, ctx, false, "Expected Tenant");

    // Assert
    verify(validationContext24).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext23).apply(isA(Typed.class));
    verify(validationContext22).apply(isA(Typed.class));
    verify(validationContext18).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext9).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext3).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext17).applyIf(eq(true), isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext14).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext21).pop();
    verify(validationContext16).pop();
    verify(validationContext12).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext20).push(isA(FieldDescriptor.class));
    verify(validationContext11).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
    verify(validationContext15).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#updateObject(MetadataWriteRequest, ValidationContext, boolean, String)} with {@code msg}, {@code ctx}, {@code apiTrust}, {@code expectedTenant}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#updateObject(MetadataWriteRequest, ValidationContext, boolean, String)}
   */
  @Test
  @DisplayName("Test updateObject(MetadataWriteRequest, ValidationContext, boolean, String) with 'msg', 'ctx', 'apiTrust', 'expectedTenant'; when 'null'; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext MetadataApiValidator.updateObject(MetadataWriteRequest, ValidationContext, boolean, String)"})
  void testUpdateObjectWithMsgCtxApiTrustExpectedTenant_whenNull_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pop()).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.applyRegistered()).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Basic>any())).thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.pop()).thenReturn(validationContext26);
    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext27);
    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext28);
    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext29);
    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.apply(Mockito.<Basic>any())).thenReturn(validationContext30);
    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext31);
    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.pop()).thenReturn(validationContext32);
    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext33);
    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext34);
    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext35);
    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.pop()).thenReturn(validationContext36);
    ValidationContext validationContext38 = mock(ValidationContext.class);
    when(validationContext38.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext37);
    ValidationContext validationContext39 = mock(ValidationContext.class);
    when(validationContext39.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext38);
    ValidationContext validationContext40 = mock(ValidationContext.class);
    when(validationContext40.apply(Mockito.<Basic>any())).thenReturn(validationContext39);
    ValidationContext validationContext41 = mock(ValidationContext.class);
    when(validationContext41.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext40);
    ValidationContext validationContext42 = mock(ValidationContext.class);
    when(validationContext42.pop()).thenReturn(validationContext41);
    when(validationContext42.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext21);
    ValidationContext validationContext43 = mock(ValidationContext.class);
    when(validationContext43.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext42);
    ValidationContext validationContext44 = mock(ValidationContext.class);
    when(validationContext44.apply(Mockito.<Basic>any())).thenReturn(validationContext43);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext44);

    // Act
    MetadataApiValidator.updateObject(msg, ctx, true, null);

    // Assert
    verify(validationContext44).apply(isA(Basic.class));
    verify(validationContext40).apply(isA(Basic.class));
    verify(validationContext31).apply(isA(Basic.class));
    verify(validationContext25).apply(isA(Basic.class));
    verify(validationContext43).apply(isA(Typed.class));
    verify(validationContext39).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext30).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext28).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext29).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext24).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext38).applyIf(eq(true), isA(Typed.class), isA(Class.class));
    verify(validationContext23).applyRegistered();
    verify(validationContext35).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext34).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext42).pop();
    verify(validationContext37).pop();
    verify(validationContext33).pop();
    verify(validationContext27).pop();
    verify(validationContext22).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext41).push(isA(FieldDescriptor.class));
    verify(validationContext32).push(isA(FieldDescriptor.class));
    verify(validationContext26).push(isA(FieldDescriptor.class));
    verify(validationContext36).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#updateObject(MetadataWriteRequest, ValidationContext)} with {@code msg}, {@code ctx}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#updateObject(MetadataWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test updateObject(MetadataWriteRequest, ValidationContext) with 'msg', 'ctx'; when DefaultInstance; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.updateObject(MetadataWriteRequest, ValidationContext)"})
  void testUpdateObjectWithMsgCtx_whenDefaultInstance_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Basic>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.pop()).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.apply(Mockito.<Basic>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pop()).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Basic>any())).thenReturn(validationContext22);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext23);

    // Act
    MetadataApiValidator.updateObject(msg, ctx);

    // Assert
    verify(validationContext23).apply(isA(Basic.class));
    verify(validationContext19).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Typed.class));
    verify(validationContext18).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext9).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext3).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext17).applyIf(eq(true), isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext14).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext21).pop();
    verify(validationContext16).pop();
    verify(validationContext12).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext20).push(isA(FieldDescriptor.class));
    verify(validationContext11).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
    verify(validationContext15).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#updateTag(MetadataWriteRequest, ValidationContext, boolean, String)} with {@code msg}, {@code ctx}, {@code apiTrust}, {@code expectedTenant}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#updateTag(MetadataWriteRequest, ValidationContext, boolean, String)}
   */
  @Test
  @DisplayName("Test updateTag(MetadataWriteRequest, ValidationContext, boolean, String) with 'msg', 'ctx', 'apiTrust', 'expectedTenant'; when DefaultInstance; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext MetadataApiValidator.updateTag(MetadataWriteRequest, ValidationContext, boolean, String)"})
  void testUpdateTagWithMsgCtxApiTrustExpectedTenant_whenDefaultInstance_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Basic>any())).thenReturn(validationContext22);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext23);

    // Act
    MetadataApiValidator.updateTag(msg, ctx, true, "Expected Tenant");

    // Assert
    verify(validationContext23).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Typed.class));
    verify(validationContext21).apply(isA(Typed.class));
    verify(validationContext17).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext5).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext16).applyIf(eq(false), isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext20).pop();
    verify(validationContext15).pop();
    verify(validationContext11).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext19).push(isA(FieldDescriptor.class));
    verify(validationContext10).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
    verify(validationContext14).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#updateTag(MetadataWriteRequest, ValidationContext, boolean, String)} with {@code msg}, {@code ctx}, {@code apiTrust}, {@code expectedTenant}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#updateTag(MetadataWriteRequest, ValidationContext, boolean, String)}
   */
  @Test
  @DisplayName("Test updateTag(MetadataWriteRequest, ValidationContext, boolean, String) with 'msg', 'ctx', 'apiTrust', 'expectedTenant'; when 'false'; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext MetadataApiValidator.updateTag(MetadataWriteRequest, ValidationContext, boolean, String)"})
  void testUpdateTagWithMsgCtxApiTrustExpectedTenant_whenFalse_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.apply(Mockito.<Basic>any())).thenReturn(validationContext22);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext23);

    // Act
    MetadataApiValidator.updateTag(msg, ctx, false, "Expected Tenant");

    // Assert
    verify(validationContext23).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Typed.class));
    verify(validationContext21).apply(isA(Typed.class));
    verify(validationContext17).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext5).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext16).applyIf(eq(false), isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext20).pop();
    verify(validationContext15).pop();
    verify(validationContext11).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext19).push(isA(FieldDescriptor.class));
    verify(validationContext10).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
    verify(validationContext14).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#updateTag(MetadataWriteRequest, ValidationContext, boolean, String)} with {@code msg}, {@code ctx}, {@code apiTrust}, {@code expectedTenant}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#updateTag(MetadataWriteRequest, ValidationContext, boolean, String)}
   */
  @Test
  @DisplayName("Test updateTag(MetadataWriteRequest, ValidationContext, boolean, String) with 'msg', 'ctx', 'apiTrust', 'expectedTenant'; when 'null'; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext MetadataApiValidator.updateTag(MetadataWriteRequest, ValidationContext, boolean, String)"})
  void testUpdateTagWithMsgCtxApiTrustExpectedTenant_whenNull_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);
    ValidationContext validationContext23 = mock(ValidationContext.class);
    when(validationContext23.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext22);
    ValidationContext validationContext24 = mock(ValidationContext.class);
    when(validationContext24.pop()).thenReturn(validationContext23);
    ValidationContext validationContext25 = mock(ValidationContext.class);
    when(validationContext25.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext24);
    ValidationContext validationContext26 = mock(ValidationContext.class);
    when(validationContext26.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext25);
    ValidationContext validationContext27 = mock(ValidationContext.class);
    when(validationContext27.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext26);
    ValidationContext validationContext28 = mock(ValidationContext.class);
    when(validationContext28.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext27);
    ValidationContext validationContext29 = mock(ValidationContext.class);
    when(validationContext29.apply(Mockito.<Basic>any())).thenReturn(validationContext28);
    ValidationContext validationContext30 = mock(ValidationContext.class);
    when(validationContext30.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext29);
    ValidationContext validationContext31 = mock(ValidationContext.class);
    when(validationContext31.pop()).thenReturn(validationContext30);
    ValidationContext validationContext32 = mock(ValidationContext.class);
    when(validationContext32.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext31);
    ValidationContext validationContext33 = mock(ValidationContext.class);
    when(validationContext33.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext32);
    ValidationContext validationContext34 = mock(ValidationContext.class);
    when(validationContext34.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext33);
    ValidationContext validationContext35 = mock(ValidationContext.class);
    when(validationContext35.pop()).thenReturn(validationContext34);
    ValidationContext validationContext36 = mock(ValidationContext.class);
    when(validationContext36.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext35);
    ValidationContext validationContext37 = mock(ValidationContext.class);
    when(validationContext37.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext36);
    ValidationContext validationContext38 = mock(ValidationContext.class);
    when(validationContext38.apply(Mockito.<Basic>any())).thenReturn(validationContext37);
    ValidationContext validationContext39 = mock(ValidationContext.class);
    when(validationContext39.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext38);
    ValidationContext validationContext40 = mock(ValidationContext.class);
    when(validationContext40.pop()).thenReturn(validationContext39);
    when(validationContext40.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext20);
    ValidationContext validationContext41 = mock(ValidationContext.class);
    when(validationContext41.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext40);
    ValidationContext validationContext42 = mock(ValidationContext.class);
    when(validationContext42.apply(Mockito.<Basic>any())).thenReturn(validationContext41);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext42);

    // Act
    MetadataApiValidator.updateTag(msg, ctx, true, null);

    // Assert
    verify(validationContext42).apply(isA(Basic.class));
    verify(validationContext38).apply(isA(Basic.class));
    verify(validationContext29).apply(isA(Basic.class));
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext41).apply(isA(Typed.class));
    verify(validationContext37).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext28).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext26).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext25).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext27).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext36).applyIf(eq(false), isA(Typed.class), isA(Class.class));
    verify(validationContext33).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext32).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext40).pop();
    verify(validationContext35).pop();
    verify(validationContext31).pop();
    verify(validationContext24).pop();
    verify(validationContext21).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext39).push(isA(FieldDescriptor.class));
    verify(validationContext30).push(isA(FieldDescriptor.class));
    verify(validationContext23).push(isA(FieldDescriptor.class));
    verify(validationContext34).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#updateTag(MetadataWriteRequest, ValidationContext)} with {@code msg}, {@code ctx}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#updateTag(MetadataWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test updateTag(MetadataWriteRequest, ValidationContext) with 'msg', 'ctx'; when DefaultInstance; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.updateTag(MetadataWriteRequest, ValidationContext)"})
  void testUpdateTagWithMsgCtx_whenDefaultInstance_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext22);

    // Act
    MetadataApiValidator.updateTag(msg, ctx);

    // Assert
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext21).apply(isA(Typed.class));
    verify(validationContext17).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext5).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext16).applyIf(eq(false), isA(Typed.class), isA(Class.class));
    verify(validationContext13).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext20).pop();
    verify(validationContext15).pop();
    verify(validationContext11).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext19).push(isA(FieldDescriptor.class));
    verify(validationContext10).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
    verify(validationContext14).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#preallocateId(MetadataWriteRequest, ValidationContext)} with {@code msg}, {@code ctx}.
   * <p>
   * Method under test: {@link MetadataApiValidator#preallocateId(MetadataWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test preallocateId(MetadataWriteRequest, ValidationContext) with 'msg', 'ctx'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.preallocateId(MetadataWriteRequest, ValidationContext)"})
  void testPreallocateIdWithMsgCtx() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.pop()).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.apply(Mockito.<Basic>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.pop()).thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);

    // Act
    MetadataApiValidator.preallocateId(msg, ctx);

    // Assert
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext14).apply(isA(Basic.class));
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(validationContext17).apply(isA(Typed.class));
    verify(validationContext13).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyIf(eq(false), isA(Typed.class), isA(Class.class));
    verify(validationContext9).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext8).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext16).pop();
    verify(validationContext11).pop();
    verify(validationContext7).pop();
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext15).push(isA(FieldDescriptor.class));
    verify(validationContext6).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
    verify(validationContext10).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#createPreallocatedObject(MetadataWriteRequest, ValidationContext)} with {@code msg}, {@code ctx}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#createPreallocatedObject(MetadataWriteRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test createPreallocatedObject(MetadataWriteRequest, ValidationContext) with 'msg', 'ctx'; when DefaultInstance; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext MetadataApiValidator.createPreallocatedObject(MetadataWriteRequest, ValidationContext)"})
  void testCreatePreallocatedObjectWithMsgCtx_whenDefaultInstance_thenCallsApply() {
    // Arrange
    MetadataWriteRequest msg = MetadataWriteRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRegistered()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.pop()).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.apply(Mockito.<Basic>any())).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.pop()).thenReturn(validationContext10);
    ValidationContext validationContext12 = mock(ValidationContext.class);
    when(validationContext12.applyRepeated(Mockito.<TypedArg<Object, Object>>any(), Mockito.<Class<Object>>any(),
        Mockito.<Object>any())).thenReturn(validationContext11);
    ValidationContext validationContext13 = mock(ValidationContext.class);
    when(validationContext13.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext12);
    ValidationContext validationContext14 = mock(ValidationContext.class);
    when(validationContext14.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext13);
    ValidationContext validationContext15 = mock(ValidationContext.class);
    when(validationContext15.pop()).thenReturn(validationContext14);
    ValidationContext validationContext16 = mock(ValidationContext.class);
    when(validationContext16.applyIf(anyBoolean(), Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext15);
    ValidationContext validationContext17 = mock(ValidationContext.class);
    when(validationContext17.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext16);
    ValidationContext validationContext18 = mock(ValidationContext.class);
    when(validationContext18.apply(Mockito.<Basic>any())).thenReturn(validationContext17);
    ValidationContext validationContext19 = mock(ValidationContext.class);
    when(validationContext19.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext18);
    ValidationContext validationContext20 = mock(ValidationContext.class);
    when(validationContext20.pop()).thenReturn(validationContext19);
    ValidationContext validationContext21 = mock(ValidationContext.class);
    when(validationContext21.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext20);
    ValidationContext validationContext22 = mock(ValidationContext.class);
    when(validationContext22.apply(Mockito.<Basic>any())).thenReturn(validationContext21);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext22);

    // Act
    MetadataApiValidator.createPreallocatedObject(msg, ctx);

    // Assert
    verify(validationContext22).apply(isA(Basic.class));
    verify(validationContext18).apply(isA(Basic.class));
    verify(validationContext9).apply(isA(Basic.class));
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext21).apply(isA(Typed.class));
    verify(validationContext17).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext8).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext7).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext3).apply(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext16).applyIf(eq(false), isA(Typed.class), isA(Class.class));
    verify(validationContext2).applyRegistered();
    verify(validationContext13).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext12).applyRepeated(isA(TypedArg.class), isA(Class.class), isA(Object.class));
    verify(validationContext20).pop();
    verify(validationContext15).pop();
    verify(validationContext11).pop();
    verify(validationContext6).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext19).push(isA(FieldDescriptor.class));
    verify(validationContext10).push(isA(FieldDescriptor.class));
    verify(validationContext5).push(isA(FieldDescriptor.class));
    verify(validationContext14).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#writeBatch(MetadataWriteBatchRequest, ValidationContext, boolean)} with {@code msg}, {@code ctx}, {@code apiTrust}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#writeBatch(MetadataWriteBatchRequest, ValidationContext, boolean)}
   */
  @Test
  @DisplayName("Test writeBatch(MetadataWriteBatchRequest, ValidationContext, boolean) with 'msg', 'ctx', 'apiTrust'; when DefaultInstance; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ValidationContext MetadataApiValidator.writeBatch(MetadataWriteBatchRequest, ValidationContext, boolean)"})
  void testWriteBatchWithMsgCtxApiTrust_whenDefaultInstance_thenCallsApply() {
    // Arrange
    MetadataWriteBatchRequest msg = MetadataWriteBatchRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

    // Act
    MetadataApiValidator.writeBatch(msg, ctx, true);

    // Assert
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Typed.class));
    verify(validationContext).error(eq("Write batch request does not contain any operations"));
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#writeBatch(MetadataWriteBatchRequest, ValidationContext)} with {@code msg}, {@code ctx}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then calls {@link ValidationContext#apply(Basic)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataApiValidator#writeBatch(MetadataWriteBatchRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test writeBatch(MetadataWriteBatchRequest, ValidationContext) with 'msg', 'ctx'; when DefaultInstance; then calls apply(Basic)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.writeBatch(MetadataWriteBatchRequest, ValidationContext)"})
  void testWriteBatchWithMsgCtx_whenDefaultInstance_thenCallsApply() {
    // Arrange
    MetadataWriteBatchRequest msg = MetadataWriteBatchRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.error(Mockito.<String>any())).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.pop()).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.apply(Mockito.<Basic>any())).thenReturn(validationContext3);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext4);

    // Act
    MetadataApiValidator.writeBatch(msg, ctx);

    // Assert
    verify(validationContext4).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Typed.class));
    verify(validationContext).error(eq("Write batch request does not contain any operations"));
    verify(validationContext2).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#readObject(MetadataReadRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link MetadataApiValidator#readObject(MetadataReadRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test readObject(MetadataReadRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.readObject(MetadataReadRequest, ValidationContext)"})
  void testReadObject() {
    // Arrange
    MetadataReadRequest msg = MetadataReadRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    // Act
    MetadataApiValidator.readObject(msg, ctx);

    // Assert
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#readBatch(MetadataBatchRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link MetadataApiValidator#readBatch(MetadataBatchRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test readBatch(MetadataBatchRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.readBatch(MetadataBatchRequest, ValidationContext)"})
  void testReadBatch() {
    // Arrange
    MetadataBatchRequest msg = MetadataBatchRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.applyRepeated(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pushRepeated(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    // Act
    MetadataApiValidator.readBatch(msg, ctx);

    // Assert
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Typed.class));
    verify(validationContext2).applyRepeated(isA(Typed.class), isA(Class.class));
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext4).pushRepeated(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#search(MetadataSearchRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link MetadataApiValidator#search(MetadataSearchRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test search(MetadataSearchRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.search(MetadataSearchRequest, ValidationContext)"})
  void testSearch() {
    // Arrange
    MetadataSearchRequest msg = MetadataSearchRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    // Act
    MetadataApiValidator.search(msg, ctx);

    // Assert
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#getObject(MetadataGetRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link MetadataApiValidator#getObject(MetadataGetRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test getObject(MetadataGetRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.getObject(MetadataGetRequest, ValidationContext)"})
  void testGetObject() {
    // Arrange
    MetadataGetRequest msg = MetadataGetRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any())).thenReturn(validationContext8);

    // Act
    MetadataApiValidator.getObject(msg, ctx);

    // Assert
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(ctx).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#getLatestObject(MetadataGetRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link MetadataApiValidator#getLatestObject(MetadataGetRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test getLatestObject(MetadataGetRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.getLatestObject(MetadataGetRequest, ValidationContext)"})
  void testGetLatestObject() {
    // Arrange
    MetadataGetRequest msg = MetadataGetRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Basic>any())).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext5);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any())).thenReturn(validationContext6);

    // Act
    MetadataApiValidator.getLatestObject(msg, ctx);

    // Assert
    verify(validationContext5).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(ctx).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(validationContext6).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#getLatestTag(MetadataGetRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link MetadataApiValidator#getLatestTag(MetadataGetRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test getLatestTag(MetadataGetRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.getLatestTag(MetadataGetRequest, ValidationContext)"})
  void testGetLatestTag() {
    // Arrange
    MetadataGetRequest msg = MetadataGetRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Basic>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.pop()).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Basic>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext6);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any())).thenReturn(validationContext7);

    // Act
    MetadataApiValidator.getLatestTag(msg, ctx);

    // Assert
    verify(validationContext6).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Basic.class));
    verify(ctx).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext5).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext4).pop();
    verify(validationContext).pop();
    verify(validationContext7).push(isA(FieldDescriptor.class));
    verify(validationContext3).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#listResources(ListResourcesRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link MetadataApiValidator#listResources(ListResourcesRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test listResources(ListResourcesRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.listResources(ListResourcesRequest, ValidationContext)"})
  void testListResources() {
    // Arrange
    ListResourcesRequest msg = ListResourcesRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);

    // Act
    MetadataApiValidator.listResources(msg, ctx);

    // Assert
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext6).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#resourceInfo(ResourceInfoRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link MetadataApiValidator#resourceInfo(ResourceInfoRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test resourceInfo(ResourceInfoRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.resourceInfo(ResourceInfoRequest, ValidationContext)"})
  void testResourceInfo() {
    // Arrange
    ResourceInfoRequest msg = ResourceInfoRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext validationContext4 = mock(ValidationContext.class);
    when(validationContext4.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);
    ValidationContext validationContext5 = mock(ValidationContext.class);
    when(validationContext5.pop()).thenReturn(validationContext4);
    ValidationContext validationContext6 = mock(ValidationContext.class);
    when(validationContext6.apply(Mockito.<Typed<Object>>any(), Mockito.<Class<Object>>any()))
        .thenReturn(validationContext5);
    ValidationContext validationContext7 = mock(ValidationContext.class);
    when(validationContext7.apply(Mockito.<Basic>any())).thenReturn(validationContext6);
    ValidationContext validationContext8 = mock(ValidationContext.class);
    when(validationContext8.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext7);
    ValidationContext validationContext9 = mock(ValidationContext.class);
    when(validationContext9.pop()).thenReturn(validationContext8);
    ValidationContext validationContext10 = mock(ValidationContext.class);
    when(validationContext10.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext9);
    ValidationContext validationContext11 = mock(ValidationContext.class);
    when(validationContext11.apply(Mockito.<Basic>any())).thenReturn(validationContext10);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext11);

    // Act
    MetadataApiValidator.resourceInfo(msg, ctx);

    // Assert
    verify(validationContext11).apply(isA(Basic.class));
    verify(validationContext7).apply(isA(Basic.class));
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext10).apply(isA(Typed.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext6).apply(isA(Typed.class), isA(Class.class));
    verify(validationContext9).pop();
    verify(validationContext5).pop();
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
    verify(validationContext8).push(isA(FieldDescriptor.class));
    verify(validationContext4).push(isA(FieldDescriptor.class));
  }

  /**
   * Test {@link MetadataApiValidator#clientConfig(ClientConfigRequest, ValidationContext)}.
   * <p>
   * Method under test: {@link MetadataApiValidator#clientConfig(ClientConfigRequest, ValidationContext)}
   */
  @Test
  @DisplayName("Test clientConfig(ClientConfigRequest, ValidationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationContext MetadataApiValidator.clientConfig(ClientConfigRequest, ValidationContext)"})
  void testClientConfig() {
    // Arrange
    ClientConfigRequest msg = ClientConfigRequest.getDefaultInstance();
    ValidationContext validationContext = mock(ValidationContext.class);
    when(validationContext.pop()).thenReturn(mock(ValidationContext.class));
    ValidationContext validationContext2 = mock(ValidationContext.class);
    when(validationContext2.apply(Mockito.<Typed<String>>any())).thenReturn(validationContext);
    ValidationContext validationContext3 = mock(ValidationContext.class);
    when(validationContext3.apply(Mockito.<Basic>any())).thenReturn(validationContext2);
    ValidationContext ctx = mock(ValidationContext.class);
    when(ctx.push(Mockito.<FieldDescriptor>any())).thenReturn(validationContext3);

    // Act
    MetadataApiValidator.clientConfig(msg, ctx);

    // Assert
    verify(validationContext3).apply(isA(Basic.class));
    verify(validationContext2).apply(isA(Typed.class));
    verify(validationContext).pop();
    verify(ctx).push(isA(FieldDescriptor.class));
  }
}
