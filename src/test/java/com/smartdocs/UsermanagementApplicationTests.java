package com.smartdocs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class UsermanagementApplicationTests {

	@Test
	void  shouldExecuteApplicationWithoutException(){
		assertDoesNotThrow(()-> UsermanagementApplication.main(new String[]{}) );
	}

}
