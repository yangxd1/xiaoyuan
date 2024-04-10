package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShetuancaiwuDao;
import com.entity.ShetuancaiwuEntity;
import com.service.ShetuancaiwuService;
import com.entity.vo.ShetuancaiwuVO;
import com.entity.view.ShetuancaiwuView;

@Service("shetuancaiwuService")
public class ShetuancaiwuServiceImpl extends ServiceImpl<ShetuancaiwuDao, ShetuancaiwuEntity> implements ShetuancaiwuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShetuancaiwuEntity> page = this.selectPage(
                new Query<ShetuancaiwuEntity>(params).getPage(),
                new EntityWrapper<ShetuancaiwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShetuancaiwuEntity> wrapper) {
		  Page<ShetuancaiwuView> page =new Query<ShetuancaiwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShetuancaiwuVO> selectListVO(Wrapper<ShetuancaiwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShetuancaiwuVO selectVO(Wrapper<ShetuancaiwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShetuancaiwuView> selectListView(Wrapper<ShetuancaiwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShetuancaiwuView selectView(Wrapper<ShetuancaiwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
