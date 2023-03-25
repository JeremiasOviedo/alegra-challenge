package com.joviedo.msvc.warehouse.service.impl;

import com.joviedo.msvc.warehouse.service.UtilService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {
    @Override
    public String makePaginationLink(HttpServletRequest request, int page) {
        return String.format("%s?page=%d", request.getRequestURI(), page);
    }
}
