package com.br.desafio;

import com.br.desafio.config.Config;
import com.br.desafio.entity.Bootcamp;
import com.br.desafio.entity.Curso;
import com.br.desafio.entity.Dev;
import com.br.desafio.entity.Mentoria;
import com.br.desafio.resource.BootcampResource;
import com.br.desafio.resource.CursoResource;
import com.br.desafio.resource.DevResource;
import com.br.desafio.resource.MentoriaResource;
import com.br.desafio.respository.generic.CrudRepositoryImpFake;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Main {
    private Config config;
    @BeforeAll
    public void setup() {
        config = Config.init()
                .configBootcamp()
                .configCurso()
                .configDev()
                .configMentoria()
                .build();
    }

    @BeforeEach
    public void resetBanco() {
        CrudRepositoryImpFake.close();
    }
    @Test
    @DisplayName("Test CRUD Bootcamp")
    public void testCrudBootcamp() {
        BootcampResource bootcampResource = config.getBootcampResource();
        Bootcamp bootcamp1 = bootcampResource.create("Bootcamp 1", "Description 1");
        Bootcamp bootcamp2 = bootcampResource.create("Bootcamp 2", "Description 2");
        Bootcamp bootcamp3 = bootcampResource.create("Bootcamp 3", "Description 3");
        Bootcamp bootcamp4 = bootcampResource.create("Bootcamp 4", "Description 4");
        Bootcamp update = bootcamp2;
        update.setNome("Update");

        List<Bootcamp> all = bootcampResource.findAll();
        assertThat(all, Matchers.hasSize(4));

        Bootcamp byId = bootcampResource.findById(bootcamp1.getID());
        assertThat(byId.getNome(), Matchers.is(bootcamp1.getNome()));

        bootcampResource.update(bootcamp2.getID(), update);
        Bootcamp updated = bootcampResource.findById(bootcamp2.getID());
        assertThat(updated.getNome(), Matchers.is(update.getNome()));

        bootcampResource.delete(update.getID());
        List<Bootcamp> all2 = bootcampResource.findAll();
        assertThat(all2, Matchers.hasSize(3));
    }
    @Test
    @DisplayName("Test CRUD Curso")
    public void testCrudCurso() {
        CursoResource cursoResource = config.getCursoResource();
        Curso curso1 = cursoResource.create("Curso 1", "Description 1", 100);
        Curso curso2 = cursoResource.create("Curso 2", "Description 2", 100);
        Curso curso3 = cursoResource.create("Curso 3", "Description 3", 100);
        Curso curso4 = cursoResource.create("Curso 4", "Description 4", 100);
        List<Curso> all = cursoResource.findAll();
        assertThat(all,Matchers.hasSize(4));

        Curso byId = cursoResource.findById(curso1.getID());
        assertThat(byId.getTitulo(), Matchers.is(curso1.getTitulo()));

        Curso update = curso2;
        update.setTitulo("Update");
        Curso updated = cursoResource.update(curso2.getID(), update);
        assertThat(updated.getTitulo(), Matchers.is(update.getTitulo()));
        cursoResource.delete(curso4.getID());
        List<Curso> all2 = cursoResource.findAll();

        assertThat(all2,Matchers.hasSize(3));
    }
    @Test
    @DisplayName("Test CRUD Dev")
    public void testCrudDev() {
        DevResource devResource = config.getDevResource();
        Dev dev1 = devResource.create("Name 1");
        Dev dev2 = devResource.create("Name 2");
        Dev dev3 = devResource.create("Name 3");
        List<Dev> all = devResource.findAll();
        assertThat(all, Matchers.hasSize(3));

        Dev byId = devResource.findById(dev1.getID());
        assertThat(byId.getNome(), Matchers.is(dev1.getNome()));

        Dev update = dev2;
        update.setNome("Update");
        Dev updated = devResource.update(dev2.getID(), update);
        assertThat(updated.getNome(), Matchers.is(update.getNome()));

        devResource.delete(dev2.getID());
        List<Dev> all2 = devResource.findAll();
        assertThat(all2, Matchers.hasSize(2));
    }
    @Test
    @DisplayName("Test CRUD Mentoria")
    public void testCrudMentoria() {
        MentoriaResource mentoriaResource = config.getMentoriaResource();
        Mentoria mentoria1 = mentoriaResource.create("Title 1", "Description 1", LocalDate.now().plusMonths(1));
        Mentoria mentoria2 = mentoriaResource.create("Title 2", "Description 2", LocalDate.now().plusMonths(2));
        Mentoria mentoria3 = mentoriaResource.create("Title 3", "Description 3", LocalDate.now().plusMonths(3));
        List<Mentoria> all = mentoriaResource.findAll();
        assertThat(all,Matchers.hasSize(3));

        Mentoria byId = mentoriaResource.findById(mentoria1.getID());
        assertThat(byId.getTitulo(), Matchers.is(mentoria1.getTitulo()));

        Mentoria update = mentoria2;
        update.setTitulo("Update");
        Mentoria updated = mentoriaResource.update(mentoria2.getID(), update);
        assertThat(updated.getTitulo(), Matchers.is(update.getTitulo()));

        mentoriaResource.delete(mentoria2.getID());
        List<Mentoria> all1 = mentoriaResource.findAll();
        assertThat(all1, Matchers.hasSize(2));
    }

    @Test
    @DisplayName("Inscrever dev no bootcamp")
    public void testAddInscritoBootcamp() {
        BootcampResource bootcampResource = config.getBootcampResource();
        DevResource devResource = config.getDevResource();
        Bootcamp bootcamp1 = bootcampResource.create("Bootcamp 1", "Description 1");

        Dev dev1 = devResource.create("Dev 1");

        bootcampResource.addInscrito(bootcamp1.getID(),dev1);
        Bootcamp byId = bootcampResource.findById(bootcamp1.getID());

        assertThat(byId.getDevsInscritos(), Matchers.hasSize(1));
        assertThat(byId.getDevsInscritos(), Matchers.contains(dev1));
    }

    @Test
    @DisplayName("adicionar conteudo Bootcamp")
    public void testAddConteudoBootcamp(){
        BootcampResource bootcampResource = config.getBootcampResource();
        CursoResource cursoResource = config.getCursoResource();
        MentoriaResource mentoriaResource = config.getMentoriaResource();

        Bootcamp bootcamp1 = bootcampResource.create("Bootcamp 1", "Description 1");
        Mentoria mentoria1 = mentoriaResource.create("Title 1", "Description 1", LocalDate.now().plusMonths(1));
        Curso curso1 = cursoResource.create("Curso 1", "Description 1", 100);

        bootcampResource.addConteudo(bootcamp1.getID(), curso1);
        bootcampResource.addConteudo(bootcamp1.getID(), mentoria1);
        Bootcamp byId = bootcampResource.findById(bootcamp1.getID());
        assertThat(byId.getConteudos(),Matchers.hasSize(2));
    }

    @Test
    @DisplayName("adicionar conteudo inscrito dev")
    public void testAddConteudoDev() {
        DevResource devResource = config.getDevResource();
        CursoResource cursoResource = config.getCursoResource();
        Dev dev1 = devResource.create("Dev 1");
        Curso curso1 = cursoResource.create("Curso 1", "Description 1", 100);

        devResource.addConteudoInscrito(dev1.getID(),curso1);

        Dev byId = devResource.findById(dev1.getID());
        assertThat(byId.getConteudosInscritos(), Matchers.hasSize(1));
        assertThat(byId.getConteudosInscritos(), Matchers.contains(curso1));
    }

    @Test
    @DisplayName("adicionar conteudo concluido inscrito dev")
    public void testAddConteudoConcluidoDev() {
        DevResource devResource = config.getDevResource();
        CursoResource cursoResource = config.getCursoResource();
        Dev dev1 = devResource.create("Dev 1");
        Curso curso1 = cursoResource.create("Curso 1", "Description 1", 100);

        devResource.addConteudoInscrito(dev1.getID(),curso1);
        devResource.addConteudoConcluido(dev1.getID(),curso1);
        Dev byId = devResource.findById(dev1.getID());
        assertThat(byId.getConteudosConcluidos(), Matchers.hasSize(1));
        assertThat(byId.getConteudosConcluidos(), Matchers.contains(curso1));
    }
}
