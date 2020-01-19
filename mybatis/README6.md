## 6、动态SQL

元素|作用|备注|
---|---|---|
if|判断语句|但条件分支判断|
choose（when，otherwise）|判断语句|多条件判断|
trim（where，set）|辅助语句|处理SQL拼装|
foreach|循环语句|处理集合|

#### if元素
###### 参数不为空,对 roleName 的模糊查询
```
<select id="findRoles" parameterType="string"  resultMap="roleResultMap">
    select role_no,role_name,note from t_role where 1=1
    <if test="roleName !=null and roleName != ''">
        and role_name like contact('%',#{roleName},'%')
    </if>
</select>
```

#### chosse、when、otherwise元素
- 如果角色编号 CroleNo ）不为空，则只用角色编号作为条件查询。
- 当角色编号为空，而角色名称不为空 ，则用角色名称作为条件进行模糊查询。
- 当角色编号和角色名称都为空 ，则要求角色备注不为空
```
<select id="findRoles" parameterType="string"  resultMap="roleResultMap">
    select role_no,role_name,note from t_role where 1=1
    <chosse>
        <when test="roleNo !=null and roleNo != ''">
              and role_no = #{roleNo}
        </when>
        <when test="roleName !=null and roleName != ''">
            and role_name like contact('%',#{roleName},'%')
        </when>
        <otherwise>
            and note is not null
        </otherwise>
    </chosse>
</select>
```

#### trim、where、set元素
###### where
```
<select id="findRoles" parameterType="string"  resultMap="roleResultMap">
    select role_no,role_name,note from t_role
    <where>
        <if test="roleName !=null and roleName != ''">
            and role_name like contact('%',#{roleName},'%')
        </if>
        <if>
            and note like contact('%',#{note},'%')
        </if>
    </where> 
</select>
```

###### trim
```
<select id="findRoles" parameterType="string"  resultMap="roleResultMap">
    select role_no,role_name,note from t_role
    <trim prefix="and" prefixOverrides="and">
        <if test="roleName !=null and roleName != ''">
            and role_name like contact('%',#{roleName},'%')
        </if>
    </trim> 
</select>
```

```$xslt
<trim prefix="set" suffixOverrides=",">
    ......
</trim>
```

###### set
```
<update id="updateRole" parameterType="role"  >
    update t_role
    <set >
        <if test="roleName !=null and roleName != ''">
             role_name like contact('%',#{roleName},'%'),
        </if>
        <if test="role !=null and role != ''">
             role =#{role}
        </if>
    </set>
    where role_no=#{roleNo} 
</update>
```

#### foreach元素
```$xslt
<select id="findUserSex" parameterType="user">
    select * from t_role where role_no in
    <foreach item="roleNo" index="index" collection="roleNoList" 
        open="(" seperator="," close=")">
        #{roleNo}
    </foreach>
</select >
```

#### bind元素
```$xslt
<select id="getBindList" parameterType="role" resultMap="roleResultMap">
    <bind name="pattern_name" value="'%'+roleName+'%'" />
    <bind name="pattern_no" value="'%'+roleNo+'%'" />
    select id ,role_no,role_name from t_role
    where roleName like #{pattern_name}
    and roleNo like #{pattern_no}
</select
```