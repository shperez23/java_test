package com.example.expressions;

import java.time.Clock;
import java.time.ZoneId;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ExpressionApp {
    private static final ZoneId ZONE = ZoneId.of("America/Guayaquil");

    private ExpressionApp() {
    }

    public static void main(String[] args) {
        String idIngesta = args.length > 0 ? args[0] : "ID_INGESTA_000_000_123_456_789";
        ExpressionContext context = new ExpressionContext(Clock.systemUTC(), ZONE, idIngesta);
        String dbUrl = envOrProperty("DB_URL");
        if (dbUrl == null || dbUrl.isBlank()) {
            throw new IllegalStateException("Missing DB_URL for public.cat_ingesta_archivo");
        }
        String dbUser = envOrProperty("DB_USER");
        String dbPassword = envOrProperty("DB_PASSWORD");

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            List<ExpressionDefinition> definitions = ExpressionCatalog.definitions(connection);
            for (ExpressionDefinition definition : definitions) {
                String value = definition.evaluate(context);
                System.out.printf("%s%n  SQL: %s%n  Resultado: %s%n%n",
                        definition.name(),
                        definition.sql(),
                        value);
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("Failed to load expressions from public.cat_ingesta_archivo", ex);
        }
    }

    private static String envOrProperty(String key) {
        String value = System.getProperty(key);
        if (value == null || value.isBlank()) {
            value = System.getenv(key);
        }
        return value;
    }
}
