package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuichushetuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TuichushetuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TuichushetuanView;


/**
 * 退出社团
 *
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
public interface TuichushetuanService extends IService<TuichushetuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuichushetuanVO> selectListVO(Wrapper<TuichushetuanEntity> wrapper);
   	
   	TuichushetuanVO selectVO(@Param("ew") Wrapper<TuichushetuanEntity> wrapper);
   	
   	List<TuichushetuanView> selectListView(Wrapper<TuichushetuanEntity> wrapper);
   	
   	TuichushetuanView selectView(@Param("ew") Wrapper<TuichushetuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuichushetuanEntity> wrapper);
   	

}

