## 7、Mybatis解析和运行原理

### 7.1 构建SqlSessionFactory过程
- 1、XMLConfigBuilder解析xml配置文件
- 2、读取内容保存Configuration（单例），
- 3、build方法（new DefaultSqlSessionFactory）创建SqlSessionFactory

#### 7.1.1 构建Configuration

###### 作用
```$xslt
1、读入配置文件，基础配置XML和映射器配置XML
2、初始化基础配置，typeAliases、插件、映射器、Object工厂、typeHandler等
3、提供单例，提供配置参数
4、一些重要的初始化方法
```
#### 7.1.2 构建映射器的内部组成
###### MappedStatement
```$xslt
保存一个映射器节点（select/update/insert/delete）。
包括配置SQL，SQL的id，缓存信息，resultMap，paramterType，resultType等
属性sqlSource
```
属性/方法|类型|
---|---|
id|String|
sqlSource|SqlSource|
parameterMap|ParameterMap|
configuration|Configuration|
databaseId|String|
getBoundSql()|BoundSql|

###### SqlSource
```$xslt
MappedStatement属性。
接口。
实现类：DynamicSqlSource，ProviderSqlSession，RawSqlSource，StaticSqlSource
根据上下文和参数解析生成需要的SQL
```
属性/方法|类型|
---|---|
getBoundSql()|BoundSql|

###### BoundSql
```$xslt
结果对象。
参数：sql，parameterObject，parameterMapping
```
属性/方法|类型|
---|---|
**sql**|String|
**parameterMappings**|List<ParameterMapping>|
**parameterObject**|Object|
additionalParameter|Map<String,Object>|
getSql()|String|
getParameterObject|Object|

```$xslt
parameterObject：
1、传递简单对象。
2、pojo或Map对象。
3、多个参数（非@param）。
    处理为Map<String,Object>,键值按顺序取。
4、多个参数（@param）
    
parameterMappings：
通过它就可以实现参数和SQL的结合，以便 PreparedStatement 能够通过它找到 parameterObject 对象的属性设置参数 ， 使得程序能准确运行。

sql：
书写在映射器里面的一条被SqlSource解析后的SQL。
```


#### 7.1.3 构建SqlSessionFactory
```$xslt
sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
```

### 7.2 SqlSession运行过程
#### 7.2.1 映射器（Mapper）动态代理