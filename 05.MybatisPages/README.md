##Mybatis 简单分页功能实现
- 配置springmvc和mybatis
    spring-mvc.xml开启注解扫描Controller包，及返回对应的物理视图
    configure.xml配置mybatis别名
    applicationContext.xml配置dbcp连接池，sqlSessionFactory,为mybatisa注入UserMaper类。
    ```java
    	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		    <property name="basePackage" value="com.licyun.entity" />
	    </bean>
    ```
  
- 前台jsp获取Controller传递的page参数拼接成page上下页,需要注意当page为1时，上一页仍然为1
```jsp
			<a href="${pageContext.request.contextPath}/user/orderpages?page=${currentPage==1?currentPage:currentPage- 1}">上一页</a>  &nbsp;
			<a href="${pageContext.request.contextPath}/user/orderpages?page=${currentPage+ 1}">下一页</a>
```

- controller中获取前台传递的page参数封装到Page类中，然后通过自动装载的UserMapper查询分页并封装到List中。
```java
        int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

```

- Usermaper接口实现sql语句的映射，其中分页使用sql语句的limit参数限制返回页面数。
```java
	@Select("SELECT u.*,o.* FROM `user` u, `order` o WHERE u.id=o.user_id AND u.id=#{userid} LIMIT #{page.currentResult}, #{page.showCount}")
	public List<Order> getOrderListPage(@Param("page") Page page, @Param("userid") int userid);
```
