package com.example.expressions;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public final class ExpressionCatalog {
    private ExpressionCatalog() {
    }

    public static List<ExpressionDefinition> definitions() {
        List<ExpressionDefinition> definitions = new ArrayList<>();
        definitions.add(new ExpressionDefinition(
                "expr01",
                "CONCAT(DATE_FORMAT(DATE(LAST_DAY(DATE_ADD(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), -DAY(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'))))),'DDMMYYYY'),'.ZIP')",
                ctx -> {
                    LocalDate base = ctx.today();
                    LocalDate firstOfMonth = base.minusDays(base.getDayOfMonth());
                    LocalDate lastDay = DateTimeUtils.lastDayOfMonth(firstOfMonth);
                    return DateTimeUtils.formatDate(lastDay, ctx.zone(), "DDMMYYYY") + ".ZIP";
                }
        ));
        definitions.add(new ExpressionDefinition(
                "expr02",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'DDMMYYYY'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "DDMMYYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr03",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL') - INTERVAL 1 DAY),'YYYYMMDD'),'_CXC_BANCS.XLS')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + "_CXC_BANCS.XLS"
        ));
        definitions.add(new ExpressionDefinition(
                "expr04",
                "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'P2.XLSX')",
                ctx -> " " + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD-MM-YY") + "P2.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr05",
                "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYYMMDD\"),\"_L_\",LPAD(SPLIT(ID_INGESTA, \"_\")[4],3,\"0\"),\".TXT\")",
                ctx -> {
                    String part = TextUtils.safeSplit(ctx.idIngesta(), "_", 4);
                    String padded = TextUtils.lpad(part, 3, "0");
                    return "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + "_L_" + padded + ".TXT";
                }
        ));
        definitions.add(new ExpressionDefinition(
                "expr06",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYMMDD'),'.TXT')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYMMDD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr07",
                "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'P1.XLSX')",
                ctx -> " " + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD-MM-YY") + "P1.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr08",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr09",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'DDMMYYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr10",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'DDMMYYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr11",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'_1.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + "_1.TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr12",
                "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 MONTH,\"YYYY_MM\"),\".XLSM\")",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYY_MM") + ".XLSM"
        ));
        definitions.add(new ExpressionDefinition(
                "expr13",
                "CONCAT(' (',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),') CIERRE DE MES.XLSX')",
                ctx -> " (" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD.MM.YYYY") + ") CIERRE DE MES.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr14",
                "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),' CIERRE DE MES.XLSX')",
                ctx -> " " + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD.MM.YYYY") + " CIERRE DE MES.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr15",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD.MM.YYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr16",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) +INTERVAL-1 DAY,'DDMMYYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr17",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -0 DAY,'DD-MM-YYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "DD-MM-YYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr18",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'MMDD'),'.ZIP')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "MMDD") + ".ZIP"
        ));
        definitions.add(new ExpressionDefinition(
                "expr19",
                "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DDMMYYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr20",
                "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 MONTH,\"YYYY_MM\"),\".XLS\")",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYY_MM") + ".XLS"
        ));
        definitions.add(new ExpressionDefinition(
                "expr21",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -0 DAY,'YYYYMMDD'),'.CSV')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + ".CSV"
        ));
        definitions.add(new ExpressionDefinition(
                "expr22",
                "CONCAT('_',DATE_FORMAT(DATE_ADD(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),-1),'YYYYMMDD'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr23",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYYMMDD\"),\".TXT\")",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr24",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'_DEFINITIVO_.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DDMMYYYY") + "_DEFINITIVO_.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr25",
                "CONCAT(DATE_FORMAT(DATE(TRUNC(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), 'YYYY') ) + INTERVAL -1 YEAR,'YYYY'), '.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today().withDayOfYear(1).minusYears(1), ctx.zone(), "YYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr26",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYYMM") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr27",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'.CSV')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".CSV"
        ));
        definitions.add(new ExpressionDefinition(
                "expr28",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr29",
                "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYYMMDD\"),\"_H_\",LPAD(SPLIT(ID_INGESTA, \"_\")[6],3,\"0\"),\".TXT\")",
                ctx -> {
                    String part = TextUtils.safeSplit(ctx.idIngesta(), "_", 6);
                    String padded = TextUtils.lpad(part, 3, "0");
                    return "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + "_H_" + padded + ".TXT";
                }
        ));
        definitions.add(new ExpressionDefinition(
                "expr30",
                "CONCAT('-',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMM'),'01.TXT')",
                ctx -> "-" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMM") + "01.TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr31",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD.MM.YYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr32",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 YEAR,'YYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusYears(1), ctx.zone(), "YYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr33",
                "CONCAT('_', DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')),'YYYY'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr34",
                "CONCAT('_', DATE_FORMAT(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), -1), 'YYYYMM'), '.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYYMM") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr35",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'YYYYMMDD'),'_1.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + "_1.TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr36",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'MM.YYYY'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "MM.YYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr37",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'YYYYMMDD'),'_2.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + "_2.TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr38",
                "CONCAT('MOC ORGANICAS ', DATE_FORMAT((DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH),'MMMM'), ' ', DATE_FORMAT((DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH),'YY'), '.XLSX')",
                ctx -> "MOC ORGANICAS "
                        + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "MMMM")
                        + " "
                        + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YY")
                        + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr39",
                "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'DEF.XLSX')",
                ctx -> " " + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD-MM-YY") + "DEF.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr40",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL'))-1,'YYYY-MM-DD'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYY-MM-DD") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr41",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYY-MM-DD'),'.TXT')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYY-MM-DD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr42",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYYMMDD'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr43",
                "CONCAT('_',YEAR(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'.XLSX')",
                ctx -> "_" + ctx.today().getYear() + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr44",
                "CONCAT(\"_\",DATE_FORMAT(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_DATE(), 'AMERICA/GUAYAQUIL'), -1), 'YYYYMM'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYYMM") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr45",
                "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYYMMDD\"),\"_H_\",LPAD(SPLIT(ID_INGESTA, \"_\")[4],3,\"0\"),\".TXT\")",
                ctx -> {
                    String part = TextUtils.safeSplit(ctx.idIngesta(), "_", 4);
                    String padded = TextUtils.lpad(part, 3, "0");
                    return "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + "_H_" + padded + ".TXT";
                }
        ));
        definitions.add(new ExpressionDefinition(
                "expr46",
                "CONCAT(CASE WHEN CAST(HOUR(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) AS INT) < 12 THEN 1 ELSE 2 END,'_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'DDMMYYYY'),'.XLSX')",
                ctx -> {
                    int marker = ctx.now().getHour() < 12 ? 1 : 2;
                    return marker + "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "DDMMYYYY") + ".XLSX";
                }
        ));
        definitions.add(new ExpressionDefinition(
                "expr47",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYYMMDD'),'_0830.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + "_0830.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr48",
                ".GZ",
                ctx -> ".GZ"
        ));
        definitions.add(new ExpressionDefinition(
                "expr49",
                "CONCAT('_',YEAR(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), -1)),LPAD(MONTH(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), -1)), 2, '0'),'.XLSX')",
                ctx -> {
                    LocalDate priorMonth = ctx.today().minusMonths(1);
                    String month = TextUtils.lpad(String.valueOf(priorMonth.getMonthValue()), 2, "0");
                    return "_" + priorMonth.getYear() + month + ".XLSX";
                }
        ));
        definitions.add(new ExpressionDefinition(
                "expr50",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr51",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr52",
                "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYYMMDD\"),\"_L_\",LPAD(SPLIT(ID_INGESTA, \"_\")[6],3,\"0\"),\".TXT\")",
                ctx -> {
                    String part = TextUtils.safeSplit(ctx.idIngesta(), "_", 6);
                    String padded = TextUtils.lpad(part, 3, "0");
                    return "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + "_L_" + padded + ".TXT";
                }
        ));
        definitions.add(new ExpressionDefinition(
                "expr53",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr54",
                "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYY-MM-DD\"),\".ZIP\")",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYY-MM-DD") + ".ZIP"
        ));
        definitions.add(new ExpressionDefinition(
                "expr55",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'_TARDE','.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DDMMYYYY") + "_TARDE" + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr56",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'.TXT')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr57",
                "CONCAT(CAST(CAST(DATE_FORMAT(TO_TIMESTAMP(UNIX_TIMESTAMP(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) - (MINUTE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) % 15) * 60),'YYMMDDHHMM') AS BIGINT)- 10000 AS STRING),'.TXT')",
                ctx -> {
                    ZonedDateTime rounded = ctx.now().minusMinutes(ctx.now().getMinute() % 15L);
                    String base = DateTimeUtils.formatDateTime(rounded, "YYMMDDHHMM");
                    long value = Long.parseLong(base) - 10000L;
                    return value + ".TXT";
                }
        ));
        definitions.add(new ExpressionDefinition(
                "expr58",
                "CONCAT('_',CAST(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'))-1,'YYYY-MM-DD')  AS STRING),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYY-MM-DD") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr59",
                "CONCAT('_',DATE_FORMAT(DATE_ADD(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),-1),'DDMM'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DDMM") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr60",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'MMYYYY'),'.XLS')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "MMYYYY") + ".XLS"
        ));
        definitions.add(new ExpressionDefinition(
                "expr61",
                "CONCAT('_',DATE_FORMAT(DATE_ADD(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),-1),'DDMMYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DDMMYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr62",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYMMDD'),'.ZIP')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYMMDD") + ".ZIP"
        ));
        definitions.add(new ExpressionDefinition(
                "expr63",
                "CONCAT(DATE_FORMAT(LAST_DAY(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL') - INTERVAL 1 MONTH), 'DDMMYYYY'),'.ZIP')",
                ctx -> DateTimeUtils.formatDate(DateTimeUtils.lastDayOfMonth(ctx.today().minusMonths(1)), ctx.zone(), "DDMMYYYY") + ".ZIP"
        ));
        definitions.add(new ExpressionDefinition(
                "expr64",
                "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 MONTH,\"MMYY\"),\".XLSX\")",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "MMYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr65",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL') - INTERVAL 1 DAY),'YYYYMMDD'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr66",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'YYYYMMDD'),'_2.CSV')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + "_2.CSV"
        ));
        definitions.add(new ExpressionDefinition(
                "expr67",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'YYYYMMDD'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr68",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMM'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMM") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr69",
                "CONCAT(DATE_FORMAT(LAST_DAY(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH),'DDMMYYYY'),'.ACU')",
                ctx -> DateTimeUtils.formatDate(DateTimeUtils.lastDayOfMonth(ctx.today().minusMonths(1)), ctx.zone(), "DDMMYYYY") + ".ACU"
        ));
        definitions.add(new ExpressionDefinition(
                "expr70",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL') - INTERVAL 1 DAY),'YYYYMMDD'),'.XLS')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".XLS"
        ));
        definitions.add(new ExpressionDefinition(
                "expr71",
                "CONCAT(' (',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),').XLSX')",
                ctx -> " (" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD.MM.YYYY") + ").XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr72",
                "CONCAT('.',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -0 DAY,'YYYYMMDD'),'.TXT')",
                ctx -> "." + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr73",
                "CONCAT('_',DATE_FORMAT(LAST_DAY(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), - 1)),'DDMMYYYY'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(DateTimeUtils.lastDayOfMonth(ctx.today().minusMonths(1)), ctx.zone(), "DDMMYYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr74",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYYMM") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr75",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'.TXT')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr76",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'MMYYYY'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "MMYYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr77",
                "CONCAT('_', DATE_FORMAT(LAST_DAY(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH),'DDMMYYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(DateTimeUtils.lastDayOfMonth(ctx.today().minusMonths(1)), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr78",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) +INTERVAL-1 DAY,'YY'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr79",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL'))-1,'YYYY-MM-DD'),'.XLS')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYY-MM-DD") + ".XLS"
        ));
        definitions.add(new ExpressionDefinition(
                "expr80",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) + INTERVAL -30 DAY,'YYYYMM'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(30), ctx.zone(), "YYYYMM") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr81",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'.CSV')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYYMM") + ".CSV"
        ));
        definitions.add(new ExpressionDefinition(
                "expr82",
                "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'P3.XLSX')",
                ctx -> " " + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD-MM-YY") + "P3.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr83",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'DDMMYY'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "DDMMYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr84",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) +INTERVAL-1 DAY,'YYYYMMDD'),'.TXT')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr85",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr86",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'.ZIP')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYYMM") + ".ZIP"
        ));
        definitions.add(new ExpressionDefinition(
                "expr87",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'MM_YYYY'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "MM_YYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr88",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYY-MM-DD'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYY-MM-DD") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr89",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'MMYYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "MMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr90",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -0 DAY,'YYYYMM'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMM") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr91",
                "CONCAT('_',DATE_FORMAT(LAST_DAY(ADD_MONTHS(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')),-1)),'DDMMYYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(DateTimeUtils.lastDayOfMonth(ctx.today().minusMonths(1)), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr92",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'-F.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYYMM") + "-F.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr93",
                "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),'.XLSX')",
                ctx -> " " + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD.MM.YYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr94",
                "CONCAT('_',DATE_FORMAT(LAST_DAY(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), - 1)),'DDMMYYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(DateTimeUtils.lastDayOfMonth(ctx.today().minusMonths(1)), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr95",
                "CONCAT('_',DATE_FORMAT(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'),'MMYYYY'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "MMYYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr96",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), AMERICA/GUAYAQUIL)),MMYYYY),.XLSX)",
                ctx -> DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "MMYYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr97",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'_2.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + "_2.TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr98",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'YYYYMMDD'),'_1.CSV')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + "_1.CSV"
        ));
        definitions.add(new ExpressionDefinition(
                "expr99",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) +INTERVAL-1 DAY,'YYYY'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr100",
                "CONCAT(DATE_FORMAT(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'),'YYYYMM'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMM") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr101",
                "CONCAT('_',DATE_FORMAT(DATE_ADD(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),-1),'DDMMYYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr102",
                "CONCAT('_',DATE_FORMAT(DATE_ADD(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),-1),'YYYYMMDD'),'.CSV')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".CSV"
        ));
        definitions.add(new ExpressionDefinition(
                "expr103",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')+ INTERVAL -1 MONTH),'YYYY-MM'),'.CSV')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYY-MM") + ".CSV"
        ));
        definitions.add(new ExpressionDefinition(
                "expr104",
                "CONCAT( YEAR(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')), '.XLSX')",
                ctx -> ctx.today().getYear() + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr105",
                "CONCAT(DATE_FORMAT(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), 'YYMMDDHH'), LPAD(FLOOR(MINUTE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'))/15)*15, 2, '0'), '.TXT')",
                ctx -> {
                    ZonedDateTime now = ctx.now();
                    String prefix = DateTimeUtils.formatDateTime(now, "YYMMDDHH");
                    int rounded = (now.getMinute() / 15) * 15;
                    String padded = TextUtils.lpad(String.valueOf(rounded), 2, "0");
                    return prefix + padded + ".TXT";
                }
        ));
        definitions.add(new ExpressionDefinition(
                "expr106",
                "CONCAT(DATE_FORMAT(LAST_DAY(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), - 1)),'DDMMYYYY'),'.TXT')",
                ctx -> DateTimeUtils.formatDate(DateTimeUtils.lastDayOfMonth(ctx.today().minusMonths(1)), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr107",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYYMMDD'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr108",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) - INTERVAL 1 MONTH,'YYYYMM'),'.TXT')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYYMM") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr109",
                "CONCAT(\"_\",DATE_FORMAT(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_DATE(), 'AMERICA/GUAYAQUIL'), -1), 'YYYYMM'),\".XLSX\")",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYYMM") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr110",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'&_NEW.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + "&_NEW.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr111",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYYMMDD'),'_0930.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + "_0930.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr112",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "YYYYMM") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr113",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DDMMYYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr114",
                "CONCAT('_', DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY, 'YYYYMMDD'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYYMMDD") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr115",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) +INTERVAL-1 DAY,'YYYY'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr116",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'MMYYYY'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusMonths(1), ctx.zone(), "MMYYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr117",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'DD.MM.YYYY'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "DD.MM.YYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr118",
                "CONCAT(LPAD(DAY(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP, 'AMERICA/GUAYAQUIL')),2,'0'),LPAD(MONTH(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP, 'AMERICA/GUAYAQUIL')),2,'0'),YEAR(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP, 'AMERICA/GUAYAQUIL')),'.XLSX')",
                ctx -> {
                    LocalDate today = ctx.today();
                    String day = TextUtils.lpad(String.valueOf(today.getDayOfMonth()), 2, "0");
                    String month = TextUtils.lpad(String.valueOf(today.getMonthValue()), 2, "0");
                    return day + month + today.getYear() + ".XLSX";
                }
        ));
        definitions.add(new ExpressionDefinition(
                "expr119",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -0 DAY,'DD.MM.YYYY'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "DD.MM.YYYY") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr120",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYY'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr121",
                "CONCAT('_',CAST(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL'))-1,'YYYY-MM-DD')AS STRING),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYY-MM-DD") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr122",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYYMMDD'),'_0900.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYYMMDD") + "_0900.XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr123",
                "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'DEF.TXT')",
                ctx -> " " + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD-MM-YY") + "DEF.TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr124",
                "CONCAT('_', DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYY'),'.XLSX')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today(), ctx.zone(), "YYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr125",
                "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'.XLSX')",
                ctx -> " " + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "DD-MM-YY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr126",
                "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYY-MM-DD'),'.TXT')",
                ctx -> "_" + DateTimeUtils.formatDate(ctx.today().minusDays(1), ctx.zone(), "YYYY-MM-DD") + ".TXT"
        ));
        definitions.add(new ExpressionDefinition(
                "expr127",
                "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -2 MONTH,'MM_YYYY'),'.XLSX')",
                ctx -> DateTimeUtils.formatDate(ctx.today().minusMonths(2), ctx.zone(), "MM_YYYY") + ".XLSX"
        ));
        definitions.add(new ExpressionDefinition(
                "expr128",
                "CONCAT(DATE_FORMAT(LAST_DAY(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH),'DDMMYYYY'),'.TXT')",
                ctx -> DateTimeUtils.formatDate(DateTimeUtils.lastDayOfMonth(ctx.today().minusMonths(1)), ctx.zone(), "DDMMYYYY") + ".TXT"
        ));
        return definitions;
    }
}
