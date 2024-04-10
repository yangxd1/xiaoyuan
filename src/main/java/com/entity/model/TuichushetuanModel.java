package com.entity.model;

import com.entity.TuichushetuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 退出社团
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
public class TuichushetuanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 社团类型
	 */
	
	private String shetuanleixing;
		
	/**
	 * 社团属性
	 */
	
	private String shetuanshuxing;
		
	/**
	 * 社长账号
	 */
	
	private String shezhangzhanghao;
		
	/**
	 * 负责人
	 */
	
	private String fuzeren;
		
	/**
	 * 退出原因
	 */
	
	private String tuichuyuanyin;
		
	/**
	 * 退出时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tuichushijian;
		
	/**
	 * 退出账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 退出人
	 */
	
	private String yonghuxingming;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：社团类型
	 */
	 
	public void setShetuanleixing(String shetuanleixing) {
		this.shetuanleixing = shetuanleixing;
	}
	
	/**
	 * 获取：社团类型
	 */
	public String getShetuanleixing() {
		return shetuanleixing;
	}
				
	
	/**
	 * 设置：社团属性
	 */
	 
	public void setShetuanshuxing(String shetuanshuxing) {
		this.shetuanshuxing = shetuanshuxing;
	}
	
	/**
	 * 获取：社团属性
	 */
	public String getShetuanshuxing() {
		return shetuanshuxing;
	}
				
	
	/**
	 * 设置：社长账号
	 */
	 
	public void setShezhangzhanghao(String shezhangzhanghao) {
		this.shezhangzhanghao = shezhangzhanghao;
	}
	
	/**
	 * 获取：社长账号
	 */
	public String getShezhangzhanghao() {
		return shezhangzhanghao;
	}
				
	
	/**
	 * 设置：负责人
	 */
	 
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	
	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}
				
	
	/**
	 * 设置：退出原因
	 */
	 
	public void setTuichuyuanyin(String tuichuyuanyin) {
		this.tuichuyuanyin = tuichuyuanyin;
	}
	
	/**
	 * 获取：退出原因
	 */
	public String getTuichuyuanyin() {
		return tuichuyuanyin;
	}
				
	
	/**
	 * 设置：退出时间
	 */
	 
	public void setTuichushijian(Date tuichushijian) {
		this.tuichushijian = tuichushijian;
	}
	
	/**
	 * 获取：退出时间
	 */
	public Date getTuichushijian() {
		return tuichushijian;
	}
				
	
	/**
	 * 设置：退出账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：退出账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：退出人
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：退出人
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：跨表用户id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
