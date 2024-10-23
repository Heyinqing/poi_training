package com.cisdi.utils;

import com.cisdi.Enums.UploadFileEnum;
import com.cisdi.Enums.constant.UploadFileConstant;
import com.mysql.cj.util.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ObjectUtils;

import javax.servlet.ServletOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Heyinqing
 * @date 2024/7/30
 */
public class ExcelUtil {
    private static final String EXCEL2003L = ".xls";
    private static final String EXCEL2007U = ".xlsx";
    private static int FIRST_ROW_NUM = 1;
    private static int LAST_ROW_NUM = 100;
    private static int LENGTH_LIMIT_COL = 5;
    private static List<String[]> COM_BOX_LIST = new ArrayList<>(1);
    private static final String PROMPT_TEMPLATE = "第%s行的%s为空";

    public static void creat(HashMap<String, List<String>> limitCondition, List<String> totalName, ServletOutputStream outputStream) {

        // 创建 workbook
        SXSSFWorkbook workbook = new SXSSFWorkbook(-1);
        // 创建 sheet
        SXSSFSheet sheet = workbook.createSheet();
        // 设置自适应列宽
        sheet.setDefaultColumnWidth(0);
        // 创建样式实例
        CellStyle cellStyle = workbook.createCellStyle();
        // 设置前景颜色
        cellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 设置边框线类型
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        // 对齐方式
        // 水平对其方式
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 垂直对其方式
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // // 创建字体实例
        // Font font = workbook.createFont();
        // // 加出
        // font.setBold(true);
        // // 设置字体大小
        // font.setFontHeight((short) 18);
        // font.setFontName("仿宋");
        // // 载入字体实例
        // cellStyle.setFont(font);
        // 创建行、写入数据、增加样式
        Row row = sheet.createRow(0);
        for (int i = 0; i < totalName.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(totalName.get(i));
            if (null != cellStyle) {
                // 将设置的样式塞入单元格中
                cell.setCellStyle(cellStyle);
            }
        }
        /**
         * 3.增加数据校验（自定义）
         *   说明："=(ISTEXT(INDIRECT(\"F\"&ROW())) * (LENB(INDIRECT(\"F\"&ROW())) >= 1) * (LENB(INDIRECT(\"F\"&ROW())) <= 10))"
         *   是否为文本          ISTEXT(INDIRECT(\"F\"&ROW()))
         *   字节数大于等于0     (LENB(INDIRECT(\"F\"&ROW())) >= 0)
         *   字节数小于等于200   (LENB(INDIRECT(\"F\"&ROW())) <= 10))
         *   如果是字符长度，就是LEN() 取F列当前行值 INDIRECT("F"&ROW())
         */
        // setDataLengthLimit(sheet,"=((LENB(INDIRECT(\"F\"&ROW())) >= 1) * (LENB(INDIRECT(\"F\"&ROW())) <= 10))");
        setDataLengthLimit(sheet, "=(ISNUMBER(INDIRECT(\"F\"&ROW())) * (LENB(INDIRECT(\"F\"&ROW())) >= 0) * (LENB(INDIRECT(\"F\"&ROW())) <= 15))");

        /**
         * 4.设置下拉值
         */
        setPullBox(sheet, limitCondition);

        /**
         * 增加
         */
        save(workbook, outputStream);
    }


