package br.com.mv.service;

import br.com.mv.domain.Category;
import br.com.mv.domain.Movie;
import br.com.mv.repository.CategoryRepository;
import br.com.mv.repository.MovieRepository;
import br.com.mv.service.inteface.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category create(Category category) {
		category.setCreatedAt(LocalDateTime.now());
		category.setUpdatedAt(LocalDateTime.now());

		Category newCategory = this.categoryRepository.save(category);
		return newCategory;
	}

	@Override
	public Category updateById (Long id, Category category) {
		Category updatedCategory = this.getById(id);
		this.updateData(updatedCategory, category);
		return this.categoryRepository.save(updatedCategory);
	}

	@Override
	public Category getById(Long id) {
		Optional<Category> category = this.categoryRepository.findById(id);
		return category.orElseThrow(() -> new Error("object not found"));
	}

	@Override
	public List<Category> getAll() {
		return this.categoryRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.getById(id);
		this.categoryRepository.deleteById(id);
	}

	private void updateData(Category updateCategory, Category category) {
		updateCategory.setName(category.getName());
		updateCategory.setDescription(category.getDescription());
		updateCategory.setUpdatedAt(LocalDateTime.now());
	}
}
