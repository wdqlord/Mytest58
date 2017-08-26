package com.itheima.solrtest;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestInput {

	@Test
	public void test() throws Exception {
		String baseURL = "http://localhost:8180/solr";
		HttpSolrServer httpSolrServer = new HttpSolrServer(baseURL);

		// 2. 创建SolrInputDocument对象
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "c1001");
		document.addField("content", "Hello world!");

		// 3. 把SolrInputDocument对象添加到索引库中
		httpSolrServer.add(document);
		// httpSolrServer.deleteByQuery("*:*");

		// 4. 提交
		httpSolrServer.commit();

	}

	@Test
	public void testSearchIndex1() throws Exception {
		String baseURL = "http://localhost:8180/solr";
		HttpSolrServer httpSolrServer = new HttpSolrServer(baseURL);
		
		//创建查询对象
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery("product_name:台灯");
		//执行查询
		QueryResponse response = httpSolrServer.query(query);
		//获得查询的结果集
		SolrDocumentList solrDocumentList = response.getResults();
		System.err.println(solrDocumentList.getNumFound());
		
		/*
		 * // 创建搜索对象 SolrQuery query = new SolrQuery(); // 设置搜索条件
		 * query.setQuery("*:*");
		 * 
		 * // 发起搜索请求 QueryResponse response = httpSolrServer.query(query); //
		 * 处理搜索结果 SolrDocumentList results = response.getResults();
		 * 
		 * System.out.println("搜索到的结果总数：" + results.getNumFound());
		 * 
		 * // 遍历搜索结果 for (SolrDocument solrDocument : results) {
		 * 
		 * System.out.println(
		 * "----------------------------------------------------");
		 * 
		 * System.out.println("id：" + solrDocument.get("id"));
		 * System.out.println("content" + solrDocument.get("content")); }
		 */
	}
}
