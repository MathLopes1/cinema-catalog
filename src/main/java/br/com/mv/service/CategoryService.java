package br.com.mv.service;

import br.com.mv.domain.Category;
import br.com.mv.exceptions.BadRequestException;
import br.com.mv.exceptions.NotFoundException;
import br.com.mv.repository.CategoryRepository;
import br.com.mv.service.inteface.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category create(Category category) {
		this.validationForCategoryCreation(category);

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

		return category.orElseThrow(() -> new NotFoundException("Categoria não existe!"));
	}

	@Override
	public Page<Category> getAll(Pageable pagination) {
		return this.categoryRepository.findAll(pagination);
	}

	@Override
	public void deleteById(Long id) {
		this.getById(id);
		this.categoryRepository.deleteById(id);
	}

	private void updateData(Category updateCategory, Category category) {
		if(category.getName() != null) {
			updateCategory.setName(category.getName());
		}

		if(category.getDescription() != null) {
			updateCategory.setDescription(category.getDescription());
		}

		updateCategory.setUpdatedAt(LocalDateTime.now());
	}

	private void validationForCategoryCreation(Category category) {
		Optional<Category> categoryForValidation = this.categoryRepository.findByName(category.getName());

		if(categoryForValidation.isPresent()) {
			throw new BadRequestException("Categoria já cadastrado!");
		}
	}
}
