package br.com.mv.service.inteface;

import br.com.mv.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    public Category create (Category category);
    public Category updateById (Long id, Category category);
    public Category getById (Long id);
    public Page<Category> getAll (Pageable pagination);
    public void deleteById(Long id);
}
