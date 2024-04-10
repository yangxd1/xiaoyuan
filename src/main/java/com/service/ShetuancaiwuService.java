package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShetuancaiwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShetuancaiwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShetuancaiwuView;


/**
 * 社团财务
 *
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
public interface ShetuancaiwuService extends IService<ShetuancaiwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShetuancaiwuVO> selectListVO(Wrapper<ShetuancaiwuEntity> wrapper);
   	
   	ShetuancaiwuVO selectVO(@Param("ew") Wrapper<ShetuancaiwuEntity> wrapper);
   	
   	List<ShetuancaiwuView> selectListView(Wrapper<ShetuancaiwuEntity> wrapper);
   	
   	ShetuancaiwuView selectView(@Param("ew") Wrapper<ShetuancaiwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShetuancaiwuEntity> wrapper);
   	

}

