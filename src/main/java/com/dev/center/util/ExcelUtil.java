package com.dev.center.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.dev.center.model.CarDownload;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static com.dev.center.util.Constants.COLUMNS;
import static com.dev.center.util.Constants.SHEET_NAME;

public class ExcelUtil {
    public static ByteArrayInputStream listToExcel(List<CarDownload> cars) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET_NAME);

            // Columns
            Row headerRow = sheet.createRow(0);

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);

            // Setting Background color
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setFont(headerFont);
            cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);

            for (int col = 0; col < COLUMNS.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(COLUMNS[col]);
            }

            int rowIdx = 1;
            for (CarDownload car : cars) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(car.getCarId());
                row.createCell(1).setCellValue(car.getModel());
                row.createCell(2).setCellValue(car.getColor());
                row.createCell(3).setCellValue(car.getBrandId());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Failed to export file: " + e.getMessage());
        }
    }
}
