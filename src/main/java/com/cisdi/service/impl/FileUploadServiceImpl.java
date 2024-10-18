package com.cisdi.service.impl;

import com.cisdi.service.*;
import com.cisdi.utils.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Heyinqing
 * @date 2024/10/10
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {


    @Resource
    private MccccOpResourceService mccccOpResourceService;

    @Resource
    private MccccOpMonthYieldService mccccOpMonthYieldService;

    @Resource
    private MccccOpTechEconIndicatorsService techEconIndicatorsService;

    @Resource
    private MccccOpMaterialConsumptionService materialConsumptionService;

    @Resource
    private MccccOpCostAnalysisService costAnalysisService;

    @Resource
    private MccccOpFinanceService financeService;

    @Resource
    private MccccOpHumanResourceService humanResourceService;

    @Override
    public int resourceUploading(InputStream inputStream, String fileName) throws Exception {
        Workbook workBook = ExcelUtil.getWorkBook(inputStream, fileName);
        Map<Integer, List<String>> data = ExcelUtil.getData(workBook);
        data.forEach(this::fileDataProcessing);
        return 0;
    }

    public void fileDataProcessing(Integer key,List<String> val) {
        try {
            switch (key){
                case 1:
                    mccccOpResourceService.fileDataProcessing(val);
                    break;
                case 2:
                    mccccOpMonthYieldService.fileDataProcessing(val);
                    break;
                case 3:
                    techEconIndicatorsService.fileDataProcessing(val);
                    break;
                case 4:
                    materialConsumptionService.fileDataProcessing(val);
                    break;
                case 5:
                    costAnalysisService.fileDataProcessing(val);
                    break;
                case 6:
                    financeService.fileDataProcessing(val);
                    break;
                case 8:
                    humanResourceService.fileDataProcessing(val);
                    break;

            }
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }

    }


}
