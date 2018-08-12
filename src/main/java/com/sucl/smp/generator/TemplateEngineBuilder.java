package com.sucl.smp.generator;

import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

public class TemplateEngineBuilder {
    private static final String VELOCITY = "velocity";
    private static final String FREEMAKER = "freemaker";

    private String engineStrategy;

    public AbstractTemplateEngine build(){
        if(StringUtils.isEmpty(engineStrategy)){
            return null;
        }else if(VELOCITY.equals(engineStrategy)){
            return new VelocityTemplateEngine();
        }else if(FREEMAKER.equals(engineStrategy)){
            return  new FreemarkerTemplateEngine();
        }
        return null;
    }
}
