package br.com.mv.controller;

import br.com.mv.domain.Category;
import br.com.mv.dto.category.CategoryDTO;
import br.com.mv.service.inteface.ICategoryService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private ModelMapper modelMapper;

	private CategoryDTO toCategoryDTO (Category category) {
		return this.modelMapper.map(category, CategoryDTO.class);
	}

	@PostMapping
	public ResponseEntity<CategoryDTO> create(@RequestBody @Valid CategoryDTO categoryDTO) {
		Category newCategory = this.modelMapper.map(categoryDTO, Category.class);
		newCategory = this.categoryService.create(newCategory);

		return new ResponseEntity<CategoryDTO>(toCategoryDTO(newCategory), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryDTO> updateById(@RequestBody CategoryDTO categoryDTO, @PathVariable(value = "id") Long id) {
		Category updatedCategory = this.modelMapper.map(categoryDTO, Category.class);
		updatedCategory = this.categoryService.updateById(id,updatedCategory);

		return new ResponseEntity<CategoryDTO>(toCategoryDTO(updatedCategory),HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Page<CategoryDTO>> getAll(@PageableDefault(sort = "id") Pageable pagination) {
		Page<Category> list = this.categoryService.getAll(pagination);

		Page<CategoryDTO> listDto = list.map(x -> toCategoryDTO(x));

		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> getById(@PathVariable Long id) {
		Category category = this.categoryService.getById(id);

		return new ResponseEntity<CategoryDTO>(toCategoryDTO(category), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		this.categoryService.deleteById(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
