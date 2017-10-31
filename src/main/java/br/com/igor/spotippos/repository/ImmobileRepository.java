package br.com.igor.spotippos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igor.spotippos.model.Immobile;

public interface ImmobileRepository extends JpaRepository<Immobile, Long> {

}
