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

import com.entity.ShetuanjiaruEntity;
import com.entity.view.ShetuanjiaruView;

import com.service.ShetuanjiaruService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 社团加入 
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
@RestController
@RequestMapping("/shetuanjiaru")
public class ShetuanjiaruController {
    @Autowired
    private ShetuanjiaruService shetuanjiaruService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShetuanjiaruEntity shetuanjiaru, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shetuan")) {
			shetuanjiaru.setShezhangzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			shetuanjiaru.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShetuanjiaruEntity> ew = new EntityWrapper<ShetuanjiaruEntity>();


		PageUtils page = shetuanjiaruService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanjiaru), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShetuanjiaruEntity shetuanjiaru, 
		HttpServletRequest request){
        EntityWrapper<ShetuanjiaruEntity> ew = new EntityWrapper<ShetuanjiaruEntity>();

		PageUtils page = shetuanjiaruService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanjiaru), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShetuanjiaruEntity shetuanjiaru){
       	EntityWrapper<ShetuanjiaruEntity> ew = new EntityWrapper<ShetuanjiaruEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shetuanjiaru, "shetuanjiaru")); 
        return R.ok().put("data", shetuanjiaruService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShetuanjiaruEntity shetuanjiaru){
        EntityWrapper< ShetuanjiaruEntity> ew = new EntityWrapper< ShetuanjiaruEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shetuanjiaru, "shetuanjiaru")); 
		ShetuanjiaruView shetuanjiaruView =  shetuanjiaruService.selectView(ew);
		return R.ok("查询社团加入成功").put("data", shetuanjiaruView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShetuanjiaruEntity shetuanjiaru = shetuanjiaruService.selectById(id);
        return R.ok().put("data", shetuanjiaru);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShetuanjiaruEntity shetuanjiaru = shetuanjiaruService.selectById(id);
        return R.ok().put("data", shetuanjiaru);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShetuanjiaruEntity shetuanjiaru, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shetuanjiaru);

        shetuanjiaruService.insert(shetuanjiaru);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShetuanjiaruEntity shetuanjiaru, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shetuanjiaru);

        shetuanjiaruService.insert(shetuanjiaru);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShetuanjiaruEntity shetuanjiaru, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shetuanjiaru);
        shetuanjiaruService.updateById(shetuanjiaru);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShetuanjiaruEntity> list = new ArrayList<ShetuanjiaruEntity>();
        for(Long id : ids) {
            ShetuanjiaruEntity shetuanjiaru = shetuanjiaruService.selectById(id);
            shetuanjiaru.setSfsh(sfsh);
            shetuanjiaru.setShhf(shhf);
            list.add(shetuanjiaru);
        }
        shetuanjiaruService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shetuanjiaruService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
