package org.jogen.demo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 类型描述：<br/>
 * 数据访问层工具
 * @author Jogen
 * 
 */
public final class DaoHandler {

	/**
	 * 方法描述：<br/>
	 * 获取偏移值
	 * @param page
	 *            请求页码，从1开始
	 * @param size
	 *            每页的大小
	 * @return
	 */
	public static int getOffset(int page, int size) {
		if (page <= 1) {
			return 0;
		}
		return (page - 1) * size;
	}

	/**
	 * 方法描述：<br/>
	 * 获取UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 方法描述：<br/>
	 * 构建参数
	 *
	 * @return
	 */
	public static DaoParam param() {
		return new DaoParam();
	}

	/**
	 * 方法描述：<br/>
	 * 构建全查<br/> mybatis中select_mark=all
	 *
	 * @return
	 */
	public static DaoParam selectAll() {
		return new DaoParam().param("select_mark", "all");
	}

	/**
	 * 方法描述：<br/>
	 * 构建部分查询
	 * @param partMark 部分的标识
	 * @return
	 */
	public static DaoParam selectPart(String partMark) {
		return new DaoParam().param("select_mark", partMark);
	}

	/**
	 * 方法描述：<br/>
	 * 构建参数
	 * @param conditions 条件集合
	 * @return
	 */
	public static DaoParam params(Map<String, Object> conditions) {
		return new DaoParam().params(conditions);
	}

	/**
	 * 方法描述：<br/>
	 * 构建参数
	 * @param paramName 参数名
	 * @param paramValue 参数值
	 * @return
	 */
	public static DaoParam param(String paramName, Object paramValue) {
		return new DaoParam().param(paramName, paramValue);
	}

	/**
	 * 方法描述：<br/>
	 * 构建参数
	 * @param paramName
	 *            参数名
	 * @param paramValue
	 *            参数值
	 * @return
	 */
	public static DaoParam param(String paramName, Object[] paramValue) {
		return new DaoParam().param(paramName, paramValue);
	}

	/**
	 * 方法描述：<br/>
	 * @param paramName
	 *            参数名
	 * @param paramValue
	 *            参数值
	 * @return
	 */
	public static DaoParam param(String paramName, Collection<?> paramValue) {
		return new DaoParam().param(paramName, paramValue);
	}

	/**
	 * 方法描述：<br/>
	 * 构建参数
	 * @param paramName
	 *            参数名
	 * @param paramValue
	 *            参数值
	 * @return
	 */
	public static DaoParam maxParam(String paramName, Number paramValue) {
		return new DaoParam().maxParam(paramName, paramValue);
	}

	/**
	 * 方法描述：<br/>
	 * 构建参数
	 * @param paramName
	 *            参数名
	 * @param paramValue
	 *            参数值
	 * @return
	 */
	public static DaoParam minParam(String paramName, Number paramValue) {
		return new DaoParam().minParam(paramName, paramValue);
	}

	/**
	 * 方法描述：<br/>
	 * 构建参数
	 * @param paramName
	 *            参数名
	 * @param paramValue
	 *            参数值
	 * @return
	 */
	public static DaoParam likeParam(String paramName, String paramValue) {
		return new DaoParam().likeParam(paramName, paramValue);
	}

	/**
	 * 方法描述：<br/>
	 * 构建参数，唯一值
	 * @param paramName
	 * @return
	 */
	public static DaoParam distinctParam(String paramName) {
		return new DaoParam().distinctParam(paramName);
	}

	/**
	 * 方法描述：<br/>
	 * 构建参数，非空值
	 * @param paramName
	 * @return
	 */
	public static DaoParam notNullParam(String paramName) {
		return new DaoParam().notNull(paramName);
	}

	/**
	 * 方法描述：<br/>
	 * 构建参数，必为空值
	 * @param paramName
	 * @return
	 */
	public static DaoParam mustNullParam(String paramName) {
		return new DaoParam().mustNull(paramName);
	}

	/**
	 * 类描述：<br/>
	 * 数据访问层入参
	 */
	public static class DaoParam extends HashMap<String, Object> {

