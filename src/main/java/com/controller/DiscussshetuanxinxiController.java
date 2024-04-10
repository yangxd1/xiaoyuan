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

import com.entity.DiscussshetuanxinxiEntity;
import com.entity.view.DiscussshetuanxinxiView;

import com.service.DiscussshetuanxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 社团信息评论表 
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-11 19:02:23
 */
@RestController
@RequestMapping("/discussshetuanxinxi")
public class DiscussshetuanxinxiController {
    @Autowired
    private DiscussshetuanxinxiService discussshetuanxinxiService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussshetuanxinxiEntity discussshetuanxinxi, 
		HttpServletRequest request){

        EntityWrapper<DiscussshetuanxinxiEntity> ew = new EntityWrapper<DiscussshetuanxinxiEntity>();


		PageUtils page = discussshetuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshetuanxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussshetuanxinxiEntity discussshetuanxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussshetuanxinxiEntity> ew = new EntityWrapper<DiscussshetuanxinxiEntity>();

		PageUtils page = discussshetuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshetuanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussshetuanxinxiEntity discussshetuanxinxi){
       	EntityWrapper<DiscussshetuanxinxiEntity> ew = new EntityWrapper<DiscussshetuanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussshetuanxinxi, "discussshetuanxinxi")); 
        return R.ok().put("data", discussshetuanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussshetuanxinxiEntity discussshetuanxinxi){
        EntityWrapper< DiscussshetuanxinxiEntity> ew = new EntityWrapper< DiscussshetuanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussshetuanxinxi, "discussshetuanxinxi")); 
		DiscussshetuanxinxiView discussshetuanxinxiView =  discussshetuanxinxiService.selectView(ew);
		return R.ok("查询社团信息评论表成功").put("data", discussshetuanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussshetuanxinxiEntity discussshetuanxinxi = discussshetuanxinxiService.selectById(id);
        return R.ok().put("data", discussshetuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussshetuanxinxiEntity discussshetuanxinxi = discussshetuanxinxiService.selectById(id);
        return R.ok().put("data", discussshetuanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussshetuanxinxiEntity discussshetuanxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussshetuanxinxi);

        discussshetuanxinxiService.insert(discussshetuanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussshetuanxinxiEntity discussshetuanxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussshetuanxinxi);

        discussshetuanxinxiService.insert(discussshetuanxinxi);
        return R.ok();
    }


     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussshetuanxinxiEntity discussshetuanxinxi = discussshetuanxinxiService.selectOne(new EntityWrapper<DiscussshetuanxinxiEntity>().eq("", username));
        return R.ok().put("data", discussshetuanxinxi);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussshetuanxinxiEntity discussshetuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshetuanxinxi);
        discussshetuanxinxiService.updateById(discussshetuanxinxi);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussshetuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussshetuanxinxiEntity discussshetuanxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussshetuanxinxiEntity> ew = new EntityWrapper<DiscussshetuanxinxiEntity>();
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
		params.put("sort", "clicktime");
        
        params.put("order", "desc");
		PageUtils page = discussshetuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshetuanxinxi), params), params));
        return R.ok().put("data", page);
    }










}
