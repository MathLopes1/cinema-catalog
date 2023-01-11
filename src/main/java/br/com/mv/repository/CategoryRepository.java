package br.com.mv.repository;

import br.com.mv.domain.Category;
import br.com.mv.enums.NameCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(NameCategory name);
}
