package com.gym.code.common;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("common")
public class CommonDispatch {

	@RequestMapping("{path}/{view}")
   public String dispatch(@PathVariable String path, @PathVariable String view) {
      return path + "/" + view;
   }
	
}
