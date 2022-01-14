package com.br.desafio.config;

import com.br.desafio.resource.BootcampResource;
import com.br.desafio.resource.CursoResource;
import com.br.desafio.resource.DevResource;
import com.br.desafio.resource.MentoriaResource;
import com.br.desafio.respository.BootcampRepository;
import com.br.desafio.respository.CursoRepository;
import com.br.desafio.respository.DevRepository;
import com.br.desafio.respository.MentoriaRepository;
import com.br.desafio.respository.implementation.BootcampRepositoryImp;
import com.br.desafio.respository.implementation.CursoRepositoryImp;
import com.br.desafio.respository.implementation.DevRepositoryImp;
import com.br.desafio.respository.implementation.MentoriaRepositoryImp;
import com.br.desafio.service.BootcampService;
import com.br.desafio.service.CursoService;
import com.br.desafio.service.DevService;
import com.br.desafio.service.MentoriaService;
import com.br.desafio.service.implementation.BootcampServiceImp;
import com.br.desafio.service.implementation.CursoServiceImp;
import com.br.desafio.service.implementation.DevServiceImp;
import com.br.desafio.service.implementation.MentoriaServiceImp;
import lombok.Getter;

@Getter
public class Config{
    private BootcampResource bootcampResource;
    private CursoResource cursoResource;
    private DevResource devResource;
    private MentoriaResource mentoriaResource;
    public Config configBootcamp() {
        BootcampRepository repository = new BootcampRepositoryImp();
        BootcampService service = new BootcampServiceImp(repository);
        BootcampResource resource = new BootcampResource(service);
        this.bootcampResource = resource;
        return this;
    }
    public Config configCurso() {
        CursoRepository repository = new CursoRepositoryImp();
        CursoService service = new CursoServiceImp(repository);
        CursoResource resource = new CursoResource(service);
        this.cursoResource = resource;
        return this;
    }
    public Config configDev() {
        DevRepository repository = new DevRepositoryImp();
        DevService service = new DevServiceImp(repository);
        DevResource resource = new DevResource(service);
        this.devResource = resource;
        return this;
    }
    public Config configMentoria() {
        MentoriaRepository repository = new MentoriaRepositoryImp();
        MentoriaService service = new MentoriaServiceImp(repository);
        MentoriaResource resource = new MentoriaResource(service);
        this.mentoriaResource = resource;
        return this;
    }
        private Config(){}
        
        public static Config init() {
            return new Config();
        }
        
        public Config build(){
            return this;
        }
    }