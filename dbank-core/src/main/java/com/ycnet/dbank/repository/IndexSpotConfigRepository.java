package com.ycnet.dbank.repository;

import com.ycnet.dbank.domain.IndexSpotConfig;
import com.ycnet.dbank.domain.enums.SpotType;
import com.ycnet.mirage.repository.MirageRepository;

import java.util.List;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 13:17:09
  */
public interface IndexSpotConfigRepository extends MirageRepository<IndexSpotConfig> {

    List<IndexSpotConfig> findBySpotType(SpotType type);


}
