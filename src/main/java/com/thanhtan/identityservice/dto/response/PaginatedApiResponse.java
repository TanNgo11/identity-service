package com.thanhtan.identityservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaginatedApiResponse<T> extends ApiResponse<List<T>> {
    long totalElements;
    int totalPages;
    int currentPage;
    int pageSize;

    @Builder(builderMethodName = "paginatedResponseBuilder")
    public PaginatedApiResponse(int code, String message, List<T> result,
                                long totalElements, int totalPages, int currentPage, int pageSize) {
        super(code, message, result);
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public static <T> PaginatedApiResponse<T> createFrom(Page<T> page, String message) {
        return PaginatedApiResponse.<T>paginatedResponseBuilder()
                .result(page.getContent())
                .message(message)
                .code(200)
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .currentPage(page.getNumber())
                .pageSize(page.getSize())
                .build();
    }
}