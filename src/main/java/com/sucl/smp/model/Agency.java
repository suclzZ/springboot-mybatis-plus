package com.sucl.smp.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("AGENCY")
public class Agency extends Model<Agency> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private String code;
    @TableField
    private String name;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
