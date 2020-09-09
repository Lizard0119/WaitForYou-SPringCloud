package com.qy.service;

import com.qy.pojo.BaseResp;

import java.io.IOException;

public interface SearchCompanyService {
    BaseResp search(String index) throws IOException;
}
