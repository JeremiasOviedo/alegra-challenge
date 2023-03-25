package com.joviedo.msvc.kitchen.service;

import jakarta.servlet.http.HttpServletRequest;

public interface UtilService {

    String makePaginationLink(HttpServletRequest request, int page);
}
