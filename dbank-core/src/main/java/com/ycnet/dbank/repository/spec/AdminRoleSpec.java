package com.ycnet.dbank.repository.spec;

import java.lang.reflect.InvocationTargetException;

import com.ycnet.dbank.domain.AdminRole;
import com.ycnet.dbank.dto.condition.AdminRoleCondition;
import com.ycnet.mirage.repository.spec.support.QueryWraper;

/**
 * @author shine
 *
 */
public class AdminRoleSpec extends BaseSpec<AdminRole, AdminRoleCondition> {

	public AdminRoleSpec(AdminRoleCondition condition) {
		super(condition);
	}

	@Override
	protected void addCondition(QueryWraper<AdminRole> queryWraper)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		addLikeCondition(queryWraper, "name");
	}

}
