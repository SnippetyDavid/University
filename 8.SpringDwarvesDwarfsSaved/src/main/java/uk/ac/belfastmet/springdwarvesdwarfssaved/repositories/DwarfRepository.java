package uk.ac.belfastmet.springdwarvesdwarfssaved.repositories;

import org.springframework.data.repository.CrudRepository;

import uk.ac.belfastmet.springdwarvesdwarfssaved.domain.Dwarf;

public interface DwarfRepository extends CrudRepository<Dwarf, Integer> {

	Iterable<Dwarf> findByAuthor(String string);

	Iterable<Dwarf> findByAuthorOrderByName(String string);

	Iterable<Dwarf> findTop3ByAuthor(String string);

	Iterable<Dwarf> findByName(String string);

	Iterable<Dwarf> findByDwarfId(int i);

	Iterable<Dwarf> findByOrderByNameAsc();

	Iterable<Dwarf> findByAuthorOrName(String string, String string2);

}


