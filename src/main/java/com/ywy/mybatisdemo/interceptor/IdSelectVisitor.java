package com.ywy.mybatisdemo.interceptor;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectVisitor;
import net.sf.jsqlparser.statement.select.SetOperationList;
import net.sf.jsqlparser.statement.select.WithItem;
import net.sf.jsqlparser.statement.values.ValuesStatement;

/**
 * @author 83425
 * @date 2020/11/25
 */
@Slf4j
public class IdSelectVisitor implements SelectVisitor {
    @Override
    public void visit(PlainSelect plainSelect) {
        EqualsTo equalsTo = new EqualsTo();
        equalsTo.setLeftExpression(new Column("id"));
        equalsTo.setRightExpression(new StringValue("11"));
        equalsTo.setRightExpression(new StringValue("11"));
        if (plainSelect.getWhere() == null) {
            plainSelect.setWhere(equalsTo);
        } else {
            plainSelect.setWhere(new AndExpression(plainSelect.getWhere(), equalsTo));
        }
    }

    @Override
    public void visit(SetOperationList setOpList) {
        System.out.println();
    }

    @Override
    public void visit(WithItem withItem) {
        System.out.println();
    }

    @Override
    public void visit(ValuesStatement aThis) {
        System.out.println();
    }
}
