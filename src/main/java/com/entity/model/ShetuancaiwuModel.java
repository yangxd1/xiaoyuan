package com.entity.model;

import com.entity.ShetuancaiwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 社团财务
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
public class ShetuancaiwuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 社团类型
	 */
	
	private String shetuanleixing;
		
	/**
	 * 社团收入
	 */
	
	private Double shetuanshouru;
		
	/**
	 * 社团支出
	 */
	
	private Double shetuanzhichu;
		
	/**
	 * 剩余金额
	 */
	
	private Double shengyujine;
		
	/**
	 * 日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date riqi;
		
	/**
	 * 社长账号
	 */
	
	private String shezhangzhanghao;
		
	/**
	 * 负责人
	 */
	
	private String fuzeren;
				
	
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
	 * 设置：社团收入
	 */
	 
	public void setShetuanshouru(Double shetuanshouru) {
		this.shetuanshouru = shetuanshouru;
	}
	
	/**
	 * 获取：社团收入
	 */
	public Double getShetuanshouru() {
		return shetuanshouru;
	}
				
	
	/**
	 * 设置：社团支出
	 */
	 
	public void setShetuanzhichu(Double shetuanzhichu) {
		this.shetuanzhichu = shetuanzhichu;
	}
	
	/**
	 * 获取：社团支出
	 */
	public Double getShetuanzhichu() {
		return shetuanzhichu;
	}
				
	
	/**
	 * 设置：剩余金额
	 */
	 
	public void setShengyujine(Double shengyujine) {
		this.shengyujine = shengyujine;
	}
	
	/**
	 * 获取：剩余金额
	 */
	public Double getShengyujine() {
		return shengyujine;
	}
				
	
	/**
	 * 设置：日期
	 */
	 
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
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
			
}
