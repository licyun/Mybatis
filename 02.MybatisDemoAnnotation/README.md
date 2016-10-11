##Mybatis 使用Interface接口配置sql语句映射代替xml
- 在01的基础下添加IUser接口类
    与xml中的sql语句相对应
```xml
public interface IUser {
    @Select("select * from user where id= #{id}")
    public User getUserByID(int id);
}
```
- 修改configure.xml
    去掉mappers配置
- 获取sqlSession中添加
```java
  sqlSessionFactory.getConfiguration().addMapper(IUser.class);
  SqlSession session = sqlSessionFactory.openSession();
  ```
