package com.hiberus.bill.service;

import com.hiberus.bill.model.BillResponse;
import com.hiberus.bill.model.BillRequest;

public interface BillService {

    BillResponse billProducts(BillRequest billRequest);
}
