package com.hiberus.bill.resource;

import com.hiberus.bill.model.BillResponse;
import com.hiberus.bill.model.BillRequest;
import com.hiberus.bill.service.BillService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BillResource {

    BillService billService;

    @ApiOperation(value = "Bill sum of all products to user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Products successfully billed"),
            @ApiResponse(code = 400, message = "Products couldn't be billed")
    })
    @PostMapping("/bill")
    public ResponseEntity<BillResponse> billProducts(
            @Valid @RequestBody final BillRequest billRequest) {
        return ResponseEntity.ok(billService.billProducts(billRequest));
    }
}
