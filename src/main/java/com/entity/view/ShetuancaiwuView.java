package com.entity.view;

import com.entity.ShetuancaiwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 社团财务
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
@TableName("shetuancaiwu")
public class ShetuancaiwuView  extends ShetuancaiwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShetuancaiwuView(){
	}
 
 	public ShetuancaiwuView(ShetuancaiwuEntity shetuancaiwuEntity){
 	try {
			BeanUtils.copyProperties(this, shetuancaiwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
