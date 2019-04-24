package com.ycnet.dbank.dto.condition;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class PaperCondition {

	/**试卷名称**/
	String name ;
	
	public PaperCondition()
	{
		
	}
	
	public PaperCondition(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
