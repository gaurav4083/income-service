package com.nhs.springboot.incomeservice.controller;

import com.nhs.springboot.incomeservice.model.RegularAmount;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller
 */
@RestController
@RequestMapping("/api/v1/income")
public class IncomeController {

    private List<RegularAmount> incomeLst = new ArrayList<>();

    @GetMapping()
    public List<RegularAmount> getAllIncomeDetails() {
        return this.incomeLst;
    }

    @PostMapping
    public String addIncomeDetails(@Valid @RequestBody RegularAmount regularAmount) {
        incomeLst.add(regularAmount);
        return "Success";
    }

}
