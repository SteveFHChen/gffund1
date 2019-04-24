package com.ycnet.dbank.core.support;

import org.hibernate.internal.util.StringHelper;

import com.ycnet.mirage.config.MirageNamingStrategy;

/**
 * 定义属性转成表的策略
 * User: guozp
 * Date: 14-5-8
 * Time: 下午5:54
 */
public class DbankNamingStrategy extends MirageNamingStrategy {
	
	private static final long serialVersionUID = -76681590945209043L;
	
	private final static String COLUMN_PREFIX = "CGB_";

    public String propertyToColumnName(String propertyName) {
        return COLUMN_PREFIX + StringHelper.unqualify( propertyName ).toUpperCase();
    }

    public String columnName(String columnName) {
        return COLUMN_PREFIX + columnName.toUpperCase();
    }

    public String logicalColumnName(String columnName, String propertyName) {
        return ((StringHelper.isNotEmpty( columnName ) ? columnName : COLUMN_PREFIX + StringHelper.unqualify( propertyName )).toUpperCase());
    }

    public String logicalCollectionColumnName(String columnName, String propertyName, String referencedColumn) {
        return (StringHelper.isNotEmpty( columnName ) ?
                columnName :
                COLUMN_PREFIX + StringHelper.unqualify( propertyName ) + "_" + referencedColumn).toUpperCase();
    }

}
