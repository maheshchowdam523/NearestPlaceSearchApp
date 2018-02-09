package com.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MapsMainData {
	private List<String> html_attributions = new ArrayList<>();
	private String next_page_token;
	private String status;
	private List<MapsResultData> results = new ArrayList<>();
	public List<String> getHtml_attributions() {
		return html_attributions;
	}
	public void setHtml_attributions(List<String> html_attributions) {
		this.html_attributions = html_attributions;
	}
	public String getNext_page_token() {
		return next_page_token;
	}
	public void setNext_page_token(String next_page_token) {
		this.next_page_token = next_page_token;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<MapsResultData> getResults() {
		return results;
	}
	public void setResults(List<MapsResultData> results) {
		this.results = results;
	}
}
