package com.tech;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.knowledgeBase.KnowledgeBaseService;
import com.tech.knowledgeBase.models.Rule;
import com.tech.restAPI.RuleNamespace;
import com.tech.rulesImpl.insuranceRuleEngine.InsuranceDetails;
import com.tech.rulesImpl.insuranceRuleEngine.PolicyHolderDetails;
import com.tech.rulesImpl.loanRuleEngine.LoanDetails;
import com.tech.rulesImpl.loanRuleEngine.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import lombok.Builder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RuleEngineTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private KnowledgeBaseService knowledgeBaseServiceMock;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        this.objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        when(knowledgeBaseServiceMock.getAllRuleByNamespace(Mockito.any())).thenReturn(getListOfRules());
    }

    @Test
    public void verifyGetAllRules() throws Exception {
        mockMvc.perform(get("/get-all-rules")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()
        );
    }

    @Test
    public void verifyPostCarLoanRuleOne() throws Exception {
    	 UserDetails userDetails = new UserDetails("Mark","L", 25,(long) 1234567,50000.0,
    			"sbi", 600, 1000000.0);
       

        MvcResult mvcResult = mockMvc.perform(post("/loan")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userDetails)))
                .andExpect(status().isOk()
                ).andReturn();

        String actualResponseBody = mvcResult.getResponse().getContentAsString();

        LoanDetails loanDetails = new LoanDetails((long) 1234567,true,(float) 9.0,(float) 90, 2000.0);
        		
        String expectedResponseBody = objectMapper.writeValueAsString(loanDetails);

        assertThat(expectedResponseBody).isEqualToIgnoringWhitespace(actualResponseBody);
    }

  

	@Test
    public void verifyPostCarLoanRuleTwo() throws Exception {
		 UserDetails userDetails = new UserDetails("john","L", 25,(long) 12345637,70000.0,
	    			"sbi", 400, 1000000.0);

        MvcResult mvcResult = mockMvc.perform(post("/loan")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userDetails)))
                .andExpect(status().isOk()
                ).andReturn();

        String actualResponseBody = mvcResult.getResponse().getContentAsString();

        LoanDetails loanDetails = new LoanDetails((long) 12345637,true,(float) 9.0,(float) 90, 2000.0);
        String expectedResponseBody = objectMapper.writeValueAsString(loanDetails);

        assertThat(expectedResponseBody).isEqualToIgnoringWhitespace(actualResponseBody);
    }

    private List<Rule> getListOfRules(){
        Rule rule1 = new Rule(RuleNamespace.LOAN,"1","input.monthlySalary >= 50000.0 && input.cibilScore >= 500 && input.requestedLoanAmount<1500000 && $(bank.target_done) == false",
                "output.setApprovalStatus(true); output.setInterestRate($(bank.interest)); output.setSanctionedPercentage(90);output.setProcessingFees(2000);output.setAccountNumber(input.accountNumber);",
                1,
                "A person is eligible for loan?");
        Rule rule2 = new Rule(RuleNamespace.LOAN,"2","(input.monthlySalary < 50000.0 && input.cibilScore <= 300 && input.requestedLoanAmount >= 1000000) || $(bank.target_done) == true",
        		"output.setApprovalStatus(false); output.setInterestRate(0.0); output.setSanctionedPercentage(0.0);output.setProcessingFees(0);output.setAccountNumber(input.accountNumber);",
                2,
                "A person is eligible for car loan?");
        
        Rule rule3 = new Rule(RuleNamespace.LOAN,"3","input.monthlySalary >= 20000.0 && input.cibilScore >= 300 && input.cibilScore < 500 && input.requestedLoanAmount <= 1000000 && $(bank.target_done) == false",
        		"output.setApprovalStatus(true); output.setInterestRate($(bank.interest)); output.setSanctionedPercentage(70);output.setProcessingFees(1000);output.setAccountNumber(input.accountNumber);",
                2,
                "A person is eligible for car loan?");
     

        List<Rule> allRulesByNamespace = Lists.newArrayList(rule1, rule2, rule3);
        return allRulesByNamespace;
    }
}
