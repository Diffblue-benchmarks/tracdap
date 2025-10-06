package org.finos.tracdap.gateway.proxy.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RestApiMethodDiffblueTest {
  /**
   * Test {@link RestApiMethod#POST(MethodDescriptor, Message, Message, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code *}.
   *   <li>Then return {@link RestApiMethod#grpcMethod} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiMethod#POST(MethodDescriptor, Message, Message, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test POST(MethodDescriptor, Message, Message, String, String, String); when '*'; then return grpcMethod is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RestApiMethod RestApiMethod.POST(MethodDescriptor, Message, Message, String, String, String)"
  })
  void testPOST_whenAsterisk_thenReturnGrpcMethodIsNull() {
    // Arrange and Act
    RestApiMethod<Message, Message> actualPOSTResult =
        RestApiMethod.POST(
            null,
            FileOptions.getDefaultInstance(),
            FileOptions.getDefaultInstance(),
            "*",
            "*",
            "*");

    // Assert
    assertNull(actualPOSTResult.grpcMethod);
    assertFalse(actualPOSTResult.isDownload);
    assertTrue(actualPOSTResult.hasBody);
  }

  /**
   * Test {@link RestApiMethod#POST(MethodDescriptor, Message, Message, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@link RestApiMethod#grpcMethod} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiMethod#POST(MethodDescriptor, Message, Message, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test POST(MethodDescriptor, Message, Message, String, String, String); when 'https://example.org/example'; then return grpcMethod is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RestApiMethod RestApiMethod.POST(MethodDescriptor, Message, Message, String, String, String)"
  })
  void testPOST_whenHttpsExampleOrgExample_thenReturnGrpcMethodIsNull() {
    // Arrange and Act
    RestApiMethod<Message, Message> actualPOSTResult =
        RestApiMethod.POST(
            null,
            FileOptions.getDefaultInstance(),
            FileOptions.getDefaultInstance(),
            "https://example.org/example",
            "*",
            "*");

    // Assert
    assertNull(actualPOSTResult.grpcMethod);
    assertFalse(actualPOSTResult.isDownload);
    assertTrue(actualPOSTResult.hasBody);
  }

  /**
   * Test {@link RestApiMethod#POST(MethodDescriptor, Message, Message, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@link RestApiMethod#grpcMethod} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiMethod#POST(MethodDescriptor, Message, Message, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test POST(MethodDescriptor, Message, Message, String, String, String); when '/'; then return grpcMethod is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RestApiMethod RestApiMethod.POST(MethodDescriptor, Message, Message, String, String, String)"
  })
  void testPOST_whenSlash_thenReturnGrpcMethodIsNull() {
    // Arrange and Act
    RestApiMethod<Message, Message> actualPOSTResult =
        RestApiMethod.POST(
            null,
            FileOptions.getDefaultInstance(),
            FileOptions.getDefaultInstance(),
            "/",
            "*",
            "*");

    // Assert
    assertNull(actualPOSTResult.grpcMethod);
    assertFalse(actualPOSTResult.isDownload);
    assertTrue(actualPOSTResult.hasBody);
  }

  /**
   * Test {@link RestApiMethod#GET(MethodDescriptor, Message, Message, String, String)}.
   *
   * <ul>
   *   <li>When {@code *}.
   *   <li>Then return {@link RestApiMethod#grpcMethod} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiMethod#GET(MethodDescriptor, Message, Message, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test GET(MethodDescriptor, Message, Message, String, String); when '*'; then return grpcMethod is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RestApiMethod RestApiMethod.GET(MethodDescriptor, Message, Message, String, String)"
  })
  void testGET_whenAsterisk_thenReturnGrpcMethodIsNull() {
    // Arrange and Act
    RestApiMethod<Message, Message> actualGETResult =
        RestApiMethod.GET(
            null,
            FileOptions.getDefaultInstance(),
            FileOptions.getDefaultInstance(),
            "https://example.org/example",
            "*");

    // Assert
    assertNull(actualGETResult.grpcMethod);
    assertFalse(actualGETResult.hasBody);
    assertFalse(actualGETResult.isDownload);
  }

  /**
   * Test {@link RestApiMethod#GET(MethodDescriptor, Message, Message, String, String)}.
   *
   * <ul>
   *   <li>When {@code *}.
   *   <li>Then return {@link RestApiMethod#grpcMethod} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiMethod#GET(MethodDescriptor, Message, Message, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test GET(MethodDescriptor, Message, Message, String, String); when '*'; then return grpcMethod is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RestApiMethod RestApiMethod.GET(MethodDescriptor, Message, Message, String, String)"
  })
  void testGET_whenAsterisk_thenReturnGrpcMethodIsNull2() {
    // Arrange and Act
    RestApiMethod<Message, Message> actualGETResult =
        RestApiMethod.GET(
            null, FileOptions.getDefaultInstance(), FileOptions.getDefaultInstance(), "*", "*");

    // Assert
    assertNull(actualGETResult.grpcMethod);
    assertFalse(actualGETResult.hasBody);
    assertFalse(actualGETResult.isDownload);
  }

  /**
   * Test {@link RestApiMethod#GET(MethodDescriptor, Message, Message, String, String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@link RestApiMethod#grpcMethod} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiMethod#GET(MethodDescriptor, Message, Message, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test GET(MethodDescriptor, Message, Message, String, String); when '/'; then return grpcMethod is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RestApiMethod RestApiMethod.GET(MethodDescriptor, Message, Message, String, String)"
  })
  void testGET_whenSlash_thenReturnGrpcMethodIsNull() {
    // Arrange and Act
    RestApiMethod<Message, Message> actualGETResult =
        RestApiMethod.GET(
            null, FileOptions.getDefaultInstance(), FileOptions.getDefaultInstance(), "/", "*");

    // Assert
    assertNull(actualGETResult.grpcMethod);
    assertFalse(actualGETResult.hasBody);
    assertFalse(actualGETResult.isDownload);
  }
}
