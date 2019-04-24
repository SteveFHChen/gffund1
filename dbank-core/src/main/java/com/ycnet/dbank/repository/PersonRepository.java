package com.ycnet.dbank.repository;

import com.ycnet.dbank.domain.Person;
import com.ycnet.mirage.repository.MirageRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface PersonRepository extends MirageRepository<Person>, UserDetailsService {

}
