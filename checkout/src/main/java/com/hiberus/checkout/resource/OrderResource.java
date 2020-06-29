package com.hiberus.checkout.resource;

import com.hiberus.checkout.model.Order;
import com.hiberus.checkout.response.OrderResponse;
import com.hiberus.checkout.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import static com.hiberus.checkout.constants.ApiConstants.MESSAGE_FOR_REGEX_NUMBER_MISMATCH;
import static com.hiberus.checkout.constants.ApiConstants.REGEX_FOR_NUMBERS;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderResource {

	OrderService orderService;

	@ApiOperation(value = "Perform checkout operation")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Checkout successfully performed"),
			@ApiResponse(code = 400, message = "Checkout couldn't be performed")
	})
	@PostMapping(value = "/orders")
	public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody final Order order) {
		return ResponseEntity.ok( orderService.createOrder(order));
	}

	@ApiOperation(value = "Retrieve order by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Order successfully retrieved"),
			@ApiResponse(code = 400, message = "Order couldn't be retrieved")
	})
	@GetMapping(value = "/orders/{orderId}")
	public ResponseEntity<Order> getOrderById(
			@Valid @Pattern(regexp = REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH)
			@PathVariable Long orderId) throws NotFound {
		return ResponseEntity.ok(orderService.getById(orderId));
	}
}
