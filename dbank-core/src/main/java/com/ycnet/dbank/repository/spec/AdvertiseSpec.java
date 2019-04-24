package com.ycnet.dbank.repository.spec;

import java.lang.reflect.InvocationTargetException;

import com.ycnet.dbank.domain.Advertise;
import com.ycnet.dbank.dto.condition.AdvertiseCondition;
import com.ycnet.mirage.repository.spec.support.QueryWraper;

public class AdvertiseSpec extends BaseSpec<Advertise, AdvertiseCondition> {

	
	public AdvertiseSpec(AdvertiseCondition condition) {
		super(condition);
	}

	@Override
	protected void addCondition(QueryWraper<Advertise> queryWraper)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		addEqualsCondition(queryWraper, "adId", "id");
		//addEqualsCondition(queryWraper, "adColumnId", "adColumn");
		addEqualsCondition(queryWraper, "status");
		addLikeCondition(queryWraper, "name");
	}

}
