package com.ycnet.dbank.dto.condition;

import com.ycnet.dbank.domain.enums.SpotType;

/**
  * 首页配置信息条件DTO
  * @author guozp  
  * Date: 2014/04/22 13:17:09
  */
public class IndexSpotConfigCondition {

    /**区域类型*/
    private SpotType spotType;

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }
}
