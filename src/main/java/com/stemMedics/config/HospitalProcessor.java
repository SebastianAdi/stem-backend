package com.stemMedics.config;

import org.springframework.batch.item.ItemProcessor;

import com.stemMedics.entity.Hospital;
import com.stemMedics.pojo.HospitalInput;

//input(MatchInput) -> process -> output(Match)
public class HospitalProcessor implements ItemProcessor<HospitalInput, Hospital> {
	
	  @Override
	  public Hospital process(final HospitalInput hospitalInput) throws Exception {
		  Hospital hospital = new Hospital();
		  
		  hospital.setName(hospitalInput.getName());
		  hospital.setState(hospitalInput.getState());
		  hospital.setCity(hospitalInput.getCity());
		  hospital.setAddress(hospitalInput.getAddress());
		  hospital.setPincode(Integer.parseInt(hospitalInput.getPincode()));
		  
		  return hospital;
	  }

}
