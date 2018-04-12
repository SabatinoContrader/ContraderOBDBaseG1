package it.contrader.automative.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Promozione;

@Repository
@Transactional
public interface PromozioneRepository extends CrudRepository<Promozione, Long>{

	Promozione findById(int id);
}
