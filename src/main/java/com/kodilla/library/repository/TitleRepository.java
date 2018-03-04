package com.kodilla.library.repository;

        import com.kodilla.library.domain.Reader;
        import com.kodilla.library.domain.Title;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;
        import javax.transaction.Transactional;
        import java.util.List;

@Repository
@Transactional
public interface TitleRepository extends CrudRepository<Title,Integer> {

    @Override
    Title save(Title title);

    @Override
    List<Title> findAll();


}