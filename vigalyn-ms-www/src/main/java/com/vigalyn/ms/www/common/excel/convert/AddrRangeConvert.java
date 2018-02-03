package com.vigalyn.ms.www.common.excel.convert;

import org.wuwz.poi.convert.ExportRange;

public class AddrRangeConvert implements ExportRange {

	private static String[] addr ;
	static {
		addr = new String[] {"深圳市南山区","广州市白云区"};
	}
	@Override
	public String[] handler() {
		return addr;
	}

}
