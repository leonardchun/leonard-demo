package com.leonard.study.spring_el;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author leonard
 * @date 2018/7/27 16:32
 */
public class ElTest {

    public static void main(String[] args) {
        elString();

        ExpressionParser parser = new SpelExpressionParser();

        //literal expressions
        Expression exp = parser.parseExpression("'Hello World'");
        String msg1 = exp.getValue(String.class);
        System.out.println(msg1);

        //method invocation
        Expression exp2 = parser.parseExpression("'Hello World'.length()");
        int msg2 = (Integer) exp2.getValue();
        System.out.println(msg2);

        //Mathematical operators
        Expression exp3 = parser.parseExpression("100 * 2");
        int msg3 = (Integer) exp3.getValue();
        System.out.println(msg3);

        //create an item object
        //Item item = new Item("yiibai", 100);
        //test EL with item object
//        StandardEvaluationContext itemContext = new StandardEvaluationContext(item);

        //display the value of item.name property
       /* Expression exp4 = parser.parseExpression("name");
        String msg4 = exp4.getValue(itemContext, String.class);
        System.out.println(msg4);

        //test if item.name == 'yiibai'
        Expression exp5 = parser.parseExpression("name == 'yiibai'");
        boolean msg5 = exp5.getValue(itemContext, Boolean.class);
        System.out.println(msg5);*/


    }

    /**
     * 使用SpringEL来计算评估文字字符串表达式。
     */
    private static void elString() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'put spel expression here'");
        String msg = exp.getValue(String.class);
        System.out.println(msg);
    }

    /**
     * 使用SpEL来计算评估 bean 属性 – “item.name”.
     */
    private static void elBean() {
        /*Item item = new Item("yiibai", 100);
        StandardEvaluationContext itemContext = new StandardEvaluationContext(item);

//display the value of item.name property
        Expression exp = parser.parseExpression("name");
        String msg = exp.getValue(itemContext, String.class);
        System.out.println(msg);*/
    }

}
