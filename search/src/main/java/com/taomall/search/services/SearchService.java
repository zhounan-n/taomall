package com.taomall.search.services;


import com.taomall.search.entities.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page, int rows) throws Exception;
}
