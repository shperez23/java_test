package com.example.expressions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ExpressionCatalog {
    private static final List<ExpressionTemplateDefinition> TEMPLATE_DEFINITIONS = List.of(
            ExpressionTemplateDefinition.of(
                    "expr01",
                    "CONCAT(DATE_FORMAT(DATE(LAST_DAY(DATE_ADD(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), -DAY(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'))))),'DDMMYYYY'),'.ZIP')",
                    "${date:format=DDMMYYYY:months=-1:lastDayOfMonth=true}.ZIP"
            ),
            ExpressionTemplateDefinition.of(
                    "expr02",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'DDMMYYYY'),'.XLSX')",
                    "${date:format=DDMMYYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr03",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL') - INTERVAL 1 DAY),'YYYYMMDD'),'_CXC_BANCS.XLS')",
                    "_${date:format=YYYYMMDD:days=-1}_CXC_BANCS.XLS"
            ),
            ExpressionTemplateDefinition.of(
                    "expr04",
                    "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'P2.XLSX')",
                    " ${date:format=DD-MM-YY:days=-1}P2.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr05",
                    "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYYMMDD\"),\"_L_\",LPAD(SPLIT(ID_INGESTA, \"_\")[4],3,\"0\"),\".TXT\")",
                    "_${date:format=YYYYMMDD:days=-1}_L_${id:idx=4:pad=3}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr06",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYMMDD'),'.TXT')",
                    "${date:format=YYMMDD:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr07",
                    "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'P1.XLSX')",
                    " ${date:format=DD-MM-YY:days=-1}P1.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr08",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'.TXT')",
                    "_${date:format=YYYYMMDD:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr09",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'DDMMYYYY'),'.TXT')",
                    "_${date:format=DDMMYYYY}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr10",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'DDMMYYYY'),'.TXT')",
                    "_${date:format=DDMMYYYY}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr11",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'_1.TXT')",
                    "_${date:format=YYYYMMDD:days=-1}_1.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr12",
                    "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 MONTH,\"YYYY_MM\"),\".XLSM\")",
                    "_${date:format=YYYY_MM:months=-1}.XLSM"
            ),
            ExpressionTemplateDefinition.of(
                    "expr13",
                    "CONCAT(' (',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),') CIERRE DE MES.XLSX')",
                    " (${date:format=DD.MM.YYYY:days=-1}) CIERRE DE MES.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr14",
                    "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),' CIERRE DE MES.XLSX')",
                    " ${date:format=DD.MM.YYYY:days=-1} CIERRE DE MES.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr15",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),'.TXT')",
                    "_${date:format=DD.MM.YYYY:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr16",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) +INTERVAL-1 DAY,'DDMMYYYY'),'.TXT')",
                    "_${date:format=DDMMYYYY:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr17",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -0 DAY,'DD-MM-YYYY'),'.TXT')",
                    "_${date:format=DD-MM-YYYY}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr18",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'MMDD'),'.ZIP')",
                    "${date:format=MMDD:days=-1}.ZIP"
            ),
            ExpressionTemplateDefinition.of(
                    "expr19",
                    "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'.XLSX')",
                    "_${date:format=DDMMYYYY:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr20",
                    "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 MONTH,\"YYYY_MM\"),\".XLS\")",
                    "_${date:format=YYYY_MM:months=-1}.XLS"
            ),
            ExpressionTemplateDefinition.of(
                    "expr21",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -0 DAY,'YYYYMMDD'),'.CSV')",
                    "_${date:format=YYYYMMDD}.CSV"
            ),
            ExpressionTemplateDefinition.of(
                    "expr22",
                    "CONCAT('_',DATE_FORMAT(DATE_ADD(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),-1),'YYYYMMDD'),'.TXT')",
                    "_${date:format=YYYYMMDD:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr23",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYYMMDD\"),\".TXT\")",
                    "${date:format=YYYYMMDD:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr24",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'_DEFINITIVO_.XLSX')",
                    "${date:format=DDMMYYYY:days=-1}_DEFINITIVO_.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr25",
                    "CONCAT(DATE_FORMAT(DATE(TRUNC(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), 'YYYY') ) + INTERVAL -1 YEAR,'YYYY'), '.XLSX')",
                    "${date:format=YYYY:startOfYear=true:years=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr26",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'.XLSX')",
                    "_${date:format=YYYYMM:months=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr27",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'.CSV')",
                    "_${date:format=YYYYMMDD:days=-1}.CSV"
            ),
            ExpressionTemplateDefinition.of(
                    "expr28",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'.TXT')",
                    "_${date:format=DDMMYYYY:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr29",
                    "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYYMMDD\"),\"_H_\",LPAD(SPLIT(ID_INGESTA, \"_\")[6],3,\"0\"),\".TXT\")",
                    "_${date:format=YYYYMMDD:days=-1}_H_${id:idx=6:pad=3}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr30",
                    "CONCAT('-',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMM'),'01.TXT')",
                    "-${date:format=YYYYMM:days=-1}01.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr31",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),'.TXT')",
                    "_${date:format=DD.MM.YYYY:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr32",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 YEAR,'YYYY'),'.TXT')",
                    "_${date:format=YYYY:years=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr33",
                    "CONCAT('_', DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')),'YYYY'),'.XLSX')",
                    "_${date:format=YYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr34",
                    "CONCAT('_', DATE_FORMAT(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), -1), 'YYYYMM'), '.XLSX')",
                    "_${date:format=YYYYMM:months=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr35",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'YYYYMMDD'),'_1.TXT')",
                    "_${date:format=YYYYMMDD}_1.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr36",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'MM.YYYY'),'.XLSX')",
                    "_${date:format=MM.YYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr37",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'YYYYMMDD'),'_2.TXT')",
                    "_${date:format=YYYYMMDD}_2.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr38",
                    "CONCAT('MOC ORGANICAS ', DATE_FORMAT((DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH),'MMMM'), ' ', DATE_FORMAT((DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH),'YY'), '.XLSX')",
                    "MOC ORGANICAS ${date:format=MMMM:months=-1} ${date:format=YY:months=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr39",
                    "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'DEF.XLSX')",
                    " ${date:format=DD-MM-YY:days=-1}DEF.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr40",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL'))-1,'YYYY-MM-DD'),'.XLSX')",
                    "${date:format=YYYY-MM-DD:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr41",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYY-MM-DD'),'.TXT')",
                    "${date:format=YYYY-MM-DD:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr42",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYYMMDD'),'.TXT')",
                    "_${date:format=YYYYMMDD}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr43",
                    "CONCAT('_',YEAR(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'.XLSX')",
                    "_${date:format=YYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr44",
                    "CONCAT(\"_\",DATE_FORMAT(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_DATE(), 'AMERICA/GUAYAQUIL'), -1), 'YYYYMM'),'.XLSX')",
                    "_${date:format=YYYYMM:months=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr45",
                    "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYYMMDD\"),\"_H_\",LPAD(SPLIT(ID_INGESTA, \"_\")[4],3,\"0\"),\".TXT\")",
                    "_${date:format=YYYYMMDD:days=-1}_H_${id:idx=4:pad=3}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr46",
                    "CONCAT(CASE WHEN CAST(HOUR(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) AS INT) < 12 THEN 1 ELSE 2 END,'_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'DDMMYYYY'),'.XLSX')",
                    "${hourMarker}_${date:format=DDMMYYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr47",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYYMMDD'),'_0830.XLSX')",
                    "${date:format=YYYYMMDD}_0830.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr48",
                    ".GZ",
                    ".GZ"
            ),
            ExpressionTemplateDefinition.of(
                    "expr49",
                    "CONCAT('_',YEAR(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), -1)),LPAD(MONTH(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), -1)), 2, '0'),'.XLSX')",
                    "_${date:format=YYYYMM:months=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr50",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'.XLSX')",
                    "_${date:format=YYYYMMDD:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr51",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYY'),'.TXT')",
                    "_${date:format=YYYY}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr52",
                    "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYYMMDD\"),\"_L_\",LPAD(SPLIT(ID_INGESTA, \"_\")[6],3,\"0\"),\".TXT\")",
                    "_${date:format=YYYYMMDD:days=-1}_L_${id:idx=6:pad=3}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr53",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'.TXT')",
                    "_${date:format=DDMMYYYY:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr54",
                    "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 DAY,\"YYYY-MM-DD\"),\".ZIP\")",
                    "_${date:format=YYYY-MM-DD:days=-1}.ZIP"
            ),
            ExpressionTemplateDefinition.of(
                    "expr55",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'_TARDE','.TXT')",
                    "_${date:format=DDMMYYYY:days=-1}_TARDE.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr56",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'.TXT')",
                    "${date:format=YYYYMMDD:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr57",
                    "CONCAT(CAST(CAST(DATE_FORMAT(TO_TIMESTAMP(UNIX_TIMESTAMP(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) - (MINUTE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) % 15) * 60),'YYMMDDHHMM') AS BIGINT)- 10000 AS STRING),'.TXT')",
                    "${roundedTimeMinus:interval=15:format=YYMMDDHHMM:minus=10000}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr58",
                    "CONCAT('_',CAST(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'))-1,'YYYY-MM-DD')  AS STRING),'.XLSX')",
                    "_${date:format=YYYY-MM-DD:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr59",
                    "CONCAT('_',DATE_FORMAT(DATE_ADD(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),-1),'DDMM'),'.TXT')",
                    "_${date:format=DDMM:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr60",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'MMYYYY'),'.XLS')",
                    "_${date:format=MMYYYY:months=-1}.XLS"
            ),
            ExpressionTemplateDefinition.of(
                    "expr61",
                    "CONCAT('_',DATE_FORMAT(DATE_ADD(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),-1),'DDMMYY'),'.TXT')",
                    "_${date:format=DDMMYY:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr62",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYMMDD'),'.ZIP')",
                    "_${date:format=YYMMDD:days=-1}.ZIP"
            ),
            ExpressionTemplateDefinition.of(
                    "expr63",
                    "CONCAT(DATE_FORMAT(LAST_DAY(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL') - INTERVAL 1 MONTH), 'DDMMYYYY'),'.ZIP')",
                    "${date:format=DDMMYYYY:months=-1:lastDayOfMonth=true}.ZIP"
            ),
            ExpressionTemplateDefinition.of(
                    "expr64",
                    "CONCAT(\"_\",DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), \"AMERICA/GUAYAQUIL\")) + INTERVAL -1 MONTH,\"MMYY\"),\".XLSX\")",
                    "_${date:format=MMYY:months=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr65",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL') - INTERVAL 1 DAY),'YYYYMMDD'),'.TXT')",
                    "_${date:format=YYYYMMDD:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr66",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'YYYYMMDD'),'_2.CSV')",
                    "_${date:format=YYYYMMDD}_2.CSV"
            ),
            ExpressionTemplateDefinition.of(
                    "expr67",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'YYYYMMDD'),'.TXT')",
                    "_${date:format=YYYYMMDD}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr68",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMM'),'.XLSX')",
                    "${date:format=YYYYMM:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr69",
                    "CONCAT(DATE_FORMAT(LAST_DAY(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH),'DDMMYYYY'),'.ACU')",
                    "${date:format=DDMMYYYY:months=-1:lastDayOfMonth=true}.ACU"
            ),
            ExpressionTemplateDefinition.of(
                    "expr70",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL') - INTERVAL 1 DAY),'YYYYMMDD'),'.XLS')",
                    "_${date:format=YYYYMMDD:days=-1}.XLS"
            ),
            ExpressionTemplateDefinition.of(
                    "expr71",
                    "CONCAT(' (',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),').XLSX')",
                    " (${date:format=DD.MM.YYYY:days=-1}).XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr72",
                    "CONCAT('.',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -0 DAY,'YYYYMMDD'),'.TXT')",
                    ".${date:format=YYYYMMDD}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr73",
                    "CONCAT('_',DATE_FORMAT(LAST_DAY(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), - 1)),'DDMMYYYY'),'.XLSX')",
                    "_${date:format=DDMMYYYY:months=-1:lastDayOfMonth=true}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr74",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'.XLSX')",
                    "_${date:format=YYYYMM:months=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr75",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'.TXT')",
                    "${date:format=DDMMYYYY:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr76",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'MMYYYY'),'.XLSX')",
                    "_${date:format=MMYYYY:months=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr77",
                    "CONCAT('_', DATE_FORMAT(LAST_DAY(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH),'DDMMYYYY'),'.TXT')",
                    "_${date:format=DDMMYYYY:months=-1:lastDayOfMonth=true}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr78",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) +INTERVAL-1 DAY,'YY'),'.XLSX')",
                    "_${date:format=YY:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr79",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL'))-1,'YYYY-MM-DD'),'.XLS')",
                    "${date:format=YYYY-MM-DD:days=-1}.XLS"
            ),
            ExpressionTemplateDefinition.of(
                    "expr80",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) + INTERVAL -30 DAY,'YYYYMM'),'.TXT')",
                    "_${date:format=YYYYMM:days=-30}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr81",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'.CSV')",
                    "${date:format=YYYYMM:months=-1}.CSV"
            ),
            ExpressionTemplateDefinition.of(
                    "expr82",
                    "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'P3.XLSX')",
                    " ${date:format=DD-MM-YY:days=-1}P3.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr83",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'DDMMYY'),'.XLSX')",
                    "${date:format=DDMMYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr84",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) +INTERVAL-1 DAY,'YYYYMMDD'),'.TXT')",
                    "${date:format=YYYYMMDD:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr85",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'.XLSX')",
                    "${date:format=YYYYMMDD:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr86",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'.ZIP')",
                    "_${date:format=YYYYMM:months=-1}.ZIP"
            ),
            ExpressionTemplateDefinition.of(
                    "expr87",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'MM_YYYY'),'.XLSX')",
                    "${date:format=MM_YYYY:months=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr88",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYY-MM-DD'),'.XLSX')",
                    "_${date:format=YYYY-MM-DD:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr89",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'MMYYYY'),'.TXT')",
                    "_${date:format=MMYYYY:months=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr90",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -0 DAY,'YYYYMM'),'.TXT')",
                    "_${date:format=YYYYMM}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr91",
                    "CONCAT('_',DATE_FORMAT(LAST_DAY(ADD_MONTHS(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')),-1)),'DDMMYYYY'),'.TXT')",
                    "_${date:format=DDMMYYYY:months=-1:lastDayOfMonth=true}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr92",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'-F.XLSX')",
                    "_${date:format=YYYYMM:months=-1}-F.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr93",
                    "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD.MM.YYYY'),'.XLSX')",
                    " ${date:format=DD.MM.YYYY:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr94",
                    "CONCAT('_',DATE_FORMAT(LAST_DAY(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), - 1)),'DDMMYYYY'),'.TXT')",
                    "_${date:format=DDMMYYYY:months=-1:lastDayOfMonth=true}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr95",
                    "CONCAT('_',DATE_FORMAT(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'),'MMYYYY'),'.XLSX')",
                    "_${date:format=MMYYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr96",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), AMERICA/GUAYAQUIL)),MMYYYY),.XLSX)",
                    "${date:format=MMYYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr97",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'_2.TXT')",
                    "_${date:format=YYYYMMDD:days=-1}_2.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr98",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL 0 DAY,'YYYYMMDD'),'_1.CSV')",
                    "_${date:format=YYYYMMDD}_1.CSV"
            ),
            ExpressionTemplateDefinition.of(
                    "expr99",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) +INTERVAL-1 DAY,'YYYY'),'.XLSX')",
                    "_${date:format=YYYY:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr100",
                    "CONCAT(DATE_FORMAT(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'),'YYYYMM'),'.XLSX')",
                    "${date:format=YYYYMM}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr101",
                    "CONCAT('_',DATE_FORMAT(DATE_ADD(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),-1),'DDMMYYYY'),'.TXT')",
                    "_${date:format=DDMMYYYY:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr102",
                    "CONCAT('_',DATE_FORMAT(DATE_ADD(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),-1),'YYYYMMDD'),'.CSV')",
                    "_${date:format=YYYYMMDD:days=-1}.CSV"
            ),
            ExpressionTemplateDefinition.of(
                    "expr103",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')+ INTERVAL -1 MONTH),'YYYY-MM'),'.CSV')",
                    "${date:format=YYYY-MM:months=-1}.CSV"
            ),
            ExpressionTemplateDefinition.of(
                    "expr104",
                    "CONCAT( YEAR(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')), '.XLSX')",
                    "${date:format=YYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr105",
                    "CONCAT(DATE_FORMAT(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), 'YYMMDDHH'), LPAD(FLOOR(MINUTE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'))/15)*15, 2, '0'), '.TXT')",
                    "${time:format=YYMMDDHH}${roundedMinute:interval=15:pad=2}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr106",
                    "CONCAT(DATE_FORMAT(LAST_DAY(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL'), - 1)),'DDMMYYYY'),'.TXT')",
                    "${date:format=DDMMYYYY:months=-1:lastDayOfMonth=true}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr107",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYYMMDD'),'.XLSX')",
                    "${date:format=YYYYMMDD}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr108",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) - INTERVAL 1 MONTH,'YYYYMM'),'.TXT')",
                    "${date:format=YYYYMM:months=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr109",
                    "CONCAT(\"_\",DATE_FORMAT(ADD_MONTHS(FROM_UTC_TIMESTAMP(CURRENT_DATE(), 'AMERICA/GUAYAQUIL'), -1), 'YYYYMM'),\".XLSX\")",
                    "_${date:format=YYYYMM:months=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr110",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYYMMDD'),'&_NEW.XLSX')",
                    "_${date:format=YYYYMMDD:days=-1}&_NEW.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr111",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYYMMDD'),'_0930.XLSX')",
                    "${date:format=YYYYMMDD}_0930.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr112",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'YYYYMM'),'.TXT')",
                    "_${date:format=YYYYMM:months=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr113",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DDMMYYYY'),'.XLSX')",
                    "${date:format=DDMMYYYY:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr114",
                    "CONCAT('_', DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY, 'YYYYMMDD'),'.XLSX')",
                    "_${date:format=YYYYMMDD:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr115",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) +INTERVAL-1 DAY,'YYYY'),'.XLSX')",
                    "${date:format=YYYY:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr116",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH,'MMYYYY'),'.XLSX')",
                    "${date:format=MMYYYY:months=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr117",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'DD.MM.YYYY'),'.XLSX')",
                    "_${date:format=DD.MM.YYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr118",
                    "CONCAT(LPAD(DAY(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP, 'AMERICA/GUAYAQUIL')),2,'0'),LPAD(MONTH(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP, 'AMERICA/GUAYAQUIL')),2,'0'),YEAR(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP, 'AMERICA/GUAYAQUIL')),'.XLSX')",
                    "${date:format=DDMMYYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr119",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -0 DAY,'DD.MM.YYYY'),'.TXT')",
                    "_${date:format=DD.MM.YYYY}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr120",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYY'),'.XLSX')",
                    "${date:format=YYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr121",
                    "CONCAT('_',CAST(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(),'AMERICA/GUAYAQUIL'))-1,'YYYY-MM-DD')AS STRING),'.XLSX')",
                    "_${date:format=YYYY-MM-DD:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr122",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYYMMDD'),'_0900.XLSX')",
                    "${date:format=YYYYMMDD}_0900.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr123",
                    "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'DEF.TXT')",
                    " ${date:format=DD-MM-YY:days=-1}DEF.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr124",
                    "CONCAT('_', DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')),'YYYY'),'.XLSX')",
                    "_${date:format=YYYY}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr125",
                    "CONCAT(' ',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'DD-MM-YY'),'.XLSX')",
                    " ${date:format=DD-MM-YY:days=-1}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr126",
                    "CONCAT('_',DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 DAY,'YYYY-MM-DD'),'.TXT')",
                    "_${date:format=YYYY-MM-DD:days=-1}.TXT"
            ),
            ExpressionTemplateDefinition.of(
                    "expr127",
                    "CONCAT(DATE_FORMAT(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -2 MONTH,'MM_YYYY'),'.XLSX')",
                    "${date:format=MM_YYYY:months=-2}.XLSX"
            ),
            ExpressionTemplateDefinition.of(
                    "expr128",
                    "CONCAT(DATE_FORMAT(LAST_DAY(DATE(FROM_UTC_TIMESTAMP(CURRENT_TIMESTAMP(), 'AMERICA/GUAYAQUIL')) + INTERVAL -1 MONTH),'DDMMYYYY'),'.TXT')",
                    "${date:format=DDMMYYYY:months=-1:lastDayOfMonth=true}.TXT"
            )
    );

    private ExpressionCatalog() {
    }

    public static List<ExpressionDefinition> definitions() {
        List<ExpressionDefinition> definitions = new ArrayList<>();
        for (ExpressionTemplateDefinition templateDefinition : TEMPLATE_DEFINITIONS) {
            definitions.add(templateDefinition.toDefinition());
        }
        return definitions;
    }

    public static List<ExpressionDefinition> definitions(Connection connection) throws SQLException {
        String query = """
                SELECT id_ingesta, nombre_archivo, nombre_archivo_variable
                FROM public.cat_ingesta_archivo
                WHERE nombre_archivo_variable IS NOT NULL
                  AND nombre_archivo_variable <> ''
                ORDER BY grupo_ingesta, orden_grupo, id_ingesta
                """;
        List<ExpressionDefinition> definitions = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String sql = resultSet.getString("nombre_archivo_variable");
                if (sql == null || sql.isBlank()) {
                    continue;
                }
                String idIngesta = resultSet.getString("id_ingesta");
                String nombreArchivo = resultSet.getString("nombre_archivo");
                String name = buildName(idIngesta, nombreArchivo);
                ExpressionTemplate expressionTemplate = resolveTemplate(sql);
                definitions.add(new ExpressionDefinition(name, sql, expressionTemplate::render));
            }
        }
        return definitions;
    }

    private static ExpressionTemplate resolveTemplate(String sql) {
        if (sql.contains("${")) {
            return new ExpressionTemplate(sql);
        }
        String normalizedSql = normalizeSql(sql);
        for (ExpressionTemplateDefinition templateDefinition : TEMPLATE_DEFINITIONS) {
            if (normalizedSql.equals(normalizeSql(templateDefinition.sql()))) {
                return templateDefinition.template();
            }
        }
        return new ExpressionTemplate(sql);
    }

    private static String normalizeSql(String sql) {
        return sql == null ? "" : sql.replaceAll("\\s+", "").toLowerCase();
    }

    private static String buildName(String idIngesta, String nombreArchivo) {
        if (nombreArchivo == null || nombreArchivo.isBlank()) {
            return idIngesta;
        }
        return idIngesta + " - " + nombreArchivo;
    }
}