    /**
     * 保存
     *
     * @param workbook
     * @param outputStream
     */
    public static void save(Workbook workbook, ServletOutputStream outputStream) {
        FileOutputStream foss = null;
        try {
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!ObjectUtils.isEmpty(foss)) {
                try {
                    foss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * @description: 在Excel中设置下拉列表
     * key.charAt(0)-65 ASCII码计算
     * @param: sheet
     * @param: limitCondition
     * @return: void
     * @author Heyinqing
     * @date: 2024/8/1 15:24
     */
    private static void setPullBox(SXSSFSheet sheet, HashMap<String, List<String>> limitCondition) {

        for (String key : limitCondition.keySet()) {
            // 解析限制条件
            List<String> contentArr = limitCondition.get(key);
            // 对sheet页添加限制条件
            sheet.addValidationData(getPullDataValidation(contentArr.toArray(new String[0]), key.toString().charAt(0) - 65, sheet));
        }
    }

    /**
     * @description: 生成限制条件
     * @param: strFormula 限制条件
     * @param: firstCol 需要限制的列
     * @param: sheet 需要限制的sheet页
     * @return: org.apache.poi.xssf.usermodel.XSSFDataValidation
     * @author Heyinqing
     * @date: 2024/8/2 9:15
     */
    private static XSSFDataValidation getPullDataValidation(String[] strFormula, int firstCol, SXSSFSheet sheet) {
        // 选中该sheet页
        sheet.setSelected(true);
        // 创建下拉列表数据
        // 校验数据所在Sheet页的单元格
        DataValidationHelper helper = sheet.getDataValidationHelper();
        DataValidationConstraint constraint = helper.createExplicitListConstraint(strFormula);
        // 设置数据有效性加载在那个单元格上。四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList addressList = new CellRangeAddressList(FIRST_ROW_NUM, LAST_ROW_NUM, firstCol, firstCol);
        // 载入目标单元格以及校验数据
        XSSFDataValidation validation = (XSSFDataValidation) helper.createValidation(constraint, addressList);

        validation.createErrorBox("输入不合法", "请输入下拉列表中的值！");
        validation.createPromptBox("", null);
        validation.setShowErrorBox(Boolean.TRUE);
        return validation;
    }

    /**
     * @description: 设置列长度
     * @param: sheet sheet页
     * @param: cellCheck 条件
     * @return: void
     * @author Heyinqing
     * @date: 2024/7/31 14:53
     */
    private static void setDataLengthLimit(SXSSFSheet sheet, String cellCheck) {
        DataValidationHelper helper = sheet.getDataValidationHelper();
        // 设置涉及的行列
        CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(FIRST_ROW_NUM, LAST_ROW_NUM, LENGTH_LIMIT_COL, LENGTH_LIMIT_COL);
        // 设置规则
        DataValidationConstraint constraint = helper.createCustomConstraint(cellCheck);
        DataValidation validation = helper.createValidation(constraint, cellRangeAddressList);
        // 设置错误框的标题和内容
        validation.createErrorBox("输入不合法", "请输入正确的手机号格式(可输入0-15位)");
        // 是否允许存在空值
        validation.setEmptyCellAllowed(true);
        // 是否开启校验（启动输入无效值时的响应）
        validation.setShowErrorBox(true);
        sheet.addValidationData(validation);
    }

    /**
     * @description: 解析Excel文件
     * @param: inputStream 文件
     * @param: fileName 文件ming
     * @return: org.apache.poi.ss.usermodel.Workbook
     * @author Heyinqing
     * @date: 2024/8/5 11:18
     */
    public static Workbook getWorkBook(InputStream inputStream, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (EXCEL2003L.equals(fileType)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (EXCEL2007U.equals(fileType)) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            throw new Exception("解析文件格式有误！");
        }
        return workbook;
    }

    /**
     * @description: 拉取Excel中的数据
     * @param: workbook Excel表
     * @param: userEntities 数据集合
     * @param: wrongDate 异常集合
     * @return: void
     * @author Heyinqing
     * @date: 2024/8/5 11:20
     */
    public static Map<Integer, List<String>> getData(Workbook workbook) {
        Map<Integer, List<String>> map = new HashMap<>();
        Sheet sheet = null;
        StringBuilder titleName = new StringBuilder();
        Row row = null;
        Row titleRow = null;
        Cell cell = null;

        // 遍历sheet页
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            sheet = workbook.getSheetAt(i);
            // 判断sheet页是否为空
            if (sheet == null) {continue;}
            // sheet页名
            String sheetName = sheet.getSheetName();
            // 是否为有效sheet页
            UploadFileEnum valueByMassage = UploadFileEnum.getValueByMassage(sheetName);
            if (valueByMassage == null) {continue;}

            titleRow = sheet.getRow(0);
            List<String> sheetDate = new ArrayList<>();
            // 一级
            String mineralReserveType = "";
            // 二级
            String reserveQuantityType = "";
            /*
             * 遍历行
             * sheet.getFirstRowNum()开始行
             * sheet.getLastRowNum() 结束行
             */

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                if (valueByMassage.getValue()==2&&j==22){
                    j+=13;
                    continue;
                }

                StringBuilder rowData = new StringBuilder();
                String cellDate = "";
                row = sheet.getRow(j);
                if (row == null) {continue;}
                rowData.append(j + 1);
                // 遍历单元格
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    rowData.append(",");
                    cell = row.getCell(k);
                    // 必填项
                    if (cell == null) {
                        continue;
                    }
                    Object cellValue = ExcelUtil.getCellValue(cell);
                    if (cellValue == null) {
                        rowData.append("null");
                        continue;
                    }
                    if (valueByMassage.getValue()==1){
                        if (k == 0){
                            mineralReserveType = cellValue==""?mineralReserveType:cellValue.toString();
                            rowData.append(mineralReserveType);
                            continue;
                        }
                        if (k == 1){
                            reserveQuantityType = cellValue==""?reserveQuantityType:cellValue.toString();
                            rowData.append(reserveQuantityType);
                            continue;
                        }
                        if (k == 2){
                            rowData.append(cellValue==""?reserveQuantityType:cellValue.toString());
                            continue;
                        }
                    }
                    rowData.append(cellValue);
                }
                sheetDate.add(rowData.toString());
                rowData.delete(0, rowData.length());
            }
            map.put(valueByMassage.getValue(), sheetDate);
        }
        return map;
    }

    /**
     * @description: 校验数据类型
     * @param: cell 单元格
     * @return: java.lang.Object
     * @author Heyinqing
     * @date: 2024/8/5 11:18
     */
    public static Object getCellValue(Cell cell) {
        Object value = null;
        // 格式化Number String字符
        DecimalFormat numberStringFormat = new DecimalFormat("0");
        // 格式化数字
        DecimalFormat numberFormat = new DecimalFormat("0.00");
        System.out.println(cell.getCellType());
        System.out.println(cell);
        switch (cell.getCellType()) {
            case STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                String dateFormat = excelIsDate((int) cell.getCellStyle().getDataFormat());
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = numberStringFormat.format(cell.getNumericCellValue());
                } else if (!StringUtils.isNullOrEmpty(dateFormat)) {
                    value = new SimpleDateFormat(dateFormat).format(cell.getDateCellValue());
                } else {
                    value = numberFormat.format(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case BLANK:
                value = "";
                break;
            case FORMULA:
                try {
                    value = cell.getNumericCellValue();
                }catch (IllegalStateException e){
                    value = 0;
                }
                break;
            case ERROR:
                break;
            case _NONE:
        }
        return value;
    }

    public static String excelIsDate(Integer dataFormat){
        switch (dataFormat){
            case 14:
                return  "yyyy-MM-dd";
            case 20:
                return "HH:mm";
            case 21:
                return "HH:mm:ss";
            case 31:
                return "yyyy年MM月dd日";
            case 32:
                return "HH时mm分";
            case 33:
                return "HH时mm分mm秒";
            case 57:
                return "yyyy年MM月";
            case 58:
                return "MM月dd日";
            default:
                return null;
        }

    }
}
