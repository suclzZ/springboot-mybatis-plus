1、简单用法
 1)引入相关的依赖包
 2)建表、实体
 3)写相关的mapper接口，直接继承BaseMapper<T>接口，无需mapper.xml
 4)直接调用mapper进行CRUD操作
 
2、AR模式(ActiveRecord)
  1)实体继承Model<T>
  2)其余与上面一样，直接通过实体进行CRUD操作

3、模板