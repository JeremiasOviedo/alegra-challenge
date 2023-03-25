package com.joviedo.msvc.warehouse.service;

import jakarta.servlet.http.HttpServletRequest;

public interface UtilService {
    String makePaginationLink(HttpServletRequest request, int page);
}
