package com.ycnet.dbank.repository.spec;

import java.lang.reflect.InvocationTargetException;

import com.ycnet.dbank.domain.Notice;
import com.ycnet.dbank.dto.condition.NoticeCondition;
import com.ycnet.mirage.repository.spec.support.QueryWraper;

/**
 * User: guozp
 * Date: 14-5-5
 * Time: 上午12:36
 */
public class NoticeSpec extends BaseSpec<Notice, NoticeCondition> {
    /**
     * @param condition 查询条件
     */
    public NoticeSpec(NoticeCondition condition) {
    	super(condition);
    }

    @Override
    protected void addCondition(QueryWraper<Notice> queryWraper) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        addEqualsCondition(queryWraper,"channelType");
    }
}
