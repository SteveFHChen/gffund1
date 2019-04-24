package com.ycnet.dbank.repository.spec;

import java.lang.reflect.InvocationTargetException;

import com.ycnet.dbank.domain.AdvertiseColumn;
import com.ycnet.dbank.dto.condition.AdvertiseColumnCondition;
import com.ycnet.mirage.repository.spec.support.QueryWraper;

/**
 * User: zhanghuan
 * Date: 14-5-12
 * Time: 上午12:36
 */
public class AdvertiseColumnSpec extends BaseSpec<AdvertiseColumn, AdvertiseColumnCondition> {
    
	private boolean isAll;

	/**
     * @param condition 查询条件
     */
    public AdvertiseColumnSpec(AdvertiseColumnCondition condition) {
    	super(condition);
    	if( null == condition.getState())
    	{
    		isAll = true;
    	}
    }

    @Override
    protected void addCondition(QueryWraper<AdvertiseColumn> queryWraper) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    	addEqualsCondition(queryWraper, "id");
        addLikeCondition(queryWraper, "name");
        if(!isAll)
        {
        	addEqualsCondition(queryWraper, "state");
        }
    }
    
}
