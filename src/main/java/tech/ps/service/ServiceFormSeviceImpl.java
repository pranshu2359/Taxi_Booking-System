package tech.ps.service;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import tech.ps.Model.ServiceForm;
import tech.ps.dao.ServiceFormCrud;


@Service
public class ServiceFormSeviceImpl implements ServiceFormService {

	
	private ServiceFormCrud serviceFormCrud;
	
	@Autowired
	public void setServiceFormCrud(ServiceFormCrud serviceFormCrud) {
		this.serviceFormCrud = serviceFormCrud;
	}

    @Transactional(rollbackOn = Exception.class)
	@Override
	public ServiceForm addService(ServiceForm servicForm, MultipartFile multipartFile) throws Exception {
		ServiceForm save =null;
		try {
			save=serviceFormCrud.save(servicForm);
			
			if(save!=null) {
			
			String path="C:\\BootWork\\TaxiBooking\\src\\main\\resources\\static\\myServiceImg\\"+multipartFile.getOriginalFilename();
			byte[] bytes = multipartFile.getBytes();
			
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(bytes);
			}
		}catch(Exception e){
			save=null;
			throw e;	
		}
		
		return save;
	}

	@Override
	public List<ServiceForm> readAllServices() {
		
		return serviceFormCrud.findAll();
	}

}
