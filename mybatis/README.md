## MyBatis 使用 properties 的 3 种方式
```
# 优先级别（覆盖原设置属性）

程序传递（编码）> 使用properties文件（xml引用） > properties子元素
```

## settings设置
配置项|作用|配置项说明|默认值|
---|---|---|---|
<b>cacheEnabled</b>|该配置影响所有映射器中配置缓存的全局开关|true/false|true|
<b>lazyLoadingEnabled</b>|延迟加载的全局开关．当开启时，所有关联对象都会延迟加载。<br/>在特定关联关系中可通过设置 fetchType 属性来覆盖该项的开关状态|true/false|false|
<b>aggressiveLazyLoading</b>|当启用时，对任意延迟属性的调用会便带有延迟加载属性的对象完整加载：<br>反之，每种属性将会按需加载|true/false|false|
multipleResultSetsEnabled|延迟力日载的全局开关．当开启时，所有关联对象都会延迟却l载。<br/>在特定关联关系中可通过设置 fetchType 属性来覆盖该项的开关状态|true/false|false|
useColumnLabel|使用列标签代替列名．不同的驱动会有不同的表现，具体可参考相关驱动文档或通过测试这两种不同的模式来观察所用驱动的结果|true/false|true|
useGeneratedKeys|允许 JDBC 支持自动生成主键，需要驱动兼容。<br> 如果设直为 true，则这个设置强制使用自动生成主键，尽管一些驱动不能兼容但仍可正常工作（比如 Derby)|true/false|false|
<b>autoMappingBehavior</b>|指定 MyBat is 应如何自动映射列到字段或属性 |NONE表示驭消自动映射：<br>PARTIAL默认表示只会自动映射，没有定义嵌套结果集和映射结果集。<br>FULL 会自动映射任意复杂的结果然（无论是否嵌套）|PARTIAL|
autoMappingUnknownColumnBehavior|指定自动映射当中未知列（或未知属性类型〉时的行为|NONE：不处理。WARNING，FAILING:显示相关日志，如巢处理失败会抛出SqlSessionException 异常|NONE|
<b>defaultExecutorType</b>|配置默认的执行器 。|SIMPLE:普通的执行器;REUSE:重用预处理语句(prepared statements);BATCh:重用语句并执行批量更新|SIMPLE|
defaultStatementTimeout|设置超时时间，它决定驱动等待数据库响应的秒数|正整数|NOT SET|
defaultFetchSize|设置数据库驱动程序默认返回的条数限制，此参数可以重新设置|正整数|NOT SET|
safeRowBoundsEnabled|允许在版套语句中使用分页（ RowBounds ）。如果允许，设置false|true/false|false|
safeResultHandlerEnabled| |true/false|false|
<b>mapUnderscoreToCameICase</b>|是杏开启自动驼峰命名规则映射，即从经典数据库列名A_COLUMN 到经典 Java 属性名 aColumn 的类似映射|true/false|false|
localCacheScope|MyBatis 利用本地缓存机制（ Local Cache ）防止循环引用（ circular references ）和加速重复嵌套查询。|STATEMENT:本地会话仅用在语句执行上，对相同 SqlSession 的不同调用将不会共享数据<br>SESSION:缓存一个会话中执行的所有查询。|SESSION|
jdbcTypeForNull|当没有为参数提供特定 的 JDBC 类型时，为空值指定JDBC 类型。|NULL/VARCHAR/OTHER|OTHER|
lazyLoadTdggerMethods|指定哪个对象的方法触发一次延迟加载。| |equals,clone,hashcode,toString|
defaultScriptingLanguage|指定动态 SQL 生成的默认语言| |org.apache.ibatis.scripting.xmltags.XMLDynamicLanguageDriver|
callSettersOnNulls|允许 JDBC 支持自动生成主键，需要驱动兼容。<br> 如果设直为 true，则这个设置强制使用自动生成主键，尽管一些驱动不能兼容但仍可正常工作（比如 Derby)|true/false|false|
logPrefix|指定 MyBatis 增加到日志名称的前缀|任何字符串|Not set|
loglmpl|指定 MyBatis 所用日志的具体实现，未指定时将自动查找|SLF4J/LOG4J/LOG4J2/JDK_LOGGING/|Not set|
proxyFactory|指定 MyBatis 创建具有延迟加载能力的对象所用到的代理工具|CGLIB/JAVASSIST|JAVASSIST|
vfslmpl|指定 VFS 的实现类|提供 VFS 类的全限定名，如果存在多个，可以使用逗号分隔|Not set|
useActualParamName|允许用方法参数中声明的实际名称引用参数．要使用此功能，项目必须被编译为 Java S 参数的选择|true/false|true|

## typeAliases别名
#### 系统别名
别名|Java类型|是否支持数组|
---|---|---|
_byte|byte|是|
_long|long|是|
_short|short|是|
_int|int|是|
_integer|integer|是|
_double|double|是|
_float|float|是|
_boolean|boolean|是|
string|String|是|
byte|Byte|是|
long|Long|是|
short|Short|是|
int|Integer|是|
integer|Integer|是|
double|Double|是|
float|Float|是|
boolean|Boolean|是|
date|Date|是|
decimal|BigDecimal|是|
bigdecimal|BigDecimal|是|
object|Object|是|
map|Map|否|
hashmap|HashMap|否|
list|List|否|
arraylist|ArrayList|否|
collection|Collection|否|
iterator|Iterator|否|
ResultSet|ResultSet|否|

## typeHandler类型转换器

#### jdbcType
定义数据库类型

#### javaType
定义java类型