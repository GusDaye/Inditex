package dev.demo.electronic_commerce.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource({
            "14, 10",
            "14, 16",
            "14, 21",
            "15, 10",
            "16, 21",
    })
    void testPriceEndpoint(int dayOfMonth, int hour) throws Exception {
        // Mocking data
        LocalDateTime testDateTime = LocalDateTime.of(2020, 6, dayOfMonth, hour, 0, 0);
        long testProductId = 35455L;
        long testBrandId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                        .param("date", testDateTime.toString())
                        .param("productId", Long.toString(testProductId))
                        .param("brandId", Long.toString(testBrandId)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
