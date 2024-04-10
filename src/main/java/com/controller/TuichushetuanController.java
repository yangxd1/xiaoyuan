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

import com.entity.TuichushetuanEntity;
import com.entity.view.TuichushetuanView;

import com.service.TuichushetuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 退出社团 
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
@RestController
@RequestMapping("/tuichushetuan")
public class TuichushetuanController {
    @Autowired
    private TuichushetuanService tuichushetuanService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuichushetuanEntity tuichushetuan, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shetuan")) {
			tuichushetuan.setShezhangzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			tuichushetuan.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TuichushetuanEntity> ew = new EntityWrapper<TuichushetuanEntity>();


		PageUtils page = tuichushetuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuichushetuan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuichushetuanEntity tuichushetuan, 
		HttpServletRequest request){
        EntityWrapper<TuichushetuanEntity> ew = new EntityWrapper<TuichushetuanEntity>();

		PageUtils page = tuichushetuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuichushetuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuichushetuanEntity tuichushetuan){
       	EntityWrapper<TuichushetuanEntity> ew = new EntityWrapper<TuichushetuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuichushetuan, "tuichushetuan")); 
        return R.ok().put("data", tuichushetuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuichushetuanEntity tuichushetuan){
        EntityWrapper< TuichushetuanEntity> ew = new EntityWrapper< TuichushetuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuichushetuan, "tuichushetuan")); 
		TuichushetuanView tuichushetuanView =  tuichushetuanService.selectView(ew);
		return R.ok("查询退出社团成功").put("data", tuichushetuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuichushetuanEntity tuichushetuan = tuichushetuanService.selectById(id);
        return R.ok().put("data", tuichushetuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuichushetuanEntity tuichushetuan = tuichushetuanService.selectById(id);
        return R.ok().put("data", tuichushetuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuichushetuanEntity tuichushetuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tuichushetuan);

        tuichushetuanService.insert(tuichushetuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TuichushetuanEntity tuichushetuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tuichushetuan);

        tuichushetuanService.insert(tuichushetuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TuichushetuanEntity tuichushetuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuichushetuan);
        tuichushetuanService.updateById(tuichushetuan);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<TuichushetuanEntity> list = new ArrayList<TuichushetuanEntity>();
        for(Long id : ids) {
            TuichushetuanEntity tuichushetuan = tuichushetuanService.selectById(id);
            tuichushetuan.setSfsh(sfsh);
            tuichushetuan.setShhf(shhf);
            list.add(tuichushetuan);
        }
        tuichushetuanService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuichushetuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
