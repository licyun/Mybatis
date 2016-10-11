package com.licyun.util;

import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = 5599632798780L;

	private int showCount = 3;//每一页要展示的的数据条数
	private int currentResult;//从第currentResult条开始
	
	public int getShowCount() {
		return showCount;
	}
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
	public int getCurrentResult() {
		return currentResult;
	}
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
}
