package com.ywy.mybatisdemo.interceptor;

import jodd.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.Select;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.io.StringReader;
import java.sql.Connection;

import static org.apache.ibatis.mapping.SqlCommandType.SELECT;

/**
 * @author 83425
 * @date 2020/11/24
 */
@Slf4j
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}))
public class IdInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 找到查询类型为SELECT的才做拦截业务
        RoutingStatementHandler target = (RoutingStatementHandler) invocation.getTarget();
        Object delegate = BeanUtil.declared.getProperty(target, "delegate");
        Object mappedStatement = BeanUtil.declared.getProperty(delegate, "mappedStatement");
        BoundSql boundSql = target.getBoundSql();

        SqlCommandType sqlCommandType = ((MappedStatement) mappedStatement).getSqlCommandType();
        if (SELECT == sqlCommandType) {
            // 对sql进行处理,拼接id=11
            handlerSql(boundSql);
        }
        return invocation.proceed();
    }

    private void handlerSql(BoundSql boundSql) throws JSQLParserException {
        CCJSqlParserManager ccjSqlParserManager = new CCJSqlParserManager();
        Select parse = (Select) ccjSqlParserManager.parse(new StringReader(boundSql.getSql()));
        parse.getSelectBody().accept(new IdSelectVisitor());
        System.out.println(boundSql);
        BeanUtil.declared.setProperty(boundSql, "sql", parse.toString());
    }
}
