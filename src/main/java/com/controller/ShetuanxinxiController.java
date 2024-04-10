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

import com.entity.ShetuanxinxiEntity;
import com.entity.view.ShetuanxinxiView;

import com.service.ShetuanxinxiService;
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
 * 社团信息 
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
@RestController
@RequestMapping("/shetuanxinxi")
public class ShetuanxinxiController {
    @Autowired
    private ShetuanxinxiService shetuanxinxiService;


    @Autowired
    private StoreupService storeupService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShetuanxinxiEntity shetuanxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shetuan")) {
			shetuanxinxi.setShezhangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShetuanxinxiEntity> ew = new EntityWrapper<ShetuanxinxiEntity>();


		PageUtils page = shetuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShetuanxinxiEntity shetuanxinxi, 
		HttpServletRequest request){
        EntityWrapper<ShetuanxinxiEntity> ew = new EntityWrapper<ShetuanxinxiEntity>();

		PageUtils page = shetuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShetuanxinxiEntity shetuanxinxi){
       	EntityWrapper<ShetuanxinxiEntity> ew = new EntityWrapper<ShetuanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shetuanxinxi, "shetuanxinxi")); 
        return R.ok().put("data", shetuanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShetuanxinxiEntity shetuanxinxi){
        EntityWrapper< ShetuanxinxiEntity> ew = new EntityWrapper< ShetuanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shetuanxinxi, "shetuanxinxi")); 
		ShetuanxinxiView shetuanxinxiView =  shetuanxinxiService.selectView(ew);
		return R.ok("查询社团信息成功").put("data", shetuanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShetuanxinxiEntity shetuanxinxi = shetuanxinxiService.selectById(id);
		shetuanxinxi.setClicknum(shetuanxinxi.getClicknum()+1);
		shetuanxinxi.setClicktime(new Date());
		shetuanxinxiService.updateById(shetuanxinxi);
        return R.ok().put("data", shetuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShetuanxinxiEntity shetuanxinxi = shetuanxinxiService.selectById(id);
		shetuanxinxi.setClicknum(shetuanxinxi.getClicknum()+1);
		shetuanxinxi.setClicktime(new Date());
		shetuanxinxiService.updateById(shetuanxinxi);
        return R.ok().put("data", shetuanxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        ShetuanxinxiEntity shetuanxinxi = shetuanxinxiService.selectById(id);
        if(type.equals("1")) {
        	shetuanxinxi.setThumbsupnum(shetuanxinxi.getThumbsupnum()+1);
        } else {
        	shetuanxinxi.setCrazilynum(shetuanxinxi.getCrazilynum()+1);
        }
        shetuanxinxiService.updateById(shetuanxinxi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShetuanxinxiEntity shetuanxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shetuanxinxi);

        shetuanxinxiService.insert(shetuanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShetuanxinxiEntity shetuanxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shetuanxinxi);

        shetuanxinxiService.insert(shetuanxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShetuanxinxiEntity shetuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shetuanxinxi);
        shetuanxinxiService.updateById(shetuanxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShetuanxinxiEntity> list = new ArrayList<ShetuanxinxiEntity>();
        for(Long id : ids) {
            ShetuanxinxiEntity shetuanxinxi = shetuanxinxiService.selectById(id);
            shetuanxinxi.setSfsh(sfsh);
            shetuanxinxi.setShhf(shhf);
            list.add(shetuanxinxi);
        }
        shetuanxinxiService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shetuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ShetuanxinxiEntity shetuanxinxi, HttpServletRequest request,String pre){
        EntityWrapper<ShetuanxinxiEntity> ew = new EntityWrapper<ShetuanxinxiEntity>();
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
		PageUtils page = shetuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanxinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ShetuanxinxiEntity shetuanxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "shetuanleixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "shetuanxinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ShetuanxinxiEntity> shetuanxinxiList = new ArrayList<ShetuanxinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                shetuanxinxiList.addAll(shetuanxinxiService.selectList(new EntityWrapper<ShetuanxinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ShetuanxinxiEntity> ew = new EntityWrapper<ShetuanxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = shetuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shetuanxinxi), params), params));
        List<ShetuanxinxiEntity> pageList = (List<ShetuanxinxiEntity>)page.getList();
        if(shetuanxinxiList.size()<limit) {
            int toAddNum = (limit-shetuanxinxiList.size())<=pageList.size()?(limit-shetuanxinxiList.size()):pageList.size();
            for(ShetuanxinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(ShetuanxinxiEntity o2 : shetuanxinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    shetuanxinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(shetuanxinxiList.size()>limit) {
            shetuanxinxiList = shetuanxinxiList.subList(0, limit);
        }
        page.setList(shetuanxinxiList);
        return R.ok().put("data", page);
    }








}
