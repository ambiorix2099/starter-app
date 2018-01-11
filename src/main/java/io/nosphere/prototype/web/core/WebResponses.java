package io.nosphere.prototype.web.core;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class WebResponses {
    private static final Map<String, Object> NO_CONTENT = ImmutableMap.<String, Object>builder()
            .put("status", HttpStatus.NO_CONTENT.value())
            .build();

    private static final Map<String, Object> NOT_FOUND = ImmutableMap.<String, Object>builder()
            .put("status", HttpStatus.NOT_FOUND.value())
            .build();

    private WebResponses() {}

    public static Map<String, Object> newResourceCreated(Object resourceId) {
        return ImmutableMap.<String, Object>builder()
                .put("status", HttpStatus.CREATED.value())
                .put("resourceId", resourceId)
                .build();
    }

    public static Map<String, Object> resourceUpdated(Object resourceId) {
        return ImmutableMap.<String, Object>builder()
                .put("status", HttpStatus.OK.value())
                .put("resourceId", resourceId)
                .build();
    }

    public static Map<String, Object> error(Throwable e) {
        return ImmutableMap.<String, Object>builder()
                .put("status", HttpStatus.INTERNAL_SERVER_ERROR.value())
                .put("errors", ImmutableList.of(e.getMessage()))
                .build();
    }

    public static <T> Map<String, Object> page(Page<T> response) {
        return ImmutableMap.<String, Object>builder()
                .put("status", HttpStatus.OK.value())
                .put("data", response.getContent())
                .put("totalCount", response.getTotalElements())
                .put("totalPages", response.getTotalPages())
                .put("currentPage", response.getNumber())
                .put("currentPageSize", response.getSize())
                .build();
    }

    public static <T> Map<String, Object> single(T response) {
        return ImmutableMap.<String, Object>builder()
                .put("status", HttpStatus.OK.value())
                .put("data", response)
                .build();
    }

    public static Map<String, Object> noContent() {
        return NO_CONTENT;
    }

    public static Map<String, Object> notFound() {
        return NOT_FOUND;
    }
}
