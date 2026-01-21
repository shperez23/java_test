package com.example.expressions;

import java.util.function.Function;

public final class ExpressionDefinition {
    private final String name;
    private final String sql;
    private final Function<ExpressionContext, String> generator;

    public ExpressionDefinition(String name, String sql, Function<ExpressionContext, String> generator) {
        this.name = name;
        this.sql = sql;
        this.generator = generator;
    }

    public String name() {
        return name;
    }

    public String sql() {
        return sql;
    }

    public String evaluate(ExpressionContext context) {
        return generator.apply(context);
    }
}
