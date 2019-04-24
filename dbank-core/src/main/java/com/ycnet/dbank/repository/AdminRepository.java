package com.ycnet.dbank.repository;

import com.ycnet.dbank.domain.Admin;
import com.ycnet.mirage.repository.MirageRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface AdminRepository extends MirageRepository<Admin>, UserDetailsService {

}
