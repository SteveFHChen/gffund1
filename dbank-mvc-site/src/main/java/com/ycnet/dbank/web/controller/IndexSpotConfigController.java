package com.ycnet.dbank.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.dbank.dto.condition.IndexSpotConfigCondition;
import com.ycnet.dbank.dto.details.IndexSpotConfigDetails;
import com.ycnet.dbank.service.IndexSpotConfigService;

/**
  * 首页配置
  * @author guozp  
  * Date: 2014/04/22 13:17:09
  */
@RestController
@RequestMapping("/index")
public class IndexSpotConfigController extends BaseController {

	@Autowired
	private IndexSpotConfigService indexSpotConfigService;

    /**
     * 首页配置列表查询：广告区、热点理财产品区、最新上市产品区
     * @param condition
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<IndexSpotConfigDetails> query(IndexSpotConfigCondition condition){
        return indexSpotConfigService.query(condition);
    }
}
