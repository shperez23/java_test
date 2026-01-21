package com.example.expressions;

import java.time.Clock;
import java.time.ZoneId;
import java.util.List;

public final class ExpressionApp {
    private static final ZoneId ZONE = ZoneId.of("America/Guayaquil");

    private ExpressionApp() {
    }

    public static void main(String[] args) {
        String idIngesta = args.length > 0 ? args[0] : "ID_INGESTA_000_000_123_456_789";
        ExpressionContext context = new ExpressionContext(Clock.systemUTC(), ZONE, idIngesta);
        List<ExpressionDefinition> definitions = ExpressionCatalog.definitions();

        for (ExpressionDefinition definition : definitions) {
            String value = definition.evaluate(context);
            System.out.printf("%s%n  SQL: %s%n  Resultado: %s%n%n",
                    definition.name(),
                    definition.sql(),
                    value);
        }
    }
}
