package com.AlfonsoMarquez.PruebaTecnica4.repository;

import com.AlfonsoMarquez.PruebaTecnica4.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person,Long> {

}
