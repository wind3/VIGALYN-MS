package com.vigalyn.ms.www.common.excel.handler;

import java.util.List;

import org.wuwz.poi.hanlder.ReadHandler;

public class UserInfoHandler  implements ReadHandler{

	@Override
	public void handler(int sheetIndex, int rowIndex, List<String> row) {
		try {
			// 排除表头
			if(rowIndex == 0) return;
			
			// 验证行数据
			if(!validRow(row)) {
				// TODO: 行数据rowIndex验证失败，记录
				
			} else {
				// 解析行数据
				
				// 方案1：记录行数据，读取完成后批量入库
		//		exportData.add(analysisRow(row));
				
				// 方案2：单行直接入库
				// xxx.save(analysisRow(row));
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			// 读取行：rowIndex发生异常，记录
		}
	}

	private Object analysisRow(List<String> row) {
		// TODO 解析行数据为对象
		return null;
	}

	private boolean validRow(List<String> row) {
		// TODO 验证行数据
		return true;
	}

}
