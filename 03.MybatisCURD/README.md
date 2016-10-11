##Mybatis 简单的CURD示例
- dao/IUser.java中添加CURD操作方法
```java
    @Select("select * from user where id= #{id}")
    public User getUserByID(int id);

    @Insert("insert into user values(#{id},#{name},#{dept},#{website},#{phone})")
    public void insertUser(User user);

    @Update("update user set name=#{name},dept=#{dept},phone=#{phone},website=#{website} where id = #{id}")
    public void updateUser(User user);

    @Delete("delete from user where id = #{id}")
    public void deleteUser(int userId);

    @Select("select * from user;")
    public List<User> getUserList();
```
- 操作类中获取到IUser userMapper = session.getMapper(IUser.class)后 ，传入对应方法参数进行数据操作。
