package hello;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import com.urosht.demo.controller.OddsOrEvensController;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public class BaseClass {

    @Autowired
    private OddsOrEvensController testClass;
 
    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder 
          = MockMvcBuilders.standaloneSetup(testClass);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
        // test behaviour
		Mockito.when(testClass.isNumberPrime(4)).thenReturn("Even");
		Mockito.when(testClass.isNumberPrime(5)).thenReturn("Odd");
    }
}
