package org.seckill.service;

import org.seckill.entity.Flow;

import java.util.List;
import java.util.Map;

public interface LoanAndFlowService {

    List<Flow> getAllTransactionRecord(String realPath, String companyId);

    Map getAllLoanRecord(String realPath, String companyId);

}
