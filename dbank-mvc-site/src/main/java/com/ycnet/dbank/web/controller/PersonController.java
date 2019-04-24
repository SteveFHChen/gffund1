package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.domain.Person;
import com.ycnet.dbank.dto.condition.PersonCondition;
import com.ycnet.dbank.dto.create.PersonCreateForm;
import com.ycnet.dbank.dto.details.PersonDetails;
import com.ycnet.dbank.dto.update.PersonUpdateForm;
import com.ycnet.dbank.service.PersonService;
import com.ycnet.dbank.web.security.SecurityContextUtil;
import com.ycnet.mirage.event.DomainCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/person")
public class PersonController extends BaseController {

	@Autowired
	private PersonService personService;
	
	/**
	 * 创建Person
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(PersonCreateForm form){
		return personService.create(form);
	}
	
	/**
	 * 更新Person
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public PersonDetails update(@PathVariable Long id,PersonUpdateForm form){
		return personService.update(id,form);
	}
	/**
	 * 删除Person
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		personService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public PersonDetails getDetails(@PathVariable Long id){
		return personService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<PersonDetails> query(PersonCondition condition,Pageable page){
		return personService.query(condition,page);
	}

    /**
     * 获取当前登录用户信息
     * @return
     */
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public Map<String, Object> getCurrentUserInfo() {

        Person person = (Person) SecurityContextUtil.getCurrentUser();

        Map<String, Object> result = new HashMap<String, Object>();

        if (person != null) {
            result.put("username", person.getUsername());
        }

        return result;
    }
    
    @RequestMapping(value = "/modPassword/{id}",method =RequestMethod.GET)
    public String modPassword(@PathVariable Long id,PersonUpdateForm form){
    	return personService.modPassword(id, form);
    }
}
