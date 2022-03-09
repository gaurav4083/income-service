package com.nhs.springboot.incomeservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhs.springboot.incomeservice.IncomeServiceApplication;
import com.nhs.springboot.incomeservice.constant.Frequency;
import com.nhs.springboot.incomeservice.model.RegularAmount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= WebEnvironment.MOCK, classes={ IncomeServiceApplication.class })
public class IncomeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void should_give_200_nonNumericAmount_validFrequencyTest() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.WEEK);
        regularAmount.setAmount("non-numeric");

        String request = objectMapper.writeValueAsString(regularAmount);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/income")
            .contentType(MediaType.APPLICATION_JSON).content(request))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void should_give_200_NullFrequencyTest() throws Exception {
        // given
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(null);
        regularAmount.setAmount("100.20");

        String request = objectMapper.writeValueAsString(regularAmount);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/income")
            .contentType(MediaType.APPLICATION_JSON).content(request))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void should_give_200_WeekTest() throws Exception {
        // given
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.WEEK);
        regularAmount.setAmount("100.20");

        String request = objectMapper.writeValueAsString(regularAmount);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/income")
            .contentType(MediaType.APPLICATION_JSON).content(request))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void should_give_200_MonthTest() throws Exception {
        // given
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.MONTH);
        regularAmount.setAmount("100.20");

        String request = objectMapper.writeValueAsString(regularAmount);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/income")
            .contentType(MediaType.APPLICATION_JSON).content(request))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void should_give_400_TwoWeekTest() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.TWO_WEEK);
        regularAmount.setAmount("100.20");

        String request = objectMapper.writeValueAsString(regularAmount);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/income")
            .contentType(MediaType.APPLICATION_JSON).content(request))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void should_give_400_FourWeekTest() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.FOUR_WEEK);
        regularAmount.setAmount("100.20");

        String request = objectMapper.writeValueAsString(regularAmount);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/income")
            .contentType(MediaType.APPLICATION_JSON).content(request))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void should_give_400_QuarterTest() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.QUARTER);
        regularAmount.setAmount("100.20");

        String request = objectMapper.writeValueAsString(regularAmount);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/income")
            .contentType(MediaType.APPLICATION_JSON).content(request))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void should_give_400_YearTest() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.YEAR);
        regularAmount.setAmount("100.20");

        String request = objectMapper.writeValueAsString(regularAmount);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/income")
            .contentType(MediaType.APPLICATION_JSON).content(request))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    @Test
    public void should_give_200_YearTest() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.YEAR);
        regularAmount.setAmount("104.00");

        String request = objectMapper.writeValueAsString(regularAmount);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/income")
            .contentType(MediaType.APPLICATION_JSON).content(request))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void should_give_200_TwoWeekTest() throws Exception {
        // given
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.TWO_WEEK);
        regularAmount.setAmount("100.00");

        String request = objectMapper.writeValueAsString(regularAmount);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/income")
            .contentType(MediaType.APPLICATION_JSON).content(request))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }



}
