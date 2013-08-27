/**
 * 
 */
package com.daojia.common.constant;

/**
 * 是或否枚举
 * 
 * @author zhaolei 2013年8月22日 上午1:29:44
 * 
 */
public enum TrueOrFalse {

	TRUE("是", 1),

	FALSE("否", 0);

	private String name;

	private int index;

	TrueOrFalse(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public static String getName(int index) {
		for (TrueOrFalse trueOrFalse : TrueOrFalse.values()) {
			if (trueOrFalse.getIndex() == index) {
				return trueOrFalse.name;
			}
		}
		return null;
	}

	public static Integer getIndex(String name) {
		for (TrueOrFalse trueOrFalse : TrueOrFalse.values()) {
			if (trueOrFalse.getName().equals(name)) {
				return trueOrFalse.index;
			}
		}
		return null;
	}

	public static TrueOrFalse getTrueOrFalse(int index) {
		for (TrueOrFalse trueOrFalse : TrueOrFalse.values()) {
			if (trueOrFalse.getIndex() == index) {
				return trueOrFalse;
			}
		}
		return null;
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}

}
