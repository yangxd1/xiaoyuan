package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShetuanhuodongEntity;
import com.entity.view.ShetuanhuodongView;

import com.service.ShetuanhuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 社团活动 
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
@RestController
@RequestMapping("/shetuanhuodong")
public class ShetuanhuodongController {
    @Autowired
    private ShetuanhuodongService shetuanhuodongService;


    @Autowired
    private StoreupService storeupService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShetuanhuodongEntity shetuanhuodong, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shetuan")) {
			shetuanhuodong.setShezhangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShetuanhuodongEntity> ew = new EntityWrapper<ShetuanhuodongEntity>();


		PageUtils page = shetuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanhuodong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShetuanhuodongEntity shetuanhuodong, 
		HttpServletRequest request){
        EntityWrapper<ShetuanhuodongEntity> ew = new EntityWrapper<ShetuanhuodongEntity>();

		PageUtils page = shetuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanhuodong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShetuanhuodongEntity shetuanhuodong){
       	EntityWrapper<ShetuanhuodongEntity> ew = new EntityWrapper<ShetuanhuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shetuanhuodong, "shetuanhuodong")); 
        return R.ok().put("data", shetuanhuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShetuanhuodongEntity shetuanhuodong){
        EntityWrapper< ShetuanhuodongEntity> ew = new EntityWrapper< ShetuanhuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shetuanhuodong, "shetuanhuodong")); 
		ShetuanhuodongView shetuanhuodongView =  shetuanhuodongService.selectView(ew);
		return R.ok("查询社团活动成功").put("data", shetuanhuodongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShetuanhuodongEntity shetuanhuodong = shetuanhuodongService.selectById(id);
		shetuanhuodong.setClicknum(shetuanhuodong.getClicknum()+1);
		shetuanhuodong.setClicktime(new Date());
		shetuanhuodongService.updateById(shetuanhuodong);
        return R.ok().put("data", shetuanhuodong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShetuanhuodongEntity shetuanhuodong = shetuanhuodongService.selectById(id);
		shetuanhuodong.setClicknum(shetuanhuodong.getClicknum()+1);
		shetuanhuodong.setClicktime(new Date());
		shetuanhuodongService.updateById(shetuanhuodong);
        return R.ok().put("data", shetuanhuodong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShetuanhuodongEntity shetuanhuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shetuanhuodong);

        shetuanhuodongService.insert(shetuanhuodong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShetuanhuodongEntity shetuanhuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shetuanhuodong);

        shetuanhuodongService.insert(shetuanhuodong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShetuanhuodongEntity shetuanhuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shetuanhuodong);
        shetuanhuodongService.updateById(shetuanhuodong);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShetuanhuodongEntity> list = new ArrayList<ShetuanhuodongEntity>();
        for(Long id : ids) {
            ShetuanhuodongEntity shetuanhuodong = shetuanhuodongService.selectById(id);
            shetuanhuodong.setSfsh(sfsh);
            shetuanhuodong.setShhf(shhf);
            list.add(shetuanhuodong);
        }
        shetuanhuodongService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shetuanhuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ShetuanhuodongEntity shetuanhuodong, HttpServletRequest request,String pre){
        EntityWrapper<ShetuanhuodongEntity> ew = new EntityWrapper<ShetuanhuodongEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = shetuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanhuodong), params), params));
        return R.ok().put("data", page);
    }










}
