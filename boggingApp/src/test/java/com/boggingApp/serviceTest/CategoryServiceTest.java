package com.boggingApp.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.boggingApp.Controller.CategoryController;
import com.boggingApp.Services.CategoryService;

@WebMvcTest(value = CategoryController.class)
public class CategoryServiceTest {
	@MockBean
	private CategoryService categoryService;
//	@Autowired
//	private MockMvc mockMvc;
@Test
public void getAllCategoryTest(){
	//wOhen(categoryService.getAllCategory()).thenReturn
	
    
}

}
