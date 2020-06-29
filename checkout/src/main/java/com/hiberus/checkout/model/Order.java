package com.hiberus.checkout.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Date is required.")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

	@NotNull(message = "Direction is required.")
	private String direction;

	@OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="op_fk", referencedColumnName = "id")
	private List<Product> products;
}
