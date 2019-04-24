package com.ycnet.dbank.dto.details;

import com.ycnet.dbank.dto.common.ProductDtoBase;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class ProductDetails extends ProductDtoBase{
	 
	/**保本：默认不保本*/
    private boolean breakevenState;

	public boolean isBreakevenState() {
		return breakevenState;
	}

	public void setBreakevenState(boolean breakevenState) {
		this.breakevenState = breakevenState;
	}
    
    
}
