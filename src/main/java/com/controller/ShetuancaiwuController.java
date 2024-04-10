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

import com.entity.ShetuancaiwuEntity;
import com.entity.view.ShetuancaiwuView;

import com.service.ShetuancaiwuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 社团财务 
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
@RestController
@RequestMapping("/shetuancaiwu")
public class ShetuancaiwuController {
    @Autowired
    private ShetuancaiwuService shetuancaiwuService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShetuancaiwuEntity shetuancaiwu, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shetuan")) {
			shetuancaiwu.setShezhangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShetuancaiwuEntity> ew = new EntityWrapper<ShetuancaiwuEntity>();


		PageUtils page = shetuancaiwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuancaiwu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShetuancaiwuEntity shetuancaiwu, 
		HttpServletRequest request){
        EntityWrapper<ShetuancaiwuEntity> ew = new EntityWrapper<ShetuancaiwuEntity>();

		PageUtils page = shetuancaiwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuancaiwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShetuancaiwuEntity shetuancaiwu){
       	EntityWrapper<ShetuancaiwuEntity> ew = new EntityWrapper<ShetuancaiwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shetuancaiwu, "shetuancaiwu")); 
        return R.ok().put("data", shetuancaiwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShetuancaiwuEntity shetuancaiwu){
        EntityWrapper< ShetuancaiwuEntity> ew = new EntityWrapper< ShetuancaiwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shetuancaiwu, "shetuancaiwu")); 
		ShetuancaiwuView shetuancaiwuView =  shetuancaiwuService.selectView(ew);
		return R.ok("查询社团财务成功").put("data", shetuancaiwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShetuancaiwuEntity shetuancaiwu = shetuancaiwuService.selectById(id);
        return R.ok().put("data", shetuancaiwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShetuancaiwuEntity shetuancaiwu = shetuancaiwuService.selectById(id);
        return R.ok().put("data", shetuancaiwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShetuancaiwuEntity shetuancaiwu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shetuancaiwu);

        shetuancaiwuService.insert(shetuancaiwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShetuancaiwuEntity shetuancaiwu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shetuancaiwu);

        shetuancaiwuService.insert(shetuancaiwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShetuancaiwuEntity shetuancaiwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shetuancaiwu);
        shetuancaiwuService.updateById(shetuancaiwu);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shetuancaiwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
