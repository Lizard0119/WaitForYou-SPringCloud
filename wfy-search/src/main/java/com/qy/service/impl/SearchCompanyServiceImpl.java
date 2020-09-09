package com.qy.service.impl;

import com.qy.pojo.BaseResp;
import com.qy.pojo.Company;
import com.qy.pojo.City;
import com.qy.pojo.Province;
import com.qy.service.SearchCompanyService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchCompanyServiceImpl implements SearchCompanyService {

    @Autowired
    RestHighLevelClient client;

    @Override
    public BaseResp search(String index) throws IOException {
        SearchRequest searchRequest = new SearchRequest("wfy-province2city2company");
        searchRequest.types("doc");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(index, "companyname", "companyshortname").field("companyshortname", 5));

        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest);

        SearchHits hits = search.getHits();

        SearchHit[] hits1 = hits.getHits();

        List list = new ArrayList();
        for (SearchHit his : hits1
        ) {
            Company company = new Company();
            Province province = new Province();
            City city = new City();
            Map<String, Object> sourceAsMap = his.getSourceAsMap();

            company.setCompany_name((String) sourceAsMap.get("companyname"));
            company.setCompany_shortname((String) sourceAsMap.get("companyshortname"));
            //公司规模（默认0）0不限/1（0-20）/2（20-99）/3（100-499）/4（500-999）/5（1000-9999）/6（10000+）
            company.setCompany_scale((Integer) sourceAsMap.get("companyscale"));
            //融资阶段（默认0）0不限/1未融资/2天使轮/3A轮/4B轮/5C轮/6D轮及以上/7已上市/8不需要融资
            company.setCompany_financing((Integer) sourceAsMap.get("companyfinancing"));
            province.setProvince_name((String) sourceAsMap.get("province"));
            city.setCity_name((String) sourceAsMap.get("city"));

            list.add(company);
            list.add(province);
            list.add(city);

        }

        BaseResp baseResp = new BaseResp();

        baseResp.setList(list);
        baseResp.setTotal(hits.getTotalHits());
        baseResp.setMessage("查询成功");
        baseResp.setCode(200);

        return baseResp;
    }
}