		private static final long serialVersionUID = -3175699183872304801L;
		// 默认限制值
		public static final Integer DEFAULT_LIMIT = 20;
		// 限制值
		public static final String LIMIT_NAME = "limit";
		// 偏移值
		public static final String OFFSET_NAME = "offset";
		// 相似符
		public static final String PERCENT_NAME = "%";
		// 最大值
		public static final String MAX_THEN_NAME = "max_";
		// 最小值
		public static final String MIN_THEN_NAME = "min_";
		// 唯一值
		public static final String DISTINCT_NAME = "distinct_";
		// 不为空
		public static final String NOT_NULL_NAME = "not_null_";
		// 必须为空
		public static final String MUST_NULL_NAME = "must_null_";

		private Integer requestPageSize = DEFAULT_LIMIT;

		private DaoParam() {
		}

		/**
		 * 方法描述：<br/>
		 * @param paramName
		 *            参数名
		 * @param paramValue
		 *            参数值
		 * @return
		 */
		public DaoParam param(String paramName, Object paramValue) {
			if (paramName != null && paramValue != null) {
				this.put(paramName, paramValue);
			}
			return this;
		}

		/**
		 * 方法描述：<br/>
		 * 配参
		 * @param params
		 *            参数键值对
		 * @return
		 */
		public DaoParam params(Map<String, Object> params) {
			if (params != null && params.size() != 0) {
				this.putAll(params);
			}
			return this;
		}

		/**
		 * 方法描述：<br/>
		 * 相似配参
		 * @param paramName
		 * @param paramValue
		 * @return
		 */
		public DaoParam likeParam(String paramName, String paramValue) {
			if (paramName != null && paramValue != null) {
				paramValue = PERCENT_NAME.concat(paramValue).concat(PERCENT_NAME);
				return this.param(paramName, paramValue);
			}
			return this;
		}

		/**
		 * 方法描述：<br/>
		 * 大于配参，会在paramName前面加多一个max_，需要在mybatis的语句中加上
		 *
		 * @param paramName
		 *            参数名
		 * @param paramValue
		 *            参数值
		 * @return
		 */
		public DaoParam maxParam(String paramName, Number paramValue) {
			if (paramName != null && paramValue != null) {
				return this.param(MAX_THEN_NAME + paramName, paramValue);
			}
			return this;
		}

		/**
		 * 方法描述：<br/>
		 * 小于配参，会在paramName前面加多一个min_，需要在mybatis的语句中加上
		 *
		 * @param paramName
		 * @param paramValue
		 * @return
		 */
		public DaoParam minParam(String paramName, Number paramValue) {
			if (paramName != null && paramValue != null) {
				return this.param(MIN_THEN_NAME + paramName, paramValue);
			}
			return this;
		}

		/**
		 * 方法描述：<br/>
		 * 唯一值配置，会在paramName前面加多一个distinct_，需要在mybatis的语句中加上，表示唯一这个参数
		 *
		 * @param paramName
		 * @return
		 */
		public DaoParam distinctParam(String paramName) {
			if (paramName != null) {
				return this.param(DISTINCT_NAME + paramName, Boolean.TRUE);
			}
			return this;
		}

		/**
		 * 方法描述：<br/>
		 * 不为空值配置，会在paramName前面加多一个not_null_，需要在mybatis的语句中加上，表示这个参数非空
		 *
		 * @param paramName
		 * @return
		 */
		public DaoParam notNull(String paramName) {
			if (paramName != null) {
				return this.param(NOT_NULL_NAME + paramName, Boolean.TRUE);
			}
			return this;
		}

		/**
		 * 方法描述：<br/>
		 * 必为空值配置，会在paramName前面加多一个must_null_，需要在mybatis的语句中加上，表示这个参数非空
		 *
		 * @param paramName
		 * @return
		 */
		public DaoParam mustNull(String paramName) {
			if (paramName != null) {
				return this.param(MUST_NULL_NAME + paramName, Boolean.TRUE);
			}
			return this;
		}

		/**
		 * 方法描述：<br/>
		 * 配置请求页码，请求的条数。偏移值为offset，限制值为limit。mybatis的语句为limit #{offset},#{limit}
		 * @param requestPage
		 *            请求的页码，为null的时候，从1开始
		 * @param pageSize
		 *            请求的页大小，为null的时候，取默认值
		 * @return
		 */
		public DaoParam requestPage(Integer requestPage, Integer pageSize) {
			if (pageSize != null && pageSize > 0) {
				this.requestPageSize = pageSize;
			}
			if (requestPage == null || requestPage < 1) {
				requestPage = 1;
			}
			this.put(LIMIT_NAME, this.requestPageSize);
			this.put(OFFSET_NAME, this.requestPageSize * (requestPage - 1));
			return this;
		}

	}

}
