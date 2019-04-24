package com.ycnet.dbank.repository.spec;

import com.ycnet.dbank.domain.Admin;
import com.ycnet.dbank.domain.enums.AdminState;
import com.ycnet.dbank.dto.condition.AdminCondition;
import com.ycnet.mirage.repository.spec.support.QueryWraper;
import com.ycnet.mirage.utils.MirageUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 内管用户specification构造条件
 * User: guozp
 * Date: 14-5-14
 * Time: 上午11:42
 */
public class AdminSpec extends BaseSpec<Admin, AdminCondition> {


    public AdminSpec(AdminCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWraper<Admin> queryWraper) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        addEqualsCondition(queryWraper, "code");

        addLikeCondition(queryWraper,"name");

        addEqualsCondition(queryWraper, "status", "state");

        String status = (String) MirageUtils.getValue(getCondition(), "status");
        if(StringUtils.isNotBlank(status)){
            addEqualsConditionToColumn(queryWraper, "state", AdminState.valueOf(status));
        }

        addEqualsCondition(queryWraper,"roleId","adminRole.id");

        addEqualsCondition(queryWraper,"branchId","branch.id");
    }
}
