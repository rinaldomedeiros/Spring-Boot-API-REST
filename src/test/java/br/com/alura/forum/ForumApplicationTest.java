package br.com.alura.forum;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.repository.CursoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ForumApplicationTest {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloNome() {
		String nomeCurso = "HTML 5";
		Curso curso = cursoRepository.findByNome(nomeCurso);
		assertNotNull(curso);
		assertEquals(nomeCurso, curso.getNome());
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
		String nomeCurso = "JPA";
		Curso curso = cursoRepository.findByNome(nomeCurso);
		assertNull(curso);
	}

}
