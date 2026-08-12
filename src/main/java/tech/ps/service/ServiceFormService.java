package tech.ps.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tech.ps.Model.ServiceForm;

public interface ServiceFormService {

	public ServiceForm addService(ServiceForm servicForm, MultipartFile multipartFile) throws Exception;
	
	public List<ServiceForm> readAllServices();
}
