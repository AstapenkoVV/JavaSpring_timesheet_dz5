package ru.gb.timesheet.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;

@NoRepositoryBean
public interface ReadOnlyRepository <T, ID> extends Repository<T, ID> {
    List<T> findAll();

    List<T> findAllById(Iterable<ID> ids);

}
