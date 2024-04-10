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

import com.entity.ShetuanxinwenEntity;
import com.entity.view.ShetuanxinwenView;

import com.service.ShetuanxinwenService;
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
 * 社团新闻 
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
@RestController
@RequestMapping("/shetuanxinwen")
public class ShetuanxinwenController {
    @Autowired
    private ShetuanxinwenService shetuanxinwenService;


    @Autowired
    private StoreupService storeupService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShetuanxinwenEntity shetuanxinwen, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shetuan")) {
			shetuanxinwen.setShezhangzhanghao((String)request.getSession().getAttribute("username"));
		}
        else {
            if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
                shetuanxinwen.setUserid((Long)request.getSession().getAttribute("userId"));
            }
        }
        EntityWrapper<ShetuanxinwenEntity> ew = new EntityWrapper<ShetuanxinwenEntity>();


		PageUtils page = shetuanxinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanxinwen), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShetuanxinwenEntity shetuanxinwen, 
		HttpServletRequest request){
        EntityWrapper<ShetuanxinwenEntity> ew = new EntityWrapper<ShetuanxinwenEntity>();

		PageUtils page = shetuanxinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanxinwen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShetuanxinwenEntity shetuanxinwen){
       	EntityWrapper<ShetuanxinwenEntity> ew = new EntityWrapper<ShetuanxinwenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shetuanxinwen, "shetuanxinwen")); 
        return R.ok().put("data", shetuanxinwenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShetuanxinwenEntity shetuanxinwen){
        EntityWrapper< ShetuanxinwenEntity> ew = new EntityWrapper< ShetuanxinwenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shetuanxinwen, "shetuanxinwen")); 
		ShetuanxinwenView shetuanxinwenView =  shetuanxinwenService.selectView(ew);
		return R.ok("查询社团新闻成功").put("data", shetuanxinwenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShetuanxinwenEntity shetuanxinwen = shetuanxinwenService.selectById(id);
		shetuanxinwen.setClicknum(shetuanxinwen.getClicknum()+1);
		shetuanxinwenService.updateById(shetuanxinwen);
        return R.ok().put("data", shetuanxinwen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShetuanxinwenEntity shetuanxinwen = shetuanxinwenService.selectById(id);
		shetuanxinwen.setClicknum(shetuanxinwen.getClicknum()+1);
		shetuanxinwenService.updateById(shetuanxinwen);
        return R.ok().put("data", shetuanxinwen);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        ShetuanxinwenEntity shetuanxinwen = shetuanxinwenService.selectById(id);
        if(type.equals("1")) {
        	shetuanxinwen.setThumbsupnum(shetuanxinwen.getThumbsupnum()+1);
        } else {
        	shetuanxinwen.setCrazilynum(shetuanxinwen.getCrazilynum()+1);
        }
        shetuanxinwenService.updateById(shetuanxinwen);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShetuanxinwenEntity shetuanxinwen, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shetuanxinwen);
    	shetuanxinwen.setUserid((Long)request.getSession().getAttribute("userId"));

        shetuanxinwenService.insert(shetuanxinwen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShetuanxinwenEntity shetuanxinwen, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shetuanxinwen);

        shetuanxinwenService.insert(shetuanxinwen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShetuanxinwenEntity shetuanxinwen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shetuanxinwen);
        shetuanxinwenService.updateById(shetuanxinwen);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShetuanxinwenEntity> list = new ArrayList<ShetuanxinwenEntity>();
        for(Long id : ids) {
            ShetuanxinwenEntity shetuanxinwen = shetuanxinwenService.selectById(id);
            shetuanxinwen.setSfsh(sfsh);
            shetuanxinwen.setShhf(shhf);
            list.add(shetuanxinwen);
        }
        shetuanxinwenService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shetuanxinwenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
