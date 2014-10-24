package com.zli.todo.resolver;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;

public class JsonViewResolver implements ViewResolver {

   @Override
   public View resolveViewName(String viewName, Locale locale) throws Exception {
      MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
      jsonView.setUpdateContentLength(true);

      return jsonView;
   }

}
