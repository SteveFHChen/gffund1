package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.condition.ItemCondition;
import com.ycnet.dbank.dto.create.ItemCreateForm;
import com.ycnet.dbank.dto.details.ItemDetails;
import com.ycnet.dbank.dto.update.ItemUpdateForm;
import com.ycnet.dbank.service.ItemService;
import com.ycnet.mirage.event.DomainCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/item")
public class ItemController extends BaseController {

	@Autowired
	private ItemService itemService;
	
	/**
	 * 创建Item
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(ItemCreateForm form){
		return itemService.create(form);
	}
	
	/**
	 * 更新Item
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public ItemDetails update(@PathVariable Long id,ItemUpdateForm form){
		return itemService.update(id,form);
	}
	/**
	 * 删除Item
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		itemService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ItemDetails getDetails(@PathVariable Long id){
		return itemService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<ItemDetails> query(ItemCondition condition,Pageable page){
		return itemService.query(condition,page);
	}
}
