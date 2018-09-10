/*
package com.leonard.bigdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

*/
/**
 * @author leonard
 * @date 2018/8/21 15:22
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoenixTest {

    @Resource(name = "phoenixNamedJdbcTemplate")
    private NamedParameterJdbcTemplate nameJdbcTemplate;

    @Test
    public void phoenixConnect() {

        Map<String, Object> paramMap = null;
        List<Map<String, Object>> list = nameJdbcTemplate.queryForList("SELECT * FROM CHL_ORDER_SUMMARY_DAY", paramMap);
        System.out.println(list);
    }
}
*/
