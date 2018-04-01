package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Appuntamento;
import it.contrader.automative.repositories.AppuntamentoRepository;
import it.contrader.automative.serviceInterfaces.IAppuntamento;

@Service
public class AppuntamentoImpl implements IAppuntamento{

	private AppuntamentoRepository appuntamentoRepository;
	
    @Autowired
    public AppuntamentoImpl(AppuntamentoRepository appuntamentoRepository) {
        this.appuntamentoRepository = appuntamentoRepository;
    }

	public Appuntamento insert(Appuntamento appuntamento) {
		Appuntamento a = appuntamentoRepository.findById(appuntamento.getId());
        if(a == null){
            return appuntamentoRepository.save(appuntamento);
        }
        else
            return a;
	}
	
}
