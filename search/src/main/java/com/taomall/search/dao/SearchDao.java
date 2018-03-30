package com.taomall.search.dao;

import com.taomall.search.entities.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;


public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
