package com.ycnet.dbank.repository.spec;

import java.lang.reflect.InvocationTargetException;

import com.ycnet.dbank.domain.Paper;
import com.ycnet.dbank.dto.condition.PaperCondition;
import com.ycnet.mirage.repository.spec.support.QueryWraper;

/**
 * User: zhanghuan
 * Date: 14-5-14
 * Time: 上午12:36
 */
public class PaperSpec extends BaseSpec<Paper, PaperCondition> {
    

	/**
     * @param condition 查询条件
     */
    public PaperSpec(PaperCondition condition) {
    	super(condition);
    }

    @Override
    protected void addCondition(QueryWraper<Paper> queryWraper) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        addLikeCondition(queryWraper, "name");
    }
    
}
