##Mybatis 一对多，多对一，多对多映射
- 一对多映射,<collection中指定多
```xml
<mapper namespace="com.licyun.model.userMaper">

	<resultMap type="User" id="resultUserMap">
		<result property="id" column="user_id" />
		<result property="username" column="username" />
		<result property="mobile" column="mobile" />
		<collection property="posts" ofType="com.licyun.model.Post" column="userid">
			<id property="id" column="post_id" javaType="int" jdbcType="INTEGER"/>    
            <result property="title" column="title" javaType="string" jdbcType="VARCHAR"/>
            <result property="content" column="content" javaType="string" jdbcType="VARCHAR"/> 
		</collection>
	</resultMap>

	<select id="getUser" resultMap="resultUserMap" parameterType="int">
		SELECT u.*,p.*
		FROM user u, post p
		WHERE u.id=p.userid AND id=#{user_id} 
  </select>

</mapper>
```

- 多对一映射  <association指定 一
```xml
<mapper namespace="com.licyun.model.userMaper">
	<!-- User 级联文章查询 方法配置 (多个文章对一个用户)  -->
	
	<resultMap type="Post" id="resultPostsMap">
		<result property="id" column="post_id" />
		<result property="title" column="title" />
		<result property="content" column="content" />
		<association property="user" javaType="User">  
	        <id property="id" column="userid"/>   
	        <result property="username" column="username"/>   
	        <result property="mobile" column="mobile"/>   
        </association> 
	</resultMap>

	<select id="getPosts" resultMap="resultPostsMap" parameterType="int">
		SELECT u.*,p.*
		FROM user u, post p
		WHERE u.id=p.userid AND p.post_id=#{post_id} 
  </select>

</mapper>
```

- 多对多映射
```xml
<mapper namespace="com.licyun.model.userMaper">
	<parameterMap type="UserGroup" id="parameterUserGroupMap">
		<parameter property="userId"/>
		<parameter property="groupId"/>
	</parameterMap>
	
	<insert id="insertUserGroup"  parameterMap="parameterUserGroupMap">
		INSERT INTO user_group(user_id, group_id)
		VALUES(#{userId},#{groupId})
	</insert>
	
	<!-- 根据一个用户组ID,查看这个用户组下的所有用户 -->
	<resultMap type="User" id="resultUserMap_2">
		<result property="id" column="id"/>
		<result property="username" column="username"/>
		<result property="mobile" column="mobile"/>
	</resultMap>
	
	<select id="getUsersByGroupId" resultMap="resultUserMap_2" parameterType="int">
		SELECT u.*, ug.group_id
		FROM user u, user_group ug
		WHERE u.id=ug.user_id AND ug.group_id=#{group_id}
	</select>
	
	<!-- 根据一个用户ID,查看这个用户所对应的组-->
	<resultMap type="Group" id="resultGroupMap_2">
		<result property="groupId" column="group_id"/>
		<result property="groupName" column="group_name"/>
	</resultMap> 
	
	<select id="getGroupsByUserId" resultMap="resultGroupMap_2" parameterType="int">
		SELECT g.*, u.user_id
		FROM group g, user_group u
		WHERE g.group_id=u.group_id AND u.user_id=#{user_id}
	</select>
</mapper>
```
