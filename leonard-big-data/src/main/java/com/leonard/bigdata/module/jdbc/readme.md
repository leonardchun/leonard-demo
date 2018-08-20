##一、jdbcTemplate提供的主要方法:
####execute方法：
可以用于执行任何SQL语句，一般用于执行DDL语句；
####update方法及batchUpdate方法：
update方法用于执行新增、修改、删除等语句；batchUpdate方法用于执行批处理相关语句；
####query方法及queryForXXX方法：
用于执行查询相关语句；
####call方法：
用于执行存储过程、函数相关语句

##二、NamedParameterJdbcTemplate讲解:
在 Spring JDBC 框架中, 绑定 SQL 参数的另一种选择是使用具名参数(named parameter).
####具名参数: 
SQL 按名称(以冒号开头)而不是按位置进行指定. 具名参数更易于维护, 也提升了可读性. 具名参数由框架类在运行时用占位符取代

NamedParameterJdbcTemplate还新增了KeyHolder类,使用它我们可以获得主键,类似Mybatis中的useGeneratedKeys

SqlParameterSource sqlParameterSource=new BeanPropertySqlParameterSource(u);
KeyHolder keyHolder = new GeneratedKeyHolder();
namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder);
int k = keyHolder.getKey().intValue();//主键