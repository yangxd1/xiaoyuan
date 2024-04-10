package com.dao;

import com.entity.TuichushetuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TuichushetuanVO;
import com.entity.view.TuichushetuanView;


/**
 * 退出社团
 * 
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
public interface TuichushetuanDao extends BaseMapper<TuichushetuanEntity> {
	
	List<TuichushetuanVO> selectListVO(@Param("ew") Wrapper<TuichushetuanEntity> wrapper);
	
	TuichushetuanVO selectVO(@Param("ew") Wrapper<TuichushetuanEntity> wrapper);
	
	List<TuichushetuanView> selectListView(@Param("ew") Wrapper<TuichushetuanEntity> wrapper);

	List<TuichushetuanView> selectListView(Pagination page,@Param("ew") Wrapper<TuichushetuanEntity> wrapper);
	
	TuichushetuanView selectView(@Param("ew") Wrapper<TuichushetuanEntity> wrapper);
	

}
