package tech.ps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.ps.Model.ServiceForm;

@Repository
public interface ServiceFormCrud extends JpaRepository<ServiceForm, Integer>{

}
