package com.dao;

import com.entity.ShetuanxinwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShetuanxinwenVO;
import com.entity.view.ShetuanxinwenView;


/**
 * 社团新闻
 * 
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
public interface ShetuanxinwenDao extends BaseMapper<ShetuanxinwenEntity> {
	
	List<ShetuanxinwenVO> selectListVO(@Param("ew") Wrapper<ShetuanxinwenEntity> wrapper);
	
	ShetuanxinwenVO selectVO(@Param("ew") Wrapper<ShetuanxinwenEntity> wrapper);
	
	List<ShetuanxinwenView> selectListView(@Param("ew") Wrapper<ShetuanxinwenEntity> wrapper);

	List<ShetuanxinwenView> selectListView(Pagination page,@Param("ew") Wrapper<ShetuanxinwenEntity> wrapper);
	
	ShetuanxinwenView selectView(@Param("ew") Wrapper<ShetuanxinwenEntity> wrapper);
	

}
