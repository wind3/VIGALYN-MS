package com.vigalyn.ms.www.common.excel.convert;

import java.util.HashMap;
import java.util.Map;

import org.wuwz.poi.convert.ExportConvert;

/**
 * 类别转换器
 * 将类别代码转换为类别名称
 * @author zengwj
 */
public class CategoryConvert implements ExportConvert {

	private static Map<Integer , String > category ;
	static {
		category = new HashMap<>();
		category.put(1, "公司新闻");
		category.put(2, "公司广告");
		category.put(3, "公司制度");
	}
	@Override
	public String handler(Integer val) {
		
		return val != null ? (category.get(val) !=null ?  category.get(val) :"没有记录") : "没有参数";
	}

}
