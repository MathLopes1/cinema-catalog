package br.com.mv.service.inteface;

import br.com.mv.domain.Category;

import java.util.List;

public interface ICategoryService {
    public Category create (Category category);
    public Category updateById (Long id, Category category);
    public Category getById (Long id);
    public List<Category> getAll ();
    public void deleteById(Long id);
}
