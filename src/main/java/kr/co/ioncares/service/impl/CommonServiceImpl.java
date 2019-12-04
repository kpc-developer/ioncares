package kr.co.ioncares.service.impl;

import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.ioncares.service.CommonService;



@Service
public class CommonServiceImpl implements CommonService {
	protected static final String REQUEST_KEY_XFF = "X-Forwarded-For";
	protected static final String REQUEST_KEY_USER_AGENT = "User-Agent";

	@Autowired
	private ObjectMapper mapper;
	
	
	@Override
	public String toJSON(final Object data)
	{
		try 
		{
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		} 
		catch (JsonProcessingException ex) 
		{
			
			return data.toString();
		}
	}

	
	@Override
	public <T> T fromJSON(final String jsonText, Class<T> type)
	{
		try 
		{
			return mapper.readValue(jsonText, type);
		} 
		catch (IOException ex) 
		{
			
			return null;
		}
	}
	
}
