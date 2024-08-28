package com.shoda.rest.webservices.restful_web_servies.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {

	//o Add Dynamic Filtering so that only some method can filter few values 
	//We need to Use "MappingJacksonValue" and provide FilterProvider to it
	// and Create SimpleBeanPropertyFilter and using it create "FilterProvider"
	// NOTE: On Pojo class "NewBean" add @JsonFilter("filterName") used above 
	
	
	@GetMapping("/dynamicfiltering")
	public MappingJacksonValue getNewBean()
	{
		NewBean newBean = new NewBean("val1","val2","val3");
		//Mapping our New Bean to MappingJacksonValue
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(newBean);
		//Create a filter to add ou r filter condition
		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3"); // Allowing only field1 and field3
		// Adding it to create A filter Provider
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("NewBeanFilter", filter);  
		// THis name "NewBeanFilter" should be defined on pojo class as @JsonFilter("NewBeanFilter")
		
		// FInally setting filter on MappingJacksonValue
		mappingJacksonValue.setFilters(filterProvider);
		
		return mappingJacksonValue;
	}
	
	
	@GetMapping("/dynamicfiltering-list")  // Allow Field1 & Field2 only and Block Field3
	public MappingJacksonValue getNewBeanList()
	{
		List<NewBean> asList = Arrays.asList( new NewBean("val1","val2","val3"), new NewBean("val1","val2","val3"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(asList);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("NewBeanFilter", filter);
		mappingJacksonValue.setFilters(filterProvider);
		
		return   mappingJacksonValue ;
	}
	
}

