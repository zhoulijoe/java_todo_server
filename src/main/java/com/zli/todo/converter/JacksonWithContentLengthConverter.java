package com.zli.todo.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;

public class JacksonWithContentLengthConverter extends MappingJackson2HttpMessageConverter {

   @Override
   protected Long getContentLength(Object object, MediaType contentType) throws IOException {
      return 100L;
   }

}
