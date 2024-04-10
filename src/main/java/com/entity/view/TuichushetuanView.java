package com.entity.view;

import com.entity.TuichushetuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 退出社团
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
@TableName("tuichushetuan")
public class TuichushetuanView  extends TuichushetuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TuichushetuanView(){
	}
 
 	public TuichushetuanView(TuichushetuanEntity tuichushetuanEntity){
 	try {
			BeanUtils.copyProperties(this, tuichushetuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
