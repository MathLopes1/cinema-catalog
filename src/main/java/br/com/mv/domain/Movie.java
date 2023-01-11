package br.com.mv.domain;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_movie")
public class Movie extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Long id;

	private String title;

	private String year;

	private String duration;

	@ManyToMany
	@JoinTable(
			name = "tb_category_movies",
			joinColumns = @JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	List<Category> categories;
}
