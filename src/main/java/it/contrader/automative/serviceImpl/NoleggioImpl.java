package it.contrader.automative.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Noleggio;
import it.contrader.automative.repositories.NoleggioRepository;
import it.contrader.automative.serviceInterfaces.INoleggio;

@Service
public class NoleggioImpl implements INoleggio{

	private NoleggioRepository noleggioRepository;
	
    @Autowired
    public NoleggioImpl(NoleggioRepository noleggioRepository) {
        this.noleggioRepository = noleggioRepository;
    }

	public Noleggio insert(Noleggio noleggio) {
		Noleggio a = noleggioRepository.findById(noleggio.getId());
        if(a == null){
            return noleggioRepository.save(noleggio);
        }
        else
            return a;
	}

	public List<Auto> autoNonPrenotate(List<Noleggio> noleggiOfficina, List<Auto> autoOfficina){
		List<Auto> lista = new ArrayList();
		
		for(int i = 0; i<autoOfficina.size(); i++) {
			
			boolean prenotata = false;
			
			for(int e = 0; e<noleggiOfficina.size(); e++) {
				if(autoOfficina.get(i).equals(noleggiOfficina.get(e).getAuto())) {
					if(noleggiOfficina.get(e).getDataFineNoleggio().after(new Date(System.currentTimeMillis()))) prenotata = true;
				}
			}
			
			if(!prenotata) lista.add(autoOfficina.get(i));
		}
		
		return lista;
	}
	
}
