package com.hiberus.logistic.resource;

import com.hiberus.logistic.model.LogisticRequest;
import com.hiberus.logistic.model.LogisticResponse;
import com.hiberus.logistic.service.LogisticService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LogisticResource {

    LogisticService logisticService;

    @ApiOperation(value = "Create a sent order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Order successfully created"),
            @ApiResponse(code = 400, message = "Order couldn't be created")
    })
    @PostMapping("/logistic")
    public ResponseEntity<LogisticResponse> createSentOrder(
            @Valid @RequestBody final LogisticRequest logisticRequest) {
        return ResponseEntity.ok(logisticService.createSentOrder(logisticRequest));
    }
}
