package com.kodilla.library.repository;

import com.kodilla.library.domain.Reader;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReaderRepository extends CrudRepository <Reader,Integer> {

    Reader findById(int id);
    @Override
    Reader save(Reader reader);

}
