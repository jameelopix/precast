package com.vme.precast.financialdetail.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.financialdetail.api.FinancialDetailDTO;
import com.vme.precast.financialdetail.api.FinancialDetailService;
import com.vme.precast.financialdetail.api.FinancialDetailServiceRequest;
import com.vme.precast.financialdetail.api.FinancialDetailServiceResponse;

@Controller
public class FinancialDetailController {

    @Autowired
    FinancialDetailService financialDetailService;

    @RequestMapping(value = "deleteFinancialDetail", method = RequestMethod.POST)
    @ResponseBody
    public FinancialDetailClientModel deleteFinancialDetail(@RequestBody FinancialDetailClientModel financialDetailClientModel) {
        FinancialDetailServiceRequest financialDetailServiceRequest = new FinancialDetailServiceRequest();
        for (Long id : financialDetailClientModel.getIdsToDelete()) {
            FinancialDetailDTO financialDetailDTO = new FinancialDetailDTO();
            financialDetailDTO.setId(id);
            financialDetailServiceRequest.setFinancialDetailDTO(financialDetailDTO);
            financialDetailService.deleteFinancialDetail(financialDetailServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createFinancialDetail", method = RequestMethod.POST)
    @ResponseBody
    public FinancialDetailClientModel createFinancialDetail(@Valid @RequestBody FinancialDetailClientModel financialDetailClientModel) {
        return this.constructClientModel(financialDetailService.createFinancialDetail(this.constructServiceRequest(financialDetailClientModel)));
    }

    @RequestMapping(value = "updateFinancialDetail", method = RequestMethod.POST)
    @ResponseBody
    public FinancialDetailClientModel updateFinancialDetail(@Valid @RequestBody FinancialDetailClientModel financialDetailClientModel) {
        return this.constructClientModel(financialDetailService.updateFinancialDetail(this.constructServiceRequest(financialDetailClientModel)));
    }

    @RequestMapping(value = "getFinancialDetail", method = RequestMethod.POST)
    @ResponseBody
    public FinancialDetailClientModel getFinancialDetail(@RequestBody FinancialDetailClientModel financialDetailClientModel) {
        return this.constructClientModel(financialDetailService.getFinancialDetails(this.constructServiceRequest(financialDetailClientModel)));
    }

    private FinancialDetailClientModel constructClientModel(FinancialDetailServiceResponse financialDetailServiceResponse) {
        FinancialDetailClientModel financialDetailClientModel = null;
        if (financialDetailServiceResponse != null) {
            financialDetailClientModel = new FinancialDetailClientModel();
            financialDetailClientModel.setFinancialDetailDTOList(financialDetailServiceResponse.getFinancialDetailDTOList());
            financialDetailClientModel.setTotalRecords(financialDetailServiceResponse.getTotalRecords());
        }
        return financialDetailClientModel;
    }

    private FinancialDetailServiceRequest constructServiceRequest(FinancialDetailClientModel financialDetailClientModel) {
        FinancialDetailServiceRequest financialDetailServiceRequest = new FinancialDetailServiceRequest();
        financialDetailServiceRequest.setFinancialDetailDTO(financialDetailClientModel.getFinancialDetailDTO());
        financialDetailServiceRequest.setFinancialDetailSearchDTO(financialDetailClientModel.getFinancialDetailSearchDTO());
        financialDetailServiceRequest.setRecordstoFetch(financialDetailClientModel.getRecordstoFetch());
        financialDetailServiceRequest.setPageIndex(financialDetailClientModel.getPageIndex());
        return financialDetailServiceRequest;
    }
}