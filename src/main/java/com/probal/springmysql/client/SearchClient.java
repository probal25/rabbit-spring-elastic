package com.probal.springmysql.client;

import com.probal.springmysql.dto.UserDto;
import com.probal.springmysql.searchRequest.UserSearchRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "searchClient", url = "${search.base.url}/documents")
public interface SearchClient {
    @PostMapping("/search_new")
    List<UserDto> getSearchResults(@RequestBody UserSearchRequestDTO requestDTO);
}
