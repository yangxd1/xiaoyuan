package com.dao;

import com.entity.ShetuancaiwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShetuancaiwuVO;
import com.entity.view.ShetuancaiwuView;


/**
 * 社团财务
 * 
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
public interface ShetuancaiwuDao extends BaseMapper<ShetuancaiwuEntity> {
	
	List<ShetuancaiwuVO> selectListVO(@Param("ew") Wrapper<ShetuancaiwuEntity> wrapper);
	
	ShetuancaiwuVO selectVO(@Param("ew") Wrapper<ShetuancaiwuEntity> wrapper);
	
	List<ShetuancaiwuView> selectListView(@Param("ew") Wrapper<ShetuancaiwuEntity> wrapper);

	List<ShetuancaiwuView> selectListView(Pagination page,@Param("ew") Wrapper<ShetuancaiwuEntity> wrapper);
	
	ShetuancaiwuView selectView(@Param("ew") Wrapper<ShetuancaiwuEntity> wrapper);
	

}
