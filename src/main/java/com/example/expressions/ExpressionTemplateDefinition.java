package com.example.expressions;

public record ExpressionTemplateDefinition(String name, String sql, ExpressionTemplate template) {
    public static ExpressionTemplateDefinition of(String name, String sql, String template) {
        return new ExpressionTemplateDefinition(name, sql, new ExpressionTemplate(template));
    }

    public ExpressionDefinition toDefinition() {
        return new ExpressionDefinition(name, sql, template::render);
    }
}
