package com.sucl.smp.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * mybatis-plus 生成代码
 */
@PropertySource(value = {"classpath:generate.properties"})
@Configuration
public class TemplateConfiguration {

    /**
     * 生成代码核心模块
     * @return
     */
    @Bean
    public AutoGenerator autoGenerator(){
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setTemplateEngine(templateEngine());
        autoGenerator.setGlobalConfig(globalConfig());
        autoGenerator.setDataSource(dataSourceConfig());
        autoGenerator.setStrategy(strategyConfig());
        autoGenerator.setPackageInfo(packageConfig());
        autoGenerator.setCfg(injectionConfig());
        autoGenerator.setTemplate(templateConfig());
        return autoGenerator;
    }

    /**
     * 模板引擎 默认为 velocity
     * @return
     */
    @ConfigurationProperties(prefix = "mybatis-plus.templateEngine")
    @Bean
    public AbstractTemplateEngine templateEngine() {
        TemplateEngineBuilder templateEngineBuilder = new TemplateEngineBuilder();
        return templateEngineBuilder.build();
    }

    /**
     * 全局配置
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "mybatis-plus.globalConfig")
    public GlobalConfig globalConfig(){
        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir("d:/generate");
//        gc.setFileOverride(true);
//        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
//        gc.setEnableCache(false);// XML 二级缓存
//        gc.setBaseResultMap(true);// XML ResultMap
//        gc.setBaseColumnList(false);// XML columList
        // .setKotlin(true) 是否生成 kotlin 代码
        //gc.setAuthor("Yanghu");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        return gc;
    }

    /**
     * 数据源配置
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "mybatis-plus.dataSourceConfig")
    public DataSourceConfig dataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        return dsc;
    }

    /**
     * 生成代码相关策略
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "mybatis-plus.strategyConfig")
    public StrategyConfig strategyConfig(){
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        //       strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
//        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        //        strategy.setInclude(new String[] { "user" }); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        return strategy;
    }

    /**
     * 输出包相关
     * 怎么针对不同表前缀生成不同模块(moduleName)?
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "mybatis-plus.packageConfig")
    public PackageConfig packageConfig(){
        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("xx");
        return pc;
    }

    /**
     * 可以没有
     * 主要是在过程进行特殊处理
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "mybatis-plus.injectionConfig")
    public InjectionConfig injectionConfig(){
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                this.getConfig(); // 可以获取以上所有配置
                this.setMap(map);
            }
        };
        return cfg;
    }

    /**
     * 模板文件 *.ftl *.vm输入
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "mybatis-plus.templateConfig")
    public TemplateConfig templateConfig(){
        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        return tc;
    }

}
