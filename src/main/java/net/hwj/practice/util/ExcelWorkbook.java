package net.hwj.practice.util;//package net.hwj.practice.util;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//
//import java.util.List;
//
//public class ExcelWorkbook {
//    public static Workbook makeWorkbook(List<RequestedAddressDto> requestedAddressDtos) {
//
//        Workbook workbook = new SXSSFWorkbook();
//        Sheet sheet = workbook.createSheet("RequestedAddress");
//
//        int rowIndex = 2;
//        Row headerRow = sheet.createRow(rowIndex++);
//        Cell headerCell1 = headerRow.createCell(0);
//        headerCell1.setCellValue("주소신청아이디");
//        //Cell headerCell2 = headerRow.createCell(1);
//        //headerCell2.setCellValue("타입");
//        Cell headerCell3 = headerRow.createCell(1);
//        headerCell3.setCellValue("GDSK건물코드");
//        Cell headerCell4 = headerRow.createCell(2);
//        headerCell4.setCellValue("상가업소번호");
//        Cell headerCell5 = headerRow.createCell(3);
//        headerCell5.setCellValue("건물관리번호");
//        Cell headerCell6 = headerRow.createCell(4);
//        headerCell6.setCellValue("법정동주소");
//        Cell headerCell7 = headerRow.createCell(5);
//        headerCell7.setCellValue("광역명");
//        Cell headerCell8 = headerRow.createCell(6);
//        headerCell8.setCellValue("시군구명");
//        Cell headerCell9 = headerRow.createCell(7);
//        headerCell9.setCellValue("읍면동명");
//        Cell headerCell10 = headerRow.createCell(8);
//        headerCell10.setCellValue("리명");
//        Cell headerCell11 = headerRow.createCell(9);
//        headerCell11.setCellValue("도로코드");
//        Cell headerCell12 = headerRow.createCell(10);
//        headerCell12.setCellValue("도로명");
//        Cell headerCell13 = headerRow.createCell(11);
//        headerCell13.setCellValue("건물본번");
//        Cell headerCell14 = headerRow.createCell(12);
//        headerCell14.setCellValue("건물부번");
//        Cell headerCell15 = headerRow.createCell(13);
//        headerCell15.setCellValue("지번본번");
//        Cell headerCell16 = headerRow.createCell(14);
//        headerCell16.setCellValue("지번부번");
//        Cell headerCell17 = headerRow.createCell(15);
//        headerCell17.setCellValue("우편번호");
//        Cell headerCell18 = headerRow.createCell(16);
//        headerCell18.setCellValue("건물명");
//        Cell headerCell19 = headerRow.createCell(17);
//        headerCell19.setCellValue("공동주택 동");
//        Cell headerCell20 = headerRow.createCell(18);
//        headerCell20.setCellValue("공동주택 호");
//        Cell headerCell21 = headerRow.createCell(19);
//        headerCell21.setCellValue("상호명");
//        Cell headerCell22 = headerRow.createCell(20);
//        headerCell22.setCellValue("지점명");
//        Cell headerCell23 = headerRow.createCell(21);
//        headerCell23.setCellValue("통상집중국번호");
//        Cell headerCell24 = headerRow.createCell(22);
//        headerCell24.setCellValue("통상집중국명");
//        Cell headerCell25 = headerRow.createCell(23);
//        headerCell25.setCellValue("통상배달국번호");
//        Cell headerCell26 = headerRow.createCell(24);
//        headerCell26.setCellValue("통상배달국명");
//        Cell headerCell27 = headerRow.createCell(25);
//        headerCell27.setCellValue("통상집배팀번호");
//        Cell headerCell28 = headerRow.createCell(26);
//        headerCell28.setCellValue("통상집배구번호");
//
//
//        // 바디에 데이터를 넣어줍니다
//        for (RequestedAddressDto requestedAddressDto : requestedAddressDtos) {
//            Row bodyRow = sheet.createRow(rowIndex++);
//
//            Cell bodyCell1 = bodyRow.createCell(0);
//            bodyCell1.setCellValue(requestedAddressDto.getRequestId());
//            //Cell bodyCell2 = bodyRow.createCell(1);
//            //char Type =  requestedAddressDto.getType();
//            //String type = Character.toString(Type);
//            //bodyCell2.setCellValue(type);
//            Cell bodyCell3 = bodyRow.createCell(1);
//            bodyCell3.setCellValue(requestedAddressDto.getCpxCd());
//            Cell bodyCell4 = bodyRow.createCell(2);
//            bodyCell4.setCellValue(requestedAddressDto.getComNo());
//            Cell bodyCell5 = bodyRow.createCell(3);
//            bodyCell5.setCellValue(requestedAddressDto.getBldMngNo());
//            Cell bodyCell6 = bodyRow.createCell(4);
//            bodyCell6.setCellValue(requestedAddressDto.getBDngCd());
//            Cell bodyCell7 = bodyRow.createCell(5);
//            bodyCell7.setCellValue(requestedAddressDto.getDoNm());
//            Cell bodyCell8 = bodyRow.createCell(6);
//            bodyCell8.setCellValue(requestedAddressDto.getCtNm());
//            Cell bodyCell9 = bodyRow.createCell(7);
//            bodyCell9.setCellValue(requestedAddressDto.getBDngNm());
//            Cell bodyCell10 = bodyRow.createCell(8);
//            bodyCell10.setCellValue(requestedAddressDto.getBRiNm());
//            Cell bodyCell11 = bodyRow.createCell(9);
//            bodyCell11.setCellValue(requestedAddressDto.getRdCd());
//            Cell bodyCell12 = bodyRow.createCell(10);
//            bodyCell12.setCellValue(requestedAddressDto.getRdNm());
//            Cell bodyCell13 = bodyRow.createCell(11);
//            bodyCell13.setCellValue(requestedAddressDto.getBldMb());
//            Cell bodyCell14 = bodyRow.createCell(12);
//            bodyCell14.setCellValue(requestedAddressDto.getBldSb());
//            Cell bodyCell15 = bodyRow.createCell(13);
//            bodyCell15.setCellValue(requestedAddressDto.getLotMb());
//            Cell bodyCell16 = bodyRow.createCell(14);
//            bodyCell16.setCellValue(requestedAddressDto.getLotSb());
//            Cell bodyCell17 = bodyRow.createCell(15);
//            bodyCell17.setCellValue(requestedAddressDto.getBasId());
//            Cell bodyCell18 = bodyRow.createCell(16);
//            bodyCell18.setCellValue(requestedAddressDto.getBldNm());
//            Cell bodyCell19 = bodyRow.createCell(17);
//            bodyCell19.setCellValue(requestedAddressDto.getBldDng());
//            Cell bodyCell20 = bodyRow.createCell(18);
//            bodyCell20.setCellValue(requestedAddressDto.getBldHo());
//            Cell bodyCell21 = bodyRow.createCell(19);
//            bodyCell21.setCellValue(requestedAddressDto.getComNm());
//            Cell bodyCell22 = bodyRow.createCell(20);
//            bodyCell22.setCellValue(requestedAddressDto.getJijumNm());
//            Cell bodyCell23 = bodyRow.createCell(21);
//            bodyCell23.setCellValue(requestedAddressDto.getDlv_g_cct_cd());
//            Cell bodyCell24 = bodyRow.createCell(22);
//            bodyCell24.setCellValue(requestedAddressDto.getDlv_g_cct_nm());
//            Cell bodyCell25 = bodyRow.createCell(23);
//            bodyCell25.setCellValue(requestedAddressDto.getDlv_g_office_cd());
//            Cell bodyCell26 = bodyRow.createCell(24);
//            bodyCell26.setCellValue(requestedAddressDto.getDlv_g_office_nm());
//            Cell bodyCell27 = bodyRow.createCell(25);
//            bodyCell27.setCellValue(requestedAddressDto.getDlv_g_team_cd());
//            Cell bodyCell28 = bodyRow.createCell(26);
//            bodyCell28.setCellValue(requestedAddressDto.getDlv_g_area_cd());
//
//
//        }
//        return workbook;
//    }
//
//}
