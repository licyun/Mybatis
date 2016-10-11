##Mybatis简单示例 使用xml配置sql语句映射
- configure.xml详解
    typeAliases指定表的别名，与对应的具体类 User.xml 中 resultType 映射。
    environments配置数据库连接的具体信息
    <mapper resource= 要包含类的xml配置文件
```xml
<configuration>
    <typeAliases>
        <typeAlias alias="User" type="com.licyun.model.User" />
    </typeAliases>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC" />
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver" />
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis" />
                <property name="username" value="root" />
                <property name="password" value="123456" />
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper resource="com/licyun/model/User.xml" />
    </mappers>
</configuration>
```
 
- User.xml详解
    namespace 指定命名空间，在方法调用时用到该命名。
    <select 执行语句，还有<update <delete <insert
```xml
<mapper namespace="com.licyun.model.UserMapper">
    <select id="GetUserByID" parameterType="int" resultType="User">
        select * from 'User' where id = #{id}
    </select>
</mapper>
```
