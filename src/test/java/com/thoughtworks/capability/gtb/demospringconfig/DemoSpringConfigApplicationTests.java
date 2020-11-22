package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;
@SpringBootTest
@AutoConfigureMockMvc
class DemoSpringConfigApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void should_return_advanced_given_levelNumber_is_1() throws Exception {
		mockMvc.perform(get("/level"))
				.andExpect(jsonPath("$", is("advanced")))
				.andExpect(status().isOk());
	}

	@SpringBootTest(properties = {"levelNumber=2"})
	@AutoConfigureMockMvc
	@Nested
	class LevelNumber2{
		@Autowired
		MockMvc mockMvc;

		@Test
		void should_return_advanced_given_levelNumber_is_2() throws Exception {
			mockMvc.perform(get("/level"))
					.andExpect(jsonPath("$", is("advanced")))
					.andExpect(status().isOk());
		}
	}

	@SpringBootTest(properties = {"levelNumber=0"})
	@AutoConfigureMockMvc
	@Nested
	class LevelNumber0{
		@Autowired
		MockMvc mockMvc;

		@Test
		void should_return_advanced_given_levelNumber_is_0() throws Exception {
			mockMvc.perform(get("/level"))
					.andExpect(jsonPath("$", is("basic")))
					.andExpect(status().isOk());
		}
	}

}
