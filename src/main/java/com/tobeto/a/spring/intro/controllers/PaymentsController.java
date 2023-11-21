package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Payment;
import com.tobeto.a.spring.intro.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payments")
public class PaymentsController {

    private final PaymentRepository paymentRepository;

    public PaymentsController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    @GetMapping
    public List<Payment> getAll(){
        List<Payment> payments = paymentRepository.findAll();
        return payments;
    }

    @GetMapping("{id}")
    public Payment getById(@PathVariable int id){
        return paymentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Payment payment){
        paymentRepository.save(payment);
    }

    @DeleteMapping
    public void delete(@PathVariable int id){
        Payment paymentToDelete = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody Payment payment){
        Payment paymentToUpdate = paymentRepository.findById(id).orElseThrow();
        paymentToUpdate.setAmount(payment.getAmount());
        paymentToUpdate.setDiscount(payment.getDiscount());
        paymentRepository.save(paymentToUpdate);

    }
}

