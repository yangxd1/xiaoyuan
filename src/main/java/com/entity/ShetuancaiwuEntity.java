package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 社团财务
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-12-11 19:02:22
 */
@TableName("shetuancaiwu")
public class ShetuancaiwuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShetuancaiwuEntity() {
		
	}
	
	public ShetuancaiwuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 社团名称
	 */
					
	private String shetuanmingcheng;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：社团名称
	 */
	public void setShetuanmingcheng(String shetuanmingcheng) {
		this.shetuanmingcheng = shetuanmingcheng;
	}
	/**
	 * 获取：社团名称
	 */
	public String getShetuanmingcheng() {
		return shetuanmingcheng;
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
