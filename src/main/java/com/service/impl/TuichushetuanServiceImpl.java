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


import com.dao.TuichushetuanDao;
import com.entity.TuichushetuanEntity;
import com.service.TuichushetuanService;
import com.entity.vo.TuichushetuanVO;
import com.entity.view.TuichushetuanView;

@Service("tuichushetuanService")
public class TuichushetuanServiceImpl extends ServiceImpl<TuichushetuanDao, TuichushetuanEntity> implements TuichushetuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuichushetuanEntity> page = this.selectPage(
                new Query<TuichushetuanEntity>(params).getPage(),
                new EntityWrapper<TuichushetuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuichushetuanEntity> wrapper) {
		  Page<TuichushetuanView> page =new Query<TuichushetuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TuichushetuanVO> selectListVO(Wrapper<TuichushetuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TuichushetuanVO selectVO(Wrapper<TuichushetuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TuichushetuanView> selectListView(Wrapper<TuichushetuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuichushetuanView selectView(Wrapper<TuichushetuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
