package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;


@RunWith(SpringRunner.class)
@WebMvcTest(value=WordController.class ,secure=false)
public class MyTest {

	@Autowired
	private MockMvc mockMvc;
	
	//test using mockito ,  //
	
	@Test
	public void defaultMessage() throws Exception {
		this.mockMvc.perform(get("/words")
				.accept(MediaType.APPLICATION_JSON))
		        .andDo(print())
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.word").value("aakakk"))
		        .andExpect(jsonPath("$.palingdrome").value(false))
		        .andExpect(jsonPath("$.anagramOfPalingdrome").value(false));
		
		}
	@Test
	public void withParameter() throws Exception {
		this.mockMvc.perform(get("/words/aakaa")
				.accept(MediaType.APPLICATION_JSON))
		        .andDo(print())
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.word").value("aakaa"))
		        .andExpect(jsonPath("$.palingdrome").value(true))
		        .andExpect(jsonPath("$.anagramOfPalingdrome").value(true));
			}
	
	@Test
	public void newTest() throws Exception {
		/*Mockito.when(
				studentService.retrieveCourse(Mockito.anyString(),
						Mockito.anyString()))
		.thenReturn("",false,false);*/
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/words")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			
		System.out.println("**********"+result.getResponse().getContentAsString()+"***********");
		String expected = "{\"word\":\"aakakk\",\"palingdrome\":false,\"anagramOfPalingdrome\":false}";
		String expected1 = "{\"word\":\"aakakk\",\"palingdrome\":false}";// partial data
		
		//String expected = "{word:aakakk, palingdromeid:false, anagramOfPalingdrome:false}";
		System.out.println("**********"+expected+"***********");
				
		JSONAssert.assertEquals(expected,
				result.getResponse().getContentAsString(), false);// false means partial data can be checked
			}
	
}
