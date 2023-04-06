package com.boggingApp.controllerTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {
	

}


//@WebMvcTest(value = BookRestController.class)
//public class BookRestControler {
//@MockBean
//private BookService bookService;
//@Autowired
//private MockMvc mockMvc;
//
//@Test
//public void testAddBook() throws Exception {
//when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(true);
//
//Book book = new Book(101, "spring", 450.00);
//ObjectMapper mapper = new ObjectMapper();
//String bookJson = mapper.writeValueAsString(book);
//
//MockHttpServletRequestBuilder reqBuilder = MockRequestBuilders.post("/addbook")
//  .contentType(MediaType.APPLICATION_JSON)
//  .content(bookJson);
//
//ResultAction perform = mockMvc.perform(requestBuilder);
//McvResult andReturn = perform.andReturn();
//MockHttpServletResponse response = andReturn.getResponse();
//int status = response.getStatus();
