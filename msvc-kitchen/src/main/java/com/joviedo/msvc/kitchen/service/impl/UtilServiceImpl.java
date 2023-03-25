package com.joviedo.msvc.kitchen.service.impl;

import com.joviedo.msvc.kitchen.service.UtilService;
import jakarta.servlet.http.HttpServletRequest;

public class UtilServiceImpl implements UtilService {
    @Override
    public String makePaginationLink(HttpServletRequest request, int page) {
        return String.format("%s?page=%d", request.getRequestURI(), page);
    }
}
